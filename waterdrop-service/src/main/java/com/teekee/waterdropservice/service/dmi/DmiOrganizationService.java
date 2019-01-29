package com.teekee.waterdropservice.service.dmi;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.waterdropservice.entity.dmi.DmiOrganization;
import com.teekee.waterdropservice.entity.dmi.DmiOrganizationOfTree;
import com.teekee.waterdropservice.entity.dmi.DmiStore;
import com.teekee.waterdropservice.entity.dmi.DmiStoreBySelectByAreaSort;
import com.teekee.waterdropservice.entity.dmi.res.DmiOrganizationRes;
import com.teekee.waterdropservice.mapper.dmi.DmiOrganizationMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiStoreMapper;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.commoncomponets.utils.TreeUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description: 雇主公司组织机构
 * @author: zhangshuai
 * @create: 2018-12-15 11:48
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DmiOrganizationService extends BaseService<DmiOrganizationMapper,DmiOrganization> {

    @Autowired
    private DmiOrganizationMapper dmiOrganizationMapper;

    @Autowired
    private DmiStoreMapper dmiStoreMapper;

    @Autowired
    private Mapper dozer;

    /**
     * 新增/编辑组织结构节点信息
     * @param userId
     * @param companyId
     * @param dmiOrganization
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result handle(int userId, int companyId, DmiOrganization dmiOrganization) {

        if (dmiOrganization == null || dmiOrganization.getOrganizationName() == null || dmiOrganization.getParentId() == null) {
            return ResultUtil.validateError("参数错误");
        } else {

            if (dmiOrganization.getId() > 0) {
                // 执行更新操作
                dmiOrganization.setUpdatePerson(userId);
                dmiOrganization.setUpdateTime(new Date());

                updateOragnization(dmiOrganization);

                return ResultUtil.successMsg("更新成功");
            } else {
                // 执行新增操作
                dmiOrganization.setCreatePerson(userId);
                dmiOrganization.setCreateTime(new Date());
                dmiOrganization.setFlagAvailable(true);
                dmiOrganization.setFlagDeleted(false);

                // 如果从页面Body中没有获得CompanyId参数，需要手动设定一次CompanyId
                if (dmiOrganization.getBelongsCompanyId() == null ||
                        dmiOrganization.getBelongsCompanyId() == 0)
                    dmiOrganization.setBelongsCompanyId(companyId);

                // 获取该新增节点的父节点信息
                if (dmiOrganization.getParentId() > 0) {
                    DmiOrganization dorg = dmiOrganizationMapper.selectByPrimaryKey(dmiOrganization.getParentId());
                    dmiOrganization.setLevel(dorg.getLevel() + 1);
                    dmiOrganization.setBelongsCompanyId(dorg.getBelongsCompanyId());
                }
                // 设定排序序号
                HashMap<String, Object> hmap1 = new HashMap<String, Object>();
                hmap1.put("companyId", dmiOrganization.getBelongsCompanyId());
                hmap1.put("parentId", dmiOrganization.getParentId());
                dmiOrganization.setOrderId(dmiOrganizationMapper.selectMaxOrderByParentId(hmap1) + 1);

                // 检查营业执照是否为空，如果为空，默认设为0；
                if (dmiOrganization.getBusinessLicenseId() == null) dmiOrganization.setBusinessLicenseId(0);

                insertOragnization(dmiOrganization);

                return ResultUtil.successMsg("新增成功");
            }
        }
    }


    /**
     * 根据雇主公司的ID，获取公司所属组织结构列表
     * @param companyId
     * @return
     */
    public Result getOragnizationByCompanyId(int companyId) {
        // 从数据库中查询有序组织结构集合
        List<DmiOrganizationRes> sqlResult = dmiOrganizationMapper.selectOrganizationListByCompanyIdRes(companyId);
        List<DmiOrganizationRes> storeResult = dmiOrganizationMapper.selectOrganizationListByCompanyIdResChildren(companyId);
        sqlResult.addAll(storeResult);

        List<DmiOrganizationRes> permissionTree = TreeUtils.formatTree(sqlResult,false);
        return ResultUtil.success(permissionTree);
    }

//    @Transactional(readOnly = false,rollbackFor = Exception.class)
//    public Result getOragnizationByCompanyId(int companyId) {
//        // 从数据库中查询有序组织结构集合
//        List<DmiOrganization> sqlResult = dmiOrganizationMapper.selectOrganizationListByCompanyId(companyId);
//        // 将数据库中查询得到的有序集合重新按照等级排列
//        List<DmiOrganizationOfTree> levelTreeList = buildTreeByLevel(sqlResult);
//        List<DmiOrganizationOfTree> levelTreeListAndStore = insertStoreToOragnizationList(levelTreeList, companyId);
//        // 将排列整齐的集合构造成最终的树形结构
//        List<DmiOrganizationOfTree> result = buildResultTree(levelTreeListAndStore);
//        return ResultUtil.success(result);
//    }


    /**
     * 删除组织结构节点
     * @param dmiOrganization
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result handleDelete(DmiOrganization dmiOrganization) {

        // 判断该组织机构是否可删除
        List<DmiStore> storeList = dmiStoreMapper.selectByAreaId(dmiOrganization.getId());
        if (storeList != null && !storeList.isEmpty()) {
            return ResultUtil.errorExceptionMsg("操作失败，该组织机构节点存在相关门店，请先删除相关门店再删除该节点！");
        }

        // 设定失效
        dmiOrganization.setFlagDeleted(true);
        dmiOrganization.setUpdateTime(new Date());
        dmiOrganization.setUpdatePerson(CurrentUtil.getCurrent().getId());

        updateOragnization(dmiOrganization);

        return ResultUtil.successMsg("删除成功");
    }


    /**
     * 根据ID，查看组织结构节点详情
     * @param id
     * @return
     */
    public Result getOragnization(int id) {
        return ResultUtil.success(dmiOrganizationMapper.selectByPrimaryKey(id));
    }


    /**
     * 根据雇主公司的ID，获取公司所属组织结构某个级别的列表
     * @param map
     * @return
     */
    public Result getOragnizationListByParentId(HashMap<String, Object> map) {
        List<DmiOrganization> list = new ArrayList<DmiOrganization>();
        List<Map<String, Object>> orgMap = dmiOrganizationMapper.selectByParentId(map);
        for (Map<String, Object> map1 : orgMap) {
            list.add(new DmiOrganization((HashMap) map1));
        }
        return ResultUtil.success(list);
    }


    /**
     * 失效组织结构节点开始
     * @param userId
     * @param dmiOrganization
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result handleInvalid(int userId, DmiOrganization dmiOrganization) {

        // 设定失效
        dmiOrganization.setFlagAvailable(false);
        dmiOrganization.setUpdateTime(new Date());
        dmiOrganization.setUpdatePerson(userId);

        updateOragnization(dmiOrganization);

        return ResultUtil.successMsg("失效成功");
    }








//----------------------------------------------------------------------

    private boolean updateOragnization(DmiOrganization dmiOrganization) {
        int effectRows = dmiOrganizationMapper.updateByPrimaryKeySelective(dmiOrganization);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }


    private boolean insertOragnization(DmiOrganization dmiOrganization) {
        int effectRows = dmiOrganizationMapper.insertSelective(dmiOrganization);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getOragnizationCountByBusinessLicenseId(int id) {
        return dmiOrganizationMapper.selectByBusinessLicenseId(id);
    }




    /**
     * 将有序集合按照级别重新排列
     *
     * @return
     */
    private List<DmiOrganizationOfTree> buildTreeByLevel(List<DmiOrganization> list) {
        List<DmiOrganizationOfTree> result = new ArrayList<DmiOrganizationOfTree>();

        // 循环迭代有序集合
        Iterator<DmiOrganization> it = list.iterator();
        while (it.hasNext()) {
            // 获取当前对象的相关参数
            DmiOrganization item = it.next();
            int level = item.getLevel() == null ? 0 : item.getLevel();
            int id = item.getId() == null ? 0 : item.getId();
            int orderId = item.getOrderId() == null ? 0 : item.getOrderId();
            int parentId = item.getParentId() == null ? 0 : item.getParentId();

            // 如果level为1，则取出，并且跳过本次循环
            if (level == 1) {
                result.add(dozer.map(item, DmiOrganizationOfTree.class));
                it.remove();
                continue;
            } else {
                // 如果level不为1，则比较父级ID
                boolean insertFlag = false;
                for (int i = 0; i < result.size(); i++) {
                    DmiOrganization resultItem = result.get(i);
//                    int resultItemId = resultItem.getId() == null ? 0 : resultItem.getId();
                    int resultItemParentId = resultItem.getParentId() == null ? 0 : resultItem.getParentId();
                    int resultOrderId = resultItem.getOrderId() == null ? 0 : resultItem.getOrderId();
//                    if (resultItemParentId == parentId && resultItemId < id) {
                    if (resultItemParentId == parentId && resultOrderId+1 == orderId) {
                        result.add(i + 1, dozer.map(item, DmiOrganizationOfTree.class));
                        insertFlag = true;
                        it.remove();
                        break;
                    }
                }
                if (!insertFlag) {
                    for (int i = 0; i < result.size(); i++) {
                        DmiOrganization resultItem = result.get(i);
                        int resultItemId = resultItem.getId() == null ? 0 : resultItem.getId();
                        if (resultItemId == parentId) {
                            result.add(i + 1, dozer.map(item, DmiOrganizationOfTree.class));
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }



    /**
     * 将查询得到的门店按照区域插入组织机构列表
     *
     * @param list
     * @param companyId
     * @return
     */
    private List<DmiOrganizationOfTree> insertStoreToOragnizationList(List<DmiOrganizationOfTree> list, int companyId) {
        // 定义返回结果
        List<DmiOrganizationOfTree> result = new ArrayList<DmiOrganizationOfTree>();
        // 查询所有门店，按区域ID升序
        DmiOrganization firstOrg = dmiOrganizationMapper.selectFirstOrgByCompanyId(companyId).get(0);
        List<DmiStoreBySelectByAreaSort> sqlRetStoreList = dmiStoreMapper.selectByAreaIdSort(companyId);
        List<DmiStoreBySelectByAreaSort> storeList = new ArrayList<DmiStoreBySelectByAreaSort>();
        for (DmiStoreBySelectByAreaSort item : sqlRetStoreList) {
            if (item.isFlagDeleted()) {
                item.setAreaId(firstOrg.getId());
            }
            storeList.add(item);
        }
        // 将查询得到的门店按照区域插入组织机构列表
        for (int i = 0; i < list.size(); i++) {
            // 先将当前数据放入结果集中
            result.add(list.get(i));
            // 是否最后一个
            if (i == list.size() - 1) {// 最后一个
                Iterator<DmiStoreBySelectByAreaSort> storeIterator = storeList.iterator();
                while (storeIterator.hasNext()) {
                    DmiOrganizationOfTree insertItem = new DmiOrganizationOfTree();
                    DmiStoreBySelectByAreaSort store = storeIterator.next();
                    insertItem.setStoreAddr(store.getAddress());
                    insertItem.setStoreCode(store.getStoreCode());
                    insertItem.setFlagIsStore(true);
                    insertItem.setId(store.getId());
                    insertItem.setMemo(store.getMemo());
                    insertItem.setOrganizationName(store.getStoreName());
                    insertItem.setLevel(list.get(list.size() - 1).getLevel() + 1);
                    insertItem.setParentId(store.getAreaId());
                    result.add(insertItem);
                    storeIterator.remove();
                }
            } else {// 不是最后一个
                DmiOrganizationOfTree item = list.get(i);

                Iterator<DmiStoreBySelectByAreaSort> storeIterator = storeList.iterator();
                // 将门店相同级别的数据插入
                while (storeIterator.hasNext()) {
                    DmiStoreBySelectByAreaSort store = storeIterator.next();
                    if (store.getAreaId().intValue() == item.getId().intValue()) {
                        DmiOrganizationOfTree insertItem = new DmiOrganizationOfTree();
                        insertItem.setFlagIsStore(true);
                        insertItem.setId(store.getId());
                        insertItem.setOrganizationName(store.getStoreName());
                        insertItem.setLevel(item.getLevel() + 1);
                        insertItem.setParentId(item.getParentId());
                        result.add(insertItem);
                        storeIterator.remove();
                    }
                }
            }
        }
        return result;
    }



    /**
     * 将排列整齐的集合构造成最终的树形结构
     *
     * @return
     */
    private List<DmiOrganizationOfTree> buildResultTree(List<DmiOrganizationOfTree> list) {
        List<DmiOrganizationOfTree> tempList = new ArrayList<DmiOrganizationOfTree>();
        List<DmiOrganizationOfTree> resultList = new ArrayList<DmiOrganizationOfTree>();
        int level = list.get(0).getLevel().intValue();

        boolean flagWorking = true; //是否在工作状态中
        boolean flagStartProcess = false; //是否可以开始处理当前级别的列表
        boolean flagFinishSplit = false; //是否在加载当前级别的子列表
        if (list.size() <= 0) return null;

        while (flagWorking) {
            //拆分列表，获取当前级别及子级别的列表
            if (list.get(0).getLevel().intValue() == level) {
                //判断当前list的level和level一致时，是否正在处理上一条同level的数据列表
                if (!flagFinishSplit) {
                    tempList.add(list.get(0));
                    list.remove(0);
                    flagFinishSplit = true;
                    //判断之前取的数据是否是最后一条
                    if (list.size() == 0) {
                        flagStartProcess = true;
                    }
                } else {
                    flagStartProcess = true;
                }
            } else if (list.get(0).getLevel().intValue() > level) {
                //获取子级别的所有列表
                tempList.add(list.get(0));
                list.remove(0);
                if (list.size() == 0) {
                    flagStartProcess = true;
                }
            }
            //可以处理当前级别和子级别的数据列表
            if (flagStartProcess) {
                DmiOrganizationOfTree dmiOrganizationOfTree = tempList.get(0);
                tempList.remove(0);
                if (tempList.size() > 0) {
                    dmiOrganizationOfTree.setHasChildNode(true);
                    dmiOrganizationOfTree.setChildren(buildResultTree(tempList));
                }
                resultList.add(dmiOrganizationOfTree);
                flagFinishSplit = false;
                flagStartProcess = false;
            }
            if (list.size() == 0 && flagStartProcess == false) {
                flagWorking = false;
            }
        }
        return resultList;
    }


    public DmiOrganization getOragnizationByCompanyIdAndCode(int companyId, String code) {
        DmiOrganization record = new DmiOrganization();
        record.setBelongsCompanyId(companyId);
        record.setOrganizationCode(code);
        return dmiOrganizationMapper.getOragnizationByCompanyIdAndCode(record);
    }
}

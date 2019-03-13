package com.company.springboot.service.dmi;

import com.company.springboot.config.OrgNodeTypeConfig;
import com.company.springboot.entity.dmi.DmiInvoiceModelWithBLOBs;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.dmi.DmiInvoiceModelMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author Chenliwen
 * @Date 2019/1/9 15:10
 **/
@Service
public class DmiInvoiceModelService {

    @Resource
    private DmiInvoiceModelMapper dmiInvoiceModelMapper;

    //根据公司ID查找发票模板
    public List<DmiInvoiceModelWithBLOBs> getAllInvoiceByCompanyId(int companyId, String type) {
        List<DmiInvoiceModelWithBLOBs> list = new ArrayList<DmiInvoiceModelWithBLOBs>();
        List<Map<String, Object>> orgMap;
        if (type.equals("null")) {
            orgMap = dmiInvoiceModelMapper.selectInvoiceListByCompanyId(companyId);
        } else {
            DmiInvoiceModelWithBLOBs record = new DmiInvoiceModelWithBLOBs();
            record.setBelongObjectId(companyId);
            record.setInvoiceType(type);
            orgMap = dmiInvoiceModelMapper.selectInvoiceListByCompanyIdAndType(record);
        }
        for (Map<String, Object> map : orgMap) {
            list.add(new DmiInvoiceModelWithBLOBs((HashMap) map));
        }
        return list;
    }

    public Result list(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        List<DmiInvoiceModelWithBLOBs> invoiceModelList;
        if (OrgNodeTypeConfig.COMPANY.equals(dmiInvoiceModelWithBLOBs.getBelongObjectType())) {
            // 如果传入的节点类型是公司
            invoiceModelList = getAllInvoiceByCompanyId(dmiInvoiceModelWithBLOBs.getBelongObjectId(), "null");
        } else if (OrgNodeTypeConfig.AREA.equals(dmiInvoiceModelWithBLOBs.getBelongObjectType())) {
            // 如果传入的节点类型是组织内节点
            invoiceModelList = getAllInvoiceByAreaId(dmiInvoiceModelWithBLOBs.getBelongObjectId());
        } else if (OrgNodeTypeConfig.STORE.equals(dmiInvoiceModelWithBLOBs.getBelongObjectType())) {
            // 如果传入的节点类型是门店
            invoiceModelList = getAllInvoiceByStoreId(dmiInvoiceModelWithBLOBs.getBelongObjectId());
        } else {
            invoiceModelList = new ArrayList<DmiInvoiceModelWithBLOBs>();
        }

        if (dmiInvoiceModelWithBLOBs.getPageNum() != null && dmiInvoiceModelWithBLOBs.getPageSize() != null) {
            PageHelper.startPage(dmiInvoiceModelWithBLOBs.getPageNum(), dmiInvoiceModelWithBLOBs.getPageSize());
            PageInfo<DmiInvoiceModelWithBLOBs> pageInfo = new PageInfo<>(invoiceModelList);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        }
            return ResultUtil.success(invoiceModelList);
    }

    //根据组织区域ID查找发票模板
    private List<DmiInvoiceModelWithBLOBs> getAllInvoiceByAreaId(int areaId) {
        List<DmiInvoiceModelWithBLOBs> list = new ArrayList<DmiInvoiceModelWithBLOBs>();
        List<Map<String, Object>> orgMap = dmiInvoiceModelMapper.selectInvoiceListByAreaId(areaId);
        for (Map<String, Object> map : orgMap) {
            list.add(new DmiInvoiceModelWithBLOBs((HashMap) map));
        }
        return list;
    }

    //根据门店模板ID查找发票模板
    private List<DmiInvoiceModelWithBLOBs> getAllInvoiceByStoreId(int storeId) {
        List<DmiInvoiceModelWithBLOBs> list = new ArrayList<DmiInvoiceModelWithBLOBs>();
        List<Map<String, Object>> orgMap = dmiInvoiceModelMapper.selectInvoiceListByStoreId(storeId);
        for (Map<String, Object> map : orgMap) {
            list.add(new DmiInvoiceModelWithBLOBs((HashMap) map));
        }
        return list;
    }

    public Result handle(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        if(dmiInvoiceModelWithBLOBs.getInvoiceModelName()==null||dmiInvoiceModelWithBLOBs.getInvoiceModelName().equals("")||
                dmiInvoiceModelWithBLOBs.getInvoiceType()==null||dmiInvoiceModelWithBLOBs.getInvoiceType().equals("")||
                dmiInvoiceModelWithBLOBs.getInvoiceTitle()==null||dmiInvoiceModelWithBLOBs.getInvoiceTitle().equals("")||
                dmiInvoiceModelWithBLOBs.getTaxpayerNumber()==null||dmiInvoiceModelWithBLOBs.getTaxpayerNumber().equals("")||
                dmiInvoiceModelWithBLOBs.getInvoiceAddress()==null||dmiInvoiceModelWithBLOBs.getInvoiceAddress().equals("")||
                dmiInvoiceModelWithBLOBs.getBankName()==null||dmiInvoiceModelWithBLOBs.getBankName().equals("")||
                dmiInvoiceModelWithBLOBs.getInvoiceAccount()==null||dmiInvoiceModelWithBLOBs.getInvoiceAccount().equals("")
        ){
            // 设定返回信息
            return ResultUtil.validateError("当前请求非法");
        } else {

            if (dmiInvoiceModelWithBLOBs.getId() > 0) {
                // 执行更新操作
                dmiInvoiceModelWithBLOBs.setUpdatePerson(user.getId());
                dmiInvoiceModelWithBLOBs.setUpdateTime(new Date());

                updateInvoice(dmiInvoiceModelWithBLOBs);

                return ResultUtil.successMsg("更新成功！");
            } else {
                // 执行新增操作
                dmiInvoiceModelWithBLOBs.setCreatePerson(user.getId());
                dmiInvoiceModelWithBLOBs.setCreateTime(new Date());
                dmiInvoiceModelWithBLOBs.setFlagAvailable(true);
                dmiInvoiceModelWithBLOBs.setFlagDeleted(false);
                dmiInvoiceModelWithBLOBs.setUpdatePerson(user.getId());
                dmiInvoiceModelWithBLOBs.setUpdateTime(new Date());

                // 如果从页面Body中没有获得CompanyId参数，需要手动设定一次CompanyId
                if (dmiInvoiceModelWithBLOBs.getBelongObjectId() == null || dmiInvoiceModelWithBLOBs.getBelongObjectId() == 0) {
                    dmiInvoiceModelWithBLOBs.setBelongObjectId(user.getCompanyId());
                    dmiInvoiceModelWithBLOBs.setBelongObjectType(OrgNodeTypeConfig.COMPANY);
                }

                insertInvoice(dmiInvoiceModelWithBLOBs);
                return ResultUtil.successMsg("新增成功");
            }
        }
    }

    private boolean insertInvoice(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        int effectRows = dmiInvoiceModelMapper.insertSelective(dmiInvoiceModelWithBLOBs);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean updateInvoice(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        int effectRows = dmiInvoiceModelMapper.updateByPrimaryKeySelective(dmiInvoiceModelWithBLOBs);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Result getInvoiceModel(int id) {
        return ResultUtil.success(dmiInvoiceModelMapper.selectByPrimaryKey(id));
    }

    public Result handleInvalid(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        // 设定失效
        dmiInvoiceModelWithBLOBs.setFlagAvailable(false);
        dmiInvoiceModelWithBLOBs.setUpdateTime(new Date());
        dmiInvoiceModelWithBLOBs.setUpdatePerson(user.getId());

        updateInvoice(dmiInvoiceModelWithBLOBs);

        return ResultUtil.successMsg("失效成功！");
    }


    public Result handleDelete(DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        // 设定失效
        dmiInvoiceModelWithBLOBs.setFlagDeleted(true);
        dmiInvoiceModelWithBLOBs.setUpdateTime(new Date());
        dmiInvoiceModelWithBLOBs.setUpdatePerson(user.getId());

        updateInvoice(dmiInvoiceModelWithBLOBs);

        return ResultUtil.successMsg("删除成功！");
    }
}

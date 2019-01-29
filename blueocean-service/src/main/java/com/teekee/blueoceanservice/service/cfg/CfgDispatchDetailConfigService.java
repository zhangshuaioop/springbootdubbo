package com.teekee.blueoceanservice.service.cfg;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.blueoceanservice.entity.cfg.CfgDispatchDetailConfig;
import com.teekee.blueoceanservice.entity.cfg.CfgDispatchDetailModel;
import com.teekee.blueoceanservice.mapper.cfg.CfgDispatchDetailConfigMapper;
import com.teekee.blueoceanservice.mapper.cfg.CfgDispatchDetailModelMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 10:51
 **/
@Service
public class CfgDispatchDetailConfigService {

    @Resource
    private CfgDispatchDetailConfigMapper mapper;
    @Resource
    private CfgDispatchDetailModelMapper modelMapper;

    public Result basicList(String dispatchType) {
        //通过type类型和objectid以及dispatchtype查询对应的派工模板
        CfgDispatchDetailModel model = new CfgDispatchDetailModel();
        model.setDispatchType(dispatchType);
        model.setCompanyId(0);
        List<CfgDispatchDetailConfig> configList = mapper.basicList(model);
        return ResultUtil.success(configList);

    }

    public Result childList(Integer id) {
        if (id == null || id == 0) {
            return ResultUtil.validateError("参数错误");
        }
        return ResultUtil.success(mapper.childList(id));
    }

    public Result show(Integer modelId) {
        if (modelId == null || modelId == 0) {
            return ResultUtil.validateError("参数错误");
        }
        List<CfgDispatchDetailConfig> list = new ArrayList<CfgDispatchDetailConfig>();
        List<CfgDispatchDetailConfig> sqlList = mapper.selectDispatchConfigByModelId(modelId);
        int currentIndex = 0;

        if (sqlList != null && sqlList.size() > 0) {
            if (sqlList.get(0).getLevel() > 1) {
                return null;
            }

            while (sqlList.size() > 0) {
                CfgDispatchDetailConfig item = sqlList.get(0);
                if (item.getDispatchType() == null || item.getDispatchType().equals("")) {
                    // TODO 此处写死了一个参数 原因 为了配合编辑
                    item.setDispatchType("FAULT_REPAIR");
                }
                if (item.getChildren() ==null) item.setChildren(new ArrayList<CfgDispatchDetailConfig>());

                // 防止出现所有Level=1数据处理完后，还有其他的level的数据存在
                if (item.getLevel() > 1) {
                    return ResultUtil.success(list);
                }
                //判定是否有以当前Id为父级Id的其他数据
                currentIndex = getIndexOfParentId(sqlList, item.getId());

                if (currentIndex >= 0) {
                    //将对应位置的数据放入父级数据下，如果长度过短或者当前数据的父级ID和上级ID不匹配则退出循环
                    while (currentIndex < sqlList.size() && sqlList.get(currentIndex).getParentId().intValue() == item.getId().intValue()) {
                        item.getChildren().add(sqlList.get(currentIndex));
                        sqlList.remove(currentIndex);
                    }
                }
                // 将Level =1的数据放入List
                list.add(item);
                if (sqlList.size() > 0) {
                    sqlList.remove(0);
                }

            }
        }
        return ResultUtil.success(list);
    }

    private int getIndexOfParentId(List<CfgDispatchDetailConfig> list, int parentId) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getParentId() == parentId) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Result showModelList(CfgDispatchDetailModel model) {
        //通过type类型和objectid以及dispatchtype查询对应的派工模板
        model.setCompanyId(0);
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<CfgDispatchDetailModel> persons = modelMapper.selectModelList(model);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<CfgDispatchDetailModel> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result selectAllVersionList(CfgDispatchDetailModel model) {
        model.setCompanyId(0);
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<CfgDispatchDetailModel> persons = modelMapper.selectAllVersionList(model);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<CfgDispatchDetailModel> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result handle(String json) {
        List<CfgDispatchDetailConfig> list = JSON.parseArray(json, CfgDispatchDetailConfig.class);
        Date now = new Date();
        CfgDispatchDetailModel model = new CfgDispatchDetailModel();
        CfgDispatchDetailConfig config = new CfgDispatchDetailConfig();
        CfgDispatchDetailConfig configLevel2 = new CfgDispatchDetailConfig();
        List<CfgDispatchDetailConfig> resultlist = new ArrayList<CfgDispatchDetailConfig>();
        //赋值
        if(list != null && list.size()>0){
            model.setDispatchType(list.get(0).getDispatchType());
        }
        model.setCreateTime(now);
        model.setModelUserType("PLATFORM");
        model.setCreatePerson(CurrentUtil.getCurrent().getId());
        // 派工要求只能操作自己的公司
        model.setCompanyId(0);
        //查询历史模板
        List<CfgDispatchDetailModel> historyList = modelMapper.selectAllVersionList(model);
        //有历史模板 version+1
        if (historyList.size() > 0) {
            model.setVersion(historyList.get(0).getVersion() + 1);
        } else {//没有历史模板 新增 veison=1
            model.setVersion(1);
        }
        model.setCompanyId(0);
        modelMapper.insertSelective(model);
        //}
        //取出level =1 的数据
        for (int i = 0; i < list.size(); i++) {
            config.setId(0);
            config.setCatalogName(list.get(i).getCatalogName());
            config.setOrderId(i + 1);
            config.setParentId(0);
            config.setLevel(list.get(i).getLevel());
            config.setModelId(model.getId());
            config.setTitle(list.get(i).getTitle());
            resultlist = list.get(i).getChildren();
            mapper.insertSelective(config);
            //获取新增后最大的id
            int id = config.getId();
            if (list.get(i).getChildren().size() != 0) {
                //取出level=2的数据
                for (int j = 0; j < resultlist.size(); j++) {
                    configLevel2.setId(0);
                    configLevel2.setLevel(2);
                    configLevel2.setOrderId(j + 1);
                    configLevel2.setCatalogName(resultlist.get(j).getCatalogName());
                    configLevel2.setParentId(id);
                    configLevel2.setModelId(model.getId());
                    mapper.insertSelective(configLevel2);
                }
            }

        }
        return ResultUtil.success();
    }

    public Result showDetailList(Integer id) {
        if (id == null || id == 0) {
            return ResultUtil.validateError("参数错误");
        }
        return ResultUtil.success(mapper.selectListById(id));
    }

}

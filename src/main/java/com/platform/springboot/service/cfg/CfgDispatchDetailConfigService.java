package com.platform.springboot.service.cfg;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.cfg.CfgDispatchDetailConfig;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.cfg.CfgDispatchDetailConfigMapper;
import com.platform.springboot.mapper.cfg.CfgDispatchDetailModelMapper;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: CfgDispatchDetailConfigService
 * @ProjectName WaterDrop
 * @Description: 派工要求
 * @date 2018/12/18下午1:35
 */
@Service
public class CfgDispatchDetailConfigService {

    @Resource
    private CfgDispatchDetailConfigMapper mapper;
    @Resource
    private CfgDispatchDetailModelMapper modelMapper;
    @Resource
    private DmiCompanyInfoMapper infoMapper;

    public Result basicList(String dispatchType) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        //通过type类型和objectid以及dispatchtype查询对应的派工模板
        CfgDispatchDetailModel model = new CfgDispatchDetailModel();
        model.setModelUserType(users.getActType());
        model.setCreatePerson(users.getId());
        model.setModelUserObjId(users.getActObjectId());
        model.setDispatchType(dispatchType);
        List<CfgDispatchDetailConfig> configList = mapper.basicList(model);
        if(configList.size()==0){
            if(users.getActType().equals("DEMAND")){
                Integer vendorId = infoMapper.selectVendorId(model.getModelUserObjId());
                model.setModelUserObjId(vendorId);
                model.setModelUserType("VENDOR");
                configList = mapper.basicList(model);
                if(configList.size() ==0){//判断type是否为集成商 不是则q查询平台下的默认model
                    model.setModelUserType("PLATFORM");
                    model.setModelUserObjId(0);
                    configList = mapper.basicList(model);
                }
            }else{
                model.setModelUserType("PLATFORM");
                model.setModelUserObjId(0);
                configList =mapper.basicList(model);
            }
        }
        return ResultUtil.success(configList);

    }

    public Result childList(Integer id) {
        if(id == null || id==0){
            return ResultUtil.validateError("参数错误");
        }
        return ResultUtil.success(mapper.childList(id));
    }

    public Result show(Integer modelId) {
        if(modelId == null || modelId==0){
            return ResultUtil.validateError("参数错误");
        }
        List<CfgDispatchDetailConfig> list = new ArrayList<CfgDispatchDetailConfig>();
        List<CfgDispatchDetailConfig> sqlList = mapper.selectDispatchConfigByModelId(modelId);
        int currentIndex = 0;

        if(sqlList != null && sqlList.size() >0){
            if(sqlList.get(0).getLevel() > 1) {
                return null;
            }

            while(sqlList.size() >0) {
                CfgDispatchDetailConfig item = sqlList.get(0);
                if(item.getChildList() == null) item.setChildList(new ArrayList<CfgDispatchDetailConfig>());

                // 防止出现所有Level=1数据处理完后，还有其他的level的数据存在
                if(item.getLevel() > 1){
                    return  ResultUtil.success(list);
                }
                //判定是否有以当前Id为父级Id的其他数据
                currentIndex = getIndexOfParentId(sqlList,item.getId());

                if(currentIndex >= 0){
                    //将对应位置的数据放入父级数据下，如果长度过短或者当前数据的父级ID和上级ID不匹配则退出循环
                    while(currentIndex < sqlList.size() && sqlList.get(currentIndex).getParentId().intValue() == item.getId().intValue()){
                        item.getChildList().add(sqlList.get(currentIndex));
                        sqlList.remove(currentIndex);
                    }
                }
                // 将Level =1的数据放入List
                list.add(item);
                if(sqlList.size() > 0){
                    sqlList.remove(0);
                }
                    
            }
        }
        return  ResultUtil.success(list);
    }

    private int getIndexOfParentId(List<CfgDispatchDetailConfig> list,int parentId){
        int index = -1;
        for(int i = 0 ;i<list.size();i++){
            if(list.get(i).getParentId() == parentId) {
                index = i;
                break;
            }
        }
        return  index;
    }

    public Result showModelList(CfgDispatchDetailModel model) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        //通过type类型和objectid以及dispatchtype查询对应的派工模板
        model.setModelUserType(users.getActType());
        model.setCreatePerson(users.getId());
        model.setModelUserObjId(users.getActObjectId());
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<CfgDispatchDetailModel> persons = modelMapper.selectModelList(model);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<CfgDispatchDetailModel> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result selectAllVersionList(CfgDispatchDetailModel model) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        model.setModelUserType(users.getActType());
        model.setModelUserObjId(users.getActObjectId());
        model.setCreatePerson(users.getId());
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<CfgDispatchDetailModel> persons = modelMapper.selectAllVersionList(model);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<CfgDispatchDetailModel> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result handle(String json) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        List<CfgDispatchDetailConfig> list = JSON.parseArray(json, CfgDispatchDetailConfig.class);
        Date now = new Date();
        CfgDispatchDetailModel model = new CfgDispatchDetailModel();
        CfgDispatchDetailConfig config = new CfgDispatchDetailConfig();
        CfgDispatchDetailConfig configLevel2 = new CfgDispatchDetailConfig();
        List<CfgDispatchDetailConfig> resultlist = new ArrayList<CfgDispatchDetailConfig>();
        //赋值
        model.setModelUserObjId(users.getActObjectId());
        model.setModelUserType(users.getActType());
        model.setDispatchType(list.get(0).getDispatchType());
        model.setCreateTime(now);
        model.setCreatePerson(users.getId());
        //查询历史模板
        List<CfgDispatchDetailModel> historyList = modelMapper.selectAllVersionList(model);
        //有历史模板 version+1
        if(historyList.size()>0){
            model.setVersion(historyList.get(0).getVersion()+1);
        }else{//没有历史模板 新增 veison=1
            model.setVersion(1);
        }
        modelMapper.insertSelective(model);
        //}
        //取出level =1 的数据
        for(int i = 0 ; i < list.size() ; i++){
            config.setId(0);
            config.setCatalogName(list.get(i).getCatalogName());
            config.setOrderId(i+1);
            config.setParentId(0);
            config.setLevel(list.get(i).getLevel());
            config.setModelId(model.getId());
            config.setTitle(list.get(i).getTitle());
            resultlist = list.get(i).getChildList();
            mapper.insertSelective(config);
            //获取新增后最大的id
            int id = config.getId();
            if(list.get(i).getChildList().size() != 0){
                //取出level=2的数据
                for(int j = 0 ;j<resultlist.size();j++){
                    configLevel2.setId(0);
                    configLevel2.setLevel(2);
                    configLevel2.setOrderId(j+1);
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
        if(id == null || id==0){
            return ResultUtil.validateError("参数错误");
        }
        return ResultUtil.success(mapper.selectListById(id));
    }
}

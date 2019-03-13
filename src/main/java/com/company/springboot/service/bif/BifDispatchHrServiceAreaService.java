package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifDispatchHrServiceArea;
import com.company.springboot.mapper.bif.BifDispatchHrServiceAreaMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Megumi
 * @Date 2019/1/2 11:37
 **/
@Service
public class BifDispatchHrServiceAreaService {

    @Resource
    private BifDispatchHrServiceAreaMapper mapper;

    public Result handle(BifDispatchHrServiceArea serviceArea) {

        if(serviceArea.getFlagDefault()==true){
            mapper.updateFaultByHrId(serviceArea.getHrId());
        }
        if(serviceArea.getNation()==null || serviceArea.getNation().equals("")) {
            return ResultUtil.validateError("国家不能为空");
        }
        if(serviceArea.getProvince()==null || serviceArea.getProvince().equals("")){
            return ResultUtil.validateError("请填写省份！");
        }
        if(serviceArea.getCity()==null || serviceArea.getCity().equals("")) {
            return ResultUtil.validateError("请填写城市！");
        }

        List<BifDispatchHrServiceArea> bifDispatchHrServiceAreas = mapper.selectByHrId(serviceArea.getHrId());

        //将当前服务区域设置为默认
        if(serviceArea.getFlagDefault().equals(true)){
            serviceArea.setFlagDefault(true);
            List<BifDispatchHrServiceArea> areaList = mapper.selectFault(serviceArea);
            if (areaList.size() > 0){
                //将默认的设置非默认
                BifDispatchHrServiceArea area = new BifDispatchHrServiceArea();
                area.setHrId(serviceArea.getHrId());
                area.setFlagDefault(false);
                mapper.updateByPrimaryKeySelectiveById(area);
            }
        }


        if(serviceArea.getId()==0){

            ////判断该服务商的服务区域数量不能超过十个
            //if(bifDispatchHrServiceAreas.size() >= 10){
            //    return StringUtil.buildSuccessRespMsgFalse("服务区域不能超过十个，请删除后再新增！");
            //}
            //判断服务商服务城市不能重复
            for (BifDispatchHrServiceArea item : bifDispatchHrServiceAreas){
                if(serviceArea.getCity().equals(item.getCity())){
                    return ResultUtil.validateError("该服务城市已存在！");
                }
            }

            serviceArea.setFlagDeleted(false);
            serviceArea.setCreateTime(new Date());
            serviceArea.setNation("中国");
            mapper.insertSelective(serviceArea);
            return ResultUtil.successMsg("新增成功!");
        }
        else {
            //编辑服务区域省、市未改动
            BifDispatchHrServiceArea area = mapper.selectByPrimaryKey(serviceArea.getId());
            if(!area.getProvince().equals(serviceArea.getProvince()) && !area.getCity().equals(serviceArea.getCity())){
                //判断服务商服务城市不能重复
                for (BifDispatchHrServiceArea item : bifDispatchHrServiceAreas){
                    if(serviceArea.getCity().equals(item.getCity())){
                        return ResultUtil.validateError("该服务城市已存在！");
                    }
                }
            }

            mapper.updateByPrimaryKeySelectiveById(serviceArea);

        }

        serviceArea.setFlagDefault(true);
        List<BifDispatchHrServiceArea> areaList = mapper.selectFault(serviceArea);
        if (areaList==null||areaList.size()==0){
            //如当前没有默认服务区自动设置最新新增的区域为默认
            autoUpdateServiceArea(serviceArea.getHrId());
        }
        return ResultUtil.successMsg("更新成功!");
    }

    //如当前没有默认服务区自动设置最新新增的区域为默认
    private void autoUpdateServiceArea(Integer hrId) {
        List<BifDispatchHrServiceArea> area2 = mapper.selectAreaList(hrId);
        BifDispatchHrServiceArea faultArea = new BifDispatchHrServiceArea();
        faultArea.setId(area2.get(0).getId());
        faultArea.setFlagDefault(true);
        mapper.updateByPrimaryKeySelective(faultArea);
    }

    public Result serviceAreaDelete(Integer id) {
        mapper.deleteAreaById(id);

        BifDispatchHrServiceArea area= mapper.selectByPrimaryKey(id);

        List<BifDispatchHrServiceArea> areaList = mapper.selectByHrId(area.getHrId());

        if (areaList!=null||areaList.size()>0){
            //如当前没有默认服务区自动设置最新新增的区域为默认
            autoUpdateServiceArea(area.getHrId());

        }
        return ResultUtil.successMsg("删除成功!");
    }

    public Result serviceAreaList(BifDispatchHrServiceArea area) {
        List<BifDispatchHrServiceArea> list = new ArrayList<>();
        PageHelper.startPage(area.getPageNum(), area.getPageSize());
        Page<BifDispatchHrServiceArea> persons = mapper.selectByHrId(area.getHrId());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDispatchHrServiceArea> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        //如果没有可服务区域 返回一个空的对象
        if(pageInfo != null){
            return ResultUtil.success(pageInfo);

        }
        return ResultUtil.success(list);
    }

    public Result serviceAreaShow(Integer id) {
        BifDispatchHrServiceArea area = mapper.selectByPrimaryKey(id);
        return ResultUtil.success(area);
    }
}

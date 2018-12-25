package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.fdp.FdpFaultReportRoute;
import com.platform.springboot.entity.fdp.GetFaultReportRouteList;
import com.platform.springboot.entity.fdp.GetRouteObjectList;
import com.platform.springboot.mapper.fdp.FdpFaultReportRouteMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.mapper.fdp.FdpFaultReportRouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-18 14:18
 */
@Service
public class FdpFaultReportRouteService {


    @Autowired
    private FdpFaultReportRouteMapper fdpFaultReportRouteMapper;

    /**
     * 新增故障分配路径
     * @param route
     * @param userId
     * @return
     * @Author Niting
     * @Date 2018/06/01
     */
    public Result handle(FdpFaultReportRoute route, Integer userId) {
        Date now = new Date();
        if(route.getCompanyId()!= 0){
            //先删除分配路径
            fdpFaultReportRouteMapper.deleteByCompanyId(route.getCompanyId());
            //获取来源数组
            String[] sourceArry = route.getSource().split(";");
            //获取对象数组
            String[] objectArry = route.getRouteObject().split(";");
            List<FdpFaultReportRoute> list = new ArrayList<FdpFaultReportRoute>();
            FdpFaultReportRoute r ;
            for(int i = 0 ; i <sourceArry.length ; i++){
                r = new FdpFaultReportRoute();
                r.setRouteObject(objectArry[i]);
                r.setSource(sourceArry[i]);
                r.setCreatePerson(userId);
                r.setCreateTime(now);
                r.setCompanyId(route.getCompanyId());
                fdpFaultReportRouteMapper.insertSelective(r);
                list.add(r);
            }
            return ResultUtil.successMsg("新增分配路径成功");
        }
        return ResultUtil.successMsg("请选择雇主！");
    }


    /**
     * 编辑故障分配路径
     * @param route
     * @param userId
     * @return
     */
    public Result modify(List<FdpFaultReportRoute> route, Integer userId) {
        Date now = new Date();
        if(route.get(0).getId() != null && route.get(0).getCompanyId() != null){
            FdpFaultReportRoute recode ;
            List<FdpFaultReportRoute> reportRoute = reportRoute = fdpFaultReportRouteMapper.queryByCompanyId(route.get(0).getCompanyId());
            for (int i = 0 ; i< reportRoute.size() ; i++){
                //判断页面参数数据库中是否匹配  如果匹配修改
                if(reportRoute.get(i).getId() == route.get(i).getId()){
                    recode = new FdpFaultReportRoute();
                    recode.setId(route.get(i).getId());
                    recode.setSource(route.get(i).getSource());
                    recode.setRouteObject(route.get(i).getRouteObject());
                    fdpFaultReportRouteMapper.updateByPrimaryKeySelective(recode);
                }else{//否则删除
                    fdpFaultReportRouteMapper.deleteByPrimaryKey(route.get(i).getId());
                }
            }
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("编辑分配路径失败");
    }


    /**
     * 查询雇主列表
     * @param userId
     * @return
     */
    public Result showCompanyList(Integer userId) {
        List<GetFaultReportRouteList> routeLists = fdpFaultReportRouteMapper.show(userId);
        List<FdpFaultReportRoute> record = new ArrayList<FdpFaultReportRoute>();
        for (GetFaultReportRouteList item :routeLists){
            //查询是否配置路径
            record = fdpFaultReportRouteMapper.isConfigRoute(item.getCompanyId());
            if(record.size() == 0){

                item.setFlagConfig(false);
            }else{
                item.setFlagConfig(true);
            }

        }
        return ResultUtil.success(routeLists);
    }


    /**
     * 删除故障分配路径
     * @param companyId
     * @return
     */
    public Result delete(Integer companyId) {
        if(companyId != null){
            fdpFaultReportRouteMapper.deleteByCompanyId(companyId);
        }
        return ResultUtil.successMsg("删除成功");
    }


    /**
     * 查询故障分配路径列表
     * @param companyId
     * @return
     */
    public Result showRouteList(Integer companyId) {
        return ResultUtil.success(fdpFaultReportRouteMapper.queryByCompanyId(companyId));
    }


    /**
     * 查询分配对象
     * @param companyId
     * @return
     */
    public Result routeObjectList(Integer companyId) {
        GetFaultReportRouteList list = fdpFaultReportRouteMapper.selectRouteObject(companyId);
        GetRouteObjectList companyName = new GetRouteObjectList();
        companyName.setRouteObject(list.getCompanyName());
        companyName.setSource("DEMAND");
        GetRouteObjectList vendorName = new GetRouteObjectList();
        vendorName.setRouteObject(list.getVendorName());
        vendorName.setSource("VENDOR");
        List<GetRouteObjectList> result = new ArrayList<GetRouteObjectList>();
        result.add(companyName);
        result.add(vendorName);
        return ResultUtil.success(result);
    }

}

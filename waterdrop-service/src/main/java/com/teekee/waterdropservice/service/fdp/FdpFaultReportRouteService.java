package com.teekee.waterdropservice.service.fdp;

import com.teekee.waterdropservice.entity.dmi.DmiCompanyInfo;
import com.teekee.waterdropservice.entity.fdp.FdpFaultReportRoute;
import com.teekee.waterdropservice.entity.fdp.GetFaultReportRouteList;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.mapper.dmi.DmiCompanyInfoMapper;
import com.teekee.waterdropservice.mapper.fdp.FdpFaultReportRouteMapper;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.apache.log4j.Logger;
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

    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private FdpFaultReportRouteMapper fdpFaultReportRouteMapper;

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    /**
     * 编辑故障分配路径
     *
     * @param listRoute
     * @return
     */
    public Result modify(List<FdpFaultReportRoute> listRoute) {
        if (listRoute == null || listRoute.size() != 3) {
            return ResultUtil.errorBusinessMsg("报障路径保证3条!");
        }

        String temp = "";
        for (int i = 0; i < listRoute.size() - 1; i++) {
            temp = listRoute.get(i).getSource();
            for (int j = i + 1; j < listRoute.size(); j++) {
                if (temp.equals(listRoute.get(j).getSource())) {
                    return ResultUtil.errorBusinessMsg("报障来源重复!");
                }
            }
        }
        for (int i = 0; i < listRoute.size(); i++) {
            if(!listRoute.get(i).getSource().equals("WECHAT")&&!listRoute.get(i).getSource().equals("POS")&&!listRoute.get(i).getSource().equals("SYSTEM")){
                return ResultUtil.errorBusinessMsg("报障来源错误!");
            }
        }
        FdpFaultReportRoute recode;
        for (FdpFaultReportRoute fdpFaultReportRoute : listRoute) {
            if (fdpFaultReportRoute.getId() == null || fdpFaultReportRoute.getId() == 0) {
                recode = new FdpFaultReportRoute();
                recode.setSource(fdpFaultReportRoute.getSource());
                recode.setRouteObject("DEMAND");
                recode.setCompanyId(fdpFaultReportRoute.getCompanyId());
                recode.setCreatePerson(CurrentUtil.getCurrent().getId());
                recode.setCreateTime(new Date());
                logger.info("新增报障路径 参数:recode:"+recode.toString());
                fdpFaultReportRouteMapper.insertSelective(recode);
            } else {
                fdpFaultReportRoute.setRouteObject("DEMAND");
                logger.info("修改报障路径 参数:fdpFaultReportRoute:"+fdpFaultReportRoute.toString());
                fdpFaultReportRouteMapper.updateByPrimaryKeySelective(fdpFaultReportRoute);
            }
        }
        return ResultUtil.success();
    }


    /**
     * 查询故障分配路径列表
     *
     * @param companyId
     * @return
     */
    public Result showRouteList(Integer companyId) {
        if(companyId ==null || companyId==0){
            companyId=CurrentUtil.getCurrent().getCompanyId();
        }
        return ResultUtil.success(fdpFaultReportRouteMapper.queryByCompanyId(companyId));
    }

    /**
     * 查询可分配对象
     *
     * @param companyId
     * @return
     */
    public Result routeObjectList(Integer companyId) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (companyId == null || companyId == 0) {
            companyId = users.getCompanyId();
        }
        //拼接本公司
        DmiCompanyInfo dmiCompanyInfo = dmiCompanyInfoMapper.selectByPrimaryKey(companyId);
        if(dmiCompanyInfo.getFlagIndependence()){
            List<GetFaultReportRouteList> list = new ArrayList<GetFaultReportRouteList>();
            GetFaultReportRouteList getFaultReportRouteList = new GetFaultReportRouteList();
            getFaultReportRouteList.setCompanyId(companyId);
            getFaultReportRouteList.setRouteObject(dmiCompanyInfo.getCompanyName());
            list.add(getFaultReportRouteList);
            return ResultUtil.success(list);
        }else{
            //查询关联公司
            List<GetFaultReportRouteList> list = fdpFaultReportRouteMapper.selectRouteObject(companyId);
            GetFaultReportRouteList getFaultReportRouteList = new GetFaultReportRouteList();
            getFaultReportRouteList.setCompanyId(companyId);
            getFaultReportRouteList.setRouteObject(dmiCompanyInfo.getCompanyName());
            list.add(getFaultReportRouteList);
            return ResultUtil.success(list);
        }
    }
}

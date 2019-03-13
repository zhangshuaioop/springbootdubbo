package com.company.springboot.service.cfg;

import com.company.springboot.entity.cfg.CfgDispatchRoute;
import com.company.springboot.entity.cfg.CfgDispatchRouteDetail;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.cfg.CfgDispatchRouteDetailMapper;
import com.company.springboot.mapper.cfg.CfgDispatchRouteMapper;
import com.company.springboot.mapper.sys.SysCompanyUsersMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.company.springboot.utils.TreeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 项目细则
 * @author: zhangshuai
 * @create: 2019-01-03 10:01
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CfgDispatchRouteDetailService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgDispatchRouteDetailMapper cfgDispatchRouteDetailMapper;

    @Autowired
    private CfgDispatchRouteMapper cfgDispatchRouteMapper;

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    /**
     * 项目细则配置列表(树)
     * @param routeId
     * @return
     */
    public Result findTree(Integer routeId) {
        return ResultUtil.success(TreeUtils.formatTree(cfgDispatchRouteDetailMapper.selectCfgDispatchRouteDetailList(routeId), false));
    }


    /**
     * 查看项目细则配置人员
     * @param routeId
     * @return
     */
    public Result findPerson(Integer routeId) {
        //配置信息
        CfgDispatchRoute cfgDispatchRoute = cfgDispatchRouteMapper.selectByPrimaryKey(routeId);

        //可分配人员
        List<SysCompanyUsers> sysCompanyUsers = new ArrayList<>();
        if(cfgDispatchRoute != null && cfgDispatchRoute.getPersons()!=null && cfgDispatchRoute.getPersons().length()>0){
            sysCompanyUsers = sysCompanyUsersMapper.selectByRouteCfg(cfgDispatchRoute.getPersons());
        }

        Map<String,Object> map = new HashMap<>();
        map.put("cfgDispatchRoute",cfgDispatchRoute);
        map.put("sysCompanyUsers",sysCompanyUsers);
        return ResultUtil.success(map);
    }




    /**
     * 保存/修改项目细则配置
     * @param cfgDispatchRouteDetails
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdate(List<CfgDispatchRouteDetail> cfgDispatchRouteDetails) {

        if(cfgDispatchRouteDetails !=null && cfgDispatchRouteDetails.size()>0){

            List<CfgDispatchRouteDetail> updateList = new ArrayList<CfgDispatchRouteDetail>();

            List<CfgDispatchRouteDetail> insertList = new ArrayList<CfgDispatchRouteDetail>();

            logger.info("组装保存或修改的对象");
            for (CfgDispatchRouteDetail cfgDispatchRouteDetail: cfgDispatchRouteDetails) {

                if(cfgDispatchRouteDetail!=null && cfgDispatchRouteDetail.getId()!=null && !cfgDispatchRouteDetail.getId().equals("0")){
                    updateList.add(cfgDispatchRouteDetail);
                }else {
                    insertList.add(cfgDispatchRouteDetail);
                }

            }

            if(insertList.size()>0){
                logger.info("批量保存细则");
                cfgDispatchRouteDetailMapper.insertBatch(insertList);
            }

            if(updateList.size()>0){
                logger.info("批量更新细则");
                cfgDispatchRouteDetailMapper.updateBatch(updateList);
            }

        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }

}

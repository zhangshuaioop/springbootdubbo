package com.teekee.waterdropservice.service.cfg;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.waterdropservice.entity.cfg.CfgDispatchRoute;
import com.teekee.waterdropservice.entity.pjt.PjtProject;
import com.teekee.waterdropservice.mapper.cfg.CfgDispatchRouteDetailMapper;
import com.teekee.waterdropservice.mapper.cfg.CfgDispatchRouteMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCompanyInfoMapper;
import com.teekee.waterdropservice.mapper.pjt.PjtProjectMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyUsersMapper;
import com.teekee.waterdropservice.mapper.sys.SysConsoleUsersMapper;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 项目规则
 * @author: zhangshuai
 * @create: 2019-01-03 09:59
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CfgDispatchRouteService extends BaseService<CfgDispatchRouteMapper,CfgDispatchRoute> {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgDispatchRouteMapper cfgDispatchRouteMapper;

    @Autowired
    private SysConsoleUsersMapper sysConsoleUsersMapper;

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private CfgDispatchRouteDetailMapper cfgDispatchRouteDetailMapper;

    @Autowired
    private PjtProjectMapper pjtProjectMapper;

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    /**
     * 分页查询项目规则配置列表
     * @param cfgDispatchRoute
     * @return
     */
    public Result findPage(CfgDispatchRoute cfgDispatchRoute){
        PageHelper.startPage(cfgDispatchRoute.getPageNum(), cfgDispatchRoute.getPageSize());
        List<CfgDispatchRoute> persons = cfgDispatchRouteMapper.selectAll(cfgDispatchRoute);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<CfgDispatchRoute> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }


    /**
     * 项目人员列表
     * @param id
     * @return
     */
    public Result findPerson(Integer id){
        CfgDispatchRoute cfgDispatchRoute = cfgDispatchRouteMapper.selectByPrimaryKey(id);
        String[] ids = {};
        if(cfgDispatchRoute != null && cfgDispatchRoute.getPersons() != null && cfgDispatchRoute.getPersons().length()>0){
            ids = cfgDispatchRoute.getPersons().split(",");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("sysUsers",sysCompanyUsersMapper.selectByCompanyType("PLATFORM")); //平台自营
        map.put("cfgUsers",sysCompanyUsersMapper.selectByRouteCfg(ids));
        return ResultUtil.success(map);
    }



    /**
     * 获取公司列表
     * @return
     */
    public Result findCompanyList(){
        return ResultUtil.success(dmiCompanyInfoMapper.companyByUserList(CurrentUtil.getCompanyIds(CurrentUtil.getCurrent().getId())));
    }


    /**
     * 根据公司id获取项目列表
     * @param companyId
     * @return
     */
    public Result findProjectByCompany(Integer companyId){
        PjtProject pjtProject = new PjtProject();
        pjtProject.setCompanyId(companyId);
        return ResultUtil.success(pjtProjectMapper.selectAll(pjtProject));
    }


    /**
     * 保存/编辑项目规则配置
     * @param cfgDispatchRoute
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdate(CfgDispatchRoute cfgDispatchRoute){
        if(cfgDispatchRoute != null && cfgDispatchRoute.getId() != null && cfgDispatchRoute.getId() != 0){
            logger.info("进入更新操作");
            cfgDispatchRouteMapper.updateByPrimaryKeySelective(cfgDispatchRoute);
        }else {
            logger.info("进入保存操作");
            if(cfgDispatchRoute != null){
                if(cfgDispatchRoute.getFlagDefault() && cfgDispatchRouteMapper.selectByIsNoDefault()>0){
                    return ResultUtil.errorBusinessMsg("默认项目只允许一条");
                }

                if(cfgDispatchRoute.getFlagProject()==false &&  cfgDispatchRouteMapper.selectByIsNoProject()>0){
                    return ResultUtil.errorBusinessMsg("非特定项目只允许一条");
                }
            }
            cfgDispatchRoute.setCreatePerson(CurrentUtil.getCurrent().getId());
            cfgDispatchRoute.setFlagTakeStatus(false);
            cfgDispatchRoute.setCreateTime(new Date());
            cfgDispatchRouteMapper.insertSelective(cfgDispatchRoute);
        }
        return ResultUtil.success();
    }


    /**
     * 删除项目规则配置
     * @param id
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result deleteCfg(Integer id){
        if(id != null){
            CfgDispatchRoute cfgDispatchRoute = cfgDispatchRouteMapper.selectByPrimaryKey(id);
            if(cfgDispatchRoute != null && cfgDispatchRoute.getFlagTakeStatus()==false){
                logger.info("删除项目规则配置");
                cfgDispatchRouteMapper.deleteByPrimaryKey(id);
                logger.info("删除项目细则配置");
                cfgDispatchRouteDetailMapper.deleteByRoute(id);
                return ResultUtil.success();
            }else{
                return ResultUtil.errorBusinessMsg("删除失败，请先停用项目");
            }

        }
        return ResultUtil.validateError("");
    }

}

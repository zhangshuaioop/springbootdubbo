package com.company.springboot.utils;

import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.wp.WpFrameProcess;
import com.company.springboot.entity.wp.WpProcessOperateLog;
import com.company.springboot.mapper.sys.SysCompanyRelationMapper;
import com.company.springboot.mapper.wp.WpFrameProcessMapper;
import com.company.springboot.mapper.wp.WpProcessOperateLogMapper;
import com.company.springboot.service.wp.WpCfgFrameProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2018-12-12 21:58
 */
@Component
public class CurrentUtil {


    /**
     * 系统公司关系
     */
    @Autowired
    private SysCompanyRelationMapper sysCompanyRelationMapper;

    /**
     * 框架流程配置
     */
    @Autowired
    private WpCfgFrameProcessService wpCfgFrameProcessService;

    /**
     * 流程操作日志Mapper
     */
    @Autowired
    private WpProcessOperateLogMapper wpProcessOperateLogMapper;

    /**
     * 框架流程Mapper
     */
    @Autowired
    private WpFrameProcessMapper wpFrameProcessMapper;

    private static CurrentUtil currentUtilService;

    public CurrentUtil(){
        super();
    }


    /* 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
	类似于Servlet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。*/
    @PostConstruct
    public void init() {
        System.out.println("实例化成功");
        currentUtilService = this;
        currentUtilService.sysCompanyRelationMapper = this.sysCompanyRelationMapper; //系统公司关系
        currentUtilService.wpCfgFrameProcessService = this.wpCfgFrameProcessService;  //框架流程配置
        currentUtilService.wpProcessOperateLogMapper = this.wpProcessOperateLogMapper; //流程操作日志
        currentUtilService.wpFrameProcessMapper = this.wpFrameProcessMapper; //框架流程Mapper

    }

    /**
     * 关联公司及本公司
     * @param userId
     * @return
     */
    public static String getCompanyIds(Integer userId) {
        return currentUtilService.sysCompanyRelationMapper.selectCompanyIds(userId);
    }

    /**
     * 登陆用户信息
     * @return
     */
    public static SysCompanyUsers getCurrent() {
        SysCompanyUsers sysCompanyUsers = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            sysCompanyUsers = (SysCompanyUsers) authentication.getCredentials();
        }
        return sysCompanyUsers;
    }


    /**
     * 权限
     * @return
     */
    public static Collection<? extends GrantedAuthority> getCurrentRole() {
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            collection = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        }
        return collection;
    }


    /**
     * 流程自动化-下一个处理人
     * @param orderId   订单id
     * @return
     */
    public static Result nextDeal(Integer orderId) {
        WpFrameProcess wpFrameProcess = currentUtilService.wpFrameProcessMapper.selectByOrderId(orderId);
        Result result = currentUtilService.wpCfgFrameProcessService.nextDeal(orderId,wpFrameProcess.getId());
        return result;
    }


    /**
     * 流程自动化-上一个处理人
     * @param orderId   订单id
     * @return
     */
    public static Result topDeal(Integer orderId) {
        WpFrameProcess wpFrameProcess = currentUtilService.wpFrameProcessMapper.selectByOrderId(orderId);
        Result result = currentUtilService.wpCfgFrameProcessService.topDeal(orderId,wpFrameProcess.getId());
        return result;
    }

    /**
     * 流程自动化-日志记录
     * @param wpProcessOperateLog   流程操作日志
     * @return
     */
    public static Result recordLog(WpProcessOperateLog wpProcessOperateLog) {
        WpFrameProcess wpFrameProcess = currentUtilService.wpFrameProcessMapper.selectByOrderId(wpProcessOperateLog.getOrderId());
        wpProcessOperateLog.setFrameProcessId(wpFrameProcess.getId());  //框架流程ID
        wpProcessOperateLog.setCfgProcessStepId(wpFrameProcess.getCurrentProcessStepId());//当前步骤ID
        wpProcessOperateLog.setOperatePerson(getCurrent().getId());    //当前处理人id
        wpProcessOperateLog.setOperateTime(new Date());
        currentUtilService.wpProcessOperateLogMapper.insertSelective(wpProcessOperateLog);
        return ResultUtil.success();
    }


}

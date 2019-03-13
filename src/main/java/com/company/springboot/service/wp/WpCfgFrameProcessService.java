package com.company.springboot.service.wp;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.fdp.FdpFaultDispatchOrder;
import com.company.springboot.entity.fdp.FdpFaultOrderDispatchRequest;
import com.company.springboot.entity.sys.SysCompanyUserRoleRelation;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.wp.*;
import com.company.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.company.springboot.mapper.fdp.FdpFaultOrderDispatchRequestMapper;
import com.company.springboot.mapper.sys.SysCompanyUserRoleRelationMapper;
import com.company.springboot.mapper.sys.SysCompanyUsersMapper;
import com.company.springboot.mapper.wp.*;
import com.company.springboot.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 框架流程配置
 * @author: zhangshuai
 * @create: 2019-01-24 10:43
 */
@Service
public class WpCfgFrameProcessService extends BaseService<WpCfgFrameProcessMapper, WpCfgFrameProcess> {

    private Logger log = Logger.getLogger(Logger.class);
    @Resource
    private WpCfgFrameProcessMapper wpCfgFrameProcessMapper;
    @Resource
    private WpCfgFrameProcessVersionMapper wpCfgFrameProcessVersionMapper;
    @Resource
    private WpFrameProcessMapper wpFrameProcessMapper;
    @Resource
    private WpCfgProcessStepMapper wpCfgProcessStepMapper;
    @Resource
    private WpCfgProcessMapper wpCfgProcessMapper;
    @Resource
    private WpProcessOperateLogMapper wpProcessOperateLogMapper;
    @Resource
    private SysCompanyUserRoleRelationMapper sysCompanyUserRoleRelationMapper;
    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;
    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    public Result list(WpCfgFrameProcess wpCfgFrameProcess) {
        if (wpCfgFrameProcess.getCompanyId() == null || wpCfgFrameProcess.getCompanyId() == 0) {
            return ResultUtil.validateError("参数错误");
        }
        if (wpCfgFrameProcess.getPageNum() != null && wpCfgFrameProcess.getPageSize() != null) {
            PageHelper.startPage(wpCfgFrameProcess.getPageNum(), wpCfgFrameProcess.getPageSize());
            Page<WpCfgFrameProcess> persons = wpCfgFrameProcessMapper.findPage(wpCfgFrameProcess);
            PageInfo<WpCfgFrameProcess> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<WpCfgFrameProcess> list = wpCfgFrameProcessMapper.findPage(wpCfgFrameProcess);
            return ResultUtil.success(list);
        }
    }


    /**
     * 框架流程列表
     *
     * @return
     */
    public Result findList() {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        return ResultUtil.success(wpCfgFrameProcessMapper.selectList(sysCompanyUsers));
    }


    public Result handle(WpCfgFrameProcess wpCfgFrameProcess) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Date now = new Date();
        wpCfgFrameProcess.setUpdateTime(now);
        wpCfgFrameProcess.setUpdatePerson(sysCompanyUsers.getId());
        if (wpCfgFrameProcess.getId() != null && wpCfgFrameProcess.getId() > 0) {

            wpCfgFrameProcessMapper.updateByPrimaryKeySelective(wpCfgFrameProcess);
            if (wpCfgFrameProcess.getFlagEnable() != null) {

                log.info("查询框架最大版本");
                Integer version = wpCfgFrameProcessVersionMapper.selectVersion();

                WpCfgFrameProcessVersion wpCfgFrameProcessVersion = new WpCfgFrameProcessVersion();
                wpCfgFrameProcessVersion.setCfgFrameProcessId(wpCfgFrameProcess.getId());

                if (version == null) {
                    wpCfgFrameProcessVersion.setVersion(1);
                } else {
                    wpCfgFrameProcessVersion.setVersion(version + 1);
                }

                wpCfgFrameProcessVersion.setCreatePerson(sysCompanyUsers.getId());
                wpCfgFrameProcessVersion.setCreateTime(now);
                wpCfgFrameProcessVersion.setFlagAvaliable(true);
                wpCfgFrameProcessVersion.setFlagIsLast(true);
                wpCfgFrameProcessVersion.setUpdatePerson(sysCompanyUsers.getId());
                wpCfgFrameProcessVersion.setUpdateTime(now);
                wpCfgFrameProcessVersionMapper.insertSelective(wpCfgFrameProcessVersion);
            }
        } else {
            wpCfgFrameProcess.setCreateTime(now);
            wpCfgFrameProcess.setCreatePerson(sysCompanyUsers.getId());
            wpCfgFrameProcess.setFlagAvaliable(true);
            wpCfgFrameProcess.setFlagDeleted(false);
            wpCfgFrameProcess.setFlagTested(false);
            String str = sdf.format(now);
            str = str.substring(2, str.length());
            wpCfgFrameProcess.setFrameProcessCode("FRA" + "_" + str + "_" + getRandom());
            wpCfgFrameProcessMapper.insertSelective(wpCfgFrameProcess);

            log.info("查询框架最大版本");
            Integer version = wpCfgFrameProcessVersionMapper.selectVersion();

            WpCfgFrameProcessVersion wpCfgFrameProcessVersion = new WpCfgFrameProcessVersion();
            wpCfgFrameProcessVersion.setCfgFrameProcessId(wpCfgFrameProcess.getId());
            if (version == null) {
                wpCfgFrameProcessVersion.setVersion(1);
            } else {
                wpCfgFrameProcessVersion.setVersion(version + 1);
            }
            wpCfgFrameProcessVersion.setCreatePerson(sysCompanyUsers.getId());
            wpCfgFrameProcessVersion.setCreateTime(now);
            wpCfgFrameProcessVersion.setFlagAvaliable(true);
            wpCfgFrameProcessVersion.setFlagIsLast(true);
            wpCfgFrameProcessVersion.setUpdatePerson(sysCompanyUsers.getId());
            wpCfgFrameProcessVersion.setUpdateTime(now);
            wpCfgFrameProcessVersionMapper.insertSelective(wpCfgFrameProcessVersion);
        }

        return ResultUtil.success();
    }

    private String getRandom() {
        String result = "";
        while (result.length() < 3) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;

    }

    /**
     * 　* @Description: 下一步处理人
     * 　* @param orderId 工单id
     * 　* @param frameProcessId 框架流程id
     * 　* @return Result
     * 　* @throws
     * 　* @author zhanghao
     * 　* @date 2019/2/27 上午10:39
     */
    public Result nextDeal(Integer orderId, Integer frameProcessId) {
        WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.findWpCfgProcessNextStepByWpFrameProcessId(frameProcessId);
        if (wpCfgProcessStep != null) {
            WpFrameProcess wpFrameProcess = new WpFrameProcess();
            wpFrameProcess.setId(frameProcessId);
            if (wpCfgProcessStep.getUnitType().equals("END")) {
                //找下一个框架流程的第一步有效子流程
                WpCfgProcessStep wpCfgProcessStep1 = wpCfgProcessStepMapper.findWpCfgProcessNextStepByWpCfgProcessStepId(wpCfgProcessStep.getId());
                if (wpCfgProcessStep1 != null) {
                    //保存框架流程 当前流程步骤id
                    wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep1.getId());
                    //设置下一步子流程缓存
                    redis(orderId, frameProcessId,wpCfgProcessStep1.getId());
                } else {
                    //保存框架流程 当前流程步骤id
                    wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep.getId());
                    //设置下一步子流程缓存
                    redis(orderId, frameProcessId,wpCfgProcessStep.getId());
                }
            } else {
                //保存框架流程 当前流程步骤id
                wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep.getId());
                //设置下一步子流程缓存
                redis(orderId, frameProcessId,wpCfgProcessStep.getId());
            }
            wpFrameProcessMapper.updateByPrimaryKeySelective(wpFrameProcess);
            //修改派工/采购工单处理人
            updatePerson(orderId, frameProcessId);

        }
        return ResultUtil.success();
    }


    /**
     * 　* @Description: 上一步处理人
     * 　* @param orderId 工单id
     * 　* @param frameProcessId 框架流程id
     * 　* @return Result
     * 　* @throws
     * 　* @author zhanghao
     * 　* @date 2019/2/27 上午10:39
     */
    public Result topDeal(Integer orderId, Integer frameProcessId) {
        WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.findWpCfgProcessTopStepByWpFrameProcessId(frameProcessId);
        if (wpCfgProcessStep != null) {
            //保存框架流程 当前流程步骤id
            WpFrameProcess wpFrameProcess = new WpFrameProcess();
            wpFrameProcess.setId(frameProcessId);
            if (wpCfgProcessStep.getUnitType().equals("START")) {
                //找上一个框架流程的最后一步有效子子流程
                WpCfgProcessStep wpCfgProcessStep1 = wpCfgProcessStepMapper.findWpCfgProcessTopStepByWpCfgProcessStepId(wpCfgProcessStep.getId());
                if (wpCfgProcessStep1 != null) {
                    wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep1.getId());
                    //设置下一步子流程缓存
                    redis(orderId, frameProcessId, wpCfgProcessStep1.getId());
                } else {
                    wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep.getId());
                    //设置下一步子流程缓存
                    redis(orderId, frameProcessId, wpCfgProcessStep.getId());
                }
            } else {
                wpFrameProcess.setCurrentProcessStepId(wpCfgProcessStep.getId());
                //设置下一步子流程缓存
                redis(orderId, frameProcessId, wpCfgProcessStep.getId());
            }
            wpFrameProcessMapper.updateByPrimaryKeySelective(wpFrameProcess);
            //修改派工/采购工单处理人
            updatePerson(orderId, frameProcessId);

        }

        return ResultUtil.success();
    }

    public Result updatePerson(Integer orderId, Integer frameProcessId) {
        FdpFaultDispatchOrder fdpFaultDispatchOrder = fdpFaultDispatchOrderMapper.selectByPrimaryKey(orderId);
        if (fdpFaultDispatchOrder != null) {
            //订单框架流程查询
            WpFrameProcess wpFrameProcess = wpFrameProcessMapper.selectByPrimaryKey(frameProcessId);
            if (wpFrameProcess != null) {
                //修改采购工单最后处理人
                FdpFaultDispatchOrder fdpFaultDispatchOrder1 = new FdpFaultDispatchOrder();
                fdpFaultDispatchOrder1.setId(orderId);
                fdpFaultDispatchOrder1.setLastDealPersonId(wpFrameProcess.getPurchaseCreatePerson());
                fdpFaultDispatchOrderMapper.updateByPrimaryKeySelective(fdpFaultDispatchOrder1);

                //修改派工工单最后处理人
                FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest = new FdpFaultOrderDispatchRequest();
                fdpFaultOrderDispatchRequest.setId(fdpFaultDispatchOrder.getFaultDispatchRequestId());
                fdpFaultOrderDispatchRequest.setCreatePerson(wpFrameProcess.getCreatePerson());
                fdpFaultOrderDispatchRequestMapper.updateByPrimaryKeySelective(fdpFaultOrderDispatchRequest);
            }
        }

        return ResultUtil.success();
    }


    public Result approval(WpApproval wpApproval) {
        Date now = new Date();
        if (wpApproval == null) {
            ResultUtil.errorBusinessMsg("参数错误");
        }

        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(wpApproval.getOrderId());
        wpProcessOperateLog.setDescription(wpApproval.getDescription());
        //审批拒绝
        if (wpApproval.getStatus() == 0) {
            wpProcessOperateLog.setOperateResult("NO");
            //找存上一步处理人
            topDeal(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
        }
        //审批通过
        if (wpApproval.getStatus() == 1) {
            wpProcessOperateLog.setOperateResult("YES");
            //订单框架流程查询
            WpFrameProcess wpFrameProcess = wpFrameProcessMapper.selectByPrimaryKey(wpApproval.getFrameProcessId());
            if (wpFrameProcess != null) {
                //子流程步骤查询
                WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.selectByPrimaryKey(wpFrameProcess.getCurrentProcessStepId());
                //无审批人规则 直接下一步
                if ("NEXTSTEP".equals(wpCfgProcessStep.getDefaultNoOperatorRule())) {
                    //找存下一步处理人
                    nextDeal(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
                } else {
                    Map<Object, Object> map = findRedis(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
                    Integer userCount = Integer.parseInt(map.get("userCount") + "");
                    ArrayList<Integer> list = (ArrayList<Integer>) map.get("users");
                    String executionRules = wpCfgProcessStep.getExecutionRules();
                    Integer executionRulesNumber = wpCfgProcessStep.getExecutionRulesNumber();
                    switch (executionRules) {
                        //按照百分比
                        case "PERCENT":
                            if (list != null && list.size() > 0) {
                                Iterator<Integer> it = list.iterator();
                                while (it.hasNext()) {
                                    if (CurrentUtil.getCurrent().getId().equals(it.next())) {
                                        it.remove();
                                    }
                                }
                                if (list.size() / userCount >= executionRulesNumber || (list.size() == 0)) {
                                    //找存下一步处理人
                                    nextDeal(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
                                } else {
                                    map.put("users", list);
                                    //更新缓存
                                    RedisUtil.setMap(wpApproval.getOrderId() + "_" + wpApproval.getFrameProcessId(), map);
                                }
                            }
                            break;
                        //按照人数
                        case "NUMBER":
                            if (list != null && list.size() > 0) {
                                Iterator<Integer> it = list.iterator();
                                while (it.hasNext()) {
                                    if (CurrentUtil.getCurrent().getId().equals(it.next())) {
                                        it.remove();
                                    }
                                }

                                //当总人数减去未审核的人数等于已审核的人数
                                if ((userCount - list.size() == executionRulesNumber) || (list.size() == 0)) {
                                    //找存下一步处理人
                                    nextDeal(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
                                } else {
                                    map.put("users", list);
                                    //更新缓存
                                    RedisUtil.setMap(wpApproval.getOrderId() + "_" + wpApproval.getFrameProcessId(), map);
                                }
                            }
                            break;
                        default:
                            //找存下一步处理人
                            nextDeal(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
                            break;
                    }
                }
            }
        }
        //审批转发
        if (wpApproval.getStatus() == 2) {
            wpProcessOperateLog.setOperateResult("TRANSFER");
            Map<Object, Object> map = findRedis(wpApproval.getOrderId(), wpApproval.getFrameProcessId());
            ArrayList<Integer> list = (ArrayList<Integer>) map.get("users");
            if (list != null && list.size() > 0) {
                if (list.size() > 1) {
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        if (CurrentUtil.getCurrent().getId().equals(it.next())) {
                            it.remove();
                        }
                    }
                    list.add(wpApproval.getForwardId());
                } else {
                    list = new ArrayList<Integer>();
                    list.add(wpApproval.getForwardId());
                }
            }
            map.put("users", list);
            //更新缓存
            RedisUtil.setMap(wpApproval.getOrderId() + "_" + wpApproval.getFrameProcessId(), map);

        }


        WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.selectByOrderId(wpApproval.getOrderId());
        Long nowDate = Long.valueOf(DateUtil.getLongDateString(now)).longValue();
        //获取上个节点的日志的保存时间
        //查询上个节点的信息
        WpCfgProcessStep lastWpCfgProcessStep = wpCfgProcessStepMapper.selectLast(wpCfgProcessStep.getStepCode());
        WpProcessOperateLog lastWpProcessOperateLog = new WpProcessOperateLog();
        //判断上一节点是否为汇合节点
        if (lastWpCfgProcessStep.getUnitType().equals("GATHER")) {
            //查汇合节点的上一节点
            lastWpCfgProcessStep = wpCfgProcessStepMapper.selectLast(lastWpCfgProcessStep.getStepCode());
            //获取上个节点的日志信息的最后一条
            lastWpProcessOperateLog = wpProcessOperateLogMapper.selectByProcessStep(lastWpCfgProcessStep.getId(), wpApproval.getFrameProcessId());
        } else {
            //获取上个节点的日志信息的最后一条
            lastWpProcessOperateLog = wpProcessOperateLogMapper.selectByProcessStep(lastWpCfgProcessStep.getId(), wpApproval.getFrameProcessId());
        }
        if (lastWpProcessOperateLog != null) {
            Long lastTime = Long.valueOf(DateUtil.getLongDateString(lastWpProcessOperateLog.getOperateTime())).longValue();
            Long differenceTime = nowDate - lastTime;
            Long minute = (Long) differenceTime / 3600;
            int timeUsed = new Long(minute).intValue();

            //判断是否延期
            Boolean flagTimeout = false;
            if (wpCfgProcessStep.getTimeExamMinute() - timeUsed > 0) {
                flagTimeout = false;
            } else {
                flagTimeout = true;
            }
            wpProcessOperateLog.setFlagTimeout(flagTimeout);
            wpProcessOperateLog.setTimeUsed(timeUsed);
        }

        wpProcessOperateLog.setPhotosUrl(wpApproval.getPhotosUrl());
        wpProcessOperateLog.setPhotosName(wpApproval.getPhotosName());
        wpProcessOperateLog.setFilesUrl(wpApproval.getFilesUrl());
        wpProcessOperateLog.setFilesName(wpApproval.getFilesName());
        //保存日志
        CurrentUtil.recordLog(wpProcessOperateLog);

        return ResultUtil.success();
    }

    public Result frameLog(WpProcessOperateLog wpProcessOperateLog) {
        PageHelper.startPage(wpProcessOperateLog.getPageNum(), wpProcessOperateLog.getPageSize());
        Page<WpProcessOperateLog> persons = wpProcessOperateLogMapper.findPage(wpProcessOperateLog);
        PageInfo<WpProcessOperateLog> pageInfo = new PageInfo<>(persons);
        if (pageInfo.getList() == null || pageInfo.getList().size() == 0) {
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("pageInfo",pageInfo);
        Map<Object, Object> stepMap = RedisUtil.getMap(wpProcessOperateLog.getOrderId() + "_" + wpProcessOperateLog.getFrameProcessId());
        ArrayList<Integer> list = (ArrayList<Integer>) stepMap.get("users");
        ArrayList<String> users = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i=0;i< list.size();i++) {
                SysCompanyUsers sysCompanyUsers= sysCompanyUsersMapper.selectByPrimaryKey(list.get(i));
                users.add(sysCompanyUsers.getNickname());
            }
        }
        stepMap.put("user",users);

        Integer stepId= Integer.parseInt(stepMap.get("stepId")+"");
        WpCfgProcessStep wpCfgProcessStep= wpCfgProcessStepMapper.selectByPrimaryKey(stepId);
        if(wpCfgProcessStep!=null){
            stepMap.put("stepName",wpCfgProcessStep.getStepName());
        }else{
            stepMap.put("stepName","");
        }
        map.put("stepInfo",stepMap);
        return ResultUtil.success(map);
    }


    /**
     * 　* @Description: 查询当前子流程缓存
     * 　* @param orderId
     * 　* @param frameProcessId
     * 　* @return map
     * 　* @author zhanghao
     * 　* @date 2019/2/22 上午11:26
     */
    public Map<Object, Object> findRedis(Integer orderId, Integer frameProcessId) {
        Map<Object, Object> map = RedisUtil.getMap(orderId + "_" + frameProcessId);
        //判断缓存对象
        if (map == null || map.isEmpty() || map.size() < 1) {
            map = new HashMap<Object, Object>();
           WpFrameProcess wpFrameProcess= wpFrameProcessMapper.selectByPrimaryKey(frameProcessId);
           if(wpFrameProcess!=null){
               //子流程查询
               WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.selectByPrimaryKey(wpFrameProcess.getCurrentProcessStepId());
               if (wpCfgProcessStep != null) {
                   //操作人员类型，SELF：本人，PERSON：某人，ORGANIZATION：部门，ROLE：角色，NONE：不需要操作
                   String operatorType = wpCfgProcessStep.getOperatorType();
                   List<Integer> listUser = new ArrayList<Integer>();
                   switch (operatorType) {
                       case "ORGANIZATION":
                           map.put("userCount", 0);
                           break;
                       case "ROLE":
                           Integer roleId = Integer.parseInt(wpCfgProcessStep.getOperatorId());
                           SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
                           sysCompanyUserRoleRelation.setRoleId(roleId);
                           sysCompanyUserRoleRelation.setFlagDeleted(false);
                           WpCfgProcess wpCfgProcess = wpCfgProcessMapper.selectByPrimaryKey(wpCfgProcessStep.getCfgProcessId());
                           sysCompanyUserRoleRelation.setCompanyId(wpCfgProcess.getCompanyId());
                           List<SysCompanyUserRoleRelation> list = sysCompanyUserRoleRelationMapper.selectRole(sysCompanyUserRoleRelation);
                           for (SysCompanyUserRoleRelation sys : list) {
                               listUser.add(sys.getUserId());
                           }
                           map.put("userCount", listUser.size());
                           break;
                       case "PERSON":
                           listUser.add(Integer.parseInt(wpCfgProcessStep.getOperatorId()));
                           map.put("userCount", 1);
                           break;
                       case "SELF":
                           if (wpFrameProcess != null) {
                               WpCfgFrameProcess wpCfgFrameProcess = wpCfgFrameProcessMapper.selectByPrimaryKey(wpFrameProcess.getFrameProcessCfgId());
                               if (wpCfgFrameProcess != null) {
                                   wpCfgProcess = wpCfgProcessMapper.selectByPrimaryKey(wpCfgProcessStep.getCfgProcessId());
                                   if (wpCfgProcess.getCompanyId().equals(wpCfgFrameProcess.getCompanyId())) {
                                       listUser.add(wpFrameProcess.getCreatePerson());
                                   } else {
                                       listUser.add(wpFrameProcess.getPurchaseCreatePerson());
                                   }
                               }
                           }
                           map.put("userCount", 1);
                           break;
                       default:
                           map.put("userCount", 0);
                           break;
                   }


                   map.put("stepId", wpCfgProcessStep.getId());
                   map.put("users", listUser);
                   map.put("operateType", wpCfgProcessStep.getOperateType());
                   //设置缓存
                   RedisUtil.setMap(orderId + "_" + frameProcessId, map);
               }
           }
        }
        log.info("获取当前子流程redis缓存对象 key:" + orderId + "_" + frameProcessId + " value:" + map);

        return map;
    }

    /**
     * 　* @Description: 根据子流程id 设置子流程缓存
     * 　* @param orderId
     * 　* @param frameProcessId
     * 　* @return map
     * 　* @author zhanghao
     * 　* @date 2019/2/22 上午11:26
     */
    public Map<Object, Object> redis(Integer orderId, Integer frameProcessId, Integer wpCfgProcessStepId) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        //子流程查询
        WpCfgProcessStep wpCfgProcessStep = wpCfgProcessStepMapper.selectByPrimaryKey(wpCfgProcessStepId);
        if (wpCfgProcessStep != null) {
            //操作人员类型，SELF：本人，PERSON：某人，ORGANIZATION：部门，ROLE：角色，NONE：不需要操作
            String operatorType = wpCfgProcessStep.getOperatorType();
            List<Integer> listUser = new ArrayList<Integer>();
            switch (operatorType) {
                case "ORGANIZATION":
                    map.put("userCount", 0);
                    break;
                case "ROLE":
                    Integer roleId = Integer.parseInt(wpCfgProcessStep.getOperatorId());
                    SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
                    sysCompanyUserRoleRelation.setRoleId(roleId);
                    sysCompanyUserRoleRelation.setFlagDeleted(false);
                    WpCfgProcess wpCfgProcess = wpCfgProcessMapper.selectByPrimaryKey(wpCfgProcessStep.getCfgProcessId());
                    sysCompanyUserRoleRelation.setCompanyId(wpCfgProcess.getCompanyId());
                    List<SysCompanyUserRoleRelation> list = sysCompanyUserRoleRelationMapper.selectRole(sysCompanyUserRoleRelation);
                    for (SysCompanyUserRoleRelation sys : list) {
                        listUser.add(sys.getUserId());
                    }
                    map.put("userCount", listUser.size());
                    break;
                case "PERSON":
                    listUser.add(Integer.parseInt(wpCfgProcessStep.getOperatorId()));
                    map.put("userCount", 1);
                    break;
                case "SELF":
                    WpFrameProcess wpFrameProcess = wpFrameProcessMapper.selectByPrimaryKey(frameProcessId);
                    if (wpFrameProcess != null) {
                        WpCfgFrameProcess wpCfgFrameProcess = wpCfgFrameProcessMapper.selectByPrimaryKey(wpFrameProcess.getFrameProcessCfgId());
                        if (wpCfgFrameProcess != null) {
                            wpCfgProcess = wpCfgProcessMapper.selectByPrimaryKey(wpCfgProcessStep.getCfgProcessId());
                            if (wpCfgProcess.getCompanyId().equals(wpCfgFrameProcess.getCompanyId())) {
                                listUser.add(wpFrameProcess.getCreatePerson());
                            } else {
                                listUser.add(wpFrameProcess.getPurchaseCreatePerson());
                            }
                        }
                    }
                    map.put("userCount", 1);
                    break;
                default:
                    map.put("userCount", 0);
                    break;
            }


            map.put("stepId", wpCfgProcessStepId);
            map.put("users", listUser);
            map.put("operateType", wpCfgProcessStep.getOperateType());
            //设置缓存
            RedisUtil.setMap(orderId + "_" + frameProcessId, map);
        }
        log.info("获取下一步子流程redis缓存对象 key:" + orderId + "_" + frameProcessId + " value:" + map);

        return map;
    }
}

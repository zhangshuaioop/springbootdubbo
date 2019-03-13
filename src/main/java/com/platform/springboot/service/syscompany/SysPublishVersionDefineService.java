package com.platform.springboot.service.syscompany;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.syscompany.SysPublishVersionDefine;
import com.platform.springboot.entity.syscompany.SysPublishVersionPermission;
import com.platform.springboot.mapper.syscompany.SysPublishVersionDefineMapper;
import com.platform.springboot.mapper.syscompany.SysPublishVersionPermissionMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:系统发布版本
 * @author: zhangshuai
 * @create: 2018-12-29 17:17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysPublishVersionDefineService extends BaseService<SysPublishVersionDefineMapper,SysPublishVersionDefine> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysPublishVersionDefineMapper sysPublishVersionDefineMapper;

    @Autowired
    private SysPublishVersionPermissionMapper sysPublishVersionPermissionMapper;

    /**
     * 分页列表
     * @param sysPublishVersionDefine
     * @return
     */
    public Result findPage(SysPublishVersionDefine sysPublishVersionDefine){

        PageHelper.startPage(sysPublishVersionDefine.getPageNum(), sysPublishVersionDefine.getPageSize());
        Page<SysPublishVersionDefine> persons = sysPublishVersionDefineMapper.findPage(sysPublishVersionDefine);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysPublishVersionDefine> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }


    /**
     * 赋予版本功能
     * @param sysPublishVersionPermission
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateVersionPermission(SysPublishVersionPermission sysPublishVersionPermission){
        try {
            logger.info("删除版本功能");
            sysPublishVersionPermissionMapper.deleteByVersionId(sysPublishVersionPermission);
            logger.info("保存版本功能");
            sysPublishVersionPermissionMapper.saveVersionPermission(sysPublishVersionPermission.getVersionId(),CurrentUtil.getCurrent().getId(),
                    sysPublishVersionPermission.getPermissionIds().split(","));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }


}

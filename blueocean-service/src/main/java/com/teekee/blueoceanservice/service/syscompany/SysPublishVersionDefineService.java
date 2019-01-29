package com.teekee.blueoceanservice.service.syscompany;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.syscompany.SysPublishVersionDefine;
import com.teekee.blueoceanservice.entity.syscompany.SysPublishVersionPermission;
import com.teekee.blueoceanservice.mapper.syscompany.SysPublishVersionDefineMapper;
import com.teekee.blueoceanservice.mapper.syscompany.SysPublishVersionPermissionMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
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

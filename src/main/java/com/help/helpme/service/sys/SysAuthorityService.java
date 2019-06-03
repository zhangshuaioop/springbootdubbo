package com.help.helpme.service.sys;

import com.help.helpme.base.BaseService;
import com.help.helpme.entity.sys.SysAuthority;
import com.help.helpme.entity.sys.SysRole;
import com.help.helpme.entity.sys.response.SysAuthorityRes;
import com.help.helpme.mapper.sys.SysAuthorityMapper;
import com.help.helpme.utils.Result;
import com.help.helpme.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 系统权限
 * @author: zhangshuai
 * @create: 2019-01-31 13:22
 */
@Service
public class SysAuthorityService extends BaseService<SysAuthorityMapper,SysAuthority> {

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    /**
     * 根据用户获取权限
     * @param adminId
     * @return
     */
    public List<SysAuthorityRes> findByAdminId(Long adminId){
        return sysAuthorityMapper.selectByAdminId(adminId);
    }


    /**
     * 系统权限列表
     * @param sysAuthority
     * @return
     */
    public List<SysAuthorityRes> findAllTree(SysAuthority sysAuthority){
        return sysAuthorityMapper.selectAllTree(sysAuthority);
    }


}

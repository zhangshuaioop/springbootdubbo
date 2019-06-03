package com.help.helpme.service.sys;

import com.github.pagehelper.PageHelper;
import com.help.helpme.base.BaseService;
import com.help.helpme.entity.sys.SysAdmin;
import com.help.helpme.entity.sys.SysAuthority;
import com.help.helpme.entity.sys.SysRole;
import com.help.helpme.entity.sys.response.SysAuthorityRes;
import com.help.helpme.mapper.sys.SysAuthorityMapper;
import com.help.helpme.mapper.sys.SysRoleMapper;
import com.help.helpme.utils.PageInfo;
import com.help.helpme.utils.Result;
import com.help.helpme.utils.ResultUtil;
import com.help.helpme.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 系统角色
 * @author: zhangshuai
 * @create: 2019-01-31 13:23
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleService extends BaseService<SysRoleMapper,SysRole> {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    /**
     * 分页系统角色列表
     * @param sysRole
     * @return
     */
    public Result findPage(SysRole sysRole){
        PageHelper.startPage(sysRole.getPageNum(), sysRole.getPageSize());
        List<SysRole> persons = sysRoleMapper.selectAll(sysRole);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysRole> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    /**
     * 编辑查询
     * @param id
     * @return
     */
    public Result edit(Long id){
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setFlagEnabled(true);
        sysAuthority.setRoleId(id);
        List<SysAuthorityRes> sysAuthoritiesTree = TreeUtils.formatTree(sysAuthorityMapper.selectByRoleIdTree(sysAuthority),false);
        Map<String,Object> map = new HashMap<>();
        map.put("sysRole",sysRole);
        map.put("sysAuthoritiesTree",sysAuthoritiesTree);
        return ResultUtil.success(map);
    }

}

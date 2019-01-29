package com.teekee.blueoceanservice.mapper.sysconsole;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysConsoleUsersMapper extends BaseMapper<SysConsoleUsers> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysConsoleUsers selectByUserName(String username);

    /**
     * 查看接单路径配置关联用户
     * @param ids
     * @return
     */
    List<SysConsoleUsers> selectByRouteCfg(@Param("ids") String[] ids);

    List<SysConsoleUsers> findUserList();
}
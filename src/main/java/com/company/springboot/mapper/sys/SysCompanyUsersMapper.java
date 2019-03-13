package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.fdp.FdpFaultOrderDispatchRequest;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.sys.response.SysCompanyUsersAdminRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysCompanyUsersMapper extends BaseMapper<SysCompanyUsers> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SysCompanyUsers selectByUserName(String username);

    List<SysCompanyUsers> findPersonOpen(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest);

    SysCompanyUsers selectVendorIdByCreatePersonId(Integer createPerson);

    String selectVendorName(Integer vendorId);

    List<SysCompanyUsers> selectApplyUser(Integer companyId);


    /**
     * 获取公司超级管理员账号
     * @param companyId
     * @return
     */
    SysCompanyUsersAdminRes selectByAdmin(Integer companyId);

    /**
     * 根据公司类型获取对应用户
     * @return
     */
    List<SysCompanyUsers> selectByCompanyType(String companyType);


    /**
     * 查看接单路径配置关联用户
     * @param ids
     * @return
     */
    List<SysCompanyUsers> selectByRouteCfg(@Param("ids") String[] ids);
}
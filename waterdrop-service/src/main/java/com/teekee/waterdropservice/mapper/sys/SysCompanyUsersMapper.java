package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderDispatchRequest;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.entity.sys.response.SysCompanyUsersAdminRes;
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
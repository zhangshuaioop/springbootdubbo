package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysCompanyPurchaseVersion;
import com.teekee.waterdropservice.entity.sys.SysPublishVersionPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysPublishVersionPermissionMapper extends BaseMapper<SysPublishVersionPermission> {

    /**
     * 删除版本功能
     * @param sysPublishVersionPermission
     */
    void deleteByVersionId(SysPublishVersionPermission sysPublishVersionPermission);

    /**
     * 保存版本功能
     * @param versionId
     * @param createPerson
     * @param permissionIds
     */
    void saveVersionPermission(@Param("versionId") Integer versionId,
                               @Param("createPerson") Integer createPerson,
                               @Param("permissionIds") String[] permissionIds);


    /**
     * 获取版本权限
     * @param sysCompanyPurchaseVersion
     * @return
     */
    String selectPermissionIds(SysCompanyPurchaseVersion sysCompanyPurchaseVersion);
}
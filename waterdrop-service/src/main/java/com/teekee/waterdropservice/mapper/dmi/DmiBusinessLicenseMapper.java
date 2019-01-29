package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.dmi.DmiBusinessLicense;
import com.teekee.waterdropservice.entity.dmi.DmiBusinessLicenseWithBLOBs;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DmiBusinessLicenseMapper extends BaseMapper<DmiBusinessLicense> {

    int insertSelective(DmiBusinessLicenseWithBLOBs record);

    DmiBusinessLicenseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiBusinessLicenseWithBLOBs record);

    Page<DmiBusinessLicense> selectByCompanyId(Integer companyId);

    /**
     * 根据公司名称以及公司id查询
     * @param companyName
     * @param companyId
     * @return
     */
    DmiBusinessLicense selectByCompanyName(@Param("companyName") String companyName, @Param("companyId") int companyId);
}
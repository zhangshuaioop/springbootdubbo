package com.platform.springboot.mapper.dmi;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiBusinessLicense;
import com.platform.springboot.entity.dmi.DmiBusinessLicenseWithBLOBs;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiBusinessLicense;
import com.platform.springboot.entity.dmi.DmiBusinessLicenseWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
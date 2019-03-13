package com.platform.springboot.mapper.dmi;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCompanyInfoMapper extends BaseMapper<DmiCompanyInfo> {


    /**
     * 根据公司名称查询
     * @param companyName
     * @return
     */
    DmiCompanyInfo selectCompanyName(String companyName);


    /**
     * 查询所有
     * @return
     */
    List<DmiCompanyInfo> findAll(DmiCompanyInfo dmiCompanyInfo);

    /**
     * 新增并获取自增主键
     * @param dmiCompanyInfo
     */
    void insertGetId(DmiCompanyInfo dmiCompanyInfo);


    /**
     * 查询独立公司(与平台关联)
     * @param dmiCompanyInfo
     * @return
     */
    List<DmiCompanyInfo> companyByFlagPlatform(DmiCompanyInfo dmiCompanyInfo);
}
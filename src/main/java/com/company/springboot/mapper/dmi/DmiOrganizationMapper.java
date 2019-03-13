package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiOrganization;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiOrganization;
import com.company.springboot.entity.dmi.res.DmiOrganizationRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DmiOrganizationMapper extends BaseMapper<DmiOrganization> {

    int insertSelective(DmiOrganization record);

    DmiOrganization selectByPrimaryKey(Integer id);

    int selectByBusinessLicenseId(Integer id);

    List<DmiOrganization> selectOrganizationListByCompanyId(Integer companyId);

    List<Map<String, Object>> selectByParentIdList(HashMap<String, Object> map);

    List<Map<String, Object>> selectByParentId(HashMap<String, Object> map);

    int updateByPrimaryKeySelective(DmiOrganization record);

    int selectMaxOrderByParentId(HashMap<String, Object> map);

    DmiOrganization getOragnizationByCompanyIdAndCode(DmiOrganization record);

    List<DmiOrganization> getIdListByCompanyIdAndCode(Map<String, Object> map);

    List<DmiOrganization> selectFirstOrgByCompanyId(Integer companyId);

    List<DmiOrganizationRes> selectOrganizationListByCompanyIdRes(Integer companyId);

    List<DmiOrganizationRes> selectOrganizationListByCompanyIdResChildren(Integer companyId);

    /**
     * 根据雇主id查询全国组织节点
     * @param belongCompanyId
     * @return
     */
    DmiOrganization selectByCompanyId(int belongCompanyId);
}
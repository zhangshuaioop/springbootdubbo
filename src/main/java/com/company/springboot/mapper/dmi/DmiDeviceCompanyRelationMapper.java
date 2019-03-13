package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiDeviceCompanyRelation;
import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifDevice;
import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.bif.BifDeviceRet;
import com.company.springboot.entity.dmi.DmiDeviceCompanyRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiDeviceCompanyRelationMapper extends BaseMapper<DmiDeviceCompanyRelation> {

    int insertSelective(DmiDeviceCompanyRelation record);

    DmiDeviceCompanyRelation selectByDeviceId(Integer deviceId);

    DmiDeviceCompanyRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiDeviceCompanyRelation record);

    List<BifDevice> queryDeviceNotInCompany();

    List<BifDevice> queryDeviceNotInCompanyByObject(BifDeviceInputParam record);

    Page<BifDeviceDetail> queryListByCompanyId(Integer companyId);

    List<BifDeviceRet> queryListByCompanyIdAndObject(BifDeviceInputParam record);
    List<BifDeviceRet> queryListByCompanyIdAndObjectForStore(BifDeviceInputParam record);
    List<BifDeviceRet> queryListByCompanyIdAndObjectForOrg(BifDeviceInputParam record);
    List<BifDeviceRet> queryListByCompanyIdAndObjectForPerson(BifDeviceInputParam record);

    Page<DmiDeviceCompanyRelation> queryBycompanyId(DmiDeviceCompanyRelation record);

}
package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifDevice;
import com.teekee.waterdropservice.entity.bif.BifDeviceDetail;
import com.teekee.waterdropservice.entity.bif.BifDeviceInputParam;
import com.teekee.waterdropservice.entity.bif.BifDeviceRet;
import com.teekee.waterdropservice.entity.dmi.DmiDeviceCompanyRelation;
import com.github.pagehelper.Page;
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
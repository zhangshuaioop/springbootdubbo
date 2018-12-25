package com.platform.springboot.mapper.dmi;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDevice;
import com.platform.springboot.entity.bif.BifDeviceDetail;
import com.platform.springboot.entity.bif.BifDeviceInputParam;
import com.platform.springboot.entity.bif.BifDeviceRet;
import com.platform.springboot.entity.dmi.DmiDeviceCompanyRelation;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDevice;
import com.platform.springboot.entity.bif.BifDeviceDetail;
import com.platform.springboot.entity.bif.BifDeviceInputParam;
import com.platform.springboot.entity.bif.BifDeviceRet;
import com.platform.springboot.entity.dmi.DmiDeviceCompanyRelation;
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
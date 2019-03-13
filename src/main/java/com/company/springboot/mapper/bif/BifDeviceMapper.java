package com.company.springboot.mapper.bif;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BifDeviceMapper extends BaseMapper<BifDevice> {


    Page<BifDeviceRet> queryListByObject(BifDeviceInputParam bifDeviceInputParam);

    BifDeviceDetail selectDeviceDetailById(Integer id);

    List<BifDeviceListDownloadRet> queryListByCompanyIdAndObjectForStore(BifDeviceInputParam record);
    List<BifDeviceListDownloadRet> queryListByCompanyIdAndObjectForOrg(BifDeviceInputParam record);
    List<BifDeviceListDownloadRet> queryListByCompanyIdAndObjectForPerson(BifDeviceInputParam record);
    List<BifDeviceListDownloadRet> queryListByCompanyIdAndObject(BifDeviceInputParam record);

    Page<BifDeviceDetail> findListPage(BifDevice BifDevice);
}
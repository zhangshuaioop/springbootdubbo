package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.*;
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
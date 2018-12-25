package com.platform.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.*;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceDetail;
import com.platform.springboot.entity.bif.BifDeviceInputParam;
import com.platform.springboot.entity.bif.BifDeviceListDownloadRet;
import com.platform.springboot.entity.bif.BifDeviceRet;
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
}
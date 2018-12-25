package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifDeviceUploadFile;
import com.platform.springboot.entity.bif.BifDeviceUploadFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDeviceUploadFileMapper {

    int insertSelective(BifDeviceUploadFile record);

    BifDeviceUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDeviceUploadFile record);

    List<BifDeviceUploadFile> selectByDeviceId(Integer deviceId);

}
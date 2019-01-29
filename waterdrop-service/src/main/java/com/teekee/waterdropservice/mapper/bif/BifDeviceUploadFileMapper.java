package com.teekee.waterdropservice.mapper.bif;

import com.teekee.waterdropservice.entity.bif.BifDeviceUploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDeviceUploadFileMapper {

    int insertSelective(BifDeviceUploadFile record);

    BifDeviceUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDeviceUploadFile record);

    List<BifDeviceUploadFile> selectByDeviceId(Integer deviceId);

}
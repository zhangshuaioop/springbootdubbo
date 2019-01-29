package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.dmi.DmiStoreUploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiStoreUploadFileMapper extends BaseMapper<DmiStoreUploadFile> {

    int insertSelective(DmiStoreUploadFile record);

    DmiStoreUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiStoreUploadFile record);

    List<DmiStoreUploadFile> selectByStoreId(Integer storeId);

}
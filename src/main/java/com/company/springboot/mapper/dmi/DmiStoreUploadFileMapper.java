package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiStoreUploadFile;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiStoreUploadFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiStoreUploadFileMapper extends BaseMapper<DmiStoreUploadFile> {

    int insertSelective(DmiStoreUploadFile record);

    DmiStoreUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiStoreUploadFile record);

    List<DmiStoreUploadFile> selectByStoreId(Integer storeId);

}
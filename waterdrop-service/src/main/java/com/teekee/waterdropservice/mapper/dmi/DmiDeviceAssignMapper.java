package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifDeviceDetail;
import com.teekee.waterdropservice.entity.bif.BifDeviceInputParam;
import com.teekee.waterdropservice.entity.dmi.DmiDeviceAssign;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiDeviceAssignMapper extends BaseMapper<DmiDeviceAssign> {

    int insertSelective(DmiDeviceAssign record);

    DmiDeviceAssign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiDeviceAssign record);

    DmiDeviceAssign selectByDeviceId(Integer deviceId);

    int updateByDeviceIdAndStoreId(DmiDeviceAssign record);

    List<BifDeviceDetail> selectByStoreId(Integer storeId);

    Page<BifDeviceDetail> selectByStoreIdAndObj(BifDeviceInputParam record);

}
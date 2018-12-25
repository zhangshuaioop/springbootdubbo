package com.platform.springboot.mapper.dmi;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceDetail;
import com.platform.springboot.entity.bif.BifDeviceInputParam;
import com.platform.springboot.entity.dmi.DmiDeviceAssign;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceDetail;
import com.platform.springboot.entity.bif.BifDeviceInputParam;
import com.platform.springboot.entity.dmi.DmiDeviceAssign;
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
package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiDeviceAssign;
import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.dmi.DmiDeviceAssign;
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
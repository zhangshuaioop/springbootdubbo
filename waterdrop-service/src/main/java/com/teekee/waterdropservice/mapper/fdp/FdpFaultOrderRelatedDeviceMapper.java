package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderRelatedDevice;
import com.teekee.waterdropservice.entity.fdp.GetBifDeviceList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultOrderRelatedDeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpFaultOrderRelatedDevice record);

    int insertSelective(FdpFaultOrderRelatedDevice record);

    FdpFaultOrderRelatedDevice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultOrderRelatedDevice record);

    int updateByPrimaryKey(FdpFaultOrderRelatedDevice record);
    /**
     * 查询选中的设备信息
     * @param processId
     * @return
     * @Author Niting
     * @Date 2018/06/26
     */
    List<GetBifDeviceList> selectByProcessId(int processId);
    /**
     * 编辑故障设备信息
     * @param list
     * @return
     * @Author Niting
     * @Date 2018/06/26
     */
    int updateByProcessId(FdpFaultOrderRelatedDevice list);

    List<GetBifDeviceList> selectByStoreId(int storeId);

    List<FdpFaultOrderRelatedDevice> selectDeviceId(FdpFaultOrderRelatedDevice faultOrderProcessId);
}
package com.teekee.waterdropservice.service.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderRelatedDevice;
import com.teekee.waterdropservice.entity.fdp.GetBifDeviceList;
import com.teekee.waterdropservice.mapper.fdp.FdpFaultOrderRelatedDeviceMapper;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderRelatedDeviceService
 * @ProjectName WaterDrop
 * @date 2019/1/11下午4:14
 */
@Service
public class FdpFaultOrderRelatedDeviceService {

    @Resource
    FdpFaultOrderRelatedDeviceMapper mapper;
    /**
     * 查询选中的设备信息
     *
     * @param storeId
     * @param processId
     * @return
     * @Author Niting
     * @Date 2018/06/26
     */
    public List<GetBifDeviceList> show(Integer processId, Integer storeId) {
        if(processId != 0 && storeId != 0){
            //调用该门店所绑定的设备
            List<GetBifDeviceList> deviceLists = list(storeId);
            List<GetBifDeviceList> deviceShow = mapper.selectByProcessId(processId);
            for(GetBifDeviceList item :deviceLists){
                boolean flag= false;
                for(GetBifDeviceList dev :deviceShow){
                    if(item.getId().equals(dev.getId())){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    item.setFlagUsed(false);
                }else {
                    item.setFlagUsed(true);
                }
            }
            return deviceLists;
        }
        return new ArrayList<GetBifDeviceList>();
    }

    /**
     * 编辑故障设备信息
     * @param fdpFaultOrderRelatedDevice
     * @param userId
     * @return
     * @Author Niting
     * @Date 2018/06/26
     */
    public Result updateByProcessId(FdpFaultOrderRelatedDevice fdpFaultOrderRelatedDevice, int userId) {
        List<FdpFaultOrderRelatedDevice> param = fdpFaultOrderRelatedDevice.getDevice();
        FdpFaultOrderRelatedDevice device ;
        //故障id不为空
        if(fdpFaultOrderRelatedDevice.getFaultOrderProcessId()!=0){

            //删除已选定的设备
            fdpFaultOrderRelatedDevice.setFlagDeleted(true);
            mapper.updateByProcessId(fdpFaultOrderRelatedDevice);
            //为选定任何设备信息
            if(param == null || param.size()==0){
                return ResultUtil.success();
            }
            //查询已选择的deviceid
            List<GetBifDeviceList> deviceIdList = mapper.selectByProcessId(fdpFaultOrderRelatedDevice.getFaultOrderProcessId());
            if(deviceIdList.size()!= 0 ){
                //查询已选择的deviceid
                List<FdpFaultOrderRelatedDevice> deviceList = mapper.selectDeviceId(fdpFaultOrderRelatedDevice);

                //新增之前未选择的设备
                for(FdpFaultOrderRelatedDevice item :param){
                    boolean flag = false;
                    for (FdpFaultOrderRelatedDevice dev :deviceList){
                        //数据库中没有deviceid 则新增
                        if(item.getDeviceId().equals(dev.getDeviceId())){
                            flag = true;
                            break;
                        }
                    }
                    if(flag == false){
                        device = new FdpFaultOrderRelatedDevice();
                        device.setDeviceId(item.getDeviceId());
                        device.setDeviceAssignId(item.getDeviceAssignId());
                        device.setFaultOrderProcessId(fdpFaultOrderRelatedDevice.getFaultOrderProcessId());
                        device.setStoreId(fdpFaultOrderRelatedDevice.getStoreId());
                        device.setUpdateTime(new Date());
                        device.setFlagDeleted(false);
                        device.setUpdatePerson(userId);
                        device.setFaultReportId(fdpFaultOrderRelatedDevice.getFaultReportId());
                        mapper.insertSelective(device);
                    }
                }
            }else{
                if(param.size()!=0){
                    //查询已选择的deviceid
                    List<FdpFaultOrderRelatedDevice> deviceList = mapper.selectDeviceId(fdpFaultOrderRelatedDevice);
                    //新增之前未选择的设备
                    for(FdpFaultOrderRelatedDevice item :param){
                        boolean flag = false;
                        for (FdpFaultOrderRelatedDevice dev :deviceList){
                            //数据库中没有deviceid 则新增
                            if(item.getDeviceId().equals(dev.getDeviceId())){
                                flag = true;
                                break;
                            }
                        }
                        if(flag == false){
                            device = new FdpFaultOrderRelatedDevice();
                            device.setDeviceId(item.getDeviceId());
                            device.setDeviceAssignId(item.getDeviceAssignId());
                            device.setFaultOrderProcessId(fdpFaultOrderRelatedDevice.getFaultOrderProcessId());
                            device.setStoreId(fdpFaultOrderRelatedDevice.getStoreId());
                            device.setUpdateTime(new Date());
                            device.setFlagDeleted(false);
                            device.setUpdatePerson(userId);
                            device.setFaultReportId(fdpFaultOrderRelatedDevice.getFaultReportId());
                            mapper.insertSelective(device);
                        }
                    }
                }

            }
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("编辑失败！");
    }

    /**
     * 查询门店中的已有设备
     * @param storeId
     * @return
     * @Author Niting
     * @Date 2018/06/26
     */
    public List<GetBifDeviceList> list(int storeId) {
        return mapper.selectByStoreId(storeId);
    }
}

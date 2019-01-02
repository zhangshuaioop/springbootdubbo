package com.platform.springboot.service.bif;

import com.platform.springboot.entity.bif.BifBuilding;
import com.platform.springboot.entity.bif.BifBuildingAddress;
import com.platform.springboot.entity.bif.ret.BifBuildingAddress.ShowRet;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.mapper.bif.BifBuildingAddressMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2018/12/28 18:27
 **/
@Service
public class BifBuildingAddressServcice {

    @Resource
    private BifBuildingAddressMapper buildingAddressMapper;
    @Resource
    private BifBuildingService buildingService;

    public Result handleDelete(BifBuildingAddress buildingAddress) {

        SysConsoleUsers users = CurrentUtil.getCurrent();

        // 查询这条道路的详情，判断是否为主要道路
        BifBuildingAddress detail = buildingAddressMapper.selectByPrimaryKey(buildingAddress.getId());
        if (detail.getFlagMajor() == true) {
            // 如果是主要道路的话，查询这栋楼的所有非主要道路
            int buildingId = detail.getBuildingId();
            List<BifBuildingAddress> sqlResult = buildingAddressMapper.selectByBuildingId(buildingId);
            // 如果非主要道路少于1条，则不能删除主要道路
            if (sqlResult == null || sqlResult.size() == 0) {
                return ResultUtil.validateError("操作失败，楼宇地址仅剩一个，不能继续删除楼宇地址!");
            }
            // 非主要道路至少有一条的情况下，删除这条主要道路的同时将另外一条非主要道路更新为主要道路
            buildingAddress.setFlagDeleted(true);
            update(buildingAddress, users.getId());
            BifBuildingAddress bo = sqlResult.get(0);
            bo.setFlagMajor(true);
            update(bo, users.getId());
        } else {
            // 如果是非主要道路,直接删除
            buildingAddress.setFlagDeleted(true);
            updateNotMajor(buildingAddress, users.getId());
        }
        return ResultUtil.successMsg("删除成功!");
    }

    public void update(BifBuildingAddress buildingAddress, int userId) {
        buildingAddress.setUpdatePerson(userId);
        buildingAddress.setUpdateTime(new Date());
        buildingAddressMapper.updateByBuildingId(buildingAddress);
    }

    public void updateNotMajor(BifBuildingAddress buildingAddress, int userId) {
        buildingAddress.setUpdatePerson(userId);
        buildingAddress.setUpdateTime(new Date());
        buildingAddressMapper.updateByBuildingIdNotMajor(buildingAddress);
    }

    public Result handle(BifBuildingAddress buildingAddress) {

        SysConsoleUsers users = CurrentUtil.getCurrent();

        buildingAddress.setFlagMajor(false);
        if (buildingAddress.getId() == 0) {
            buildingAddress.setFlagMajor(false);
            insert(buildingAddress, users.getId());
            return ResultUtil.successMsg("新增成功!");
        } else {
            update(buildingAddress, users.getId());
            return ResultUtil.successMsg("修改成功!");
        }
    }

    public void insert(BifBuildingAddress buildingAddress, int userId) {
        Date now = new Date();
        buildingAddress.setCreatePerson(userId);
        buildingAddress.setCreateTime(now);
        buildingAddress.setFlagDeleted(false);
        buildingAddress.setUpdatePerson(userId);
        buildingAddress.setUpdateTime(now);
        buildingAddressMapper.insertSelective(buildingAddress);
    }

    public Result show(int id) {
        BifBuildingAddress address = buildingAddressMapper.selectByPrimaryKey(id);
        if (address == null) return null;
        BifBuilding building = buildingService.showBasic(address.getBuildingId());
        if (building == null) return null;
        ShowRet result = new ShowRet();
        result.setBuildingName(building.getBuildingName());
        result.setRoad(address.getRoad());
        result.setCity(building.getCity());
        result.setDistrict(building.getDistrict());
        result.setProvince(building.getProvince());
        result.setLatitude(building.getLatitude());
        result.setLongitude(building.getLongitude());
        return ResultUtil.success(result);
    }
}

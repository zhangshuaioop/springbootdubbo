package com.teekee.blueoceanservice.service.bif;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teekee.blueoceanservice.entity.bif.BifAddressDetail;
import com.teekee.blueoceanservice.entity.bif.BifBuilding;
import com.teekee.blueoceanservice.entity.bif.BifBuildingAddress;
import com.teekee.blueoceanservice.entity.bif.ret.BifBuilding.AddressInfoRet;
import com.teekee.blueoceanservice.entity.bif.ret.BifBuilding.AddressListRet;
import com.teekee.blueoceanservice.entity.bif.ret.BifBuilding.ListRet;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUsers;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.mapper.bif.BifBuildingAddressMapper;
import com.teekee.blueoceanservice.mapper.bif.BifBuildingMapper;
import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyUsersMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.blueoceanservice.utils.LocationUtils;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Chenliwen
 * @Date 2018/12/28 18:03
 **/
@Service
public class BifBuildingService{

    @Resource
    private BifBuildingMapper buildingMapper;
    @Resource
    private BifBuildingAddressMapper buildingAddressMapper;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Value("${select.range}")
    private Double range;

    public Result handle(BifBuilding building) {

        SysConsoleUsers users = CurrentUtil.getCurrent();

        BifBuildingAddress buildingAddress = new BifBuildingAddress();

        if (building.getId() == null || building.getId() == 0) {
            // 新增楼
            int buildingId = insertBuilding(building, users.getId());
            Date now = new Date();
            // 新增地址
            buildingAddress.setFlagMajor(true);
            buildingAddress.setBuildingId(buildingId);
            buildingAddress.setCreatePerson(users.getId());
            buildingAddress.setCreateTime(now);
            buildingAddress.setFlagDeleted(false);
            buildingAddress.setUpdatePerson(users.getId());
            buildingAddress.setUpdateTime(now);
            buildingAddressMapper.insertSelective(buildingAddress);
        } else {
            // 编辑楼
            if (building.getApplyId() == null) {
                building.setApplyId(0);
            }
            building.setUpdatePerson(users.getId());
            building.setUpdateTime(new Date());
            building.setFlagAmend(true);
            buildingMapper.updateByPrimaryKeySelective(building);
            // 编辑地址
            buildingAddress.setBuildingId(building.getId());
            buildingAddress.setId(null);
            buildingAddress.setFlagMajor(true);
            buildingAddress.setUpdatePerson(users.getId());
            buildingAddress.setUpdateTime(new Date());
            buildingAddressMapper.updateByBuildingId(buildingAddress);
        }
        return ResultUtil.success();
    }

    private int insertBuilding(BifBuilding building, int userId) {
        Date now = new Date();
        if (building.getApplyId() == null) building.setApplyId(0);
        building.setCreatePerson(userId);
        building.setCreateTime(now);
        building.setFlagDeleted(false);
        building.setUpdatePerson(userId);
        building.setUpdateTime(now);
        buildingMapper.insertSelective(building);
        return building.getId();
    }

    public Result addressInfo(Integer id) {
        BifBuilding sqlResult = buildingMapper.selectByPrimaryKey(id);
        AddressInfoRet result = new AddressInfoRet();
        if (sqlResult != null) {
            result.setBuildingName(sqlResult.getBuildingName());
            result.setProvince(sqlResult.getProvince());
            result.setCity(sqlResult.getCity());
            result.setDistrict(sqlResult.getDistrict());
            result.setLatitude(sqlResult.getLatitude());
            result.setLongitude(sqlResult.getLongitude());
            result.setFlagAlongTheStreet(sqlResult.isFlagAlongTheStreet());
            /** 查询道路集合 */
            BifBuildingAddress addressInfo = new BifBuildingAddress();
            addressInfo.setBuildingId(sqlResult.getId());
            // 查询主要道路
            addressInfo.setFlagMajor(true);
            List<BifBuildingAddress> addressesList = byMajor(addressInfo);
            result.setMajorRoad(addressesList.get(0).getRoad());
            // 查询非主要道路
            addressInfo.setFlagMajor(false);
            addressesList = byMajor(addressInfo);
            List<String> roadList = new ArrayList<String>();
            for (BifBuildingAddress item : addressesList) {
                roadList.add(item.getRoad());
            }
            result.setRoad(roadList);
        }
        return ResultUtil.success(result);
    }

    public List<BifBuildingAddress> byMajor(BifBuildingAddress buildingAddress) {
        List<BifBuildingAddress> sqlResult = buildingAddressMapper.byMajor(buildingAddress);
        return sqlResult == null ? new ArrayList<BifBuildingAddress>() : sqlResult;
    }


    public Result list(BifBuilding bifBuilding) {
        if (bifBuilding.getPageNum() != null && bifBuilding.getPageSize() != null) {
            PageHelper.startPage(bifBuilding.getPageNum(), bifBuilding.getPageSize());
            Page<ListRet> persons = buildingMapper.list(bifBuilding);
            PageInfo<ListRet> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<ListRet> persons = buildingMapper.list(bifBuilding);
            return ResultUtil.success(persons);
        }
    }

    public Result vicinityBuildingList(double longitude, double latitude) {
        /** 首先根据查询精度，首先查询出满足经纬度极限值的全部数据*/
        // 根据查询精度，计算出经纬度的极限值,放入对象中
        Map<String, BigDecimal> rangeMap = LocationUtils.calculateLimitRange(longitude, latitude, range);
        BifAddressDetail bifAddressDetail = new BifAddressDetail();
        bifAddressDetail.setLongitudeMax(rangeMap.get("longitudeMax"));
        bifAddressDetail.setLongitudeMin(rangeMap.get("longitudeMin"));
        bifAddressDetail.setLatitudeMax(rangeMap.get("latitudeMax"));
        bifAddressDetail.setLatitudeMin(rangeMap.get("latitudeMin"));
        // 查询在及限制范围内的全部数据
        List<BifBuilding> sqlResult = buildingMapper.selectLimitList(bifAddressDetail);

        /** 遍历集合，逐个算出与传入经纬度之间的距离，将所有满足查询精度的数据返回给上层 */
        List<BifBuilding> result = new ArrayList<BifBuilding>();
        for (BifBuilding item : sqlResult) {
            BigDecimal sqlLongitude = item.getLongitude();
            BigDecimal sqlLatitude = item.getLatitude();
            // 计算出该地点与传入经纬度之间的距离
            double distance = LocationUtils.getDistance(sqlLatitude.doubleValue(), sqlLongitude.doubleValue(), latitude, longitude);
            // 判断是否符合查询精度，并且把符合的数据保留下来
            if (distance <= range) {
                result.add(item);
            }
        }
        return ResultUtil.success(result);
    }

    public Result addressList(Integer id) {

        BifBuildingAddress buildingAddress = new BifBuildingAddress();
        buildingAddress.setBuildingId(id);
        List<BifBuildingAddress> sqlResult = byMajor(buildingAddress);
        List<AddressListRet> result = new ArrayList<AddressListRet>();
        for (BifBuildingAddress item : sqlResult) {
            AddressListRet outItem = new AddressListRet();
            outItem.setId(item.getId());
            SysCompanyUsers user = sysCompanyUsersMapper.selectByPrimaryKey(item.getId());
            if (user != null) outItem.setCreatePerson(user.getUsername());
            outItem.setCreateTime(item.getCreateTime());
            outItem.setRoad(item.getRoad());
            outItem.setUpdateTime(item.getUpdateTime());
            result.add(outItem);
        }
        return ResultUtil.success(result);
    }

    public Result handleDelete(BifBuilding building) {
        SysConsoleUsers users = CurrentUtil.getCurrent();
        building.setFlagDeleted(true);
        updateBuilding(building, users.getId());
        BifBuildingAddress address = new BifBuildingAddress();
        address.setUpdatePerson(users.getId());
        address.setUpdateTime(new Date());
        address.setBuildingId(building.getId());
        buildingAddressMapper.deleteByBuildingId(address);
        return ResultUtil.success();
    }

    private void updateBuilding(BifBuilding building, int userId) {
        building.setUpdatePerson(userId);
        building.setUpdateTime(new Date());
        building.setFlagAmend(true);
        buildingMapper.updateByPrimaryKeySelective(building);
    }

    public BifBuilding showBasic(int id) {
        return buildingMapper.selectByPrimaryKey(id);
    }
}

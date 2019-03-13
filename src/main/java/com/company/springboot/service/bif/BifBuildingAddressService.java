package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifBuilding;
import com.company.springboot.entity.bif.BifBuildingAddress;
import com.company.springboot.entity.bif.ret.BifBuildingAddress.ShowRet;
import com.company.springboot.mapper.bif.BifBuildingAddressMapper;
import com.company.springboot.mapper.bif.BifBuildingMapper;
import com.company.springboot.entity.bif.BifBuilding;
import com.company.springboot.entity.bif.BifBuildingAddress;
import com.company.springboot.entity.bif.ret.BifBuildingAddress.ShowRet;
import com.company.springboot.mapper.bif.BifBuildingAddressMapper;
import com.company.springboot.mapper.bif.BifBuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:16
 */
@Service
public class BifBuildingAddressService {

    @Autowired
    private BifBuildingAddressMapper buildingAddressMapper;

    @Autowired
    private BifBuildingMapper bifBuildingMapper;

    public ShowRet show(int id) {
        BifBuildingAddress address = buildingAddressMapper.selectByPrimaryKey(id);
        if (address == null) return null;
        BifBuilding building = bifBuildingMapper.selectByPrimaryKey(address.getBuildingId());
        if (building == null) return null;
        ShowRet result = new ShowRet();
        result.setBuildingName(building.getBuildingName());
        result.setRoad(address.getRoad());
        result.setCity(building.getCity());
        result.setDistrict(building.getDistrict());
        result.setProvince(building.getProvince());
        result.setLatitude(building.getLatitude());
        result.setLongitude(building.getLongitude());
        return result;
    }
}

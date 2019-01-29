package com.teekee.waterdropservice.service.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductBroadband;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductBroadband.BroadbandShowRet;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductBroadbandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:10
 */
@Service
public class DmiCommProductBroadbandService {

    @Autowired
    private DmiCommProductBroadbandMapper dmiCommProductBroadbandMapper;

    public BroadbandShowRet show(int productId) {
        DmiCommProductBroadband sqlResult = dmiCommProductBroadbandMapper.selectByProductId(productId);
        if(sqlResult!=null){
            BroadbandShowRet result = new BroadbandShowRet();
            result.setUnitBandWidthDown(sqlResult.getUnitBandWidthDown());
            result.setUnitBandWidthUp(sqlResult.getUnitBandWidthUp());
            result.setBandWidthUp(sqlResult.getBandWidthUp());
            result.setBandWidthDown(sqlResult.getBandWidthDown());
            result.setFlagFixedIp(sqlResult.getFlagFixedIp());
            result.setFlagSymmetry(sqlResult.getFlagSymmetry());
            result.setIpSectionBegin(sqlResult.getIpSectionBegin());
            result.setIpSectionEnd(sqlResult.getIpSectionEnd());
            result.setSubnetMask(sqlResult.getSubnetMask());
            result.setGateway(sqlResult.getGateway());
            result.setLoginAccount(sqlResult.getLoginAccount());
            result.setLoginPassword(sqlResult.getLoginPassword());
            result.setInterconnectAddress(sqlResult.getInterconnectAddress());
            return result;
        }else{
            return null;
        }

    }
}

package com.teekee.waterdropservice.service.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductMobile;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMobile.MobileShowRet;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductMobileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:13
 */
@Service
public class DmiCommProductMobileService {

    @Autowired
    private DmiCommProductMobileMapper mobileMapper;

    public MobileShowRet show(int productId) {
        DmiCommProductMobile sqlResult = mobileMapper.selectByProductId(productId);
        if(sqlResult==null){
            return null;
        }
        MobileShowRet result = new MobileShowRet();
        result.setPuk(sqlResult.getPuk());
        result.setNetworkType(sqlResult.getNetworkType());
        result.setUseType(sqlResult.getUseType());
        result.setCapacity(sqlResult.getCapacity());
        result.setUnitBandWidth(sqlResult.getUnitBandWidth());
        result.setOffLimitsOperator(sqlResult.getOffLimitsOperator());
        result.setUseRate(sqlResult.getUseRate());
        result.setFlagDdd(sqlResult.getFlagDdd());
        result.setFlagIdd(sqlResult.getFlagIdd());
        return result;
    }
}

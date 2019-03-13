package com.company.springboot.service.dmi;

import com.company.springboot.entity.dmi.DmiCommProductTrunking;
import com.company.springboot.entity.dmi.ret.dmiCommProductTrunking.TrunkShowRet;
import com.company.springboot.mapper.dmi.DmiCommProductTrunkingMapper;
import com.company.springboot.entity.dmi.DmiCommProductTrunking;
import com.company.springboot.entity.dmi.ret.dmiCommProductTrunking.TrunkShowRet;
import com.company.springboot.mapper.dmi.DmiCommProductTrunkingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:25
 */
@Service
public class DmiCommProductTrunkingService {

    @Autowired
    private DmiCommProductTrunkingMapper trunkingMapper;

    public TrunkShowRet show(int productId) {
        DmiCommProductTrunking sqlResult = trunkingMapper.selectByProductId(productId);
        if(sqlResult==null){
            return null;
        }
        TrunkShowRet result = new TrunkShowRet();
        result.setZipCode(sqlResult.getZipCode());
        result.setFlagCid(sqlResult.getFlagCid());
        result.setContainLines(sqlResult.getContainLines());
        result.setNumberBegin(sqlResult.getNumberBegin());
        result.setNumberEnd(sqlResult.getNumberEnd());
        result.setDisplayNumber(sqlResult.getDisplayNumber());
        return result;
    }
}

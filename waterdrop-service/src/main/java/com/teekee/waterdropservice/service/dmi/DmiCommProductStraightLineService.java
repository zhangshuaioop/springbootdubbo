package com.teekee.waterdropservice.service.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductStraightLine;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductStraightLine.StraightLineRet;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductStraightLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:23
 */
@Service
public class DmiCommProductStraightLineService {

    @Autowired
    private DmiCommProductStraightLineMapper straightLineMapper;

    public StraightLineRet show(int productId) {
        DmiCommProductStraightLine sqlResult = straightLineMapper.selectByProductId(productId);
        if(sqlResult==null){
            return null;
        }
        StraightLineRet result = new StraightLineRet();
        result.setZipCode(sqlResult.getZipCode());
        result.setFlagCid(sqlResult.getFlagCid());
        result.setFlagIpPhone(sqlResult.getFlagIpPhone());
        result.setFlagDdd(sqlResult.getFlagDdd());
        result.setFlagIdd(sqlResult.getFlagIdd());
        return result;
    }

}

package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.dmi.DmiCommProductStraightLine;
import com.platform.springboot.entity.dmi.ret.dmiCommProductStraightLine.StraightLineRet;
import com.platform.springboot.mapper.dmi.DmiCommProductStraightLineMapper;
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

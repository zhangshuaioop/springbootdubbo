package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.dmi.DmiCommCharge;
import com.platform.springboot.mapper.dmi.DmiCommChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:38
 */
@Service
public class DmiCommChargeService {

    @Autowired
    private DmiCommChargeMapper dmiCommChargeMapper;

    public DmiCommCharge showByObjectId(DmiCommCharge dmiCommCharge) {
        return dmiCommChargeMapper.showByObjectId(dmiCommCharge);
    }
}

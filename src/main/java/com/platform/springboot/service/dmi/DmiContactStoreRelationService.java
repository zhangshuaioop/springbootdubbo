package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.dmi.DmiContactStoreRelationDetail;
import com.platform.springboot.mapper.dmi.DmiContactStoreRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:53
 */
@Service
public class DmiContactStoreRelationService {


    @Autowired
    private DmiContactStoreRelationMapper dmiContactStoreRelationMapper;

    public List<DmiContactStoreRelationDetail> getAllRelationsByStoreId(int storeId) {
        List<DmiContactStoreRelationDetail> list = new ArrayList<DmiContactStoreRelationDetail>();
        List<Map<String, Object>> orgList = dmiContactStoreRelationMapper.selectListByStoreId(storeId);
        for (Map<String, Object> map : orgList) {
            list.add(new DmiContactStoreRelationDetail((HashMap) map));
        }
        return list;
    }

}

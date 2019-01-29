package com.teekee.waterdropservice.service.cfg;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.waterdropservice.entity.cfg.CfgCommunicationBrand;
import com.teekee.waterdropservice.mapper.cfg.CfgCommunicationBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/12/18
 **/
@Service
public class CfgCommunicationBrandService extends BaseService<CfgCommunicationBrandMapper,CfgCommunicationBrand> {
    @Autowired
    private CfgCommunicationBrandMapper mapper;

    public List<CfgCommunicationBrand> list(int flagOp) {
        CfgCommunicationBrand cfgCommunicationBrand = new CfgCommunicationBrand();
        if (flagOp == 0) {
            cfgCommunicationBrand.setFlagAvailable(true);
        }
        List<CfgCommunicationBrand> sqlResult = mapper.list(cfgCommunicationBrand);
        return sqlResult == null ? new ArrayList<CfgCommunicationBrand>() : sqlResult;
    }

    public CfgCommunicationBrand show(int id) {
        return mapper.selectByPrimaryKey(id);
    }
}

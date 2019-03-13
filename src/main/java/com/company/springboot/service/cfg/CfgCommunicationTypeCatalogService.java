package com.company.springboot.service.cfg;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import com.company.springboot.base.BaseService;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/12/18
 **/
@Service
public class CfgCommunicationTypeCatalogService extends BaseService<CfgCommunicationTypeCatalogMapper,CfgCommunicationTypeCatalog> {
    private Logger log = Logger.getLogger(CfgCommunicationTypeCatalogService.class);

    @Autowired
    private CfgCommunicationTypeCatalogMapper mapper;

    public CfgCommunicationTypeCatalog getByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询通讯资源类型
     *
     * @param id
     * @return
     */
    public List<CfgCommunicationTypeCatalog> list(int id) {
        // 查询一级通讯类型
        if (id == 0) {
            List<CfgCommunicationTypeCatalog> sqlResult = mapper.queryByLevelOne();
            return sqlResult == null ? new ArrayList<CfgCommunicationTypeCatalog>() : sqlResult;
        }
        // 查询二级通讯类型
        if (id > 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(id);
            List<CfgCommunicationTypeCatalog> sqlResult = mapper.queryByParentId(list);
            return sqlResult == null ? new ArrayList<CfgCommunicationTypeCatalog>() : sqlResult;
        }
        // id不存在
        return new ArrayList<CfgCommunicationTypeCatalog>();
    }
}

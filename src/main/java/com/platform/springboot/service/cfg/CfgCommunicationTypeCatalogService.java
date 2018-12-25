package com.platform.springboot.service.cfg;

import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.platform.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/12/18
 **/
@Service
public class CfgCommunicationTypeCatalogService extends BaseService<CfgCommunicationTypeCatalogMapper,CfgCommunicationTypeCatalog>{
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
        log.info("id：" + id);
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

package com.company.springboot.mapper.wp;


import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.wp.WpCfgFrameProcess;
import com.company.springboot.entity.wp.response.WpCfgFrameProcessRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WpCfgFrameProcessMapper extends BaseMapper<WpCfgFrameProcess> {

    /**
     * 框架流程列表
     * @return
     */
    List<WpCfgFrameProcessRes> selectList(SysCompanyUsers sysCompanyUsers);
}
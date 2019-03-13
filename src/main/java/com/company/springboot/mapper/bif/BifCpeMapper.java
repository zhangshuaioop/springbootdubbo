package com.company.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifCpe;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghao
 */
@Mapper
public interface BifCpeMapper extends BaseMapper<BifCpe> {

    /**
     * 根据cpeSn获取网关列表
     * @param bifCpe
     * @return
     */
    Page<BifCpe> getBifCpeList(BifCpe bifCpe);
    /**
     * 新增网关信息
     * @param bifCpe
     * @return
     */
    int insertSelective(BifCpe bifCpe);
    /**
     * 编辑网关信息
     * @param bifCpe
     * @return
     */
    int updateByPrimaryKeySelective(BifCpe bifCpe);
    /**
     * 删除网关信息
     * @param id
     * @return
     */
    Integer deleteByid(@Param("id") Integer id);

    /**
     * 网关详情信息
     * @param id
     * @return
     */
    BifCpe getBifCpeById(@Param("id") Integer id);
}

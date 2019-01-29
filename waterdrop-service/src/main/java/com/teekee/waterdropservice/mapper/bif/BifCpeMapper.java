package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifCpe;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

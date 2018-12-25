package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifDispatchHrAutonymValid;
import com.platform.springboot.entity.bif.BifDispatchHrAutonymValid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrAutonymValidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BifDispatchHrAutonymValid record);

    int insertSelective(BifDispatchHrAutonymValid record);

    BifDispatchHrAutonymValid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHrAutonymValid record);

    int updateByPrimaryKey(BifDispatchHrAutonymValid record);

    /**
     * 根据hrid查询
     * @param id
     * @return
     * @Auhtor：Niting
     * @Date:2018/08/17
     */
    BifDispatchHrAutonymValid selectByHrId(Integer id);
}
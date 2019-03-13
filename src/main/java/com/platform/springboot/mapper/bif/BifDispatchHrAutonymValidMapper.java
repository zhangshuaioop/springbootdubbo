package com.platform.springboot.mapper.bif;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDispatchHrAutonymValid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrAutonymValidMapper extends BaseMapper<BifDispatchHrAutonymValid> {

    BifDispatchHrAutonymValid selectByHrId(Integer id);

}
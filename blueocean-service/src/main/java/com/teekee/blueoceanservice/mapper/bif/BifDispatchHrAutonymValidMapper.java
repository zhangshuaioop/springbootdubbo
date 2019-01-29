package com.teekee.blueoceanservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHrAutonymValid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrAutonymValidMapper extends BaseMapper<BifDispatchHrAutonymValid> {

    BifDispatchHrAutonymValid selectByHrId(Integer id);

}
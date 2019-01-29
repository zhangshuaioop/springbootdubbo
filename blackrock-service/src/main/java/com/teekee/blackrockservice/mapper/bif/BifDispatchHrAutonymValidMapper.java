package com.teekee.blackrockservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrAutonymValid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrAutonymValidMapper extends BaseMapper<BifDispatchHrAutonymValid>{
    /**
     * 根据hrId查询证件
     * @param userId
     * @return
     * @Author:Niting
     * @Date:2018/07/19
     */
    BifDispatchHrAutonymValid selectByHrId(Integer userId);
    /**
     * 根据hrid修改flagLast
     * @param setFlagLast
     * @return
     * @Author:Niting
     * @Date:2018/07/19
     */
    int updateFlagLastByHrId(BifDispatchHrAutonymValid setFlagLast);
}
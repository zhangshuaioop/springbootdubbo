package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifDispatchHrServiceArea;
import com.platform.springboot.entity.bif.BifDispatchHrServiceAreaShow;
import com.platform.springboot.entity.bif.BifDispatchHrServiceArea;
import com.platform.springboot.entity.bif.BifDispatchHrServiceAreaShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDispatchHrServiceAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BifDispatchHrServiceArea record);

    int insertSelective(BifDispatchHrServiceArea record);

    BifDispatchHrServiceArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHrServiceArea record);

    int updateByPrimaryKey(BifDispatchHrServiceArea record);

    List<BifDispatchHrServiceAreaShow> selectServiceShowById(Integer id);

    void updateFaultByHrId(Integer hrId);

    void deleteAreaById(Integer id);

    List<BifDispatchHrServiceArea> selectByHrId(Integer id);

    void updateByPrimaryKeySelectiveById(BifDispatchHrServiceArea serviceArea);

    List<BifDispatchHrServiceArea> selectFault(BifDispatchHrServiceArea serviceArea);

    List<BifDispatchHrServiceArea> selectAreaList(Integer id);

}
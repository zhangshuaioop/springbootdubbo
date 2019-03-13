package com.company.springboot.mapper.bif;

import com.company.springboot.entity.bif.BifDispatchHrServiceArea;
import com.company.springboot.entity.bif.BifDispatchHrServiceAreaShow;
import com.github.pagehelper.Page;
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

    void updateFaultByHrId(Integer hrId);

    void deleteAreaById(Integer id);

    Page<BifDispatchHrServiceArea> selectByHrId(Integer id);

    void updateByPrimaryKeySelectiveById(BifDispatchHrServiceArea serviceArea);

    List<BifDispatchHrServiceArea> selectFault(BifDispatchHrServiceArea serviceArea);

    List<BifDispatchHrServiceArea> selectAreaList(Integer id);

    List<BifDispatchHrServiceAreaShow> selectServiceShowById(Integer id);

}
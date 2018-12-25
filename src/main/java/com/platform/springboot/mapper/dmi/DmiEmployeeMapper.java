package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiEmployee;
import com.platform.springboot.entity.dmi.DmiEmployeeExport;
import com.platform.springboot.entity.dmi.DmiEmployee;
import com.platform.springboot.entity.dmi.DmiEmployeeExport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiEmployeeMapper {

    int insertSelective(DmiEmployee record);

    DmiEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiEmployee record);

    DmiEmployee selectByCompanyAndObject(DmiEmployee record);

    List<DmiEmployee> list(DmiEmployee record);

    List<DmiEmployeeExport> listForExport(DmiEmployee record);

    int insertDmiEmployeeList(List<DmiEmployee> list);

    List<DmiEmployee> selectByObject(DmiEmployee record);

}
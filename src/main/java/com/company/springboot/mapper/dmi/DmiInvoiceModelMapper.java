package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiInvoiceModelWithBLOBs;
import com.company.springboot.entity.dmi.DmiInvoiceModelWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmiInvoiceModelMapper {

    int insertSelective(DmiInvoiceModelWithBLOBs record);

    DmiInvoiceModelWithBLOBs selectByPrimaryKey(Integer id);

    List<Map<String,Object>> selectInvoiceListByCompanyId(Integer belongId);

    List<Map<String,Object>> selectInvoiceListByAreaId(Integer belongId);

    List<Map<String,Object>> selectInvoiceListByStoreId(Integer belongId);

    int updateByPrimaryKeySelective(DmiInvoiceModelWithBLOBs record);

    List<Map<String,Object>> selectInvoiceListByCompanyIdAndType(DmiInvoiceModelWithBLOBs record);
}
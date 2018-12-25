package com.platform.springboot.mapper.dmi;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiBrand;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DmiBrandMapper extends BaseMapper<DmiBrand> {

    int insertSelective(DmiBrand record);

    DmiBrand selectByPrimaryKey(Integer id);

    Page<DmiBrand> selectBrandByCompanyId(Integer companyId);

    int updateByPrimaryKeySelective(DmiBrand record);

    /**
     * 根据品牌名字查询
     * @param brandName
     * @param companyId
     * @return
     * @Author:Niting
     * @Date:2018/08/29
     */
    DmiBrand selectByBrandName(@Param("brandName") String brandName, @Param("companyId") int companyId);
}
package com.company.springboot.mapper.trc;

import com.company.springboot.entity.trc.TrcQrLoginCodeLog;
import com.company.springboot.entity.trc.TrcQrLoginCodeLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcQrLoginCodeLogMapper {

    int insertSelective(TrcQrLoginCodeLog record);

    TrcQrLoginCodeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcQrLoginCodeLog record);
    /**
     * 二维码code验证
     * @return
     * @Author:Niting
     * @Date:2018/08/21
     * @param code
     */
    TrcQrLoginCodeLog selectByCode(String code);
}
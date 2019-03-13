package com.company.springboot.mapper.trc;

import com.company.springboot.entity.trc.TrcQrLoginCodeLog;
import com.company.springboot.entity.trc.TrcUserWorkLog;
import com.company.springboot.entity.trc.TrcQrLoginCodeLog;
import com.company.springboot.entity.trc.TrcUserWorkLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户打开关闭mapper
 * @author zhanghao
 */
@Mapper
public interface TrcUserWorkLogMapper {

    /**
     * 添加
     * @param trcUserWorkLog
     * @return
     */
    int insertSelective(TrcUserWorkLog trcUserWorkLog);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    TrcQrLoginCodeLog selectByPrimaryKey(Integer id);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    List<TrcQrLoginCodeLog> selectByUserId(Integer id);


}
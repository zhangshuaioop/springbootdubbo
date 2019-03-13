package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysOperationMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghao
 * @Title: SysOperationMessageMapper
 * @ProjectName WaterDrop
 * @Description: 业务操作消息
 * @date 2018/12/20下午3:21
 */
@Mapper
public interface SysOperationMessageMapper extends BaseMapper<SysOperationMessage> {

    String selectCompanyName(Integer companyId);

    void updateSetReadByUserIAndDispatchNumber(SysOperationMessage message);
}

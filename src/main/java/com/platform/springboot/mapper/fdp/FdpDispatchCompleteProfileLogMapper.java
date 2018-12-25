package com.platform.springboot.mapper.fdp;

import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.fdp.FdpDispatchCompleteProfileLog;
import com.platform.springboot.entity.fdp.GetFdpCompleteProfileLogShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchCompleteProfileLogMapper {

    int insert(FdpDispatchCompleteProfileLog record);

    int insertSelective(FdpDispatchCompleteProfileLog record);

    FdpDispatchCompleteProfileLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchCompleteProfileLog record);

    /**
     * 根据requestId查询完工资料历史列表
     * @param requestId
     * @return
     * @Author:Niting
     * @Date:2018/10/19
     */
    List<FdpDispatchCompleteProfileLog> selectByRequestId(int requestId);
    /**
     * 查看完工资料历史详情
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/19
     */
    GetFdpCompleteProfileLogShow getProfileShow(int id);
}
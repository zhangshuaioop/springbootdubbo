package com.teekee.blackrockservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrAccountInfo;
import com.teekee.blackrockservice.entity.bif.ListDispatchAccountInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDispatchHrAccountInfoMapper extends BaseMapper<BifDispatchHrAccountInfo> {
    int deleteByPrimaryKey(Integer id);

    int insert(BifDispatchHrAccountInfo record);

    int insertSelective(BifDispatchHrAccountInfo record);

    BifDispatchHrAccountInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHrAccountInfo record);

    int updateByPrimaryKey(BifDispatchHrAccountInfo record);

    /**
     * 根据hrId查询账户
     * @param hrId
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    List<ListDispatchAccountInfo> selectByHrId(Integer hrId);

    /**
     * 查询最近创建账号信息
     * @param hrId
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    BifDispatchHrAccountInfo selectLastTimeAccount(Integer hrId);

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    ListDispatchAccountInfo selectById(Integer id);

    /**
     * 取消原来默认区域
     * @param setDefault
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    int updateDefaultByHrId(BifDispatchHrAccountInfo setDefault);

    /**
     * 根据hrId查询默认账户列表
     * @param hrId
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    BifDispatchHrAccountInfo selectDefaultByHrId(Integer hrId);

    /**
     * 查询账户列表
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/07
     */
    List<ListDispatchAccountInfo> selectAccountList();


    /**
     * 根据hrId查询账户列表
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/07
     */
    int selelctByHrId(Integer hrId);
}
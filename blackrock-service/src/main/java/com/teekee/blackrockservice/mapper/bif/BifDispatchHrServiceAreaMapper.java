package com.teekee.blackrockservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrServiceArea;
import com.teekee.blackrockservice.entity.bif.ListBifDispatchHrServiceArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDispatchHrServiceAreaMapper extends BaseMapper<BifDispatchHrServiceArea>{
    /**
     * 根据hrId查询默认区域
     * @param hrId
     * @return
     * @Author:Niting
     * @Date:2018/07/19
     */
    BifDispatchHrServiceArea selectDefaultAreaByHrId(Integer hrId);
    /**
     * 查询可服务区域列表
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/07/20
     */
    List<ListBifDispatchHrServiceArea> selectByHrId(Integer id);
    /**
     * 修改原来默认区域
     * @param setDefault
     * @return
     * @Author:Niting
     * @Date:2018/07/20
     */
    void updateDefaultByHrId(BifDispatchHrServiceArea setDefault);
    /**
     * 查询可服务区域wolia
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/07/20
     */
    ListBifDispatchHrServiceArea selectById(Integer id);
    /**
     * 查询最近创建的服务区域
     * @param hrId
     * @return
     * @Author:Niting
     * @Date:2018/07/25
     */
    BifDispatchHrServiceArea selectLastTimeArea(Integer hrId);

    /**
     * 根据hrId查询区域条数
     * @param hrId
     * @return
     * @Author:Chenliwen
     * @Date:2018/12/04
     */
    int selectServiceByHrId(Integer hrId);
}
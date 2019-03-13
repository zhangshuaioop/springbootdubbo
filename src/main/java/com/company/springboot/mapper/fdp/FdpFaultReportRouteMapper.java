package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpFaultReportRoute;
import com.company.springboot.entity.fdp.GetFaultReportRouteList;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultReportRouteMapper {
    /**
     * 通过id删除分配路径
     * @param id
     * @return
     * @Author Niting
     * @Date 2018/06/04
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 通过companyid删除全部雇主下全部路径
     * @param companyId
     * @return
     * @Author Niting
     * @Date 2018/06/04
     */
    int deleteByCompanyId(Integer companyId);

    int insert(FdpFaultReportRoute record);
    /**
     * 新增故障分配路径
     * @param record
     * @return
     * @Author Niting
     * @Date 2018/06/01
     */
    int insertSelective(FdpFaultReportRoute record);

    FdpFaultReportRoute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultReportRoute record);

    int updateByPrimaryKey(FdpFaultReportRoute record);
    /**
     * 查询雇主列表
     * @param userId
     * @return
     * @Author Niting
     * @Date 2018/06/01
     */
    Page<GetFaultReportRouteList> show(int userId);
    /**
     * 是否配置路径
     * @param companyId
     * @return
     * @Author Niting
     * @Date 2018/06/01
     */
    List<FdpFaultReportRoute> isConfigRoute(Integer companyId);
    /**
     * 查询故障分配路径列表
     * @param companyId
     * @return
     * @Author Niting
     * @Date 2018/06/01
     */
    List<FdpFaultReportRoute> queryByCompanyId(int companyId);
    /**
     * 查询分配对象
     * @param companyId
     * @return
     * @Author Niting
     * @Date 2018/06/04
     */
    List<GetFaultReportRouteList> selectRouteObject(int companyId);

    /**
     * 新增一套报障路径配置
     * @param fdpFaultReportRoute
     */
    void inserts(FdpFaultReportRoute fdpFaultReportRoute);
}
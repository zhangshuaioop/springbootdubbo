package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.dmi.DmiBrand;
import com.company.springboot.entity.fdp.*;
import com.company.springboot.entity.dmi.DmiBrand;
import com.company.springboot.entity.fdp.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultDispatchHrRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpFaultDispatchHrRelation record);

    int insertSelective(FdpFaultOrderInsertParam record);

    FdpFaultDispatchHrRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultDispatchHrRelation record);

    int updateByPrimaryKey(FdpFaultDispatchHrRelation record);

    void updateFlagUsed(FdpFaultDispatchHrRelation hrRelation);

    /**
     * 通过派工工单查询服务器图片路径
     *@param:  dispatchOrderNumber 派工工单
     *@return: 服务器图片路径
     *@Author Niting
     *@date: 2018/4/26
     **/
    String selectPhotoByOrderNumber(String dispatchOrderNumber);
    /**
     * 新增dispatch_hr_relation
     *
     * @param hrRelation
     *

     * @author liukan
     * @create 2018年04月25日 10:39
     * @return
     */
    int updateByRequestId(FdpFaultDispatchHrRelation hrRelation);

    void updateHrById(FdpFaultDispatchHrRelation hrRelation);

    FdpFaultDispatchHrRelation selectIdByOrderId(Integer dispatchOrderId);

    /**
     * 修改派工费用,修改派工人员
     *
     * @param hr
     * @create 2018年05月03日 10:23
     * @author liukan
     * @return
     */
    void insertHrRelation(FdpFaultDispatchHrRelation hr);

    void updateFlagUsedByOrderId(FdpFaultDispatchHrRelation flag);
    /**
     * 编辑完工资料
     *
     * @param
     * @create 2018年5月10日
     * @author Niting
     * @return
     */
    GetFdpFaultDispatchHrRelationShowRequest selectConfirmFile(int dispatchOrderId);

    FdpFaultDispatchHrRelation selectByRequestId(int faultDispatchRequestId);

    /**
     * 查看完工资料
     *
     * @param
     * @create 2018/08/22
     * @author Niting
     * @return
     */
    GetServiceCompleteProfile selectCompleteProFile(Integer orderId);
    /**
     * 服务商工单筛选品牌
     * @param
     * @create 2018年5月10日
     * @author Niting
     * @return
     */
    List<DmiBrand> selectBrandNameById(Integer hrId);
    /**
     * 服务商工单筛选城市
     * @param hrId
     * @Date 2018/08/29
     * @author Niting
     * @return
     */
    List<GetFdpRequestServiceCity> selectServiceCityByHrId(Integer hrId);

    /**
     * 采购补充完工资料
     * @param hr
     * @Date 2018/10/16
     * @author Chenliwen
     * @return
     */
    void updateExtendProfile(FdpFaultDispatchHrRelation hr);


    /**
     * 查看补充完工资料
     * @param dispatchOrderId
     * @Date 2018/10/16
     * @author Chenliwen
     * @return
     */
    FdpFaultDispatchHrRelation selectShowExtendProfile(int dispatchOrderId);
    /**
     * 修改是否修改完工资料
     * @param relation
     * @Date 2018/10/19
     * @author Niting
     * @return
     */
    void updateFlagEnableModifyProfile(FdpFaultDispatchHrRelation relation);

    /**
     * 查看派工人员信息
     *
     * @param requestId
     * @author Niting
     * @create 2018/10/22
     * @return
     */
    GetFdpFaultDispatchHrRelationShow getDispatchHrShow(int requestId);

    /**
     * 控制是否显示服务商信息
     * @param hrRelation
     * @create 2018/12/04
     * @author zhanghao
     * @return
     */
    int updateFlagDisplayByOrderId(FdpFaultDispatchHrRelation hrRelation);
}
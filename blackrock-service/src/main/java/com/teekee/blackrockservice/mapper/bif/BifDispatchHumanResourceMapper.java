package com.teekee.blackrockservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Mapper
public interface BifDispatchHumanResourceMapper extends BaseMapper<BifDispatchHumanResource> {
    /**
     * 服务商小程序登录
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/02
     */
    BifDispatchHumanResource serviceLogin(HumanResourceLoginParam param);

    /**
     * 手机号是否注册
     * @param account
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    Boolean selectByAccount(String account);

    /**
     * 根据mobile查询
     * @param account
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    BifDispatchHumanResource selectByMobile(String account);

    /**
     * 修改密码
     * @param resource
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    int updatePasswordByAccount(BifDispatchHumanResource resource);
    /**
     * 查询服务商基础信息
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    BifDispatchHumanResourceInfoShow selectServiceInfoById(Integer id);
    /**
     * 编辑服务商基础信息
     *
     * @param info
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    void updateByServiceId(BifDispatchHumanResourceInfoShow info);
    /**
     * 服务商认证信息查询
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    GetHumanResourceServiceInfoShow selectInfoById(Integer id);
    /**
     * 查询关联公司&发票
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    GetHumanResourceCompanyInvoice selectCompanyInvoiceById(Integer id);
    /**
     * 编辑关联公司&发票信息
     * @param resource
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    int updateCompanyInvoice(BifDispatchHumanResource resource);

    /**
     * 查询关联公司&发票
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/07
     */
    GetHumanResourceCompanyInvoice selectCompanyInvoice();

    /**
     * 服务商是否冻结或删除
     * @param userId
     * @return
     * @Author:Niting
     * @Date:2018/11/11
     */
    BifDispatchHumanResource selectByHrId(Integer userId);

    /**
     * 手机号状态
     * @param account
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/19
     */
    BifDispatchHumanResource selectStateByAccount(String account);

}

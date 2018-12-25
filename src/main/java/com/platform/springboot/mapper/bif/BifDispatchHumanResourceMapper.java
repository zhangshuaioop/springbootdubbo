package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.*;
import com.platform.springboot.entity.bif.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifDispatchHumanResourceMapper {

    int insertSelective(BifDispatchHumanResource record);

    BifDispatchHumanResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHumanResource record);

    List<BifDispatchHumanResource> list(DispatchHumanResourceList record);


    List<BifServiceList> selectServiceListByParam(BifServiceListParam serviceListParam);

    BifServiceShow selectServiceInfoById(Integer id);

    void deleteById(Integer id);

    BifServiceCheckShow selectCheckShow(Integer id);

    BifServicePermissionShow selectServicePermissionShowById(Integer id);

    List<BifDispatchHumanResource> selectByMobile(String mobile);
    /**
     * 服务商账号密码登录
     * @param param
     * @return
     * @Author：Niting
     * @Date：2018/08/20
     */
    BifDispatchHumanResource selectByAccountAndPwd(BifDispatchHumanResource param);

    /**
     * 获取派工人员标签
     * @param id
     * @return
     */
    BifDispatchHumanResource findBifDispatchHumanResource(Integer id);

    /**
     * 更新派工人员标签
     * @param bifDispatchHumanResource
     * @return
     */
    int updateLabel(BifDispatchHumanResource bifDispatchHumanResource);

    /**
     * 自定义标签列表
     * @return
     */
    String customLabelList();


    /**
     * 更新自定义标签
     * @param bifDispatchHumanResource
     */
    void updateCustomLable(BifDispatchHumanResource bifDispatchHumanResource);
}
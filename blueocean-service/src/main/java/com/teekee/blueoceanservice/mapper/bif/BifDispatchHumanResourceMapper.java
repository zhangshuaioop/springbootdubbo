package com.teekee.blueoceanservice.mapper.bif;

import com.github.pagehelper.Page;
import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.bif.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDispatchHumanResourceMapper
 * @ProjectName BlueOcean
 * @Description: 人力服务商
 * @date 2018/12/28上午11:46
 */
@Mapper
public interface BifDispatchHumanResourceMapper extends BaseMapper<BifDispatchHumanResource> {
    int insertSelective(BifDispatchHumanResource record);

    BifDispatchHumanResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHumanResource record);

    Page<BifDispatchHumanResource> list(DispatchHumanResourceList record);


    Page<BifServiceList> selectServiceListByParam(BifServiceListParam serviceListParam);

    BifServiceShow selectServiceInfoById(Integer id);

    Integer deleteById(Integer id);

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
    String customLabelList(Integer id);


    /**
     * 更新自定义标签
     * @param bifDispatchHumanResource
     */
    void updateCustomLable(BifDispatchHumanResource bifDispatchHumanResource);

    List<BifDispatchHumanResource> dispatchMainHrIdList(DispatchHumanResourceList dispatchHumanResourceList);
}

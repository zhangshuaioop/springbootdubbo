package com.teekee.blackrockservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.sys.SysUserWechatRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserWechatRelationMapper extends BaseMapper<SysUserWechatRelation>{
    /**
     * 微信自动登录
     * @param param
     * @return
     * @Author Niting
     * @date: 2018/05/28
     */
    Boolean queryByWechatOpenId(SysUserWechatRelation param);
    /**
     * 自动登录更新最后登录时间
     * @param record
     * @return
     * @Author Niting
     * @date: 2018/05/29
     */
    Integer updateByWechatOpenId(SysUserWechatRelation record);
    /**
     * 通过token查询联系人id
     * @param wechatOpenId
     * @return
     * @Author Niting
     * @date: 2018/06/11
     */
    SysUserWechatRelation queryContact(String wechatOpenId);
    /**
     * 通过userId查询
     * @param userId
     * @return
     * @Author Niting
     * @date: 2018/07/18
     */
    SysUserWechatRelation selectOpenIdByUserId(Integer userId);
}
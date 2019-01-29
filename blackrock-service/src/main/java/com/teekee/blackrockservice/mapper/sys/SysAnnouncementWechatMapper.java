package com.teekee.blackrockservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatList;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatShow;
import com.teekee.blackrockservice.entity.sys.SysAnnouncementWechat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Mapper
public interface SysAnnouncementWechatMapper extends BaseMapper<SysAnnouncementWechat>{
    /**
     * 查询服务商公告
     * @return
     * Author:Niting
     * @Date:2018/11/03
     */
    List<GetSysAnnouncementWechatList> list();

    /**
     * 查看公告详情
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     * @param id
     */
    GetSysAnnouncementWechatShow show(Integer id);
}

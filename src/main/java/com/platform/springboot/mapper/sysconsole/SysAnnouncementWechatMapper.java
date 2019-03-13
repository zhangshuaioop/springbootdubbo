package com.platform.springboot.mapper.sysconsole;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sysconsole.SysAnnouncementWechat;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghao
 * @Title: SysAnnouncementWechatMapper
 * @ProjectName BlueOcean
 * @Description: 服务商公告
 * @date 2019/1/2下午2:23
 */
@Mapper
public interface SysAnnouncementWechatMapper extends BaseMapper<SysAnnouncementWechat> {

    Page<SysAnnouncementWechat> list(SysAnnouncementWechat sysAnnouncementWechat);

}

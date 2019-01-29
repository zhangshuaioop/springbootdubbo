package com.teekee.blueoceanservice.mapper.sysconsole;

import com.github.pagehelper.Page;
import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.sysconsole.SysAnnouncementWechat;
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

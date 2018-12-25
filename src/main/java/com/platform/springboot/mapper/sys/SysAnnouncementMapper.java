package com.platform.springboot.mapper.sys;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sys.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    List<SysAnnouncement> selectLastFive();

}
package com.platform.springboot.mapper.syscompany;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.syscompany.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    List<SysAnnouncement> selectLastFive();

}
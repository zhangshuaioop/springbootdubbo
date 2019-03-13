package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysAnnouncement;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    List<SysAnnouncement> selectLastFive();

}
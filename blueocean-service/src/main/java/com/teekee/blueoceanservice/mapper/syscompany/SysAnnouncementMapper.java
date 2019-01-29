package com.teekee.blueoceanservice.mapper.syscompany;

import com.github.pagehelper.Page;
import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.syscompany.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    List<SysAnnouncement> selectLastFive();

    Page<SysAnnouncement> list(SysAnnouncement sysAnnouncement);
}
package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    List<SysAnnouncement> selectLastFive();

}
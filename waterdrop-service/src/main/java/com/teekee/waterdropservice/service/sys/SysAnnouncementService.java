package com.teekee.waterdropservice.service.sys;

import com.teekee.waterdropservice.entity.sys.SysAnnouncement;
import com.teekee.waterdropservice.mapper.sys.SysAnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAnnouncementService{

    @Autowired
    private SysAnnouncementMapper sysAnnouncementMapper;

    public List<SysAnnouncement> getLastFive(){
        return sysAnnouncementMapper.selectLastFive();

    }
}

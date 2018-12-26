package com.platform.springboot.service.syscompany;

import com.platform.springboot.entity.syscompany.SysAnnouncement;
import com.platform.springboot.mapper.syscompany.SysAnnouncementMapper;
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

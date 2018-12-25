package com.platform.springboot.service.sys;

import com.platform.springboot.entity.sys.SysAnnouncement;
import com.platform.springboot.mapper.sys.SysAnnouncementMapper;
import com.platform.springboot.mapper.sys.SysAnnouncementMapper;
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

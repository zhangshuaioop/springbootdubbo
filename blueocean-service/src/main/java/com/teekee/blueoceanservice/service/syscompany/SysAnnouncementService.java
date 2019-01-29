package com.teekee.blueoceanservice.service.syscompany;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teekee.blueoceanservice.entity.syscompany.SysAnnouncement;
import com.teekee.blueoceanservice.mapper.syscompany.SysAnnouncementMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysAnnouncementService{

    @Autowired
    private SysAnnouncementMapper sysAnnouncementMapper;

    public List<SysAnnouncement> getLastFive(){
        return sysAnnouncementMapper.selectLastFive();

    }

    public Result list(SysAnnouncement sysAnnouncement) {
        PageHelper.startPage(sysAnnouncement.getPageNum(), sysAnnouncement.getPageSize());
        Page<SysAnnouncement> persons = sysAnnouncementMapper.list(sysAnnouncement);
        PageInfo<SysAnnouncement> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result handle(SysAnnouncement sysAnnouncement) {
        Integer userId = CurrentUtil.getCurrent().getId();
        if(sysAnnouncement.getContent()==null||sysAnnouncement.getContent().equals("")){
            return ResultUtil.errorBusinessMsg("内容不能空");
        }
        if(sysAnnouncement.getTitle()==null||sysAnnouncement.getTitle().equals("")){
            return ResultUtil.errorBusinessMsg("标题不能空");
        }
        sysAnnouncement.setCreateTime(new Date());
        sysAnnouncement.setCreateId(userId);
        sysAnnouncement.setFlagDeleted(false);
        if(sysAnnouncement.getId()==null||sysAnnouncement.getId()==0){
            sysAnnouncementMapper.insertSelective(sysAnnouncement);
        }else{
            sysAnnouncementMapper.updateByPrimaryKeySelective(sysAnnouncement);
        }
        return ResultUtil.success();
    }

    public Result show(Integer id) {
        return ResultUtil.success(sysAnnouncementMapper.selectByPrimaryKey(id));
    }

    public Result delete(Integer id) {
        if(id!=null && id != 0){
            SysAnnouncement param = new SysAnnouncement();
            param.setId(id);
            param.setFlagDeleted(true);
            if(sysAnnouncementMapper.updateByPrimaryKeySelective(param) > 0){
                return ResultUtil.success();
            }
        }
        return ResultUtil.errorBusinessMsg("删除失败！");
    }
}

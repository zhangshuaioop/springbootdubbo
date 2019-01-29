package com.teekee.blackrockservice.service.sys;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatList;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatShow;
import com.teekee.blackrockservice.entity.sys.SysAnnouncementWechat;
import com.teekee.blackrockservice.mapper.sys.SysAnnouncementWechatMapper;
import com.teekee.blackrockservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysAnnouncementWechatService extends BaseService<SysAnnouncementWechatMapper, SysAnnouncementWechat> {
    @Autowired
    private SysAnnouncementWechatMapper mapper;

    /**
     * 公告列表
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    public List<GetSysAnnouncementWechatList> noticeList() {
        List<GetSysAnnouncementWechatList> result = mapper.list();
        if(result.size() > 0){
            return result;
        }
        return new ArrayList<GetSysAnnouncementWechatList>();
    }

    /**
     * 查看公告详情
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     * @param id
     */
    public GetSysAnnouncementWechatShow noticeShow(Integer id) {
        GetSysAnnouncementWechatShow result = mapper.show(id);
        if(result.getPublishDate() != null){
            //转换日期格式
            result.setPublishTime(DateUtil.getNewFormat(result.getPublishDate()));
        }
        if(result != null){
            return result;
        }
        return new GetSysAnnouncementWechatShow();
    }
}

package com.teekee.blueoceanservice.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.blueoceanservice.entity.sysconsole.SysAnnouncementWechat;
import com.teekee.blueoceanservice.mapper.sysconsole.SysAnnouncementWechatMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhanghao
 * @Title: SysAnnouncementWechatService
 * @ProjectName BlueOcean
 * @Description: 服务商公告
 * @date 2019/1/2下午2:18
 */
@Service
public class SysAnnouncementWechatService {

    @Resource
    private SysAnnouncementWechatMapper mapper;


    public Result list(SysAnnouncementWechat sysAnnouncementWechat) {

        PageHelper.startPage(sysAnnouncementWechat.getPageNum(), sysAnnouncementWechat.getPageSize());
        Page<SysAnnouncementWechat> persons = mapper.list(sysAnnouncementWechat);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysAnnouncementWechat> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result show(Integer id) {
        return ResultUtil.success(mapper.selectByPrimaryKey(id));
    }

    public Result handle(SysAnnouncementWechat param) {

        Integer userId = CurrentUtil.getCurrent().getId();
        Date now = new Date();
        param.setCreateTime(now);
        param.setCreateId(userId);
        param.setFlagDeleted(false);
        param.setFlagAvaliable(false);
        param.setFlagPublished(false);
        param.setTitle(param.getTitle().trim());
        param.setContent(param.getContent().trim());
        param.setUpdateId(userId);
        param.setUpdateTime(now);
        if (param.getTitle() == null || param.getTitle().equals("")) {
            return ResultUtil.errorBusinessMsg("请填写标题！");
        }
        if (param.getMainPicUrl() == null || param.getMainPicUrl().equals("")) {
            return ResultUtil.errorBusinessMsg("请选择上传图片！");
        }
        if (param.getContent() == null || param.getContent().equals("")) {
            return ResultUtil.errorBusinessMsg("请填写文本！");
        }

        if (param.getId() == null || param.getId() == 0) {
            //新增服务商公告
            if (mapper.insertSelective(param) > 0) {
                return ResultUtil.success();
            }
        } else {
            //编辑服务商公告
            if (mapper.updateByPrimaryKeySelective(param) > 0) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.errorBusinessMsg("失败！");
    }

    public Result publishNotice(SysAnnouncementWechat param) {

        if (param.getId() == null || param.getId() == 0) {
            return ResultUtil.validateError("参数错误");
        }

        if (param.getPublishTime() == null) {
            return ResultUtil.errorBusinessMsg("请选择发布时间！");
        }
        param.setId(param.getId());
        param.setFlagPublished(true);
        param.setFlagAvaliable(true);
        param.setPublishTime(param.getPublishTime());
        param.setUpdateId(CurrentUtil.getCurrent().getId());
        param.setUpdateTime(new Date());
        if (mapper.updateByPrimaryKeySelective(param) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("失败！");
    }

    public Result recall(Integer id) {
        if (id == null || id == 0) {
            return ResultUtil.validateError("参数错误");
        }
        SysAnnouncementWechat param = new SysAnnouncementWechat();
        param.setId(id);
        param.setFlagAvaliable(false);
        param.setFlagPublished(false);
        param.setUpdateId(CurrentUtil.getCurrent().getId());
        param.setUpdateTime(new Date());
        //编辑服务商公告
        if (mapper.updateByPrimaryKeySelective(param) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("失败！");
    }

    public Result delete(Integer id) {
        if (id == null || id == 0) {
            return ResultUtil.validateError("参数错误");
        }
        SysAnnouncementWechat param = new SysAnnouncementWechat();
        param.setId(id);
        param.setFlagDeleted(true);
        param.setUpdateId(CurrentUtil.getCurrent().getId());
        param.setUpdateTime(new Date());
        if (mapper.updateByPrimaryKeySelective(param) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("失败！");
    }
}

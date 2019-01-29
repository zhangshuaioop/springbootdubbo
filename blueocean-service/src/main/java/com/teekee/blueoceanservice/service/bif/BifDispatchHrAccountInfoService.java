package com.teekee.blueoceanservice.service.bif;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHrAccountInfo;
import com.teekee.blueoceanservice.mapper.bif.BifDispatchHrAccountInfoMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDispatchHrAccountInfoService
 * @ProjectName BlueOcean
 * @Description: 人力服务商账号
 * @date 2018/12/29下午1:37
 */
@Service
public class BifDispatchHrAccountInfoService {

    @Resource
    private BifDispatchHrAccountInfoMapper bifDispatchHrAccountInfoMapper;

    public Result getHrAccountlist(BifDispatchHrAccountInfo bifDispatchHrAccountInfo) {

        if (bifDispatchHrAccountInfo.getPageNum() != null && bifDispatchHrAccountInfo.getPageSize() != null) {
            PageHelper.startPage(bifDispatchHrAccountInfo.getPageNum(), bifDispatchHrAccountInfo.getPageSize());
            Page<BifDispatchHrAccountInfo> persons = bifDispatchHrAccountInfoMapper.selectByHrIdOld(bifDispatchHrAccountInfo.getHrId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifDispatchHrAccountInfo> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<BifDispatchHrAccountInfo> persons = bifDispatchHrAccountInfoMapper.selectByHrIdOld(bifDispatchHrAccountInfo.getHrId());
            return ResultUtil.success(persons);
        }

    }

    public Result getHrAccountShow(Integer accountId) {
        return ResultUtil.success(bifDispatchHrAccountInfoMapper.selectByHrAccountShow(accountId));
    }

    public Result handle(BifDispatchHrAccountInfo AccountInfo) {
        Integer userId = CurrentUtil.getCurrent().getId();
        Date now = new Date();

        AccountInfo.setUpdateTime(now);
        AccountInfo.setFlagDeleted(false);
        AccountInfo.setUpdatePerson(userId);

        if (AccountInfo.getFlagDefault()) {
            BifDispatchHrAccountInfo hrAccountInfo = new BifDispatchHrAccountInfo();
            hrAccountInfo.setFlagDefault(false);
            hrAccountInfo.setHrId(AccountInfo.getHrId());
            bifDispatchHrAccountInfoMapper.updateFlagDefaultByHrId(hrAccountInfo);
        }

        if (AccountInfo.getId() == null || AccountInfo.getId() == 0) {
            AccountInfo.setCreatePerson(userId);
            AccountInfo.setCreateTime(now);
            bifDispatchHrAccountInfoMapper.insertSelective(AccountInfo);
        } else {
            bifDispatchHrAccountInfoMapper.updateByPrimaryKeySelective(AccountInfo);
        }


        return ResultUtil.success();

    }

    public Result showDefaultHrAccount(Integer hrId) {
        return ResultUtil.success(bifDispatchHrAccountInfoMapper.selectByHrIdFlagDefault(hrId));
    }

    public Result accountDelete(Integer id) {
        if (bifDispatchHrAccountInfoMapper.accountDelete(id) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("删除失败");
    }
}

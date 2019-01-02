package com.platform.springboot.service.bif;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platform.springboot.entity.bif.*;
import com.platform.springboot.mapper.bif.BifDispatchHrAccountInfoMapper;
import com.platform.springboot.mapper.bif.BifDispatchHrAutonymValidMapper;
import com.platform.springboot.mapper.bif.BifDispatchHrServiceAreaMapper;
import com.platform.springboot.mapper.bif.BifDispatchHumanResourceMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.utils.ValiDateUtil;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDispatchHumanResourceService
 * @ProjectName BlueOcean
 * @Description: 人力服务商
 * @date 2018/12/28上午11:42
 */
@Service
public class BifDispatchHumanResourceService {

    @Resource
    private BifDispatchHumanResourceMapper mapper;
    @Resource
    private Mapper dozer;
    @Resource
    private BifDispatchHrAccountInfoMapper hrAccountInfoMapper;
    @Resource
    private BifDispatchHrServiceAreaMapper areaMapper;
    @Resource
    private BifDispatchHrAutonymValidMapper validMapper;

    public Result serviceListParam(BifServiceListParam bifServiceListParam) {
        if (bifServiceListParam.getPageNum() != null && bifServiceListParam.getPageSize() != null) {
            PageHelper.startPage(bifServiceListParam.getPageNum(), bifServiceListParam.getPageSize());
            Page<BifServiceList> persons = mapper.selectServiceListByParam(bifServiceListParam);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifServiceList> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<BifServiceList> persons = mapper.selectServiceListByParam(bifServiceListParam);
            return ResultUtil.success(persons);
        }

    }

    public Result list(DispatchHumanResourceList dispatchHumanResourceList) {

        dispatchHumanResourceList.setUserId(CurrentUtil.getCurrent().getId());

        // 查询操作者派工过的人员集合
        List<BifDispatchHumanResource> sqlResult = null;

        if (dispatchHumanResourceList.getFlagMyUsed() == true && dispatchHumanResourceList.getUserId() != 0) {
            sqlResult = mapper.dispatchMainHrIdList(dispatchHumanResourceList);
            if (sqlResult != null && sqlResult.size() > 0) {
                List<Integer> hrIdList = new ArrayList<Integer>();
                for (BifDispatchHumanResource item : sqlResult) {
                    hrIdList.add(item.getId());
                }
                dispatchHumanResourceList.setIdList(hrIdList);
            }
        }

        if (dispatchHumanResourceList.getFlagMyUsed() && (sqlResult == null || sqlResult.size() == 0)) {
            return ResultUtil.success(null);
        } else {
            if (dispatchHumanResourceList.getPageNum() != null && dispatchHumanResourceList.getPageSize() != null) {
                PageHelper.startPage(dispatchHumanResourceList.getPageNum(), dispatchHumanResourceList.getPageSize());
                Page<BifDispatchHumanResource> pageInfo = mapper.list(dispatchHumanResourceList);
                PageInfo<BifDispatchHumanResource> persons = new PageInfo<>(pageInfo);
                return ResultUtil.success(persons);
            } else {
                List<BifDispatchHumanResource> list = mapper.list(dispatchHumanResourceList);
                return ResultUtil.success(list);
            }
        }
    }

    public Result show(Integer id) {

        BifDispatchHumanResourceShowResp result = new BifDispatchHumanResourceShowResp();

        // 账户信息
        BifDispatchHrAccountInfo bifDispatchHrAccountInfo = hrAccountInfoMapper.selectByHrIdFlagDefault(id);
        if (bifDispatchHrAccountInfo != null) {
            result = dozer.map(bifDispatchHrAccountInfo, BifDispatchHumanResourceShowResp.class);
        }
        // 资源信息
        BifDispatchHumanResource bifDispatchHumanResource = mapper.selectByPrimaryKey(id);
        if (bifDispatchHumanResource != null) {
            result.setFirstName(bifDispatchHumanResource.getFirstName());
            result.setLastName(bifDispatchHumanResource.getLastName());
            result.setMobile(bifDispatchHumanResource.getMobile());
            result.setBelongCompany(bifDispatchHumanResource.getBelongCompany());
            result.setQq(bifDispatchHumanResource.getQq());
            result.setWechat(bifDispatchHumanResource.getWechat());
            result.setMemo(bifDispatchHumanResource.getMemo());
            result.setIdCode(bifDispatchHumanResource.getIdCode());
            result.setIdType(bifDispatchHumanResource.getIdType());
            result.setEmail(bifDispatchHumanResource.getEmail());
            result.setDefaultProvice(bifDispatchHumanResource.getDefaultProvice());
            result.setDefaultCity(bifDispatchHumanResource.getDefaultCity());
            result.setDefaultDistrict(bifDispatchHumanResource.getDefaultDistrict());
        }
        return ResultUtil.success(result);
    }

    public Result handle(BifDispatchHumanResource HumanResource) {

        if (HumanResource.getMobile() == null) {
            return ResultUtil.errorBusinessMsg("手机号不能为空");
        }
        if (!ValiDateUtil.isNumeric(HumanResource.getMobile())) {
            return ResultUtil.errorBusinessMsg("手机号码只能为纯数字");
        }

        if (HumanResource.getId() == null || HumanResource.getId() == 0) {

            List<BifDispatchHumanResource> hr = mapper.selectByMobile(HumanResource.getMobile());
            if (hr.size() > 0) {
                return ResultUtil.errorBusinessMsg("该手机号已存在，请更换手机号");
            }

            Date now = new Date();
            HumanResource.setCreatePerson(CurrentUtil.getCurrent().getId());
            HumanResource.setCreateTime(now);
            HumanResource.setDispatchSuccessfulCount(0);
            HumanResource.setDispatchAvgFee(new BigDecimal(0.0));
            HumanResource.setDispatchTotalFee(new BigDecimal(0.0));
            HumanResource.setDispatchMaxFee(new BigDecimal(0.0));
            HumanResource.setFlagDeleted(false);
            HumanResource.setFlagAvailable(true);
            HumanResource.setUpdateTime(now);
            HumanResource.setUserAssessmentCount(0);
            HumanResource.setContactAssessmentCount(0);
            HumanResource.setClientAssessmentCount(0);
            HumanResource.setUserAssmAchieveTotalPoint(0);
            HumanResource.setUserAssmCommunicationTotalPoint(0);
            HumanResource.setUserAssmTimelyTotalPoint(0);
            HumanResource.setUserAssmAchieveAvgPoint(new BigDecimal(0.0));
            HumanResource.setUserAssmCommunicationAvgPoint(new BigDecimal(0.0));
            HumanResource.setUserAssmTimelyAvgPoint(new BigDecimal(0.0));
            HumanResource.setClientAssmAchieveTotalPoint(0);
            HumanResource.setClientAssmCommunicationTotalPoint(0);
            HumanResource.setClientAssmTimelyTotalPoint(0);
            HumanResource.setClientAssmAchieveAvgPoint(new BigDecimal(0.0));
            HumanResource.setClientAssmCommunicationAvgPoint(new BigDecimal(0.0));
            HumanResource.setClientAssmTimelyAvgPoint(new BigDecimal(0.0));
            HumanResource.setContactAssmTotalPoint(new BigDecimal(5));
            HumanResource.setContactAssmAvgPoint("0");
            mapper.insertSelective(HumanResource);

            BifDispatchHrServiceArea area = new BifDispatchHrServiceArea();
            area.setProvince(HumanResource.getDefaultProvice());
            area.setCity(HumanResource.getDefaultCity());
            area.setHrId(HumanResource.getId());
            area.setNation("中国");
            area.setFlagDefault(true);
            area.setFlagDeleted(false);
            area.setCreateTime(new Date());
            areaMapper.insert(area);

            BifDispatchHrAutonymValid valid = validMapper.selectByHrId(HumanResource.getId());
            BifDispatchHrAutonymValid validRecord = new BifDispatchHrAutonymValid();
            if (valid == null) {
                //新增实名认证信息
                validRecord.setUserId(HumanResource.getId());
                validRecord.setIdCode(HumanResource.getIdCode());
                validRecord.setIdType(HumanResource.getIdType());
                validRecord.setUserName(HumanResource.getFirstName() + HumanResource.getLastName());
                validRecord.setFlagLast(true);
                validRecord.setFlagValidStatus(false);
                validRecord.setCreateTime(now);
                validMapper.insertSelective(validRecord);
            } else {
                //编辑实名认证信息
                validRecord.setId(valid.getId());
                validRecord.setIdCode(HumanResource.getIdCode());
                validRecord.setIdType(HumanResource.getIdType());
                validMapper.updateByPrimaryKeySelective(validRecord);
            }
            return ResultUtil.success();
        } else {
            Date now = new Date();
            HumanResource.setUpdateTime(now);
            HumanResource.setUpdatePerson(CurrentUtil.getCurrent().getId());
            List<BifDispatchHumanResource> humanResources = mapper.selectByMobile(HumanResource.getMobile());
            if (humanResources == null || humanResources.size() == 0) {
                mapper.updateByPrimaryKeySelective(HumanResource);
                return ResultUtil.success();
            }
            if (humanResources.size() == 1 && humanResources.get(0).getId().equals(HumanResource.getId())) {
                mapper.updateByPrimaryKeySelective(HumanResource);
                return ResultUtil.success();
            } else {
                return ResultUtil.errorBusinessMsg("手机号已存在,请更换手机号");
            }
        }

    }

    public Result serviceHandle(BifDispatchHumanResource serviceHumanResource) {

        if (serviceHumanResource.getMobile() == null) {
            return ResultUtil.errorBusinessMsg("手机号不能为空");
        }
        if (!ValiDateUtil.isNumeric(serviceHumanResource.getMobile())) {
            return ResultUtil.errorBusinessMsg("手机号码只能为纯数字");
        }

        if (serviceHumanResource.getId() == 0) {

            List<BifDispatchHumanResource> hr = mapper.selectByMobile(serviceHumanResource.getMobile());
            if (hr.size() > 0) {
                return ResultUtil.errorBusinessMsg("该手机号已存在，请更换手机号");
            }
            Date now = new Date();
            serviceHumanResource.setCreatePerson(CurrentUtil.getCurrent().getId());
            serviceHumanResource.setCreateTime(now);
            serviceHumanResource.setDispatchSuccessfulCount(0);
            serviceHumanResource.setDispatchAvgFee(new BigDecimal(0.0));
            serviceHumanResource.setDispatchTotalFee(new BigDecimal(0.0));
            serviceHumanResource.setDispatchMaxFee(new BigDecimal(0.0));
            serviceHumanResource.setFlagDeleted(false);
            serviceHumanResource.setFlagAvailable(true);
            serviceHumanResource.setUpdateTime(now);
            serviceHumanResource.setUserAssessmentCount(0);
            serviceHumanResource.setContactAssessmentCount(0);
            serviceHumanResource.setClientAssessmentCount(0);
            serviceHumanResource.setUserAssmAchieveTotalPoint(0);
            serviceHumanResource.setUserAssmCommunicationTotalPoint(0);
            serviceHumanResource.setUserAssmTimelyTotalPoint(0);
            serviceHumanResource.setUserAssmAchieveAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setUserAssmCommunicationAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setUserAssmTimelyAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setClientAssmAchieveTotalPoint(0);
            serviceHumanResource.setClientAssmCommunicationTotalPoint(0);
            serviceHumanResource.setClientAssmTimelyTotalPoint(0);
            serviceHumanResource.setClientAssmAchieveAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setClientAssmCommunicationAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setClientAssmTimelyAvgPoint(new BigDecimal(0.0));
            serviceHumanResource.setContactAssmTotalPoint(new BigDecimal(5));
            serviceHumanResource.setContactAssmAvgPoint("0");
            serviceHumanResource.setValidStatus("NOREGITER");

            mapper.insertSelective(serviceHumanResource);

            BifDispatchHrServiceArea area = new BifDispatchHrServiceArea();
            area.setProvince(serviceHumanResource.getDefaultProvice());
            area.setCity(serviceHumanResource.getDefaultCity());
            area.setHrId(serviceHumanResource.getId());
            area.setNation("中国");
            area.setFlagDefault(true);
            area.setFlagDeleted(false);
            area.setCreateTime(new Date());
            areaMapper.insert(area);


            return ResultUtil.success();
        } else {
            Date now = new Date();
            serviceHumanResource.setUpdateTime(now);

            List<BifDispatchHumanResource> humanResources = mapper.selectByMobile(serviceHumanResource.getMobile());

            if (humanResources.size() == 0) {
                mapper.updateByPrimaryKeySelective(serviceHumanResource);
                mapper.updateCustomLable(serviceHumanResource);

                return ResultUtil.success();
            }
            if (humanResources.size() == 1 && humanResources.get(0).getId().equals(serviceHumanResource.getId())) {
                mapper.updateByPrimaryKeySelective(serviceHumanResource);
                mapper.updateCustomLable(serviceHumanResource);

                return ResultUtil.success();

            } else {
                return ResultUtil.errorBusinessMsg("手机号已存在,请更换手机号");
            }

        }

    }

    public Result serviceShow(Integer id) {

        //获取该服务商基本信息
        BifServiceShow hr = mapper.selectServiceInfoById(id);
        //获取该服务商服务城市
        List<BifDispatchHrServiceAreaShow> serviceArea = areaMapper.selectServiceShowById(id);
        //把城市添加到基本信息里
        hr.setProviceList(serviceArea);
        //该服务商的收款账户
        List<BifDispatchHrAccountInfoShow> accountInfos = hrAccountInfoMapper.selectServiceShowByHrId(id);

        hr.setAccountInfoList(accountInfos);

        return ResultUtil.success(hr);
    }

    public Result servicePermissionShow(Integer id) {

        //获取该服务商基本信息
        BifServicePermissionShow hr = mapper.selectServicePermissionShowById(id);
        //获取该服务商服务城市
        List<BifDispatchHrServiceAreaShow> serviceArea = areaMapper.selectServiceShowById(id);
        //把城市添加到基本信息里
        hr.setProviceList(serviceArea);
        //该服务商的收款账户
        List<BifDispatchHrAccountInfoShow> accountInfos = hrAccountInfoMapper.selectServiceShowByHrId(id);

        hr.setAccountInfoList(accountInfos);

        return ResultUtil.success(hr);
    }

    public Result serviceAvailable(Integer id, Integer available) {

        BifDispatchHumanResource hr = new BifDispatchHumanResource();
        hr.setId(id);
        //1= 冻结
        if (available == 0) {
            hr.setFlagAvailable(false);
            mapper.updateByPrimaryKeySelective(hr);
            return ResultUtil.success();
        } else {
            //解冻
            hr.setFlagAvailable(true);
            mapper.updateByPrimaryKeySelective(hr);
            return ResultUtil.success();
        }

    }

    public Result serviceValid(BifDispatchHrAutonymValid autonymValid) {
        Integer userId = CurrentUtil.getCurrent().getId();
        autonymValid.setValidPersonId(userId);
        autonymValid.setDealTime(new Date());
        if (autonymValid.getFlagValidStatus() == true) {
            autonymValid.setValidPersonId(userId);
            validMapper.updateByPrimaryKeySelective(autonymValid);
            BifDispatchHumanResource humanResource = new BifDispatchHumanResource();
            humanResource.setValidStatus("APPROVED");
            humanResource.setValidTime(new Date());
            humanResource.setUpdatePerson(userId);
            humanResource.setId(autonymValid.getUserId());
            mapper.updateByPrimaryKeySelective(humanResource);

        } else {
            BifDispatchHumanResource humanResource = new BifDispatchHumanResource();
            autonymValid.setValidPersonId(userId);
            validMapper.updateByPrimaryKeySelective(autonymValid);

            humanResource.setValidStatus("DENY");
            humanResource.setValidTime(new Date());
            humanResource.setUpdatePerson(userId);
            humanResource.setId(autonymValid.getUserId());
            mapper.updateByPrimaryKeySelective(humanResource);
        }
        return ResultUtil.success();
    }

    public Result serviceDelete(Integer id) {
        if (mapper.deleteById(id) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("删除失败");
    }

    public Result serviceCheck(Integer id) {
        return ResultUtil.success(mapper.selectCheckShow(id));
    }

    public Result serviceLogin(BifDispatchHumanResource bifDispatchHumanResource) {
        return ResultUtil.errorBusinessMsg("需要重新定义下,先返回个假的");
    }
    /**
     * 校验服务商手机号
     * @param mobile
     * @return
     * @Author：Niting
     * @Date：2018/10/24
     */
    public Result checkHrMobile(String mobile) {
        List<BifDispatchHumanResource> humanResources = mapper.selectByMobile(mobile);
        if(humanResources.size() > 0){
            return ResultUtil.errorBusinessMsg("该手机号已存在！");
        }
        return ResultUtil.success("手机号校验成功！");
    }

    public Result checkHrMobileEdit(String mobile) {
        List<BifDispatchHumanResource> humanResources = mapper.selectByMobile(mobile);
        if(humanResources.size() > 1){
            return ResultUtil.errorBusinessMsg("该手机号已存在！");
        }
        return ResultUtil.success("手机号校验成功！");
    }

    public Result updateLabel(BifDispatchHumanResource bifDispatchHumanResource) {
        if(mapper.updateLabel(bifDispatchHumanResource)>0){
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("失败");
    }

    public Result updateLabels(BifDispatchHumanResource bifDispatchHumanResource) {

        //更新派工人员标签
        mapper.updateLabel(bifDispatchHumanResource);

        mapper.updateCustomLable(bifDispatchHumanResource);
        return ResultUtil.success();
    }
}

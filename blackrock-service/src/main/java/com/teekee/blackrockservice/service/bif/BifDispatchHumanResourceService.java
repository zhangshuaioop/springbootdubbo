package com.teekee.blackrockservice.service.bif;

import com.alibaba.fastjson.JSONObject;
import com.teekee.blackrockservice.utils.*;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.bif.*;
import com.teekee.blackrockservice.entity.sys.SysAppToken;
import com.teekee.blackrockservice.entity.sys.SysUserWechatRelation;
import com.teekee.blackrockservice.entity.trc.SmsParam;
import com.teekee.blackrockservice.entity.trc.TrcSmsLog;
import com.teekee.blackrockservice.mapper.bif.BifDispatchHrAutonymValidMapper;
import com.teekee.blackrockservice.mapper.bif.BifDispatchHumanResourceMapper;
import com.teekee.blackrockservice.mapper.sys.SysAppTokenMapper;
import com.teekee.blackrockservice.mapper.sys.SysUserWechatRelationMapper;
import com.teekee.blackrockservice.mapper.trc.TrcSmsLogMapper;
import com.teekee.commoncomponets.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Service
public class BifDispatchHumanResourceService extends BaseService<BifDispatchHumanResourceMapper,BifDispatchHumanResource> {

    @Value("${messenger.sendSms}")
    private String sendSmsUrl;

    @Resource
    BifDispatchHumanResourceMapper mapper;
    @Resource
    SysAppTokenMapper tokenMapper;
    @Resource
    TrcSmsLogMapper trcSmsLogMapper;
    @Resource
    BifDispatchHrAutonymValidMapper validMapper;
    @Resource
    SysUserWechatRelationMapper wechatMapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务商APP登录
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/02
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage serviceLogin(HumanResourceLoginParam param) {
        Date now = new Date();

        if (param.getAccount().equals("") || param.getAccount() == null) {
            return StringUtil.buildErrorRespMsg("账号不能为空！");
        }
        if (param.getPassword().equals("") || param.getPassword() == null) {
            return StringUtil.buildErrorRespMsg("密码不能为空！");
        }
        if (param.getAccount().equals("") && param.getPassword().equals("")) {
            return StringUtil.buildErrorRespMsg("账号,密码不能为空！");
        }
        Boolean account = mapper.selectByAccount(param.getAccount());
        if(account == false) {
            return StringUtil.buildErrorRespMsg("账号不存在，请注册！");
        }
        param.setPassword(Encrypt.getMD5Str(param.getPassword()));
        BifDispatchHumanResource resource = mapper.serviceLogin(param);
        if (resource != null) {
            //账号是否被冻结
            if(resource.getFlagAvailable() == false) {
                return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                        "请拨打400-820-6440进行账户解冻！");
            }
            GetHumanResourceLogin login = new GetHumanResourceLogin();
            login.setId(resource.getId());
            login.setMobile(param.getAccount());
            SysAppToken tokenParam = new SysAppToken();
            tokenParam.setSource("APP");
            tokenParam.setUserId(resource.getId());
            SysAppToken sysToken = tokenMapper.getTokenByUerId(tokenParam);
            SysAppToken appToken = new SysAppToken();
            //生成token
            String token = UUID.randomUUID().toString();
            if(sysToken == null){
                appToken.setSource("APP");
                appToken.setAccountType("MOBILE");
                appToken.setUserId(resource.getId());
                appToken.setToken(token);
                appToken.setCreateTime(now);
                appToken.setExpiredTime(DateUtil.addOneDay(now));
                appToken.setFlagAvaliable(true);
                tokenMapper.insertSelective(appToken);
            }else {
                appToken.setUserId(resource.getId());
                appToken.setToken(token);
                appToken.setSource("APP");
                tokenMapper.updateByUserId(appToken);
            }


            //返回token值
            login.setToken(token);
            ResponseMessage message = StringUtil.buildSuccessRespMsg("登录成功！");
            message.setData(login);
            return message;
        }
        return StringUtil.buildErrorRespMsg("账号密码错误！");
    }
    /**
     * 服务商小程序
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage serviceRegister(HumanResourceLoginParam param) {
        Date now = new Date();
        if(param.getFirstName().equals("") || param.getFirstName() == null){
            return StringUtil.buildErrorRespMsg("姓不能为空！");
        }
        if(param.getLastName().equals("") || param.getLastName() == null){
            return StringUtil.buildErrorRespMsg("名不能为空！");
        }
        if(param.getAccount().equals("") || param.getAccount() == null){
            return StringUtil.buildErrorRespMsg("账号不能为空！");
        }
        if(param.getKeyword() == null || param.getKeyword().equals("")){
            return StringUtil.buildErrorRespMsg("验证码不能为空！");
        }
        if(param.getPassword().equals("") || param.getPassword() == null){
            return StringUtil.buildErrorRespMsg("密码不能为空！");
        }
        //手机号是否已注册
        Boolean isRegister = mapper.selectByAccount(param.getAccount());
        if(isRegister == true){
            return StringUtil.buildErrorRespMsg("该手机号已注册，请登录！");
        }
        //验证码为六位数纯数字
        if(!param.getKeyword().matches("^\\d{6}$")){
            return StringUtil.buildErrorRespMsg("验证码格式不正确！");
        }
        //判断验证码是否匹配
        TrcSmsLog trcSmsLog = trcSmsLogMapper.selectByMobileAndKey(param);
        if(trcSmsLog == null){
            return StringUtil.buildErrorRespMsg("验证码错误，请重新输入！");
        }
        //验证码已失效
        if(trcSmsLog.getValidTime().before(now)){
            return StringUtil.buildErrorRespMsg("该验证码已失效，请重新获取验证码！");
        }
        //判断密码是否为六到十二位的数字字和字母
        if(!ValidateUtil.isLetterDigit(param.getPassword())){
            return StringUtil.buildErrorRespMsg("请输入6-12位数字或字母的密码！");
        }

        //查询该手机号是否存在
        BifDispatchHumanResource mobile = mapper.selectByMobile(param.getAccount());
        if(mobile != null && mobile.getFlagAvailable() == false){
            return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                    "请拨打400-820-6440进行账户解冻！");
        }
        BifDispatchHumanResource resource = new BifDispatchHumanResource();
        //存在该手机号
        if(mobile != null){
            resource.setFirstName(param.getFirstName());
            resource.setLastName(param.getLastName());
            resource.setAccount(param.getAccount());
            resource.setPassword(Encrypt.getMD5Str(param.getPassword()));
            resource.setId(mobile.getId());
            resource.setRegisterTime(now);
            mapper.updateByPrimaryKeySelective(resource);
        }else{
            resource.setFirstName(param.getFirstName());
            resource.setLastName(param.getLastName());
            resource.setValidStatus("NEW");
            resource.setAccount(param.getAccount());
            resource.setMobile(param.getAccount());
            resource.setRegisterTime(now);
            resource.setCreateTime(now);
            resource.setPassword(Encrypt.getMD5Str(param.getPassword()));
            resource.setDispatchSuccessfulCount(0);
            resource.setDispatchAvgFee(new BigDecimal(0.0));
            resource.setDispatchTotalFee(new BigDecimal(0.0));
            resource.setDispatchMaxFee(new BigDecimal(0.0));
            resource.setFlagDeleted(false);
            resource.setFlagAvailable(true);
            resource.setUpdateTime(now);
            resource.setUserAssessmentCount(0);
            resource.setContactAssessmentCount(0);
            resource.setClientAssessmentCount(0);
            resource.setUserAssmAchieveTotalPoint(0);
            resource.setUserAssmCommunicationTotalPoint(0);
            resource.setUserAssmTimelyTotalPoint(0);
            resource.setUserAssmAchieveAvgPoint(new BigDecimal(0.0));
            resource.setUserAssmCommunicationAvgPoint(new BigDecimal(0.0));
            resource.setUserAssmTimelyAvgPoint(new BigDecimal(0.0));
            resource.setClientAssmAchieveTotalPoint(0);
            resource.setClientAssmCommunicationTotalPoint(0);
            resource.setClientAssmTimelyTotalPoint(0);
            resource.setClientAssmAchieveAvgPoint(new BigDecimal(0.0));
            resource.setClientAssmCommunicationAvgPoint(new BigDecimal(0.0));
            resource.setClientAssmTimelyAvgPoint(new BigDecimal(0.0));
            resource.setContactAssmTotalPoint(new BigDecimal(5));
            resource.setContactAssmAvgPoint(0);
            resource.setUserEvaluatePoint(new BigDecimal(18));
            mapper.insertSelective(resource);
        }
        if(trcSmsLog != null){
            //设置验证码已使用
            TrcSmsLog setFlagVaild = new TrcSmsLog();
            setFlagVaild.setId(trcSmsLog.getId());
            setFlagVaild.setFlagValid(true);
            trcSmsLogMapper.updateByPrimaryKeySelective(setFlagVaild);
        }
        GetHumanResourceLogin login = new GetHumanResourceLogin();
        login.setId(resource.getId());
        login.setMobile(param.getAccount());
        ResponseMessage message = StringUtil.buildSuccessRespMsg("注册成功！");
        message.setData(login);
        return message;
    }


    /**
     * 发送验证码
     * @param smsParam
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    public ResponseMessage getCode(SmsParam smsParam) throws UnsupportedEncodingException {
        //手机号是否为空
        if(smsParam.getMobile() == null || smsParam.equals("")){
            return StringUtil.buildErrorRespMsg("请填写手机号！");
        }
        //判断手机号是否为纯数字
        if(!ValidateUtil.isNumericType(smsParam.getMobile())){
            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
        }
        //判断手机是否为1开11位
        if(!ValidateUtil.isPhoneStart(smsParam.getMobile())){
            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
        }
        //验证手机号是否被注册
//        BifDispatchHumanResource mobile = mapper.selectByMobile(smsParam.getMobile());
//        if(mobile!= null){
//            return StringUtil.buildErrorRespMsg("该手机号已被注册！");
//         }else{
//            return StringUtil.buildErrorRespMsg("该手机号未被注册！");
//        }
        TrcSmsLog log = new TrcSmsLog();
        log.setSendModule("wechat");
        log.setUserId(0);
        log.setMobile(smsParam.getMobile());
        log.setCreateTime(new Date());
        log.setFlagValid(false);
        trcSmsLogMapper.insertSelective(log);

        smsParam.setTrcSmsLogId(log.getId());
        smsParam.setMessageId(UUID.randomUUID().toString()); //请求唯一id
        smsParam.setBusinessType("YZM");    //模板类型为验证码

        Result result = restTemplate.postForObject(sendSmsUrl, smsParam, Result.class);
        String hhh = result.getMsg();
        return StringUtil.buildSuccessRespMsg(result.getMsg());
    }

//    /**
//     * 发送验证码
//     * @param smsParam
//     * @return
//     * @Author:Niting
//     * @Date:2018/11/03
//     */
//    public ResponseMessage getCode(SmsParam smsParam) throws UnsupportedEncodingException {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
//        String currTime = sdf.format(date);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String curr = dateFormat.format(date);
//        String custid = curr+getRandom();
//        String code = getRandom();
//        //手机号是否为空
//        if(smsParam.getMobile() == null || smsParam.equals("")){
//            return StringUtil.buildErrorRespMsg("请填写手机号！");
//        }
//        //判断手机号是否为纯数字
//        if(!ValidateUtil.isNumericType(smsParam.getMobile())){
//            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
//        }
//        //判断手机是否为1开11位
//        if(!ValidateUtil.isPhoneStart(smsParam.getMobile())){
//            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
//        }
//
//        //短信模板
//        String content = "验证码："+code+"，验证码5分钟内有效，如非本人操作请忽略，谢谢。";
//        String mobile = smsParam.getMobile();
//        String url = "http://120.204.199.44:8026/sms/v2/std/single_send";
//        Map<String,String> param = new HashMap<String, String>();
//        //短信参数
//        String md5 =  Encrypt.getMD5Str("JE0223"+"00000000"+"321626"+currTime);
//        param.put("userid","JE0223");
//        param.put("pwd",md5);
//        param.put("mobile",mobile);
//        param.put("content",content);
//        param.put("timestamp",currTime);
//        param.put("svrtype","SMS001");
//        param.put("exno","0");
//        param.put("custid",custid);
//        param.put("exdata","");
//        String s = HttpUtils.sendHttpPost(url, param);
//        TrcSmsLog log = new TrcSmsLog();
//        JSONObject json = JSONObject.parseObject(s);
//        String result = json.getString("result");
//        //短信是否发送成功
//        if(result.equals("0")){
//            log.setFlagSendSuccessful(true);
//        }
//        log.setSendModule("wechat");
//        log.setKeyword(code);
//        log.setContent(URLDecoder.decode(content, "UTF-8"));
//        log.setUserId(0);
//        log.setMobile(mobile);
//        log.setSerialNumber(custid);
//        log.setCreateTime(date);
//        log.setFlagValid(false);
//        Date afterDate = new Date(date .getTime() + 300000);
//        log.setValidTime(afterDate);
//        trcSmsLogMapper.insertSelective(log);
//        if(result.equals("0")){
//            return StringUtil.buildSuccessRespMsg("短信发送成功！");
//        }
//        //System.out.println(s);
//        return StringUtil.buildErrorRespMsg("短信发送失败！");
//    }

    /**
     * 服务商APP找回密码
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage retrievePassword(HumanResourceLoginParam param) {
        Date now = new Date();
        if(param.getAccount().equals("") || param.getAccount() == null){
            return StringUtil.buildErrorRespMsg("账号不能为空！");
        }
        //判断手机号是否为纯数字
        if(!ValidateUtil.isNumericType(param.getAccount())){
            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
        }
        //判断手机是否为1开11位
        if(!ValidateUtil.isPhoneStart(param.getAccount())){
            return StringUtil.buildErrorRespMsg("请填写正确手机号！");
        }
        //验证码非空验证
        if(param.getKeyword().equals("") || param.getKeyword() == null){
            return StringUtil.buildErrorRespMsg("验证码不能为空！");
        }
        //密码非空验证
        if(param.getPassword().equals("") || param.getPassword() == null){
            return StringUtil.buildErrorRespMsg("密码不能为空！");
        }
        //判断验证码是否匹配
        TrcSmsLog trcSmsLog = trcSmsLogMapper.selectByMobileAndKey(param);
        if(trcSmsLog == null){
            return StringUtil.buildErrorRespMsg("验证码错误，请重新输入！");
        }
        //验证码已失效
        if(trcSmsLog.getValidTime().before(now)){
            return StringUtil.buildErrorRespMsg("该验证码已失效，请重新获取验证码！");
        }
        //判断密码是否为六到十二位的数字字和字母
        if(!ValidateUtil.isLetterDigit(param.getPassword())){
            return StringUtil.buildErrorRespMsg("请输入6-12位数字或字母的密码！");
        }

        //是否存在该账号
        Boolean isAccount = mapper.selectByAccount(param.getAccount());
        if(isAccount){
            //修改密码
            BifDispatchHumanResource resource = new BifDispatchHumanResource();
            resource.setAccount(param.getAccount());
            resource.setPassword(Encrypt.getMD5Str(param.getPassword()));
            int result = mapper.updatePasswordByAccount(resource);

            //设置验证码已使用
            TrcSmsLog setFlagVaild = new TrcSmsLog();
            setFlagVaild.setId(trcSmsLog.getId());
            setFlagVaild.setFlagValid(true);
            trcSmsLogMapper.updateByPrimaryKeySelective(setFlagVaild);

            if(result > 0){
                return StringUtil.buildSuccessRespMsg("重置密码成功！");
            }
            return StringUtil.buildErrorRespMsg("重置密码失败！");
        }
        return StringUtil.buildErrorRespMsg("请输入正确手机号！");
    }

    /**
     *  服务商基础信息
     *  @Author Niting
     *  @date 2018/11/03
     */
    public BifDispatchHumanResourceInfoShow serviceInfo(Integer id) {
        return mapper.selectServiceInfoById(id);
    }

    /**
     *  编辑服务商个人信息编辑
     *  @Author Liukan
     *  @date 2018/7/17
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage serviceEdit(BifDispatchHumanResourceInfoShow info, Integer id) {
        if(info.getQq() != null || info.getWechat() != null){
            if( ValidateUtil.isChinese(info.getQq())) return StringUtil.buildErrorRespMsg("QQ不能为汉字");
            if( ValidateUtil.isChinese(info.getWechat())) return StringUtil.buildErrorRespMsg("微信不能为汉字");
        }
        if(id != 0){
            info.setId(id);
            mapper.updateByServiceId(info);
            return StringUtil.buildSuccessRespMsg("编辑成功！");
        }
        return StringUtil.buildErrorRespMsg("编辑失败！");
    }

    /**
     * 服务商认证信息查询
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    public GetHumanResourceServiceInfoShow serviceInfoShow(Integer id) {
        if(id != null || id != 0){
            GetHumanResourceServiceInfoShow result = mapper.selectInfoById(id);
            if(result != null){
                return result;
            }
            return new GetHumanResourceServiceInfoShow();
        }
        return new GetHumanResourceServiceInfoShow();
    }

    /**
     * 服务商认证信息新增&编辑
     * @param resourceParam
     * @param validParam
     * @Author:Niting
     * @Date:2018/07/19
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage handleServiceInfo(BifDispatchHumanResource resourceParam, BifDispatchHrAutonymValid validParam) {
        Date now = new Date();
        int result = 0;

        //姓氏为空
        if(resourceParam.getFirstName() == null || resourceParam.getFirstName().equals("")){
            return StringUtil.buildErrorRespMsg("请输入姓！");
        }
        //名字为空
        if(resourceParam.getLastName() == null || resourceParam.getLastName().equals("")){
            return StringUtil.buildErrorRespMsg("请输入名！");
        }
        //证件类型为空
        if(validParam.getIdType() == null || validParam.getIdType().equals("")){
            return StringUtil.buildErrorRespMsg("请选择证件类型！");
        }
        //证件号码为空
        if(validParam.getIdCode() == null || validParam.getIdCode().equals("")){
            return StringUtil.buildErrorRespMsg("请填写证件号码！");
        }
        //证件照正面为空
        if(validParam.getPositiveImageUrl() == null || validParam.getPositiveImageUrl().equals("")){
            return StringUtil.buildErrorRespMsg("请上传证件正面照！");
        }
        //证件照反面为空
        if(validParam.getContraryImageUrl() == null || validParam.getContraryImageUrl().equals("")){
            return StringUtil.buildErrorRespMsg("请上传证件反面照！");
        }
        //手持证件照为空
        if(validParam.getHandheldImageUrl() == null || validParam.getHandheldImageUrl().equals("")){
            return StringUtil.buildErrorRespMsg("请上传手持证件照！");
        }

        BifDispatchHrAutonymValid valid = validMapper.selectByHrId(resourceParam.getId());
        BifDispatchHrAutonymValid validRecord = new BifDispatchHrAutonymValid();
        //没有信息则新增
        if(valid == null){
            //将审核状态更新为提交审核
            resourceParam.setValidApplyTime(now);
            resourceParam.setValidStatus("SUBMIT");
            mapper.updateByPrimaryKeySelective(resourceParam);

            //新增实名信息
            validRecord.setUserId(resourceParam.getId());
            validRecord.setUserName(resourceParam.getFirstName()+resourceParam.getLastName());
            validRecord.setIdType(validParam.getIdType());
            validRecord.setIdCode(validParam.getIdCode());
            validRecord.setPositiveImageUrl(validParam.getPositiveImageUrl());
            validRecord.setContraryImageUrl(validParam.getContraryImageUrl());
            validRecord.setHandheldImageUrl(validParam.getHandheldImageUrl());
            validRecord.setFlagLast(true);
            validRecord.setFlagValidStatus(false);
            validRecord.setCreateTime(now);
            result = validMapper.insertSelective(validRecord);
        }else{
            //根据hrid设置之前的不为最新
            BifDispatchHrAutonymValid setFlagLast = new BifDispatchHrAutonymValid();
            setFlagLast.setUserId(resourceParam.getId());
            setFlagLast.setFlagLast(false);
            validMapper.updateFlagLastByHrId(setFlagLast);


            //再次新增
            validParam.setUserId(resourceParam.getId());
            validParam.setFlagLast(true);
            validParam.setFlagValidStatus(false);
            validParam.setCreateTime(now);
            validParam.setUserName(resourceParam.getFirstName()+resourceParam.getLastName());
            if( validMapper.insertSelective(validParam) > 0 ){
                //将审核状态更新为重新提交审核
                BifDispatchHumanResource resource = new BifDispatchHumanResource();
                resource.setFirstName(resourceParam.getFirstName());
                resource.setLastName(resourceParam.getLastName());
                resource.setId(resourceParam.getId());
                resource.setValidStatus("RESUBMIT");
                resource.setIdCode(resourceParam.getIdCode());
                resource.setIdType(resourceParam.getIdType());
                resource.setValidApplyTime(now);
                mapper.updateByPrimaryKeySelective(resource);

                return StringUtil.buildSuccessRespMsg("信息提交成功！");
            }
        }
        if(result > 0){
            return StringUtil.buildSuccessRespMsg("信息提交成功！");
        }
        return StringUtil.buildErrorRespMsg("信息提交失败！");
    }

    /**
     * 查询关联公司&发票

     * @return
     * @Author:Niting
     * @Date:2018/11/03
     * @param hrId
     */
    public GetHumanResourceCompanyInvoice companyInvoiceShow(Integer hrId) {
        GetHumanResourceCompanyInvoice result = mapper.selectCompanyInvoiceById(hrId);
        if(result != null){
            return result;
        }
        return new GetHumanResourceCompanyInvoice();
    }

    /**
     * 编辑关联公司&发票信息
     * @param resource
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage updateCompanyInvoice(BifDispatchHumanResource resource) {
        Date now = new Date();
        if(resource != null){
            if(resource.getProvideInvoiceRate() == null){
                resource.setProvideInvoiceRate(new BigDecimal(0));
            }
            resource.setUpdateTime(now);
            int result = mapper.updateCompanyInvoice(resource);
            if(result >0){
                return StringUtil.buildSuccessRespMsg("编辑信息成功！");
            }
        }
        return StringUtil.buildErrorRespMsg("编辑信息失败！");
    }

    private String getRandom() {

        String result = "";

        while (result.length() < 6) {
            String str = String.valueOf((int)(Math.random()*10));
            if(result.indexOf(str) == -1){
                result += str;
            }
        }
        return result;
    }

    /**
     * 服务商小程序登录
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/11
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage wechatLogin(HumanResourceLoginParam param) {
        Date now = new Date();
        if(param.getAccount().equals("") || param.getAccount() == null){
            return StringUtil.buildErrorRespMsg("账号不能为空！");
        }
        if(param.getPassword().equals("") || param.getPassword() == null){
            return StringUtil.buildErrorRespMsg("密码不能为空！");
        }
        if(param.getAccount().equals("") && param.getPassword().equals("")) {
            return StringUtil.buildErrorRespMsg("账号,密码不能为空！");
        }
        Boolean account = mapper.selectByAccount(param.getAccount());
        if(account == false) {
            return StringUtil.buildErrorRespMsg("账号不存在，请注册！");
        }
        param.setPassword(Encrypt.getMD5Str(param.getPassword()));
        BifDispatchHumanResource resource = mapper.serviceLogin(param);
        if(resource == null){
            return StringUtil.buildErrorRespMsg("账号密码输入错误！");
        }
        SysUserWechatRelation wechatRelation = new SysUserWechatRelation();
        GetOpenId getOpenId = new GetOpenId();
        //获取openid
        String jsonId = getOpenId.getopenid(param.getCode(),"service");
        JSONObject jsonObject = JSONObject.parseObject(jsonId);
        //从json字符串获取openid和session_key
        String openid=jsonObject.getString("openid");
        String sessionKey=jsonObject.getString("session_key");
        //查询改openid是否存在
        SysUserWechatRelation openidParam = new SysUserWechatRelation();
        openidParam.setWechatOpenId(openid);
        openidParam.setUserType("DISPATCH_HR");
        Boolean openIdresult = wechatMapper.queryByWechatOpenId(openidParam);

        if(openid != null){
            //没有openid新增 没有则更新
            if(openIdresult == false){
                wechatRelation.setFlagDeleted(false);
                wechatRelation.setUserType("DISPATCH_HR");
                wechatRelation.setCreateTime(now);
                wechatRelation.setLastLoginTime(now);
                wechatRelation.setWechatOpenId(openid);
                wechatRelation.setSessionKey(sessionKey);
                wechatRelation.setUserId(resource.getId());
                wechatMapper.insertSelective(wechatRelation);
            }else{
                wechatRelation.setLastLoginTime(now);
                wechatRelation.setWechatOpenId(openid);
                wechatRelation.setSessionKey(sessionKey);
                wechatRelation.setUserId(resource.getId());
                wechatMapper.updateByWechatOpenId(wechatRelation);
            }

            if(resource != null){
                //账号是否被冻结
                if(resource.getFlagAvailable() == false) {
                    return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                            "请拨打400-820-6440进行账户解冻！");
                }
                SysAppToken tokenParam = new SysAppToken();
                tokenParam.setSource("WECHAT");
                tokenParam.setUserId(resource.getId());
                SysAppToken sysToken = tokenMapper.getTokenByUerId(tokenParam);
                SysAppToken appToken = new SysAppToken();
                //生成token
                String token = UUID.randomUUID().toString();
                if(sysToken == null){
                    appToken.setSource("WECHAT");
                    appToken.setAccountType("WECHAT");
                    appToken.setWechatOpenId(openid);
                    appToken.setUserId(resource.getId());
                    appToken.setToken(token);
                    appToken.setCreateTime(now);
                    appToken.setExpiredTime(DateUtil.addOneDay(now));
                    appToken.setFlagAvaliable(true);
                    tokenMapper.insertSelective(appToken);
                }else {
                    appToken.setUserId(resource.getId());
                    //appToken.setId(sysToken.getId());
                    appToken.setToken(token);
                    appToken.setSource("WECHAT");
                    tokenMapper.updateByUserId(appToken);
                }

                GetHumanResourceLogin login = new GetHumanResourceLogin();
                login.setId(resource.getId());
                login.setWechatOpenId(openid);
                login.setMobile(param.getAccount());
                login.setToken(token);
                ResponseMessage message = StringUtil.buildSuccessRespMsg("登录成功！");
                message.setData(login);
                return message;
            }
        }
        return StringUtil.buildErrorRespMsg("登录验证失败！");
    }

    /**
     * 服务商小程序自动登录
     * @param token
     * @return
     * @Author:Niting
     * @Date:2018/11/11
     */
    public ResponseMessage serviceAutoLogin(String token) {
        SysAppToken appToken = tokenMapper.queryToken(token);
        if(appToken != null){
            BifDispatchHumanResource resource = mapper.selectByHrId(appToken.getUserId());
            if(resource == null){
                return StringUtil.buildErrorRespMsg("自动登录失败！");
            }
            GetHumanResourceLogin login = new GetHumanResourceLogin();
            login.setId(resource.getId());
            login.setWechatOpenId(appToken.getWechatOpenId());
            login.setMobile(resource.getMobile());
            login.setToken(token);
            ResponseMessage message = StringUtil.buildSuccessRespMsg("登录成功！");
            message.setData(login);
            return message;
        }
        return StringUtil.buildSuccessRespMsg("自动登录失败！");
    }

    /**
     * 微信小程序手机验证码登录
     *
     * @param param
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/19
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage tellLogin(HumanResourceLoginParam param) {


        Date now = new Date();
        if(param.getAccount().equals("") || param.getAccount() == null){
            return StringUtil.buildErrorRespMsg("手机号不能为空！");
        }
        //判断手机号是否注册
        boolean tellReturn = mapper.selectByAccount(param.getAccount());
        if(tellReturn==false){
            return StringUtil.buildErrorRespMsg("手机号未注册！");
        }
        //判断手机号状态
        BifDispatchHumanResource resource = new BifDispatchHumanResource();
        resource = mapper.selectStateByAccount(param.getAccount());
        if(resource.getFlagAvailable()==false){
            return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                    "请拨打400-820-6440进行账户解冻！");
        }
        if(param.getCode().equals("") || param.getCode() == null) {
            return StringUtil.buildErrorRespMsg("验证码不能为空！");
        }
        //判断验证码是否匹配
        TrcSmsLog trcSmsLog = trcSmsLogMapper.selectByMobileAndKey(param);
        if(trcSmsLog == null){
            return StringUtil.buildErrorRespMsg("验证码错误，请重新输入！");
        }
        SysUserWechatRelation wechatRelation = new SysUserWechatRelation();
        GetOpenId getOpenId = new GetOpenId();
        //获取openid
        String jsonId = getOpenId.getopenid(param.getCode(),"service");
        JSONObject jsonObject = JSONObject.parseObject(jsonId);
        //从json字符串获取openid和session_key
        String openid=jsonObject.getString("openid");
        String sessionKey=jsonObject.getString("session_key");
        //查询改openid是否存在
        SysUserWechatRelation openidParam = new SysUserWechatRelation();
        openidParam.setWechatOpenId(openid);
        openidParam.setUserType("DISPATCH_HR");
        Boolean openIdresult = wechatMapper.queryByWechatOpenId(openidParam);

        if (openid != null) {
            //没有openid新增 没有则更新
            if (openIdresult == false) {
                wechatRelation.setFlagDeleted(false);
                wechatRelation.setUserType("DISPATCH_HR");
                wechatRelation.setCreateTime(now);
                wechatRelation.setLastLoginTime(now);
                wechatRelation.setWechatOpenId(openid);
                wechatRelation.setSessionKey(sessionKey);
                wechatRelation.setUserId(resource.getId());
                wechatMapper.insertSelective(wechatRelation);
            } else {
                wechatRelation.setLastLoginTime(now);
                wechatRelation.setWechatOpenId(openid);
                wechatRelation.setSessionKey(sessionKey);
                wechatRelation.setUserId(resource.getId());
                wechatMapper.updateByWechatOpenId(wechatRelation);
            }

            if (resource != null) {
                //账号是否被冻结
                if(resource.getFlagAvailable() == false) {
                    return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                            "请拨打400-820-6440进行账户解冻！");
                }
                SysAppToken tokenParam = new SysAppToken();
                tokenParam.setSource("WECHAT");
                tokenParam.setUserId(resource.getId());
                SysAppToken sysToken = tokenMapper.getTokenByUerId(tokenParam);
                SysAppToken appToken = new SysAppToken();
                //生成token
                String token = UUID.randomUUID().toString();
                if (sysToken == null) {
                    appToken.setSource("WECHAT");
                    appToken.setAccountType("MOBILE");
                    appToken.setWechatOpenId(openid);
                    appToken.setUserId(resource.getId());
                    appToken.setToken(token);
                    appToken.setCreateTime(now);
                    appToken.setExpiredTime(DateUtil.addOneDay(now));
                    appToken.setFlagAvaliable(true);
                    tokenMapper.insertSelective(appToken);
                } else {
                    appToken.setUserId(resource.getId());
                    appToken.setToken(token);
                    tokenMapper.updateByUserId(appToken);
                }

                GetHumanResourceLogin login = new GetHumanResourceLogin();
                login.setId(resource.getId());
                login.setWechatOpenId(openid);
                login.setMobile(param.getAccount());
                login.setToken(token);
                ResponseMessage message = StringUtil.buildSuccessRespMsg("登录成功！");
                message.setData(login);
                return message;
            }
        }
        return StringUtil.buildErrorRespMsg("登录验证失败！");

    }

    /**
     * app手机验证码登录
     *
     * @param param
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/19
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage appTellLogin(HumanResourceLoginParam param) {
        Date now = new Date();
        if(param.getAccount().equals("") || param.getAccount() == null){
            return StringUtil.buildErrorRespMsg("手机号不能为空！");
        }
        //判断手机号是否注册
        boolean tellReturn = mapper.selectByAccount(param.getAccount());
        if(tellReturn==false){
            return StringUtil.buildErrorRespMsg("手机号未注册！");
        }
        //判断手机号状态
        BifDispatchHumanResource resource = new BifDispatchHumanResource();
        resource = mapper.selectStateByAccount(param.getAccount());
        if(resource.getFlagAvailable()==false){
            return StringUtil.buildErrorRespMsg("您的账号已被冻结\n" +
                    "请拨打400-820-6440进行账户解冻！");
        }
        if(param.getKeyword().equals("") || param.getKeyword() == null) {
            return StringUtil.buildErrorRespMsg("验证码不能为空！");
        }
        //判断验证码是否匹配
        TrcSmsLog trcSmsLog = trcSmsLogMapper.selectByMobileAndKey(param);
        if(trcSmsLog == null){
            return StringUtil.buildErrorRespMsg("验证码错误，请重新输入！");
        }

        if (resource != null) {

            GetHumanResourceLogin login = new GetHumanResourceLogin();
            login.setId(resource.getId());
            login.setMobile(param.getAccount());
            SysAppToken tokenParam = new SysAppToken();
            tokenParam.setSource("APP");
            tokenParam.setUserId(resource.getId());
            SysAppToken sysToken = tokenMapper.getTokenByUerId(tokenParam);
            SysAppToken appToken = new SysAppToken();
            //生成token
            String token = UUID.randomUUID().toString();
            if(sysToken == null){
                appToken.setSource("APP");
                appToken.setAccountType("MOBILE");
                appToken.setUserId(resource.getId());
                appToken.setToken(token);
                appToken.setCreateTime(now);
                appToken.setExpiredTime(DateUtil.addOneDay(now));
                appToken.setFlagAvaliable(true);
                tokenMapper.insertSelective(appToken);
            }else {
                appToken.setUserId(resource.getId());
                appToken.setToken(token);
                appToken.setSource("APP");
                tokenMapper.updateByUserId(appToken);
            }

            //返回token值
            login.setToken(token);

            ResponseMessage message = StringUtil.buildSuccessRespMsg("登录成功！");
            message.setData(login);
            return message;
        }
        return StringUtil.buildErrorRespMsg("账号密码错误！");

    }
}

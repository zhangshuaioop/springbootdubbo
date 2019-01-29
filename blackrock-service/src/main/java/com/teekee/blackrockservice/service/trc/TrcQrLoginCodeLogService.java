package com.teekee.blackrockservice.service.trc;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.sys.SysAppToken;
import com.teekee.blackrockservice.entity.sys.SysUserWechatRelation;
import com.teekee.blackrockservice.entity.trc.ParamTrcQrLoginVerify;
import com.teekee.blackrockservice.entity.trc.TrcQrLoginCodeLog;
import com.teekee.blackrockservice.mapper.sys.SysAppTokenMapper;
import com.teekee.blackrockservice.mapper.sys.SysUserWechatRelationMapper;
import com.teekee.blackrockservice.mapper.trc.TrcQrLoginCodeLogMapper;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author Niting
 * @date 2018/11/21
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class TrcQrLoginCodeLogService extends BaseService<TrcQrLoginCodeLogMapper,TrcQrLoginCodeLog>{
    @Resource
    private TrcQrLoginCodeLogMapper mapper;
    @Resource
    private SysUserWechatRelationMapper wechatRelationMapper;
    @Resource
    private SysAppTokenMapper appTokenMapper;
    /**
     * 服务商二维码登录验证
     * @param param
     * @param hrId
     * @return
     * @Author:Niting
     * @Date:2018/08/22
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage verifyQrCode(ParamTrcQrLoginVerify param, Integer hrId) {
        Date now = new Date();
        TrcQrLoginCodeLog qrCode = mapper.selectByCode(param.getCode());
        if(qrCode == null){
            return StringUtil.buildErrorRespMsg("登录失败！");
        }
        if(qrCode.getAvaliableTime().getTime() < now.getTime()){
            return StringUtil.buildErrorRespMsg("二维码已失效！");
        }
        SysUserWechatRelation wechatRelation = wechatRelationMapper.queryContact(param.getWechatOpenId());
        if(wechatRelation == null){
            return StringUtil.buildErrorRespMsg("登录失败！");
        }
        TrcQrLoginCodeLog record = new TrcQrLoginCodeLog();
        record.setId(qrCode.getId());
        record.setFlagUsed(true);
        record.setUserId(wechatRelation.getUserId());
        record.setUseTime(now);
        int result = mapper.updateByPrimaryKeySelective(record);
        if(result >0){
            return StringUtil.buildSuccessRespMsg("登录成功！");
        }
        return StringUtil.buildErrorRespMsg("登录失败！");
    }

    /**
     * APP服务商二维码登录验证
     * @param param
     * @param token
     * @return
     * @Author:Niting
     * @Date:2018/08/22
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage AppVerifyQrCode(ParamTrcQrLoginVerify param, String token) {
        Date now = new Date();
        TrcQrLoginCodeLog qrCode = mapper.selectByCode(param.getCode());
        if(qrCode == null){
            return StringUtil.buildErrorRespMsg("登录失败！");
        }
        if(qrCode.getAvaliableTime().getTime() < now.getTime()){
            return StringUtil.buildErrorRespMsg("二维码已失效！");
        }
        SysAppToken tokenValidity = appTokenMapper.getTokenValidity(token);
        if(tokenValidity == null){
            return StringUtil.buildErrorRespMsg("登录失败！");
        }
        TrcQrLoginCodeLog record = new TrcQrLoginCodeLog();
        record.setId(qrCode.getId());
        record.setFlagUsed(true);
        record.setUserId(tokenValidity.getUserId());
        record.setUseTime(now);
        int result = mapper.updateByPrimaryKeySelective(record);
        if(result >0){
            return StringUtil.buildSuccessRespMsg("登录成功！");
        }
        return StringUtil.buildErrorRespMsg("登录失败！");
    }
}

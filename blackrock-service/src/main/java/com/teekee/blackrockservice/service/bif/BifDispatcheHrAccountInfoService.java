package com.teekee.blackrockservice.service.bif;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrAccountInfo;
import com.teekee.blackrockservice.entity.bif.ListDispatchAccountInfo;
import com.teekee.blackrockservice.mapper.bif.BifDispatchHrAccountInfoMapper;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @date 2018/11/5
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BifDispatcheHrAccountInfoService extends BaseService<BifDispatchHrAccountInfoMapper, BifDispatchHrAccountInfo> {
    @Resource
    BifDispatchHrAccountInfoMapper mapper;

    /**
     * 查询账户列表
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     * @param hrId
     */
    public List<ListDispatchAccountInfo> payAcountList(Integer hrId) {
        List<ListDispatchAccountInfo> result = mapper.selectByHrId(hrId);
        if (result.size() >0) {
            return result;
        }
        return new ArrayList<ListDispatchAccountInfo>();
    }

    /**
     * 删除账户
     * @param id
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/05
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage deletePayAccount(Integer id) {
        if(id != 0){
            BifDispatchHrAccountInfo accountInfo = mapper.selectByPrimaryKey(id);
            int haif = mapper.selelctByHrId(accountInfo.getHrId());
            if(haif==1){
                return StringUtil.buildErrorRespMsg("删除账户失败，账户至少保留一条！");
            }
            BifDispatchHrAccountInfo param = new BifDispatchHrAccountInfo();
            param.setFlagDeleted(true);
            param.setId(id);
            int result = mapper.updateByPrimaryKeySelective(param);
            if(result > 0){
                //删除账户为默认账户
                if(accountInfo.getFlagDefault() == true){
                    BifDispatchHrAccountInfo lastAccount = mapper.selectLastTimeAccount(accountInfo.getHrId());
                    if(lastAccount != null){
                        lastAccount.setFlagDefault(true);
                        //没有默认账户  将最近更新账户设为默认
                        mapper.updateByPrimaryKeySelective(lastAccount);
                    }
                }

                return StringUtil.buildSuccessRespMsg("删除账户成功！");
            }else {
                return StringUtil.buildErrorRespMsg("删除账户失败！");
            }
        }
        return StringUtil.buildErrorRespMsg("删除账户失败！");
    }

    /**
     * 查询账户信息
     * @param id
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/5
     */
    public ListDispatchAccountInfo payAcountShow(Integer id) {
        ListDispatchAccountInfo result = mapper.selectById(id);
        if (result != null) {
            return result;
        }
        return new ListDispatchAccountInfo();
    }

    /**
     * 新增/编辑账户
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/07/20
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage handlePayAccount(BifDispatchHrAccountInfo param) {
        Date now = new Date();
        if("".equals(param.getPaymentMethod()) || param.getPaymentMethod() == null){
            return StringUtil.buildErrorRespMsg("请选择账户类型！");
        }
        if("".equals(param.getFullName()) || param.getFullName() == null){
            return StringUtil.buildErrorRespMsg("请输入户名！");
        }
        if(param != null && param.getId() != null){
            if(param.getFlagDefault() != null && param.getFlagDefault() == true){
                //取消原来默认区域
                BifDispatchHrAccountInfo setDefault = new BifDispatchHrAccountInfo();
                setDefault.setFlagDefault(false);
                setDefault.setHrId(param.getHrId());
                setDefault.setUpdateTime(now);
                mapper.updateDefaultByHrId(setDefault);
            }
            if(param.getId() == 0){
                //新增
                param.setCreateTime(now);
                param.setFlagDeleted(false);
                int resutl = mapper.insertSelective(param);
                if(resutl > 0 ){
                    return StringUtil.buildSuccessRespMsg("新增账户成功！");
                }else {
                    return StringUtil.buildSuccessRespMsg("新增账户域失败！");
                }
            }else {
                //编辑
                int resutl = mapper.updateByPrimaryKeySelective(param);

                if(param.getFlagDefault() == false){
                    BifDispatchHrAccountInfo accountInfo = mapper.selectDefaultByHrId(param.getHrId());
                    if(accountInfo == null){
                        BifDispatchHrAccountInfo lastAccount = mapper.selectLastTimeAccount(param.getHrId());
                        lastAccount.setFlagDefault(true);
                        //没有默认账户  将最近创建账户设为默认
                        mapper.updateByPrimaryKeySelective(lastAccount);
                    }
                }
                if(resutl > 0 ){
                    return StringUtil.buildSuccessRespMsg("编辑账户成功！");
                }else {
                    return StringUtil.buildSuccessRespMsg("编辑账户失败！");
                }
            }

        }
        return StringUtil.buildSuccessRespMsg("新增账户域失败！");
    }

}

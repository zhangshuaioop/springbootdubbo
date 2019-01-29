package com.teekee.blackrockservice.service.fdp;

import com.teekee.blackrockservice.utils.DateUtil;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.bif.BifServiceListParam;
import com.teekee.blackrockservice.entity.dmi.DmiBrandName;
import com.teekee.blackrockservice.entity.fdp.FdpFaultDispatchHrRelation;
import com.teekee.blackrockservice.entity.fdp.FdpRecentOrderList;
import com.teekee.blackrockservice.mapper.fdp.FdpFaultDispatchHrRelationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @Author Niting
 * @date 2018/11/7
 **/
@Service
public class FdpFaultDispatchHrRelationService extends BaseService<FdpFaultDispatchHrRelationMapper,FdpFaultDispatchHrRelation>{
    @Resource
    FdpFaultDispatchHrRelationMapper mapper;


    /**
     * 近期工单
     * @param serviceListParam
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/07
     */
    public List<FdpRecentOrderList> recentOrder(BifServiceListParam serviceListParam, Integer id) {

        serviceListParam.setId(id);
        List<FdpRecentOrderList> list = mapper.selectNoticeList(serviceListParam);
        Date now = new Date();

        for (FdpRecentOrderList ll: list
                ) {

            int  day = DateUtil.getDaysBetween(DateUtil.todayFirstDate() ,ll.getServiceTime());
            if(ll.getAmPm().equals("AM")){
                ll.setAmPm("上午");
            }
            if(ll.getAmPm().equals("PM")){
                ll.setAmPm("下午");
            }
            if(day==1){
                int day1= DateUtil.getDay(now);
                int day2= DateUtil.getDay(ll.getServiceTime());
                if(day1==day2){
                    ll.setYmd("今日");
                }
            }
            if(day==2){
                ll.setYmd("明日");
            }
            if(day==3){
                ll.setYmd("后日");
            }
        }
        return list;
    }

    /**
     * 工单筛选品牌
     * @param hrId
     * @return
     * @Author Chenliwen
     * @date 2018/11/07
     */
    public List<DmiBrandName> orderBrand(Integer hrId) {

        List<DmiBrandName> list = mapper.selectBrandNameById(hrId);

        for (DmiBrandName brandName : list
        ) {
            if(brandName.getBrandName().equals("")){
                brandName.setBrandName("其他品牌");
            }
        }
        return list;
    }


}

package com.company.springboot.service.fdp;

import com.company.springboot.entity.fdp.*;
import com.company.springboot.mapper.fdp.FdpDispatchJobContentMapper;
import com.company.springboot.mapper.fdp.FdpDispatchRequestHistoryMapper;
import com.company.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.company.springboot.mapper.fdp.FdpFaultOrderDispatchRequestMapper;
import com.company.springboot.utils.DateUtil;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchRequestHistoryService
 * @ProjectName WaterDrop
 * @Description: 采购工单历史记录
 * @date 2019/1/17上午9:20
 */
@Service
public class FdpDispatchRequestHistoryService {


    @Resource
    private FdpDispatchRequestHistoryMapper fdpDispatchRequestHistoryMapper;

    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;

    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    @Resource
    private FdpDispatchJobContentMapper fdpDispatchJobContentMapper;

    /**
     * 查询派工单历史
     *
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    public Result getHistoryList(FdbOrderFindPage fdbOrderFindPage) {
        List<GetFdpRequestHistoryList> result = new ArrayList<GetFdpRequestHistoryList>();
        if (fdbOrderFindPage.getPageNum() != null && fdbOrderFindPage.getPageSize() != null) {
            PageHelper.startPage(fdbOrderFindPage.getPageNum(), fdbOrderFindPage.getPageSize());
            Page<FdpDispatchRequestHistory> persons = fdpDispatchRequestHistoryMapper.getListByRequestId(fdbOrderFindPage.getRequestId());
            PageInfo<FdpDispatchRequestHistory> pageInfo = new PageInfo<>(persons);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            List<FdpDispatchRequestHistory> dispatchOrderListResp = pageInfo.getList();
            Iterator<FdpDispatchRequestHistory> it = dispatchOrderListResp.iterator();
            while (it.hasNext()) {
                FdpDispatchRequestHistory item = it.next();
                GetFdpRequestHistoryList history = new GetFdpRequestHistoryList();
                history.setVersion(DateUtil.getNoSecondFormat(item.getCreateHistoryTime()));
                history.setRequestId(item.getRootRequestId());
                history.setId(item.getId());
                result.add(history);
            }
        } else {
            List<FdpDispatchRequestHistory> historyLists = fdpDispatchRequestHistoryMapper.getListByRequestId(fdbOrderFindPage.getRequestId());
            for (FdpDispatchRequestHistory item : historyLists) {
                GetFdpRequestHistoryList history = new GetFdpRequestHistoryList();
                history.setVersion(DateUtil.getNoSecondFormat(item.getCreateHistoryTime()));
                history.setRequestId(item.getRootRequestId());
                history.setId(item.getId());
                result.add(history);
            }
        }
        return ResultUtil.success(result);
    }

    /**
     * 查询派工单历史详情
     *
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    public Result showHistory(int id) {
        FdpDispatchRequestHistoryShow history = fdpDispatchRequestHistoryMapper.show(id);

        //查询派工要求工作内容历史
        List<FdpDispatchJobContent> contents = fdpDispatchJobContentMapper.selectByHistoryId(history.getId());
        StringBuffer job = new StringBuffer();
        if (contents.size() != 0) {
            //工作内容为一个
            if (contents.size() == 1) {
                history.setDispatchDescription(contents.get(0).getJobStepDescription());
            } else {
                for (int i = 0; i < contents.size(); i++) {
                    if (!"".equals(contents.get(i).getJobStepDescription()) && i == 0) {
                        job.append(contents.get(i).getJobStepDescription());
                    } else {
                        job.append(";" + contents.get(i).getJobStepDescription());
                    }
                }
                history.setDispatchDescription(job.toString());
            }
        }
        return ResultUtil.success(history);
    }

}

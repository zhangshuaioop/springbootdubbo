package com.teekee.blueoceanservice.service.fdp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teekee.blueoceanservice.entity.fdp.*;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.teekee.blueoceanservice.service.file.FileServiceImpl;
import com.teekee.blueoceanservice.utils.ExcelUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchListService
 * @ProjectName BlueOcean
 * @Description: 采购清单
 * @date 2019/1/9下午4:06
 */
@Service
public class FdpFaultDispatchListService {

    @Value("${filepath}")
    private String filepath;

    @Autowired
    private FileServiceImpl fileService;


    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    public Result getFaultDispatchOrderList(GetFdpFaultdispatchOrderList getFdpFaultdispatchOrderList) {
        if (getFdpFaultdispatchOrderList.getPageNum() != null && getFdpFaultdispatchOrderList.getPageSize() != null) {
            PageHelper.startPage(getFdpFaultdispatchOrderList.getPageNum(), getFdpFaultdispatchOrderList.getPageSize());
            Page<FdpFaultDispatchOrderList> persons = fdpFaultDispatchOrderMapper.selectDispatchOrderList(getFdpFaultdispatchOrderList);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<FdpFaultDispatchOrderList> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<FdpFaultDispatchOrderList> persons = fdpFaultDispatchOrderMapper.selectDispatchOrderList(getFdpFaultdispatchOrderList);
            return ResultUtil.success(persons);
        }
    }

    public Result exportFaultOrderList(GetFdpFaultdispatchOrderList getFdpFaultdispatchOrderList) {
        List<FdpFaultDispatchOrderList> list = fdpFaultDispatchOrderMapper.selectDispatchOrderList(getFdpFaultdispatchOrderList);

        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                file.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "ORDERLIST" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.errorBusinessMsg("找不到默认保存文件的目录，请联系管理员!");
        }

        ExcelUtil.exportDispatchOrderList(list, out);
        File uploadFile = new File(filepath + ExcelUtil.FILE_SEPARATOR + "ORDERLIST" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.errorBusinessMsg("文件没有找到，请联系管理员！");
        }
    }

    public Result exportFaultOrderCount(GetFaultDispatchRequestList getFaultDispatchRequestList) {


        List<FaultOrderCount> orderList = faultOrderCount(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listCompany = faultOrderCountByDemand(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listLastDealPerson = faultOrderCountByDealPerson(getFaultDispatchRequestList);

        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                file.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "ORDERCOUNTLIST_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.errorBusinessMsg("找不到默认保存文件的目录，请联系管理员!");
        }

        ExcelUtil.exportOrderCountList(orderList, listCompany, listLastDealPerson, out);
        File uploadFile = new File(filepath + ExcelUtil.FILE_SEPARATOR + "ORDERCOUNTLIST_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.errorBusinessMsg("文件没有找到，请联系管理员！");
        }

    }

    /**
     * (方法)查询采购工单统计
     *
     * @param getFaultDispatchRequestList
     * @return
     * @Author Liukan
     * @Date 2018/06/24
     */
    private List<FaultOrderCount> faultOrderCount(GetFaultDispatchRequestList getFaultDispatchRequestList) {

        int count = fdpFaultDispatchOrderMapper.selectOrderCount(getFaultDispatchRequestList);
        List<FaultOrderCount> orderList = new ArrayList<FaultOrderCount>();
        FaultOrderCount orderCount = new FaultOrderCount();
        orderCount.setOrderCountAll(count);
        getFaultDispatchRequestList.setDispatchStatus("COMPLETE");
        BigDecimal actual = BigDecimal.ZERO;
        BigDecimal estimate = BigDecimal.ZERO;
        BigDecimal actualUN = BigDecimal.ZERO;
        BigDecimal estimateUN = BigDecimal.ZERO;
        BigDecimal actualCost = BigDecimal.ZERO;
        BigDecimal actualCostUn = BigDecimal.ZERO;
        BigDecimal estimateCost = BigDecimal.ZERO;
        BigDecimal estimateCostUn = BigDecimal.ZERO;

        FaultOrderCount order = fdpFaultDispatchOrderMapper.selectOrderCompletePrice(getFaultDispatchRequestList);

        if (order == null) {
            actual = BigDecimal.ZERO;
            estimate = BigDecimal.ZERO;
            actualCost = BigDecimal.ZERO;
            estimateCost = BigDecimal.ZERO;
            orderCount.setActualMonetaryUnit("");
            orderCount.setActualPriceUnit("");
            orderCount.setEstimatedMonetaryUnit("");
            orderCount.setEstimatedPriceUnit("");

        } else {
            if (order.getSumEstimatedPrice() == null) {
                estimate = BigDecimal.ZERO;
            } else {
                estimate = order.getSumEstimatedPrice();
            }
            if (order.getSumActualPrice() == null) {
                actual = BigDecimal.ZERO;
            } else {
                actual = order.getSumActualPrice();
            }
            if (order.getSumActualCost() == null) {
                actualCost = BigDecimal.ZERO;
            } else {
                actualCost = order.getSumActualCost();

            }
            if (order.getSumEstimatedCost() == null) {
                estimateCost = BigDecimal.ZERO;
            } else {
                estimateCost = order.getSumEstimatedCost();
            }
            orderCount.setActualMonetaryUnit(order.getActualMonetaryUnit());
            orderCount.setActualPriceUnit(order.getActualPriceUnit());
            orderCount.setEstimatedMonetaryUnit(order.getEstimatedMonetaryUnit());
            orderCount.setEstimatedPriceUnit(order.getEstimatedPriceUnit());
        }

        orderCount.setSumActualCost(actualCost);
        orderCount.setSumEstimatedCost(estimateCost);
        orderCount.setSumActualPrice(actual);
        orderCount.setSumEstimatedPrice(estimate);
        int countComplete = fdpFaultDispatchOrderMapper.selectOrderCount(getFaultDispatchRequestList);
        orderCount.setOrderCountComplete(countComplete);

        getFaultDispatchRequestList.setDispatchStatus("UNCOMPLETE");
        int countUnComplete = fdpFaultDispatchOrderMapper.selectOrderCount(getFaultDispatchRequestList);
        orderCount.setOrderCountUnComplete(countUnComplete);
        FaultOrderCount orderUn = fdpFaultDispatchOrderMapper.selectOrderCompletePrice(getFaultDispatchRequestList);
        if (orderUn == null) {
            actualUN = BigDecimal.ZERO;
            estimateUN = BigDecimal.ZERO;
            actualCostUn = BigDecimal.ZERO;
            estimateCostUn = BigDecimal.ZERO;
        } else {
            if (orderUn.getSumActualPrice() == null) {
                actualUN = BigDecimal.ZERO;
            } else {
                actualUN = orderUn.getSumActualPrice();
            }
            if (orderUn.getSumEstimatedPrice() == null) {
                estimateUN = BigDecimal.ZERO;
            } else {
                estimateUN = orderUn.getSumEstimatedPrice();
            }
            if (orderUn.getSumEstimatedCost() == null) {
                estimateCostUn = BigDecimal.ZERO;
            } else {
                estimateCostUn = orderUn.getSumEstimatedCost();
            }
            if (orderUn.getSumActualCost() == null) {
                actualCostUn = BigDecimal.ZERO;
            } else {
                actualCostUn = orderUn.getSumActualCost();
            }
        }
        orderCount.setSumUnActualCost(actualCostUn);
        orderCount.setSumUnEstimatedCost(estimateCostUn);
        orderCount.setSumUnActualPrice(actualUN);
        orderCount.setSumUnEstimatedPrice(estimateUN);

        getFaultDispatchRequestList.setDispatchStatus("CANCEL");
        int countOrderCancel = fdpFaultDispatchOrderMapper.selectOrderCount(getFaultDispatchRequestList);
        orderCount.setOrderCountCancel(countOrderCancel);

        orderList.add(orderCount);
        return orderList;
    }

    private List<FaultOrderRequestCountByCompany> faultOrderCountByDemand(GetFaultDispatchRequestList getFaultDispatchRequestList) {

        List<FaultOrderCount> listAll = fdpFaultDispatchOrderMapper.selectOrderByCompanyAll(getFaultDispatchRequestList);

        List<FaultOrderCount> listComplete = fdpFaultDispatchOrderMapper.selectOrderByCompanyComplete(getFaultDispatchRequestList);

        List<FaultOrderCount> listUnComplete = fdpFaultDispatchOrderMapper.selectOrderByCompanyUnComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listCompany = new ArrayList<FaultOrderRequestCountByCompany>();


        for (FaultOrderCount cc : listAll) {
            FaultOrderRequestCountByCompany list = new FaultOrderRequestCountByCompany();
            list.setCompanyName(cc.getCompanyName());
            list.setAllCount(cc.getOrderCountAll());
            for (FaultOrderCount complete : listComplete) {
                if (cc.getCompanyName().equals(complete.getCompanyName())) {
                    list.setCompleteCount(complete.getOrderCountComplete());

                }
            }
            for (FaultOrderCount unComplete : listUnComplete) {

                if (cc.getCompanyName().equals(unComplete.getCompanyName())) {
                    list.setUnCompleteCount(unComplete.getOrderCountUnComplete());
                }
            }
            listCompany.add(list);
        }

        return listCompany;

    }

    private List<FaultOrderRequestCountByCompany> faultOrderCountByDealPerson(GetFaultDispatchRequestList getFaultDispatchRequestList) {


        List<FaultOrderCount> listAll = fdpFaultDispatchOrderMapper.selectOrderByDealPersonAll(getFaultDispatchRequestList);

        List<FaultOrderCount> listComplete = fdpFaultDispatchOrderMapper.selectOrderByCreatePersonComplete(getFaultDispatchRequestList);

        List<FaultOrderCount> listUnComplete = fdpFaultDispatchOrderMapper.selectOrderByCreatePersonUnComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listLastDealPerson = new ArrayList<FaultOrderRequestCountByCompany>();


        for (FaultOrderCount cc : listAll
        ) {
            FaultOrderRequestCountByCompany list = new FaultOrderRequestCountByCompany();
            list.setCompanyName(cc.getCompanyName());
            list.setAllCount(cc.getOrderCountAll());
            for (FaultOrderCount complete : listComplete
            ) {
                if (cc.getCompanyName().equals(complete.getCompanyName())) {
                    list.setCompleteCount(complete.getOrderCountComplete());

                }
            }
            for (FaultOrderCount unComplete : listUnComplete) {

                if (cc.getCompanyName().equals(unComplete.getCompanyName())) {
                    list.setUnCompleteCount(unComplete.getOrderCountUnComplete());
                }
            }
            listLastDealPerson.add(list);
        }

        return listLastDealPerson;

    }

    /**
     * 查询采购工单统计
     *
     * @param getFaultDispatchRequestList
     * @return
     */
    public Result getFaultOrderCount(GetFaultDispatchRequestList getFaultDispatchRequestList) {

        List<FaultOrderCount> orderList = faultOrderCount(getFaultDispatchRequestList);

        return ResultUtil.success(orderList);

    }

    public Result getFaultOrderCountByDemand(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        List<FaultOrderRequestCountByCompany> listCompany = faultOrderCountByDemand(getFaultDispatchRequestList);
        return ResultUtil.success(listCompany);
    }

    public Result getFaultOrderCountByDealPerson(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        List<FaultOrderRequestCountByCompany> listLastDealPerson = faultOrderCountByDealPerson(getFaultDispatchRequestList);
        return ResultUtil.success(listLastDealPerson);
    }
}

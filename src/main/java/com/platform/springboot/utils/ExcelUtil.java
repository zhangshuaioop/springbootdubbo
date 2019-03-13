package com.platform.springboot.utils;


import com.platform.springboot.entity.fdp.FaultOrderCount;
import com.platform.springboot.entity.fdp.FaultOrderRequestCountByCompany;
import com.platform.springboot.entity.fdp.FdpFaultDispatchOrderList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 下载工具类
 *
 * @author Wujun
 * @version v1.0
 * @create 2017年09月25日 10:21z
 */
public class ExcelUtil {

    public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

    /**
     * 下载采购清单
     * @param list
     * @param out
     * @return
     * @Author Liukan
     * @Date 2018/06/24
     */
    public static void exportDispatchOrderList(List<FdpFaultDispatchOrderList> list, OutputStream out) {


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("采购清单信息信息");
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);

        // 生成一个标题样式
        HSSFCellStyle styleBig = workbook.createCellStyle();
        HSSFFont fontBig = workbook.createFont();
        fontBig.setBold(true);
        fontBig.setFontHeightInPoints((short) 11);
        styleBig.setFont(fontBig);
        styleBig.setAlignment(HorizontalAlignment.CENTER);

        // 生成一个正常样式
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        style.setWrapText(true);

        // 列表第0行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("雇主");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("门店");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工来源");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("省份");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("城市");
        cell.setCellValue(text);

        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("辖区");
        cell.setCellValue(text);

        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工地址");
        cell.setCellValue(text);

        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("集成商");
        cell.setCellValue(text);

        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建人");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("处理人");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("工单编号");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("系统编号");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工阶段");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工类型");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工人数");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("备件要求");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("其他要求");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("其他描述");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计成本");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计成本单位");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际成本");
        cell.setCellValue(text);
        cell = row.createCell(21);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际成本单位");
        cell.setCellValue(text);
        cell = row.createCell(22);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计售价");
        cell.setCellValue(text);
        cell = row.createCell(23);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计售价单位");
        cell.setCellValue(text);
        cell = row.createCell(24);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际售价");
        cell.setCellValue(text);
        cell = row.createCell(25);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际售价单位");
        cell.setCellValue(text);
        cell = row.createCell(26);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建日期");
        cell.setCellValue(text);
        cell = row.createCell(27);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("处理时间");
        cell.setCellValue(text);
        cell = row.createCell(28);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完工日期");
        cell.setCellValue(text);
        cell = row.createCell(29);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("服务日期");
        cell.setCellValue(text);
        cell = row.createCell(30);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("服务时间段");
        cell.setCellValue(text);
        cell = row.createCell(31);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("回复时间");
        cell.setCellValue(text);
        cell = row.createCell(32);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("期望完工时间");
        cell.setCellValue(text);



        for ( FdpFaultDispatchOrderList item: list) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getCompanyName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCustomerSource());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProvince());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCity());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getServiceDistrict());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getServiceAddress());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getVendorName());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getUsername());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getLastDealPerson());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDispatchOrderNumber());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOtherSystemNumber());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            if(item.getDispatchStatus().equals("USED")){
                itemText = new HSSFRichTextString("派工中");

            }
            if(item.getDispatchStatus().equals("NEW")){
                itemText = new HSSFRichTextString("新增报障");

            }
            if(item.getDispatchStatus().equals("COMPLETE")){
                itemText = new HSSFRichTextString("新增报障");

            }
            if(item.getDispatchStatus().equals("CANCEL")){
                itemText = new HSSFRichTextString("订单已取消");

            }
            if(item.getDispatchStatus().equals("ABANDON")){
                itemText = new HSSFRichTextString("订单已放弃");

            }
            if(item.getDispatchStatus().equals("DEALING")){
                itemText = new HSSFRichTextString("处理中");

            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            JSONObject jsStr = JSONObject.fromObject(item.getDispatchModelRequest());
            String s = jsStr.get("aaData").toString();
            JSONArray jsArr = JSONArray.fromObject(s);
            String aa = jsArr.getJSONObject(0).getString("arr");
            itemText = new HSSFRichTextString(aa.substring(2,6));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getHrCount()));
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBackupDeviceRequest());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOtherRequest());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDispatchDescription());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            String estimatedCost ;
            if(item.getEstimatedCost()==null){
                estimatedCost ="0.00";
            }else{
                estimatedCost =item.getEstimatedCost().toString();
            }
            itemText = new HSSFRichTextString(estimatedCost);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            String estimatedCostUnit ;
            if(item.getEstimatedMonetaryUnit()==null){
                estimatedCostUnit ="人民币";
            }else{
                estimatedCostUnit =item.getEstimatedMonetaryUnit();
            }
            itemText = new HSSFRichTextString(estimatedCostUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            String  actualCost ;
            if(item.getActualCost()==null){
                actualCost ="0.00";
            }else{
                actualCost =item.getActualCost().toString();
            }
            itemText = new HSSFRichTextString(actualCost);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(21);
            itemCell.setCellStyle(style);
            String  actualCostUnit ;
            if(item.getActualMonetaryUnit()==null){
                actualCostUnit ="人民币";
            }else{
                actualCostUnit =item.getActualMonetaryUnit();
            }
            itemText = new HSSFRichTextString(actualCostUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(22);
            itemCell.setCellStyle(style);
            String estimatedPrice;
            if(item.getEstimatedPrice()==null){
                estimatedPrice ="0.00";
            }else{
                estimatedPrice =item.getEstimatedPrice().toString();
            }
            itemText = new HSSFRichTextString(estimatedPrice);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(23);
            itemCell.setCellStyle(style);
            String estimatedPriceUnit;
            if(item.getEstimatedPriceUnit()==null){
                estimatedPriceUnit ="人民币";
            }else{
                estimatedPriceUnit =item.getEstimatedPriceUnit();
            }
            itemText = new HSSFRichTextString(estimatedPriceUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(25);
            itemCell.setCellStyle(style);
            String actualPrice;
            if(item.getActualPrice()==null){
                actualPrice ="0.00";
            }else{
                actualPrice = item.getActualPrice().toString();
            }
            itemText = new HSSFRichTextString(actualPrice);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(25);
            itemCell.setCellStyle(style);
            String actualPriceUnit;
            if(item.getActualPriceUnit()==null){
                actualPriceUnit ="人民币";
            }else{
                actualPriceUnit =item.getActualPriceUnit();
            }
            itemText = new HSSFRichTextString(actualPriceUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(26);
            itemCell.setCellStyle(style);
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            String createTime = format.format(item.getCreateTime());
            itemText = new HSSFRichTextString(createTime);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(27);
            itemCell.setCellStyle(style);
            String lastDealTime = format.format(item.getLastDealTime());
            itemText = new HSSFRichTextString(lastDealTime);
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(28);
            itemCell.setCellStyle(style);
            String completeTime;
            if(item.getFinishTime() == null){
                completeTime ="";
            }else{
                completeTime = format.format(item.getFinishTime());
            }
            itemText = new HSSFRichTextString(completeTime);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(29);
            itemCell.setCellStyle(style);
            String serviceDate = item.getServiceDate()!=null?format.format(item.getServiceDate()):"";
            itemText = new HSSFRichTextString(serviceDate);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(30);
            itemCell.setCellStyle(style);
            String start="";
            String end="";
            Integer serviceTimeStart=0;
            if(item.getServiceTimeStart()!=null){
                serviceTimeStart=item.getServiceTimeStart();
                start= serviceTimeStart>0?((serviceTimeStart/30)%2==1?(serviceTimeStart/30-1)+":30":(serviceTimeStart/30-1)+":00"):"0:00";
            }
            Integer serviceTimeEnd=0;
            if(item.getServiceTimeEnd()!=null){
                serviceTimeEnd=item.getServiceTimeEnd();
                end= serviceTimeEnd>0?((serviceTimeEnd/30)%2==1?(serviceTimeEnd/30-1)+":30":(serviceTimeEnd/30-1)+":00"):"0:00";
            }
            itemText = new HSSFRichTextString(start+"~"+end);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(31);
            itemCell.setCellStyle(style);
            //String expectReplyTime = format.format(item.getExpectReplyTime());
            String expectReplyTime;
            if(item.getExpectReplyTime() == null){
                expectReplyTime ="";
            }else{
                expectReplyTime = format.format(item.getExpectReplyTime());
            }
            itemText = new HSSFRichTextString(expectReplyTime);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(32);
            itemCell.setCellStyle(style);
            //String expectCompleteTime = format.format(item.getExpectCompleteTime());
            String expectCompleteTime;
            if(item.getExpectCompleteTime() == null){
                expectCompleteTime ="";
            }else{
                expectCompleteTime = format.format(item.getExpectCompleteTime());
            }
            itemText = new HSSFRichTextString(expectCompleteTime);
            itemCell.setCellValue(itemText);
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void exportOrderCountList(List<FaultOrderCount> orderList, List<FaultOrderRequestCountByCompany> listCompany, List<FaultOrderRequestCountByCompany> listLastDealPerson, OutputStream out) {

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("采购汇总");
        HSSFSheet sheet2 = workbook.createSheet("采购雇主汇总");
        HSSFSheet sheet3 = workbook.createSheet("采购处理人汇总");
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        sheet2.setDefaultColumnWidth((short) 20);
        sheet3.setDefaultColumnWidth((short) 20);
        // 生成一个标题样式
        HSSFCellStyle styleBig = workbook.createCellStyle();
        HSSFFont fontBig = workbook.createFont();
        fontBig.setBold(true);
        fontBig.setFontHeightInPoints((short) 11);
        styleBig.setFont(fontBig);
        styleBig.setAlignment(HorizontalAlignment.CENTER);

        // 生成一个正常样式
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        style.setWrapText(true);

        // 列表第0行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("总量");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完成总量");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("为完成量");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("取消总量");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计售价");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计未完成售价");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计成本");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计未完成成本");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际完成售价");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际未完成售价");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际完成成本");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际未完成成本");
        cell.setCellValue(text);
        for (FaultOrderCount item : orderList
        ) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(String.valueOf(item.getOrderCountAll()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getOrderCountComplete()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getOrderCountUnComplete()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getOrderCountCancel()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumEstimatedPrice())+item.getEstimatedPriceUnit());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumUnEstimatedPrice())+item.getEstimatedPriceUnit());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumEstimatedCost())+item.getEstimatedMonetaryUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumUnEstimatedCost())+item.getEstimatedMonetaryUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumActualPrice())+item.getActualPriceUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumUnActualPrice())+item.getActualPriceUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumActualCost())+item.getActualMonetaryUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getSumUnActualCost())+item.getActualMonetaryUnit());
            itemCell.setCellValue(itemText);
        }


        // 列表第0行
        int rowIndex2 = 0;
        HSSFRow row2 = sheet2.createRow(rowIndex2);
        HSSFCell cell2 = row2.createCell(0);
        cell2.setCellStyle(styleBig);
        HSSFRichTextString text2 = new HSSFRichTextString("雇主");
        cell2.setCellValue(text2);
        cell2 = row2.createCell(1);
        cell2.setCellStyle(styleBig);
        text2 = new HSSFRichTextString("总量");
        cell2.setCellValue(text2);
        cell2 = row2.createCell(2);
        cell2.setCellStyle(styleBig);
        text2 = new HSSFRichTextString("已完成");
        cell2.setCellValue(text2);
        cell2 = row2.createCell(3);
        cell2.setCellStyle(styleBig);
        text2 = new HSSFRichTextString("未完成");
        cell2.setCellValue(text2);


        for (FaultOrderRequestCountByCompany item:listCompany
        ) {

            rowIndex2 = rowIndex2 + 1;
            HSSFRow itemRow2 = sheet2.createRow(rowIndex2);
            HSSFCell itemCell = itemRow2.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(String.valueOf(item.getCompanyName()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow2.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getAllCount()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow2.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getCompleteCount()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow2.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getUnCompleteCount()));
            itemCell.setCellValue(itemText);



        }



        // 列表第0行
        int rowIndex3 = 0;
        HSSFRow row3 = sheet3.createRow(rowIndex3);
        HSSFCell cell3 = row3.createCell(0);
        cell3.setCellStyle(styleBig);
        HSSFRichTextString text3 = new HSSFRichTextString("处理人");
        cell3.setCellValue(text3);
        cell3 = row3.createCell(1);
        cell3.setCellStyle(styleBig);
        text3 = new HSSFRichTextString("总量");
        cell3.setCellValue(text3);
        cell3 = row3.createCell(2);
        cell3.setCellStyle(styleBig);
        text3 = new HSSFRichTextString("已完成");
        cell3.setCellValue(text3);
        cell3 = row3.createCell(3);
        cell3.setCellStyle(styleBig);
        text3 = new HSSFRichTextString("未完成");
        cell3.setCellValue(text3);


        for (FaultOrderRequestCountByCompany item :listLastDealPerson
        ) {


            rowIndex3 = rowIndex3+ 1;
            HSSFRow itemRow3 = sheet3.createRow(rowIndex3);
            HSSFCell itemCell = itemRow3.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(String.valueOf(item.getCompanyName()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow3.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getAllCount()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow3.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getCompleteCount()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow3.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getUnCompleteCount()));
            itemCell.setCellValue(itemText);



        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

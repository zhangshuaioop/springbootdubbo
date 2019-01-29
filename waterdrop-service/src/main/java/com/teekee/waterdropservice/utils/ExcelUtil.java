package com.teekee.waterdropservice.utils;

import com.teekee.waterdropservice.entity.bif.BifDeviceListDownloadRet;
import com.teekee.waterdropservice.entity.dmi.DmiEmployeeExport;
import com.teekee.waterdropservice.entity.dmi.DmiExportContact;
import com.teekee.waterdropservice.entity.dmi.ret.dmiStore.ListRet;
import com.teekee.waterdropservice.entity.fdp.*;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill.ShowBillRet;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill.ShowChargeListRet;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill.ShowOverAllRet;
import com.teekee.waterdropservice.entity.ret.dmi.DmiCompanyInfo.CommListByDownloadRet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 账单下载工具类
 *
 * @author Wujun
 * @version v1.0
 * @create 2017年09月25日 10:21z
 */
public class ExcelUtil {

    public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

    public static void exportExcel(ShowOverAllRet billDetail, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("账单详情");
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 合并单元格
        CellRangeAddress region1 = new CellRangeAddress(1, 1, (short) 0, (short) 7);
        CellRangeAddress region4 = new CellRangeAddress(4, 4, (short) 0, (short) 18);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region4);

        // 生成一个标题样式
        HSSFCellStyle styleBig = workbook.createCellStyle();
        HSSFFont fontBig = workbook.createFont();
        fontBig.setBold(true);
        fontBig.setColor(HSSFFont.COLOR_RED);
        fontBig.setFontHeightInPoints((short) 11);
        styleBig.setFont(fontBig);

        // 生成一个红色样式
        HSSFCellStyle styleRed = workbook.createCellStyle();
        HSSFFont fontRed = workbook.createFont();
        fontRed.setFontHeightInPoints((short) 10);
        fontRed.setColor(HSSFFont.COLOR_RED);
        styleRed.setFont(fontRed);
        styleRed.setAlignment(HorizontalAlignment.LEFT);

        // 生成一个正常样式
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        styleBig.setWrapText(true);

        // 编辑表格（将账单信息写入表格）
        ShowBillRet showBillRet = billDetail.getShowBillRet();

        // 账单标题
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("账单编号：");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString(showBillRet.getBillNumber());
        cell.setCellValue(text);

        // 账单的合计信息
        rowIndex++;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(styleRed);
        text = new HSSFRichTextString("合计信息");
        cell.setCellValue(text);

        rowIndex++;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("雇主");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("账单序号");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("子项数量");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("预计费用");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("实际费用");
        cell.setCellValue(text);
        cell = row.createCell(5);
        text = new HSSFRichTextString("出账时间");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("出账人");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注");
        cell.setCellValue(text);

        rowIndex++;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(showBillRet.getCompanyName());
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(showBillRet.getBillNumber());
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(String.valueOf(showBillRet.getProductCount()));
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(String.valueOf(MathUtil.getStringBigDecimal(showBillRet.getEstimatedFee())));
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(String.valueOf(MathUtil.getStringBigDecimal(showBillRet.getActualFee())));
        cell.setCellValue(text);
        cell = row.createCell(5);
        text = new HSSFRichTextString(DateUtil.getNewFormat(showBillRet.getCreateBillTime()));
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(showBillRet.getCreateBillPersonName());
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString(showBillRet.getMemo());
        cell.setCellValue(text);

        rowIndex++;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(styleRed);
        text = new HSSFRichTextString("明细信息");
        cell.setCellValue(text);

        rowIndex++;
        int column = 0;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("雇主");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("雇主品牌");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("门店");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("类型");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信品牌");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("ISP服务商");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("产品概述");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("开始收费日期");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("账期");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("账期周期");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信周期费");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信一次性费用");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业周期费");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业一次性费用");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("尾纤费");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("预计费用合计");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("预期总账期");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("当前账期");
        cell.setCellValue(text);
        column++;
        cell = row.createCell(column);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("实际总费用");
        cell.setCellValue(text);

        // 账单的明细信息
        List<ShowChargeListRet> chargeList = billDetail.getShowChargeListRetList();
        for (int i = 0; i < chargeList.size(); i++) {
            ShowChargeListRet item = chargeList.get(i);
            rowIndex++;
            row = sheet.createRow(rowIndex);
            int itemColumn = 0;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getCompany());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getCompanyBrand());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getStore());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getType());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getCommBrand());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getIspService());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getName());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            String dateStringStart = item.getAccountPeriodStart() == null ? "" : DateUtil.getNewFormat(item.getAccountPeriodStart());
            text = new HSSFRichTextString(dateStringStart);
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(item.getAccountPeriodNumber());
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            String dateStringEnd = item.getAccountPeriodEnd() == null ? "" : DateUtil.getNewFormat(item.getAccountPeriodEnd());
            text = new HSSFRichTextString(dateStringStart + " - " + dateStringEnd);
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getCommPeriodFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getCommOneTimeFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getTenementPeriodFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getTenementOneTimeFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getFiberFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getExpectedTotalFee()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(String.valueOf(item.getAccountTotal()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(String.valueOf(item.getAccountIndex()));
            cell.setCellValue(text);
            itemColumn++;
            cell = row.createCell(itemColumn);
            cell.setCellStyle(style);
            text = new HSSFRichTextString(MathUtil.getStringBigDecimal(item.getActualChargeFee()));
            cell.setCellValue(text);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportCommExcel(List<CommListByDownloadRet> commList, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("通信资源列表");
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

        // 合并单元格
        CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 6);
        sheet.addMergedRegion(region1);
        CellRangeAddress region2 = new CellRangeAddress(0, 0, (short) 7, (short) 16);
        sheet.addMergedRegion(region2);
        CellRangeAddress region3 = new CellRangeAddress(0, 0, (short) 17, (short) 20);
        sheet.addMergedRegion(region3);
        CellRangeAddress region4 = new CellRangeAddress(0, 0, (short) 21, (short) 25);
        sheet.addMergedRegion(region4);
        CellRangeAddress region5 = new CellRangeAddress(0, 0, (short) 26, (short) 30);
        sheet.addMergedRegion(region5);
        CellRangeAddress region6 = new CellRangeAddress(0, 0, (short) 31, (short) 39);
        sheet.addMergedRegion(region6);
        CellRangeAddress region7 = new CellRangeAddress(0, 0, (short) 40, (short) 47);
        sheet.addMergedRegion(region7);
        CellRangeAddress region8 = new CellRangeAddress(0, 0, (short) 48, (short) 59);
        sheet.addMergedRegion(region8);
        CellRangeAddress region9 = new CellRangeAddress(0, 0, (short) 60, (short) 71);
        sheet.addMergedRegion(region9);
        CellRangeAddress region10 = new CellRangeAddress(0, 0, (short) 72, (short) 74);
        sheet.addMergedRegion(region10);

        // 列表第0行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("门店信息");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("通信产品信息");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("宽带信息");
        cell.setCellValue(text);
        cell = row.createCell(21);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("语音-直线信息");
        cell.setCellValue(text);
        cell = row.createCell(26);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("语音-中继信息");
        cell.setCellValue(text);
        cell = row.createCell(31);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("专线信息");
        cell.setCellValue(text);
        cell = row.createCell(40);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("移动信息");
        cell.setCellValue(text);
        cell = row.createCell(48);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("付费信息");
        cell.setCellValue(text);
        cell = row.createCell(60);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("收费信息");
        cell.setCellValue(text);
        cell = row.createCell(72);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("套餐详情及账务信息");
        cell.setCellValue(text);

        // 列表第一行
        rowIndex = 1;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("雇主品牌");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("门店");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("省份");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("门店地址");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("店铺电话");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注（门店信息）");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("产品数量");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("产品/套餐名");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("资源编号");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("服务商");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信品牌");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("产品分类");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("设备号");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("实名主体");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("集成商管理");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("待收待付");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("下行带宽");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("上行带宽");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("账号");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("密码");
        cell.setCellValue(text);
        cell = row.createCell(21);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("区号");
        cell.setCellValue(text);
        cell = row.createCell(22);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有来电显示");
        cell.setCellValue(text);
        cell = row.createCell(23);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否IP电话");
        cell.setCellValue(text);
        cell = row.createCell(24);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有国内长途");
        cell.setCellValue(text);
        cell = row.createCell(25);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有国内长途");
        cell.setCellValue(text);
        cell = row.createCell(26);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("区号");
        cell.setCellValue(text);
        cell = row.createCell(27);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有来电显示");
        cell.setCellValue(text);
        cell = row.createCell(28);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("包含线路数量");
        cell.setCellValue(text);
        cell = row.createCell(29);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("号码段");
        cell.setCellValue(text);
        cell = row.createCell(30);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("引示号");
        cell.setCellValue(text);
        cell = row.createCell(31);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("速率");
        cell.setCellValue(text);
        cell = row.createCell(32);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("A端门店");
        cell.setCellValue(text);
        cell = row.createCell(33);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("A端接口类型");
        cell.setCellValue(text);
        cell = row.createCell(34);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("A端速率");
        cell.setCellValue(text);
        cell = row.createCell(35);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("A端本地编号");
        cell.setCellValue(text);
        cell = row.createCell(36);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("Z端门店");
        cell.setCellValue(text);
        cell = row.createCell(37);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("Z端接口类型");
        cell.setCellValue(text);
        cell = row.createCell(38);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("Z端速率");
        cell.setCellValue(text);
        cell = row.createCell(39);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("Z端本地编号");
        cell.setCellValue(text);
        cell = row.createCell(40);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("puk");
        cell.setCellValue(text);
        cell = row.createCell(41);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("网络制式");
        cell.setCellValue(text);
        cell = row.createCell(42);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("用途");
        cell.setCellValue(text);
        cell = row.createCell(43);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("流量包");
        cell.setCellValue(text);
        cell = row.createCell(44);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("超额动作");
        cell.setCellValue(text);
        cell = row.createCell(45);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("使用频率");
        cell.setCellValue(text);
        cell = row.createCell(46);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有国内长途");
        cell.setCellValue(text);
        cell = row.createCell(47);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有国际长途");
        cell.setCellValue(text);
        cell = row.createCell(48);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期-起");
        cell.setCellValue(text);
        cell = row.createCell(49);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期限");
        cell.setCellValue(text);
        cell = row.createCell(50);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期-止");
        cell.setCellValue(text);
        cell = row.createCell(51);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("付费周期");
        cell.setCellValue(text);
        cell = row.createCell(52);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("计费类型");
        cell.setCellValue(text);
        cell = row.createCell(53);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("付费方式");
        cell.setCellValue(text);
        cell = row.createCell(54);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("周期费用");
        cell.setCellValue(text);
        cell = row.createCell(55);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("初装费");
        cell.setCellValue(text);
        cell = row.createCell(56);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("设备费");
        cell.setCellValue(text);
        cell = row.createCell(57);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("尾纤费");
        cell.setCellValue(text);
        cell = row.createCell(58);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业一次费用");
        cell.setCellValue(text);
        cell = row.createCell(59);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业周期费用");
        cell.setCellValue(text);
        cell = row.createCell(60);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期-起");
        cell.setCellValue(text);
        cell = row.createCell(61);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期限");
        cell.setCellValue(text);
        cell = row.createCell(62);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("合约期-止");
        cell.setCellValue(text);
        cell = row.createCell(63);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("付费周期");
        cell.setCellValue(text);
        cell = row.createCell(64);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("计费类型");
        cell.setCellValue(text);
        cell = row.createCell(65);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("付费方式");
        cell.setCellValue(text);
        cell = row.createCell(66);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信周期费用");
        cell.setCellValue(text);
        cell = row.createCell(67);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("通信一次费用");
        cell.setCellValue(text);
        cell = row.createCell(68);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("待收待付");
        cell.setCellValue(text);
        cell = row.createCell(69);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("尾纤费");
        cell.setCellValue(text);
        cell = row.createCell(70);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业一次费用");
        cell.setCellValue(text);
        cell = row.createCell(71);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("物业周期费用");
        cell.setCellValue(text);
        cell = row.createCell(72);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("套餐");
        cell.setCellValue(text);
        cell = row.createCell(73);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("套餐名称");
        cell.setCellValue(text);
        cell = row.createCell(74);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("营销活动描述");
        cell.setCellValue(text);

        // 循环列表
        for (CommListByDownloadRet item : commList) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getDmiBrandName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProvince());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAddress());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTelephone());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProductCount());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCommName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProductCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getServiceName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCommBrandName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCatalogName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDeviceNumber());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getRegister());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagVendor());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagChargeAgency());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBandWidthDown());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBandWidthUp());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getLoginAccount());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getLoginPassword());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(21);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStraightLineZipCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(22);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStraightLineFlagCid());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(23);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStraightLineFlagIpPhone());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(24);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStraightLineFlagDdd());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(25);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStraightLineFlagIdd());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(26);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTrunkingZipCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(27);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTrunkingFlagCid());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(28);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTrunkingContainLines());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(29);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTrunkingNumber());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(30);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTrunkingDisplayNumber());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(31);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBandWidth());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(32);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreNameWithA());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(33);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getaPortType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(34);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getaBandWidth());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(35);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getaLocalCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(36);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreNameWithZ());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(37);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getzPortType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(38);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getzBandWidth());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(39);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getzLocalCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(40);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPuk());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(41);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getNetworkType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(42);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getUseType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(43);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCapacity());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(44);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOffLimitsOperator());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(45);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getUseRate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(46);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMobileFlagDdd());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(47);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMobileFlagIdd());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(48);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentStartDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(49);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentMonths());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(50);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentEndDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(51);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPayFrequency());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(52);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(53);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentMethod());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(54);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentCommPeriodFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(55);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentFirstInstallFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(56);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentFiberDeviceFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(57);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentFiberFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(58);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentTenementOneTimeFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(59);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPaymentTenementPeriodFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(60);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeStartDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(61);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeMonths());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(62);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeEndDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(63);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargePayFrequency());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(64);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(65);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargePaymentMethod());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(66);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeCommPeriodFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(67);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargecommOneTimeFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(68);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeFlagChargeAgency());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(69);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeFiberFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(70);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeTenementOneTimeFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(71);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getChargeTenementPeriodFee());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(72);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagCampaign());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(73);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCampaignName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(74);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCampaignDesc());
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportEmployeeExcel(List<DmiEmployeeExport> employeeList, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("员工信息");
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
        HSSFRichTextString text = new HSSFRichTextString("联系人姓名");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系人英文名");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("工号");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("所属公司");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("组织机构");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("组织机构编码");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("性别");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("职位");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("学历");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系电话-座机");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("手机");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("籍贯");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("民族");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("证件类型");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("证件号");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("住址");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("电子邮箱");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("备注");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("是否手动录入");
        cell.setCellValue(text);

        // 循环列表
        for (DmiEmployeeExport item : employeeList) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getEmployeeName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getEmployeeNameEn());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getEmployeeCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCompanyName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOrganizationName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOrganizationCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getSex());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPosition());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getEducationCertification());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTelephone());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMobile());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getNativePlace());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getNation());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getIdType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getIdCode());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAddress());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getEmail());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagManualString());
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportDeviceExcel(List<BifDeviceListDownloadRet> deviceList, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("设备列表");
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

        // 合并单元格
        CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 11);
        sheet.addMergedRegion(region1);
        CellRangeAddress region2 = new CellRangeAddress(0, 0, (short) 12, (short) 18);
        sheet.addMergedRegion(region2);
        CellRangeAddress region3 = new CellRangeAddress(0, 0, (short) 19, (short) 22);
        sheet.addMergedRegion(region3);

        // 列表第0行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("设备基础信息");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("设备资产信息");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("设备使用信息");
        cell.setCellValue(text);

        // 列表第一行
        rowIndex = 1;
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("设备名");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("设备序号");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("品牌");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("系列");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("型号");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("一级类别");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("二级类别");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("三级类别");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("技术参数");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否可使用");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("停用日期");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注（设备基础信息）");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("资产编号");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("供应商");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("采购日期");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("购入价格");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否维保中");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("维保到期日期");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注（设备资产信息）");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否已分配");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("分配日期");
        cell.setCellValue(text);
        cell = row.createCell(21);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("分配类型");
        cell.setCellValue(text);
        cell = row.createCell(22);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("用户名称");
        cell.setCellValue(text);

        // 循环列表
        for (BifDeviceListDownloadRet item : deviceList) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getDeviceName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDeviceSn());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBrand());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getSeries());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getModel());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOneLevelCatalog());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTwoLevelCatalog());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getThreeLevelCatalog());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTechParam());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagUsable());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getUseExpireDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDeviceBaseInfoMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAssetSn());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getSupplyCompany());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPurchaseDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getPurchasePrice());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagWarranty());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getWarrantyExpireDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDeviceAssetMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFlagAssign());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAssignDate());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(21);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAssignType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(22);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getAssignUserName());
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getStringValForExcel(HSSFCell cell) {
        if (cell == null) return "";
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                return cell.getBooleanCellValue() ? "true" : "false";
            case FORMULA:
                return cell.getCellFormula();
            case NUMERIC:
                return cell.getNumericCellValue()+"";
            case STRING:
                return cell.getStringCellValue();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    /**
     *生成派工工单xls
     *@param: FdpFaultDispatchOrderRequestForDownload 派工导出列表
     *@param: OutputStream 输出流
     *@Author Niting
     *@date: 2018/4/26
     **/
    public static void exportDispatchExcel(List<FdpFaultDispatchOrderRequestForDownload> disOrderList, OutputStream out){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("派工列表");
        // 设置表格默认列宽度为20个字节
        //sheet.setDefaultColumnWidth((short) 200);
        sheet.autoSizeColumn((short)0); //调整第一列宽度
        sheet.autoSizeColumn((short)1); //调整第二列宽度
        sheet.autoSizeColumn((short)2); //调整第三列宽度
        sheet.autoSizeColumn((short)3); //调整第四列宽度

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


        // 列表第一行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("");
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("雇主");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("门店");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("故障工单ID");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("最早派单的ID");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("故障工单编号");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("派工人数");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("服务地址(门店地址)");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("派工省份");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("服务城市");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("服务行政区");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("派工模板要求");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("携带设备要求");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("其他要求");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("工作内容");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备注");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("期望服务的时间要求");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("服务日期");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("其他品牌");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("其他门店（服务点）");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("备件要求");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("经度坐标");
        cell.setCellValue(text);
        cell = row.createCell(21);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("纬度坐标");
        cell.setCellValue(text);
        cell = row.createCell(22);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("派工来源");
        cell.setCellValue(text);
        cell = row.createCell(23);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否已删除");
        cell.setCellValue(text);
        cell = row.createCell(24);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("是否有效");
        cell.setCellValue(text);
        cell = row.createCell(25);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("创建人");
        cell.setCellValue(text);
        cell = row.createCell(26);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("创建时间");
        cell.setCellValue(text);
        cell = row.createCell(27);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("更新ID");
        cell.setCellValue(text);
        cell = row.createCell(28);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("更新日期");
        cell.setCellValue(text);
        cell = row.createCell(29);
        cell.setCellStyle(style);
        // 循环列表
        for (FdpFaultDispatchOrderRequestForDownload item : disOrderList) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);

            HSSFRichTextString itemText = new HSSFRichTextString(item.getCompanyName());

            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            if(item.getStoreName()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getStoreName());
            }

            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            if(item.getFaultOrderId()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getFaultOrderId().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            if(item.getRootFaultOrderId()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getRootFaultOrderId().toString());
            }

            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            if(item.getFaultOrderNumber()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getFaultOrderNumber());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            if(item.getHrCount()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getHrCount().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            if(item.getServiceAddress()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getServiceAddress());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            if(item.getServiceProvince()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getServiceProvince());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            if(item.getServiceCity()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getServiceCity());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            if(item.getServiceDistrict()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getServiceDistrict());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            if(item.getDispatchModelRequest()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getDispatchModelRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            if(item.getEquipmentRequest()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getEquipmentRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            if(item.getOtherRequest()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getOtherRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            if(item.getDispatchDescription()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getDispatchDescription());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            if(item.getMemo()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getMemo());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            if(item.getUrgencyRequest()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getUrgencyRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            if(null == item.getServiceDate() || ("").equals(item.getServiceDate())){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(sdf.format(item.getServiceDate()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            if(item.getOtherBrand()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getOtherBrand());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            if(item.getOtherStore()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getOtherStore());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            if(item.getBackupDeviceRequest()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getBackupDeviceRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            if(item.getLongitude()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getLongitude().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(21);
            itemCell.setCellStyle(style);
            if(item.getLatitude()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getLatitude().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(22);
            itemCell.setCellStyle(style);
            if(item.getSourceType()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getSourceType());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(23);
            if(item.getFlagDeleted()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getFlagDeleted().toString());
            }
            itemCell.setCellStyle(style);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(24);
            itemCell.setCellStyle(style);
            if(item.getFlagAvailable()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getFlagAvailable().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(25);
            itemCell.setCellStyle(style);
            if(item.getUserName()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getUserName());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(26);
            if(item.getCreateTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(sdf.format(item.getCreateTime()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(27);
            itemCell.setCellStyle(style);
            if(item.getUpdatePerson()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getUpdatePerson().toString());
            }

            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(28);
            itemCell.setCellStyle(style);
            if(item.getUpdateTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(sdf.format(item.getUpdateTime()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(29);
            itemCell.setCellStyle(style);

        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportExcelStoreList(List<ListRet> list, OutputStream out) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("门店信息");
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 30);
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


        // 列表第一行
        int rowIndex = 0;
        HSSFRow row = sheet.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("");
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("门店名");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("品牌");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("地址");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("产品数量(个)");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("联系人");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("电话");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("有效");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("创建人");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("创建时间");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("更新人");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(style);
        text = new HSSFRichTextString("更新时间");
        cell.setCellValue(text);

        for (ListRet item : list) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);

            HSSFRichTextString itemText = new HSSFRichTextString(item.getStoreName());


            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            if (item.getCompanyBrand() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getCompanyBrand());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            if (item.getAddress() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getAddress());
            }

            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            if (item.getProductCount() == 0) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(String.valueOf(item.getProductCount()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            if (item.getContactName() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getContactName());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            if (item.getMobile() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getMobile());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            if (item.isFlagAvailable() == false) {
                itemText = new HSSFRichTextString("否");
            } else {
                itemText = new HSSFRichTextString("是");
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);

            if (item.getCreatePerson() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getCreatePerson());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);

            if ( item.getCreateTime()== null) {
                itemText = new HSSFRichTextString("");
            } else {
                String str = sdf.format(item.getCreateTime());
                itemText = new HSSFRichTextString(str);
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);

            if (item.getUpdatePerson() == null) {
                itemText = new HSSFRichTextString("");
            } else {
                itemText = new HSSFRichTextString(item.getUpdatePerson());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);



            if ( item.getUpdateTime()== null) {
                itemText = new HSSFRichTextString("");
            } else {
                String str = sdf.format(item.getUpdateTime());
                itemText = new HSSFRichTextString(str);
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);




        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportContactExcel(List<DmiExportContact> sqlResult, OutputStream out) {

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("员工信息");
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
        HSSFRichTextString text = new HSSFRichTextString("联系人姓名");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系人英文名");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系电话-座机");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("手机");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("QQ号");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("微信号");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("email");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("备注");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("所属公司名字");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("所属部门或门店");
        cell.setCellValue(text);


        // 循环列表
        for (DmiExportContact item : sqlResult) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getContactName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getContactNameEn());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTelephone());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMobile());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getQq());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getWechat());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getEmail());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getMemo());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCompanyName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getStoreOrCompany());
            itemCell.setCellValue(itemText);

        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载派工清单
     * @param list
     * @param out
     * @return
     * @Author Liukan
     * @Date 2018/06/23
     */
    public static void exportRequestList(List<FdpFaultdispatchRequestList> list, OutputStream out) {


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("派工清单信息信息");
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
        text = new HSSFRichTextString("服务地址");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建人");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("工单编号");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("品牌");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工阶段");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工类型");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工人数");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("备件要求");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("其他要求");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工描述");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计费用单位");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际费用单位");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建日期");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完工日期");
        cell.setCellValue(text);


        // 循环列表
        for (FdpFaultdispatchRequestList item : list) {

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
            itemText = new HSSFRichTextString(item.getServiceAddress());
            itemCell.setCellValue(itemText);

            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCreatePersonName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDispatchOrderNumber());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBrandName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
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
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            JSONObject jsStr = JSONObject.fromObject(item.getDispatchModelRequest());
            String s = jsStr.get("aaData").toString();
            JSONArray jsArr = JSONArray.fromObject(s);
            String aa = jsArr.getJSONObject(0).getString("arr");

            itemText = new HSSFRichTextString(aa.substring(2,6));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getHrCount().toString());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            if(item.getDeviceRequest().equals("") || item.getDeviceRequest() == null){
                itemText = new HSSFRichTextString("");
            }else {
                //JSONArray device = JSONArray.fromObject(item.getDeviceRequest());
                //String dev ="";
                //String devdev="";
                //String devAll ="";
                //
                //for(int i = 0;i<device.size();i++){
                //    jsStr = device.getJSONObject(i);
                //    for(int j =0 ;j<jsStr.size();j++){
                //        devdev = jsStr.getString(String.valueOf(j));
                //        if(devdev==null||devdev.equals("")){
                //            continue;
                //        }
                //        if(j==jsStr.size()-1){
                //            dev = devdev;
                //            devAll=devAll+dev;
                //        }else {
                //            dev = devdev + ",";
                //            devAll = devAll + dev;
                //        }
                //    }
                //
                //    int indx = devAll.lastIndexOf(",");
                //    if(indx!=-1){
                //        devAll = devAll.substring(0,indx)+devAll.substring(indx+1,devAll.length());
                //    }
                //    //     devAll.substring(0,devAll.length()-1);
                //    devAll =devAll+";";
                //}

                //itemText = new HSSFRichTextString(devAll);
                itemText = new HSSFRichTextString(item.getDeviceRequest());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOtherRequest());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDispatchDescription());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            String estimatedPrice;
            if(item.getEstimatedPrice()==null){
                estimatedPrice ="0.00";
            }else{
                estimatedPrice =item.getEstimatedPrice().toString();
            }
            itemText = new HSSFRichTextString(estimatedPrice);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            String estimatedPriceUnit;
            if(item.getEstimatedPriceUnit() == null){
                estimatedPriceUnit ="人民币";
            }else{
                estimatedPriceUnit =item.getEstimatedPriceUnit();
            }
            itemText = new HSSFRichTextString(estimatedPriceUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            String actualPrice;
            if(item.getEstimatedPrice()==null){
                actualPrice ="0.00";
            }else{
                actualPrice=item.getActualPrice().toString();
            }
            itemText = new HSSFRichTextString(actualPrice);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            String actualPriceUnit;
            if(item.getActualPriceUnit()==null){
                actualPriceUnit ="人民币";
            }else{
                actualPriceUnit=item.getActualPriceUnit();
            }
            itemText = new HSSFRichTextString(actualPriceUnit);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            String createTime = format.format(item.getCreateTime());
            itemText = new HSSFRichTextString(createTime);
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            String completeTime ="";
            if(item.isFlagFinish()==false){
                completeTime ="";
            }else
            {
                 completeTime = format.format(item.getLastDealTime());
            }

            itemText = new HSSFRichTextString(completeTime);
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }  /**
     * 下载派工汇总
     * @param out
     * @return
     * @Author Liukan
     * @Date 2018/06/23
     */

    public static void exportRequestCountList(List<FaultOrderRequestCount> requestCountList, List<FaultOrderRequestCountByCompany> requestListCompany, List<FaultOrderRequestCountByCompany> requestCountByPerson, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("派工汇总");
        HSSFSheet sheet2 = workbook.createSheet("派工雇主汇总");
        HSSFSheet sheet3 = workbook.createSheet("派工创建人汇总");
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
        HSSFRichTextString text = new HSSFRichTextString("派工总量");
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
        text = new HSSFRichTextString("预计总费用");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计未完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际未完成总费用");
        cell.setCellValue(text);

        for (FaultOrderRequestCount item : requestCountList
             ) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(String.valueOf(item.getRequestCountAll()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getRequestCountComplete()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getReqeustCountUncomplete()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getRequestCountCancel()));
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getEstimatedPriceComplete())+item.getEstimatedPriceUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getEstimatedPriceUncomplete())+item.getEstimatedPriceUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getActualPriceComplete())+item.getActualPriceUnit());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(String.valueOf(item.getActualPriceUncomplete())+item.getActualPriceUnit());
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


        for (FaultOrderRequestCountByCompany item:requestListCompany
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
        HSSFRichTextString text3 = new HSSFRichTextString("创建人");
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


        for (FaultOrderRequestCountByCompany item :requestCountByPerson
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

//            itemCell = itemRow.createCell(15);
//            itemCell.setCellStyle(style);
//            String type ;
//            if(item.getActualInvoiceType()==null||item.getActualInvoiceType().equals("")){
//                type ="无";
//            }else{
//                type =item.getActualInvoiceType();
//            }
//            itemText = new HSSFRichTextString(type);
//            itemCell.setCellValue(itemText);
//            itemCell = itemRow.createCell(12);
//            itemCell.setCellStyle(style);
//            itemText = new HSSFRichTextString(item.getActualInvoiceFee().toString());
//            itemCell.setCellValue(itemText);
//            itemCell = itemRow.createCell(13);
//            itemCell.setCellStyle(style);
//            String rate = "";
//            if(item.getActualInvoiceRate()==null){
//                rate = "0";
//            }
//            else{
//                rate =item.getActualInvoiceRate().toString();
//            }
//            itemText = new HSSFRichTextString(rate+"%");
//            itemCell.setCellValue(itemText);

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

    /**
     * 生成客服清单xsl
     * @param detailedLists
     * @param os
     */
    public static void exportProcessListExcel(List<GetFdpProcessDetailedList> detailedLists, OutputStream os) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("客服清单");
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
        text = new HSSFRichTextString("报障来源");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("省份");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完成阶段");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("处理人");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("报障工单号");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建人");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("品牌");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("服务地址");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("报障类型");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系人");
        cell.setCellValue(text);
        cell = row.createCell(12);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("联系电话");
        cell.setCellValue(text);
        cell = row.createCell(13);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计费用");
        cell.setCellValue(text);
        cell = row.createCell(14);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("费用单位");
        cell.setCellValue(text);
        cell = row.createCell(15);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际费用");
        cell.setCellValue(text);
        cell = row.createCell(16);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("费用单位");
        cell.setCellValue(text);
        cell = row.createCell(17);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("创建日期");
        cell.setCellValue(text);
        cell = row.createCell(18);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完成日期");
        cell.setCellValue(text);
        cell = row.createCell(19);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工创建日期");
        cell.setCellValue(text);
        cell = row.createCell(20);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("派工完工日期");
        cell.setCellValue(text);

        // 循环列表
        for (GetFdpProcessDetailedList item : detailedLists) {
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
            itemText = new HSSFRichTextString(item.getInputType());
            if(item.getInputType().equals("SYS")){
                itemText = new HSSFRichTextString("系统");
            }
            if(item.getInputType().equals("WECHAT")){
                itemText = new HSSFRichTextString("微信");
            }
            if(item.getInputType().equals("POS")){
                itemText = new HSSFRichTextString("伯俊");
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProvince());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getOpearteStatus());
            if(item.getOpearteStatus().equals("FAULTCONFIRMED")){
                itemText = new HSSFRichTextString("故障已确认");
            }
            if(item.getOpearteStatus().equals("NEW")){
                itemText = new HSSFRichTextString("新增报障");
            }
            if(item.getOpearteStatus().equals("COMPLETE")){
                itemText = new HSSFRichTextString("已完工");
            }
            if(item.getOpearteStatus().equals("CANCEL")){
                itemText = new HSSFRichTextString("订单已取消");
            }
            if(item.getOpearteStatus().equals("FINISH")){
                itemText = new HSSFRichTextString("结束未完工");
            }
            if(item.getOpearteStatus().equals("DEALING")){
                itemText = new HSSFRichTextString("处理中");
            }
            if(item.getOpearteStatus().equals("RENEW")){
                itemText = new HSSFRichTextString("再次新增");
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDealPerson());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFaultOrderNumber());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCreatePerson());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getBrandName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getServiceAddress());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getFaultType());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getContactName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(12);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getTelephone());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(13);
            itemCell.setCellStyle(style);
            if(item.getEstimatedPrice()==null){
                itemText = new HSSFRichTextString("0.00");
            }else{
                itemText = new HSSFRichTextString(item.getEstimatedPrice().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(14);
            itemCell.setCellStyle(style);
            if(item.getEstimatedPriceUnit()==null){
                itemText = new HSSFRichTextString("人民币");
            }else{
                itemText = new HSSFRichTextString(item.getEstimatedPriceUnit());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(15);
            itemCell.setCellStyle(style);
            if(item.getActualPrice()==null){
                itemText = new HSSFRichTextString("0.00");
            }else{
                itemText = new HSSFRichTextString(item.getActualPrice().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(16);
            itemCell.setCellStyle(style);
            if(item.getActualPriceUnit()==null){
                itemText = new HSSFRichTextString("人民币");
            }else{
                itemText = new HSSFRichTextString(item.getActualPriceUnit());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(17);
            itemCell.setCellStyle(style);
            if(item.getCreateTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(DateUtil.getDayDateString(item.getCreateTime()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(18);
            itemCell.setCellStyle(style);
            if(item.getUpdateTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(DateUtil.getDayDateString(item.getUpdateTime()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(19);
            itemCell.setCellStyle(style);
            if(item.getDispatchCreateTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(DateUtil.getDayDateString(item.getDispatchCreateTime()));
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(20);
            itemCell.setCellStyle(style);
            if(item.getLastDealTime()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(DateUtil.getDayDateString(item.getLastDealTime()));
            }
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成客服汇总xsl
     * @param collectLists
     * @param demandCollectLists
     * @param belongPersonCollerctLists
     * @param os
     */
    public static void exportProcessCollectExcel(List<GetFdpProcessCollectList> collectLists, List<GetDemandCollectList> demandCollectLists, List<GetBelongPersonCollerctList> belongPersonCollerctLists, OutputStream os) {

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheetCollect = workbook.createSheet("客服工单总量汇总");
        HSSFSheet sheetDemand = workbook.createSheet("客服工单雇主汇总");
        HSSFSheet sheetDealPerson = workbook.createSheet("客服工单处理人汇总");
        // 设置表格默认列宽度为20个字节
        sheetCollect.setDefaultColumnWidth((short) 20);

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
        HSSFRow row = sheetCollect.createRow(rowIndex);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(styleBig);
        HSSFRichTextString text = new HSSFRichTextString("故障总量");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("报障总量");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("完成总量");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("未完成总量");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("取消总量");
        cell.setCellValue(text);
        cell = row.createCell(5);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("TK系统量");
        cell.setCellValue(text);
        cell = row.createCell(6);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("伯俊总量");
        cell.setCellValue(text);
        cell = row.createCell(7);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("微信总量");
        cell.setCellValue(text);
        cell = row.createCell(8);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(9);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("预计未完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(10);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际完成总费用");
        cell.setCellValue(text);
        cell = row.createCell(11);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("实际未完成总费用");
        cell.setCellValue(text);


        // 循环列表
        for (GetFdpProcessCollectList item : collectLists) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheetCollect.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getProcessTotal().toString());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            if(item.getReportTotal()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getReportTotal().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            if(item.getCompleteNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getCompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            if(item.getUncompleteNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getUncompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            if(item.getCancelNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getCancelNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(5);
            itemCell.setCellStyle(style);
            if(item.getSysNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getSysNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(6);
            itemCell.setCellStyle(style);
            if(item.getPosNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getPosNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(7);
            itemCell.setCellStyle(style);
            if(item.getWechatNum()==null){
                itemText = new HSSFRichTextString("");
            }else{
                itemText = new HSSFRichTextString(item.getWechatNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(8);
            itemCell.setCellStyle(style);
            if(item.getEstimatedPriceCompleteNum()==null){
                itemText = new HSSFRichTextString("0.00人民币");
            }else{
                itemText = new HSSFRichTextString(item.getEstimatedPriceCompleteNum().toString()+item.getEstimatedPriceUnit());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(9);
            itemCell.setCellStyle(style);
            if(item.getEstimatedPriceUncompleteNum()==null){
                itemText = new HSSFRichTextString("0.00人民币");
            }else{
                itemText = new HSSFRichTextString(item.getEstimatedPriceUncompleteNum().toString()+item.getEstimatedPriceUnit());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(10);
            itemCell.setCellStyle(style);
            if(item.getActualPriceCompleteNum()==null){
                itemText = new HSSFRichTextString("0.00人民币");
            }else{
                itemText = new HSSFRichTextString(item.getActualPriceCompleteNum().toString()+item.getActualPriceUnit());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(11);
            itemCell.setCellStyle(style);
            if(item.getActualPriceUncompleteNum()==null){
                itemText = new HSSFRichTextString("0.00人民币");
            }else{
                itemText = new HSSFRichTextString(item.getActualPriceUncompleteNum().toString()+item.getActualPriceUnit());
            }
            itemCell.setCellValue(itemText);
        }


        // 列表第0行
        int rowIndexDem = 0;
        HSSFRow rowDem = sheetDemand.createRow(rowIndexDem);
        HSSFCell cellDem = rowDem.createCell(0);
        cellDem.setCellStyle(styleBig);
        HSSFRichTextString textDem = new HSSFRichTextString("雇主");
        cellDem.setCellValue(textDem);
        cellDem = rowDem.createCell(1);
        cellDem.setCellStyle(styleBig);
        textDem = new HSSFRichTextString("总量");
        cellDem.setCellValue(textDem);
        cellDem = rowDem.createCell(2);
        cellDem.setCellStyle(styleBig);
        textDem = new HSSFRichTextString("已完成");
        cellDem.setCellValue(textDem);
        cellDem = rowDem.createCell(3);
        cellDem.setCellStyle(styleBig);
        textDem = new HSSFRichTextString("未完成");
        cellDem.setCellValue(textDem);



        // 循环列表
        for (GetDemandCollectList item : demandCollectLists) {
            rowIndexDem = rowIndexDem + 1;
            HSSFRow itemRow = sheetDemand.createRow(rowIndexDem);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getCompanyName().toString());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            if(item.getDemandTotal()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getDemandTotal().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            if(item.getDemCompleteNum()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getDemCompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            if(item.getDemUncompleteNum()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getDemUncompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
        }
        // 列表第0行
        int rowIndexDeal = 0;
        HSSFRow rowDeal = sheetDealPerson.createRow(rowIndexDeal);
        HSSFCell cellDeal = rowDeal.createCell(0);
        cellDeal.setCellStyle(styleBig);
        HSSFRichTextString textPerson = new HSSFRichTextString("处理人");
        cellDeal.setCellValue(textPerson);
        cellDeal = rowDeal.createCell(1);
        cellDeal.setCellStyle(styleBig);
        textPerson = new HSSFRichTextString("总量");
        cellDeal.setCellValue(textPerson);
        cellDeal = rowDeal.createCell(2);
        cellDeal.setCellStyle(styleBig);
        textPerson = new HSSFRichTextString("已完成");
        cellDeal.setCellValue(textPerson);
        cellDeal = rowDeal.createCell(3);
        cellDeal.setCellStyle(styleBig);
        textPerson = new HSSFRichTextString("未完成");
        cellDeal.setCellValue(textPerson);



        // 循环列表
        for (GetBelongPersonCollerctList item : belongPersonCollerctLists) {
            rowIndexDeal = rowIndexDeal + 1;
            HSSFRow itemRow = sheetDealPerson.createRow(rowIndexDeal);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getBelongPersonName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            if(item.getBelongPersonTotal()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getBelongPersonTotal().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            if(item.getBelCompleteNum()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getBelCompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            if(item.getBelUncompleteNum()==null){
                itemText = new HSSFRichTextString("0");
            }else{
                itemText = new HSSFRichTextString(item.getBelUncompleteNum().toString());
            }
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
        }

        try {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void exportStoreExcel(List<ListRet> sqlResult, OutputStream out) {

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("门店信息");
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
        HSSFRichTextString text = new HSSFRichTextString("其他服务点/门店名");
        cell.setCellValue(text);
        cell = row.createCell(1);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("省份");
        cell.setCellValue(text);
        cell = row.createCell(2);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("城市");
        cell.setCellValue(text);
        cell = row.createCell(3);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("行政区");
        cell.setCellValue(text);
        cell = row.createCell(4);
        cell.setCellStyle(styleBig);
        text = new HSSFRichTextString("具体地址");
        cell.setCellValue(text);

        // 循环列表
        for (ListRet item : sqlResult) {
            rowIndex = rowIndex + 1;
            HSSFRow itemRow = sheet.createRow(rowIndex);
            HSSFCell itemCell = itemRow.createCell(0);
            itemCell.setCellStyle(style);
            HSSFRichTextString itemText = new HSSFRichTextString(item.getStoreName());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(1);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getProvince());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(2);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getCity());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(3);
            itemCell.setCellStyle(style);
            itemText = new HSSFRichTextString(item.getDistrict());
            itemCell.setCellValue(itemText);
            itemCell = itemRow.createCell(4);
            itemCell.setCellStyle(style);
            if(item.getImportAddress()!=null&&item.getImportAddress().length()>0){
                itemText = new HSSFRichTextString(item.getImportAddress());
            }else{
                itemText = new HSSFRichTextString(item.getAddress());
            }
            itemCell.setCellValue(itemText);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取本地的临时文件路劲
     *
     * @return
     */
    public static String getLocalFilePath() {
        return "/usr/local/tempFile_xls/";
//        return "D:/excel";
//        return "/Users/zhanghao/work/file/excel/";
    }
}

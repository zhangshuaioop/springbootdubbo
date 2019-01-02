package com.platform.springboot.utils;

import java.math.BigDecimal;

/**
 * 常量
 *
 * @author Wujun
 * @create 2017年08月29日 9:49
 */
public class Constant {

    /**
     * 零（BigDecimal类型）
     */
    public static final BigDecimal DEFAULT_DECIMAL_ZERO = new BigDecimal(0);

    /**
     * 通信资源类型：产品
     */
    public static final String OBJECT_TYPE_PRODUCT = "PRODUCT";

    /**
     * 通信资源类型：套餐
     */
    public static final String OBJECT_TYPE_CAMPAIGN = "CAMPAIGN";

    /**
     * 通信资源状态：新增
     */
    public static final String COMM_STATUS_NEW = "NEW";

    /**
     * 通信资源状态：计费中
     */
    public static final String COMM_STATUS_CHARGING = "CHARGING";

    /**
     * 通信资源状态：准备退出
     */
    public static final String COMM_STATUS_PREPAREQUIT = "PREPAREQUIT";

    /**
     * 通信资源状态：已退出
     */
    public static final String COMM_STATUS_QUIT = "QUIT";

    /**
     * 不拉平
     */
    public final static String NO_EXTEND = "NO-EXTEND";
    /**
     * 按月拉平
     */
    public final static String EXTEND_TO_MONTH = "EXTEND-TO-MONTH";
    /**
     * 按季拉平
     */
    public final static String EXTEND_TO_SEASON = "EXTEND-TO-SEASON";
    /**
     * 按月收费-自然月
     */
    public final static String MONTH_NORMAL = "MONTH-NORMAL";
    /**
     * 按月付费-连续一月
     */
    public final static String MONTH_CONTINUOUS = "MONTH-CONTINUOUS";
    /**
     * 按季收费-自然季
     */
    public final static String SEASON_NORMAL = "SEASON-NORMAL";
    /**
     * 按季付费-连续三月
     */
    public final static String SEASON_CONTINUOUS = "SEASON-CONTINUOUS";
    /**
     * 按半年收费
     */
    public final static String HALF_YEAR = "HALFYEAR";
    /**
     * 按年收费
     */
    public final static String YEAR = "YEAR";
    /**
     * 预付费
     */
    public final static String PREPAY = "PREPAY";
    /**
     * 后付费
     */
    public final static String POSTPAID = "POSTPAID";

    /**
     * 账号类型-平台
     */
    public final static String ACT_TYPE_PLATFORM = "PLATFORM";

    /**
     * 账号类型-集成商
     */
    public final static String ACT_TYPE_VENDOR = "VENDOR";

    /**
     * 账号类型-雇主
     */
    public final static String ACT_TYPE_DEMAND = "DEMAND";
}

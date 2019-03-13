package com.platform.springboot.utils;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zhanghao
 * @Title: LocationUtils
 * @ProjectName WaterDrop
 * @Description: TODO
 * @date 2018/12/27下午6:18
 */
public class LocationUtils {

    private LocationUtils() {
    }

    private static final double EARTH_RADIUS = 6378.137;

    private static final double rad(double d) {
        return d * Math.PI / 180.0;
    }

    private static final int DEFAULT_DIVISOR = 111319;// 默认的除数
    private static final int LATITUDE_TEN_DIVISOR = 109628;// 纬度为十度范围的除数
    private static final int LATITUDE_TWENTY_DIVISOR = 104606;// 纬度为二十度范围的除数
    private static final int LATITUDE_THIRTY_DIVISOR = 96406;// 纬度为三十度范围的除数
    private static final int LATITUDE_FORTY_DIVISOR = 85276;// 纬度为四十度范围的除数
    private static final int LATITUDE_FIFTY_DIVISOR = 71555;// 纬度为五十度范围的除数
    private static final int LATITUDE_SIXTY_DIVISOR = 55660;// 纬度为六十度范围的除数
    private static final int LATITUDE_SEVENTY_DIVISOR = 38074;// 纬度为七十度范围的除数
    private static final int LATITUDE_EIGHTY_DIVISOR = 19330;// 纬度为八十度范围的除数

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static final double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double result = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        result = result * EARTH_RADIUS;
        result = Math.round(result * 10000) / 10;
        return Math.abs(result);
    }

    /**
     * 根据经纬度和查询精度，计算出经纬度的极限值（方形区域）
     *
     * @param longitude 精度
     * @param latitude  纬度
     * @param range     查询精度
     * @return
     */
    public static final Map<String, BigDecimal> calculateLimitRange(double longitude, double latitude, double range) {
        Map<String, BigDecimal> result = Maps.newHashMap();
        // 计算经度的浮动数值
        BigDecimal longitudeRange = MathUtil.defaultDivision(range, DEFAULT_DIVISOR);
        // 计算纬度的浮动数值
        BigDecimal latitudeRange = MathUtil.defaultDivision(range, getDivisor(latitude));
        // 返回上层
        result.put("longitudeMax", new BigDecimal(longitude).add(longitudeRange));
        result.put("longitudeMin", new BigDecimal(longitude).subtract(longitudeRange));
        result.put("latitudeMax", new BigDecimal(latitude).add(latitudeRange));
        result.put("latitudeMin", new BigDecimal(latitude).subtract(latitudeRange));
        return result;
    }

    /**
     * 四舍五入取整
     *
     * @param longitudeOrLatitude 经度或者纬度
     * @return 经度或者纬度四舍五入之后取整的整数
     */
    public static final int round(double longitudeOrLatitude) {
        return new BigDecimal(longitudeOrLatitude).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }


    /**
     * 根据所给纬度，获取所对应的除数
     *
     * @param latitude 纬度
     * @return 除数
     */
    private static int getDivisor(double latitude) {
        int angle = round(latitude);

        if (angle >= 75) {
            return LATITUDE_EIGHTY_DIVISOR;
        }
        if (angle >= 65) {
            return LATITUDE_SEVENTY_DIVISOR;
        }
        if (angle >= 55) {
            return LATITUDE_SIXTY_DIVISOR;
        }
        if (angle >= 45) {
            return LATITUDE_FIFTY_DIVISOR;
        }
        if (angle >= 35) {
            return LATITUDE_FORTY_DIVISOR;
        }
        if (angle >= 25) {
            return LATITUDE_THIRTY_DIVISOR;
        }
        if (angle >= 15) {
            return LATITUDE_TWENTY_DIVISOR;
        }
        if (angle >= 5) {
            return LATITUDE_TEN_DIVISOR;
        }
        return DEFAULT_DIVISOR;
    }
}

package com.platform.springboot.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * @author Wujun
 * @create 2017年04月10日 19:47
 */
public class MathUtil {
    private MathUtil() {
    }

    private static final int DEFAULT_DIVISION_SCALE = 6;

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    /**
     * 从四个书中找出最小的数
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static BigDecimal getMinimumFrom4(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return getLesser(getLesser(a, b), getLesser(c, d));
    }

    /**
     * 获取两个数中较小的数
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal getLesser(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 1 ? b : a;
    }

    /**
     * 除法运算，保留6位小数
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public static final BigDecimal defaultDivision(double dividend, double divisor) {
        return baseDivision(dividend, divisor, DEFAULT_DIVISION_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static final BigDecimal baseDivision(double dividend, double divisor, int scale) {
        BigDecimal bDividend = new BigDecimal(Double.toString(dividend));
        BigDecimal bDivisor = new BigDecimal(Double.toString(divisor));
        return bDividend.divide(bDivisor, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 费用初始化，当费用为空时自动设置成0
     *
     * @param free
     * @return
     */
    public static final BigDecimal freeInit(BigDecimal free) {
        return free == null ? new BigDecimal(0) : free;
    }

    /**
     * BigDecimal转换成字符串
     *
     * @param value
     * @return
     */
    public static final String getStringBigDecimal(BigDecimal value) {
        if (value == null) {
            return String.valueOf(new BigDecimal(0).doubleValue());
        } else {
            return String.valueOf(value.doubleValue());
        }
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return new BigDecimal(b1.multiply(b2).doubleValue());
    }


    /**
     * 生成随机账号
     * @return
     */
        public static String getUserName(int length) {
            String val = "";
            Random random = new Random();
            //参数length，表示生成几位随机数
            for(int i = 0; i < length; i++) {
               String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
              //输出字母还是数字
               if( "char".equalsIgnoreCase(charOrNum) ) {
                        //输出是大写字母还是小写字母
                        int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                        val += (char)(random.nextInt(26) + temp);
                    } else if( "num".equalsIgnoreCase(charOrNum) ) {
                        val += String.valueOf(random.nextInt(10));
               }
            }
            return val;
        }


}

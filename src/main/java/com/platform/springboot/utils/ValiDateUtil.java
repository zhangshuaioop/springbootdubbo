package com.platform.springboot.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.validation.BindingResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 参数检验工具
 * @author: zhangshuai
 * @create: 2018-11-26 13:32
 */
public class ValiDateUtil {

    //校验手机号
    public static boolean failPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }


    //校验邮箱
    public static boolean failEmail(String email) {
        Pattern p = Pattern.compile("/^(\\w)+(.\\w+)*@(\\w)+((.\\w+)+)$/");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     *
     * @param value 指定的字符串
     * @return 字符串的长度
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * 判断字符串是否是纯数字
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isNumeric(String arg) {
        boolean result = false;
        Pattern pattern1 = Pattern.compile("[0-9]*");
        if (pattern1.matcher(arg).matches()) {
            result = true;
        }
        return result;
    }

    /**
     * 判断字符串是半角还是全角
     *
     * @param
     * @return true:半角
     * false:全角
     */
    public static boolean isAllHalf(String arg) {
        char[] chs = arg.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!(('\uFF61' <= chs[i]) && (chs[i] <= '\uFF9F')) && !(('\u0020' <= chs[i]) && (chs[i] <= '\u007E'))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 共通校验
     *
     * @param bindingResult
     * @return
     */
    public static Result commonValidate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.errorBusinessMsg(errorMessage);
        } else {
            return null;
        }
    }


    /**
     * 判断字符串是否是数字和+-
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isMobileArea(String arg) {
        boolean result = false;
        Pattern pattern1 = Pattern.compile("[0-9+]*");
        if (pattern1.matcher(arg).matches()) {
            result = true;
        }
        return result;
    }


    /**
     * 判断字符串是否是数字（包含浮点型）
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isNumericType(String arg) {
        boolean result = false;
        Pattern pattern1 = Pattern.compile("^[0-9]+(.[0-9]+)?$");
        if (pattern1.matcher(arg).matches()) {
            result = true;
        }
        return result;
    }

    /**
     * 判断字符串是否包含数字
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean hasNumeric(String arg) {
        boolean result = false;
        Pattern pattern1 = Pattern.compile("[0-9]");
        if (pattern1.matcher(arg).find()) {
            result = true;
        }
        return result;
    }


    /**
     * 判断字符串是否是英数
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isAlphanumeric(String arg) {
        boolean result = false;
        Pattern pattern1 = Pattern.compile("[a-zA-Z0-9]*");
        if (pattern1.matcher(arg).matches()) {
            result = true;
        }
        return result;
    }

    /**
     * 判断字符串是否是半角英文
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isAllHalfAlpha(String arg) {
        String s = arg.replaceAll(" ", "");
        if (!isAllHalf(s)) {
            return false;
        }
        Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
        if (pattern1.matcher(s).matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否是汉字
     *
     * @param
     * @return true:是汉子
     * false:不是汉字
     */
    public static boolean isChinese(String arg) {
        Pattern pattern1 = Pattern.compile("[a-zA-Z0-9]");
        if (pattern1.matcher(arg).find()) {
            return false;
        }
        if (isAllHalf(arg)) return false;
        return true;
    }

    /**
     * 判断字符串是否是半角数字下划线和括号
     *
     * @param
     * @return true:是
     * false:不是
     */
    public static boolean isAllHalfNum(String arg) {
        if (!isAllHalf(arg)) {
            return false;
        }
        Pattern pattern1 = Pattern.compile("[a-zA-Z0-9(),-]*");
        if (pattern1.matcher(arg).matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是Email
     *
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断是否是整数
     *
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 包含大小写字母及数字且在6-12位
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        String regex = "^[0-9a-zA-Z]{6,12}";
        //boolean isRight = isDigit && isLetter && str.matches(regex);
        return str.matches(regex);
    }

    /**
     * 手机号正则判断
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        if (str != null && !"".equals(str) && str.length() == 11) {
            String s2 = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";// 验证手机号
            if (StringUtils.isNotBlank(str)) {
                p = Pattern.compile(s2);
                m = p.matcher(str);
                b = m.matches();
            }
        }
        return b;
    }

    /**
     * 判断字符串是否为时间格式
     *
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 判断日期是否大于当前日期
     *
     * @param str
     * @return
     */
    public static boolean isDateBefore(String str) {
        boolean convertSuccess = false;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date pastDate = format.parse(str);
            Date nowDate = format.parse(format.format(new Date()));
            if (!pastDate.before(nowDate) || pastDate.getTime() == nowDate.getTime()) {
                convertSuccess = true;
            }
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 校验excel行是否为空
     *
     * @param row
     * @return
     */
    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellTypeEnum()!=null) {
                return false;
            }
        }
        return true;
    }

    public static Date addSeconds(Date date, Integer seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}

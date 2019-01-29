package com.teekee.blackrockservice.utils;

import org.springframework.validation.BindingResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Wujun
 * @create 2017年05月25日 14:21
 */
public class ValidateUtil {

    /**
     * 共通校验
     *
     * @param bindingResult
     * @return
     */
    public static ResponseMessage commonValidate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return StringUtil.buildErrorRespMsg(errorMessage);
        } else {
            return null;
        }
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
     * 判断是否为1开头的11位手机号
     *
     * @return
     */
    public static boolean isPhoneStart(String str) {
        if(str == null || "".equals(str)){
            return false;
        }
        return str.matches("^1[0-9]{10}$");
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
}

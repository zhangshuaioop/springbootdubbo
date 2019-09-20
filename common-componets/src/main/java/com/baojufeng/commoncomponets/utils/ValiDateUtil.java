package com.baojufeng.commoncomponets.utils;

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

}

package com.teekee.blueoceanservice.utils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by Wujun on 2017/3/10.
 */
public class FileUtil {
    private FileUtil() {
    }

    private final static String DOT = ".";

    /**
     * 构造阿里云KEY
     *
     * @param model
     * @param OriginalFilename
     * @return
     */
    public final static String buildKey(String model, String OriginalFilename) {
        StringBuilder sb = new StringBuilder(model);
        sb.append("/").append(OriginalFilename);
        return sb.toString();
    }

    /**
     * 组装保聚丰唯一上传文件名
     * 格式：yyyyMMddHHmmssSSS（年月日时分秒毫秒）+文件类型
     * 例如：20170310133001123.img
     *
     * @param file
     * @return
     */
    public final static String buildFileName(CommonsMultipartFile file) {
        return DateUtil.getMilliDateString(new Date()) + DOT + getFileType(file);
    }

    /**
     * 组装保聚丰唯一上传文件名
     * 格式：yyyyMMddHHmmssSSS（年月日时分秒毫秒）+文件类型
     * 例如：20170310133001123.img
     *
     * @param file
     * @return
     */
    public final static String buildFileName(File file) {
        return DateUtil.getMilliDateString(new Date()) + random()+DOT + getFileType(file);
    }

    private static String random() {

        String result = "";

        while (result.length() <6) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;
    }

    /**
     * 获取文件的类型
     *
     * @param file
     * @return
     */
    public final static String getFileType(CommonsMultipartFile file) {
        String fileOriginalName = file.getOriginalFilename();
        int lastIdx = fileOriginalName.lastIndexOf(DOT);
        if (lastIdx >= 0) {
            return fileOriginalName.substring(lastIdx + DOT.length()).toLowerCase();
        }
        return null;
    }

    /**
     * 获取文件的类型
     *
     * @param file
     * @return
     */
    public final static String getFileType(File file) {
        String fileOriginalName = file.getName();
        int lastIdx = fileOriginalName.lastIndexOf(DOT);
        if (lastIdx >= 0) {
            return fileOriginalName.substring(lastIdx + DOT.length()).toLowerCase();
        }
        return null;
    }

    /**
     * 获取对象在阿里云OSS服务器上面的存储路劲
     *
     * @return
     */
    public final static String getFilePathInOSS(String ossPath, String OriginalFilename) {
        final StringBuilder sb = new StringBuilder(ossPath);
        sb.append(OriginalFilename);
        return sb.toString();
    }

}

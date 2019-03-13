package com.company.springboot.entity.sys;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author zhanghao
 * @Title: FileUpload
 * @ProjectName WaterDrop
 * @Description: oss文件上传实体
 * @date 2019/1/13下午4:54
 */
public class FileUpload {


    private CommonsMultipartFile file;
    private String model;
    private String type;

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FileUpload{" +
                "file=" + file +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

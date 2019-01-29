package com.teekee.waterdropservice.controller;

import com.teekee.waterdropservice.service.file.FileServiceImpl;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FileUploadController
 * @ProjectName WaterDrop
 * @Description: oss上传
 * @date 2019/1/13下午4:52
 */
@RestController
@RequestMapping("/file")
@Api(description = "oss上传")
public class FileUploadController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private FileServiceImpl service;

    @ApiOperation(value = "上传文件至阿里云OSS服务器", httpMethod = "POST", notes = "上传文件至阿里云OSS服务器")
    @PostMapping(value = "/upload")
    public Result fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("model") String model, @RequestParam("type") String type) {
        log.info("上传文件至阿里云OSS服务器-开始");
        // 调用业务接口
        Result result = service.upload(file,model,type);
        log.info("上传文件至阿里云OSS服务器-结束");
        return result;
    }
}

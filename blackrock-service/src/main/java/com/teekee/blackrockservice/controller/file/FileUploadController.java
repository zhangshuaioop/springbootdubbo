package com.teekee.blackrockservice.controller.file;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.service.file.FileService;
import com.teekee.blackrockservice.utils.ResponseMessage;
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
 * @Author Niting
 * @date 2018/11/2
 **/
@Api(value = "FileUploadController", tags = "upload-service")
@RestController
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    private Logger log = Logger.getLogger(FileUploadController.class);

    @Resource
    private FileService service;

    @ApiOperation(value = "上传文件至阿里云OSS服务器", notes = "上传文件至阿里云OSS服务器", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("model") String model, @RequestParam("type") String type) {
        log.info("上传文件至阿里云OSS服务器-开始");
        ResponseMessage result = service.upload(file, model,type);
        log.info("上传文件至阿里云OSS服务器-结束");
        return result.getMessage();
    }

    @ApiOperation(value = "上传录音文件至阿里云OSS服务器", notes = "上传录音文件至阿里云OSS服务器", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/uploadVoice")
    public String fileUploadVoice(@RequestParam("file") MultipartFile file, @RequestParam("model") String model, @RequestParam("type") String type, @RequestParam("voiceLogLength")String voiceLogLength) {
        log.info("上传录音文件至阿里云OSS服务器-开始");
        ResponseMessage result = service.uploadVoice(file, model,type,voiceLogLength);
        log.info("上传录音文件至阿里云OSS服务器-结束");
        return build(result);
    }

}

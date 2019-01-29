package com.teekee.waterdropservice.service.file;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.teekee.commoncomponets.enums.ResultEnum;
import com.teekee.waterdropservice.entity.file.DeleteFile;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.google.common.collect.Maps;
import com.teekee.waterdropservice.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @author Wujun
 * @create 2017年09月25日 15:58
 */
@Service
public class FileServiceImpl {

    @Value("${oss.file.path}")
    private String ossPath;

    @Value("${oss.end.point}")
    private String endPoint;

    @Value("${oss.access.key.id}")
    private String accessKeyId;

    @Value("${oss.access.key.secret}")
    private String accessKeySecret;

    @Value("${oss.bucket.file.name}")
    private String bucketNm;


    @Value("${oss.bucket.img.name}")
    private String bucketImg;

    @Value("${oss.img.path}")
    private String imgPath;

    @Value("${model.bif}")
    private String modelBif;
    @Value("${model.fdp}")
    private String modelFdp;
    @Value("${model.dmi}")
    private String modelDmi;
    @Value("${model.disptachChatLog}")
    private String modelChatLog;
    @Value("${model.dispatchRequest}")
    private String modelDisReq;
    @Value("${model.dispatchCompleteFile}")
    private String modelDisComplete;
    @Value("${type.image}")
    private String typeImage;
    @Value("${type.video}")
    private String typeVideo;
    @Value("${type.file}")
    private String typeFile;


    public Result delete(DeleteFile record) {
        // 获取properties文件信息
//        Map<String, String> environmentMap;
//        try {
//            environmentMap = getProperties("environment.properties");
//        } catch (IOException e) {
//            return StringUtil.buildErrorRespMsg(e.getMessage());
//        }
//        String endPoint = environmentMap.get("oss.end.point");
//        String accessKeyId = environmentMap.get("oss.access.key.id");
//        String accessKeySecret = environmentMap.get("oss.access.key.secret");
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        //
        ossClient.deleteObject(record.getType(), record.getKey());
        // 关闭client
        ossClient.shutdown();
        return ResultUtil.successMsg("删除成功");
    }



    public Result upload(MultipartFile file, String model, String type) {
        if (typeImage.equals(type)) {

            bucketNm = bucketImg;
            ossPath = imgPath;
        }
        // 初始化OSS客户端，返回参数
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

        // 判断文件类型是否符合条件
        FileUtil.getFileType(file);

        // 重构文件名称
        String OriginalFilename = FileUtil.buildFileName(file);

        // 判断类型和模块是否符合条件
        if (!modelDmi.equals(model) && !modelBif.equals(model) && !modelFdp.equals(model) && !modelChatLog.equals(model) && !modelDisReq.equals(model) && !modelDisComplete.equals(model)) {
            return ResultUtil.validateError(ResultEnum.UPLOAD_MODEL_TYPE_FAILURE.getMsg());
        }
        if (!typeImage.equals(type) && !typeFile.equals(type) && !typeVideo.equals(type)) {
            return ResultUtil.validateError(ResultEnum.UPLOAD_MODEL_TYPE_FAILURE.getMsg());
        }

        // 生成上传文件key
        String updateKey = FileUtil.buildKey(model, OriginalFilename);

        try {
            // 上传至阿里云OSS
            client.putObject(bucketNm, updateKey, file.getInputStream());
        } catch (OSSException oe) {
            return ResultUtil.errorExceptionMsg(oe.getErrorMessage());
        } catch (IOException e) {
            return ResultUtil.errorExceptionMsg(e.getMessage());
        } finally {
            client.shutdown();
        }

        return ResultUtil.successMsg(FileUtil.getFilePathInOSS(ossPath, updateKey));
    }



    public Result upload(String fileName, InputStream inputStream, String bjfType) {

        // 初始化OSS客户端，返回参数
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

        // 生成上传文件key
        String updateKey = FileUtil.buildKey(bjfType, fileName);

        try {
            // 上传至阿里云OSS
            client.putObject(bucketNm, updateKey, inputStream);
        } catch (OSSException oe) {
            return ResultUtil.errorExceptionMsg(oe.getErrorMessage());
        } finally {
            client.shutdown();
        }

        return ResultUtil.successMsg(FileUtil.getFilePathInOSS(ossPath, updateKey));
    }

    /**
     * 获取指定Properties文件中的内容
     *
     * @param PropertiesName
     * @return
     * @throws IOException
     */
    private final Map<String, String> getProperties(String PropertiesName) throws IOException {
        Properties pps = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PropertiesName);
        pps.load(inputStream);
        Enumeration enum1 = pps.propertyNames();
        Map<String, String> result = Maps.newHashMap();
        while (enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            result.put(strKey, strValue);
        }
        return result;
    }




    public Result uploadLocal(File file, String model, String type) {

        // 获取properties文件信息
//        Map<String, String> environmentMap;
        Map<String, String> uploadMap;
        try {
//            environmentMap = getProperties("environment.properties");
            uploadMap = getProperties("upload_path.properties");
        } catch (IOException e) {
            return ResultUtil.errorExceptionMsg(e.getMessage());
        }
//        String ossPath = environmentMap.get("oss.file.path");
//        String endPoint = environmentMap.get("oss.end.point");
//        String accessKeyId = environmentMap.get("oss.access.key.id");
//        String accessKeySecret = environmentMap.get("oss.access.key.secret");
        String modelBif = uploadMap.get("model.bif");
        String modelFdp = uploadMap.get("model.fdp");
        String modelDmi = uploadMap.get("model.dmi");
        String modelChatLog = uploadMap.get("model.disptachChatLog");
        String modelDisReq = uploadMap.get("model.dispatchRequest");
        String modelDisComplete = uploadMap.get("model.dispatchCompleteFile");
        String modeQrcode = uploadMap.get("model.qrcode");
        String typeImage = uploadMap.get("type.image");
        String typeVideo = uploadMap.get("type.video");
        String typeFile = uploadMap.get("type.file");
//        String bucketNm = environmentMap.get("oss.bucket.file.name");
        if (typeImage.equals(type)) {
//            bucketNm = environmentMap.get("oss.bucket.img.name");
//            ossPath = environmentMap.get("oss.img.path");
            bucketNm = bucketImg;
            ossPath = imgPath;
        }

        // 初始化OSS客户端，返回参数
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

        // 判断文件类型是否符合条件
        FileUtil.getFileType(file);

        // 重构文件名称
        String OriginalFilename = FileUtil.buildFileName(file);

        // 判断类型和模块是否符合条件
        if (!modelDmi.equals(model) && !modelBif.equals(model) && !modelFdp.equals(model) && !modelChatLog.equals(model) && !modelDisReq.equals(model) && !modelDisComplete.equals(model)&&!modeQrcode.equals(model)) {
            return ResultUtil.validateError(ResultEnum.UPLOAD_MODEL_TYPE_FAILURE.getMsg());
        }
        if (!typeImage.equals(type) && !typeFile.equals(type) && !typeVideo.equals(type)) {
            return ResultUtil.validateError(ResultEnum.UPLOAD_MODEL_TYPE_FAILURE.getMsg());
        }

        // 生成上传文件key
        String updateKey = FileUtil.buildKey(model, OriginalFilename);

        try {
            // 上传至阿里云OSS
            client.putObject(bucketNm, updateKey, file);
        } catch (OSSException oe) {
            return ResultUtil.errorExceptionMsg(oe.getErrorMessage());
        } finally {
            client.shutdown();
        }

        return ResultUtil.successMsg(FileUtil.getFilePathInOSS(ossPath, updateKey));
    }
}

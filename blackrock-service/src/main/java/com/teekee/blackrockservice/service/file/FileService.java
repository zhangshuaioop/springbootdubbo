package com.teekee.blackrockservice.service.file;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.teekee.blackrockservice.config.ResponseMessageConfig;
import com.teekee.blackrockservice.entity.file.GetUploadVoice;
import com.teekee.blackrockservice.utils.DateUtil;
import com.teekee.blackrockservice.utils.FileUtil;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Service
public class FileService{

    @Value("${oss.file.path}")
    private String ossPath;

    @Value("${oss.img.path}")
    private String imgPath;

    @Value("${oss.end.point}")
    private String endPoint;


    @Value("${oss.access.key.id}")
    private String accessKeyId;

    @Value("${oss.access.key.secret}")
    private String accessKeySecret;


    @Value("${oss.bucket.img.name}")
    private String bucketNm1;

    @Value("${oss.bucket.file.name}")
    private String bucketNm2;




    @Value("${model.wechat}")
    private String modelWechat;

    @Value("${type.image}")
    private String typeImage;

    @Value("${type.file}")
    private String typeFile;

    @Value("${type.video}")
    private String typeVideo;

    @Value("${type.voice}")
    private String typeVoice;



    public ResponseMessage upload(MultipartFile file, String model, String type) {
        String bucketNm = bucketNm2;
        String path = ossPath;
        if (typeImage.equals(type)) {
            bucketNm = bucketNm1;
            path = imgPath;
        }

        // 初始化OSS客户端，返回参数
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

        // 判断文件类型是否符合条件
        FileUtil.getFileType(file);

        // 重构文件名称
        String OriginalFilename = FileUtil.buildFileName(file);

        // 判断类型和模块是否符合条件
        if (!modelWechat.equals(model) ) {
            return StringUtil.buildErrorRespMsg(ResponseMessageConfig.UPLOAD_MODEL_TYPE_FAILURE);
        }
        if (!typeImage.equals(type) && !typeFile.equals(type) && !typeVideo.equals(type)) {
            return StringUtil.buildErrorRespMsg(ResponseMessageConfig.UPLOAD_MODEL_TYPE_FAILURE);
        }

        // 生成上传文件key
        String updateKey = FileUtil.buildKey(model, OriginalFilename);

        try {
            // 上传至阿里云OSS
            client.putObject(bucketNm, updateKey, file.getInputStream());
        } catch (OSSException oe) {
            return StringUtil.buildErrorRespMsg(oe.getErrorMessage());
        } catch (IOException e) {
            return StringUtil.buildErrorRespMsg(e.getMessage());
        } finally {
            client.shutdown();
        }

        return StringUtil.buildSuccessRespMsg(FileUtil.getFilePathInOSS(path, updateKey));
    }

    /**
     * 上传语音文件
     * @param file
     * @param
     *@param model
     * @param type   @return
     */
    public ResponseMessage uploadVoice(MultipartFile file, String model, String type, String voiceLogLength) {

        // 初始化OSS客户端，返回参数
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

        // 判断文件类型是否符合条件
        FileUtil.getFileType(file);

        // 重构文件名称
        String OriginalFilename = FileUtil.buildFileName(file);

        // 判断类型和模块是否符合条件
        if (!modelWechat.equals(model)) {
            return StringUtil.buildErrorRespMsg(ResponseMessageConfig.UPLOAD_MODEL_TYPE_FAILURE);
        }
        if (!typeVoice.equals(type)) {
            return StringUtil.buildErrorRespMsg(ResponseMessageConfig.UPLOAD_MODEL_TYPE_FAILURE);
        }

        // 生成上传文件key
        String updateKey = FileUtil.buildKey(model, OriginalFilename);

        try {
            // 上传至阿里云OSS
            client.putObject(bucketNm2, updateKey, file.getInputStream());
        } catch (OSSException oe) {
            return StringUtil.buildErrorRespMsg(oe.getErrorMessage());
        } catch (IOException e) {
            return StringUtil.buildErrorRespMsg(e.getMessage());
        } finally {
            client.shutdown();
        }

        if(FileUtil.getFilePathInOSS(ossPath, updateKey).equals("")){
            return StringUtil.buildErrorRespMsg("上传失败！");
        }
        GetUploadVoice voice = new GetUploadVoice();
        voice.setUrl(FileUtil.getFilePathInOSS(ossPath, updateKey));
        voice.setUploadTime(DateUtil.getNewFormat(new Date()));
        voice.setVoiceLogLength(voiceLogLength);
        ResponseMessage result = StringUtil.buildSuccessRespMsg("上传成功！");
        result.setData(voice);
        return result;
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
}

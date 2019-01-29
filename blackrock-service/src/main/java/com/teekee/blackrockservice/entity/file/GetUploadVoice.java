package com.teekee.blackrockservice.entity.file;

/**
 * @Author Niting
 * @date 2018/8/20
 **/
public class GetUploadVoice {
    String url;
    String uploadTime;
    String voiceLogLength;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getVoiceLogLength() {
        return voiceLogLength;
    }

    public void setVoiceLogLength(String voiceLogLength) {
        this.voiceLogLength = voiceLogLength;
    }
}

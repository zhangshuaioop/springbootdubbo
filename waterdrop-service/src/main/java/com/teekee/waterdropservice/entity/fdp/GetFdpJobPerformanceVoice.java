package com.teekee.waterdropservice.entity.fdp;

/**
 * @Author Niting
 * @date 2018/8/22
 **/
public class GetFdpJobPerformanceVoice {

    private String voiceLogUrl;

    private String voiceLogLength;

    private String voiceLogTime;

    public String getVoiceLogUrl() {
        return voiceLogUrl;
    }

    public void setVoiceLogUrl(String voiceLogUrl) {
        this.voiceLogUrl = voiceLogUrl;
    }

    public String getVoiceLogLength() {
        return voiceLogLength;
    }

    public void setVoiceLogLength(String voiceLogLength) {
        this.voiceLogLength = voiceLogLength;
    }

    public String getVoiceLogTime() {
        return voiceLogTime;
    }

    public void setVoiceLogTime(String voiceLogTime) {
        this.voiceLogTime = voiceLogTime;
    }
}

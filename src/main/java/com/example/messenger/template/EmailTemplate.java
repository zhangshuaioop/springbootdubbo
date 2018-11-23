package com.example.messenger.template;

/**
 * @description: 邮箱模板
 * @author: zhangshuai
 * @create: 2018-11-22 16:38
 */
public enum EmailTemplate {

    //客服
    KEFU("保聚风", "十一活动\n",
            "客服你好:\n" +
            "我是巴拉巴拉，\n" +
            "谢谢"),

    //采购
    CAIGOU("保聚风", "十一活动\n",
            "采购你好:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢"),

    //雇主
    GUZHU("保聚风", "十一活动\n",
            "雇主你好:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢"),

    //集成商
    JICHENGSHANG("保聚风", "十一活动\n",
            "集成商你好:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢"),;
    /**
     * 发送人名称
     */
    private String nickName;

    /**
     * 发送标题
     */
    private String subject;

    /**
     * 发送内容
     */
    private String context;



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }



    EmailTemplate(String nickName, String subject, String context) {
        this.nickName = nickName;
        this.subject = subject;
        this.context = context;
    }
}

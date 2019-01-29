package com.teekee.blackrockservice.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.log4j.Logger;

/**
 * Created by ray on 2017/1/4.
 */
public class DataFormatTransform {

    private static Logger log = Logger.getLogger(DataFormatTransform.class);

    /**
     * 将Controller返回的Json进行跨域处理
     *
     * @param model
     * @return
     */
    public static String changeModel2Json(Object model) {
        String json = JSON.toJSONString(model, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature
                .WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty);
        log.info("返回的Json为：" + json);
        return json;
    }

}

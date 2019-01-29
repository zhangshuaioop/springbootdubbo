package com.teekee.blueoceanservice.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: dozer配置
 * @author: zhangshuai
 * @create: 2018-11-29 18:34
 */

@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper dozer() {
        //这里是配置文件的路径
//        List<String> mappingFiles = Arrays.asList("dozer/dozer-mapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
//        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

//    @Bean("objectMapper")
//    public ObjectMapper myMapper() {
//        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//    }


}

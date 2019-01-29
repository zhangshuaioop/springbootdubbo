package com.teekee.cloudzuul.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: swagger文档资源配置
 * @author: zhangshuai
 * @create: 2018-10-30 21:51
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
        resources.add(swaggerResource("公司系统", "/waterDrop/v2/api-docs", "2.0"));
        resources.add(swaggerResource("平台系统", "/blueOcean/v2/api-docs", "2.0"));
        resources.add(swaggerResource("小程序系统", "/blackrock/v2/api-docs", "2.0"));
        resources.add(swaggerResource("消息系统", "/messenger/v2/api-docs", "2.0"));
        return resources;
    }
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}

package com.company.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @description: swgger2
 * @author: zhangshuai
 * @create: 2018-10-25 10:27
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    // 设置默认TOKEN，方便测试
    private static final String TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aGFveGluZ3VvLVtST0xFX0FETUlOLCBBVVRIX1dSSVRFXSIsImV4cCI6MTUzOTMzOTM0NX0.P9dkLQ7lpNODJppHBM-InSS90nw0XJieK8QNlZM0TeuNNQ8sUPYH-uif099A1-P2Ap6b_9lCLbXL2iR0OLdFyw";


    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("令牌").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.springboot.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder()
                        .code(500).message("500 message").responseModel(new ModelRef("Error"))
                        .build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
        return docket;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("COMPANYAPI")
                .description("公司系统接口文档说明")
                .termsOfServiceUrl("")
                .contact(new Contact("zs", "", ""))
                .version("2.0")
                .build();
    }

}

package com.cisco.peo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()/*RequestHandlerSelectors.basePackage("com.cisco.si")*/)
                .paths(PathSelectors.any()/*regex("/si/api.*")*/)
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "SI API",
                "SI API for Marketplaces",
                "0.0.1",
                "Terms of Service",
                new Contact("Amit Gaurav", "http://directory.cisco.com/dir/reports/amigaura",
                        "amigaura@cisco.com"),
                "Cisco License Version 2.0",
                "https://www.cisco.org/licesen.html"
        );

    }

}

package com.wuaishop.api.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mwl
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(com.wuaishop.api.config.swagger.Swagger2properties.class)
@ConditionalOnProperty(prefix = "swagger2", name = "enabled", havingValue = "true", matchIfMissing = true)
public class Swagger2config {

    @Autowired
    Swagger2properties swagger2Properties;

    @Bean
    public Docket createRestApi() {
        if (StringUtils.hasText(swagger2Properties.getBasePackage())) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
                    .paths(PathSelectors.any())
                    .build();
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    .paths(PathSelectors.any())
                    .build();
        }
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription())
                .version(swagger2Properties.getVersion())
                .contact(new Contact(swagger2Properties.getContactName(), swagger2Properties.getContactUrl(), swagger2Properties.getContactEmail()))
                .build();
    }
}

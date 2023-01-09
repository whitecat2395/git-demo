package com.wuaishop.api.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mwl
 */
@Data
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2properties {

    boolean enabled = true;

    String title = "swagger";

    String description = "swagger doc";

    String version = "2.0";

    String contactName = "developer";

    String contactUrl = "http://springcloud2022.com";

    String contactEmail = "springcloud2022@gmail.com";

    /**
     * 扫描路径
     */
    String basePackage = "com.wuaishop.api";

}

package com.project.escape.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("방탈출 프로젝트 API")
                        .description("방탈출 예약을 하기위한 페이지 입니다.")
                        .version("v1.0.0")
                );
    }
}

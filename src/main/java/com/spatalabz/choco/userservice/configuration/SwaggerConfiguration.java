package com.spatalabz.choco.userservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spatalabz.choco.userservice"))
                .paths(PathSelectors.regex("/.*")).build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Rohan Ravindra Kadam",
                "//", "rohankadam662@gmail.com");
        return new ApiInfoBuilder().title("Choco userservice ")
                .description("Choco userservice for getting adding customer")
                .version("1.0")
                .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }




    }

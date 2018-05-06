package de.andi.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket dockerBean() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())//
            .build()
            //Convenience rule builder that substitutes LocalDate with String when rendering model properties
            //.directModelSubstitute(LocalDate.class, String.class)
            .apiInfo(apiInfo())
            .globalOperationParameters(globalOperationParameters());
    }

    private List<Parameter> globalOperationParameters() {
        List<Parameter> p = new ArrayList();
        p.add(new ParameterBuilder()
            .name("someGlobalParameter")
            .description("Description of someGlobalParameter")
            .modelRef(new ModelRef("string"))
            .parameterType("query")
            .required(true)
            .build());
        return p;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Andis Demo Spring Boot REST API")
            .description("\"Andis Spring Boot REST API with swagger-ui\"")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
            .build();
    }

}

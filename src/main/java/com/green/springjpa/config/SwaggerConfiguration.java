package com.green.springjpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

//Annotation에서 Yaml에 있는 데이터 사용하는 방법 ${속성명}
@OpenAPIDefinition(
        info = @Info(
                title = "${constants.swagger.info.title}"
                , description = "${constants.swagger.info.description}"
                , version = "${constants.swagger.info.version}"
        )
        , security = @SecurityRequirement(name = "Authorization")
)
public class SwaggerConfiguration {

}

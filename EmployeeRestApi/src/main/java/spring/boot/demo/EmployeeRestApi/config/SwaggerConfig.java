
package spring.boot.demo.EmployeeRestApi.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger Configuration Class
 * @author Udhay
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket empApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("spring.boot.demo.EmployeeRestApi.controller"))
				.paths(regex("/employee.*")).build().apiInfo(metaData());
	}

	public ApiInfo metaData() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Spring Boot - REST Demo",
				"Spring Rest Example - Employee Service", "1.0", "TOC", "Udhay",
				"Apache License", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}

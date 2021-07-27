/**
 * 
 */
package com.student.advice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Prateek Maurya
 *
 */

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
     return new OpenAPI() .info(new Info() .title("Student Service API").version(appVersion) .description(appDesciption)
    		 .termsOfService("http://swagger.io/terms/").license(new License().name("GNU General Public License v3").url("https://www.gnu.org/licenses/gpl-3.0.en.html")));
    }

}

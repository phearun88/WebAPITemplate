/**
 * Author : PhearunPhin
 * Date : 8/3/2023
 */

package com.phearun.needhelpAPI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {

    @Value("${application.rest.allowed-origins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") //
//              //  .allowedOrigins(allowedOrigins) //
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS") //
//                .allowedHeaders("*");

        registry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("*")    // Allow requests from any origin (replace with your specific origin if needed)
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS") // Allow specific HTTP methods  //, "POST", "PUT", "DELETE", "OPTIONS"
                .allowedHeaders("*");   // Allow all headers in the request
    }
}

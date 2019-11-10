package com.nguyenvk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    static final String FORWARD_INDEX_VIEW = "forward:/index.html";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        Arrays.stream(getUrlPatterns()).forEach(url -> {
            registry.addViewController(url)
                    .setViewName(FORWARD_INDEX_VIEW);
        });
    }

    public String[] getUrlPatterns() {
        return new String[] {
                "/",
                "/employeeReview",
                "/admin/**",
        };
    }
}

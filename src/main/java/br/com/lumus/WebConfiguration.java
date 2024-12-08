package br.com.lumus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        handlerRegistry.addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/static/**");
    }

}

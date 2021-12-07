package com.sarin.cms.config;

import com.sarin.cms.filter.MyUrlFilterA;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyUrlFilterA> registrationBean(){

        FilterRegistrationBean<MyUrlFilterA> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyUrlFilterA());
        registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
}

package com.springboot.blog.config;

import com.springboot.blog.interceptor.LoginInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义配置类
 */
@Configuration
public class AppConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/dashboard").setViewName("dashboard");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/").setViewName("index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/index", "/index.html", "/css/**", "/plugin/**",
                                "/js/**", "/webjars/**", "/images/**", "/common/**", "/login",
                                "/login.html","/logout");
            }

        };
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                String lang = request.getParameter("lang");
                Locale locale = Locale.getDefault();
                if(StringUtils.isNotBlank(lang) && lang.contains("_")){
                    String[] langArr = lang.split("_");
                    locale=new Locale(langArr[0],langArr[1]);
                }
                return locale;
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        };
    }
}

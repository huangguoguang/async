package com.huangguang.config;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;


/**
 * 拦截器注册
 *
 * @author WangYang
 * @version 1.0
 * @datetime 2017/2/28 17:55
 */
@Service("webMvcConfiguration")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(mvcTaskExecutor());//所借助的TaskExecutor
        configurer.setDefaultTimeout(30 * 1000L); //tomcat默认10秒
        super.configureAsyncSupport(configurer);
    }

    @Bean
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(100);
        executor.setMaxPoolSize(25);
        executor.setQueueCapacity(2000);
        executor.initialize();
        return executor;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Content-Type", "accessToken")
                .exposedHeaders("Content-Type", "accessToken")
                .allowCredentials(true);
        super.addCorsMappings(registry);
    }
    
    

    //加入自定义参数拦截器
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        //argumentResolvers.add(new LoginTokenArgumentResolver());
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = 
    	{
    	 "classpath:/templates/",
    	 "classpath:/static/"
    	};
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations(
					"classpath:/META-INF/resources/webjars/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(
					CLASSPATH_RESOURCE_LOCATIONS);
		}
		super.addResourceHandlers(registry);
	}
    
    
    

}

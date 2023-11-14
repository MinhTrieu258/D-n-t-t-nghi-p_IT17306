package poly.dn.huyndai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import poly.dn.huyndai.Interceptor.Globallnterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    Globallnterceptor globallnterceptor;

    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
       registry.addInterceptor(globallnterceptor)
       .addPathPatterns("/**")
       .excludePathPatterns("/rest/**", "/admin**", "/assets/**");
    }
}

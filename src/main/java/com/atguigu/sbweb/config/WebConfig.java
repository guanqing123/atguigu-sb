package com.atguigu.sbweb.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson2.util.DateUtils;
import com.atguigu.sbweb.controller.bean.Pet;
import com.atguigu.sbweb.converter.GuiguMessageConverter;
import com.atguigu.sbweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/9 9:47
 **/
// @Import(DataSourceConfig.class)
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除；后面的内容。矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        // 阿猫,3
                        if (StringUtils.hasText(source)){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //需要定义一个convert转换消息的对象;
                FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
                //添加fastJson的配置信息;
                FastJsonConfig fastJsonConfig = new FastJsonConfig();
                fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
                fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
                //关闭循环引用
                fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
                //全局时间配置
                fastJsonConfig.setDateFormat("yyyy-MM-dd");
                fastJsonConfig.setCharset(Charset.forName("UTF-8"));
                //处理中文乱码问题
                List<MediaType> fastMediaTypes = new ArrayList<>();
                fastMediaTypes.add(MediaType.APPLICATION_JSON);
                //在convert中添加配置信息.
                fastConverter.setSupportedMediaTypes(fastMediaTypes);
                fastConverter.setFastJsonConfig(fastJsonConfig);
                converters.add(0, fastConverter);

                converters.add(new GuiguMessageConverter());
            }

            /**
             * 自定义内容协商策略
             * @Author guanqing
             * @Date 2023/4/16 0:08
             **/
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("guigu", MediaType.parseMediaType("application/x-guigu"));
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(mediaTypes);
                // strategy.setParameterName("ff");

                HeaderContentNegotiationStrategy header = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy, header));
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**");
            }
        };
    }

    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    //     UrlPathHelper urlPathHelper = new UrlPathHelper();
    //     // 不移除；后面的内容。矩阵变量功能就可以生效
    //     urlPathHelper.setRemoveSemicolonContent(false);
    //     configurer.setUrlPathHelper(urlPathHelper);
    // }
}

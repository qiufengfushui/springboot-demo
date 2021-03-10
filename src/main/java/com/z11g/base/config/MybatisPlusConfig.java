package com.z11g.base.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program：demo
 * @description：mybatis plus 配置类
 * @author：z11g
 * @create：2021-01-15
 **/
@Configuration
@MapperScan("com.z11g.base.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        return new PaginationInnerInterceptor();
    }
}

package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author junhao
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/219:32
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan("com.example.mybatisplus.mapper")
public class myBatisConfig {
    //注册乐观锁插件
    @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor(){
       MybatisPlusInterceptor mybatisPlusInterceptor  = new MybatisPlusInterceptor();
       mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
       return  mybatisPlusInterceptor;
    }
    //配置分页查询插件
    @Bean
        public  MybatisPlusInterceptor mybatisPlusInterceptor1(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return  mybatisPlusInterceptor;
    }
}

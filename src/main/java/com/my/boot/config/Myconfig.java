package com.my.boot.config;

import com.my.boot.bean.Car;
import com.my.boot.bean.Pet;
import com.my.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法，默认为true
 *      proxyBeanMethods = true Full模式【保证每个@Bean方法被调用多少次返回的组件都是单实例的，即在容器内部单例】
 *      proxyBeanMethods = false  Lite模式【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 */
//@Configuration(proxyBeanMethods = false)
@Configuration
@EnableConfigurationProperties(Car.class)
public class Myconfig {

    @Bean
    public User user01() {
        User zhangsan = new User("zhangsan", 11);
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcat() {
        return new Pet("tomcat");
    }
}

package com.my.boot;

import com.my.boot.bean.Pet;
import com.my.boot.bean.User;
import com.my.boot.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/*
 * @EnableAutoConfiguration原型：
 *   @AutoConfigurationPackage
 *   @Import(AutoConfigurationImportSelector.class)
 *   public @interface EnableAutoConfiguration {}
 * @AutoConfigurationPackage：
 *   将指定的一个包下的所有组件导入进来，放在main上即导入main所在的包下的所有组件
 * @Import(AutoConfigurationImportSelector.class)：
 *   1、利用getAutoConfigurationEntry(annotationMetadata);给容器中批量导入一些组件
 *   2、调用List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes)
 *     获取到所有需要导入到容器中的配置类
 *   3、利用工厂加载 Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader)得到所有的组件
 *   4、从META-INF/spring.factories位置来加载一个文件
 *     默认扫描我们当前系统里面所有META-INF/spring.factories位置的文件
 *     spring-boot-autoconfigure-2.3.4.RELEASE.jar包里面也有META-INF/spring.factories
 */
@SpringBootApplication  // 是以下三个注解的合成
//@SpringBootConfiguration  // @Configuration：代表当前是一个配置类
//@ComponentScan("com.my.boot")  // 指定扫描位置
//@EnableAutoConfiguration  // 详见上方笔记
public class MainApp {
    public static void main(String[] args) {
//        SpringApplication.run(MainApp.class, args);
        // 1、返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApp.class, args);

        // 2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        // 3、从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);

        Pet tom02 = run.getBean("tom", Pet.class);

//        System.out.println("组件单例：" + (tom01 == tom02));

        // 4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        Myconfig bean = run.getBean(Myconfig.class);
//        System.out.println(bean);

        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        // 保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
//        System.out.println(user == user1);

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

    }

}

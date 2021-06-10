# Java SpringBoot HelloWorld Demo

**只有在容器中的组件，才会拥有SpringBoot提供的强大功能**

## @EnableAutoConfiguration 原型

* @AutoConfigurationPackage

* @Import(AutoConfigurationImportSelector.class)

* public @interface EnableAutoConfiguration {}

##  @AutoConfigurationPackage

将指定的一个包下的所有组件导入进来，放在main上即导入main所在的包下的所有组件

##  @Import(AutoConfigurationImportSelector.class)

1. 利用getAutoConfigurationEntry(annotationMetadata);给容器中批量导入一些组件
2. 调用List\<String\> configurations = getCandidateConfigurations(annotationMetadata, attributes) 获取到所有需要导入到容器中的配置类
3. 利用工厂加载 Map\<String, List\<String\>\> loadSpringFactories(@Nullable ClassLoader classLoader)得到所有的组件
4. 从META-INF/spring.factories位置来加载一个文件，默认扫描我们当前系统里面所有META-INF/spring.factories位置的文件，spring-boot-autoconfigure-2.3.4.RELEASE.jar包里面也有META-INF/spring.factories

## @SpringBootApplication 原型

- @SpringBootConfiguration：@Configuration：代表当前是一个配置类

- @ComponentScan("com.my.boot")：指定扫描位置

- @EnableAutoConfiguration：详见上方笔记

## @Configuration

1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的

2. 配置类本身也是组件

3. proxyBeanMethods：代理bean的方法，默认为true

   proxyBeanMethods = true Full模式【保证每个@Bean方法被调用多少次返回的组件都是单实例的，即在容器内部单例】

   proxyBeanMethods = false Lite模式【每个@Bean方法被调用多少次返回的组件都是新创建的】

   组件依赖必须使用Full模式默认。其他默认是否Lite模式

## @Component

将该组件加入容器中

## @Data

自动生成getter、setter、toString、hashCode和equals方法，需先设置lombok插件

## @ToString

自动生成toString方法

## @AllArgsConstructor

自动生成有参构造器，使用所有参数构造

## @NoArgsConstructor

自动生成无参构造器

## @Slf4j

日志记录，log.xxx

## @RestController 原型

- @Controller

- @ResponseBody

## @Autowired

自动注入组件，但现在更推荐的写法是使用**final**字段

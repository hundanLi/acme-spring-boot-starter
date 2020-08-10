自定义starter

通常一个starter包含以下两个部分：

1. autoconfigure 模块：包含自动配置代码
2. starter模块：为autoconfigure模块提供依赖，以及其他有用的依赖库

当功能比较简单时，可以合二为一。

1.创建Maven工程

命名为 acme-sprint-boot-starter。

2.导入相关依赖

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.2.9.RELEASE</version>
            <relativePath/> <!-- lookup parent from repository -->
        </parent>
        <groupId>com.tcl</groupId>
        <artifactId>acme-spring-boot-starter</artifactId>
        <version>0.0.1</version>
        <name>acme-sprint-boot-starter</name>
        <description>Demo Starter</description>
    
        <properties>
            <java.version>1.8</java.version>
        </properties>
    
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
    
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-autoconfigure</artifactId>
            </dependency>
    
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-autoconfigure-processor</artifactId>
                <optional>true</optional>
            </dependency>
    
        </dependencies>
    
    
    </project>
    

3.编写自动配置类

1. Properties属性类
       @ConfigurationProperties(prefix = "acme")
       public class AcmeProperties {
       
           private String name;
           private boolean enable;
       
           public String getName() {
               return name;
           }
       
           public void setName(String name) {
               this.name = name;
           }
       
           public boolean isEnable() {
               return enable;
           }
       
           public void setEnable(boolean enable) {
               this.enable = enable;
           }
       }
       
   
2. 自动配置类
       @Configuration
       @EnableConfigurationProperties(value = AcmeProperties.class)
       public class AcmeAutoConfiguration {
       
           final
           AcmeProperties properties;
       
           public AcmeAutoConfiguration(AcmeProperties properties) {
               this.properties = properties;
           }
       
           @Bean
           @ConditionalOnMissingBean
           public Acme acme() {
               Acme acme = new Acme();
       
               acme.setName(properties.getName());
               acme.setEnable(properties.isEnable());
               return acme;
           }
       }
   
3. 功能实体类
       public class Acme {
           private String name;
           private boolean enable;
       
           public String getName() {
               return name;
           }
       
           public void setName(String name) {
               this.name = name;
           }
       
           public boolean isEnable() {
               return enable;
           }
       
           public void setEnable(boolean enable) {
               this.enable = enable;
           }
       }

4.创建spring.factories

    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.tcl.acme.spring.boot.autoconfigure.AcmeAutoConfiguration

5.打包安装

    $ mvn clean install

执行该命令后，jar将被安装到本地Maven仓库中，其他项目可以通过以下方式引用：

            <dependency>
                <groupId>com.tcl</groupId>
                <artifactId>acme-spring-boot-starter</artifactId>
                <version>0.0.1</version>
            </dependency>





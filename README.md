# 0.说明
这是本人的一些简单demo的整合，做一下记录，方便之后的复用。用的是 SpringBoot3.x，这个 MD 主要使用来记录下遇到的未解决的问题。
基础环境如下：

```java
SpringBoot 3.0.2
Red Hat OpenJdk17
```
## 0.1.Common模块
common模块主要是用来保存些基本信息和logback的公共配置，这样，其他模块需要使用的时候，只需要引入依赖即可
```java
        <dependency>
            <groupId>com.lwh.learn</groupId>
            <artifactId>common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```
# 1.MyBatis-Plus
依赖版本:
```java
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>3.5.3.1</version>
            </dependency>
```
配置：
```properties
spring.datasource.url=jdbc:postgresql://127.0.0.1:49156/postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=postgrespw
```
启动后发现报错信息如下

![image-20230219125537002](C:\Users\85303\AppData\Roaming\Typora\typora-user-images\image-20230219125537002.png)

查看具体的包之后发现确实是没有这个类，但是从打印出来的不知道具体是哪里在加载这个类，去 issue 里面查找也没有找到原因。暂时使用 MyBatis 吧，反正 Plus 我也只使用 BaseMapper。
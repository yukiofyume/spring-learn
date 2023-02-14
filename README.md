# 1.项目基础骨架创建
## 1.1.Common模块
common模块主要是用来保存些基本信息和logback的公共配置，这样，其他模块需要使用的时候，只需要引入依赖即可
```java
        <dependency>
            <groupId>com.lwh.learn</groupId>
            <artifactId>common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```
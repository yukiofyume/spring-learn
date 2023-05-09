package com.lwh.learn.annotation;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 11:56:11
 * @describe --
 */
@ClassAnnotation(name = "personBean", version = "1.2.1")
public class Person {

    @FieldAnnotation(name = "description", value = "this is my personal annotation")
    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @MethodAnnotation(name = "sayHello", type = MethodTypeEnum.TYPE2)
    public void sayHello() {
        System.out.println("Hello Annotation");
    }
}

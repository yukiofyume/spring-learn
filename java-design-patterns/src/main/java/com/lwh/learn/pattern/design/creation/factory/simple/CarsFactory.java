package com.lwh.learn.pattern.design.creation.factory.simple;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:36:15
 * @describe --
 */
public class CarsFactory {

    public static Car getCar(CarType type) {
        return type.getConstructor().get();
    }
}

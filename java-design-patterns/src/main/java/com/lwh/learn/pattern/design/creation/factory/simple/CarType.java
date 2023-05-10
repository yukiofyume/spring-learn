package com.lwh.learn.pattern.design.creation.factory.simple;

import java.util.function.Supplier;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:33:57
 * @describe --
 */
public enum CarType {

    FORD(Ford::new),
    FERRARI(Ferrari::new),
    ;

    private final Supplier<Car> constructor;

    CarType(Supplier<Car> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Car> getConstructor() {
        return constructor;
    }
}

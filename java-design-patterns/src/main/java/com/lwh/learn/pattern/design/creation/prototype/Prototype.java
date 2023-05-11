package com.lwh.learn.pattern.design.creation.prototype;

import lombok.SneakyThrows;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:11:18
 * @describe --
 */
public abstract class Prototype<T> implements Cloneable {

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public T copy() {
        return (T) super.clone();
    }
}

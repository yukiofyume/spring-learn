package com.lwh.learn.pattern.design.creation.builder;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:13:33
 * @describe --
 */
public enum HairColor {

    WHITE,
    BLOND,
    RED,
    BROWN,
    BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
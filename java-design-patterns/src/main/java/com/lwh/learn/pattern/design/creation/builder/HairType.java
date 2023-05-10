package com.lwh.learn.pattern.design.creation.builder;

import lombok.AllArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:13:50
 * @describe --
 */
@AllArgsConstructor
public enum HairType {

    BALD("bald"),
    SHORT("short"),
    CURLY("curly"),
    LONG_STRAIGHT("long straight"),
    LONG_CURLY("long curly");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}

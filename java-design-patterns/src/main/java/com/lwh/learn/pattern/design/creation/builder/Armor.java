package com.lwh.learn.pattern.design.creation.builder;

import lombok.AllArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:13:18
 * @describe --
 */
@AllArgsConstructor
public enum Armor {

    CLOTHES("clothes"),
    LEATHER("leather"),
    CHAIN_MAIL("chain mail"),
    PLATE_MAIL("plate mail");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}

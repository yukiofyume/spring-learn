package com.lwh.learn.pattern.design.creation.factory.method;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:51:23
 * @describe --
 */
public enum WeaponType {
    SHORT_SWORD("short sword"),
    SPEAR("spear"),
    AXE("axe"),
    UNDEFINED(""),
    ;

    private final String title;

    WeaponType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

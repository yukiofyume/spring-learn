package com.lwh.learn.pattern.design.creation.builder;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:11:36
 * @describe --
 */
public enum Profession {

    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

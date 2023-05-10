package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Army;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:29:20
 * @describe --
 */
public class ElfArmy implements Army {
    @Override
    public String getDescription() {
        return "This is the Elven army";
    }
}

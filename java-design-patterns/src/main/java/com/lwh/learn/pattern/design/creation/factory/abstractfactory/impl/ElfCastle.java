package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Castle;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:28:16
 * @describe --
 */
public class ElfCastle implements Castle {
    @Override
    public String getDescription() {
        return "This is the Elven castle!";
    }
}

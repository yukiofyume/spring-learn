package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.King;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:28:49
 * @describe --
 */
public class ElfKing implements King {
    @Override
    public String getDescription() {
        return "This is the Elven king!";
    }
}

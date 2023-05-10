package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Army;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:38:47
 * @describe --
 */
public class OrcishArmy implements Army {
    @Override
    public String getDescription() {
        return "This is the orcish army";
    }
}

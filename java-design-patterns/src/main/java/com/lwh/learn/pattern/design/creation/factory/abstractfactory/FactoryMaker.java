package com.lwh.learn.pattern.design.creation.factory.abstractfactory;

import com.lwh.learn.pattern.design.creation.factory.KingdomType;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.ElfKingdomFactory;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.KingdomFactory;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.OrcKingdomFactory;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:49:23
 * @describe --
 */
public class FactoryMaker {

    public static KingdomFactory makeKingdomFactory(KingdomType kingdomType) {
        return kingdomType.getKingdomFactory().get();
    }
}

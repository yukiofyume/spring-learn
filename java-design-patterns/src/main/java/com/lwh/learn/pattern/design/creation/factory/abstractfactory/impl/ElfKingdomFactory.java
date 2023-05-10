package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Army;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Castle;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.King;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:43:13
 * @describe --
 */
public class ElfKingdomFactory implements KingdomFactory{
    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}

package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Army;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Castle;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.King;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:46:24
 * @describe --
 */
public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new OrcishCastle();
    }

    @Override
    public King createKing() {
        return new OrcishKing();
    }

    @Override
    public Army createArmy() {
        return new OrcishArmy();
    }
}

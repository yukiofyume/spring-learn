package com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Army;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.Castle;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.King;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:42:19
 * @describe --
 */
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();
}

package com.lwh.learn.pattern.design.creation.factory;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.ElfKingdomFactory;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.KingdomFactory;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.OrcKingdomFactory;

import java.util.function.Supplier;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:52:12
 * @describe --
 */
public enum KingdomType {
    ELF(ElfKingdomFactory::new),
    ORC(OrcKingdomFactory::new),
    ;

    private final Supplier<KingdomFactory> kingdomFactory;

    KingdomType(Supplier<KingdomFactory> kingdomFactory) {
        this.kingdomFactory = kingdomFactory;
    }

    public Supplier<KingdomFactory> getKingdomFactory() {
        return kingdomFactory;
    }
}

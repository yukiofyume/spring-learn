package com.lwh.learn.pattern.design.creation.factory;

import com.lwh.learn.pattern.design.creation.factory.abstractfactory.FactoryMaker;
import com.lwh.learn.pattern.design.creation.factory.abstractfactory.impl.KingdomFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:54:14
 * @describe --
 */
@Slf4j
class KingdomTypeTest {

    @Test
    void kingdomTypeTest() {
        var elfKingdomFactory = FactoryMaker.makeKingdomFactory(KingdomType.ELF);
        log.info(elfKingdomFactory.createArmy().getDescription());
        log.info(elfKingdomFactory.createKing().getDescription());
        log.info(elfKingdomFactory.createCastle().getDescription());
    }
}
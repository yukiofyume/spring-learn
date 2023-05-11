package com.lwh.learn.pattern.design.creation.prototype;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:52:37
 * @describe --
 */
@Slf4j
class PrototypeAppTest {

    @Test
    void heroFactoryTest() {
        var factory = new HeroFactoryImpl(new ElfMage("cooking"), new ElfWarlord("cleaning"), new ElfBeast("protecting"));
        var mege = factory.createMage();
        var warlord = factory.createWarlord();
        var beast = factory.createBeast();
        log.info(mege.toString());
        log.info(warlord.toString());
        log.info(beast.toString());
    }
}
package com.lwh.learn.pattern.design.creation.builder;

import com.lwh.learn.pattern.design.creation.factory.method.Weapon;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:19:05
 * @describe --
 */
@Slf4j
class AppTest {

    @Test
    void builderTest() {
        var mege = new Hero.Builder()
                .withHairColor(HairColor.BLACK)
                .build();
        log.info(mege.getHairColor().toString());
    }

    @Test
    void lombokBuilder() {
        var hero = HeroLombok.builder()
                .hairColor(HairColor.BLOND)
                .name("hwl")
                .build();
        log.info(hero.getName());
        log.info(hero.getHairColor().toString());
    }
}
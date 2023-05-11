package com.lwh.learn.pattern.design.creation.prototype;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:42:30
 * @describe --
 */
public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}

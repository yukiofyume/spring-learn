package com.lwh.learn.pattern.design.creation.factory.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 17:01:15
 * @describe --
 */
@Slf4j
class MethodFactoryTest {

    @Test
    void  blacksmithTest() {
        var blacksmith = new ElfBlacksmith();
        log.info(blacksmith.manufactureWeapon(WeaponType.SPEAR).getWeaponType().toString());
        log.info(blacksmith.manufactureWeapon(WeaponType.AXE).getWeaponType().toString());
    }
}
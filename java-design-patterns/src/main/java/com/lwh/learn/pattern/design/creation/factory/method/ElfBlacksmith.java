package com.lwh.learn.pattern.design.creation.factory.method;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:53:20
 * @describe 铁匠接口的实现类
 */
public class ElfBlacksmith implements Blacksmith {

    private static final Map<WeaponType, ElfWeapon> ELFARSENAL;

    static {
        ELFARSENAL = new EnumMap<>(WeaponType.class);
        Arrays.stream(WeaponType.values()).forEach(type -> ELFARSENAL.put(type, new ElfWeapon(type)));
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ELFARSENAL.get(weaponType);
    }

    @Override
    public String toString() {
        return "The elf blacksmith";
    }
}

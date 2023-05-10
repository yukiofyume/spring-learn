package com.lwh.learn.pattern.design.creation.factory.method;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:57:51
 * @describe 铁匠接口的实现类
 */
public class OrcBlacksmith implements Blacksmith {

    private static final Map<WeaponType, OrcWeapon> ORCARSENAL;

    static {
        ORCARSENAL = new EnumMap<>(WeaponType.class);
        Arrays.stream(WeaponType.values()).forEach(type -> ORCARSENAL.put(type, new OrcWeapon(type)));
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ORCARSENAL.get(weaponType);
    }

    @Override
    public String toString() {
        return "The orc blacksmith";
    }
}

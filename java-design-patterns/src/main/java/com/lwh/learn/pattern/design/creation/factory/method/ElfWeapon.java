package com.lwh.learn.pattern.design.creation.factory.method;

import lombok.Data;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:54:37
 * @describe --
 */
@Data
public class ElfWeapon implements Weapon{

    private final WeaponType weaponType;

    public String toString() {
        return "an elven " + weaponType;
    }
}

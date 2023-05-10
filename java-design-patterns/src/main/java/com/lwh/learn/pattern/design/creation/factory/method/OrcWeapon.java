package com.lwh.learn.pattern.design.creation.factory.method;

import lombok.Data;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:58:12
 * @describe --
 */
@Data
public class OrcWeapon implements Weapon {

    private final WeaponType weaponType;

    @Override
    public String toString() {
        return "an orcish " + weaponType;
    }
}

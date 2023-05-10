package com.lwh.learn.pattern.design.creation.factory.method;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:48:58
 * @describe 铁匠的接口
 */
public interface Blacksmith {

    Weapon manufactureWeapon(WeaponType weaponType);
}

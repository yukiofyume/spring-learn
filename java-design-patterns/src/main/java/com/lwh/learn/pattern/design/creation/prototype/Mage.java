package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:43:11
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class Mage extends Prototype<Mage> {

    public Mage(Mage source){}
}

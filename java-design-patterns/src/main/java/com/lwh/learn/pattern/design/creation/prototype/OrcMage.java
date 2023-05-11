package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 11:16:26
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcMage extends Mage {

    private final String weapon;

    public OrcMage(OrcMage orcMage) {
        super(orcMage);
        this.weapon = orcMage.weapon;
    }

    @Override
    public String toString() {
        return "Orcish mage attacks with " + weapon;
    }
}

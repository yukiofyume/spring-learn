package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 11:18:30
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcWarlord extends Warlord {

    private final String weapon;

    public OrcWarlord(OrcWarlord orcWarlord) {
        super(orcWarlord);
        this.weapon = orcWarlord.weapon;
    }

    @Override
    public String toString() {
        return "Orcish warlord attacks with " + weapon;
    }
}

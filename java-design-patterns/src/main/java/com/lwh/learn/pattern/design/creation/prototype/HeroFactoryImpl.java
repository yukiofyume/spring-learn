package com.lwh.learn.pattern.design.creation.prototype;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:46:02
 * @describe --
 */
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class HeroFactoryImpl implements HeroFactory{

    private final Mage mage;
    private final Warlord warlord;
    private final Beast beast;

    @Override
    public Mage createMage() {
        return mage.copy();
    }

    @Override
    public Warlord createWarlord() {
        return warlord.copy();
    }

    @Override
    public Beast createBeast() {
        return beast.copy();
    }
}

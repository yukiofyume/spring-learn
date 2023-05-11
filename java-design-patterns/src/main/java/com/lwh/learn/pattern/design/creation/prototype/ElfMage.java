package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:55:42
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ElfMage extends Mage {

    private final String helpType;

    public ElfMage(ElfMage elfMage) {
        super(elfMage);
        this.helpType = elfMage.helpType;
    }

    @Override
    public String toString() {
        return "Elven mage helps in " + helpType;
    }
}

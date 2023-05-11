package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 11:14:04
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ElfWarlord extends Warlord {

    private final String helpType;

    public ElfWarlord(ElfWarlord elfWarlord) {
        super(elfWarlord);
        this.helpType = elfWarlord.helpType;
    }

    @Override
    public String toString() {
        return "Elven warlord helps in " + helpType;
    }
}

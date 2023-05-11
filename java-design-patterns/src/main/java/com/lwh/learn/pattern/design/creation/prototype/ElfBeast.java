package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author lwha
 * @version 1.0
 * @date 2023-05-11 10:57:35
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ElfBeast extends Beast {

    private final String helpType;

    public ElfBeast(ElfBeast elfBeast) {
        super(elfBeast);
        this.helpType = elfBeast.helpType;
    }

    @Override
    public String toString() {
        return "Elven eagle helps in " + helpType;
    }
}

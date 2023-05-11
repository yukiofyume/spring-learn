package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:20:17
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class OrcBeast extends Beast {

    private final String weapon;

    public OrcBeast(OrcBeast orcBeast) {
        super(orcBeast);
        this.weapon = orcBeast.weapon;
    }

    @Override
    public String toString() {
        return "Orcish wolf attacks with " + weapon;
    }
}

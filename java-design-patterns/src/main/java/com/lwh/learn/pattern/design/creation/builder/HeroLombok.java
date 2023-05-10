package com.lwh.learn.pattern.design.creation.builder;

import com.lwh.learn.pattern.design.creation.factory.method.Weapon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 18:25:24
 * @describe --
 */
@Data
@Builder
public class HeroLombok {
    private final Profession profession;
    private final String name;
    private final HairType hairType;
    private final HairColor hairColor;
    private final Armor armor;
    private final Weapon weapon;
}

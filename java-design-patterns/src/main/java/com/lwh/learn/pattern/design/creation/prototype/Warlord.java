package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:44:26
 * @describe --
 */
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Warlord extends Prototype<Warlord>{

    public Warlord(Warlord source){}
}

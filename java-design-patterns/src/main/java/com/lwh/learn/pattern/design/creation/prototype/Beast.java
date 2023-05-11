package com.lwh.learn.pattern.design.creation.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 10:14:05
 * @describe --
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class Beast extends Prototype<Beast>{

    public Beast(Beast source) {
    }
}

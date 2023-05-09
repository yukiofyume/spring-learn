package com.lwh.learn.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 14:22:26
 * @describe --
 */
@Slf4j
public class TestGuava {

    @Test
    void JoinerTest() {
        StringBuilder stringBuilder = new StringBuilder("hello");
        Joiner joiner = Joiner.on("|").skipNulls();
        stringBuilder = joiner.appendTo(stringBuilder, "foo", "bar", null, "baz");
        log.info(stringBuilder.toString());
    }
}

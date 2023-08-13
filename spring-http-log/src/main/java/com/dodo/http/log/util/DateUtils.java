package com.dodo.http.log.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author lwh
 * @date 2023-08-13 18:52:35
 * @describe --
 */
public class DateUtils {

    public static final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static String toString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    public static long currentTimestamp() {
        return toTimestamp(LocalDateTime.now());
    }

    public static long toTimestamp(LocalDateTime localDateTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        return localDateTime.toInstant(zoneOffset).toEpochMilli();
    }
}

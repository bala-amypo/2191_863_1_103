package com.example.demo.util;

import java.time.LocalTime;

public class TimeUtils {
    public static boolean isAfter(LocalTime start, LocalTime end) {
        return end.isAfter(start);
    }
}

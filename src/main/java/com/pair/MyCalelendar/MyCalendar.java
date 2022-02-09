package com.pair.MyCalelendar;

import java.time.LocalDateTime;

public class MyCalendar {

    public static LocalDateTime now() {
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), now.getMinute(),now.getSecond());
    }

}

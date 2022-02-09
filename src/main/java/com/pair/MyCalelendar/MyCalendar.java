package com.pair.MyCalelendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class MyCalendar {

    public static LocalDateTime now() {
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getHour(), now.getMinute(), now.getSecond());
    }

    public static LocalDate of(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(str, formatter);
    }

    public static LocalDate of(int year, int month, int date) {
        return LocalDate.of(year, month, date);
    }

    public static String formatToKorean(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        return localDate.format(formatter);
    }

    public static DayOfWeek getFirstDayOfWeek(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        return firstDayOfMonth.getDayOfWeek();
    }

    public static LocalDate[][] getMonthCalender(int year, int month) {
        LocalDate[][] result = new LocalDate[5][7];
        int monthLength = LocalDate.of(year, month, 1).lengthOfMonth();
        int week = 1;
        for (int j = 1; j <= monthLength; j++) {
            LocalDate date = LocalDate.of(year, month, j);
            int dayOfWeek = date.getDayOfWeek().getValue();
            result[week - 1][dayOfWeek - 1] = date;
            if (dayOfWeek==7) {
                week++;
            }
        }
        return result;
    }
}

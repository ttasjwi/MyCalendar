package com.pair.MyCalelendar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class MyCalendarTest {

    @Test
    @DisplayName("now Test")
    void now() {
        //given
        LocalDateTime now = MyCalendar.now();
        System.out.println(now);
    }

    @Test
    @DisplayName("년월일 날짜만 문자열로 입력하면 Date 인스턴스를 리턴한다.")
    void of() {
        //given
        String str = "2022-02-09";
        LocalDate date = MyCalendar.of(str);

        //when
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(year).isEqualTo(2022);
        softAssertions.assertThat(month).isEqualTo(2);
        softAssertions.assertThat(dayOfMonth).isEqualTo(9);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("년월일 숫자값 입력 Date 인스턴스를 리턴한다.")
    void of2() {
        //given
        LocalDate date = MyCalendar.of(2022, 01, 17);
        //when
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(year).isEqualTo(2022);
        softAssertions.assertThat(month).isEqualTo(1);
        softAssertions.assertThat(dayOfMonth).isEqualTo(17);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("문자열 반환")
    void name() {
        //given
        LocalDate localDate = MyCalendar.of(2022,07,18);

        //when
        String result = MyCalendar.formatToKorean(localDate);

        //then
        assertThat(result).isEqualTo("2022년 07월 18일");
    }

    @Test
    @DisplayName("해당 년월의 1일의 요일을 리턴한다.")
    void getFirstDayOfWeek() {
        //given
        DayOfWeek firstDayOfWeek = MyCalendar.getFirstDayOfWeek(2022, 2);

        //when
        DayOfWeek expect = DayOfWeek.TUESDAY;

        //then
        assertThat(firstDayOfWeek).isEqualTo(expect);
    }

    @Test
    @DisplayName("getMonthCalendar - 해당 월의 최대 일수만큼 LocalDate들이 존재해야한다.")
    void getMonthCalender() {

        //given
        int year = 2022;
        int month = 2;

        int expectLengthOfMonth = MyCalendar.of(year, month, 1).lengthOfMonth();

        LocalDate[][] monthCalender = MyCalendar.getMonthCalender(year, month);

        int actualLengthOfMonth = 0;

        for (int i=0; i<monthCalender.length; i++) {
            for (int j=0; j<monthCalender[i].length; j++) {
                if (monthCalender[i][j] != null) {
                    actualLengthOfMonth ++;
                }
            }
        }

        //then
        assertThat(actualLengthOfMonth).isEqualTo(expectLengthOfMonth);
    }
}

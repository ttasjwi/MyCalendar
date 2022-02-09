package com.pair.MyCalelendar;

import java.time.LocalDate;
import net.bytebuddy.asm.Advice;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
}

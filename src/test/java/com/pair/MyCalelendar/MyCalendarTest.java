package com.pair.MyCalelendar;

import net.bytebuddy.asm.Advice;
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
}
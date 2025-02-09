package com.lime.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimeStringUtilsTest {

    @Test
    @DisplayName("LimeStringUtils.isEmpty 호출시 빈값제공시 true를 반환한다.")
    void isEmpty() {
        Boolean actual = LimeStringUtils.isEmpty("");

        assertTrue(actual);
    }

    @Test
    @DisplayName("빈값 제공시 defaultString 을 반환한다.")
    void emptyToDefault() {
        String defaultString = "hello world";
        final String EMPTY_STRING = "";
        String actual = LimeStringUtils.emptyToDefault(EMPTY_STRING, defaultString);

        assertEquals(defaultString, actual);
    }

}
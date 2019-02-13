package com.android.biathlonapp.util;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DateHelperTest {

    private String input;
    private Date expected;
    private String datePattern;

    @Before
    public void setUp() {
        datePattern = "yyyy.MM.dd G 'at' HH:mm:ss z";
        expected = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        input = dateFormatter.format(expected);
    }

    @Test
    public void parseDate_string_string_success() {
        Date actual = DateHelper.parseDate(input, datePattern);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void parseDate_string_string_fail() {
        assertNotEquals(expected, null);
    }

    @Test
    public void formatDate_date_string_success() {
        String actual = DateHelper.formatDate(expected, datePattern);
        String expected = input;
        assertEquals(expected, actual);
    }

    @Test
    public void formatDate_date_string_fail() {
        String actual = DateHelper.formatDate(expected, datePattern);
        String expected = "dummy";
        assertNotEquals(expected, actual);
    }
}
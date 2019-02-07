package com.android.biathlonapp.util.parser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringParserTest {

    private List<String> input;
    private List<List<String>> expected;
    private StringParser stringParser;

    @Before
    public void setUp() {
        // Prepare data
        String[] firstRow = {"2016.02.09 AD at 12:08:56 MSK", "17,5", "Men's sprint", "Male", "Sprint"};
        String[] secondRow = {"2018.02.09 AD at 12:08:56 MSK", "12,5", "Women's sprint", "Female", "Sprint"};
        List<String> firstList = Arrays.asList(firstRow);
        List<String> secondList = Arrays.asList(secondRow);
        // Create input list
        input = new ArrayList<>();
        input.add(String.join("|", firstList));
        input.add(String.join("|", secondList));
        // Create expected list
        expected = new ArrayList<>();
        expected.add(firstList);
        expected.add(secondList);
        // Create string parser
        stringParser = new StringParser(input, "\\|");
    }

    @Test
    public void parse_void_success() {
        List<List<String>> actual = stringParser.parse();
        assertEquals(expected, actual);
    }

    @Test
    public void parse_void_fail() {
        List<List<String>> actual = stringParser.parse();
        assertNotEquals(expected, null);
    }

    @Test
    public void parseString_string_success() {
        List<String> actual = stringParser.parseString(input.get(0));
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void parseString_string_fail() {
        List<String> actual = stringParser.parseString(input.get(1));
        assertNotEquals(expected.get(0), actual);
    }
}
package com.android.biathlonapp.util.parser;

import com.android.biathlonapp.race.BiathlonRace;
import com.android.biathlonapp.race.Race;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BiathlonRaceParserTest {

    private List<List<String>> input;
    private List<Race> expected;
    private RaceParser raceParser;

    @Before
    public void setUp() {
        // Prepare data
        String[] firstRow = {"2016.02.09 AD at 12:08:56 MSK", "17.5", "Men's sprint", "Male", "Sprint"};
        String[] secondRow = {"2018.02.09 AD at 12:08:56 MSK", "12.5", "Women's sprint", "Female", "Sprint"};
        List<String> firstList = Arrays.asList(firstRow);
        List<String> secondList = Arrays.asList(secondRow);
        // Create input list
        input = new ArrayList<>();
        input.add(null);
        input.add(null);
        input.add(firstList);
        input.add(secondList);
        // Create expected list
        expected = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        Date firstDate = null;
        try {
            firstDate = dateFormat.parse("2016.02.09 AD at 12:08:56 MSK");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date secondDate = null;
        try {
            secondDate = dateFormat.parse("2018.02.09 AD at 12:08:56 MSK");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Race firstRace = new BiathlonRace(firstDate, 17.5, "Men's sprint", "Male", "Sprint");
        Race secondRace = new BiathlonRace(secondDate, 12.5, "Women's sprint", "Female", "Sprint");
        expected.add(firstRace);
        expected.add(secondRace);
        // Create string parser
        raceParser = new BiathlonRaceParser(input);
    }

    @Test
    public void parse_void_success() {
        List<Race> actual = raceParser.parse();
        assertEquals(expected, actual);
    }

    @Test
    public void parse_void_fail() {
        List<Race> actual = new ArrayList<>(expected);
        actual.remove(0);
        assertNotEquals(expected, actual);
    }

    @Test
    public void parseRace_list_string_success() {
        Race actual = raceParser.parseRace(input.get(0));
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void parseRace_list_string_fail() {
        Race actual = raceParser.parseRace(null);
        assertNotEquals(expected.get(0), actual);
    }
}
package com.android.biathlonapp.util.parser;

import android.util.Log;

import com.android.biathlonapp.race.Race;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RaceParser extends Parser<String, Race> {

    private static final String TAG = "RaceParser";

    public RaceParser() {
    }

    public RaceParser(List<String> inputList) {
        super(inputList);
    }

    @Override
    public List<Race> parse() {
        Parser<String, List<String>> stringParser = new StringParser(getInputList(), "|");
        List<List<String>> raceList = stringParser.parse();
        return raceList.stream().
                map(this::parseRace).
                collect(Collectors.toList());
    }

    private Race parseRace(List<String> raceData) {
        if (raceData == null || raceData.size() < 3) return null;
        return new Race(parseDate(raceData.get(0)),
                Double.parseDouble(raceData.get(1)),
                raceData.get(2));
    }

    public Date parseDate(String input) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        Date date = null;
        try {
            date = dateParser.parse(input);
        } catch (ParseException e) {
            Log.e(TAG, "Failed to parse date " + input, e);
        }
        return date;
    }

}

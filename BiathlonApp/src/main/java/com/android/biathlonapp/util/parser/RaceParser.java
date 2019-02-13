package com.android.biathlonapp.util.parser;

import com.android.biathlonapp.race.Race;
import com.android.biathlonapp.util.DateHelper;

import java.util.List;
import java.util.stream.Collectors;

public class RaceParser extends Parser<List<String>, Race> {

    private static final String TAG = "RaceParser";
    private static final String DEFAULT_DATE_PATTERN = "yyyy.MM.dd G 'at' HH:mm:ss z";
    private static final Race EMPTY_RACE = new Race();

    private String datePattern;

    public RaceParser() {
        super();
        this.datePattern = DEFAULT_DATE_PATTERN;
    }

    public RaceParser(List<List<String>> inputList) {
        super(inputList);
        this.datePattern = DEFAULT_DATE_PATTERN;
    }

    public RaceParser(List<List<String>> inputList, String datePattern) {
        super(inputList);
        this.datePattern = (datePattern != null) ? datePattern : DEFAULT_DATE_PATTERN;
    }

    public String getDatePattern() {
        return datePattern;
    }

    @Override
    public List<Race> parse() {
        return getInputList().stream().
                map(this::parseRace).
                collect(Collectors.toList());
    }

    public Race parseRace(List<String> raceData) {
        if (raceData == null || raceData.size() < 3) return EMPTY_RACE;
        return new Race(DateHelper.parseDate(raceData.get(0), datePattern),
                Double.parseDouble(raceData.get(1)),
                raceData.get(2));
    }

}

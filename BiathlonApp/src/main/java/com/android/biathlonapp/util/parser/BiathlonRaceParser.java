package com.android.biathlonapp.util.parser;

import com.android.biathlonapp.race.BiathlonRace;
import com.android.biathlonapp.race.Race;
import com.android.biathlonapp.util.DateHelper;

import java.util.List;
import java.util.stream.Collectors;

public class BiathlonRaceParser extends RaceParser {

    private static final Race BIATHLON_EMPTY_RACE = new BiathlonRace();

    public BiathlonRaceParser() {
    }

    public BiathlonRaceParser(List<List<String>> inputList) {
        super(inputList);
    }

    @Override
    public List<Race> parse() {
        return getInputList().stream()
                .map(this::parseBiathlonRace)
                .collect(Collectors.toList());
    }

    public Race parseBiathlonRace(List<String> raceData) {
        if (raceData == null || raceData.size() < 5) return BIATHLON_EMPTY_RACE;
        return new BiathlonRace(DateHelper.parseDate(raceData.get(0), getDatePattern()),
                Double.parseDouble(raceData.get(1)),
                raceData.get(2),
                raceData.get(3),
                raceData.get(4));
    }

}

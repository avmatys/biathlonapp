package com.android.biathlonapp.util.parser;

import com.android.biathlonapp.race.BiathlonRace;
import com.android.biathlonapp.race.Race;

import java.util.List;
import java.util.stream.Collectors;

public class BiathlonRaceParser extends RaceParser {

    public BiathlonRaceParser() {
    }

    public BiathlonRaceParser(List<String> inputList) {
        super(inputList);
    }

    @Override
    public List<Race> parse() {
        Parser<String, List<String>> stringParser = new StringParser(getInputList(), "|");
        List<List<String>> raceList = stringParser.parse();
        return raceList.stream()
                .map(this::parseBiathlonRace)
                .collect(Collectors.toList());
    }

    private Race parseBiathlonRace(List<String> raceData) {
        if (raceData == null || raceData.size() < 5) return null;
        return new BiathlonRace(parseDate(raceData.get(0)),
                Double.parseDouble(raceData.get(1)),
                raceData.get(2),
                raceData.get(3),
                raceData.get(4));
    }

}

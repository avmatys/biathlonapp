package com.android.biathlonapp.util.parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser extends Parser<String, List<String>> {

    private String delimiter;

    public StringParser() {
        this.delimiter = "\\s+";
    }

    public StringParser(List<String> inputList, String delimiter) {
        super(inputList);
        this.delimiter = delimiter;
    }

    @Override
    public List<List<String>> parse() {
        return getInputList().stream()
                .map(this::parseString)
                .collect(Collectors.toList());
    }

    private List<String> parseString(String input) {
        return Stream.of(input.split(delimiter))
                .map(String::new)
                .collect(Collectors.toList());
    }
}

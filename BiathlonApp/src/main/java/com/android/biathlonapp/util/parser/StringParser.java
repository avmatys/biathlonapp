package com.android.biathlonapp.util.parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser extends Parser<String, List<String>> {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_DELIMITER = "\\s+";

    private String delimiter;

    public StringParser() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public StringParser(String delimiter) {
        super();
        setDelimiter(delimiter);
    }

    public StringParser(List<String> inputList, String delimiter) {
        super(inputList);
        setDelimiter(delimiter);
    }

    private void setDelimiter(String delimiter) {
        this.delimiter = (delimiter != null) ? delimiter : DEFAULT_DELIMITER;
    }

    @Override
    public List<List<String>> parse() {
        return getInputList().stream()
                .map(this::parseString)
                .collect(Collectors.toList());
    }

    public List<String> parseString(String input) {
        input = (input != null) ? input : EMPTY_STRING;
        return Stream.of(input.split(delimiter))
                .map(String::new)
                .collect(Collectors.toList());
    }
}

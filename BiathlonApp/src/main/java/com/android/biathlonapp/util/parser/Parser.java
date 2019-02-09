package com.android.biathlonapp.util.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Parser<T, V> {

    private static final List EMPTY_LIST = new ArrayList<>();

    private List<T> inputList;

    public Parser() {
        inputList = new ArrayList<>();
    }

    public Parser(List<T> inputList) {
        setInputList(inputList);
    }

    public List<T> getInputList() {
        return inputList;
    }

    private void setInputList(List<T> inputList) {
        this.inputList = (inputList != null) ? inputList : EMPTY_LIST;
        Objects.requireNonNull(inputList).removeIf(Objects::isNull);
    }

    public abstract List<V> parse();
}

package com.android.biathlonapp.util.parser;

import java.util.List;

public abstract class Parser<T, V> {

    private List<T> inputList;

    public Parser() {
    }

    public Parser(List<T> inputList) {
        this.inputList = inputList;
    }

    public List<T> getInputList() {
        return inputList;
    }

    public abstract List<V> parse();
}

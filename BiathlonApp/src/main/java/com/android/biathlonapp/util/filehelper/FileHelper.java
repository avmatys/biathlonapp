package com.android.biathlonapp.util.filehelper;

import android.util.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHelper {

    private static final String TAG = "FileHelper";

    public static List<String> readLines(Path path) {
        List<String> list = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            list = lines.collect(Collectors.toList());
        } catch (IOException e) {
            Log.e(TAG, "Failed to load file " + path, e);
        }
        return list;
    }

}

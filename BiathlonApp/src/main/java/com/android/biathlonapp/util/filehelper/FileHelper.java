package com.android.biathlonapp.util.filehelper;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHelper {

    private static final String TAG = "FileHelper";

    private Context context;
    private String path;
    private File file;

    public FileHelper(Context context, String path) {
        this.context = context;
        this.path = path;
    }

    public List<String> readLines(){
        if(file == null){
            openFile();
        }
        List<String> list = null;
        try (Stream<String> lines = Files.lines(file.toPath())) {
            list = lines.collect(Collectors.toList());
        } catch (IOException e) {
            Log.e(TAG, "Failed to load file " + path, e);
        }
        return list;
    }

    private void openFile(){
        file = new File(context.getDataDir(),path);
    }
}

package com.android.biathlonapp.activity;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.biathlonapp.R;
import com.android.biathlonapp.race.Race;
import com.android.biathlonapp.util.file.FileHelper;
import com.android.biathlonapp.util.parser.BiathlonRaceParser;
import com.android.biathlonapp.util.parser.Parser;
import com.android.biathlonapp.util.parser.StringParser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.biathlon_races);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Load data (test)
        ContextWrapper c = new ContextWrapper(this);
        File data = new File(c.getExternalFilesDir(null), "schedule.txt");
        Path path = Paths.get(data.toURI());
        List<String> fileData = FileHelper.readLines(path);
        Parser stringParser = new StringParser(fileData, "\\|");
        List<List<String>> racesData = stringParser.parse();
        Parser raceParser = new BiathlonRaceParser(racesData);
        List<Race> races = raceParser.parse();
        ///sdcard/Android/data/com.android.biathlonapp/files/schedule.txt

        // specify an adapter (see also next example)
        adapter = new MainAdapter(races);
        recyclerView.setAdapter(adapter);
    }
}

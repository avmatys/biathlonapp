package com.android.biathlonapp.util.file;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileHelperTest {

    private Path path;
    private List<String> expected;

    @Before
    public void setUp() throws Exception {
        path = Paths.get(this.getClass().getClassLoader().getResource("test.txt").toURI());
        String[] expectedData = {"2016.02.09 AD at 12:08:56 MSK|17.5|Мужской спринт|Male|Sprint",
                "2018.02.09 AD at 12:08:56 MSK|12.5|Женский спринт|Female|Sprint"};
        expected = Arrays.asList(expectedData);
    }

    @Test
    public void readLines_path_success() {
        List<String> actual = FileHelper.readLines(path);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readLines_path_fail() {
        List<String> actual = FileHelper.readLines(null);
    }
}
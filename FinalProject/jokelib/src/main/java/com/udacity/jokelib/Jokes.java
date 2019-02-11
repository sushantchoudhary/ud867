package com.udacity.jokelib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jokes {

    private static List<String>  jokes = new ArrayList<>();

    public String getJoke() throws IOException {

        InputStream resourceStream = this.getClass().getResourceAsStream("/jokes.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream, Charset.defaultCharset()));
        String line;

        while ((line = reader.readLine()) != null) {
            jokes.add(line);
        }
        reader.close();

        int idx = new Random().nextInt(jokes.size());
        return jokes.get(idx);

    }
}



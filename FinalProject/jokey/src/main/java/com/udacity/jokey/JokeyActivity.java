package com.udacity.jokey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeyActivity extends AppCompatActivity {

    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokey);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.joke_fragment_container,
                    JokeyFragment.newInstance(joke)).commit();
        }
    }
}

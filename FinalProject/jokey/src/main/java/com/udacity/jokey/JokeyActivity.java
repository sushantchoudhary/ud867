package com.udacity.jokey;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokeyActivity extends AppCompatActivity implements JokeyFragment.OnFragmentInteractionListener
{
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

        @Override
        public void onFragmentInteraction(Uri uri) {

        }

}


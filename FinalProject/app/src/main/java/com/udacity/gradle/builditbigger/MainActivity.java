package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.service.JokeService;
import com.udacity.gradle.builditbigger.util.JokeIdlingResource;


public class MainActivity extends AppCompatActivity {

    @Nullable
    private JokeIdlingResource jokeIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void launchJokeActivity(View view) {
        new JokeService().execute(this);
    }


    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (jokeIdlingResource == null) {
            jokeIdlingResource = new JokeIdlingResource();
        }
        return jokeIdlingResource;
    }
}

package com.udacity.gradle.builditbigger.service;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.jokey.JokeyActivity;

import java.io.IOException;

public class JokeService extends AsyncTask<Context, Void, Pair<Context, String>> {

    private static  MyApi  jokeService = null;

    @Override
    protected Pair<Context, String> doInBackground(Context... contexts) {
        if(jokeService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeService = builder.build();
        }

        Context context = contexts[0];

        try {
            return new Pair<>(context, jokeService.sayHi().execute().getData());
        } catch (IOException e) {
            return new Pair<>(context, e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(Pair<Context, String> pair) {
        Intent intent = new Intent(pair.first, JokeyActivity.class);
        intent.putExtra(JokeyActivity.JOKE_KEY, pair.second);
        pair.first.startActivity(intent);
    }
}

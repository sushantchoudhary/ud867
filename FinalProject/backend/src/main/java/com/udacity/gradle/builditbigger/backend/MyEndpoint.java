package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.jokelib.Jokes;

import java.io.IOException;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() throws IOException {
        Jokes jokes = new Jokes();

        MyBean response = new MyBean();
        response.setData(jokes.getJoke());

        return response;
    }

//    @ApiMethod(name = "getJokes", httpMethod = GET )
//    public MyBean getJokes() throws IOException {
//        Jokes jokes = new Jokes();
//
//        MyBean response = new MyBean();
//
//        response.getData();
//        response.getData(jokes.getJoke());
//
//    }

}

package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokesApi.JokesApi;


import java.io.IOException;

import recipe.kildare.com.jokesandroidlib.JokesActivity;

/**
 * Created by kilda on 4/27/2018.
 */

public class JokeEndpointAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokesApi mJokesApiService = null;
    private Context context;

    @Override
    public  String doInBackground(Context... params) {
        if(mJokesApiService == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            mJokesApiService = builder.build();
        }

        context = params[0];

        try {
            return mJokesApiService.requestJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    public void onPostExecute(String result) {
        Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra(context.getString(R.string.JOKE_KEY), result);
        context.startActivity(intent);
    }
}
package com.example.swagmence.lasthope.Model;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LocationWeatherApi extends AsyncTask<Void, Void, Void>{

    public JSONObject jo;

    @Override
    protected Void doInBackground(Void... voids) {
        {
            try {
                jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.metaweather.com/api/location/455827"))).nextValue();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

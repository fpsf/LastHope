package com.example.swagmence.lasthope;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LocationWeatherApi{


    JSONObject jo;

    LocationWeatherApi(Context context){
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
    }

}

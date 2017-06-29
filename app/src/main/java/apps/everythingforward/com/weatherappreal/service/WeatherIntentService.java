package apps.everythingforward.com.weatherappreal.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import apps.everythingforward.com.weatherappreal.Utility;
import apps.everythingforward.com.weatherappreal.events.WeatherEvent;
import apps.everythingforward.com.weatherappreal.model.WeatherData;
import apps.everythingforward.com.weatherappreal.network.HttpRequest;

/**
 * Created by santh on 6/30/2017.
 */

public class WeatherIntentService extends IntentService {

    public WeatherIntentService() {
        super("WeatherIntentService");
    }

    public WeatherIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        ArrayList<WeatherData> data = new ArrayList<>();

        double latValue, lonValue;

        String addressValue = intent.getStringExtra(Intent.EXTRA_TEXT);

        String urlString = Utility.getGeoCodingURL(addressValue);

        try {
            String jsonResponse = HttpRequest.get(new URL(urlString)).body();

            Log.e("GeocodingIntentService", jsonResponse);

            JSONObject mainObject = new JSONObject(jsonResponse);
            JSONArray results = mainObject.getJSONArray("results");
            JSONObject anothermainObject = results.getJSONObject(0);
            JSONObject geometry = anothermainObject.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");

            latValue = location.getDouble("lat");
            lonValue = location.getDouble("lng");

            Log.e("Geocoding", String.valueOf(latValue) + " : " + String.valueOf(lonValue));

            String strLatitude = String.valueOf(latValue);
            String strLongitude = String.valueOf(lonValue);


            String openWeatherURL = Utility.getOpenWeatherApiURL(strLatitude,strLongitude);

            Log.e("WIS",openWeatherURL);



                String body = HttpRequest.get(openWeatherURL).body();

                Log.e("WIS",body);
                JSONObject mainObj = new JSONObject(body);
                JSONArray listArray = mainObj.getJSONArray(Utility.KEY_LIST);

                for(int counter=0;counter<listArray.length();counter++)
                {
                    JSONObject main = listArray.getJSONObject(counter).getJSONObject(Utility.LIST_MAIN);
                    String temp = main.getString(Utility.MAIN_TEMP);
                    JSONArray array = main.getJSONArray(Utility.LIST_MAIN);
                    JSONObject weatherobj = array.getJSONObject(0);
                    String description = weatherobj.getString(Utility.WEATHER_MAIN);

                    data.add(new WeatherData(temp,description));



                }


                if(data.size()==0)
                {
                    Log.e("WIS","Data is empty");
                }

                EventBus.getDefault().post(new WeatherEvent(data));
















        } catch (Exception e) {

        }
    }
}

package apps.everythingforward.com.weatherappreal.events;

import java.util.ArrayList;

import apps.everythingforward.com.weatherappreal.model.WeatherData;

/**
 * Created by santh on 6/30/2017.
 */

public class WeatherEvent {
    ArrayList<WeatherData> data;

    public WeatherEvent(ArrayList<WeatherData> data)
    {
        this.data=data;
    }

    public ArrayList<WeatherData> getData() {
        return data;
    }
}

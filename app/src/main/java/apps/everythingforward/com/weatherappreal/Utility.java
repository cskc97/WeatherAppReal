package apps.everythingforward.com.weatherappreal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by santh on 6/29/2017.
 */

public class Utility {


        private static String GEOCODING_API_KEY="AIzaSyBYrIQYYqkdBcajkgA3VssxkN238hVCVw0";

     private static String OPENWEATHER_API_URL="api.openweathermap.org/data/2.5/weather?";


        public static String getOpenWeatherApiURL(String lat,String lon)
        {
            String retURL = OPENWEATHER_API_URL+"lat="+lat+"&lon="+lon;

            return retURL;
        }

        public static String getGeoCodingURL(String address)
        {
            String retString = null;
            String encodeAddress = "";
            try {
                encodeAddress = URLEncoder.encode(address,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if(encodeAddress!="") {
                retString = "https://maps.googleapis.com/maps/api/geocode/json?" +
                        "address=" + encodeAddress + "&key=" + GEOCODING_API_KEY;
                return retString;
            }

            return null;


        }


}

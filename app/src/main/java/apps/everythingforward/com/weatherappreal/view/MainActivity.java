package apps.everythingforward.com.weatherappreal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import apps.everythingforward.com.weatherappreal.R;
import apps.everythingforward.com.weatherappreal.events.WeatherEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWeatherObtain(WeatherEvent event)
    {


    }
}

package apps.everythingforward.com.weatherappreal.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import apps.everythingforward.com.weatherappreal.R;
import apps.everythingforward.com.weatherappreal.events.WeatherEvent;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWeatherObtain(WeatherEvent event)
    {




    }
    private void initRecyclerView() {



//        postsRecyclerViewAdapter = new PostsRecyclerViewAdapter();
//        postsRecyclerView.setAdapter(postsRecyclerViewAdapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        postsRecyclerView.setLayoutManager(layoutManager);
//        postsRecyclerView.setHasFixedSize(true);
//
    }
}

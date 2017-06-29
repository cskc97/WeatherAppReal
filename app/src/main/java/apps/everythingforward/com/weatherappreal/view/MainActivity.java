package apps.everythingforward.com.weatherappreal.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gc.materialdesign.views.ButtonFlat;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import apps.everythingforward.com.weatherappreal.R;
import apps.everythingforward.com.weatherappreal.events.WeatherEvent;
import apps.everythingforward.com.weatherappreal.model.WeatherData;
import apps.everythingforward.com.weatherappreal.service.WeatherIntentService;
import apps.everythingforward.com.weatherappreal.view.adapters.WeatherAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String address;

    ArrayList<WeatherData> data;


    ButtonFlat button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ButtonFlat)findViewById(R.id.button);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new MaterialDialog.Builder(MainActivity.this)
                        .title("Enter Address")
                        .content("Please choose a location")
                        .inputType(InputType.TYPE_CLASS_TEXT )
                        .input("Enter", "city", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something

                                address = input.toString();
                                Intent intent = new Intent(MainActivity.this, WeatherIntentService.class);
                                intent.putExtra(Intent.EXTRA_TEXT,address);
                                startService(intent);
                            }
                        }).show();





//                new LovelyTextInputDialog(getBaseContext())
//                        .setTopColorRes(R.color.colorAccent)
//                        .setTitle("Enter Address:")
//                        .setMessage("Please choose a location")
//                        .setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
//                            @Override
//                            public void onTextInputConfirmed(String text) {
//
//                                address = text;
//                                Intent intent = new Intent(MainActivity.this, WeatherIntentService.class);
//                                intent.putExtra(Intent.EXTRA_TEXT,address);
//                                startService(intent);
//
//
//
//
//
//                            }
//
//
//
//
//                        }).show();
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();






    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWeatherObtain(WeatherEvent event)
    {

        Log.e("MainActivity","onWeatherObtained");

        button.setVisibility(View.GONE);

        data = event.getData();
        WeatherAdapter adapter = new WeatherAdapter(data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);






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

package apps.everythingforward.com.weatherappreal.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import apps.everythingforward.com.weatherappreal.R;
import apps.everythingforward.com.weatherappreal.model.WeatherData;

/**
 * Created by santh on 6/29/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {


    public ArrayList<WeatherData> data;

    public WeatherAdapter(ArrayList<WeatherData> dataVal)
    {
        data = dataVal;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tempTV;
        TextView descriptionTV;

        public ViewHolder(View itemView) {
            super(itemView);
            tempTV = (TextView)itemView.findViewById(R.id.temp);
            descriptionTV=(TextView)itemView.findViewById(R.id.description);

        }
    }

    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);




    }

    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position) {
        holder.tempTV.setText(data.get(position).getTemperature());
        holder.descriptionTV.setText(data.get(position).getMainDescription());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

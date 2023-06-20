package com.example.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherRVAdapter extends RecyclerView.Adapter<WeatherRVAdapter.ViewHolder> {
    private  Context context;
    private ArrayList<WeatherRVmodal> weatherRVmodalArrayList;

    public WeatherRVAdapter(Context context, ArrayList<WeatherRVmodal> weatherRVmodalArrayList) {
        this.context = context;
        this.weatherRVmodalArrayList = weatherRVmodalArrayList;
    }

    @NonNull
    @Override
    public WeatherRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter.ViewHolder holder, int position) {
        WeatherRVmodal modal = weatherRVmodalArrayList.get(position);
        holder.temperatureTV.setText(modal.getTemperature() + "°c");
        Picasso.get().load("http:".concat(modal.getIcon() )).into(holder.conditionIV);
        holder.windTV.setText(modal.getWindSpeed() + "km/h");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date t = input.parse(modal.getTime());
            holder.timeTV.setText(output.format(t));

        }catch (ParseException e){
            e.printStackTrace();}

    }

    @Override
    public int getItemCount() {
        return weatherRVmodalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView windTV,temperatureTV,timeTV;
        private ImageView conditionIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windTV = itemView.findViewById(R.id.idTVWindSpeed);
            temperatureTV = itemView.findViewById(R.id.idTVTemperature);
            timeTV = itemView.findViewById(R.id.idTVTime);
            conditionIV = itemView.findViewById(R.id.idIVCondition);
        }
    }
}

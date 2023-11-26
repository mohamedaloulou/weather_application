package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RVAdapterMore extends RecyclerView.Adapter<RVAdapterMore.ViewHolder> {
    private Context context;
    private ArrayList<RVmodalMore> RVModalMoreArrayList;

    public RVAdapterMore(Context context, ArrayList<RVmodalMore> RVModalMoreList) {
        this.context = context;
        this.RVModalMoreArrayList =  RVModalMoreList;;
    }
    @NonNull
    @Override
    public RVAdapterMore.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item_more,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapterMore.ViewHolder holder, int position) {
        RVmodalMore modalMore = RVModalMoreArrayList.get(position);
        holder.wind_degree.setText("wind degree : "+modalMore.getWind_degree());
        holder.pressure.setText("pressure(mb) : "+modalMore.getPressure());
        holder.precipitation.setText("precipitation(mm) : "+modalMore.getPrecipitation());
        holder.humidity.setText("humidity : "+modalMore.getHumidity());
        holder.cloud.setText("cloud : "+modalMore.getCloud());
        holder.rain.setText("chance of rain : "+modalMore.getRain());
        holder.snow.setText("chance of snow : "+modalMore.getSnow());
        holder.vis.setText("vis : "+modalMore.getVis());
        holder.uv.setText("uv : "+modalMore.getUv());
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date t = input.parse(modalMore.getTime());
            holder.TimeMore.setText(output.format(t));

        }catch (ParseException e){
            e.printStackTrace();}

    }

    @Override
    public int getItemCount() {
        return RVModalMoreArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView wind_degree,pressure,precipitation,humidity,cloud,rain,snow,vis,uv,TimeMore;
        public ViewHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            wind_degree = itemView.findViewById(R.id.idTVWindDegree);
            pressure = itemView.findViewById(R.id.idPressure);
            precipitation = itemView.findViewById(R.id.idPrecipitation);
            humidity = itemView.findViewById(R.id.idHumidity);
            cloud = itemView.findViewById(R.id.idCloud);
            rain = itemView.findViewById(R.id.idRain);
            snow = itemView.findViewById(R.id.idSnow);
            vis = itemView.findViewById(R.id.idVis);
            uv = itemView.findViewById(R.id.idUv);
            TimeMore = itemView.findViewById(R.id.idTVTimeMore);
        }
    }





}

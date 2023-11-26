package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MoreActivity extends AppCompatActivity {
    private TextView wind_degree,pressure,precipitation,humidity,cloud,rain,snow,vis,uv,timeMore,cityMore;
    private RecyclerView weatherRVMore;
    private ArrayList<RVmodalMore> RVmodalMoreArrayList;
    private RVAdapterMore RVAdapterMore;
    private int PERMISSION_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        cityMore = findViewById(R.id.idTVCityNameMore);
        timeMore=findViewById(R.id.idTVTimeMore);
        wind_degree=findViewById(R.id.idTVWindDegree);
        pressure=findViewById(R.id.idPressure);
        precipitation = findViewById(R.id.idPrecipitation);
        humidity = findViewById(R.id.idHumidity);
        cloud = findViewById(R.id.idCloud);
        rain=findViewById(R.id.idRain);
        snow=findViewById(R.id.idSnow);
        vis=findViewById(R.id.idVis);
        uv=findViewById(R.id.idUv);
        weatherRVMore=findViewById(R.id.idRVWeatherMore);
        RVmodalMoreArrayList = new ArrayList<>();
        RVAdapterMore = new RVAdapterMore(this,RVmodalMoreArrayList);
        weatherRVMore.setAdapter(RVAdapterMore);
        final String cityName = getIntent().getStringExtra("city Name");
        getWeatherInfoMore(cityName);
        final Button predict= findViewById(R.id.predict);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreActivity.this,ResultActivity.class);
                startActivity(intent);

            }
        });


    }
    private void getWeatherInfoMore(String city){
        String url = "http://api.weatherapi.com/v1/forecast.json?key=579507948c43482281d92359232006 &q="+ city +"&days=1&aqi=yes&alerts=yes";
        cityMore.setText(city);
        RequestQueue requestQueue = Volley.newRequestQueue(MoreActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RVmodalMoreArrayList.clear();
                try{

                    JSONObject forecastObj = response.getJSONObject("forecast");
                    JSONObject forecastO = forecastObj.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourArray = forecastO.getJSONArray("hour");

                    for(int i =0;i<hourArray.length();i++){
                        JSONObject hourObj = hourArray.getJSONObject(i);
                        String time = hourObj.getString("time");
                        String wind = hourObj.getString("wind_degree");
                        String press = hourObj.getString("pressure_mb");
                        String precip = hourObj.getString("precip_mm");
                        String hum = hourObj.getString("humidity");
                        String clou = hourObj.getString("cloud");
                        String rain_chance = hourObj.getString("chance_of_rain");
                        String snow_chance = hourObj.getString("chance_of_snow");
                        String vis_var = hourObj.getString("vis_km");
                        String uv_var = hourObj.getString("uv");
                        RVmodalMoreArrayList.add(new RVmodalMore(time,wind,press,precip,hum,clou,rain_chance,snow_chance,vis_var,uv_var));


                    }
                    RVAdapterMore.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MoreActivity.this,"Please enter valid city name",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);


    }
}

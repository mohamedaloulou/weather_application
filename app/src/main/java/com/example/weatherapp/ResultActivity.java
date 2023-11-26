package com.example.weatherapp;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private double maxTemp, minTemp, windSpeed, precipa;
    private ArrayList<RVmodalMore> RVmodalMoreArrayList;

    private void getWeatherInfoMore(String city) {
       /* String url = "http://api.weatherapi.com/v1/forecast.json?key=579507948c43482281d92359232006 &q="+ city +"&days=1&aqi=yes&alerts=yes";
        cityMore.setText(city);
        RequestQueue requestQueue = Volley.newRequestQueue(ResultActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RVmodalMoreArrayList.clear();
                try {
                    String responseBody = response.toString();
                    JSONObject jsonObject = new JSONObject(responseBody);

                    JSONObject forecastDay = jsonObject.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0);
                    JSONObject dayData = forecastDay.getJSONObject("day");

                    double maxTemp = dayData.getDouble("maxtemp_c");
                    double minTemp = dayData.getDouble("mintemp_c");
                    double windSpeed = dayData.getDouble("maxwind_kph");
                    double precipa = dayData.getDouble("totalprecip_mm")

                    RVmodalMoreArrayList.add(new RVmodalMore(maxTemp, minTemp, windSpeed, precipa));

                    RVAdapterMore.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayList<Double> temperatureData = new ArrayList<>();
                temperatureData.add(maxTemp);
                temperatureData.add(minTemp);
                temperatureData.add(windSpeed);

            }
        }*/
    }
}
package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
private RelativeLayout homeRL;
private ProgressBar loadingPB;
private TextView cityNameTV,TemperatureTV,conditionTV;
private RecyclerView weatherRV;
private TextInputEditText cityEdt;
private ImageView backIV,searchIV,iconIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeRL= findViewById(R.id.idRLHome);
        loadingPB= findViewById(R.id.idPBLoading);
        cityNameTV= findViewById(R.id.idTVCityName);
        TemperatureTV= findViewById(R.id.idTVTemperature);
        conditionTV= findViewById(R.id.idTVCondition);
        weatherRV= findViewById(R.id.idRVWeather);
        cityEdt= findViewById(R.id.idEdtCity);
        backIV= findViewById(R.id.idIVBack);
        searchIV= findViewById(R.id.idIVSearch);
        iconIV= findViewById(R.id.idIVIcon);

    }
}
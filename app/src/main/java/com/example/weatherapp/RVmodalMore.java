package com.example.weatherapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVmodalMore {
    private String time;
    private String wind_degree;
    private String pressure;
    private String precipitation;
    private String humidity;
    private String cloud;
    private String rain;
    private String snow;
    private String vis;
    private String uv;

    public RVmodalMore(String time, String wind_degree, String pressure, String precipitation, String humidity, String cloud, String rain, String snow, String vis, String uv) {
        this.time = time;
        this.wind_degree = wind_degree;
        this.pressure = pressure;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.cloud = cloud;
        this.rain = rain;
        this.snow = snow;
        this.vis = vis;
        this.uv = uv;
    }

    public String getTime() {
        return time;
    }

    public String getWind_degree() {
        return wind_degree;
    }

    public String getPressure() {
        return pressure;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getCloud() {
        return cloud;
    }

    public String getRain() {
        return rain;
    }

    public String getSnow() {
        return snow;
    }

    public String getVis() {
        return vis;
    }

    public String getUv() {
        return uv;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWind_degree(String wind_degree) {
        this.wind_degree = wind_degree;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }


}

package com.weatherapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class WeatherResponse {

    private Main main;
    private Wind wind;
    private Sys sys;
    private List<WeatherInfo> weather;

    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }

    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }

    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }

    public List<WeatherInfo> getWeather() { return weather; }
    public void setWeather(List<WeatherInfo> weather) { this.weather = weather; }

    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }

        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() { return speed; }
        public void setSpeed(double speed) { this.speed = speed; }
    }

    public static class Sys {
        private long sunrise;
        private long sunset;

        public long getSunrise() { return sunrise; }
        public void setSunrise(long sunrise) { this.sunrise = sunrise; }

        public long getSunset() { return sunset; }
        public void setSunset(long sunset) { this.sunset = sunset; }
    }

    public static class WeatherInfo {
        private String description;

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}

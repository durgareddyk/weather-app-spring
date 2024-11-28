package com.weatherapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Weather getWeather(
            @RequestParam String city,
            @RequestParam(required = false) String country,
            @RequestParam(defaultValue = "metric") String units) {
        // Fetch real-time weather data from WeatherService
        return weatherService.getWeather(city, country, units);
    }
}

class Weather {
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String condition;
    private String sunrise;
    private String sunset;

    // Add the constructor with all parameters
    public Weather(double temperature, int humidity, double windSpeed, String condition, String sunrise, String sunset) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Weather(double temp, int humidity2, double speed, String description, long sunrise2, long sunset2) {
        //TODO Auto-generated constructor stub
    }

    // Getters and setters
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getSunrise() { return sunrise; }
    public void setSunrise(String sunrise) { this.sunrise = sunrise; }

    public String getSunset() { return sunset; }
    public void setSunset(String sunset) { this.sunset = sunset; }
}

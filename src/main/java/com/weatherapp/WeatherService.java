package com.weatherapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public Weather getWeather(String city, String country, String units) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q", city + (country != null ? "," + country : ""))
                .queryParam("units", units)
                .queryParam("appid", apiKey)
                .toUriString();
        logger.info("Fetching weather data from URL: {}", url);
        // Call the weather API and map the response to the Weather class
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response != null) {
            logger.info("WeatherResponse received: {}", response);
            return new Weather(
                    response.getMain().getTemp(),
                    response.getMain().getHumidity(),
                    response.getWind().getSpeed(),
                    response.getWeather().get(0).getDescription(),
                    response.getSys().getSunrise(),
                    response.getSys().getSunset()
            );
        }
        System.out.println("Failed to fetch weather data");

        throw new RuntimeException("Failed to fetch weather data");
    }
}

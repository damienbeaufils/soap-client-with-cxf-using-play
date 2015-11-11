package controllers;

import com.global.weather.GlobalWeatherSoap;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class GlobalWeatherController extends Controller {

    @Inject
    private GlobalWeatherSoap globalWeatherSoapClient;

    public Result getCities(String countryName) {
        String cities = globalWeatherSoapClient.getCitiesByCountry(countryName);
        return ok(cities).as("text/xml");
    }

    public Result getWeather(String countryName, String cityName) {
        String weather = globalWeatherSoapClient.getWeather(cityName, countryName);
        return ok(weather).as("text/xml");
    }
}

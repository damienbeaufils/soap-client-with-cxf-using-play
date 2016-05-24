package controllers;

import com.global.weather.GlobalWeatherSoap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import play.mvc.Result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static play.test.Helpers.contentAsString;

@RunWith(MockitoJUnitRunner.class)
public class GlobalWeatherControllerTest {

    @InjectMocks
    private GlobalWeatherController globalWeatherController;

    @Mock
    private GlobalWeatherSoap globalWeatherSoapClient;

    @Test
    public void shouldReturnCities_AsTextXml_OfGivenCountry_UsingGlobalWeatherSoapClient() {
        // Given
        String country = "France";
        String cities = "<NewDataSet>\n" +
                "  <Table>\n" +
                "    <Country>France</Country>\n" +
                "    <City>Le Touquet</City>\n" +
                "  </Table>\n" +
                "</NewDataSet>";
        when(globalWeatherSoapClient.getCitiesByCountry(country)).thenReturn(cities);

        // When
        Result result = globalWeatherController.getCities(country);

        // Then
        assertThat(result.status()).isEqualTo(200);
        assertThat(result.contentType().get()).isEqualTo("text/xml");
        assertThat(contentAsString(result)).isEqualTo(cities);
    }

    @Test
    public void shouldReturnWeather_AsTextXml_OfGivenCityInCountry_UsingGlobalWeatherSoapClient() {
        // Given
        String country = "France";
        String city = "Cognac";
        String weather = "<CurrentWeather>\n" +
                "  <Location>Cognac, France (LFBG) 45-40N 000-19W 31M</Location>\n" +
                "  <Time>Nov 09, 2015 - 07:30 AM EST / 2015.11.09 1230 UTC</Time>\n" +
                "  <Wind> from the SSW (200 degrees) at 7 MPH (6 KT):0</Wind>\n" +
                "  <Visibility> greater than 7 mile(s):0</Visibility>\n" +
                "  <SkyConditions> overcast</SkyConditions>\n" +
                "  <Temperature> 64 F (18 C)</Temperature>\n" +
                "  <DewPoint> 59 F (15 C)</DewPoint>\n" +
                "  <RelativeHumidity> 82%</RelativeHumidity>\n" +
                "  <Pressure> 30.47 in. Hg (1032 hPa)</Pressure>\n" +
                "  <Status>Success</Status>\n" +
                "</CurrentWeather>";
        when(globalWeatherSoapClient.getWeather(city, country)).thenReturn(weather);

        // When
        Result result = globalWeatherController.getWeather(country, city);

        // Then
        assertThat(result.status()).isEqualTo(200);
        assertThat(result.contentType().get()).isEqualTo("text/xml");
        assertThat(contentAsString(result)).isEqualTo(weather);
    }
}
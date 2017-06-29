package apps.everythingforward.com.weatherappreal.model;

/**
 * Created by santh on 6/29/2017.
 */

public class WeatherData {
    private String temperature;
    private String mainDescription;

    public WeatherData() {
    }

    public WeatherData(String temperature, String mainDescription) {
        this.temperature = temperature;
        this.mainDescription = mainDescription;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }
}

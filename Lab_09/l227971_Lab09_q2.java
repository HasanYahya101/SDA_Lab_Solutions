interface WeatherProvider {
    double getTemperature();
    double getHumidity();
    double getWindSpeed();
    double getPrecipitation();
}

class ThirdPartyWeatherAPI {
    double fetchTemperature() {
        return 0.0;
     }
    double fetchHumidity() {
        return 0.0;
     }
    double fetchWindSpeed() {
        return 0.0;
     }
    double fetchPrecipitation() {
        return 0.0;
     }
}

class WeatherAdapter implements WeatherProvider {
    private ThirdPartyWeatherAPI api;

    public WeatherAdapter(ThirdPartyWeatherAPI api) {
        this.api = api;
    }

    @Override
    public double getTemperature() {
        return api.fetchTemperature();
    }

    @Override
    public double getHumidity() {
        return api.fetchHumidity();
    }

    @Override
    public double getWindSpeed() {
        return api.fetchWindSpeed();
    }

    @Override
    public double getPrecipitation() {
        return api.fetchPrecipitation();
    }
}

public class l227971_Lab09_q2 {
    public static void main(String[] args) {
        ThirdPartyWeatherAPI thirdPartyAPI = new ThirdPartyWeatherAPI();
        WeatherProvider weatherProvider = new WeatherAdapter(thirdPartyAPI);

        // Use the weatherProvider to fetch weather information
        double temperature = weatherProvider.getTemperature();
        double humidity = weatherProvider.getHumidity();
        double windSpeed = weatherProvider.getWindSpeed();
        double precipitation = weatherProvider.getPrecipitation();
    }
}




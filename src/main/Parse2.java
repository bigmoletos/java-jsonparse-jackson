import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parse2 {

	private final static String JSON_WEATHER_PATH = "weather.json";
	// https://rapidapi.com/community/api/open-weather-map
	// private final static String JSON_API_METEO_URL =
	// "https://geoservices.atmosud.org/geoserver/ind_sudpaca/ows?service=WFS&version=2.0.0&request=GetFeature&typeName=ind_sudpaca:ind_sudpaca_agglo&outputFormat=application/json&srsName=EPSG:2154";
	private final static String JSON_API_METEO_URL = "geoserver-GetFeatureAtmosud.json";
	private final static String JSON_API_METEO = "qualiteAir.json";
	private final static String JSON_API_METEO3 = "qualiteAir3.json";
	private final static String JSON_API_METEO2 = "qualiteAir2.json";

	// Method body
	// In the method body you should make a request to the openweather server with
	// an api key which you can get by registering in the website. You can achieve
	// this with Unirest library (it's the easiest way)

	// public void parse2() {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectMapper objectMapperMeteo = new ObjectMapper();

		// avec le JSON WEATHER
		try {
			// write your code here !
			// TODO : get the root from the file JSON_WEATHER_PATH
//			JsonNode root = objectMapper.readTree(new File(
//					"/home/franck/programmation/workspaceEclipse/queteSpring_parse_jakson_Json/java-jsonparse-jackson/weather.json"));
			JsonNode rootWeather = objectMapper.readTree(new File(JSON_WEATHER_PATH));

			// TODO : get the value of "name" attribute
			String cityName = rootWeather.get("name").asText();

			// TODO : get the "lat" and "lon" values of the "coord"
			JsonNode coordObject = rootWeather.get("coord");
			Double cityLatitude = coordObject.get("lat").asDouble();
			Double cityLongitude = coordObject.get("lon").asDouble();

			// TODO : get the "wind" attribute as an Wind object
			JsonNode windObject = rootWeather.get("wind");
			Double speed = windObject.get("speed").asDouble();
			Double deg = windObject.get("deg").asDouble();
			Wind wind = objectMapper.convertValue(rootWeather.get("wind"), Wind.class);

			// TODO : get the "weather" attribute as an array of Weather objects
			Weather[] weathers = objectMapper.convertValue(rootWeather.get("weather"), Weather[].class);

			System.out.println("*********API weather *****************");
			// Don't touch this !
			System.out.printf("City name: %s%n", cityName);
			System.out.printf("City latitude: %s%n", cityLatitude);
			System.out.printf("City longitude: %s%n", cityLongitude);
			System.out.printf("Wind infos: %s%n", wind.toString());
			System.out.printf("Wind speed:\t%.2f and deg:\t%.2f %n", speed, deg);
			for (Weather weather : weathers) {
				System.out.printf("Weather infos: %s%n", weather.toString());
			}
			/*
			 * Expected result :
			 * 
			 * City name: London City latitude: 51.51 City longitude: -0.13 Wind infos:
			 * src.main.Wind{speed=4.1, deg=80.0} Weather infos: src.main.Weather{id=300,
			 * main='Drizzle', description='light intensity drizzle', icon='09d'} Weather
			 * infos: src.main.Weather{id=800, main='Clear', description='clear sky',
			 * icon='01n'}
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
// avec l'API meteo
		System.out.println("*********API meteo *****************");
		try {
			// TODO : get the root from the file JSON_WEATHER_PATH
			JsonNode rootMeteo1 = objectMapperMeteo.readTree(new File(JSON_API_METEO));
			JsonNode rootMeteo2 = objectMapperMeteo.readTree(new File(JSON_API_METEO2));
			JsonNode rootMeteo3 = objectMapperMeteo.readTree(new File(JSON_API_METEO3));
			JsonNode rootMeteoURL = objectMapperMeteo.readTree(new File(JSON_API_METEO_URL));
//données générales du json
			Integer nbfeature = rootMeteo1.get("totalFeatures").asInt();
			System.out.println("nombre features: " + nbfeature);
//données properties uniquement 
			Properties[] properties2 = objectMapperMeteo.convertValue(rootMeteo3.get("properties"), Properties[].class);
			for (Properties properties : properties2) {
				System.out.println("*********Properties *****************");
				System.out.printf("properties infos: %s%n", properties.toString());
				System.out.println("**************************");
			}
//données features comprenant properties et geometry
//			Features[] features = objectMapper.convertValue(rootMeteo2.get("features"), Features[].class);
			Features[] features = objectMapper.convertValue(rootMeteoURL.get("features"), Features[].class);

			for (Features features2 : features) {
				System.out.println("*********données features comprenant properties et geometry*****************");
				System.out.printf("features infos: %s%n", features2.toString());
				System.out.println("**************************");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

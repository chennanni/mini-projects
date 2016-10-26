package app.weather_fetcher;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class WeatherApp {
	
	private static String API_KEY = "7cbb3b610d6b00dcd4f9200e9cce99bc";
	private static String URL = "http://api.openweathermap.org/data/2.5/weather";
	
	public static void main(String[] args) throws UnsupportedOperationException, IOException {
		
		String zipCode = "19401";
		String requestUrl = new WeatherApp().assembleRequestUrl(zipCode);
		
		//System.out.println(requestUrl);
		
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	// execute http get request and get a response
            HttpGet httpGet = new HttpGet(requestUrl);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            
            //System.out.println(response.getStatusLine());

            // deal with response
            try {
            	HttpEntity entity = response.getEntity();
                InputStream input = entity.getContent();
                StringBuilder responseString = new StringBuilder();
                
                // read response body content and put it into a String
                try {
    				int data = input.read();
    				while(data != -1){
    					responseString.append((char) data);
    					data = input.read();
    				}
                } finally {
                	input.close();
                }
  
				//System.out.println(responseString);
				
                // parse json and get weather information
				JsonObject object = Json.parse(responseString.toString()).asObject();
				float temp = object.get("main").asObject().getFloat("temp", 0);
				float pressure = object.get("main").asObject().getFloat("pressure", 0);
				float humidity = object.get("main").asObject().getFloat("humidity", 0);
				
				System.out.println("zip code: " + zipCode);
				System.out.println("temperature(Celsius): " + temp);
				System.out.println("pressure(hPa): " + pressure);
				System.out.println("humidity(%): " + humidity);
				
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
	
	public String assembleRequestUrl(String zipCode) {
		// TODO: check zip code format
		return URL+"?zip="+zipCode+",us&"+"units=metric&"+"APPID="+API_KEY;
	}
}

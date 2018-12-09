import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Class to make API call to Google Maps with a string address, parse the JSON response
 * for latitude and longitude of the address, and save as a new Location object.
 * @author michellechien
 *
 */
public class GeocodeAPI {
	
	/**
	 * Makes the API call and returns the JSON result as a String
	 * @param address address of the location
	 * @return JSON result from API call
	 * @throws IOException
	 */
	public String makeAPICall(String address) throws IOException {
		address = address.replaceAll(" ", "+");
		String urlString = GoogleAPIKey.startURL + address + GoogleAPIKey.endURL;
		URL geoCoderURL;
		URLConnection yc;
		BufferedReader in;
		
		geoCoderURL = new URL(urlString);
		yc = geoCoderURL.openConnection();
		in = new BufferedReader(new InputStreamReader(
                 yc.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		     response.append(inputLine);
		}
		in.close();
		     
		return response.toString();
	}
	
	/**
	 * Parse the JSON response String into a Location object
	 * @param jsonResponse string of response of API call
	 * @return Location object
	 * @throws JSONException
	 */
	public GeocodeLocation parseGeoCodeJSON(String jsonResponse) throws JSONException {
		JSONObject jObj = new JSONObject(jsonResponse);
		JSONArray results = jObj.getJSONArray("results");
		JSONObject item = results.getJSONObject(0);
		String address = results.getJSONObject(0).getString("formatted_address");
		JSONObject geometry = item.getJSONObject("geometry");
	    JSONObject location = geometry.getJSONObject("location");
	    double lat = location.getDouble("lat");
        double lng = location.getDouble("lng");
        
		return new GeocodeLocation(address, lat, lng);
	}
	
	public static void main(String[] args) {
		String address = "2606 South St, Philadelphia, PA";
		System.out.println(address);
		GeocodeAPI geo = new GeocodeAPI();
		String jsonResponse;
		try {
			jsonResponse = geo.makeAPICall(address);
			GeocodeLocation location = geo.parseGeoCodeJSON(jsonResponse);
			System.out.println(location.getAddress() + "|" + location.getLat() + "|" + location.getLng());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/**
 * Location object to hold location information
 * @author michellechien
 *
 */
public class GeocodeLocation {
	
	private String address;
	private double lat; 
	private double lng;
	
	public GeocodeLocation(String address, double lat, double lng) {
		this.address = address;
		this.lat = lat; 
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getAddress() {
		return address;
	}
	
	

}

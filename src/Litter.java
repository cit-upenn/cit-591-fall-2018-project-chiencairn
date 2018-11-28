
public class Litter {
	
	//Instance Variables
	private int litterId;
	private double latitude;
	private double longitude;
	
	/**
	 * The Litter constructor instantiates a single litter incident with an integer ID and a lat/long location.
	 * @param litterId
	 * @param latitude
	 * @param longitude
	 */
	Litter(int litterId, double latitude, double longitude) {
		this.litterId = litterId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * The getLitterId method allows for accessing a single incident by an integer identifier.
	 * @return litterId
	 */
	public int getLitterId() {
		return litterId;
	}
	/**
	 * The getLatitude method allows for accessing an incidents latitude location as a double
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * The getLongitude method allows for accessing an incidents longitude location as a double
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
}

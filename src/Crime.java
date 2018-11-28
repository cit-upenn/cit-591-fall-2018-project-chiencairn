
public class Crime {

	//Instance Variables
	private int crimeId;
	private String offense;
	private double latitude;
	private double longitude;
	
	/**
	 * The Crime constructor instantiates a single crime base on the arguments of crimeId, offense, latitude, and longitude.
	 * @param crimeId
	 * @param offense
	 * @param latitude
	 * @param longitude
	 */
	Crime(int crimeId, String offense, double latitude, double longitude) {
		this.crimeId = crimeId;
		this.offense = offense;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * The getCrimeId method allows for accessing a single incident by an integer identifier.
	 * @return crimeId
	 */
	public int getCrimeId() {
		return crimeId;
	}
	/**
	 * The getOffense method allows for accessing a single incidents particular offense.
	 * @return offense
	 */
	public String getOffense() {
		return offense;
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

/**
 * Class to hold information from Residential Permit Parking data
 * @author michellechien
 *
 */
public class PermitBlocks {
	private String street;
	private int district;
	private String block;
	private String side;
	private double lat;
	private double lng;
	private String geomMerc; 
	private String geom;
	
	/**
	 * Constructor
	 * @param district district the parking zone belongs to
	 * @param lat latitude
	 * @param lng longitude
	 */
	public PermitBlocks(int district, double lat, double lng) {
		this.street = "";
		this.district = district;
		this.block = ""; 
		this.side = "";
		this.lat = lat;
		this.lng = lng;
		this.geomMerc = "";
		this.geom = "";
	}

	/**
	 * Getter for street name
	 * @return street name
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Getter for district num
	 * @return district number
	 */
	public int getDistrict() {
		return district;
	}
	
	/**
	 * Getter for block sequence
	 * @return block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * Getter for side of street of parking permit
	 * @return side
	 */
	public String getSide() {
		return side;
	}
	
	/**
	 * Getter for latitude 
	 * @return latitude
	 */
	public double getLat() {
		return lat;
	}
	
	/**
	 * Getter for longitude
	 * @return longitude
	 */
	public double getLng() {
		return lng;
	}
	
	/**
	 * Getter for geomerc
	 * @return GeoMerc
	 */
	public String getGeomMerc() {
		return geomMerc;
	}
	
	/**
	 * Getter for geom
	 * @return geom
	 */
	public String getGeom() {
		return geom;
	}
	
	/**
	 * Set street name
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Set block sequence
	 * @param block
	 */
	public void setBlock(String block) {
		this.block = block;
	}
	
	/**
	 * Set side street
	 * @param side
	 */
	public void setSide(String side) {
		this.side = side;
	}
	
	/**
	 * set GeomMerc 
	 * @param geomMerc
	 */
	public void setGeomMerc(String geomMerc) {
		this.geomMerc = geomMerc;
	}
	
	/**
	 * set geo 
	 * @param geom
	 */
	public void setGeom(String geom) {
		this.geom = geom;
	}
	
	/**
	 * Returns string representation of PermitBlocks
	 */
	public String toString() {
		return district + "|" + street + "|" + lat + "|" + lng;
	}
	
	

}


public class PermitBlocks {
	private String street;
	private int district;
	private String block;
	private String side;
	private double lat;
	private double lng;
	private String geomMerc; 
	private String geom;
	
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

	public String getStreet() {
		return street;
	}

	public int getDistrict() {
		return district;
	}

	public String getBlock() {
		return block;
	}

	public String getSide() {
		return side;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public String getGeomMerc() {
		return geomMerc;
	}

	public String getGeom() {
		return geom;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public void setGeomMerc(String geomMerc) {
		this.geomMerc = geomMerc;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}
	
	public String toString() {
		return district + "|" + street + "|" + lat + "|" + lng;
	}
	
	

}

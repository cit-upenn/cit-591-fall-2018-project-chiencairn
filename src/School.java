/**
 * Class to hold information from School data
 * @author michellechien
 *
 */
public class School {
	private String name;
	private int id;
	private double lng;
	private double lat;
	private String gradeLevels;
	private int enrollment;
	private String type;
	private double score;
	
	/**
	 * Constructor to create school with name and location
	 * @param name
	 * @param lat
	 * @param lng
	 */
	public School(String name, double lat, double lng) {
		this.name = name;
		this.id = -1;
		this.lat = lat;
		this.lng = lng;
		this.gradeLevels  = "";
		this.enrollment = -1;
		this.type = "";
		this.score = 0;
	}

	/**
	 * Getter for school name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for longitude
	 * @return longitude
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * Getter for latitude
	 * @return latitude
	 */
	public double getLat() {
		return lat;
	}
	
	/**
	 * Getter for id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Getter for grade levels in school
	 * @return grade levels
	 */
	public String getGradeLevels() {
		return gradeLevels;
	}

	/**
	 * Setter for grade levels in school
	 * @param gradeLevels
	 */
	public void setGradeLevels(String gradeLevels) {
		this.gradeLevels = gradeLevels;
	}
	
	/**
	 * Getter for enrollment numbers
	 * @return enrollment
	 */
	public int getEnrollment() {
		return enrollment;
	}
	
	/**
	 * Setter for enrollement numbers
	 * @param enrollment
	 */
	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}
	
	/**
	 * Getter for type of school (e.g. public, private)
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Setter for type of school (e.g. public, private)
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for school score. Returns -1 if not graded.
	 * @return school score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Setter for school score. Set to -1 if not graded.
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	 * Returns string representation of School
	 */
	public String toString() {
		String s = name + "|" + lat + "|" + lng  + "|" + id  + "|" +  gradeLevels  + "|" + enrollment  + "|" + type  + "|" + score;
		return s;
	}
}

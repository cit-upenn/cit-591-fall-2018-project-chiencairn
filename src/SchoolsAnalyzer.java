import java.util.ArrayList;
/**
 * Class to get a school score based on a location using school data
 * @author michellechien
 *
 */
public class SchoolsAnalyzer {
	private ArrayList<School> schools;
	private double lat;
	private double lng;
	
	/**
	 * Constructor to create an analyzer object using an arraylist of school info and coordinates to compare against
	 * @param schools
	 * @param lat
	 * @param lng
	 */
	public SchoolsAnalyzer(ArrayList<School> schools, double lat, double lng) {
		this.schools = schools;
		this.lat = lat; 
		this.lng = lng;
	}
	
	/**
	 *
	 * Method calculates an integer rating between 0-100 based on the number of
	 * schools within .5 miles. Schools with you progress report scores from 
	 * the district are weighted more based off of their grade.
	 * @return school score
	 */
	public double getSchoolScore() {
		double quality = 0; 
		double qualityCount = 0;
		double quantity = 0;
		for(School s: schools) {
			if (isClose(.007, s.getLat(), s.getLng(), lat, lng)) {
				quantity++;
				if (s.getScore() > 0) {
					quality += s.getScore();
					qualityCount++;
				}
			}	
		}
		double score = (quality/qualityCount)*.6 + (quantity/35)*100*.4;
		if(score < 0) {
			return 0.0;
		} else if(score > 100) {
			return 100.0;
		} else {
			return score;
		}
	}
	
	/**
	 * helper function to determine if two coordinates are close based on a threshold 
	 * @param threshold
	 * @param startLat
	 * @param startLong
	 * @param endLat
	 * @param endLong
	 * @return true if close
	 */
	public boolean isClose(double threshold, double startLat, double startLong, double endLat, double endLong) {
		double diffLat = Math.abs(startLat-endLat);
		double diffLong = Math.abs(startLong-endLong);
		return (diffLat+diffLong)/2 < threshold;
	}

}

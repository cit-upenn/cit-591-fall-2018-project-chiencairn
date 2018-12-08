import java.util.ArrayList;

public class SchoolsAnalyzer {
	private ArrayList<School> schools;
	private double lat;
	private double lng;
	
	public SchoolsAnalyzer(ArrayList<School> schools, double lat, double lng) {
		this.schools = schools;
		this.lat = lat; 
		this.lng = lng;
	}
	
	public double getSchoolScore() {
		double quality = 0; 
		double qualityCount = 0;
		double quantity = 0;
		for(School s: schools) {
			//System.out.println(s.getName());
			if (isClose(.007, s.getLat(), s.getLng(), lat, lng)) {
				//System.out.println("isclose");
				quantity++;
				if (s.getScore() > 0) {
					quality += s.getScore();
					qualityCount++;
				}
			}	
		}
		//System.out.println(quality + "|" + qualityCount + "|" + quantity);
		double score = (quality/qualityCount)*.6 + (quantity/35)*100*.4;
		return score;
	}
	
	public boolean isClose(double threshold, double startLat, double startLong, double endLat, double endLong) {
		double diffLat = Math.abs(startLat-endLat);
		double diffLong = Math.abs(startLong-endLong);
		return (diffLat+diffLong)/2 < threshold;
	}

}

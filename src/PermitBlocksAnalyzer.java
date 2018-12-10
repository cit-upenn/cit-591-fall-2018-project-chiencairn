import java.util.ArrayList;

/**
 * Class to get a parking score based on a location using permit blocks data
 * @author michellechien
 *
 */
public class PermitBlocksAnalyzer {
	private ArrayList<PermitBlocks> blocks;
	private double lat;
	private double lng;
	
	/**
	 * Constructor to create an analyzer object using an arraylist of block info and coordinates to compare against
	 * @param blocks
	 * @param lat
	 * @param lng
	 */
	public PermitBlocksAnalyzer(ArrayList<PermitBlocks> blocks, double lat, double lng) {
		this.blocks = blocks;
		this.lat = lat; 
		this.lng = lng;
	}
	
	/**
	 * Method calculates an integer rating between 0-100 based on the number of
	 * available street parking spaces within .5 miles
	 * @return parking score 
	 */
	public double getParkingScore() {
		double parkingCount = 0;
		for (PermitBlocks p: blocks) {
			if (isClose(.007, p.getLat(), p.getLng(), lat, lng)) {
				parkingCount++;
			}
		}
		parkingCount = parkingCount/1.5;
		if(parkingCount > 100) {
			return 100;
		} else if(parkingCount < 0){
			return 0;
		} else {
		return parkingCount;
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

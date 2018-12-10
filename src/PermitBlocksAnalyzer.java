import java.util.ArrayList;

public class PermitBlocksAnalyzer {
	private ArrayList<PermitBlocks> blocks;
	private double lat;
	private double lng;
	
	public PermitBlocksAnalyzer(ArrayList<PermitBlocks> blocks, double lat, double lng) {
		this.blocks = blocks;
		this.lat = lat; 
		this.lng = lng;
	}
	
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
		} else {
		return parkingCount;
		}
	}
	
	public boolean isClose(double threshold, double startLat, double startLong, double endLat, double endLong) {
		double diffLat = Math.abs(startLat-endLat);
		double diffLong = Math.abs(startLong-endLong);
		return (diffLat+diffLong)/2 < threshold;
	}

}

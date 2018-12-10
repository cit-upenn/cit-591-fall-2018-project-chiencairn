import java.util.ArrayList;

/**
 * The DataAnalyzer class is used to assess input data in the form of arraylists and produce tangible ratings based on event frequency.
 * @author grahampitcairn
 * @version 1.0 12-03-2018
 */
public class DataAnalyzer {
	
	//Instance Variables
	double latitude;
	double longitude;
	private ArrayList<Crime> crimes;
	private ArrayList<Litter> litter;
	final double areaOfPhilly = 141.7;
	
	/**
	 * The DataAnalyzer constructor accepts as arguments: arraylists of data indices and a position. 
	 * @param c
	 * @param l
	 * @param latitude
	 * @param longitude
	 */
	public DataAnalyzer(ArrayList<Crime> c, ArrayList<Litter> l, double latitude, double longitude) {
		crimes = c;
		litter = l;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * The getCrimeRating method produces an integer rating between 0-100 based on a comparison to the average crime rate per square mile in the city of Philadelphia
	 * @return crimeRating
	 */
	public int getCrimeRating() {
		double crimeTally = 0;
		double crimeRating = 0;
		for(Crime crime: crimes) {
			//Comparison of user input location with all data events. [.007]=.5 statute miles in latitude/longitude. 
			//This creates a 1 square mile box around the user input location
			if(java.lang.Math.abs(crime.getLatitude()-latitude) < .007 && java.lang.Math.abs(crime.getLongitude() - longitude) < .007) {
				crimeTally++;
			}
		}
//		System.out.println("This position crime tally: "+crimeTally);
		double avgCrimeRate = crimes.size()/areaOfPhilly;
//		System.out.println("Average crime rate (crimes/m^2): "+avgCrimeRate);
		crimeRating = 100 - 15*(crimeTally/avgCrimeRate);
		if(crimeRating > 100) {
			return 100;
		} else if(crimeRating < 0) {
			return 0;
		} else {
			return (int) crimeRating;
		}
		
	}
	/**
	 * The getLitterRating method produces an integer rating between 0-100 based on a comparison to the average litter rate per square mile in the city of Philadelphia
	 * @return litterRating
	 */
	public int getLitterRating() {
		double litterTally = 0;
		double litterRating = 0;
		for(Litter litter1: litter) {
			//Comparison of user input location with all data events. [.007]=.5 statute miles in latitude/longitude. 
			//This creates a 1 square mile box around the user input location
			if(java.lang.Math.abs(litter1.getLatitude()-latitude) < .007 && java.lang.Math.abs(litter1.getLongitude() - longitude) < .007) {
				litterTally++;
			}
		}
		//System.out.println("This position litter tally: "+litterTally);
		double avgLitterRate = litter.size()/areaOfPhilly;
		//System.out.println("Average litter rate (litter/m^2): "+avgLitterRate);
		litterRating = 100 - 15*(litterTally/avgLitterRate);
		if(litterRating > 100) {
			return 100;
		} else if(litterRating < 0) {
			return 0;
		} else {
			return (int) litterRating;
		}
		
		
	}
}

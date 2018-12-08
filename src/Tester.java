import java.text.ParseException;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		LitterParser lit;
		CrimeParser crim;
		try {
			lit = new LitterParser("litter_index_survey.csv");
			crim = new CrimeParser("incidents_part1_part2 (1).csv");
			
			ArrayList<Litter> litter = lit.getLitter();
			ArrayList<Crime> crimes = crim.getCrimes();
			
			/**
			 * Print to test first 10 lines
			 *
			for(int i = 0; i < 10; i++) {
				System.out.println("Litter ID: " + litter.get(i).getLitterId()+" Location: "+litter.get(i).getLongitude()+"N, "+litter.get(i).getLatitude()+"W.");
				System.out.println("Crime ID: "+crimes.get(i).getCrimeId()+" Offense: "+crimes.get(i).getOffense()+" Location: "+crimes.get(i).getLongitude()+"N, "+crimes.get(i).getLatitude()+"W.");
			}
			*/
			
			
			/**
			 * Sample Positions
			 * Fairmount: 39.963296, -75.172907 crimeRating: 81 litterRating: 87
			 * UPenn: 39.953164, -75.194880 crimeRating: 78 litterRating: 92
			 * Kensington: 39.988791, -75.147774 crimeRating: 25 litterRating: 15
			 * Port Richmond: 40.007622, -75.161062 crimeRating: 43 litterRating: 70
			 * Rawnhurst: 40.058409, -75.057235 crimeRating: 96 litterRating: 92
			 */
			DataAnalyzer da = new DataAnalyzer(crimes, litter, 39.988791, -75.147774);
			System.out.println(da.getCrimeRating());
			System.out.println(da.getLitterRating());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
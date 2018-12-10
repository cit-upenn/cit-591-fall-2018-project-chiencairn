import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	LitterParser litterParser;
	CrimeParser crimeParser;
	DataAnalyzer dataAnalyzer;
	SchoolReader schoolReader;
	PermitBlockReader parkingReader;
	SchoolsAnalyzer schoolAnalyzer;
	PermitBlocksAnalyzer parkingAnalyzer;
	
	@BeforeEach
	public void setUp() throws ParseException {
		litterParser = new LitterParser("litter_index_survey.csv");
		crimeParser = new CrimeParser("Crime_incidents.csv");
		dataAnalyzer = new DataAnalyzer(crimeParser.getCrimes(), litterParser.getLitter(), 0.0, 0.0);
		schoolReader = new SchoolReader("schools.csv", "2012_2013_SPR_20140428.csv");
		parkingReader = new PermitBlockReader("residential_parking_permit_blocks.csv");
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of Litter Array
	public void testReadLitterFile() {
		System.out.println("Running testReadLitterFile");
		assertEquals(litterParser.getLitter().size(), 49474);	
	}	
	
	@Test
	//Test Purpose: tests latitude parsing of random line of file
	public void testLitterLatitude() {
		System.out.println("Running testLitterLatitude");
		assertEquals(litterParser.getLitter().get(5).getLatitude(), 39.97290377);	
	}
	
	@Test
	//Test Purpose: tests longitude parsing of random line of file
	public void testLitterLongitude() {
		System.out.println("Running testLitterLongitude");
		assertEquals(litterParser.getLitter().get(5).getLongitude(), -75.2061826);	
	}
	
	@Test
	//Test Purpose: tests latitude parsing of random line of file
	public void testCrimeLatitude() {
		System.out.println("Running testCrimeLatitude");
		assertEquals(crimeParser.getCrimes().get(9).getLatitude(), 39.96796405);	
	}
	
	@Test
	//Test Purpose: tests longitude parsing of random line of file
	public void testCrimeLongitude() {
		System.out.println("Running testCrimeLongitude");
		assertEquals(crimeParser.getCrimes().get(9).getLongitude(), -75.19841015);	
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of Crimes Array
	public void testReadCrimeFile() {
		System.out.println("Running testReadCrimeFile");
		assertEquals(crimeParser.getCrimes().size(), 471422);	
	}
	
	@Test
	//Test Purpose: test that getCrimeRating returns a perfectly safe rating for an address outside of Philadelphia
	public void testGetCrimeRating() {
		System.out.println("Running testGetGrimeRating");
		assertEquals(dataAnalyzer.getCrimeRating(), 100);	
	}	
	
	@Test
	//Test Purpose: test that getLitterRating returns a perfectly clean rating for an address outside of Philadelphia
	public void testGetLitterRating() {
		System.out.println("Running testGetLitterRating");
		assertEquals(dataAnalyzer.getLitterRating(), 99);	
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of School Array
	public void testReadSchoolsFile() throws FileNotFoundException {
		System.out.println("Running testReadSchoolsFile");
		assertEquals(schoolReader.readSchoolFile().size(), 547);	
	}	
	
	@Test
	//Test Purpose: tests file read functionality and building of Permit Blocks Array
	public void testReadPermitBlocksFile() throws FileNotFoundException {
		System.out.println("Running testReadPermitBlocksFile");
		assertEquals(parkingReader.readPermitBlockFile().size(), 1342);	
	}	
	
	@Test
	//Test Purpose: tests parking score functionality when a non-Philly area location is entered
	public void testPermitBlocksAnalyzerZero() throws FileNotFoundException {
		System.out.println("Running testPermitBlocksReaderZero");
		PermitBlocksAnalyzer parkingAnalyzer = new PermitBlocksAnalyzer(parkingReader.readPermitBlockFile(), 0 , 0);
		assertEquals((int)parkingAnalyzer.getParkingScore(), 0);	
	}
	
	@Test
	//Test Purpose: tests parking score functionality when a valid Philly area location is entered
	public void testPermitBlocksAnalyzerValid() throws FileNotFoundException {
		System.out.println("Running testPermitBlocksReaderValid");
		PermitBlocksAnalyzer parkingAnalyzer = new PermitBlocksAnalyzer(parkingReader.readPermitBlockFile(), 39.945712 , -75.183454);
		assertEquals((int)parkingAnalyzer.getParkingScore(), 93);	
	}

	@Test
	//Test Purpose: tests schools score functionality when a non-Philly area location is entered
	public void testSchoolsAnalyzerZero() throws FileNotFoundException {
		System.out.println("Running testSchoolsZero");
		SchoolsAnalyzer schoolAnalyzer = new SchoolsAnalyzer(schoolReader.readSchoolFile(), 0 , 0);
		assertEquals((int)schoolAnalyzer.getSchoolScore(), 0);	
	}
	
	@Test
	//Test Purpose: tests schools score functionality when a valid Philly area location is entered
	public void testSchoolssAnalyzerValid() throws FileNotFoundException {
		System.out.println("Running testSchoolsReaderValid");
		SchoolsAnalyzer schoolAnalyzer = new SchoolsAnalyzer(schoolReader.readSchoolFile(), 39.945712 , -75.183454);
		assertEquals((int)schoolAnalyzer.getSchoolScore(), 36);	
	}
	
	@Test
	//Test Purpose: tests JSON parser to make sure correct latitude is brought back from Google Geocoder
	public void testGeocodeAPILat() throws IOException, JSONException {
		System.out.println("Running testGeocodeAPILat");
		String address = "2606 South St, Philadelphia, PA";
		GeocodeAPI geocoder = new GeocodeAPI();
		String jsonResponse =  geocoder.makeAPICall(address);
		GeocodeLocation location = geocoder.parseGeoCodeJSON(jsonResponse);
		assertEquals(location.getLat(), 39.945712);	
	}
	
	@Test
	//Test Purpose: tests JSON parser to make sure correct longitude is brought back from Google Geocoder
	public void testGeocodeAPILng() throws IOException, JSONException {
		System.out.println("Running testGeocodeAPILng");
		String address = "2606 South St, Philadelphia, PA";
		GeocodeAPI geocoder = new GeocodeAPI();
		String jsonResponse =  geocoder.makeAPICall(address);
		GeocodeLocation location = geocoder.parseGeoCodeJSON(jsonResponse);
		assertEquals(location.getLng(), -75.183454);	
	}
	
}

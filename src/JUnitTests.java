import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	LitterParser litterParser;
	CrimeParser crimeParser;
	DataAnalyzer dataAnalyzer;
	
	@BeforeEach
	public void setUp() throws ParseException {
		litterParser = new LitterParser("litter_index_survey.csv");
		crimeParser = new CrimeParser("Crime_incidents.csv");
		dataAnalyzer = new DataAnalyzer(crimeParser.getCrimes(), litterParser.getLitter(), 0.0, 0.0);
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of Litter Array
	public void testReadLitterFile() throws ParseException {
		System.out.println("Running testReadLitterFile");
		assertEquals(litterParser.getLitter().size(), 49474);	
	}	
	
	@Test
	//Test Purpose: tests latitude parsing of random line of file
	public void testLitterLatitude() throws ParseException {
		System.out.println("Running testLitterLatitude");
		assertEquals(litterParser.getLitter().get(5).getLatitude(), 39.97290377);	
	}
	
	@Test
	//Test Purpose: tests longitude parsing of random line of file
	public void testLitterLongitude() throws ParseException {
		System.out.println("Running testLitterLongitude");
		assertEquals(litterParser.getLitter().get(5).getLongitude(), -75.2061826);	
	}
	
	@Test
	//Test Purpose: tests latitude parsing of random line of file
	public void testCrimeLatitude() throws ParseException {
		System.out.println("Running testCrimeLatitude");
		assertEquals(crimeParser.getCrimes().get(9).getLatitude(), 39.96796405);	
	}
	
	@Test
	//Test Purpose: tests longitude parsing of random line of file
	public void testCrimeLongitude() throws ParseException {
		System.out.println("Running testCrimeLongitude");
		assertEquals(crimeParser.getCrimes().get(9).getLongitude(), -75.19841015);	
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of Crimes Array
	public void testReadCrimeFile() throws ParseException {
		System.out.println("Running testReadCrimeFile");
		assertEquals(crimeParser.getCrimes().size(), 471422);	
	}
	
	@Test
	//Test Purpose: test that getCrimeRating returns a perfectly safe rating for an address outside of Philadelphia
	public void testGetCrimeRating() throws ParseException {
		System.out.println("Running testGetGrimeRating");
		assertEquals(dataAnalyzer.getCrimeRating(), 100);	
	}	
	
	@Test
	//Test Purpose: test that getLitterRating returns a perfectly clean rating for an address outside of Philadelphia
	public void testGetLitterRating() throws ParseException {
		System.out.println("Running testGetLitterRating");
		assertEquals(dataAnalyzer.getLitterRating(), 99);	
	}

}

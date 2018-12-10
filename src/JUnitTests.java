import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	LitterParser litterParser;
	CrimeParser crimeParser;
	LitterParser litterParserEmpty;
	CrimeParser crimeParserEmpty;
	
	@BeforeEach
	public void setUp() throws ParseException {
		litterParser = new LitterParser("litter_index_survey.csv");
		crimeParser = new CrimeParser("Crime_incidents.csv");
	}
	
	@Test
	//Test Purpose: tests file read functionality and building of Litter Array
	public void testReadLitterFile() throws ParseException {
		System.out.println("Running testReadLitterFile");
		assertEquals(litterParser.getLitter().size(), 49474);	
	}	
	
	@Test
	//Test Purpose: tests file read functionality and building of Crimes Array
	public void testReadCrimeFile() throws ParseException {
		System.out.println("Running testReadCrimeFile");
		assertEquals(crimeParser.getCrimes().size(), 471422);	
	}

}

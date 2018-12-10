import java.text.ParseException;

public class JUnitTesting {
	LitterParser litterParser;
	
	public void setUp() throws ParseException {
		litterParser =new LitterParser("litter_index_survey.csv");
	}
	
	//Test Purpose: tests basic functionality
	public void testReadLitterFile() throws ParseException {
		litterParser.readLitterFile();
		assert(litterParser.getLitter().size() == 49474);	
	}	
}

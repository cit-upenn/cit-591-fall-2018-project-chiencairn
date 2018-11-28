import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrimeParser {
	//Instance Variables
	File fileName;
	ArrayList<Crime> crimes;
	
	//Constructors
	CrimeParser(String fileName) throws ParseException{
		this.fileName = new File(fileName);
		crimes = new ArrayList<>();
		readCrimeFile();
	}
	
	/**
	 * The readCrimeFile method accepts a text file and parses data as necessary
	 * @return array List of litter incidents
	 * @throws ParseException
	 */
	
	public void readCrimeFile() throws ParseException {
		
		try  {
			Scanner scan= new Scanner(this.fileName);
			
			//Throws away top row of headers
			scan.nextLine();			
		    
		    while (scan.hasNext()) {
		
		    	String s = scan.nextLine();
		    	String[] list = s.split(",");
		    	
		    	/**
		    	 * Create local variables from each column of the text file to use as arguments in the Litter class.
		    	 */
		    	int crimeId;
		    	String offense;
		    	double longitude;
		    	double latitude;
		    	
		    	if(s.matches("^\\d.*") && list[13].matches("^-.*")) {
		    		
			    	crimeId = Integer.parseInt(list[2]);
			    	offense = list[12];
			    	longitude = -1.0 * Double.parseDouble(list[13]);	//Has to be multiplied by -1 to correct for negative longitude (Used to imply "West")
			    	latitude = Double.parseDouble(list[14]);
		    		
		    		/**
		    		 * Produces an instance of the Trip class with inputs produced and parsed from the text file.
		    		 */
			    	Crime newCrime = new Crime(crimeId, offense, latitude, longitude);
			    	crimes.add(newCrime);
		    	} 
		    	
		    }
		    
		    scan.close();
		 } catch(IOException e) {
			  e.printStackTrace();
		 }	
		
	}
	
	/**
	 * the getCrimes method is used to transfer the returned array list into another class
	 * @return crimes
	 */
	public ArrayList<Crime> getCrimes() {
		return crimes;
	}
}

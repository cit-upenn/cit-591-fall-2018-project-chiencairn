import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The LitterParser class accepts a data file and reads in all pertinent information while 
 * storing each event in an ArrayList of type Litter
 * @author grahampitcairn
 * @version 1.0 12-5-2018
 */
public class LitterParser {
	//Instance Variables
	File fileName;
	ArrayList<Litter> litter;
	
	//Constructors
	LitterParser(String fileName) throws ParseException{
		this.fileName = new File(fileName);
		litter = new ArrayList<>();
		readLitterFile();
	}
	
	/**
	 * The readLitterFile method accepts a text file and parses data as necessary
	 * @return array List of litter incidents
	 * @throws ParseException
	 */
	
	public void readLitterFile() throws ParseException {
		
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
		    	int litterId;
		    	double longitude;
		    	double latitude;
		    	
		    	if(s.startsWith("\"")) {
			    	litterId = Integer.parseInt(list[2]);
			    	longitude = Double.parseDouble(list[13]);
			    	latitude = Double.parseDouble(list[12]);		    		
		    	} else {
			    	litterId = Integer.parseInt(list[1]);
			    	longitude = Double.parseDouble(list[12]);	
			    	latitude = Double.parseDouble(list[11]);
		    	}
	    		/**
	    		 * Produces an instance of the Litter class with inputs produced and parsed from the text file.
	    		 */
		    	Litter newLitter = new Litter(litterId, latitude, longitude);
		    	litter.add(newLitter); 
		    }
		    
		    scan.close();
		 } catch(IOException e) {
			  e.printStackTrace();
		 }	
		
	}
	
	/**
	 * the getLitter method is used to transfer the returned array list into another class
	 * @return litter
	 */
	public ArrayList<Litter> getLitter() {
		return litter;
	}
}

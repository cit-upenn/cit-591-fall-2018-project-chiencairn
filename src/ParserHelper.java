import java.util.Calendar;
import java.util.Scanner;

public class ParserHelper {
	/**
	 * Formats the time as a string and processes them into the appropriate Calendar object for either
	 * the trip or station. Method takes in a string representation of time, removes quotations if any, 
	 * and splits the string into different parts by different delimeters that may be used.
	 * If the resulting array has 6 elements, create and return a calendar object with date and time.
	 * If the resulting array does not have 6 elements (probably 3), create and return a calendar
	 * object with date.
	 * @param time time as a String from file
	 * @return time represented as a Calendar object
	 */
	public static Calendar processTime(String time) {
		String timeString = trimQuotation(time);
		String[] timeParts = timeString.split("/|-|:| ");
		Calendar timeCal = Calendar.getInstance();
		if (timeParts.length==6) {
			timeCal.set(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1])-1, Integer.parseInt(timeParts[2]), Integer.parseInt(timeParts[3]), Integer.parseInt(timeParts[4]), Integer.parseInt(timeParts[5]));
		} else {
			timeCal.set(Integer.parseInt(timeParts[2]), Integer.parseInt(timeParts[0])-1, Integer.parseInt(timeParts[1]));
		}
		return timeCal;
	}
	
	/**
	 * Method processes coordinates from a string. If the coordinates from the file are empty ("")
	 * set the coordinate to 0.0. Otherwise, parse the string to a double.
	 * @param coordString string representation of coordinates
	 * @return coordinate as a double
	 */
	public static double processCoordinate(String coordString) {
		Double coord = 0.0;
		if (!coordString.equals("")) {
			coord = Double.parseDouble(coordString);
		}
		return coord;
	}
	
	public static int processInt(String intString) {
		int num = -1;
		if (!intString.equals("")) {
			num = Integer.parseInt(intString);
		}
		return num;
	}
	
	
	/**
	 * Method removes quotation marks from strings as necessary. If the first character
	 * of the string is a ", we remove the first and last characters of the string to 
	 * ensure the removal of quotation marks.
	 * @param s string from file
	 * @return string trimmed of quotation marks
	 */
	public static String trimQuotation(String s) {
		if (s.charAt(0)=='"') {
			return s.substring(1, s.length()-1);
		}
		return s;
	}
	
	/**
	 * Processes strings from file to handle commas within quotations. Used specifically
	 * for Station file. If the first character of the string is ", we know the next string
	 * read in by the scanner is a part of the previous string. When this occurs, we combine them
	 * and trim quotation marks from the string.
	 * @param scan scanner used to process file
	 * @param token string that has been scanned
	 * @return string that has addressed the commas within quotation marks.
	 */
	public static String processString(Scanner scan, String token) {
		if (token.isEmpty()) {
			return "";
		}
		if(token.charAt(0)=='\"') {
			String temp = scan.next();
			token = token + "," + temp;
			if (!temp.contains("\"")) {
				token = token + "," + scan.next();
			}
		}
		return trimQuotation(token);
	}
}

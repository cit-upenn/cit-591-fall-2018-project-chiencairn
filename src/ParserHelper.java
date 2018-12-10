import java.util.Scanner;

/**
 * Class of helper functions to help parse School and Parking files
 * @author michellechien
 *
 */
public class ParserHelper {
	
	/**
	 * Method to processes integers. Initializes to -1 if no int.
	 * @param intString
	 * @return
	 */
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * File Reader for School File. Combines two files of school dat
 * @author michellechien
 *
 */
public class SchoolReader {
	
	public String schoolFile;
	public String schoolRankingFile;
	
	/**
	 * Constructor for reader file.
	 * @param schoolFile file name of schools
	 * @param schoolRankingFile file name of school progress reports
	 */
	public SchoolReader (String schoolFile, String schoolRankingFile) {
		this.schoolFile = schoolFile;
		this.schoolRankingFile = schoolRankingFile;
	}
	
	/**
	 * Method to read in school blocks from file to an ArrayList of Schools.
	 * Method reads in a second file of school scores for public schools updating
	 * the existing school score.
	 * @return
	 * @throws FileNotFoundException
	 */
	public ArrayList<School> readSchoolFile() throws FileNotFoundException {
		HashMap<Integer,School> schoolScores = new HashMap<Integer,School>();
		ArrayList<School> schools = new ArrayList<School>();
		Scanner scan = new Scanner(new File(schoolFile));
		scan.useDelimiter(",|\n"); //use comma and line delimiter
		scan.nextLine(); //skip header in file
		while (scan.hasNext()) {
			double lng = Double.parseDouble(scan.next());
			double lat = Double.parseDouble(scan.next());
			scan.next(); //skip object ID
			scan.next(); //skip AUN
			int id = ParserHelper.processInt(scan.next());
			scan.next(); //skip location ID
			String name = ParserHelper.processString(scan, scan.next());
			ParserHelper.processString(scan, scan.next());
			for (int i=0; i<5; i++) {
				scan.next();
			}
			String grades = ParserHelper.processString(scan, scan.next());
			int enrollment = ParserHelper.processInt(scan.next());
			String type = scan.next();
			scan.next(); //skip type specific
			School current = new School(name, lat, lng);
			current.setId(id);
			current.setEnrollment(enrollment);
			current.setGradeLevels(grades);
			current.setType(type);
			schoolScores.put(id, current);
			schools.add(current);
		}
		scan.close();
		
		Scanner scan1 = new Scanner(new File(schoolRankingFile));
		scan1.useDelimiter(",|\n"); //use comma and line delimiter
		scan1.nextLine(); //skip header in file
		while (scan1.hasNext()) {
			scan1.next();
			scan1.next();
			int id = ParserHelper.processInt(scan1.next());;
			scan1.next();
			String name = ParserHelper.processString(scan1, scan1.next());
			if (name.contains("CLOSED")) {
				for (int i = 0; i<330; i++) {
					scan1.next();
				}
			} else {
				for (int i = 0; i<12; i++) {
					scan1.next();
				}
				String scoreString = scan1.next();
				int score = 9;
				if (!scoreString.equals("Less than 10")) {
					score = ParserHelper.processInt(scoreString);
				}
				if (schoolScores.containsKey(id)) {
					schoolScores.get(id).setScore(score);
				}
				for (int i = 0; i<317; i++) {
					scan1.next();
				}
			}
		}
		return schools;
	}

}
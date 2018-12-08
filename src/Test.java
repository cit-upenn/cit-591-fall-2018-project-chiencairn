import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		PermitBlockReader pbReader = new PermitBlockReader("residential_parking_permit_blocks.csv");
		ArrayList<PermitBlocks> blocks = new ArrayList<PermitBlocks>();
		try {
			blocks = pbReader.readPermitBlockFile();
			System.out.println(blocks.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SchoolReader sReader = new SchoolReader("schools.csv", "2012_2013_SPR_20140428.csv");
		ArrayList<School> schools = new ArrayList<School>();
		try {
			schools = sReader.readSchoolFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(schools.size());
		
		for (int i=0; i<blocks.size(); i++) {
			System.out.println(blocks.get(i).toString());
		}
		
		for (int i=0; i<schools.size(); i++) {
			System.out.println(schools.get(i).toString());
		}
		
		double lng = -75.165222;
		double lat = 39.952583;
		
		SchoolsAnalyzer schoolAnalysis = new SchoolsAnalyzer(schools, lat, lng);
		PermitBlocksAnalyzer blockAnalysis = new PermitBlocksAnalyzer(blocks, lat, lng);
		
		System.out.println(schoolAnalysis.getSchoolScore());
		System.out.println(blockAnalysis.getParkingScore());
		
	}
	

}

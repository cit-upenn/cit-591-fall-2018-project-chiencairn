import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * File Reader for Permit Blocks File
 * @author michellechien
 *
 */
public class PermitBlockReader {
	private String fileName;
	private Scanner scan;
	
	/**
	 * Constructor for reader
	 * @param fileName name of file to read
	 */
	public PermitBlockReader(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Method to read in permit blocks from file to an ArrayList of PermitBlocks
	 * @return ArrayList of PermitBlocks from file
	 * @throws FileNotFoundException
	 */
	public ArrayList<PermitBlocks> readPermitBlockFile() throws FileNotFoundException {
		ArrayList<PermitBlocks> blocks = new ArrayList<PermitBlocks>();
		scan = new Scanner(new File(fileName));
		scan.useDelimiter(",|\n"); //use comma and line delimiter
		scan.nextLine(); //skip header in file
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] parts = line.split(",");
			PermitBlocks currentBlock = new PermitBlocks(Integer.parseInt(parts[7]), Double.parseDouble(parts[10]), Double.parseDouble(parts[11]));
			currentBlock.setBlock(parts[8]);
			currentBlock.setSide(parts[9]);
			currentBlock.setStreet(parts[2]);
			currentBlock.setGeom(parts[0]);
			currentBlock.setGeomMerc(parts[6]);
			blocks.add(currentBlock);
		}
		return blocks;
	}

}

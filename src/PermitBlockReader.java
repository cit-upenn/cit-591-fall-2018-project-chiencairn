import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PermitBlockReader {
	private String fileName;

	public PermitBlockReader(String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<PermitBlocks> readPermitBlockFile() throws FileNotFoundException {
		ArrayList<PermitBlocks> blocks = new ArrayList<PermitBlocks>();
		Scanner scan = new Scanner(new File(fileName));
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

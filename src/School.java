
public class School {
	private String name;
	private int id;
	private double xCoord;
	private double yCoord;
	private String gradeLevels;
	private int enrollment;
	private String type;
	private double score;
	
	public School(String name, double xCoord, double yCoord) {
		this.name = name;
		this.id = -1;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.gradeLevels  = "";
		this.enrollment = -1;
		this.type = "";
		this.score = 0;
	}

	public String getName() {
		return name;
	}



	public double getxCoord() {
		return xCoord;
	}



	public double getyCoord() {
		return yCoord;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGradeLevels() {
		return gradeLevels;
	}

	public void setGradeLevels(String gradeLevels) {
		this.gradeLevels = gradeLevels;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public String toString() {
		String s = name + "|" + xCoord + "|" + yCoord  + "|" + id  + "|" +  gradeLevels  + "|" + enrollment  + "|" + type  + "|" + score;
		return s;
	}
}

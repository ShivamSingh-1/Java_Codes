package project_1;

public class Project {
	
	private int projectID;
	private String name;
	private double budget;
	
	public Project(int projectID, String name, double budget) {
		this.projectID = projectID;
		this.name = name;
		this.budget = budget;
	}
	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}

}

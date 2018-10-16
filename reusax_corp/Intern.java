package reusax_corp;

public class Intern extends Employee{

	//Encapsulated Attributes
	private int GPA;

	//Constants for GPA Logic
	static final int goodGPA = 5;
	static final int excellentGPA = 8;
	static final int benefit = 1000;
	static final int noSalary = 0;


	//Constructor for class Intern
	public Intern(String name, String id, double grossSalary, int GPA) {
		super(id, name, grossSalary);
		this.GPA = GPA;
	}

	public double getGrossSalary() {
		return this.grossSalary;
	}
	
	public double getGrossSalaryWithGPA() {
		double newSalary = noSalary;
		if (this.GPA >= excellentGPA) {
			newSalary = this.grossSalary + benefit;
		} else if ( this.GPA > goodGPA ) {
			newSalary = this.grossSalary;
		}			 
		return newSalary;
	}

	public int getGPA() {
		return this.GPA;
	}

	public String toString() {
		String allInfo = "ID: " + getId() + "(Position: Intern)" + END_OF_LINE +
		           "Name: " + getName() + END_OF_LINE +
		           "Gross/Net Salary: " + getGrossSalaryWithGPA() + " SEK" + END_OF_LINE +
		           "GPA: " + getGPA() + END_OF_LINE ;
		return allInfo;
	}
}

package reusax_corp;

public class Intern extends Employee {

  // private instance variable
  private int gpa;

  // constant for the Intern
  private static final int MIN_GPA = 0;
  private static final int MAX_GPA = 10;
  private static final int bonusForGoodGPA = 1000;


  // initialize instance variables
  public Intern(String id, String name, double grossSalary, int gpa) {
    super(id, name, grossSalary);

    // limit GPA between 0-10
    if (gpa < MIN_GPA) {
      IO.printL("GPA can't be negative, defaulting to " + MIN_GPA);
      this.gpa = MIN_GPA;
    } else if (gpa > MAX_GPA) {
      IO.printL("GPA can't be more than " + MAX_GPA + ", defaulting to " + MAX_GPA);
      this.gpa = MAX_GPA;
    } else {
      this.gpa = gpa;
    }
  }


  /**
   * Change Intern's GPA
   * @param gpa New value for GPA
   */
  protected void setGpa(int gpa) {
    this.gpa = gpa;
  }


  /**
   * Return gross salary as per gpa
   * @return double
   */
  protected double getGrossSalary() {
    if (gpa >= 5 && gpa < 8) {
      return super.getGrossSalary();
    } else if (gpa >= 8) {
      return super.getGrossSalary() + bonusForGoodGPA;
    } else {
      return 0;
    }
  }


  /**
   * Return net salary
   * @return double
   */
  protected double getNetSalary() {
    return this.getGrossSalary();
  }


  /**
   * A String representation of Intern's object
   * @return String
   */
  public String toString() {
    return "ID: " + getId() + " (Position: Intern)" + END_OF_LINE +
           "Name: " + getName() + END_OF_LINE +
           "Gross Salary: " + this.getGrossSalary() + " SEK" + END_OF_LINE +
           "Net Salary: " + this.getNetSalary() + " SEK" + END_OF_LINE +
           "GPA: " + this.gpa;
  }
}

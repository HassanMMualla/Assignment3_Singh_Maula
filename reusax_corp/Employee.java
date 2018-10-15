package reusax_corp;

public class Employee {

  // private instance variables
  protected String id;
  protected String name;
  protected double grossSalary;

  protected final double TAX_PER = 0.1;
  public static final String END_OF_LINE = System.lineSeparator();


  // initialize an employee
  public Employee(String name, String id, double grossSalary) {
    this.id = id;
    this.name = name;
    this.grossSalary = grossSalary;
  }

  /**
   * Return Employee's ID
   */
  protected String getId() {
    return this.id;
  }


  /**
   * Return Employee's name
   */
  protected String getName() {
    return this.name;
  }


  /**
   * Set Employee name to given value
   */
  protected void setName(String name) {
    this.name = name;
  }


  /**
   * Return Employee's grossSalary
   */
  protected double getGrossSalary() {
    return this.grossSalary;
  }


  /**
   * Set Employee grossSalary to given value
   */
  protected void setGrossSalary(double grossSalary) {
    this.grossSalary = grossSalary;
  }


  /**
   * Return Employee's netSalary depending on tax percentage
   */
  protected double getNetSalary() {
    return (this.grossSalary - (this.grossSalary * TAX_PER));
  }


  /**
   * Check if given object equals to Employee comparing their ID's
   * return true if yes, else return false
   */
  public boolean equals(Object object) {
    if (object instanceof Employee) {
      Employee employee = (Employee) object;
      return employee.getId().equals(this.id);
    }

    return false;
  }


  /**
   * A string representation of 'Employee' object
   */
  public String toString() {
    return "ID: " + this.getId() + " (Position: Regular Employee)" + END_OF_LINE +
        "Name: " + this.getName() + END_OF_LINE +
        "Gross Salary: " + this.getGrossSalary() + " SEK" + END_OF_LINE +
        "Net Salary: " + this.getNetSalary() + " SEK";
  }
}
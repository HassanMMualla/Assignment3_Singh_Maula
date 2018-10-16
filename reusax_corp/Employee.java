package reusax_corp;

/**
 * todo write these comments for all the classes
 * Employee class is responsible for
 */
public class Employee {

  // private instance variables
  private String id;
  private String name;
  private double grossSalary;

  // constants
  protected static final double TAX_PER = 0.1;
  public static final String END_OF_LINE = System.lineSeparator();


  // initialize an employee
  public Employee(String id, String name, double grossSalary) {
    this.id = id;
    this.name = name;
    this.grossSalary = grossSalary;
  }


  /**
   * Return Employee's ID
   * @return String
   */
  protected String getId() {
    return this.id;
  }


  /**
   * Return Employee's name
   * @return String
   */
  protected String getName() {
    return this.name;
  }


  /**
   * Set Employee name to given value
   * @param name Value for new name.
   */
  protected void setName(String name) {
    this.name = name;
  }


  /**
   * Return Employee's grossSalary
   * @return double
   */
  protected double getGrossSalary() {
    return this.grossSalary;
  }


  /**
   * Set Employee grossSalary to given value
   * @param grossSalary Value for new gross salary
   */
  protected void setGrossSalary(double grossSalary) {
    this.grossSalary = grossSalary;
  }


  /**
   * Return Employee's netSalary depending on tax percentage
   * @return double
   */
  protected double getNetSalary() {
    return (this.grossSalary - (this.grossSalary * TAX_PER));
  }


  /**
   * If given object is equal and is an instance of Employee
   * return true, else return false
   *
   * @param object An object to compare to
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
   * @return String
   */
  public String toString() {
    return "ID: " + this.id + " (Position: Regular Employee)" + END_OF_LINE +
           "Name: " + this.name + END_OF_LINE +
           "Gross Salary: " + this.grossSalary + " SEK" + END_OF_LINE +
           "Net Salary: " + this.getNetSalary() + " SEK";
  }
}

package reusax_corp;

public class Manager extends Employee {

  // private instance variables
  protected String degree;
  private double bonusPercentage;

  // final values for bonus percentages depending on degree
  private static final double BONUS_PER_FOR_BSC = 0.1;
  private static final double BONUS_PER_FOR_MSC = 0.2;
  private static final double BONUS_PER_FOR_PHD = 0.35;


  // initialize super
  public Manager(String id, String name, double grossSalary, String degree) {
    super(id, name, grossSalary);
    setDegree(degree);
  }


  /**
   * Return Manager's degree
   */
  protected String getDegree() {
    return this.degree;
  }


  /**
   * Set Manager's degree and bonus percentage depending on the degree
   */
  protected void setDegree(String degree) {
    if (degree.equalsIgnoreCase("bsc")) {
      this.bonusPercentage = BONUS_PER_FOR_BSC;   // bonus of 10%
    } else if (degree.equalsIgnoreCase("msc")) {
      this.bonusPercentage = BONUS_PER_FOR_MSC;   // bonus of 20%
    } else if (degree.equalsIgnoreCase("phd")) {
      this.bonusPercentage = BONUS_PER_FOR_PHD;   // bonus of 35%
    }

    // change degree
    this.degree = degree;
  }


  /**
   * Return Manager's gross salary with bonus percentage
   */
  protected double getGrossSalary() {
    double grossSalary = super.getGrossSalary();
    return grossSalary + (this.bonusPercentage * grossSalary);
  }


  /**
   * Return Employee's netSalary depending on tax percentage
   */
  protected double getNetSalary() {
    return (this.getGrossSalary() - (TAX_PER * this.getGrossSalary()));
  }


  /**
   * A string representation of 'Manager' object
   */
  public String toString() {
    return "ID: " + getId() + " (Position: Manager)" + END_OF_LINE +
        "Name: " + getName() +  END_OF_LINE +
        "Gross Salary: " + this.getGrossSalary() + " SEK" + END_OF_LINE +
        "Net Salary: " + this.getNetSalary() + " SEK" + END_OF_LINE +
        "Degree: " + this.degree.toUpperCase() + END_OF_LINE +
        "Bonus Percentage: " + this.bonusPercentage;
  }
}

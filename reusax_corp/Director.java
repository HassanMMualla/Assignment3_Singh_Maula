package reusax_corp;

public class Director extends Manager {

  // private instance variables
  private String department;

  // final instance variables
  private static final double TAX_PER_FOR_SALARY_BELOW_30000 = 0.1;
  private static final double TAX_PER_FOR_SALARY_BETWEEN_30000_AND_50000 = 0.2;
  private static final double TAX_PER_FOR_SALARY_ABOVE_50000 = 0.4;

  // tax percentage limits
  private static final int MIN_LIMIT = 30000;
  private static final int MAX_LIMIT = 50000;


  // initialize instance variables
  public Director(String name, String id, double grossSalary, String degree, String department) {
    super(id, name, grossSalary, degree);
    this.department = department;
  }


  /**
   * Get Director's gross salary
   */
  protected double getGrossSalary() {
    double grossSalary = super.getGrossSalary();
    return grossSalary + Reusax.getBenefit();
  }


  /**
   * Return Director's net salary
   */
  protected double getNetSalary() {
    double grossSalary = this.getGrossSalary();

    if (grossSalary >= MIN_LIMIT && grossSalary < MAX_LIMIT) {
      return grossSalary - (TAX_PER_FOR_SALARY_BETWEEN_30000_AND_50000 * grossSalary);
    } else if (grossSalary >= MIN_LIMIT) {
      return grossSalary - (TAX_PER_FOR_SALARY_BETWEEN_30000_AND_50000 * MIN_LIMIT) - (TAX_PER_FOR_SALARY_ABOVE_50000 * (grossSalary - MIN_LIMIT));
    }

    return grossSalary - (TAX_PER_FOR_SALARY_BELOW_30000 * grossSalary);
  }


  /**
   * A string representation of 'Director' object
   */
  public String toString() {
    return "ID: " + getId() + " (" + this.department.toUpperCase() + ")-(Position: Director)" + END_OF_LINE +
        "Name: " + getName() + END_OF_LINE +
        "Gross Salary: " + this.getGrossSalary() + " SEK" + END_OF_LINE +
        "Net Salary: " + this.getNetSalary() + " SEK" + END_OF_LINE +
        "Degree: " + getDegree().toUpperCase() + END_OF_LINE +
        "Benefit: " + Reusax.getBenefit();
  }
}

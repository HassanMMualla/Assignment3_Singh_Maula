package reusax_corp;

import java.util.Comparator;

public class CompareEmployees implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
      int flag = o1.getName().compareTo(o2.getName());

      if(flag == 0) {
        flag = (int) (o1.getGrossSalary() - o2.getGrossSalary());
      }

      return flag;
  }


  /**
   * Sort employees list based on name
   */
  protected static Comparator<Employee> compareByName = new Comparator<Employee>() {

    @Override
    public int compare(Employee employee1, Employee employee2) {
      return employee1.getName().compareTo(employee2.getName());
    }
  };


  /**
   * Sort employees list based on net salary
   */
  protected static Comparator<Employee> compareByNetSalary = new Comparator<Employee>() {

    @Override
    public int compare(Employee employee1, Employee employee2) {
      return (int) (employee1.getNetSalary() - employee2.getNetSalary());
    }
  };
}

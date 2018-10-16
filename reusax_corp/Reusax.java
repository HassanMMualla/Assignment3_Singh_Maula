package reusax_corp;

import java.util.ArrayList;

public class Reusax{
	
	//Attribute for the class Reusax
	private ArrayList <Employee> employeesList;
	
	public Reusax(){
		this.employeesList = new ArrayList< Employee >();
	}
	
	public String newEmployee(String name, String ID, double grossSalary) {			
		boolean flag = IdDubplicateChecker(ID);	
		if(! (employeesList.isEmpty()))	
			if ( flag )
					return "error";
		Employee newEmployee = new Employee(name, ID, grossSalary);
		employeesList.add(newEmployee);
		return "Employee is successfully created";
	}
	
	public String newDirector(String name, String ID, double grossSalary, String degree, String department) {
		boolean flag = IdDubplicateChecker(ID);
		if(! (employeesList.isEmpty()))	
			if ( flag )
					return "error";
		Employee newDirector = new Director(name, ID, grossSalary, degree, department);
		employeesList.add(newDirector);
		return "Director successfully created";
	}
	
	public String newManager(String name, String ID, double grossSalary, String degree) {
		boolean flag = IdDubplicateChecker(ID);
		if(! (employeesList.isEmpty()))	
			if ( flag )
					return "error";
		Employee newManager = new Manager(name, ID, grossSalary, degree);
		employeesList.add(newManager);
		return "Manager is successfully created";
	}

	public String newIntern(String name, String ID, double grossSalary, int GPA) 
	{
		boolean flag = IdDubplicateChecker(ID);
		if(! (employeesList.isEmpty()))	
			if ( flag )
					return "error";
		Employee newIntern = new Intern(name, ID, grossSalary, GPA);
		employeesList.add(newIntern);
		return "Intern student successfully created";
	}

	public Employee findEmployee(String ID) {
			for (Employee foundEmployee: employeesList) {
				if ( foundEmployee.getId().equals(ID) && ! foundEmployee.equals(null))
					return foundEmployee;
			}
		return null;
	}

	public String removeEmployee(String ID)
	{
		if (checkIfListIsEmpty())
			return "empty";
		if (! IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		employeesList.remove(employee);
		return "Employee removed";
	}

	public String retrieveEmployee(String ID) 
	{		
		Employee employee = null;
		if (checkIfListIsEmpty()) 
			return "empty";
		if (! IdDubplicateChecker(ID))
			return "error";
		for (Employee foundEmployee : employeesList)
			if (foundEmployee.getId().equals(ID))
				employee = foundEmployee;
		String retrievedEmployee = employee.toString();
			return retrievedEmployee; 
	}
	
	public String updateEmployee(String ID, int whatToUpdate, String name, double grossSalary) 
	{
		name ="";
		grossSalary = 1;
		if (checkIfListIsEmpty()) 
			return "empty";
		if (! IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		if (employee.equals(null))
			return "error";
		if (whatToUpdate == 1) 
		{
			employee.setName(name);
			return "success";
		}
		if (whatToUpdate == 2) {
			employee.setGrossSalary(grossSalary);
			return "success";
		}
	return "error";
	}
	
	public double calculateTotalGross() 
	{
		if (checkIfListIsEmpty()) 
			return -1;
		double sumOfGross = 0;
		for (Employee anEmployee : employeesList) {
			if (! anEmployee.equals(null)) {
				sumOfGross += anEmployee.getGrossSalary();
			}	
		}
		return sumOfGross;
	}
	
	public double calculateTotalNet() 
	{
		if (checkIfListIsEmpty()) {
			return -1;
		}
		double sumOfNet = 0;
		for (Employee anEmployee : employeesList) {
			if (! anEmployee.equals(null)) {
				sumOfNet += anEmployee.getNetSalary();
			}
				
		}
		return sumOfNet;
	}
	
	public String promoteToEmployee(String ID) 
	{
		
		if (checkIfListIsEmpty())
			return "empty";
		if (! IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		Employee newEmployee = (Employee) employee;
		employeesList.add(newEmployee);
		employeesList.remove(employee);
		
		return "success";
	}
	
	public String promoteToIntern(String ID, int gpa) 
	{
		if (checkIfListIsEmpty())
			return "empty";
		if ( ! IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		String currentEmployeeType = determineEmployeeType(employee);
		if (currentEmployeeType.equals("Intern"))
			return "not updateble";
		String name = employee.getName();
		double grossSalary = employee.getGrossSalary();
		Employee newintern = new Intern(name, ID, grossSalary, gpa);
		employeesList.add(newintern);
		employeesList.remove(employee);
		return "success";
	}
	
	public String promoteToManager(String ID, String degree)
	{
		if (checkIfListIsEmpty())
			return "empty";
		if (!IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		String currentEmployeeType = determineEmployeeType(employee);
		if (currentEmployeeType.equals("Manager"))
			return "not updateble";
		Employee newManager;
		if (currentEmployeeType.equals("Director")) { 
			newManager = (Manager) employee;
		} else {
			String name = employee.getName();
			double grossSalary = employee.getGrossSalary();
			newManager = new Manager(name, ID, grossSalary, degree);
		}
		employeesList.add(newManager);
		employeesList.remove(employee);
		return "success";
	}
	
	public String promoteToDirector(String ID, String degree, String department) {
		if (checkIfListIsEmpty())
			return "empty";
		if (IdDubplicateChecker(ID))
			return "error";
		Employee employee = findEmployee(ID);
		String currentEmployeeType = determineEmployeeType(employee);
		if (currentEmployeeType.equals("Director"))
			return "not updateble";
		String name = employee.getName();
		double grossSalary = employee.getGrossSalary();
		if (currentEmployeeType.equals("Manager"))
		{
			Manager tempManager = (Manager) employee;
			degree = tempManager.getDegree();
		}
		Employee newDirector = new Director(name, ID, grossSalary, degree, department);
		employeesList.add(newDirector);
		employeesList.remove(employee);
		return "success";
	}
	
	public int printTotalRegistered() 
	{
		return employeesList.size();	
	}
	
	public boolean checkIfListIsEmpty() 
	{
		boolean checker;
		if (employeesList.isEmpty()) {
			checker = true;
			return checker;
		} else {
			checker = false;
			
		}
		return checker;
	}

	public String determineEmployeeType(Employee foundEmployee) 
	{
		
		//It is important to place the Director before the manager, why tho hahahahahahahahahahahahahahahahah, I know
		if (foundEmployee instanceof Director)
			return "Director";
		if (foundEmployee instanceof Manager) 
			return "Manager";
		if (foundEmployee instanceof Intern)
			return "Intern"; 
		return "normal employee";	
	}
	
	public boolean IdDubplicateChecker(String id)
	{
		for (Employee foundEmployee: employeesList) {
			if ( foundEmployee.getId().equals(id))
				return true;
		}
		return false;
	}
}
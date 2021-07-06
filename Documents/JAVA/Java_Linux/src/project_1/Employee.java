package project_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Employee extends User {
	
	private Address address;
	private Project project;
	private double salary;
	
	
	public Employee(String id, String name, Address address, Project project, double salary) {
		super(id, name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static void main(String[] args) {
		
		ArrayList<User> ls = new ArrayList<User>();
		
		ls.add(new User("Emp_01","Rahul"));
		ls.add(new User("Emp_05","Rocky"));
		ls.add(new User("Emp_09","James"));
		
		ls.add(new Employee("Emp_02","Albert",new Address("NYC","202"),new Project(01,"Budget Tracker",1000.0),300.0));
		ls.add(new Employee("Emp_03","Swan",new Address("Paris","503"),new Project(01,"Budget Tracker",1000.0),500.0));
		ls.add(new Employee("Emp_04","Sam",new Address("London","603"),new Project(01,"Budget Tracker",1000.0),600.0));
		ls.add(new Employee("Emp_06","Stephen",new Address("Bangalore","475"),new Project(02,"Color Generator",1200.0),400.0));
		ls.add(new Employee("Emp_07","Mark",new Address("Delhi","203"),new Project(02,"Color Generator",1200.0),500.0));
		ls.add(new Employee("Emp_08","Rohdy",new Address("Singapore","485"),new Project(02,"Color Generator",1200.0),200.0));

	
       List<Employee> emp = new ArrayList<Employee>();
		
	  for(User ob: ls){    //filtering employees from list of users
		  
		  if(ob instanceof Employee){
			  
			  emp.add((Employee)ob);
			  
		  }
		  
	  }
	  
	  Collections.sort(emp,new Comparator<Employee>() {   //sorting "emp" using custom comparator

		@Override
		public int compare(Employee obj1, Employee obj2) {
			
			if(obj1.getProject().getProjectID() == obj2.getProject().getProjectID()){
				
				return (int)(obj2.getProject().getBudget() - obj1.getProject().getBudget());
				
			}else {
				
				return (int)(obj1.salary - obj2.salary);
				
			}
			
		}
		 
	  });
	  
	  HashSet<Integer> hs = new HashSet<Integer>();
	  
	  for(Employee ob: emp) {    //storing the IDs of total different projects 
	  
	   if(!(hs.contains(ob.getProject().getProjectID()))){
		   
		   hs.add(ob.getProject().getProjectID());
		   
	   }
	  
	  }
	  
	  Iterator<Integer> itr = hs.iterator();
	  
	  while(itr.hasNext()){       //logic for Utilizing the maximum budget for a particular project 
	  
		int pID = itr.next();  
		
		int sum = 0;
		
		System.out.println("For Project ID --> " + pID);
		
	    for(Employee ob:emp){
		  
		   if(ob.getProject().getProjectID() == pID){
			   
			   if((sum + ob.salary) <= ob.getProject().getBudget()){
				   
				   sum += ob.salary;
				   
				   System.out.println(pID + "-->" + ob.getId());
				   
			   }
			   
		   }
		   
		  
	     }
	    
	    
	    System.out.println();
	    
	
	  }
	
	
	}


}

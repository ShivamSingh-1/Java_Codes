package collections_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> ls = new ArrayList<Employee>();
		
		ls.add(new Employee("BLR",1000));
		ls.add(new Employee("DEL",1200));
		ls.add(new Employee("BOM",1000));
		
		Collections.sort(ls,new MyComp());
		
		for(Employee ob:ls){
			
			System.out.println(ob.city +"---"+ob.salary);
		}
		
		
	}

}

class Employee{
	
	String city;
	int salary;
	
	public Employee(String city,int salary){
		
		this.city = city;
		this.salary = salary;
		
	}

}

class MyComp implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(!(o1.city.equals(o2.city))){
			
			return o1.city.compareTo(o2.city);
			
		}
		
		
		return (o1.salary - o2.salary);
	}
	
}












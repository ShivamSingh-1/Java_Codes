package mini_project;

import java.util.*;

public class Main_Class {
	
	private static List<Customer> ls; 

	public static void main(String[] args) {
		
		ls = new ArrayList<Customer>();
		
		ls.add(new Customer("Stark",300501001,10000,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Maven",300501023,70000,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Bob",300501005,80000,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Jim",300501020,30006,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Sam",300501021,50008,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Rock",300501011,60010,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Harry",300501051,90000,new Transaction(new ArrayList<String>(),0)));
		ls.add(new Customer("Gwen",300501061,50000,new Transaction(new ArrayList<String>(),0)));
        
		
		//performing credit/debit operation on a different account_NO 
		
		ls.get(7).debit(2300);
		ls.get(7).debit(2300);
		ls.get(7).debit(100000);
		ls.get(7).credit(4000);
		ls.get(4).credit(1200);
		ls.get(4).credit(1200);
		ls.get(4).debit(20000);
		ls.get(3).credit(2000);
		ls.get(2).debit(10000);
		
		
		System.out.print("Accout No -> ");   //fetching details of a particular account number
		System.out.println(ls.get(4).getAccount_NO());
		System.out.println("Transaction Details are as follows :->");
		
       ls.get(4)            //getting details of all transactions done by above account holder
		.getTransaction()
		.getLs()
		.stream()
		.forEach(n -> System.out.println(n));
		
		
	    System.out.println(	"Total Transactions:-> " + ls.get(4)
		                                            .getTransaction()
		                                            .getTotalTransaction());
        
	    System.out.println("----------");
	
	
		System.out.print("Accout No -> ");  //fetching details of a particular account number
		System.out.println(ls.get(7).getAccount_NO());
		System.out.println("Transaction Details are as follow :->");
	
	  ls.get(7)                 //getting details of all transactions done by above account holder
		.getTransaction()
		.getLs()
		.stream()
		.forEach(n -> System.out.println(n));
		
		
		System.out.println(	"Total Transactions:-> " + ls.get(7)
        .getTransaction()
        .getTotalTransaction());
		
		
		System.out.println("----------");
		
 Optional<Long> tmp =  ls.stream()           //for fetching maximum transactions done by an individual 
		               .map(n -> n.getTransaction().getTotalTransaction())
		               .reduce(Math::max);
		
        System.out.println("Maximum Transaction -> " + tmp);      
        
        System.out.println("----------");
        
        CustomComparator cus = new CustomComparator();
        
        ls.stream()                  //sorting names of Account holders (customers) in decreasing order of their total transactions they did
            .sorted(cus::compare)
            .forEach(n -> System.out.println(n.getName() + " ----> " + n.getTransaction().getTotalTransaction()));
        
        
		
	}

}



class CustomComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
	         
		return (int)(o2.getTransaction().getTotalTransaction() - o1.getTransaction().getTotalTransaction());
		
	}
	
}






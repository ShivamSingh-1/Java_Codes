package collections_project_08_07_2021;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> ls = new ArrayList<User>();
		
		ls.add(new User(2,"User2",new Address()));
		ls.get(0).getAddress().getLs().add(new Structure("DEL",110001));
		ls.get(0).getAddress().getLs().add(new Structure("BLR",560001));
		
		ls.add(new User(1,"User1",new Address()));
		ls.get(1).getAddress().getLs().add(new Structure("GUR",201305));
		ls.get(1).getAddress().getLs().add(new Structure("BLR",560001));
		
		ls.add(new User(3,"User3",new Address()));
		ls.get(2).getAddress().getLs().add(new Structure("GUR",201305));
		ls.get(2).getAddress().getLs().add(new Structure("BLR",560001));
		
		ls.add(new User(4,"User4",new Address()));
		ls.get(3).getAddress().getLs().add(new Structure("GUR",201305));
         
		System.out.println("Structure Before:-->");
		
		   for(User obj : ls){
	    	   
	    	   System.out.print("User ID:-> " + obj.getId()  + " " + "User Name:-> " + obj.getName() + "    ");
	    	   
	    	   System.out.print("Address:->  ");
	    	   
	    	   for(Structure objj : obj.getAddress().getLs()){
	    		   
	    		   System.out.print("[ " + "City:-> " + objj.getCity() + " "+ "Zipcode:-> " + objj.getZipcode() + " ]");
	    		   
	    	   }
	    	   
	    	   System.out.println();
	    	   
	       }
		   
		   System.out.println();
		
		
		List<User> lss = ls.stream().filter(n -> n.getAddress().getLs().size() >= 2).collect(Collectors.toList());
		
		HashSet<String> hs = new HashSet<>();
		
		List<Structure> uniqueCity = new ArrayList<>();  //for storing total different cities available (Distinct Cities)
		
		for(User obj : lss) {   //traversing list of Users
			
			List<Structure> addressList = obj.getAddress().getLs();
			
			for(Structure objj : addressList ){  //traversing list of different cities associated with a particular user
				
				if(!(hs.contains(objj.getCity()))){
			         
					hs.add(objj.getCity());
					
					uniqueCity.add(objj);
					
				}
				
			}
			
			
		}
		
		MyComparator myc = new MyComparator();
		
		uniqueCity = uniqueCity.stream().sorted(myc::compare).collect(Collectors.toList());
		
	//	uniqueCity.stream().forEach(n -> System.out.println(n.getCity() + " "));
		
		/*
		 *Now ,We will form the required structure as given in the question 
		 * 
		 * "uniqueCity" contains all distinct cities  
		 */
		
		
//	List<NewAddress> ans = new ArrayList<>();	
//		
//      for(Structure st : uniqueCity){      //Adding users to a particular address
//			
//    	  String str = st.getCity();
//    	  
//    	  ans.add(new NewAddress(st,new ArrayList<User>()));
//    	  
//    	  for(User obj : lss){
//    		  
//    		  for(Structure objj : obj.getAddress().getLs()) {
//    			  
//    			  if(objj.getCity().equals(str)){
//    				  
//    				  int idx = (ans.size() - 1); 
//    				  
//    				  ans.get(idx).getLs().add(obj);
//    				  
//    				  
//    			  }
//    			  
//    			  
//    		  }
//    		  
//    	  }
    	  
		
		// Now we will use Map to store the new structure in HashMap
		
    	  Map<Structure,List<User>> hm = new HashMap<>();	
    	  
    	  for(Structure st : uniqueCity){      //Adding users to a particular address
  			
        	  String str = st.getCity();
        	  
        	//  ans.add(new NewAddress(st,new ArrayList<User>()));
        	  
        	hm.put(st,new ArrayList<>());  
        	  
        	  for(User obj : lss){
        		  
        		  for(Structure objj : obj.getAddress().getLs()) {
        			  
        			  if(objj.getCity().equals(str)){
        				  
        				 // int idx = (ans.size() - 1); 
        				 
        				  List<User> lis = hm.get(st);
        				  
        				//  ans.get(idx).getLs().add(obj);
        				  
        				  lis.add(obj);
        				  
        				  
        			  }
        			  
        			  
        		  }
        		  
        	  }
    	  
    	  
    	//  int idx = (ans.size() - 1); 
        	  
        	List<User> lis = hm.get(st);  
    	  
    	  Collections.sort(lis, new Comparator<User>() {  //sorting Users according to their UserIds

			@Override
			public int compare(User o1, User o2) {
				
				return (o1.getId() - o2.getId());
				
				
				
			}
    		 
    	  });
    
		}
      
//      System.out.println("Structure After:-->"); 
//      
//       for(NewAddress obj : ans){
//    	   
//    	   System.out.print("City:-> " + obj.getStructure().getCity()  + " " + "Zipcode:-> " + obj.getStructure().getZipcode() + "    ");
//    	   
//    	   System.out.print("Users:->  ");
//    	   
//    	   for(User objj : obj.getLs()){
//    		   
//    		   System.out.print("[ " + "User ID:-> " + objj.getId() + " "+ "User Name:-> " + objj.getName() + " ]");
//    		   
//    	   }
//    	   
//    	   System.out.println();
//    	   
//       }
    	  
    	  System.out.println("Structure After:-->"); 
          
          for(Entry<Structure, List<User>> obj : hm.entrySet()){
       	   
       	   Structure objj = obj.getKey();
       	   
       	   System.out.print("City:-> " + objj.getCity()  + " " + "Zipcode:-> " + objj.getZipcode() + "    ");
       	   
       	   System.out.print("Users:->  ");
       	   
       	   List<User> les = obj.getValue();
       	   
       	   for(User obje : les){
       		   
       		   System.out.print("[ " + "User ID:-> " + obje.getId() + " "+ "User Name:-> " + obje.getName() + " ]");
       		   
       	   }
       	   
       	   System.out.println();
       	   
          }
      	

	}

}


class MyComparator implements Comparator<Structure>{

	@Override
	public int compare(Structure o1, Structure o2) {
		
		return (o1.getCity().compareTo(o2.getCity()));
		
	}
	
	
}







package collections_project_09_07_2021;

import java.util.*;
import java.util.Map.Entry;


public class MainClass {

	public static void main(String[] args){
		
		List<User> ls = new ArrayList<User>();
		
		ls.add(new User(3,"User3",new Address()));
		ls.get(0).getAddress().getLs().add(new Structure("BLR",560001));
		ls.get(0).getAddress().getLs().add(new Structure("BLR",560002));
		ls.get(0).getAddress().getLs().add(new Structure("DEL",110001));
		
		ls.add(new User(44,"User44",new Address()));
		ls.get(1).getAddress().getLs().add(new Structure("BLR",560038));
		ls.get(1).getAddress().getLs().add(new Structure("DEL",110096));
		ls.get(1).getAddress().getLs().add(new Structure("DEL",110001));
		
		ls.add(new User(2,"User2",new Address()));
		ls.get(2).getAddress().getLs().add(new Structure("BOM",400018));
		ls.get(2).getAddress().getLs().add(new Structure("BOM",400037));
		ls.get(2).getAddress().getLs().add(new Structure("DEL",110001));
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
		
		
		   
			HashSet<Integer> hs = new HashSet<>();
			
			List<Structure> uniqueZipcode = new ArrayList<>();  //for storing total different zipcodes available (Distinct Zipcodes)
			
			for(User obj : ls) {   //traversing list of Users
				
				List<Structure> addressList = obj.getAddress().getLs();
				
				for(Structure objj : addressList){  //traversing list of different zipcodes associated with a particular user
					
					if(!(hs.contains(objj.getZipcode()))){
				         
						hs.add(objj.getZipcode());
						
						uniqueZipcode.add(objj);
						
					}
					
				}
				
				
			}
			
			
		//	uniqueZipcode.forEach(n -> System.out.println(n.getCity() + " " + n.getZipcode()));
		   
			Comparator<User> cmp = (User o1,User o2) -> {return (o1.getId() - o2.getId());}; 		
			
			  List<NewStructure> lsHub = new ArrayList<>();	
	    	  
	    	  for(Structure st : uniqueZipcode){      //Adding users to a particular unique Zipcode
	  			
	           int zip = st.getZipcode();
	        	  
	        	lsHub.add(new NewStructure(st,new ArrayList<User>())); 
	        	  
	        	  for(User obj : ls){  
	        		  
	        		  for(Structure objj : obj.getAddress().getLs()){
	        			  
	        			  if(objj.getZipcode() == zip){
	        				 
	        				  int size = (lsHub.size() - 1);
	        				  
	        				  List<User> lis = lsHub.get(size).getLs();
	        				  
	        				  lis.add(obj);
	        				  
	        				  
	        			  }
	        			  
	        			  
	        		  }
	        		  
	        	  }
	        	  
	        	  Collections.sort(lsHub.get(lsHub.size() - 1).getLs(),cmp);
	        	  
	    	    
	    	  }
	    	  
	    	  
	    	  Comparator<NewStructure> cmp2 = (NewStructure o1,NewStructure o2) -> {
	    		
	    		  if(o2.getLs().size() != o1.getLs().size()){
	    			  
	    			  return (o2.getLs().size() - o1.getLs().size());
	    			  
	    		  }else {
	    			  
	    			   if(o1.getStructure().getCity().compareTo(o2.getStructure().getCity()) != 0) {
	    				   
	    				   
	    				  return o1.getStructure().getCity().compareTo(o2.getStructure().getCity());
	    				   
	    			   }else {
	    				   
	    				   return o1.getStructure().getZipcode() - (o2.getStructure().getZipcode());
	    				   
	    			   }
	    			  
	    		  }
	    		  
	    		
	    	  };
	    	  
	    	  Collections.sort(lsHub, cmp2);
	    	  
	
    //	     lsHub.forEach(n -> System.out.println(n.getStructure().getZipcode() + "  " +  n.getLs().size()));
	    	  
	    	 
	  		Map<Structure,List<User>> hmHubCities = new HashMap<>();
	  		
	  	    for(NewStructure obj : lsHub) {
	  	    	
	  	    	if(obj.getLs().size() >= 2){

		  	    	Structure key = obj.getStructure();
		  	    	
		  	    	List<User> value = obj.getLs();
		  	    	
		  	    	hmHubCities.put(key, value);
		  	  
	  	    	}
	  	    	
	  	    	
	  	    }
	    
	    	  
	  	System.out.println("Structure After:-->"); 
	  	  
	  	System.out.println("Popular Cities");
          
          for(Entry<Structure, List<User>> obj : hmHubCities.entrySet()){
       	   
       	   Structure objj = obj.getKey();
       	   
       	   System.out.print("City:-> " + objj.getCity()  + " " + "Zipcode:-> " + objj.getZipcode() + "    ");
       	   
       	   System.out.print("Users:->  ");
       	   
       	   List<User> les = obj.getValue();
       	   
       	   for(User obje : les){
       		   
       		   System.out.print("[ " + "User ID:-> " + obje.getId() + " "+ "User Name:-> " + obje.getName() + " ]");
       		   
       	   }
       	   
       	   System.out.println();
       	   
          } 
          
	  	    
	    	Map<Structure,List<User>> hmLessPopularCities = new TreeMap<>(new MyComparator());
	    	
	    	 for(NewStructure obj : lsHub) {
		  	    	
		  	    	if(obj.getLs().size() < 2){

			  	    	Structure key = obj.getStructure();
			  	    	
			  	    	List<User> value = obj.getLs();
			  	    	
			  	    	hmLessPopularCities.put(key, value);
			  	  
		  	    	}
		  	    	
		  	    	
		  	    }
	    	 
	    	System.out.println("------------");
	    	 
	    	 
	    	 System.out.println("Less Popular Cities"); 
	          
	          for(Entry<Structure, List<User>> obj : hmLessPopularCities.entrySet()){
	       	   
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

 class NewStructure {    //New Structure according for Zipcodes 
		
		private Structure structure;
		private List<User> ls;
		
		public NewStructure(Structure structure, List<User> ls) {
			this.structure = structure;
			this.ls = ls;
		}
		public Structure getStructure() {
			return structure;
		}
		public void setStructure(Structure structure) {
			this.structure = structure;
		}
		public List<User> getLs() {
			return ls;
		}
		public void setLs(List<User> ls) {
			this.ls = ls;
		}
		

	}

	

class MyComparator implements Comparator<Structure>{

	@Override
	public int compare(Structure o1, Structure o2) {
		
		if(o1.getCity().compareTo(o2.getCity()) != 0) {
			
			return o1.getCity().compareTo(o2.getCity());
			
		}else {
			
			return (o1.getZipcode() - o2.getZipcode());
			
		}
		
		
	}
	
}


/**
*
*Project :--->
*
* List: [
*          User{id:3,name: User3, address: [
*                                          { city: BLR, zipCode: 560001 },
*                                          { city: BLR , zipCode: 560002 },
*                                          { city: DEL, zipCode: 110001}]}
*         User{id:44,name: User44, address: [
*  *                                          { city: BLR, zipCode: 560038 },
*  *                                          { city: DEL , zipCode: 110096 },
*  *                                          { city: DEL, zipCode: 110001}]}
*          User{id:2,name: User2, address: [
*  *  *                                          { city: BOM, zipCode: 400018 },
*  *  *                                          { city: BOM , zipCode: 400037 },
*  *  *                                          { city: DEL, zipCode: 110001 }
*                                                { city: BLR, zipCode: 560001 }]}
*                                          ]
*  Build a ranking system for cities based on employees functioning from there, to identify / designate a city as hub office
*  [
*      { city:DEL, zipCode:110001 }, [
*                                         User{id:2, name: User2 }, User{id:3, name: User3 }, User{id:44, name: User44 }
*                                  ],
*      { city:BLR, zipCode:560001 }, [
*  *                                         User{id:2, name: User2 }, User{id:3, name: User3 }
*  *                                  ],
*       *                                  ],
*          { city: BLR, zipCode: 560002 },[
*  *  *  *                                         User{id:3, name: User3 }
*  *  *  *                                  ],
*  *    { city: BOM, zipCode: 400018 },[
*  *  *  *                                         User{id:2, name: User2 }
*  *  *  *                                  ],
*  *
*  *      { city: BOM, zipCode: 400037 },[
*  *  *  *  *                                         User{id:2, name: User2 }
*  *  *  *
*  *
*  ]
*
*
*
* */











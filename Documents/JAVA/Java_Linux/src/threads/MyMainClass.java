package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMainClass {

	public static void main(String[] args) {
		
EmpService2 empService = new EmpService2();
        
        Thread empThread1 = new Thread(empService);
        Thread empThread2 = new Thread(empService);
        
        empThread1.setPriority(7); //setting priority for thread
        
        // start the thread
        empThread1.start();
        empThread2.start();
        
       
	}

}

class EmpService2 implements Runnable{

    private List<Integer> integers = Collections.emptyList();

    @Override
    public void run() {
        integers = new ArrayList<>();

        for (int i = 100; i > 0 ; i--){
        	
        	if((i % 2 == 0) && (Thread.currentThread().getPriority() == 7)){
        		
 
        			integers.add(i);
        			
        			System.out.println(Thread.currentThread().getName() + " ----> "+i);
      	
        	}else {
        		 
                     if((i % 2 != 0) && Thread.currentThread().getPriority() == 5) {
                  
        			 integers.add(i);
        			 
        			 System.out.println(Thread.currentThread().getName() + " ----> "+i);
        			
                     }
        	}
        	
          

            
        }
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}
package thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
//Assignment - 1
import java.util.concurrent.TimeoutException;

public class Fib_Using_Callable {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		MyCallable call = new MyCallable();
		
		Future<String> fut = service.submit(call);
		
		System.out.println(fut.isCancelled());
		
		try {
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try{
			
            try {
				System.out.println("Fibonacci Using Future :--  "+ fut.get(400, TimeUnit.MILLISECONDS ));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
		
		
		service.shutdown();
		

	}

}

class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		String str = "";
		
		int a = 0;
		int b = 1;
	    int c = 0;
	    int sum = 1;
	    
	    str = "0 + 1";
		
		for(int i = 3; i <= 10; i++){
			
			System.out.println(Thread.currentThread().getName());
			
			c = (a + b);
			sum += c;
			
			str = str + " + " + c;
		
			a = b;
			b = c;
			
			Thread.sleep(100);
			
		}
		
		str = str + " = " + sum;
		
		return str;
		
	}
	
	
	
}













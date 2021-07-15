package thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Fib_Using_Callable {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		MyCallable call = new MyCallable();
		
		Future<String> fut = service.submit(call);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{

            System.out.println("Fibonacci Using Future :--  "+ fut.get());

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
		
		for(int i = 3; i <= 7; i++){
			
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName());
			
			c = (a + b);
			sum += c;
			
			str = str + " + " + c;
		
			a = b;
			b = c;
			
		}
		
		str = str + " = " + sum;
		
		return str;
		
	}
	
	
	
}













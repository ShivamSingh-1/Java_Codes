package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		
		fibThread fib = new fibThread(10);
		
		Thread th1 = new Thread(fib);
		Thread th2 = new Thread(fib);
		Thread th3 = new Thread(fib);
		Thread th4 = new Thread(fib);
     	
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 fib.getLsSum().forEach(n -> System.out.print(n + " + "));
		 
		 System.out.println("\b = " + fib.getSum());
		
		 System.out.println("----------------");
		 
		 fib.getLsExpected().forEach(n -> System.out.println(n));
				
		
	}

}


class fibThread implements Runnable{
   
	private List<Integer> lsSum = Collections.emptyList();
	
	private List<String> lsExpected = Collections.emptyList();
	
	private static String name; 
	
	private int sum = 1;
	
	private int s = 1;
	
	private int c = 0;
	
	private int a = 0;
	
	private int b = 1;
	
	private int n;
	
	
	@Override
	public void run(){
	 
		
		while(n > 0){
			
			synchronized(this){
			
		    c = a + b;
		    a = b;
		    b = c;
		    
		    sum += c;
		    
			lsSum.add(c);
		    
		    lsExpected.add(s + " + " + c + " = " + (s+c) );
			
		    s += c;
		    
			--n;
			
	        System.out.println(Thread.currentThread().getName());
			
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    
		
	}

	
	public fibThread(int n){
		this.n = (n-1);
		
        lsSum = new ArrayList<>();
		
        lsSum.add(1);
        
		lsExpected = new ArrayList<>();
		
		lsExpected.add("0" + " + " + "1" + " = " + (s+c));
		
		
	}



	public List<Integer> getLsSum() {
		return lsSum;
	}

	public void setLsSum(List<Integer> lsSum) {
		this.lsSum = lsSum;
	}

	public List<String> getLsExpected() {
		return lsExpected;
	}

	public void setLsExpected(List<String> lsExpected) {
		this.lsExpected = lsExpected;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}


	public static String getName() {
		return name;
	}


	public static void setName(String name) {
		fibThread.name = name;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}

	
}




package dsa_wiley;

public class Queue_Main_Class {

	public static void main(String[] args) {
		
		Queue_New queue = new Queue_New();
		
		queue.enqueue(10);  //adding elements to queue
		queue.enqueue(20);  
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println("Dequeued Element:-- " + queue.dequeue()); //removing elements from queue 
		System.out.println("Dequeued Element:-- " + queue.dequeue());  
		System.out.println("Dequeued Element:-- " + queue.dequeue());
		System.out.println("Peek Element:-- " + queue.peek());        //checking top element
		System.out.println("Dequeued Element:-- " + queue.dequeue());
		System.out.println("Dequeued Element:-- " + queue.dequeue());
		System.out.println("Is Queue Empty:-- " + queue.isEmpty());
		
	

	}

}

class Queue_New{
	
	final static int SIZE = 100;
	
    private static int[] arr = new int[SIZE];
	
	private int front = -1;
	
	private int rear = -1;
	
	
	void enqueue(int x) {
		
		if(rear == 99){
			
			System.out.println("Queue is full");
			
			return;
			
		}else {
			
			if(front == -1){
				
				arr[++rear] = x;
			    
				++front;
				
			}else {
			
			arr[++rear] = x;
			
			}
			
			
		}
		
		
	}
	
	int dequeue(){
		
       if(front == -1 || front > rear){
    	   
    	    if(front > rear){
    	    	
    	    	front = -1;
    	    	
    	    	rear = -1;
    	    	
    	    }
			
			System.out.print("Queue is empty,  ");
			
			return -1;
			
		}else {
			
			if(front == 99){
				
				front = -1;
				
				rear = -1;
				
				return arr[99];
				
				
			}else {
			
              return arr[front++];			
			
			}

			
		}
		
		
	}
	
	int peek(){
		
		if(front == -1){
			
			return -1;
			
		}else {
			
			return arr[front];
			
		}
		
		
		
	}
	
	boolean isEmpty(){
		
		if(front == -1 ){
			
			return true;
			
		}else {
			
			return false;
			
		}
		
		
	}
	
	
	
	
}
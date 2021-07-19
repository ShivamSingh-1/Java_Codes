package dsa_wiley;

public class Circular_Queue_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circular_Queue cQueue = new Circular_Queue();
		
		cQueue.enqueue(10); //adding elements to circular queue
		cQueue.enqueue(20);
		cQueue.enqueue(30);
		cQueue.enqueue(40);
		cQueue.enqueue(50);
		cQueue.enqueue(60);
		
		System.out.println("Element Removed:-- " + cQueue.dequeue()); //removing elements
		System.out.println("Element Removed:-- " +cQueue.dequeue());
		cQueue.enqueue(70);
		cQueue.enqueue(80);
		cQueue.enqueue(90);
		
		System.out.println("Peek element:-- " + cQueue.peek()); //checking peek element
		
	

	}

}


class Circular_Queue{
	
final static int SIZE = 5;
	
    private static int[] arr = new int[SIZE];
	
	private int front = -1;
	
	private int rear = -1;
	
	
	void enqueue(int x){
		
		if(rear == (SIZE-1) && front == 0){
				
			System.out.println("Queue is full");
				
			return;
			
		}
		
		if(rear == (front-1)){
			
			 System.out.println("Queue is full");
			
		
		}else {
			
			if(rear == (SIZE-1) && front != 0){
				
				rear = 0;
				 
				arr[rear] = x;
			 
				
			}else {
			
			  if(front == -1){
				  
				  ++front;
				  
				  arr[++rear] = x;
				  
			  }else {
				  
				  arr[++rear] = x;
				  
			  }
				
			  
			
		    }
			
		}		
		
		
   }
	
	int dequeue(){
		
       if(front == -1){
			
			System.out.print("Queue is empty  ");
			
			return -1;
			
		}
			
	     if(front == rear){
	    	 
			   int tmp = rear;	
	    	 
				front = -1;
				
				rear = -1;
				
				return arr[tmp];
				
				
			}else {
				
				
				if(front == (SIZE - 1)) {
					
					front = 0;
					
					return arr[SIZE-1];
					
					
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
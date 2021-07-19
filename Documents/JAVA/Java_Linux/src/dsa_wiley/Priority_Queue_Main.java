package dsa_wiley;

public class Priority_Queue_Main {

	public static void main(String[] args) {
		
		Priority_Queue pq = new Priority_Queue();
		
		pq.enqueue("Respected",10);
		pq.enqueue("Hi",1);
		pq.enqueue("Hello",2);
		pq.enqueue("How",3);
		pq.enqueue("What",6);
		pq.enqueue("Where",2);
		pq.enqueue("When",4);
		pq.enqueue("Why",5);
		pq.enqueue("ComeBack",2);
		
		
		System.out.println(pq.dequeue());
		System.out.println(pq.dequeue());
		System.out.println(pq.dequeue());
		

		
		

	}

}

class Priority_Queue{
	
	private lNode front = null;
	
	private lNode rear = null;
	
	
	void enqueue(String x,int p) {
		
		if(front == null){
			
			front = new lNode(x,p);
			
			rear = front;
			
			
		}else {
			
			lNode tmp = new lNode(x,p);
			
			rear.next = tmp;
			
			rear = rear.next;
			
		}
		
		
		
	}
	
	String dequeue(){
		
     if(front == null){
    	 
    	 System.out.println("Queue is Empty");
    	 return "";
    	 
     }else {
    	
    	 if(front == rear){
    		 
    		 String tmp = front.data; 
    		 
    		 front = rear = null;
    		
    		 return tmp;
    		 
    	 }else {
    		 
    		 lNode n = front;
 			
 			int p = Integer.MIN_VALUE;
 			String val = "";
 			
 			
 			while(n != null){
 				
 				if(n.priority > p){
 					
 					val = n.data;
 					
 				}
 				
 				n = n.next;
 				
 			}
    		 
    	   front = front.next;
    	
    	    return val;
    	 
    	 }
    	 
    	 
     }
		
		
		
	}
	
	String peek(){
		
		if(front == null){
			
			return "Queue is Empty";
			
		}else {
			
			lNode n = front;
			
			int p = Integer.MIN_VALUE;
			String val = "";
			
			
			while(n != null){
				
				if(n.priority > p){
					
					val = n.data;
					
				}
				n = n.next;
				
			}
		
			return val;
			
		}
		
		
		
	}
	
	boolean isEmpty(){
		
		if(front == null ){
			
			return true;
			
		}else {
			
			return false;
			
		}
		
		
	}
	
	
	
	
}

class lNode{
	
	String data;
	int priority;
	lNode next;
	
	public lNode(String data, int priority) {

		this.data = data;
		this.priority = priority;
		this.next = null;
	}
	
	
}








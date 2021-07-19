package dsa_wiley;

public class Stack_Class {
	
	
	public static void main(String[] args) {
	
	StackNew st = new StackNew();
	
	st.push(10);
	st.push(20);
	st.push(30);
	st.push(40);
	st.push(50);
	
	System.out.println(st.peek());    //top most element
	System.out.println(st.isEmpty()); //checking empty
	System.out.println(st.pop());     //pop top most element
	System.out.println(st.pop());      //pop top most element
	
	
	}

}




class StackNew{
	
	static int top = -1;
	
	final static int SIZE = 20;
	
	static int[] arr = new int[SIZE];
	

	void push(int x){
		
		if(top > 18) {
			
			System.out.print("Stack Overflow");
	
			
		}else {
			
			++top;
			
			arr[top] = x;
			
			
		}
		
	}
	
	int pop(){
		
         if(top <= -1) {
			
			System.out.print("Stack Underflow");
			
			return 0;
			
		}else {
			
			--top;
			
			return arr[top+1];
			
		}
		
		
		
	}
	
	int peek(){
		
		return arr[top];
		
		
	}
	
	boolean isEmpty(){
		
		if(top == -1) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
		
	}
	
	
	
	
	
	
}
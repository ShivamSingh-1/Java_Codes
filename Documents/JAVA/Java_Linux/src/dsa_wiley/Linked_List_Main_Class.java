package dsa_wiley;

public class Linked_List_Main_Class {

	public static void main(String[] args) {
		
		Linked_List ls = new Linked_List(new Node(6));
		
		Node n = ls.getHead();
		
		Node tmp = null;
		
		int ct = 5;
		
		while(ct != 0) {
			
			tmp = new Node(ct);
			
			n.setNext(tmp);
			
			n = n.getNext();
			
			--ct;
		}
		
		n = ls.getHead();
		
		while(n != null ) {
			
			System.out.println(n.getData());
			
			n = n.getNext();
			
		}
		
		

	}

}

class Linked_List{
	
	private Node head;

	public Linked_List(Node head) {
		this.head = head;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	
	
}


class Node{
	
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}










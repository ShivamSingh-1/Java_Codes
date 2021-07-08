package mini_project;

import java.util.*;

public class Transaction{
	
	private ArrayList<String> ls;
	private long totalTransaction;
	
	public Transaction(ArrayList<String> ls, int totalTransaction) {
		this.ls = ls;
		this.totalTransaction = totalTransaction;
	}
	
	public ArrayList<String> getLs() {
		return ls;
	}
	
	public void setLs(ArrayList<String> ls) {
		this.ls = ls;
	}
	
	public long getTotalTransaction() {
		return totalTransaction;
	}
	
	public void setTotalTransaction(long totalTransaction) {
		this.totalTransaction = totalTransaction;
	}
	

}

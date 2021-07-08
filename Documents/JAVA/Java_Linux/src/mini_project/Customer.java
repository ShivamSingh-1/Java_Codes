package mini_project;

public class Customer {
	
	private String name;
	private long account_NO;
	private long balance;
	private Transaction transaction;
	
	public Customer(String name,int account_NO,int balance,Transaction transaction){
		
		this.name = name;
		this.account_NO = account_NO;
		this.balance = balance;
		this.transaction = transaction;
		
	}
	
	public long getAccount_NO() {
		return account_NO;
	}
	public void setAccount_NO(long account_NO) {
		this.account_NO = account_NO;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
	//method for credit operation
	
	public void credit(long amt) {
		
		balance += amt;
		
		this.transaction.getLs().add("Credit Amount :-> " + amt + "	Current balance :-> " + this.balance); 
		
		long tmp = this.transaction.getTotalTransaction();
		
		++tmp;
		
		this.getTransaction().setTotalTransaction(tmp);
		
	}
	
	//method for debit operation
	
	public boolean debit(long amt) {
		
		if(this.balance >= amt) {
			
			this.balance -= amt;
			
			this.transaction.getLs().add("Debit Amount :-> " + amt + "	Current balance :-> " + this.balance); 
			
			long tmp = this.transaction.getTotalTransaction();
			
			++tmp;
			
			this.getTransaction().setTotalTransaction(tmp);
			
			return true;
			
		}else {
			
			this.transaction.getLs().add("Transaction Failed :-> " + "Insufficient Amount" + " Current balance :-> " + this.balance); 
			
             long tmp = this.transaction.getTotalTransaction();
			
			++tmp;
			
			this.getTransaction().setTotalTransaction(tmp);
			
			return false;
			
		}
		
	}
	

	
}

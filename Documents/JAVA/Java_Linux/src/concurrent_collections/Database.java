package concurrent_collections;

import java.util.*;
import java.util.concurrent.*;

public class Database implements Runnable {
	
	private static ConcurrentHashMap<CustomerDetails,ArrayList<BankDetails>> mp = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		
		
		ExecutorService service = Executors.newFixedThreadPool(3); 
		
		Database obj = new Database();
			
		service.execute(obj.new AddRecords());  //starting ThreadPool for Reading as well as updating Data
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.execute(obj);

		service.shutdown();
		
	}
	
	class AddRecords implements Runnable{  //inner class

		@Override
		public void run() {
			
			System.out.println("Thread Adding Records->  " + Thread.currentThread().getName());
			
			//Record 1
			CustomerDetails cs = new CustomerDetails(001,"Mike",new ArrayList<>(),9877847);
			cs.getAccounts().add(new BankDetails("Branch-1",1234,100000,10040,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-10",1230,100030,14000,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-5",1235,100050,1400,"Current"));
			mp.put(cs, cs.getAccounts());
			
			//Record 2
			cs = new CustomerDetails(002,"Stark",new ArrayList<>(),8457847);
			cs.getAccounts().add(new BankDetails("Branch-2",1233,103400,7400,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-1",1234,103100,23000,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-7",1237,103420,10000,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-6",1236,103440,5000,"Current"));
			mp.put(cs, cs.getAccounts());
			
			//Record 3
			cs = new CustomerDetails(003,"Michael",new ArrayList<>(),8455847);
			cs.getAccounts().add(new BankDetails("Branch-2",1233,106400,44400,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-1",1234,107100,53000,"Current"));
			cs.getAccounts().add(new BankDetails("Branch-9",1239,109420,70000,"Current"));
			cs.getAccounts().add(new BankDetails("Branch-6",1236,102440,9000,"Savings"));
			mp.put(cs, cs.getAccounts());
			
			//Record 4
			cs = new CustomerDetails(004,"Robert",new ArrayList<>(),8485847);
			cs.getAccounts().add(new BankDetails("Branch-10",1230,406400,453400,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-1",1234,807100,55000,"Current"));
			cs.getAccounts().add(new BankDetails("Branch-9",1239,909420,74000,"Current"));
			cs.getAccounts().add(new BankDetails("Branch-6",1236,402440,20000,"Savings"));
			mp.put(cs, cs.getAccounts());
			
			
			//Record 5
			cs = new CustomerDetails(005,"Stephen",new ArrayList<>(),9485547);
			cs.getAccounts().add(new BankDetails("Branch-3",1233,444700,3400,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-1",1234,855190,5000,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-8",1238,977420,4000,"Savings"));
			cs.getAccounts().add(new BankDetails("Branch-7",1237,488440,7000,"Savings"));
			mp.put(cs, cs.getAccounts());
			
			
		}
	  	
	 
		
	}

	@Override
	public void run() {
		
		ConcurrentHashMap<CustomerDetails,ArrayList<BankDetails>> map = this.mp;
		
		Iterator<CustomerDetails> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			
	         try {
		     	Thread.sleep(1000);
		      } catch (InterruptedException e) {
			   e.printStackTrace();
		      }
			
			System.out.print("Thread Reading Records-> " + Thread.currentThread().getName() + "   ");
			
			CustomerDetails cs = (CustomerDetails)itr.next();
			
			System.out.println("CustId:- " + cs.getCustId() + " , " +"CustomerName:- " + cs.getCustName() );
			
			if(cs.getCustName() == "Stark"){  //accessing and updating details inside iterator
				
				ArrayList<BankDetails> ls = cs.getAccounts();
				
				ls.add(new BankDetails("Branch-5",1235,136400,74400,"Savings"));
				
			}
			
			
		}
		
		
	}


}

class CustomerDetails{
	
	private int CustId;
	private String CustName;
	private ArrayList<BankDetails> accounts;
	private int phoneNo;
	
	public CustomerDetails(int custId, String custName, ArrayList<BankDetails> accounts,int phoneNo) {
		super();
		CustId = custId;
		CustName = custName;
		this.accounts = accounts;
		this.phoneNo = phoneNo;
	}
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public ArrayList<BankDetails> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<BankDetails> accounts) {
		this.accounts = accounts;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}

class BankDetails{
	
	private String branchName;
	private int ifsc;
	private int accountNumber;
	private int currentBalance;
	private String typeOfAccount;
	
	public BankDetails(String branchName, int ifsc, int accountNumber, int currentBalance, String typeOfAccount) {
		super();
		this.branchName = branchName;
		this.setIfsc(ifsc);
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.typeOfAccount = typeOfAccount;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getTypeOfAccount() {
		return typeOfAccount;
	}
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	public int getIfsc() {
		return ifsc;
	}
	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}
	
	
}







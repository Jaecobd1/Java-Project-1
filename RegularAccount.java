public class RegularAccount extends Account {
	int transactionCount;
	public RegularAccount(Customer customer, double balance) {
		super(customer, balance);
		this.transactionCount = 0;
	}
	
	public void monthlyUpdates() {
		this.balance = this.balance + this.balance * 0.06;
		this.balance = this.balance - 10;
	}
	public void deposit(int amount) {
		
		this.balance = this.balance + amount;
		
	}
	public void withdraw(int amount) {
		if(this.balance > amount) {
			this.balance = this.balance - amount;
			
		}else {
			System.out.println("Could not complete withdraw,"
					+ "\nwithdraw limit: " + this.balance);
		}
	}
	
	
}

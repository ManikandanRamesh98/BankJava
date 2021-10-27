
public class Account {
	
	double balance = 500.00;
	double withday = 0.00;

	//Withdraw:
	public boolean withdraw(double m) {
		boolean flag = false;
		if(m <= balance) {
			flag = true;
			balance -= m;
		}else {
			flag = false;
		}
		return flag;
	}
	//Deposit:
	public boolean deposit(double m) {
	if(m <= 100000.00) {
		balance += m;
		withday += m;
		if(withday <= 100000.00) {
		return true;
		}
	}
	return false;
}
	//balance:
	public void balance() {
		System.out.println("your balance is " + balance);
	}
	
}

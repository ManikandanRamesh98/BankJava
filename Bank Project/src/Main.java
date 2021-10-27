import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	boolean flag = true;
	Account acc = new Account();
	Scanner sc = new Scanner(System.in);
	while(flag) {
	System.out.println("enter the option"+ '\n' + "1.Withdraw" + '\n' + "2.Deposit" + '\n' + "3.balance" + '\n' + "4.Exit");
	int in = sc.nextInt();
	switch(in) {
	case 1:
		//Withdraw
		System.out.println("enter the amount to withdraw!!");
		int with = sc.nextInt();
	
		boolean res = acc.withdraw(with);
		if(res) {
			System.out.println("your have sucessfully withdraw the amount " + with);
			acc.balance();
		}else {
			System.out.println("Insufficient balance!!");
		}
		break;
		//Deposit:
	case 2:
		System.out.println("enter the amount to deposit!!");
		int dep = sc.nextInt();
		boolean res1 = acc.deposit(dep);
		if(res1) {
			System.out.println("your have sucessfully deposited " + dep);
			acc.balance();
		}else {
			System.out.println("limit exceed!!");
		}
		break;
		//balance:
	case 3:
		acc.balance();
		break;
	case 4:
		flag = false;
	}
	}
}
}

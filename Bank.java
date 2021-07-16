package bank;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
	static {
		System.out.println("---------Welcome to HGs Banks---------\n\n");
	}
	static int AcNo = 101;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ConcurrentHashMap<Integer, Customer> t = new ConcurrentHashMap<>();
		t.put(AcNo,new Customer(AcNo,1234,"Hari","Trichy",50000));
		AcNo++;
		t.put(AcNo,new Customer(AcNo,1111,"Gautam","Chandigarh",75000));
		AcNo++;
		t.put(AcNo,new Customer(AcNo,1234,"Gaurav","Chandigarh",80000));
		AcNo++;
		t.put(AcNo,new Customer(AcNo,1234,"Daksh","Jaipur",100000));
		AcNo++;
		int n = 1, ac, pin;
		
		while (n != 5) {
			int f=0;
			while (true) {
				System.out.println("Enter your Account number");
				ac = sc.nextInt();
				if (t.containsKey(ac) && t.get(ac).status==true)
					break;
				else {
					System.out.println("Account not found !!!\nPlease press enter correct account number");
					f=1;
				}
			}
			if(f==0) {
			while(true) {
				System.out.println("Enter your pin");
				pin = sc.nextInt();
				if(t.get(ac).pin==pin)
					break;
				else
					System.out.println("Wrong pin!!!\nEnter correct pin");
			}
			System.out.println("Enter your choice: \n1.Withdraw\n2.Deposit\n3.Display saving\n4.Remove account\n5.Exit");
			n = sc.nextInt();
			int m;
			switch (n) {
			case 1:
				System.out.println("Enter the amount to withdraw");
				m=sc.nextInt();
				t.get(ac).Withdraw(m);
				break;
			case 2:
				System.out.println("Please enter the amount to deposit");
				m=sc.nextInt();
				t.get(ac).Deposit(m);
				break;
			case 3:
				t.get(ac).Display();
				break;
			case 4:
				t.get(ac).TerminateServices();
				break;
			default:
				System.out.println("Thank you for using our services");
			}
			}
			
		}//while end
		
	
		
	}
}

class Customer {
	int acNo;
	int pin;
	String name;
	String city;
	float amount;
	boolean status=true;

	public Customer(int acNo,int pin, String name, String city, float amount) {

		this.acNo = acNo;
		this.pin=pin;
		this.name = name;
		this.city = city;
		this.amount = amount;
	}
	
	public void Withdraw(int m) {
		this.amount-=m;
		System.out.println("Withdrawn Rs."+m+" from your account");
	}
	
	public void Deposit(int m) {
		this.amount+=m;
		System.out.println("Deposited an amount of Rs."+m+" to your account");
	}
	
	public void Display() {
		System.out.println("Your balance is : "+this.amount);
	}
	
	public void TerminateServices() {
		this.status=false;
		System.out.println("Dear customer your services are cancelled. Thank you for visiting our bank!");
	}

}

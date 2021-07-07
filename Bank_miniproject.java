import java.util.*;
public class Admin {
	
	private int custId;
	private float savings;
	private String custName;
	
	Admin(int custId,float savings,String custName){
		this.custId=custId;
		this.savings=savings;
		this.custName=custName;
	}

	public int getCustId() {
		return custId;
	}



	public void setCustId(int custId) {
		this.custId = custId;
	}



	public float getSavings() {
		return savings;
	}



	public void setSavings(float savings) {
		this.savings = savings;
	}
	
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	void getBalance() {
		System.out.println("Your balance is $"+savings);
	}
	
	void depositMoney(int money) {
		this.savings+=money;
		System.out.println("Succesfully deposited amount of $"+money+" to your account!!!");
		System.out.println("Your balance is $"+ savings);
	}
	
	void withdrawMoney(int money) {
		if(savings<1000) {
			System.out.println("Can't withdraw, below minimum balance!!!");
		}
		else {
			System.out.println("Amount of $"+money+" withdrawn from your account!!!");
			this.savings-=money;
			System.out.println("Your balance is $"+ savings);
		}
	}



	public static void main(String[] args) {
		ArrayList<Admin> cust=new ArrayList<>();
		cust.add(new Admin(101,30000,"Stanley"));
		cust.add(new Admin(102,25000,"Sansa"));
		cust.add(new Admin(103,10000,"Pam"));
		cust.add(new Admin(104,8000,"Phoebe"));
		
		for(Admin m:cust) {
			Admin k=(Admin)m;
			System.out.println(m.savings);
		}
		
		System.out.println(cust.get(0).savings);
		
		cust.get(0).depositMoney(1000);
		
		cust.get(0).withdrawMoney(15000);
		
		cust.get(0).getBalance();
		
		//stream implementation
		
		//savings less than 25000
		cust.stream().filter(n-> n.savings<25000).forEach(k->System.out.println(k.savings));
		
		//sorted customer names
		cust.stream().sorted((i,j)->i.custName.compareTo(j.custName)).forEach(k->System.out.println(k.custName));
		
		//cust.stream().sorted(i->i.getCustName().reverseOrder()).forEach(k->System.out.println(k.custName));

	}

}

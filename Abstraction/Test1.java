import java.util.Scanner;

abstract class Bank
{
	abstract void setDetails();
	abstract void showDetails();
	abstract float rateOfInterest();
}
class Sbi extends Bank
{
	String name;
	int ac;
	double amt, cinterest;
	Scanner sc = new Scanner(System.in);
	
	Sbi() {
		System.out.println("~~~ WELCOME TO STATE BANK OF INDIA ~~~");
	}

	@Override
	void setDetails() {
		System.out.println("\nEnter Customer Details :");
		System.out.print("\nEnter Customer Name : ");
		name=sc.nextLine();
		System.out.print("Enter Account Number: ");
		ac = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Amount to be deposited: ");
		amt=Double.parseDouble(sc.nextLine());
	}

	@Override
	void showDetails() {
		System.out.println("\nView Details: \n");
		System.out.println("Customer Name : " + name);
		System.out.println("Account Number: " + ac);
		System.out.println("Amount deposited: " + amt);
		System.out.println("Compund Interest on "+amt+" for 1 year is "+cal());
	}
	
	double cal()
	{
		int t=1;
		int n=12;
		float r= rateOfInterest();
		double amount = amt*Math.pow(1+(r/n), n*t);
		cinterest = amount-amt;
		return cinterest;
	}

	@Override
	float rateOfInterest() {
		return (float) 0.1;
	}
	
}

class Canara extends Bank
{
	String name;
	int ac;
	double amt, cinterest;
	Scanner sc = new Scanner(System.in);
	
	Canara() {
		System.out.println("~~~ WELCOME TO CANARA BANK ~~~");
	}

	@Override
	void setDetails() {
		System.out.println("\nEnter Customer Details :");
		System.out.print("\nEnter Customer Name : ");
		name=sc.nextLine();
		System.out.print("Enter Account Number: ");
		ac = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Amount to be deposited: ");
		amt=Double.parseDouble(sc.nextLine());
	}

	@Override
	void showDetails() {
		System.out.println("\nView Details: \n");
		System.out.println("Customer Name : " + name);
		System.out.println("Account Number: " + ac);
		System.out.println("Amount deposited: " + amt);
		for(int i=0; i<=5; i++)
		{
			cal(i);
		}
	}
	void cal(int t)
	{
		int n=12;
		float r= rateOfInterest();
		double amount = amt*Math.pow(1+(r/n), n*t);
		cinterest = amount-amt;
		System.out.println("Compund Interest on "+amt+" for "+ t + " year is "+ cinterest);
	}
	@Override
	float rateOfInterest() {
		return (float) 0.11;
	}
}

public class Test1 {

	public static void main(String[] args) {
		Sbi b1 = new Sbi();
		b1.setDetails();
		b1.showDetails();
		
		Canara b2 = new Canara();
		b2.setDetails();
		b2.showDetails();
	}

}

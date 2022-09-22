abstract class Bank1
{
	abstract void seCustDetails();
	abstract void showCusDetails();
	void setInterest()
	{
		System.out.println("interest");
	}
}
class Axis1 extends Bank1
{

	@Override
	void seCustDetails() {
		System.out.println("set data");		
	}

	@Override
	void showCusDetails() {
		System.out.println("show data");		
	}
}
class Sbi1 extends Bank1
{

	@Override
	void seCustDetails() {
		System.out.println("set data");		
	}

	@Override
	void showCusDetails() {
		
	}
	void show()
	{
		System.out.println("data show");
	}
}
class A extends Sbi1
{
	void show()
	{
		
	}
}

public class Test {

	public static void main(String[] args) {
		
		Axis1 a1 = new Axis1();
		a1.seCustDetails();
	}

}

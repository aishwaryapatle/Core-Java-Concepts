import java.util.Scanner;

final class A1
{
	Scanner sc = new Scanner(System.in);
	static final int a; //blank final data member
	/*
	 A1()
	 
	{
		System.out.println("Enter the value of a : ");
		a=sc.nextInt();
	}
	*/
	final void myfun()
	{
		System.out.println(a);
	}
	final void fun()
	{
		System.out.println("hello fun");
	}
	static {
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
	}
}
public class Test2 {

	public static void main(String[] args) {
		A1 a = new A1();
		a.myfun();
	}

}

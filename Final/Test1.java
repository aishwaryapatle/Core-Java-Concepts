import java.util.Scanner;

class A
{
	Scanner sc = new Scanner(System.in);
	final int a; //blank final data member
	A()
	{
		System.out.println("Enter the value of a : ");
		a=sc.nextInt();
	}
	void myfun()
	{
		System.out.println(a);
	}
	final void fun()
	{
		System.out.println("hello fun");
	}
}
class B extends A
{
	/*
	void fun() //can't override
	{
		System.out.println("hey fun");
	}
	*/
}
public class Test1 {

	public static void main(String[] args) 
	{
		A a = new A();
		a.myfun();
	}
}

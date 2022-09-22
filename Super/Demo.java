class A2
{
	int a=10;
	A2()
	{
		System.out.println("I am Class A constructor");
	}
}
class B2 extends A2
{
	int a=22;
	B2()
	{
		System.out.println("I am class B constructor");
	}
	B2(int a)
	{
		super();
		System.out.println("1 parameter constructor");
	}
	void show()
	{
		System.out.println(a+super.a);
	}
}
class C2 extends B2
{
	int a=25;
	void show()
	{
		System.out.println(a+super.a);
	}
}
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

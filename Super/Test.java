class A
{
	int a=10;
}
class B extends A
{
	int a = 22;
	void show()
	{
		System.out.println(super.a+a);
	}
}
class C extends B
{
	int a=25;
	void show()
	{
		System.out.println(a+super.a);
	}
}
public class Test {

	public static void main(String[] args) 
	{
		B b1 = new B();
		System.out.println(b1.a);
		b1.show();
		C c1 = new C();
		System.out.println(c1.a);
		c1.show();
	}

}

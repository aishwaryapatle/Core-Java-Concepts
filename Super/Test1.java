class A1
{
	int a, b;
	void add(int a, int b)
	{
		System.out.println("Addition = "+(a+b));
	}
}
class B1 extends A1
{
	void show()
	{
		super.add(10, 20);
	}
}
public class Test1 {

	public static void main(String[] args) {
		B1 b1 = new B1();
		b1.show();
	}
}

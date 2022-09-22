import java.util.Scanner;

final class A2
{
	Scanner sc = new Scanner(System.in);
	int a; //blank final data member
	
	void myfun(final int a)
	{
		//a=a*a; //final parameter value can't reassign
		this.a=a*a; //it can be done
		System.out.println("The value of a is "+a);
	}
}
	
public class Test3 {

	public static void main(String[] args) {
		A2 a = new A2();
		a.myfun(20);
	}
}

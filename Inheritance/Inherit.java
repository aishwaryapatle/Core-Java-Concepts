import java.util.Scanner;
class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
	
	void table(int a)
	{
		System.out.print("~~~ The Table of "+ a +" ~~~\n");
		for(int i=1; i<=10; i++)
		{
			System.out.print(a + " x "+ i + " = " + a*i+" , ");
		}
	}
	
}

public class Inherit {

	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		A a1 = new A();
		a1.table();
		System.out.print("\nEnter any number to get table of that number : ");
		int a = ab.nextInt();
		a1.table(a);
		ab.close();
	}
}


/* Single Inheritance

class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
}
class B extends A
{
	int x;
	void cube(int a)
	{
		this.x=a;
		System.out.println("Cube of "+x+" = "+x*x*x);
	}
}

public class Inherit {

	public static void main(String[] args) {
		
		B b1 = new B();
		b1.table();
		b1.cube(7);
	}

}
*/


/* Multilevel Inheritance

class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
}
class B extends A
{
	int x;
	void cube()
	{
		System.out.print("Enter the number to find its cube = ");
		x=sc.nextInt();
		System.out.println("Cube of "+x+" = "+x*x*x);
	}
}
class C extends B
{
	void profit()
	{
		System.out.print("Enter the Cost Price : ");
		int cp=sc.nextInt();
		System.out.print("Enter the Selling Price : ");
		int sp=sc.nextInt();
		if(sp>cp)
		{
			System.out.println("The Profit is of Rs. "+(sp-cp));
		}
		else
		{
			System.out.println("The Loss is of Rs. "+(cp-sp));
		}
	}
	
}

public class Inherit {

	public static void main(String[] args) {
		C c1 = new C();
		c1.table();
		c1.cube();
		c1.profit();
	}
}
*/

/* Runtime Polymorphism

class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
	
}
class B extends A
{
	int x;
	void cube()
	{
		System.out.print("Enter the number to find its cube = ");
		x=sc.nextInt();
		System.out.println("Cube of "+x+" = "+x*x*x);
	}
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		for(int i=1; i<=10; i++)
		{
			System.out.print(n + " x "+ i + " = " + n*i+" , ");
		}
	}
}

public class Inherit {

	public static void main(String[] args) {
		B b1 = new B();
		b1.table();
		b1.cube();
	}
}
*/

/* Compile Time Polymorphism
 
 class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
	
}
class B extends A
{
	int x;
	void cube()
	{
		System.out.print("Enter the number to find its cube = ");
		x=sc.nextInt();
		System.out.println("Cube of "+x+" = "+x*x*x);
	}
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		for(int i=1; i<=10; i++)
		{
			System.out.print(n + " x "+ i + " = " + n*i+" , ");
		}
	}
}

public class Inherit {

	public static void main(String[] args) {
		B b1 = new B();
		b1.table();
		b1.cube();
	}
}

 */

/* Function Overloading
 
 class A
{
	Scanner sc = new Scanner(System.in);
	void table()
	{
		System.out.print("Enter the number whose table you want : ");
		int n=sc.nextInt();
		System.out.println("Table of "+ n);
		for(int i=1; i<=10; i++)
		{
			System.out.println(n + " x "+ i + " = " + n*i);
		}
	}
	
	void table(int a)
	{
		System.out.print("~~~ The Table of "+ a +" ~~~\n");
		for(int i=1; i<=10; i++)
		{
			System.out.print(a + " x "+ i + " = " + a*i+" , ");
		}
	}
	
}

public class Inherit {

	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		A a1 = new A();
		a1.table();
		System.out.print("\nEnter any number to get table of that number : ");
		int a = ab.nextInt();
		a1.table(a);
		ab.close();
	}
}
 */
 

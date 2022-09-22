class Student1
{
	int roll;
	String name;
	double res;
	
	void setData(int roll, String name, double res)
	{
		this.roll=roll;
		this.name=name;
		this.res=res;
		this.show();
	}
	
	void show()
	{
		System.out.println("Roll : "+roll);
		System.out.println("Name : "+name);
		System.out.println("Result : "+res);
	}
	public Student1(int roll, double res, String name)
	{
		this.roll=roll;
		this.name=name;
		this.res=res;
		System.out.println("hello 3 para");
	}
	
	public Student1()
	{
		this(103,67.87,"ygjhjf");
		roll=00;
		res=1.0;
		name="unknown";
		System.out.println("default constructor");
	}
}
public class Testing {

	public static void main(String[] args) 
	{
		Student1 s1 = new Student1(101, 56.78, "ram");
		Student1 s2 = new Student1();
		s2.setData(102, "geeta", 78.87);
	}
}

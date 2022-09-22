import java.util.Scanner;

class Student
{
	int roll;
	String name;
	static String insName="Asterisc Computer";
	Scanner sc = new Scanner(System.in);
	void setData()
	{
		System.out.println("Enter roll number : ");
		roll=Integer.parseInt(sc.nextLine());
		System.out.println("Enter name : ");
		name = sc.nextLine();
	}
	void showData()
	{
		Student.show();
		System.out.println("Institute name : "+insName);
		System.out.println("Roll number : "+roll);
		System.out.println("Name : "+name);
	}
	static void show()
	{
		int a;
		System.out.println("Institute name : "+insName);
	}
	static
	{
		System.out.println("hello static block 1");
	}
	static
	{
		System.out.println("hello static block 2");
	}
}
public class Stat {

	public static void main(String[] args) {
		Student.insName="Asterisc";
		System.out.println(""+Student.insName);
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setData(); //ram 24 bytes
		s2.setData(); //geeta 26 bytes
		s1.show();
		s2.show();
	}
}

import java.util.Scanner;

class Student
{
	int roll;
	String name;
	
	void setData(int r, String n) {
		roll=r;
		name=n;
	}
	void getData()
	{
		System.out.println("Your roll number is : "+roll+" Your name is :"+name);
	}
}
public class Array {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		int n=Integer.parseInt(sc.nextLine());
		Student s[]=new Student[n];
		
		for(int i=0; i<s.length; i++)
		{
			s[i]=new Student();
			System.out.println("Enter your roll number : ");
			int roll=Integer.parseInt(sc.nextLine());
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
			s[i].setData(roll, name);
		}
		for(int i=0; i<s.length; i++)
		{
			s[i].getData();
		}
	}
}


import java.util.Scanner;

class Student
{
	int roll, eng, mat, sci;
	String name;
	float per;
	
	void add(int roll, String name, int eng, int mat, int sci, int i)
	{
		this.roll=roll;
		this.name=name;
		this.eng=eng;
		this.mat=mat;
		this.sci=sci;
		per=(eng+mat+sci)/3;
		this.show(i);
	}
	
	void show(int i)
	{
		System.out.println("\nStudent "+ i +" Details : \n");
		System.out.println(roll+"\t"+name+"\t"+eng+"\t"+mat+"\t"+sci+"\t"+per);
	}
}
public class Test {

	public static void main(String[] args) {
		int n, roll, eng, mat, sci;
		String name;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		n=Integer.parseInt(sc.nextLine());
		for(int i=1; i<=n; i++)
		{
			System.out.println("\nEnter Student "+ i + " Data : ");
			System.out.print("\nEnter your roll number : ");
			roll=Integer.parseInt(sc.nextLine());
			System.out.print("Enter your name : ");
			name = sc.nextLine();
			System.out.print("Enter English Marks : ");
			eng=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Maths Marks : ");
			mat=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Science Marks : ");
			sci=Integer.parseInt(sc.nextLine());
			
			Student s1 = new Student();
			s1.add(roll, name, eng, mat, sci, i);
			System.out.println("+------------------------------------------+");

		}	
	}
}

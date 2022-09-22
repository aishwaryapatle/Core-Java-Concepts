
class Stud
{
	private int roll_no;
	private String name;
	private int age;
	
	void setRoll(int roll1)
	{
		roll_no = roll1;
	}
	void setName(String name1)
	{
		name = name1;
	}
	void setAge(int age1)
	{
		age = age1;
	}
	int getRoll()
	{
		return roll_no;
	}
	
	String getName()
	{
		return name;
	}
	
	int getAge()
	{
		return age;
	}
	
}
public class encap {

	public static void main(String[] args) {
		Stud s1 = new Stud();
		s1.setRoll(1);
		s1.setAge(20);
		s1.setName("Aishwarya");
		
		System.out.println("~~~ Student 1 Details ~~~");
		System.out.println("Roll Number = "+s1.getRoll());
		System.out.println("Name = "+s1.getName());
		System.out.println("Age = "+s1.getAge());
	}

}

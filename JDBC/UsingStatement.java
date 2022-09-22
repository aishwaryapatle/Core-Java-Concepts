import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Employee
{
	int empno;
	String empname, salary;
	Scanner sc = new Scanner(System.in);
	int a=0;

	void add(Statement st)
	{	
        System.out.print("\n\n+-------------------------------+");
        System.out.print("\n| \t1. ADD EMMPLOYEE\t|");
        System.out.print("\n+-------------------------------+");
        
    	System.out.print("\nEnter Employee Number: ");
    	empno=Integer.parseInt(sc.nextLine());
        System.out.print( "Enter Employee Name: ");
        empname=sc.nextLine();
        System.out.print( "Enter Employee Salary: ");
        salary=sc.nextLine();
        
		try {
			a = st.executeUpdate("INSERT INTO Emp(empno, empname, salary) values(" +empno+",'"+empname+"','"+salary+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		if(a>0)
  		{
  			System.out.println("data inserted successfully");
  		}
  		else
  		{
  			System.out.println("data isn't inserted :(");
  		}
	}
	
	void show(Statement st)
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t2. SHOW EMPLOYEE\t|");
    	System.out.print("\n+-------------------------------+\n\n");
		String query="SELECT * FROM Emp";
		ResultSet rs=null;
		try 
		{
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Employee no. : "+rs.getInt("empno"));
				System.out.println("Employee name : "+rs.getString("empname"));
				System.out.println("Employee salary. : "+rs.getString("salary"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void search(Statement st)
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t3. SEARCH EMPLOYEE\t|");
    	System.out.print("\n+-------------------------------+\n\n");
    	
    	System.out.print("Enter the Employee number to search : ");
    	int searchEmpno=Integer.parseInt(sc.nextLine());
    	
		String query="SELECT * FROM Emp WHERE empno="+searchEmpno+"";
		ResultSet rs=null;
		try 
		{
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Employee no. : "+rs.getInt("empno"));
				System.out.println("Employee name : "+rs.getString("empname"));
				System.out.println("Employee salary : "+rs.getString("salary"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void update(Statement st)
	{
		System.out.print("Enter Employee number whose record is to be deleted: ");
  		int updateEmpno=Integer.parseInt(sc.nextLine());
	     
  		System.out.println("1. Update Employee Name\n2. Update Employee Salary");
  		System.out.print("Choose the option: ");
  		int option=Integer.parseInt(sc.nextLine());;
  		
  		if(option==1)
  		{
  			System.out.print( "Enter New Employee Name: ");
  			String newEmpname=sc.nextLine();
   	     
     		try {
				a = st.executeUpdate("UPDATE Emp Set empname='"+newEmpname+"' WHERE empno="+updateEmpno+"");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  	  		
  	  		if(a>0)
  	  		{
  	  			System.out.println("Employee Name updated successfully!");
  	  		}
  	  		else
  	  		{
  	  			System.out.println("Employee name could not updated :(");
  	  		}
  		}
  		
  		if(option==2)
  		{
  			System.out.print( "Enter New Salary of Employee: ");
  			String newSalary=sc.nextLine();
   	     
     		try {
				a = st.executeUpdate("UPDATE Emp Set salary='"+newSalary+"' WHERE empno="+updateEmpno+"");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  	  		
  	  		if(a>0)
  	  		{
  	  			System.out.println("salary updated successfully!");
  	  		}
  	  		else
  	  		{
  	  			System.out.println("salary could not updated :(");
  	  		}
  		}
		
	}
	
	void delete(Statement st)
	{
		System.out.print("Enter Employee number whose record is to be deleted: ");
  		int delEmpno=Integer.parseInt(sc.nextLine());
	     
		try {
			a = st.executeUpdate("DELETE FROM Emp WHERE empno="+delEmpno+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		if(a>0)
  		{
  			System.out.println("data deleted successfully");
  		}
  		else
  		{
  			System.out.println("data could not deleted");
  		}
	}
}

public class UsingStatement {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		Employee s1=new Employee();
		int choice;
		boolean y = true;
		
		//Step 1 : Driver Registration
		
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		System.out.println("Driver Registered");
  		
  		//Step 2 : Connection Building
  		
  		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","abc123");
  		System.out.println("connected");
  		
  		//Step 3: Statement
  		
  		Statement st = con.createStatement();
  		System.out.println("Statement created");

	    while(y)
	    {
	    	System.out.println("\n****Asterisc Classes****");
	    	System.out.println("\n1.Add Employee");
	    	System.out.println("2.Show Employee");
	    	System.out.println("3.Search Employee");
	    	System.out.println("4.Update Employee Record");
	    	System.out.println("5.Delete Employee Record");
	    	System.out.println("0.Exit");
	    	System.out.print("\nEnter your choice = ");
	        choice=Integer.parseInt(sc.nextLine());
      		
	        switch(choice)
	        {
	        case 1:
	    		s1.add(st);
	    		break;
	    		
	        case 2:
	        	s1.show(st);
	        	break;
	        	
	        case 3: 
	        	s1.search(st);
	        	break;
	        	
	        case 4: 
	        	s1.update(st);
	        	break;	
	        
	        case 5:
	        	s1.delete(st);
	        	break;
	        	
	        case 0:
	        	y=false;
	        	//Step 5: Connection Closing
	      		
	      		con.close();
	      		System.out.println("closed");
	        	break;
	        	
	        default: System.out.println("\nYou have entered wrong choice :(");
	        }
        }
	   }
	}

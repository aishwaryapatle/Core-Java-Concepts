import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Employee1
{
	int empno;
	String empname, salary;
	Scanner sc = new Scanner(System.in);
	int a=0;

	void add(Connection con) throws SQLException
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
        
        //Insert Statement
				
		PreparedStatement st = con.prepareStatement("INSERT INTO EmployeeDB.Emp VALUES(?,?,?)");
		System.out.println("\nStatement created");
		st.setInt(1, empno);
		st.setString(2, empname);
		st.setString(3, salary);
		int a = st.executeUpdate();
		if(a>0)
		{
			System.out.println("data inserted successfully!");
		}
		else
		{
			System.out.println("data is not inserted :(");
		}
	}
	
	void show(Connection con) throws SQLException
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t2. SHOW EMPLOYEE\t|");
    	System.out.print("\n+-------------------------------+\n\n");
		
		ResultSet rs=null;
		
		PreparedStatement st = con.prepareStatement("SELECT * FROM Emp");
		System.out.println("Statement created");
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			System.out.println("Employee no. : "+rs.getInt("empno"));
			System.out.println("Employee name : "+rs.getString("empname"));
			System.out.println("Employee salary : "+rs.getString("salary"));
			System.out.println();
		}
	}
	
	void search(Connection con) throws SQLException
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t3. SEARCH EMPLOYEE\t|");
    	System.out.print("\n+-------------------------------+\n\n");
    	
    	System.out.print("Enter the Employee number to search : ");
    	int searchEmpno=Integer.parseInt(sc.nextLine());
    	
		PreparedStatement st = con.prepareStatement("SELECT * FROM EmployeeDB.Emp WHERE empno=?");
		System.out.println("\nStatement created");
		st.setInt(1, searchEmpno);
		
		ResultSet rs=null;
		rs = st.executeQuery();
		System.out.println("Query executed");
		
		while(rs.next()) {
			System.out.println("\nEmployee no. : "+rs.getInt(1));
			System.out.println("Employee name : "+rs.getString(2));
			System.out.println("Employee salary : "+rs.getString(3));
			System.out.println();
		}
	}
	
	void update(Connection con) throws SQLException
	{
		System.out.print("\nEnter Employee number whose record is to be updated: ");
  		int updateEmpno=Integer.parseInt(sc.nextLine());
	     
		System.out.println("\nWhat do you want to update ? ");
  		System.out.println("n1. Update Employee Name\n2. Update Employee Salary");
  		System.out.print("Choose the option: ");
  		int option=Integer.parseInt(sc.nextLine());;
		PreparedStatement st;

  		if(option==1)
  		{
  			// Getting the previous record
  			
  			st = con.prepareStatement("SELECT empname FROM EmployeeDB.Emp WHERE empno=?");
  			System.out.println("\nStatement created");
  			st.setInt(1, updateEmpno);
  			
  			ResultSet rs=null;
  			rs = st.executeQuery();
  			System.out.println("Query executed");
  			
  			while(rs.next()) {
  				System.out.println("\nThe Previous Employee Name is: "+rs.getString("empname"));
  				System.out.println();
  			}
  			
  			System.out.print( "Enter New Employee Name: ");
  			String updateEmpname=sc.nextLine();
  			
  			//Update Statement
  			
			st = con.prepareStatement("UPDATE EmployeeDB.Emp SET empname=? WHERE empno = ?");
			System.out.println("\nStatement created");
			st.setString(1, updateEmpname);
			st.setInt(2, updateEmpno);
			int a = st.executeUpdate();
			if(a>0)
			{
				System.out.println("Employee name is updated successfully!");
			}
			else
			{
				System.out.println("Employee name is not updated :(");
			}
  		}
  		
  		else if(option==2)
  		{
  			// Getting the previous record

  			st = con.prepareStatement("SELECT salary FROM EmployeeDB.Emp WHERE empno=?");
  			System.out.println("\nStatement created");
  			st.setInt(1, updateEmpno);
  			
  			ResultSet rs=null;
  			rs = st.executeQuery();
  			System.out.println("Query executed");
  			
  			while(rs.next()) {
  				System.out.println("\nThe Previous Salary of Employee is: "+rs.getString("salary"));
  				System.out.println();
  			}
  			System.out.print( "Enter New Salary of Employee: ");
  			String updateSalary=sc.nextLine();
  			
  			//Update Statement
  			
  			st = con.prepareStatement("UPDATE EmployeeDB.Emp SET salary=? WHERE empno = ?");
			System.out.println("\nStatement created");
			st.setString(1, updateSalary);
			st.setInt(2, updateEmpno);
			
			int a = st.executeUpdate();
			if(a>0)
			{
				System.out.println("salary updated successfully!");
			}
			else
			{
				System.out.println("salary is not updated :(");
			}
  		}
	}
	
	void delete(Connection con) throws SQLException
	{
		System.out.print("\nEnter Employee number whose record is to be deleted: ");
  		int deleteEmpno=Integer.parseInt(sc.nextLine());
			
		//Delete Statement
		
		PreparedStatement st = con.prepareStatement("DELETE FROM EmployeeDB.Emp WHERE empno = ?");
		System.out.println("\nStatement created");
		st.setInt(1, deleteEmpno);
		
		int a = st.executeUpdate();
		if(a>0)
		{
			System.out.println("data deleted successfully!");
		}
		else
		{
			System.out.println("data is not deleted :(");
		}
	}
}

public class UsingPreparedStatement {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		Employee1 e1=new Employee1();
		int choice;
		boolean y = true;
		
		//Step 1 : Driver Registration
		
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		System.out.println("Driver Registered");
  		
  		//Step 2 : Connection Building
  		
  		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","abc123");
  		System.out.println("connected");	
  		

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
	    		e1.add(con);
	    		break;
	    		
	        case 2:
	        	e1.show(con);
	        	break;
	        	
	        case 3: 
	        	e1.search(con);
	        	break;
	        	
	        case 4: 
	        	e1.update(con);
	        	break;	
	        
	        case 5:
	        	e1.delete(con);
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

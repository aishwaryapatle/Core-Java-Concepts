import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class Student
{
	//Initializing data members
	int roll, eng, mat, sci;
	float result;
	String name;
	boolean found=false;
	
	//Default constructor
	Student()
	{
		
	}
	
	//Parameterized Constructor
	Student(int roll, String name, int eng, int mat, int sci, float result)
	{
		this.roll=roll;
		this.name=name;
		this.eng=eng;
		this.mat=mat;
		this.sci=sci;
		this.result=result;
	}
	
	int total=0;
	ArrayList<Student> s1=new ArrayList<Student>();
	Scanner sc=new Scanner(System.in);
	
	PreparedStatement st;
	
	//Function for Adding students into ArrayList and into DB
	void add(Connection con) throws SQLException
	{	
		//initializing local variables
        int user=0;
        int add_roll=0, add_eng=0, add_mat=0, add_sci=0;
        float add_result=0;
		String add_name=null;
		
        System.out.print("\n\n+-------------------------------+");
        System.out.print("\n| \t1. ADD STUDENT\t\t|");
        System.out.print("\n+-------------------------------+");
		
        System.out.print("\n\nEnter numbers of Students : ");
        user=Integer.parseInt(sc.nextLine());
        System.out.println();
        
		for(int i=total; i<user+total; i++)
		{
        	System.out.println("\nEnter Student Number " + (i+1) + " Details");
			System.out.print("\nEnter roll number : ");
			add_roll=Integer.parseInt(sc.nextLine());
			System.out.print("Enter name : ");
			add_name=sc.nextLine();
			System.out.print("Enter English marks : ");
			add_eng=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Maths marks : ");
			add_mat=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Science marks : ");
			add_sci=Integer.parseInt(sc.nextLine());
			add_result=(add_eng + add_mat + add_sci)/3;
			
			//Insert Statement
			
			st = con.prepareStatement("INSERT INTO StudentsDB.Stud VALUES(?,?,?,?,?,?)");
			System.out.println("\nStatement created");
			st.setInt(1, add_roll);
			st.setString(2, add_name);
			st.setInt(3, add_eng);
			st.setInt(4, add_mat );
			st.setInt(5, add_sci);
			st.setFloat(6, add_result);
			
			int a = st.executeUpdate();
			if(a>0)
			{
				System.out.println("data inserted successfully!");
				s1.add(new Student(add_roll, add_name, add_eng, add_mat, add_sci, add_result));
			}
			else
			{
				System.out.println("data is not inserted :(");
			}
		}
        total+=user;
	}
	
	
	void show(Connection con) throws SQLException
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t2. SHOW STUDENT\t\t|");
    	System.out.print("\n+-------------------------------+\n\n");

    	//Code 1: showing details from ArrayList
    	System.out.println("\n~~~ Show using ArrayList ~~~");
    	
    	System.out.println("\nRoll Number\tName\tMaths\tScience\tEnglish\tPercentage\n");
    	for(Student st : s1)
		{		
			System.out.println(st.roll + "\t\t"+st.name+"\t"+st.mat+"\t"+st.sci+"\t"+st.eng+"\t"+st.result);
			found=true;
		}

    	//Code 2: showing details from Database
		ResultSet rs=null;
		
		st = con.prepareStatement("SELECT * FROM StudentsDB.stud");
		System.out.println("Statement created");
		
		rs = st.executeQuery();
		
    	System.out.println("\n~~~ Show using Database ~~~");
		while(rs.next()) {
			System.out.println("Roll number:  : "+rs.getInt(1));
			System.out.println("Student name : "+rs.getString(2));
			System.out.println("Maths Marks : "+rs.getInt(3));
			System.out.println("Science Marks : "+rs.getInt(4));
			System.out.println("English Marks : "+rs.getInt(5));
			System.out.println("Percentage : "+rs.getFloat(6));
			System.out.println();
			found=true;
        }
		if(!found)
        {
        	System.out.print("\nNo data is entered\n\n");
        }
	}
	
	
	void search(Connection con) throws SQLException
	{
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t3. SEARCH STUDENT\t|");
    	System.out.print("\n+-------------------------------+");
		
    	System.out.print("\n\nEnter Roll Number whose details is to be searched: ");
        int searchRoll=Integer.parseInt(sc.nextLine());
	
    	System.out.println("\n~~~ Search using ArrayList ~~~");
        for(Student st : s1)
        {
            if(st.roll==searchRoll)
            {
            	System.out.println("\nName     : "+st.name);
            	System.out.println("Roll number: "+st.roll);
            	System.out.println("  *** MARKS ***");
            	System.out.println("Marks      : "+st.eng);
            	System.out.println("Marks      : "+st.mat);
            	System.out.println("Marks      : "+st.sci);
            	System.out.println("Percentage      : "+st.result);
            	System.out.println();
                found = true;
            }
        }
        
        st = con.prepareStatement("SELECT * FROM StudentsDB.stud WHERE roll=?");
        st.setInt(1, searchRoll);
		System.out.println("Statement created");
		
		ResultSet rs=null;
		rs = st.executeQuery();
		
    	System.out.println("\n~~~ Search using Database ~~~");
		while(rs.next()) {
			System.out.println("Roll number:  : "+rs.getInt(1));
			System.out.println("Student name : "+rs.getString(2));
			System.out.println("Maths Marks : "+rs.getInt(3));
			System.out.println("Science Marks : "+rs.getInt(4));
			System.out.println("English Marks : "+rs.getInt(5));
			System.out.println("Percentage : "+rs.getFloat(6));
			System.out.println();
			found=true;
		}
		if(!found)
		{
			System.out.println("Data not found!");
		}
	}
	
	void update(Connection con)
	{
		int i=0;
		int updateRoll;
		int choice;
		if(total!=0)
        {
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t4. UPDATE STUDENT\t|");
    	System.out.print("\n+-------------------------------+\n");
		System.out.print("\nEnter the roll number: ");
		updateRoll=Integer.parseInt(sc.nextLine());
		int subch;
		
		for(Student st: s1)
		{
			i++;
			if(st.roll==updateRoll)
			{
				System.out.print("\nWhat do you want to udpate ? \n");
            	System.out.print("\n1.Name\n* Marks *\n2.Maths\n3.Science\n4.English\n0.Exit");
            	System.out.print("\n\nEnter your choice : ");
            	choice = Integer.parseInt(sc.nextLine());
            	
            	switch(choice)
            	{
            		case 1: 
            			System.out.print("\nOld Name is : "+st.name);
                    	System.out.print("\nEnter New Name : ");
                        String updateName=sc.nextLine();
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
	                        case 1:
	                            st.name=updateName;
	                            System.out.print("updated..\n");
	                            break;
	                        case 2:
	                            break;
	                        default:
	                        	System.out.print("SORRY Wrong input\n");
	                            break;
                        }
                        break;
                        
            		case 2: 
            			System.out.print("\n\nOld Maths Marks is : "+st.mat);
                    	System.out.print("\nEnter New Maths Marks : ");
                        int updateMat=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
	                        case 1:
	                            st.mat=updateMat;
	                			st.result=(st.eng+st.mat+st.sci)/3;
	                            System.out.print("updated..\n");
	                            break;
	                        case 2:
	                            break;
	                        default:
	                        	System.out.print("SORRY Wrong input\n");
	                            break;
                        }
                        break;
                        
            		case 3: 
            			System.out.print("\n\nOld Science Marks is : "+st.sci);
                    	System.out.print("\nEnter New Science Marks : ");
                        int updateSci=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
	                        case 1:
	                            st.sci=updateSci;
	                			st.result=(st.eng+st.mat+st.sci)/3;
	                            System.out.print("updated..\n");
	                            break;
	                        case 2:
	                            break;
	                        default:
	                        	System.out.print("SORRY Wrong input\n");
	                            break;
                        }
                        break;
                        
            		case 4: 
            			System.out.print("\n\nOld English Marks is : "+st.eng);
                    	System.out.print("\nEnter New Maths Marks : ");
                        int updateEng=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
	                        case 1:
	                            st.eng=updateEng;
	                			st.result=(st.eng+st.mat+st.sci)/3;
	                            System.out.print("updated..\n");
	                            break;
	                        case 2:
	                            break;
	                        default:
	                        	System.out.print("SORRY Wrong input\n");
	                            break;
                        }
                        break;
            		 
            		case 0:
                         break;

            		default:
            			System.out.println("\nwrong input");
            			break;
            		}
            		break;//compare two id if wala break
				}

				if(i==total-1)
				{
					System.out.println("No such record found");
				}
			}
        }
		else
		{
			System.out.println("No data is entered");
		}
	}
	
	void delete(Connection con)
	{
		if(total!=0)
        {
			int i=0;
			System.out.print("\n\n+-------------------------------+");
	    	System.out.print("\n| \t5. DELETE STUDENT\t|");
	    	System.out.print("\n+-------------------------------+\n");
			
	    	int select;
	    	System.out.print("\nWhat do you want to delete ? \n");
	    	System.out.print("\n1.Delete specific record\n2.Delete full record");
	    	System.out.print("\n\nEnter your choice : ");
	    	select = Integer.parseInt(sc.nextLine());
	    	
	    	if(select==1)
	    	{
	    		int deleteRoll;
	    		System.out.print("\nEnter Roll number of student which you want to delete : ");
	            deleteRoll=Integer.parseInt(sc.nextLine());

            for(Student st : s1)
            {
            	i++;
                if(st.roll==deleteRoll)
                {
                	s1.remove(i-1);
                    total--;
                    System.out.print("\nYour required record is deleted\n");
                    break;
                }
                if(i==total-1)
                {
                	System.out.print("\nNo such record found\n");
                }
            }
        }
        else if(select==2)
        {
            total=0;
            System.out.print("\nAll record is deleted\n");
        }
        else
        {
        	System.out.print("\nInvalid Input\n");
        }
    }
    else
    {
    	System.out.print("\nNo data is entered\n");
    }
    	
	}

}

public class Alien {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		int choice;
		boolean y = true;

		//Step 1 : Driver Registration
		
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		System.out.println("Driver Registered");
  		
  		//Step 2 : Connection Building
  		
  		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentsDB","root","abc123");
  		System.out.println("connected");	
  		

	    while(y)
	    {
	    	System.out.println("\n****Asterisc Classes****");
	    	System.out.println("\n1.Add Student");
	    	System.out.println("2.Show Students");
	    	System.out.println("3.Search Student");
	    	System.out.println("4.Update Student Record");
	    	System.out.println("5.Delete Student Record");
	    	System.out.println("0.Exit");
	    	System.out.print("\nEnter your choice = ");
	        choice=Integer.parseInt(sc.nextLine());

	        switch(choice)
	        {
	        case 1:
	    		s.add(con);
	    		break;
	        case 2:
	        	s.show(con);
	        	break;
	        	
	        case 3:
	        	s.search(con);
	        	break;
	        	
	        case 4:
	        	s.update(con);
	        	break;
	        	
	        case 5:
	        	s.delete(con);
	        	break;
	        	
	        case 0: 
	        	con.close();
	        	y=false;
	        	break;
	        	
	        default: System.out.println("You have entered wrong choice!");
	        }
	    }
	}
}

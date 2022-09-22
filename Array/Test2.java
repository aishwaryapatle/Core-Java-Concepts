import java.util.Scanner;

class Student
{
	int roll, eng, mat, sci;
	float result;
	String name;
	
	int total=0;
	Student s1[]=new Student[20];
	Scanner sc=new Scanner(System.in);
	
	void add()
	{	
        int user=0;
        System.out.print("\n\n+-------------------------------+");
        System.out.print("\n| \t1. ADD STUDENT\t\t|");
        System.out.print("\n+-------------------------------+");
		
        System.out.print("\n\nEnter numbers of Students : ");
        user=Integer.parseInt(sc.nextLine());
		
        for(int i=total; i<user+total; i++)
		{
			s1[i]=new Student();
        	System.out.println("\nEnter Student Number " + (i+1) + " Details\n");
			System.out.print("Enter your roll number : ");
			s1[i].roll=Integer.parseInt(sc.nextLine());
			System.out.print("Enter your name : ");
			s1[i].name = sc.nextLine();
			System.out.print("Enter English Marks : ");
			s1[i].eng=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Maths Marks : ");
			s1[i].mat=Integer.parseInt(sc.nextLine());
			System.out.print("Enter Science Marks : ");
			s1[i].sci=Integer.parseInt(sc.nextLine());
			s1[i].result=(s1[i].eng+s1[i].mat+s1[i].sci)/3;
			System.out.println();
		}
        total+=user;
	}
	
	void show()
	{
		if(total!=0)
        {
			System.out.print("\n\n+-------------------------------+");
	    	System.out.print("\n| \t2. SHOW STUDENT\t\t|");
	    	System.out.print("\n+-------------------------------+\n\n");
	    	System.out.println("\nName\tRoll Number\tMaths\tScience\tEnglish\tPercentage");
	
			for(int i=0;i<total;i++)
			{
				System.out.println(s1[i].name+"\t\t"+s1[i].roll+"\t"+s1[i].mat+"\t"+s1[i].sci+"\t"+s1[i].eng+"\t"+s1[i].result);
			}
			System.out.println();
        }
		else
        {
        	System.out.print("\nNo data is entered\n\n");
        }
	}
	
	void search()
	{
		if(total!=0)
        {
			int newRoll;
			System.out.print("\n\n+-------------------------------+");
	    	System.out.print("\n| \t3. SEARCH STUDENT\t|");
	    	System.out.print("\n+-------------------------------+");
			System.out.print("\n\nEnter Roll Number : ");
	        newRoll=sc.nextInt();
	
	        for(int i=0;i<total;i++)
	        {
	            if(s1[i].roll==newRoll)
	            {
	            	System.out.println("\nName     : "+s1[i].name);
	            	System.out.println("Roll number: "+s1[i].roll);
	            	System.out.println("  *** MARKS ***");
	            	System.out.println("Maths      : "+s1[i].mat);
	            	System.out.println("Science    : "+s1[i].sci);
	            	System.out.println("English    : "+s1[i].eng);
	            	System.out.println("Percentage : "+s1[i].result+" %");
	            	System.out.println();
	                break;
	            }
	            if(i==total-1)
	            {
	            	System.out.println("\nNo such record found");
	            	break;
	            }
	        }
        }
		else
        {
        	System.out.print("\nNo data is entered");
        }
	}
	
	void update()
	{
		if(total!=0)
        {
		System.out.print("\n\n+-------------------------------+");
    	System.out.print("\n| \t4. UPDATE STUDENT\t|");
    	System.out.print("\n+-------------------------------+\n");
		System.out.print("\nEnter the roll number: ");
		int newRoll=Integer.parseInt(sc.nextLine());
		int subch;

		
		for(int i=0; i<total; i++)
		{
			if(s1[i].roll==newRoll)
			{
				System.out.print("\nWhat do you want to udpate ? \n");
            	System.out.print("\n1.Name\n* Marks *\n2.Maths\n3.Science\n4.English\n0.Exit");
            	System.out.print("\n\nEnter your choice : ");
            	int choice = Integer.parseInt(sc.nextLine());
            	
            	switch(choice)
            	{
            		case 1: 
            			System.out.print("\nOld Name is : "+s1[i].name);
                    	System.out.print("\nEnter New Name : ");
                        String newName=sc.nextLine();
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
                        case 1:
                            s1[i].name=newName;
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
            			System.out.print("\n\nOld Maths Marks is : "+s1[i].mat);
                    	System.out.print("\nEnter New Maths Marks : ");
                        int newMat=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
                        case 1:
                            s1[i].mat=newMat;
                			s1[i].result=(s1[i].eng+s1[i].mat+s1[i].sci)/3;
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
            			System.out.print("\n\nOld Science Marks is : "+s1[i].sci);
                    	System.out.print("\nEnter New Science Marks : ");
                        int newSci=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
                        case 1:
                            s1[i].sci=newSci;
                			s1[i].result=(s1[i].eng+s1[i].mat+s1[i].sci)/3;
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
            			System.out.print("\n\nOld English Marks is : "+s1[i].eng);
                    	System.out.print("\nEnter New Maths Marks : ");
                        int newEng=Integer.parseInt(sc.nextLine());
        				System.out.print("\nDo you really want to change ?");
        				System.out.print("\n1.yes\n2.no\n");
        				System.out.print("Choice = ");
                        subch=Integer.parseInt(sc.nextLine());
                        
                        switch(subch)
                        {
                        case 1:
                            s1[i].eng=newEng;
                			s1[i].result=(s1[i].eng+s1[i].mat+s1[i].sci)/3;
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
	
	void delete()
	{
		if(total!=0)
        {
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
    		int tempRoll;
    		System.out.print("\nEnter Roll number of student which you want to delete : ");
            tempRoll=Integer.parseInt(sc.nextLine());

            for(int i=0;i<total;i++)
            {
                if(s1[i].roll==tempRoll)
                {
                	s1[i].name=s1[i+1].name;
                	s1[i].roll=s1[i+1].roll;
                	s1[i].eng=s1[i+1].eng;
                	s1[i].mat=s1[i+1].mat;
                	s1[i].sci=s1[i+1].sci;
                	s1[i].result=s1[i+1].result;
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

public class Test2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student s1=new Student();
		int choice;
		boolean y = true;

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
	    		s1.add();
	    		break;
	    		
	        case 2:
	        	s1.show();
	        	break;
	        	
	        case 3:
	        	s1.search();
	        	break;
	        	
	        case 4:
	        	s1.update();
	        	break;
	        	
	        case 5:
	        	s1.delete();
	        	break;
	        	
	        case 0:
	        	y=false;
	        	break;
	        	
	        default: System.out.println("\nYou have entered wrong choice :(");
	        }
        }
	}
}

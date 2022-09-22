
public class StringAlien1 {

	public static void main(String[] args) {
//		String name="javalanguage";  
//		char ch=name.charAt(4);//returns the char value at the 4th index  
//		System.out.println(ch); 
		
//		String s1="java string";  
//		s1.concat("is immutable");  
//		System.out.println(s1);  
//		s1=s1.concat(" is immutable so assign it explicitly");  
//		System.out.println(s1); 
//		
//		String name1="what do you know about me";  
//		System.out.println(name1.contains("do you know"));  
//		System.out.println(name1.contains("about"));  
//		System.out.println(name1.contains("hello"));  
//		
//		String s1="java programming language";  
//		System.out.println(s1.endsWith("language"));  
//		System.out.println(s1.startsWith("Hello"));  
//		
//		StringBuffer a = new StringBuffer("Java programming is fun");
//	    System.out.println(a.reverse());
//	    
//	    String s1="hello";  
//	    String s2="hello";  
//	    String s3="meklo";  
//	    String s4="hemlo";  
//	    System.out.println(s1.compareTo(s2));  
//	    System.out.println(s1.compareTo(s3));  
//	    System.out.println(s1.compareTo(s4));  
//	    
//	    int n, reverse = 0;
//	    
//	      System.out.println("Enter the number to reverse");
//	      Scanner in = new Scanner(System.in);
//	      n = in.nextInt();
//	 
//	      while( n != 0 )
//	      {
//	          reverse = reverse * 10;
//	          reverse = reverse + n%10;
//	          n = n/10;
//	      }
//	      System.out.println("Reverse of entered number is "+reverse);
//	      
//	      
//	      String original, reverse = "";
//	      Scanner in = new Scanner(System.in);
//	 
//	      System.out.println("Enter a string to reverse");
//	      original = in.nextLine();
//	 
//	      int length = original.length();
//	 
//	      for ( int i = length - 1 ; i >= 0 ; i-- )
//	         reverse = reverse + original.charAt(i);
//	      System.out.println("Reverse of entered string is: "+reverse);
//	      
//	      
//	      int x=5,y=5;
//	      if(x==y){
//	      System.out.println("t");}else{
//	      System.out.println("f");}
//	      
//	      
//	      String s1="java string split method by java";  
//	      String[] words=s1.split("\\s");//splits the string based on string  
//	      //using java for each loop to print elements of string array  
//	      for(String w:words){  
//	      	System.out.println(w);  
//	      }  
//	      
//	      
//	      	String s="hello";  
//          System.out.println(s.substring(0,2));//he
//
//			String s="Sachin Tendulkar";  
//          System.out.println(s.substring(6));// Tendulkar  
//          System.out.println(s.substring(0,6));//Sachin 
//			
//			String s="Sachin";  
//			System.out.println(s.toUpperCase());//SACHIN  
//			System.out.println(s.toLowerCase());//sachin  
//				 
//			String s="  Sachin  ";  
//			System.out.println(s);//  Sachin    
//			System.out.println(s.trim());//Sachin
//			
//			String s1="Java is a programming language. Java is a platform. Java is an Island.";    
//          String replaceString=s1.replace("Java","Kava");//replaces all occurrences of "Java" to "Kava"    
//          System.out.println(replaceString);
//		  
//			String s="Sachin";  
//			System.out.println(s.charAt(0));//S  
//			System.out.println(s.charAt(3));//h
		
//			String s1="ABCDEFG";  
//			byte[] barr=s1.getBytes();  
//			for(int i=0;i<barr.length;i++){  
//				System.out.println(barr[i]); 
//			}
		
//			String s1="hello";  
//			char[] ch=s1.toCharArray();  
//			for(int i=0;i<ch.length;i++){  
//			System.out.print(ch[i]); }
		
		String s1="  hello string   ";  
		System.out.println(s1+"javaprogramming");//without trim()  
		System.out.println(s1.trim()+" javaprogramming");//with trim() 
	}
}

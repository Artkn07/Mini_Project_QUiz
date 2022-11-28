package com.velocity.miniproject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMarks {
	

	public void getStudentMark() throws Exception
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_competetion", "root","root");
		Statement st2=con.createStatement();
		ResultSet results=null;
		Scanner sc=new Scanner(System.in);
		BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
		String s1="select * from studentdata";
		st2.execute(s1);
		
		 while(true)
         {
         System.out.println("Enter Students Roll Number : ");
         int sRno=Integer.parseInt(br2.readLine());
         
         System.out.println("ROllNo\t Name\t Marks\t Grade\t Remark");
         System.out.println("========================================");
         System.out.println();
          results=st2.executeQuery("select * from Studentdata");
         
         while(results.next())
         {
        	 if(sRno==results.getInt(1))
        	 {
        		 System.out.print(results.getInt(1)+"\t");
        		 System.out.print(results.getString(2)+"\t");
        		 System.out.print(results.getInt(3)+"\t");
        		 System.out.print(results.getString(4)+"\t");
        		 System.out.print(results.getString(5)+"\t");
        		 System.out.println();
        		 break;
        		  }
        	 
        	
         }
         System.out.print("Dou you want to see the record of any other Student[yes/No]");
         String nextRec=br2.readLine();
         if(nextRec.equalsIgnoreCase("yes"))
         {
        	 continue;
        	 }
         else
         {
        	 System.out.println("Thank You!!");
        	 break;
         }
         }
         
         //Closing the resources
      /*   
       st2.close();
        con.close();
        br2.close();
        sc.close();
        results.close();
       */  
         
	}

}

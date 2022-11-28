package com.velocity.miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class StudentEnrollment {
	

	static int rollNo;
	static String name;
	int correct=0;
	int incorrect=0;
	

	
	
	
	
	public void getEnrollment()throws Exception
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_competetion", "root","root");
			Statement st=con.createStatement();
			ResultSet rs=null;
								
			Scanner sc=new Scanner(System.in);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StudentEnrollment se=new StudentEnrollment();
		    // StudentInfo si=new StudentInfo();
		    
		//	DatabaseConnection dbc=new DatabaseConnection();
			
			System.out.println("welcome Students to the Quiz Competetion");
			
			System.out.println("-------------------------------------");
			
			System.out.println("Please Enroll for the Quiz Competetion");
			
			System.out.println("***************************************");
			
			System.out.print(" Enter roll number[Between 1-10 and Unique] : ");
			
			se.rollNo=Integer.parseInt(br.readLine());
			
			System.out.print("Enter Your Name :");
			
			se.name=br.readLine();
			
		
			
			String query="insert into studentdata(ROll_No, Student_Name) values("+StudentEnrollment.rollNo+",'"+StudentEnrollment.name+"')";
			
			st.execute(query);
			
			System.out.println("You Enrolled Successfully");
				
								
								
	}
	
	
	public void testStart() throws Exception
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_competetion", "root","root");
			Statement st=con.createStatement();
			ResultSet rs=null;
			Scanner sc=new Scanner(System.in);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//StudentInfo si=new StudentInfo();
			 StudentEnrollment se=new StudentEnrollment();
			// StartTest start=new StartTest();
			
		//	DatabaseConnection dbc=new DatabaseConnection();
			
			System.out.println("name is : "+StudentEnrollment.name);
			System.out.println("Roll No Is : "+StudentEnrollment.rollNo);
			
			
		
			rs=st.executeQuery("select * from quiz order by rand() limit 10");
			
			System.out.println("==============================");
			System.out.println();
			System.out.println("Your Test Starts Now\n Best Luck!!");
			System.out.println("\n\n\n");
			
			System.out.println("Test : \n\n");
			
			System.out.println(se.name);
			System.out.println(se.rollNo);
			
			se.correct=0;
			se.incorrect=0;
			
			

	int j=1;
	while(rs.next())//boolean  true
	{
		
	System.out.println("Q:"+j+" "+rs.getString(1));
	System.out.println("1) "+rs.getString(2));
	System.out.println("2) "+rs.getString(3));
	System.out.println("3) "+rs.getString(4));
	System.out.println("4) "+rs.getString(5));

	System.out.print("Your Answer : ");

	int answer=sc.nextInt();

	if(answer==rs.getInt(6))
	{
		se.correct++;
		System.out.println("Correct Answer");
		System.out.println("\n\n");
	}
	else
	{
		se.incorrect++;
		System.out.println("Incorrect Answer");
		}

	j++;
	}
	
	System.out.println("Correct Answers are : "+se.correct);
	System.out.println("Incorrect Answers are : "+se.incorrect);
	st.execute("use quiz_competetion");
	
	String query1="select * from studentdata";
	st.execute(query1);

	String query2="update studentdata set marks="+se.correct+" where ROll_No="+this.rollNo;
	st.execute(query2);
	
	String query3="update studentdata set Grade='A' where ROll_No="+this.rollNo;
	String query4="update studentdata set Grade='B' where ROll_No="+this.rollNo;
	String query5="update studentdata set Grade='C' where ROll_No="+this.rollNo;
	String query6="update studentdata set Grade='D' where ROll_No="+this.rollNo;
	String query7="update studentdata set remark='Pass' where ROll_No="+this.rollNo;
	String query8="update studentdata set remark='Failed' where ROll_No="+this.rollNo;
	if(se.correct>=8)
	{
		st.execute(query3);
	}
	else if(se.correct>=6 && se.correct<8)
	{
		st.execute(query4);
	}
	else if(se.correct==5)
	{
		st.execute(query5);
	}
	else if(se.correct<5)
	{
		st.execute(query6);
		st.execute(query8);
	}
	
	if(se.correct>=5)
	{
		st.execute(query7);
	}
	
	}

}

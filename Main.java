package com.velocity.miniproject;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		 StudentEnrollment se1=new StudentEnrollment();
		// StartTest start=new StartTest();
		 StudentMarks sm=new StudentMarks();
		 DatabaseConnection dc=new DatabaseConnection();
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 
		 while(true)
		 {
			 se1.getEnrollment();
			 se1.testStart();
			 
			 System.out.println("Does the next user want to take the test[yes/no]");
			 String nextUser=br.readLine();
			 if(nextUser.equalsIgnoreCase("yes"))
			 {
				 continue;
			 }
			 else {
				 System.out.println("Thanks for Attending Test ");
				 break;
			 }
		 }
		 
		 
		 while(true)
		 {
			 System.out.println("Do you want to see the Students record[Enter 1]  : ");
			 System.out.println("Do you want see the record of particular Student[Enter 2] : ");
			 System.out.println("Enter 0 to Exit : ");
			
			 int sRecord=Integer.parseInt(br.readLine());
			 
			
			 
			 if(sRecord==1)
			 {
				 dc.showStudentTable();
				 System.out.println("Do you want to Continue[Y/N] : ");
				 String conti=br.readLine();
				 if(conti.equalsIgnoreCase("Y"))
				 {
					 continue;
				 }
			
			 }
			 else if(sRecord==2)
			 {
				 sm.getStudentMark();
				 System.out.println("Do you want to Continue[Y/N] : ");
				 String conti=br.readLine();
				 if(conti.equalsIgnoreCase("Y"))
				 {
					 continue;
				 }
				 else 
				 {
				 System.out.println("Thank You For Visiting!!");
				 break;
				 }
			 }
			 
			 if(sRecord==0)
			 {
				 System.out.println("Thank You For Visiting");
				 break;
			 }
			 
			 }
			 
			  }
}

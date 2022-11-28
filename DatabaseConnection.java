package com.velocity.miniproject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {
public void showStudentTable() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_competetion", "root","root");
		Statement st1=con.createStatement();
		ResultSet resultset=null;
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1="select * from studentdata";
		st1.execute(s1);
		while(true)
		{
		System.out.println("if you want to see students marks with ascending order Enter 1 and for descending order press 2 : ");
		int sAscOrder=Integer.parseInt(br.readLine());
				
		if(sAscOrder==1)
		{
		resultset=st1.executeQuery("select * from studentdata order by Marks ASC");
		
		System.out.println("ROll_No\t Student_Name\t Marks");
		System.out.println("================================");
		
		while(resultset.next())
		{
			System.out.print(resultset.getInt(1)+"\t");
			System.out.print(resultset.getString(2)+"\t");
			System.out.print(resultset.getInt(3)+"\t");
			System.out.print(resultset.getString(4)+"\t");
			System.out.print(resultset.getString(5)+"\t");
			System.out.println();
		}
		
		}
		else if(sAscOrder==2)
		{
			resultset=st1.executeQuery("select * from studentdata order by Marks DESC");
		
		System.out.println("ROll_No\t Student_Name\t Marks");
		System.out.println("================================");
		
		while(resultset.next())
		{
			System.out.print(resultset.getInt(1)+"\t");
			System.out.print(resultset.getString(2)+"\t");
			System.out.print(resultset.getInt(3)+"\t");
			System.out.print(resultset.getString(4)+"\t");
			System.out.print(resultset.getString(5)+"\t");
			System.out.println();
		}
		}
		
		System.out.print("Do You want to see Recoed again[yes/no]");
		String showRecAgain=br.readLine();
		
		if(showRecAgain.equalsIgnoreCase("yes"))
		{
			continue;
			}
		
		else {
			
			System.out.println("Thank You!!");
			break;
		}
		}
		
		//close the resources
	/*	br.close();
		sc.close();
		st1.close();
		con.close();
		resultset.close();*/
		}

}

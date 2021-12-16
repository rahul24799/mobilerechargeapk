package com.mobilerechargeapk.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.mobilerechargeapk.dao.AdminDao;
import com.mobilerechargeapk.dao.OperatorDao;
import com.mobilerechargeapk.dao.UserDao;
import com.mobilerechargeapk.model.Admin;
import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;

public class MobileRechargeMain {

	public static void main(String[] args) throws SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println(" Admin login");
		
//char correct='y';
//while(correct=='y') {
			String adminName=null;
		   do {
	    System.out.println("enter the Admin name");
		 adminName=scan.nextLine();
		if(!adminName.matches("[a-zA-Z]+{20}")){
	     	System.out.println("name Should be below 20 char");
		}
		if(adminName.isEmpty()) {
			System.out.println("invalid name");
		}
		}while(!adminName.matches("[a-zA-Z]+{20}") ||adminName.isEmpty());
			
		String password=null;
		do{
		System.out.println("enter the password");
		 password=scan.nextLine();
		if(!password.matches("[0-9a-zA-Z@#*]+{8}")) {
			System.out.println("invalid password");
		}
		if(password.isEmpty()) {
			System.out.println("password invalid");
		}
		}while(!password.matches("[0-9a-zA-Z@#*]+{8}") && password.isEmpty());
	    AdminDao adminDao=new AdminDao();
	    boolean result=false;
	    result=adminDao.validateAdmin(adminName, password);
	    UserDao userdao=null;
	    
	    if(result==false)
	    {
	    	System.out.println("");
	    }
    else {
//	    	System.out.println("invalid admin");
//		    	//System.out.println("re-enter Adminname and password:");
//		    	System.out.println("Do you want to re-enter:y/n");
//		    	correct=scan.nextLine().charAt(0);
		  }
	    
		System.out.println("\n1.Register\n2.login \n Enter your choice");
		int choice=Integer.parseInt(scan.nextLine());
		
		switch(choice) {
		case 1:
			String name=null;
			long number=0;
			Double wallet=0.;
			do {
			System.out.println("Enter User Name:");
			name=scan.nextLine();
			if(!name.matches("[a-zA-z]+{3,}")) {
				System.out.println("Enter name maximum 3 character");
			}
			if(name.isEmpty()) {
			System.out.println("name can not be empty");
		    }
		    }while(!name.matches("[a-zA-z]+{3,}")||name.isEmpty());
			
			String mail=null;
			do {
			System.out.println("Enter Email_id:");
			 mail=scan.nextLine();
			if(!mail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
		    System.out.println("Enter valid mail address");
			}
			if(mail.isEmpty()) {
			System.out.println("Mail cannot be empty");
		    }
		    }while(!mail.matches( "[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || mail.isEmpty());
			
			String tempnum=null;
			do {
			System.out.println("Enter Mobile number:");
		     tempnum=scan.nextLine();
		     if(!tempnum.matches("[0-9]{10}")) {
		    	 System.out.println("enter valid 10 digit mobile number");
		     }
		    if(tempnum.isEmpty()) {
		    	System.out.println("mobile number do not empty");
		    }
			}while(!tempnum.matches("[0-9]{10}") || tempnum.isEmpty());
			number=Long.parseLong(tempnum);
			
			String pwd=null;
			do {
		    System.out.println("Enter your password");
		     pwd=scan.nextLine();
		    if(!pwd.matches("[0-9a-zA-Z@#$*]{8,16}")) {
		    	System.out.println("Enter the valid password");
		    }
		    if(pwd.isEmpty()) {
		    	System.out.println("Empty password cannot be valid");
		    }
			}while(!pwd.matches("[0-9a-zA_Z@#$*]{8,16}") ||pwd.isEmpty());
			
			String tempwallet=null;
			do {
		    System.out.println("Enter your wallet");
		     tempwallet=(scan.nextLine());
		     if(!tempwallet.matches("[0-9]+{0,}")) 
		     {
			   System.out.println("payment wallet amount insufficient balance");
			  }
		    if(tempwallet.isEmpty()) {
		    System.out.println("payment wallet is empty");
		    }
			}while(!tempwallet.matches("[0-9]{0,}") ||tempwallet.isEmpty());
			wallet=Double.parseDouble(tempwallet);
			
			
		    System.out.println("Enter Operator Name");
		    String operatorName=scan.nextLine();
//		    if(operatorName.isEmpty())
		    Operator operator=new Operator();
		    operator.setOperatorname(operatorName);
		    User user=new User(name,mail,number,pwd,wallet,operator);
		    userdao=new UserDao();
		    userdao.insertUser(user);
		    
		    
		case 2:
			//user=new User();
			String Emailid=null;
			userdao=new UserDao();
		    System.out.println("User Login");
		    do {
		    System.out.println("Enter the  Emailid");
		     Emailid=scan.nextLine();
		    if(!Emailid.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")){
		    	System.out.println("valid email id");
		    }
		     
		    if(Emailid.isEmpty()) {
		    	System.out.println("invalid mailid");
		    }
		    }while(!Emailid.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || Emailid.isEmpty());
		   
		     do {
		     System.out.println("enter the password");
		     password=scan.nextLine();
		     if(!password.matches("[0-9a-zA-Z@#$*]{8,16}")) {
		     System.out.println("invalid password");
		   }
		    if(password.isEmpty()) {
		    System.out.println("password should be filled");
		   }
		    } 
		     while(!password.matches("[0-9a-zA-Z@#$*]{8,16}") ||password.isEmpty());
		     
		    User currentUser=userdao.validiateUser(Emailid,password);
		    if(currentUser!=null) {
		    	System.out.println("welcome"+" "+currentUser.getUsername());
		     }
		    else {
		    	System.out.println("invalid entry");
		    }
		    
		    
		    
		    
		}	
	  }
		
	 }
// }


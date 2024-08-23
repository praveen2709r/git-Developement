package BankSBI;

import java.sql.SQLException;
import java.util.Scanner;

public class BankWebPage {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to SBI");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for new user 2 for Existing user");
		int userInput=sc.nextInt();
		if(userInput==1) {
			NewUser.accRegisteration();
			System.out.println("Your Account is successfully created");
			System.out.println("Your New Account number is :"+NewUser.getRan_Acc());
			System.out.println("Your temporary password is :"+NewUser.getPin());
		}
		else {
			System.out.println("Enter your account number :");
			long acc_no=sc.nextLong();
			String user_name= ExistingUser.authenticate(acc_no);
			System.out.println("Confirm your name: "+user_name);
			System.out.println("enter 1 to confirm 2 to exit");
			int input=sc.nextInt();
			if(input==1) {
				BankInterface.bankInterface(user_name,acc_no);
			}
		}
	}

}

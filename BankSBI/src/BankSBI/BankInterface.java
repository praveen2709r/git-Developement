package BankSBI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankInterface {
	
	
	static void bankInterface(String name,long acc_no) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome"+name);
		System.out.println("Select your transaction");
		System.out.println("1.Withdrawal");
		System.out.println("2.Deposit");
		System.out.println("3.Balance Enquiry");
		System.out.println("4.PIN Change");
		int input=sc.nextInt();
		if(input==1) {
			withdrawal(acc_no);
		}
		else if(input==2) {
			desposit(acc_no);
		}
		else if(input==3){
			balanceEnquiry(acc_no);
		}
		else {
			pinChange(acc_no);
		}
	}
	static void withdrawal(long acc_no) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount :");
		long amount=sc.nextLong();
		System.out.println("Enter your PIN :");
		int pin=sc.nextInt();
		if(pinCheck(pin,acc_no)) {
		String query="select savings from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		long sav=set.getLong(1);
		long rem_Balance=sav-amount;
		if(sav<amount) {
			System.out.println("Insufficient Balance");
		}
		else {
			System.out.println("Collect your cash");
			updateSavings(rem_Balance,acc_no);
			balanceEnquiry(acc_no);
		}
		}
		
	}
	static boolean pinCheck(int user_pin,long acc_no) throws SQLException {
		String query="select pin from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		int pin=set.getInt(1);
		if(pin==user_pin)
			return true;
		return false;
	}
	static void desposit(long acc_no) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your PIN :");
		int pin=sc.nextInt();
		if(pinCheck(pin,acc_no)) {
		System.out.println("Enter the amount to wish to add to your account");
		long deposit_Amount=sc.nextLong();
		String query="select Savings from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		long sav=set.getLong(1);
		long newSaving=sav+deposit_Amount;
		updateSavings(newSaving,acc_no);
		balanceEnquiry(acc_no);
		}
	}
	static void updateSavings(long newSavings,long acc_No) throws SQLException{
		String query="update SBI set Savings=? where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, newSavings);
		st.setLong(2, acc_No);
		st.executeUpdate();
	}
	static void balanceEnquiry(long acc_no) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your PIN :");
		int pin=sc.nextInt();
		if(pinCheck(pin,acc_no)) {
		System.out.print("Your available balance is :");
		String query="select savings from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		System.out.println(set.getLong(1));
		}
	}
	static void pinChange(long acc_no) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your pin :");
		int tempPin=sc.nextInt();
		String query="select pin from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		int pin=set.getInt(1);
		if(pin==tempPin) {
			System.out.println("Enter your new pin");
			int newPin=sc.nextInt();
			System.out.println("confirm your new pin");
			int newPin2=sc.nextInt();
			if(newPin==newPin2) {
				updatePin(acc_no,newPin);
				System.out.println("your pin has successfully changed");
			}
		}
	}static void updatePin(long acc_No,int newPin) throws SQLException{
		String query="update SBI set pin=? where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, newPin);
		st.setLong(2, acc_No);
		st.executeUpdate();
	}
}

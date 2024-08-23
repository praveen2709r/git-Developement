package BankSBI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class NewUser {

	//private static int count=1;
	private static String userName;
	private static long phoneNumber;
	private static long savings=0;
	static Random rand = new Random();
	   
    public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		NewUser.userName = userName;
	}
	public static long getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(long phoneNumber) {
		NewUser.phoneNumber = phoneNumber;
	}
	public static long getSavings() {
		return savings;
	}
	public static void setSavings(long savings) {
		NewUser.savings = savings;
	}
	public static int getRan_Acc() {
		return ran_Acc;
	}
	public static void setRan_Acc(int ran_Acc) {
		NewUser.ran_Acc = ran_Acc;
	}
	private static int ran_Acc = rand.nextInt(1000); 
	private static int pin=rand.nextInt(10000);
	public static void getInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name");
		userName=sc.nextLine();
		System.out.println("Enter your Phone Number");
		phoneNumber=sc.nextLong();
		
		
	}
	public static int getPin() {
		return pin;
	}
	public static void setPin(int pin) {
		NewUser.pin = pin;
	}
	public static void accRegisteration() throws SQLException {
		getInfo();
		String query="insert into SBI values (?,?,?,?,?)";
		Connection con=DBConnection.getConnection();
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, userName);		
		st.setLong(2,phoneNumber);
		st.setInt(3, ran_Acc);
		st.setLong(4, savings);
		st.setInt(5, pin);
		st.executeUpdate();
	}
	
	
}

package BankSBI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExistingUser {
	static String authenticate(long acc_no) throws SQLException{
		String query="select customer_Name from SBI where account_Number=?";
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		st.setLong(1, acc_no);
		ResultSet set=st.executeQuery();
		set.next();
		return set.getString(1);
	}
}

package modellayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOservice1Impl implements DAOservice1 {
private Connection con;
private Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psa", "root", "Rahsan56@");
		     stmnt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void Saveregistration1(String name, String city, String email, String mobile) {
		try {
		stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}

	}

	@Override
	public ResultSet getAll() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteregistration(String email) {
		try {
			stmnt.executeUpdate("Delete from registration where email='"+email+"'");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateregistration1(String email, String mobile) {
try {
	stmnt.executeUpdate("Update registration SET mobile='"+mobile+"' where email='"+email+"'");	
} catch (Exception e) {
e.printStackTrace();
		}
		
	}

	@Override
	public void savelogininfo(String email, String password) {
		try {
			stmnt.executeUpdate("insert into login values('"+email+"','"+password+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
	}

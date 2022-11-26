package modellayer;

import java.sql.ResultSet;

public interface DAOservice1 {

	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public void Saveregistration1(String name, String city, String email, String mobile);
	public ResultSet getAll();
	public void deleteregistration(String email);
	public void updateregistration1(String email, String mobile);
	public void savelogininfo(String email, String password);
	
	
}

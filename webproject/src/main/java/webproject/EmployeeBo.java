package webproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBo {
	static Connection connection = null;
	String url ="jdbc:mysql://localhost:3306/jdbc";
	String username ="root";
	String password ="Mechboy@345";
	String Insert_Qry="Insert into `employee` (id,name,email,department,salary) values(?,?,?,?,?)";
	static PreparedStatement ps =null;
	
	
	

	public EmployeeBo() {
		// TODO Auto-generated constructor stub
	}

	public int save(Employee e) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
			ps =connection.prepareStatement(Insert_Qry);
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getDepartment());
			ps.setInt(5,e.getSalary());
			
			int i =ps.executeUpdate();
			
			return 1;
			

			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
			
		
		
	}
	
	

}

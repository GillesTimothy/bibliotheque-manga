import java.sql.*;

public class Connecter {
	
	Connection con;
	public Connecter() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.println(e); 
		}	
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collection", "root", "");
		} catch(SQLException e) {System.err.println(e);}
	}
	Connection obtenirconnexion() {
		return con;
	}

}

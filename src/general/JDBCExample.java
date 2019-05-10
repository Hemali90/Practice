package general;import java.sql.*;
public class JDBCExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection established");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","");
			Statement st=con.createStatement();
			st.execute("insert into student values(12,'Hiten','hiten.shah@gmail.com');");
			con.close();
			System.out.println("Connection closed");
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}

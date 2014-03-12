package ampro;

import java.sql.*;

//CLASE DE CONEXION CON MYSQL
class Conexion 
{
	//INICIA CONEXION
	protected static Connection conectar() 
	{
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ampro", "root", "jmora");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		}

	//CIERRA CONEXION
	protected static void desconectar(Connection connection) 
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
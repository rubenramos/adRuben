package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class MySql {
	
	private static Scanner scanner = new Scanner (System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//java -cp .:/usr/share/java/mysql.jar serpis.ad.MySql
		//Es para poder ejecutarlo desde la consola y importar las librerias Sql.
		//Class.forName("com.mysql.jdbc.Driver"); Necesario en tipo 3 o anterior.
		System.out.println("Hola MySql desde eclipse");
		System.out.println("Dime tu nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Hola "+nombre+" bienvenido!!");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba?user=root&password=sistemas"
				);
		//Statement statement = connection.createStatement();
		//ResultSet resultSet = statement.executeQuery("select * from categoria");
		
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from categoria where nombre like ?"
				);
		preparedStatement.setObject(1, "%ben%");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
			System.out.printf("id=%4s nombre=%s\n",
					resultSet.getObject("id"), resultSet.getObject("nombre"));
		
		resultSet.close();
		//statement.close();
		preparedStatement.close();
		connection.close();
		scanner.close(); //puede ponerse o no.

	}

}

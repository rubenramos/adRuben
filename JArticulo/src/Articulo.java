import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Articulo {
	
	private static Scanner scanner 	= new Scanner (System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba?user=root&password=sistemas"
				);
		
		
		ResultSet resultSet;
		
		System.out.println("---------- Gestion de la Base de Datos ----------");
		System.out.println("0.- Salir");
		System.out.println("1.- Nuevo");
		System.out.println("2.- Editar");
		System.out.println("3.- Eliminar");
		System.out.println("4.- Visualizar");
		System.out.println();
		System.out.println("Seleccione la opción que desea realizar: ");
		
		int opcion = scanner.nextInt();
	
		
		switch(opcion){
		case 0: {
			System.out.println("Gracias por utilizar este programa, hasta pronto.");
			System.exit(0);
			connection.close();	
			break;
		}
		case 1: {
			System.out.println("Has elegido Nuevo");
			break;
		}
		case 2: {
			System.out.println("Has elegido Editar");
			break;
		}
		case 3: {
			System.out.println("Has elegido Eliminar");
			break;
		}
		case 4: {
			Statement visualizar = connection.createStatement();
			System.out.println("-------Base de Datos-------");
			resultSet = visualizar.executeQuery("select * from categoria");
			while(resultSet.next()){
				System.out.printf("id=%4s || nombre=%s || precio=%s  || cat=%s\n" , resultSet.getObject("id"), resultSet.getObject("nombre"), resultSet.getObject("precio"), resultSet.getObject("cat"));
			}
			visualizar.close();
			resultSet.close();
			break;
		}
		}


	}

}

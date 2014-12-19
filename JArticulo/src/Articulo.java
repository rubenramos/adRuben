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

		while(true){
			
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
			System.out.println("Has elegido añadir un registro nuevo");
			System.out.println("Introduce nombre:");
			String nombre = scanner.next();
			System.out.println("Introduce precio:");
			int precio = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Introduce categoría:");
			String categoria = scanner.nextLine();
			
			PreparedStatement insert = connection.prepareStatement(
					"insert into categoria (nombre, precio, cat) values (?, ?, ?)"
					);
			insert.setObject(1, nombre);
			insert.setObject(2, precio);
			insert.setObject(3, categoria);
			insert.execute();
			insert.close();
			System.out.println("Registro añadido con éxito");
			
			break;
		}
		case 2: {
			System.out.println("Has elegido Editar");
			System.out.println("Escribe el id del elemento que deseas modificar");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Escribe el nuevo nombre");
			String nombre = scanner.nextLine();
			System.out.println("Escribe el nuevo precio");
			int precio = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Escribe la nueva categoria");
			String categoria = scanner.nextLine();
			System.out.println();
			
			PreparedStatement insert = connection.prepareStatement(
					"insert into categoria (nombre, precio, cat) values (?, ?, ?)"
					);
			insert.setObject(1, nombre);
			insert.setObject(2, precio);
			insert.setObject(3, categoria);
			insert.execute();
			insert.close();
			
			break;
		}
		case 3: {
			System.out.println("Has elegido Eliminar, introduce el id que deseas eliminar");
			int idSelec = scanner.nextInt();
			PreparedStatement eliminar = connection.prepareStatement("delete from categoria where id=?");
			//("select int from categoria");
			eliminar.setInt(1, idSelec);
			eliminar.execute();
			eliminar.close();
			System.out.println("Se ha eliminado los datos del id ="+idSelec);
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
}
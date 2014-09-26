using System;
using MySql.Data.MySqlClient;
namespace PHolaMySql
{
	class MainClass
	{
		public static void Main (string[] args)
		{

			MySqlConnection mySqlConnection = new MySqlConnection (
				"Server=localhost;Database=dbprueba;User ID=root;Password=sistemas"
				);

			mySqlConnection.Open ();

			Console.WriteLine ("Hello MySql");

//			MySqlCommand mySqlCommand = mySqlConnection.CreateCommand ();
//			mySqlCommand.CommandText = 
//				string.Format ("insert into categoria (nombre) values ('{0}')", DateTime.Now);
//
//			mySqlCommand.ExecuteNonQuery ();

			MySqlCommand mySqlCommand = mySqlConnection.CreateCommand ();
				mySqlCommand.CommandText = "select * from categoria";

			MySqlDataReader mySqlDataReader = mySqlCommand.ExecuteReader ();

			Console.WriteLine ("FieldCount={0}", mySqlDataReader.FieldCount);
			for (int index =0; index < mySqlDataReader.FieldCount; index++)
				Console.WriteLine ("column {0}={1}", index, mySqlDataReader.GetName (index));
			//			mySqlDataReader.GetFieldType();
			while (mySqlDataReader.Read()) {

				//Devolveria el valor de la columna 0 
				//mySqlDataReader.GetValue (0);

				//Devolvera el valor de la columna "id" 
				object id = mySqlDataReader ["id"];
				object nombre = mySqlDataReader ["nombre"];
				//Los números negativos son para los espacios.
				Console.WriteLine ("id={0, -10} nombre={1, -20} *", id, nombre);
			}

			mySqlDataReader.Close ();
			mySqlConnection.Close ();

		}
	}
}

package view;

import model.logic.Modelo;

public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Crear Arreglo Dinamico de videos de Youtube");
		System.out.println("2. Crear Lista Encadenada de videos de Youtube");
		System.out.println("3. Cargar Datos");
		System.out.println("4. Cantidad de videos registrados");
		System.out.println("5. Informacion del primer video");
		System.out.println("6. Informacion del ultimo video");
		System.out.println("7. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		

	public void printModelo(Modelo modelo)
	{
		// TODO implementar
		for (int i = 1; i<=modelo.darTamano(); i++)
		{
			System.out.println(modelo.darDatos().getElement(i));
		}
	}
}

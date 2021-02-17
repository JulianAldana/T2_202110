package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nCreando Arreglo Dinámico \n");
				int capacidad = lector.nextInt();
				modelo = new Modelo(capacidad); 
				view.printMessage("Arreglo Dinamico creado"+ "\n---------");
				break;

			case 2:
				view.printMessage("--------- \nCreando Lista encadenada \n");
				modelo = new Modelo();
				view.printMessage("Lista encadenada creada"+ "\n---------");					
				break;

			case 3:
				view.printMessage("--------- \nCargando Datos \n");
				long start = System.currentTimeMillis();
				try {
					modelo.cargarDatosCSV();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				view.printMessage("Carga finalizada");
				long end = System.currentTimeMillis();
				//finding the time difference and converting it into seconds
				float sec = (end - start) / 1000F;
				view.printMessage("Duracion de: "+sec + " segundos");
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 4: 
				view.printMessage("--------- \n");
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 5: 
				view.printMessage("--------- \nInformacion del primer dato: ");
				view.printMessage("Primer video " + modelo.darPrimerVideo().darPresentacion() + "\n---------");						
				break;

			case 6: 
				view.printMessage("--------- \nInformacion del último dato: ");
				view.printMessage("Último video " + modelo.darUltimoVideo().darPresentacion() + "\n---------");						
				break;

			case 7: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}

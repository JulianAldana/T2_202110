package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaArregloDinamico;
import model.data_structures.ListaSencillamenteEncadenada;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ILista<YoutubeVideo> datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ListaSencillamenteEncadenada<YoutubeVideo>();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ListaArregloDinamico<YoutubeVideo>(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(YoutubeVideo dato)
	{	
		datos.addLast(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public YoutubeVideo buscar(YoutubeVideo dato)
	{
		YoutubeVideo videoEncontrado = null;
		int index = datos.isPresent(dato);
		if (index > 0 )
		{
			videoEncontrado = datos.getElement(index);
		}
		return videoEncontrado;
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public YoutubeVideo eliminar(YoutubeVideo dato)
	{
		YoutubeVideo videoEncontrado = null;
		int index = datos.isPresent(dato);
		if (index > 0 )
		{
			videoEncontrado = datos.deleteElement(index);
		}
		return videoEncontrado;
	}

	/**
	 * Requerimiento para retornar los datos
	 * @return ILista con los videos
	 */
	public ILista<YoutubeVideo> darDatos()
	{
		return datos;
	}


	public YoutubeVideo darPrimerVideo()
	{
		return datos.firstElement();
	}

	public YoutubeVideo darUltimoVideo()
	{
		return datos.lastElement();
	}

	public void cargarDatosCSV() throws FileNotFoundException
	{
		//Reader in = new FileReader("data/videos-all.csv");
		Reader in = new FileReader("data/videos-small.csv");
		try {
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				String id = record.get("video_id");
				String trending_date = record.get("trending_date");
				String title = record.get("title");
				String channel_title = record.get("channel_title");
				String category_id = record.get("category_id");
				String publish_time = record.get("publish_time");
				String tags = record.get("tags");
				String views = record.get("views");
				String likes = record.get("likes");
				String dislikes = record.get("dislikes");
				String comment_count = record.get("comment_count");
				String thumbnail_link = record.get("thumbnail_link");
				String comments_disabled = record.get("comments_disabled");
				String ratings_disabled = record.get("ratings_disabled");
				String video_error_or_removed = record.get("video_error_or_removed");
				String description = record.get("description");
				String country = record.get("country");

				YoutubeVideo videoActual = new YoutubeVideo(id, trending_date, Integer.parseInt(likes), title);
				agregar(videoActual);
				System.out.println(title+trending_date);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//TOOD
	//public void invertirDatos()
	//{
	//	datos.invertirElementos();
	//}

}

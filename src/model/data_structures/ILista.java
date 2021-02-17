package model.data_structures;

public interface ILista <T extends Comparable<T>> {

	/**
	 * Agrega un elemento al inicio de la lista.
	 * @param element: elemento a agregar
	 */
	void addFirst(T element);
	
	/**
	 * Agrega un elemento al final de la lista.
	 * @param element: elemento a agregar
	 */
	void addLast(T element);
	
	/**
	 * Agregar un dato en la posicion dada por parametro.
	 * @param element: elemento a agregar.
	 * @param pos: posicion donde agregar.
	 */
	void insertElement( T element, int pos );
	
	/**
	 * Elimina el primer elemento de la lista.
	 * @return element: elemento eliminado.
	 */
	T removeFirst();
	
	/**
	 * Elimina el primer elemento de la lista.
	 * @return element: elemento eliminado.
	 */
	T removeLast();
	
	/**
	 * Elimina un dato en la posicion dada por parametro.
	 * @param pos: posicion válida donde se busca eliminar.
	 ( @return element: elemento eliminado.
	 */
	T deleteElement(int pos );
	
	/**
	 * Retornar el primer elemento.
	 * @return elemento en la primera posición. null si no hay elemento en esa posicion.
	 */
	T firstElement( );
	
	/**
	 * Retornar el ultimo elemento.
	 * @return elemento en la ultima posición. null si no hay elemento.
	 */
	T lastElement( );
	
	/**
	 * Retornar el elemento que esta en la posicion dada por parametro.
	 * @param pos: posicion válida del elemento a retornar. La posicion del primer elemento es uno.
	 * @return elemento en la posicion dada por parametro. null si no hay elemento.
	 */
	T getElement( int pos);
	
	
	/**
	 * Retornar el numero de elementos presentes en la lista
	 * @return el numero de elementos en la lista.
	 */
	int size( );
	
	/**
	 * Retorna true si la lista no posee elementos.
	 * @return Retorna true si el arreglo No tiene datos. false en caso contrario.
	 */
	boolean isEmpty( );
	
	/**
	 * Retorna la posición válida de un elemento.
	 * @return Retorna la posición válida de un elemento. Si no se encuentra el elemento, el valor retornado es -1.
	 */
	int isPresent( T element );
	
	/**
	 * Intercambia la información de los elementos en dos posiciones válidas.
	 */
	void exchange( int pos1, int pos2);
	
	/**
	 * Actualiza el elemento en una posición válida.
	 */
	void changeInfo( int pos, T elem);

}

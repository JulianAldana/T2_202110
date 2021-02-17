package model.data_structures;

public class ListaArregloDinamico <T extends Comparable<T>> implements ILista<T> {

	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ListaArregloDinamico( int max )
	{
		elementos = (T[])new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void invertirElementos()
	{
		T[] copia = elementos;
		elementos = (T[]) new Comparable[tamanoMax];
		for ( int i = 0; i< tamanoAct; i++)
		{
			elementos[tamanoAct-1-i] = copia[i];
		}
	}


	@Override
	public void addFirst(T element) {

		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct+1; i++)
			{
				if (i == 0)
				{
					elementos[i] = element;
				}
				else
				{
					elementos[i] = copia[i-1];
				}
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
			tamanoAct ++;
		}
		else
		{
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct+1; i++)
			{
				if (i == 0)
				{
					elementos[i] = element;
				}
				else
				{
					elementos[i] = copia[i-1];
				}
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
			tamanoAct ++;
		}

	}

	@Override
	public void addLast(T element) {
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
			tamanoAct ++;
		}	
		elementos[tamanoAct] = element;
		tamanoAct++;		
	}

	@Override
	public void insertElement(T element, int pos) {
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
		}
		T [ ] copia = elementos;
		elementos = (T[]) new Comparable[tamanoMax];
		for ( int i = 0; i < tamanoAct+1; i++)
		{
			if ( i < (pos-1))
			{
				elementos[i] = copia[i];
			}
			else if( i == (pos-1))
			{
				elementos[i] = element;
			}
			else
			{
				elementos[i] = copia[i-1];
			}				
		} 
		System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		tamanoAct ++;
	}	


	@Override
	public T removeFirst() {
		T res = elementos[0];
		T [] copia = elementos;
		elementos = (T[]) new Comparable[tamanoMax];
		for ( int i = 0; i < tamanoAct-1; i++)
		{
			elementos[i] = copia[i+1];
		} 
		tamanoAct --;
		return res;
	}

	@Override
	public T removeLast() {
		T res = elementos[tamanoAct];
		T [] copia = elementos;
		elementos = (T[]) new Comparable[tamanoMax];
		for ( int i = 0; i < tamanoAct-1; i++)
		{
			elementos[i] = copia[i];
		} 
		tamanoAct --;
		return res;
	}

	@Override
	public T deleteElement(int pos) {
		T res = null;	
		if(pos==tamanoAct)
		{
			res = removeLast();
		}
		else
		{
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct-1; i++)
			{
				if ( i < (pos-1))
				{
					elementos[i] = copia[i];
				}
				else if( i >= (pos-1))
				{
					elementos[i] = copia[i+1];
				}				
			} 
			tamanoAct --;
		}
		return res;
	}

	@Override
	public T firstElement() {
		return elementos[0];
	}

	@Override
	public T lastElement() {
		return elementos[tamanoAct];
	}

	@Override
	public T getElement(int pos) {
		return elementos[(pos-1)];
	}

	@Override
	public int size() {
		return tamanoAct;
	}

	@Override
	public boolean isEmpty() {
		boolean res = true;
		if (tamanoAct>0) res= false;
		return res;
	}

	@Override
	public int isPresent(T element) {
		int index = 0;
		boolean encontrado = false;
		for (int i = 0; i<tamanoAct && !encontrado; i++)
		{
			if(elementos[i].compareTo(element)==0)
			{
				encontrado = true;
			}
			index++;
		}
		if (!encontrado)index = -1;
		return index;
	}

	@Override
	public void exchange(int pos1, int pos2) {
		T elemento1 = elementos[pos1];
		T elemento2 = elementos[pos2];
		elementos[pos1] = elemento2;
		elementos[pos2] = elemento1;
	}

	@Override
	public void changeInfo(int pos, T elem) {
		elementos[pos] = elem;
	}

}

package model.data_structures;

public class ListaSencillamenteEncadenada <T extends Comparable<T>> implements ILista<T>{

	private NodoLista<T> first;

	public ListaSencillamenteEncadenada() {

		first = null;
	}

	public NodoLista<T> firstNode(){
		return first;
	}

	public NodoLista<T> lastNode(){

		NodoLista<T> res = null;

		if(first == null || first.getNext() == null )
		{
			res = first;
		}else {
			NodoLista<T> nodo_temp = first.getNext();
			while(nodo_temp.getNext()  != null)
			{
				nodo_temp = nodo_temp.getNext();
			}
			res = nodo_temp;
		}

		return res; 
	}

	@Override
	public void addFirst(T element) {

		NodoLista<T> nodoNuevo = new NodoLista<T>(element);
		if(first==null) 
		{
			first = nodoNuevo;
		}
		else {			
			nodoNuevo.setNext(first);
			first = nodoNuevo;
		}
	}

	@Override
	public void addLast(T element) {
		NodoLista<T> nodoNuevo = new NodoLista<T>(element);
		if(first==null) 
		{
			first = nodoNuevo;
		}
		else {
			if (first.getNext()!=null)
			{
				NodoLista<T> nodo_temp = first.getNext();
				while(nodo_temp.getNext()!=null)
				{
					nodo_temp = nodo_temp.getNext();
				}
				nodo_temp.setNext(nodoNuevo);
			}else
			{
				first.setNext(nodoNuevo);
			}
		}
	}

	@Override
	public void insertElement(T element, int pos) {
		NodoLista<T> nodoNuevo = new NodoLista<T>(element);
		if(pos == 1) 
		{
			nodoNuevo.setNext(first);
			first = nodoNuevo;
		}
		else {
			NodoLista<T> nodo_temp = first;
			while( nodo_temp != null && pos>2 )
			{
				nodo_temp = nodo_temp.getNext();
				pos--;
			}
			nodoNuevo.setNext(nodo_temp.getNext());
			nodo_temp.setNext(nodoNuevo);
		}
	}

	@Override
	public T removeFirst() {
		NodoLista<T> res = null;
		if(first!=null)
		{
			res = first;
			first = first.getNext();
		}			
		return res.getInfo();
	}

	@Override
	public T removeLast() {
		T res = null;
		if(first!=null) 
		{
			NodoLista<T> nodo_temp = first;
			while(nodo_temp.getNext()!=null)
			{
				nodo_temp = nodo_temp.getNext();
			}
			res = nodo_temp.getNext().getInfo();
			nodo_temp.setNext(null);
		}
		return res;
	}

	@Override
	public T deleteElement(int pos) {
		T res = null;
		if(pos ==1 && first==null)
		{
			res = null;
		}
		else if(pos == 1 && first!=null) 
		{	
			res = first.getInfo();
			first = first.getNext();
		}
		else {
			NodoLista<T> nodo_temp = first;
			while( nodo_temp != null && pos>2 )
			{
				nodo_temp = nodo_temp.getNext();
				pos--;
			}
			res = nodo_temp.getNext().getInfo();
			nodo_temp.disconnectNext();
		}
		return res;
	}

	@Override
	public T firstElement() {
		return first.getInfo();
	}

	@Override
	public T lastElement() {
		T res = null;
		if (first!=null)
		{
			NodoLista<T> nodo_temp = first;
			while (nodo_temp.getNext()!=null)
			{
				nodo_temp = nodo_temp.getNext();
			}
			res = nodo_temp.getInfo();
		}
		return res;
	}

	@Override
	public T getElement(int pos) {
		T res = null;
		if(pos == 1 && first!=null) 
		{	
			res = first.getInfo();
		}
		else if(pos>1 && first!=null)
		{
			NodoLista<T> nodo_temp = first.getNext();
			while( nodo_temp != null && pos>2 )
			{
				nodo_temp = nodo_temp.getNext();
				pos--;
			}
			res = nodo_temp.getInfo();
		}
		return res;
	}

	@Override
	public int size() {
		int res = 0;
		if (first!=null)
		{
			res ++;
			NodoLista<T> nodo_temp = first;
			while (nodo_temp.getNext()!=null)
			{
				nodo_temp = nodo_temp.getNext();
				res++;
			}
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = true;
		if (first!=null)
		{
			res = true;
		}
		return res;
	}

	@Override
	public int isPresent(T element) {
		int index = 0;
		boolean encontrado = false;
		boolean finalAlcanzado = false;
		if (first!=null)
		{
			NodoLista<T> nodo_temp = first;

			while(!encontrado && !finalAlcanzado)
			{
				if (nodo_temp.getInfo().compareTo(element)==0)
				{
					encontrado = true;
				}
				else
				{
					if(nodo_temp.getNext()!=null)
					{
						nodo_temp = nodo_temp.getNext();
					}
					else
					{
						finalAlcanzado = true;
					}
				}
				index++;
			}
		}
		int res = -1;
		if(encontrado)
		{
			res = index;
		}
		return res;
	}

	@Override
	public void exchange(int pos1, int pos2) {

		if (pos1>1 && pos2>1)
		{
			NodoLista<T> nodo1 = first;
			while( nodo1 != null && pos1>1 )
			{
				nodo1 = nodo1.getNext();
				pos1--;
			}
			NodoLista<T> nodo2 = first;
			while( nodo2 != null && pos2>1 )
			{
				nodo2 = nodo2.getNext();
				pos2--;
			}

			NodoLista<T> nodoCambio1 = nodo1.getNext();
			NodoLista<T> nodoCambio2 = nodo2.getNext();
			NodoLista<T> nodoCambio2_temp = nodo2.getNext();

			nodoCambio2.setNext(nodoCambio1.getNext());
			nodo1.setNext(nodoCambio2);

			nodoCambio1.setNext(nodoCambio2_temp.getNext());
			nodo2.setNext(nodoCambio1);
		}

	}

	@Override
	public void changeInfo(int pos, T elem) {

		NodoLista<T> nodoNuevo = new NodoLista<T>(elem);
		if(pos == 1) 
		{
			nodoNuevo.setNext(first);
			first = nodoNuevo;
		}
		else {
			NodoLista<T> nodo_temp = first;
			while( nodo_temp != null && pos>2 )
			{
				nodo_temp = nodo_temp.getNext();
				pos--;
			}
			nodoNuevo.setNext(nodo_temp.getNext());
			nodo_temp.setNext(nodoNuevo);
		}
	}

}

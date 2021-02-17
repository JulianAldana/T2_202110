package model.data_structures;

public class NodoLista <T extends Comparable<T>>{

	private T info;

	private NodoLista<T> next;

	public NodoLista(T pElement)
	{
		info=pElement;
		next=null;
	}

	public T getInfo()
	{
		return info;
	}

	public NodoLista<T> getNext()
	{
		return next;
	}

	void setNext(NodoLista<T> pNodoNext)
	{
		next = pNodoNext;

	}

	void disconnectNext()
	{
		if(next!=null)
		{
			next = next.getNext();
		}
	}

}

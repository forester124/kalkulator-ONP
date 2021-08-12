package ONP;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class stos
{
	private LinkedList<String> lista;
	
	public stos()
	{
		lista = new LinkedList<String>(); 
	}
	
	public void push(String elem)
	{
		lista.add(elem);
	}
	public String pop() throws EmptyStackException
	{
		if(lista.size() == 0)
			throw new EmptyStackException();
		
		return lista.removeLast();
	}
	public String showValue(int i)
	{
		if(i < lista.size())
			return lista.get(i);
		else
			return null;
	}
	public int getSize()
	{
		return lista.size();
	}
	public void wys()
	{
		for(int i = 0; i < lista.size(); i++)
			System.out.println(lista.get(i));
	}
}
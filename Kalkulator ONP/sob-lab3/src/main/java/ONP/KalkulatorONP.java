package ONP;

import java.util.*;
import java.awt.EventQueue;


public class KalkulatorONP {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}

class ONP
{
	private stos stack = new stos();
	
	boolean czyPoprawneRownanie(String rownanie) 
	{
		if (rownanie.endsWith("="))
			return true;
		else
			return false;
	}
	public double silnia(double n) 
	{
		double wynik = 1;
		if(n == 0)
			return 1;
		else
		{
			for(double i = n; i > 0; i--)
			{
				wynik = wynik * i; 
			}
			return wynik;
		}
	}
	public double pierwiastek(double a, double n)
	{
        double result = a;
        double tmp = Math.pow(result,(n-1));
        double e = 0.00000001;

        while (Math.abs(a - tmp * result)>= e)
        {
        	result = 1/n*((n-1)*result + (a/tmp));
        	tmp = Math.pow(result, n-1);
        }
        return result;
    }
	public String obliczOnp(String rownanie) throws ujemnaWartoscPodPierwiastkiemException
	{
		if (czyPoprawneRownanie(rownanie)) 
		{
			String wynik = "";
			Double a = 0.0;
			Double b = 0.0;
			for (int i = 0; i < rownanie.length(); i++) 
			{
				if (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9' || rownanie.charAt(i) == '.') 
				{
					wynik += rownanie.charAt(i);
					if (!(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9' || rownanie.charAt(i + 1) == '.')) 
					{
						stack.push(wynik);
						wynik = "";
					}

				} 
				else if (rownanie.charAt(i) == '=') 
				{
					return stack.pop();
				}
				else if (rownanie.charAt(i) != ' ') 
				{
					b = Double.parseDouble(stack.pop());
					if(rownanie.charAt(i) != '!')
						a = Double.parseDouble(stack.pop());
					switch (rownanie.charAt(i)) 
					{
					case ('+'): 
					{
						stack.push((a + b) + "");
						break;
					}
					case ('-'): 
					{
						stack.push((a - b) + "");
						break;
					}
					case ('x'):
						;
					case ('*'): 
					{
						stack.push((a * b) + "");
						break;
					}
					case ('/'): 
					{
						stack.push((a / b) + "");
						break;
					}
					case ('^'): 
					{
						stack.push(Math.pow(a, b) + "");
						break;
					}
					case ('#'): 
					{	if(b < 0)
							throw new ujemnaWartoscPodPierwiastkiemException();
						stack.push(pierwiastek(b, a) + "");
						break;
					}
					case ('%'):
					{
						stack.push(a%b + "");
						break;
					}
					case ('!'):
					{
						stack.push(silnia(b) + "");
						break;
					}
					}
				}
			}
			return "0.0";
		} 
		else
			return "Brak '='";
	}
	public String przeksztalcNaOnp(String rownanie) throws zleRownanieException, zlyOperatorException, dzieleniePrzezZeroException 
	{
		if (czyPoprawneRownanie(rownanie)) 
		{
			String wynik = "";
			for (int i = 0; i < rownanie.length(); i++) 
			{
				if (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9' || rownanie.charAt(i) == '.') 
				{
					wynik += rownanie.charAt(i);
					if (!(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9' || rownanie.charAt(i + 1) == '.'))
						wynik += " ";
				} 
				else
					switch (rownanie.charAt(i)) 
					{
					case ('+'):
						;
					case ('-'): 
					{
						while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) 
						{
							wynik = wynik + stack.pop() + " ";
						}
						String str = "" + rownanie.charAt(i);
						stack.push(str);
						break;
					}
					case ('x'):
						;
					case ('*'):
						;
					case ('%'):
						;
					case ('/'): 
					{
						if(rownanie.charAt(i) == '/' && rownanie.charAt(i+1) == '0')
						{
							throw new dzieleniePrzezZeroException();
						}
						while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")
								&& !stack.showValue(stack.getSize() - 1).equals("+")
								&& !stack.showValue(stack.getSize() - 1).equals("-")) 
						{
							wynik = wynik + stack.pop() + " ";
						}
						String str = "" + rownanie.charAt(i);
						stack.push(str);
						break;
					}
					case ('!'):
						;
					case ('#'):
						;
					case ('^'): 
					{
						while (stack.getSize() > 0 && stack.showValue(stack.getSize() - 1).equals("^")) 
						{
							wynik = wynik + stack.pop() + " ";
						}
						String str = "" + rownanie.charAt(i);
						stack.push(str);
						break;
					}
					case ('('): 
					{
						String str = "" + rownanie.charAt(i);
						stack.push(str);
						break;
					}
					case (')'): 
					{
						while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) 
						{
							wynik = wynik + stack.pop() + " ";
						}
						stack.pop();
						break;
					}
					case ('='): 
					{
						while (stack.getSize() > 0) 
						{
							wynik = wynik + stack.pop() + " ";
						}
						wynik += "=";
						break;
					}
					default: throw new zlyOperatorException();
				}
			}
			return wynik;
		} 
		else
			throw new zleRownanieException();
	}
}

class zleRownanieException extends Exception
{
	public zleRownanieException() {}
}
class zlyOperatorException  extends Exception
{
	public zlyOperatorException() {}
}
class dzieleniePrzezZeroException extends Exception
{
	public dzieleniePrzezZeroException() {}
}
class ujemnaWartoscPodPierwiastkiemException extends Exception
{
	public ujemnaWartoscPodPierwiastkiemException() {}
}
class pelnaHistoriaException extends Exception
{
	public pelnaHistoriaException() {}
}
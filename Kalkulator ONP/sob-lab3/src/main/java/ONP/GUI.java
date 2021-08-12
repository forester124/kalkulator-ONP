package ONP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI implements ActionListener
{
	private JFrame frame;
	private JTextField textDisplay;
	private JTextArea text2;
	private String [] historia = new String [10];
	private static int i = 0;
	
	public GUI()
	{
		initialize();
	}
	
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 435);
		frame.setResizable(true);
		frame.setTitle("Kalkulator ONP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(510, 435));
		frame.getContentPane().setLayout(null);
		
		textDisplay = new JTextField();
		textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDisplay.setColumns(10);
		textDisplay.setBounds(10, 11, 230, 45);
		frame.getContentPane().add(textDisplay);
		
		JLabel hist = new JLabel("Historia:");
		hist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hist.setBounds(250, 11, 230, 20);
		frame.getContentPane().add(hist);
		
		text2 = new JTextArea();
		text2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text2.setBounds(250, 31, 250, 350);
		frame.getContentPane().add(text2);
		
		JButton Button0 = new JButton("0");
		Button0.addActionListener(this);
		Button0.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button0.setBounds(10, 369, 50, 50);
		frame.getContentPane().add(Button0);
		
		JButton Button1 = new JButton("1");
		Button1.addActionListener(this);
		Button1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button1.setBounds(10, 308, 50, 50);
		frame.getContentPane().add(Button1);
		
		JButton Button2 = new JButton("2");
		Button2.addActionListener(this);
		Button2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button2.setBounds(70, 306, 50, 50);
		frame.getContentPane().add(Button2);
		
		JButton Button3 = new JButton("3");
		Button3.addActionListener(this);
		Button3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button3.setBounds(130, 308, 50, 50);
		frame.getContentPane().add(Button3);
		
		JButton Button4 = new JButton("4");
		Button4.addActionListener(this);
		Button4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button4.setBounds(10, 245, 50, 50);
		frame.getContentPane().add(Button4);
		
		JButton Button5 = new JButton("5");
		Button5.addActionListener(this);
		Button5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button5.setBounds(70, 245, 50, 50);
		frame.getContentPane().add(Button5);
		
		JButton Button6 = new JButton("6");
		Button6.addActionListener(this);
		Button6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button6.setBounds(130, 247, 50, 50);
		frame.getContentPane().add(Button6);
		
		JButton Button7 = new JButton("7");
		Button7.addActionListener(this);
		Button7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button7.setBounds(10, 186, 50, 50);
		frame.getContentPane().add(Button7);
		
		JButton Button8 = new JButton("8");
		Button8.addActionListener(this);
		Button8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button8.setBounds(70, 186, 50, 50);
		frame.getContentPane().add(Button8);
		
		JButton Button9 = new JButton("9");
		Button9.addActionListener(this);
		Button9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button9.setBounds(130, 186, 50, 50);
		frame.getContentPane().add(Button9);
		
		JButton ButtonBracket1 = new JButton("(");
		ButtonBracket1.addActionListener(this);
		ButtonBracket1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonBracket1.setBounds(10, 67, 50, 50);
		frame.getContentPane().add(ButtonBracket1);
		
		JButton ButtonBracket2 = new JButton(")");
		ButtonBracket2.addActionListener(this);
		ButtonBracket2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonBracket2.setBounds(70, 67, 50, 50);
		frame.getContentPane().add(ButtonBracket2);
		
		JButton ButtonPlus = new JButton("+");
		ButtonPlus.addActionListener(this);
		ButtonPlus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonPlus.setBounds(190, 306, 50, 50);
		frame.getContentPane().add(ButtonPlus);
		
		JButton ButtonMinus = new JButton("-");
		ButtonMinus.addActionListener(this);
		ButtonMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonMinus.setBounds(190, 245, 50, 50);
		frame.getContentPane().add(ButtonMinus);
		
		JButton ButtonMultiply = new JButton("x");
		ButtonMultiply.addActionListener(this);
		ButtonMultiply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonMultiply.setBounds(190, 184, 50, 50);
		frame.getContentPane().add(ButtonMultiply);
		
		JButton ButtonSilnia = new JButton("!");
		ButtonSilnia.addActionListener(this);
		ButtonSilnia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonSilnia.setBounds(130, 367, 50, 50);
		frame.getContentPane().add(ButtonSilnia);
		
		JButton ButtonDot = new JButton(".");
		ButtonDot.addActionListener(this);
		ButtonDot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonDot.setBounds(70, 367, 50, 50);
		frame.getContentPane().add(ButtonDot);
		
		JButton ButtonEquals = new JButton("=");
		ButtonEquals.addActionListener(this);
		ButtonEquals.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonEquals.setBounds(190, 367, 50, 50);
		frame.getContentPane().add(ButtonEquals);
		
		JButton ButtonPierwiastek = new JButton("\u221a");
		ButtonPierwiastek.addActionListener(this);
		ButtonPierwiastek.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonPierwiastek.setBounds(10, 127, 50, 50);
		frame.getContentPane().add(ButtonPierwiastek);
		
		JButton ButtonModulo = new JButton("%");
		ButtonModulo.addActionListener(this);
		ButtonModulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ButtonModulo.setBounds(130, 128, 50, 50);
		frame.getContentPane().add(ButtonModulo);
		
		JButton ButtonDivide = new JButton("/");
		ButtonDivide.addActionListener(this);
		ButtonDivide.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonDivide.setBounds(190, 125, 50, 50);
		frame.getContentPane().add(ButtonDivide);
		
		JButton ButtonBackspace = new JButton("\u2190");
		ButtonBackspace.addActionListener(this);
		ButtonBackspace.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ButtonBackspace.setBounds(190, 67, 50, 50);
		frame.getContentPane().add(ButtonBackspace);
		
		JButton ButtonPower = new JButton("^");
		ButtonPower.addActionListener(this);
		ButtonPower.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonPower.setBounds(70, 128, 50, 50);
		frame.getContentPane().add(ButtonPower);
		
		JButton ButtonClear = new JButton("C");
		ButtonClear.addActionListener(this);
		ButtonClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonClear.setBounds(130, 67, 50, 50);
		frame.getContentPane().add(ButtonClear);
		
		JButton ButtonClearHistory = new JButton("Wyczyść");
		ButtonClearHistory.addActionListener(this);
		ButtonClearHistory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonClearHistory.setBounds(250, 385, 250, 32);
		frame.getContentPane().add(ButtonClearHistory);
		
		frame.setVisible(true);
		frame.getContentPane().addHierarchyBoundsListener(new ResizeComponentsListener(510, 435, true));
	}
	public void actionPerformed(ActionEvent e)
	{
		 String ans;
		 String rownanie = "";
		 String znak = e.getActionCommand();
		 
		 if(znak == "C")
		 {
			 rownanie = "";
			 textDisplay.setText(rownanie);
		 }
		 else if(znak == "\u2190") //backspace
		 {
			 rownanie = textDisplay.getText();
			 rownanie = rownanie.substring(0, rownanie.length() - 1);
			 textDisplay.setText(rownanie);
		 }
		 else if(znak == "=")
		 {
			try
			{
				Writer output = new BufferedWriter(new FileWriter("historia.txt", true));
				rownanie = textDisplay.getText() + znak;
				rownanie = rownanie.replaceAll("\u221a", "#");
				ONP onp = new ONP();
				String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
				ans = onp.obliczOnp(rownanieOnp);
				
				if(i == 10)
					throw new pelnaHistoriaException();
				textDisplay.setText(ans);
				historia[i] = rownanie + " " + rownanieOnp + " " + ans + "\n";
				((BufferedWriter) output.append(historia[i])).newLine();
				output.close();
				
				String tmp = "";
				i++;
				for(int j = 0; j < i; j++)
				{
					tmp = tmp + historia[j];
				}
				text2.setText(tmp);
			}
			catch(zleRownanieException ex)
			{
				textDisplay.setText("złe równanie");
			}
			catch(zlyOperatorException ex)
			{
				textDisplay.setText("zły operator");
			}
			catch(dzieleniePrzezZeroException ex)
			{
				textDisplay.setText("nie można dzielić przez 0");
			}
			catch(pelnaHistoriaException ex)
			{
				textDisplay.setText("Pełna historia");
			}
			catch(ujemnaWartoscPodPierwiastkiemException ex)
			{
				textDisplay.setText("ujemna wartość pod pierwiastkiem");
			}
			catch(IOException ex)
			{
				
			}
		 }
		 else if(znak == "Wyczyść")
		 {
			 i = 0;
			 text2.setText("");
		 }
		 else
		 {
			 rownanie = textDisplay.getText() + znak;
			 textDisplay.setText(rownanie);
		 }
	}
}

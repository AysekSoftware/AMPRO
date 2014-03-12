package ampro;

import javax.swing.*;
import java.awt.Font;

@SuppressWarnings("serial")
public class CalculadoraPromedios extends Emergentes 
{
	private JTextField txt1, txt2, txt3, txt4, txt5;

	public CalculadoraPromedios() 
	{
		setBounds(100, 100, 359, 417);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCalculadoraDePromedios = new JLabel("Calculadora de ");
		lblCalculadoraDePromedios.setFont(new Font("Georgia", Font.PLAIN, 24));
		lblCalculadoraDePromedios.setBounds(68, 28, 176, 35);
		getContentPane().add(lblCalculadoraDePromedios);
		
		JLabel lblPromedios = new JLabel("Promedios:");
		lblPromedios.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblPromedios.setBounds(57, 96, 176, 35);
		getContentPane().add(lblPromedios);
		
		txt1 = new JTextField();
		txt1.setBounds(188, 96, 139, 35);
		getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(188, 142, 139, 35);
		getContentPane().add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(188, 188, 139, 35);
		getContentPane().add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(188, 234, 139, 35);
		getContentPane().add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(188, 281, 139, 35);
		getContentPane().add(txt5);
		
		JLabel lblPromedios_1 = new JLabel("promedios");
		lblPromedios_1.setFont(new Font("Georgia", Font.PLAIN, 24));
		lblPromedios_1.setBounds(141, 59, 158, 26);
		getContentPane().add(lblPromedios_1);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(188, 330, 139, 26);
		getContentPane().add(btnCalcular);
	}

}

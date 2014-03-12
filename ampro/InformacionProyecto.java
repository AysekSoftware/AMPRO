/**
 * 		AUTOMATIZACION Y MEJORAMIENTO DEL PROCESO DE ADMISIÓN (AMPRO)  INFO-V-12
 * 		VERSION 3.2.9 (Actualizado 22/10/12) 
 * 		COLEGIO TÉCNICO DON BOSCO
 * 		PROYECTO DE EXPOTEC 2012
 * 		DEPARTAMENTO DE TIC'S
 * 		ESPECIALIDAD DE INFORMATICA EN DESARROLLO DE SOFTWARE
 *		JOSÉ DAVID MORA LORÍA
 *		DIEGO SOLÍS PEÑARANDA
 *		SECCIÓN 11-D					2012
 */

package ampro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformacionProyecto extends Emergentes 
{
	private final String VERSION = "VERSION 3.2.9 (Actualizado 22/10/12)";
	private final String CODIGO_PROYECTO = "INFO-V-12";
	
	public InformacionProyecto() 
	{
		setBounds(300, 150, 817, 476);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel Proyecto = new JLabel("AUTOMATIZACION Y MEJORAMIENTO DEL PROCESO DE ADMISIÓN (AMPRO)  " + CODIGO_PROYECTO);
		Proyecto.setHorizontalAlignment(SwingConstants.CENTER);
		Proyecto.setFont(new Font("Consolas", Font.BOLD, 18));
		Proyecto.setBounds(10, 23, 763, 65);
		getContentPane().add(Proyecto);
		
		JLabel Version = new JLabel(VERSION);
		Version.setHorizontalAlignment(SwingConstants.CENTER);
		Version.setFont(new Font("Consolas", Font.BOLD, 18));
		Version.setBounds(171, 70, 450, 58);
		getContentPane().add(Version);
		
		JLabel Colegio = new JLabel("COLEGIO T\u00C9CNICO DON BOSCO");
		Colegio.setHorizontalAlignment(SwingConstants.CENTER);
		Colegio.setFont(new Font("Consolas", Font.BOLD, 18));
		Colegio.setBounds(151, 118, 443, 50);
		getContentPane().add(Colegio);
		
		JLabel Expo12 = new JLabel("PROYECTO DE EXPOTEC 2012");
		Expo12.setHorizontalAlignment(SwingConstants.CENTER);
		Expo12.setFont(new Font("Consolas", Font.BOLD, 18));
		Expo12.setBounds(151, 165, 451, 42);
		getContentPane().add(Expo12);
		
		JLabel Departamento = new JLabel("DEPARTAMENTO DE TIC'S");
		Departamento.setHorizontalAlignment(SwingConstants.CENTER);
		Departamento.setFont(new Font("Consolas", Font.BOLD, 18));
		Departamento.setBounds(151, 205, 450, 42);
		getContentPane().add(Departamento);
		
		JLabel Epecialiadad = new JLabel("INFORM\u00C1TICA EN DESARROLLO DE SOFTWARE");
		Epecialiadad.setHorizontalAlignment(SwingConstants.CENTER);
		Epecialiadad.setFont(new Font("Consolas", Font.BOLD, 18));
		Epecialiadad.setBounds(152, 246, 450, 42);
		getContentPane().add(Epecialiadad);
		
		JLabel lblJosDavidMora = new JLabel("JOS\u00C9 DAVID MORA LOR\u00CDA");
		lblJosDavidMora.setHorizontalAlignment(SwingConstants.CENTER);
		lblJosDavidMora.setFont(new Font("Consolas", Font.BOLD, 18));
		lblJosDavidMora.setBounds(0, 299, 450, 42);
		getContentPane().add(lblJosDavidMora);
		
		JLabel lblDiegoSolsPearanda = new JLabel("DIEGO SOL\u00CDS PE\u00D1ARANDA");
		lblDiegoSolsPearanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiegoSolsPearanda.setFont(new Font("Consolas", Font.BOLD, 18));
		lblDiegoSolsPearanda.setBounds(351, 299, 450, 42);
		getContentPane().add(lblDiegoSolsPearanda);
		
		JLabel lblSeccind = new JLabel("SECCI\u00D3N 12D");
		lblSeccind.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeccind.setFont(new Font("Consolas", Font.BOLD, 18));
		lblSeccind.setBounds(161, 340, 450, 42);
		getContentPane().add(lblSeccind);
		
		JLabel label_1 = new JLabel("2012");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Consolas", Font.BOLD, 18));
		label_1.setBounds(171, 366, 450, 42);
		getContentPane().add(label_1);
	}

}

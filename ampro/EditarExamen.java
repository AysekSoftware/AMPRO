package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class EditarExamen extends Ampro
{
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 22);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 18);
    public Font letraTexto3 = new Font("Georgia", Font.PLAIN, 16);
    private JTextField txtPregunta, op1, op2, op4, op3;
    @SuppressWarnings("rawtypes")
	private JComboBox comboMateria, comboPregunta, comboCorrecta;

	@SuppressWarnings("unchecked")
	public EditarExamen() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
        
  //Regresar
  		JPanel regresar = new JPanel();
  		regresar.setBounds(27, 126, 60, 53);
  		regresar.setOpaque(false);
  		try {
          	regresar.setForeground(SystemColor.controlHighlight);
              try {
                  URL imagen = Ampro.class.getResource("regresar.png");
                  BufferedImage  img = ImageIO.read(imagen);
                  BgBorder borde = new BgBorder( img );
                  regresar.setBorder(borde);
              } catch (Exception e) {
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
  		getContentPane().add(regresar);
  		regresar.setLayout(new BorderLayout(0, 0));
  		getContentPane().add(regresar);
  		
  		JButton btnRegres = new JButton("");
  		regresar.add(btnRegres, BorderLayout.CENTER);
  		btnRegres.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent arg0) {
  				AmproPrincipal.menu = new Menu();
        			AmproPrincipal.menu.setVisible(true); 
        			AmproPrincipal.editarExamen.setVisible(false);
  			}
  		});
  		btnRegres.setOpaque(false);
  		btnRegres.setContentAreaFilled(false);
  		btnRegres.setBorderPainted(false);
  		
  		JPanel guardar = new JPanel();
  		guardar.setBounds(1206, 359, 65, 65);
  		guardar.setOpaque(false);
  		try {
          	guardar.setForeground(SystemColor.controlHighlight);
              try {
                  URL imagen = Ampro.class.getResource("check.png");
                  BufferedImage  img = ImageIO.read(imagen);
                  BgBorder borde = new BgBorder( img );
                  guardar.setBorder(borde);
              } catch (Exception e) {
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
  		getContentPane().add(guardar);
  		guardar.setLayout(new BorderLayout(0, 0));
  		
  		JButton btnGuardar = new JButton("");
  		btnGuardar.setToolTipText("Guardar cambios del rubro");
  		guardar.add(btnGuardar);
  		btnGuardar.addActionListener(new ActionListener() {
  			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent arg0) {
  				GuardarDatos();
  				comboMateria = new JComboBox();
  				comboPregunta = new JComboBox();
  				comboCorrecta = new JComboBox();
  				txtPregunta = new JTextField();
  				op1 = new JTextField();
  				op2 = new JTextField();
  				op3 = new JTextField();
  				op4 = new JTextField();
  			}
  		});
  		btnGuardar.setOpaque(false);
  		btnGuardar.setContentAreaFilled(false);
  		btnGuardar.setBorderPainted(false);
  		
  		JPanel cancelar = new JPanel();
  		cancelar.setBounds(1206, 454, 65, 65);
  		cancelar.setOpaque(false);
  		try {
          	cancelar.setForeground(SystemColor.controlHighlight);
              try {
                  URL imagen = Ampro.class.getResource("eliminar.png");
                  BufferedImage  img = ImageIO.read(imagen);
                  BgBorder borde = new BgBorder( img );
                  cancelar.setBorder(borde);
              } catch (Exception e) {
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
  		getContentPane().add(cancelar);
  		cancelar.setLayout(new BorderLayout(0, 0));
  		
  		JButton btnCancelar = new JButton("");
  		btnCancelar.setToolTipText("No guardar los cambios del rubro");
  		cancelar.add(btnCancelar);
  		btnCancelar.addActionListener(new ActionListener() {
  			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent arg0) {
  				comboMateria = new JComboBox();
				comboPregunta = new JComboBox();
				comboCorrecta = new JComboBox();
				txtPregunta = new JTextField();
				op1 = new JTextField();
				op2 = new JTextField();
				op3 = new JTextField();
				op4 = new JTextField();
  			}
  		});
  		btnCancelar.setOpaque(false);
  		btnCancelar.setContentAreaFilled(false);
  		btnCancelar.setBorderPainted(false);
  		
  		JPanel agregar = new JPanel();
  		agregar.setBounds(1206, 273, 65, 65);
  		agregar.setOpaque(false);
  		try {
          	agregar.setForeground(SystemColor.controlHighlight);
              try {
                  URL imagen = Ampro.class.getResource("agregar.png");
                  BufferedImage  img = ImageIO.read(imagen);
                  BgBorder borde = new BgBorder( img );
                  agregar.setBorder(borde);
              } catch (Exception e) {
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
  		getContentPane().add(agregar);
  		agregar.setLayout(new BorderLayout(0, 0));
  		
  		JButton btnAgregar = new JButton("");
  		btnAgregar.setToolTipText("Agregar un rubro");
  		agregar.add(btnAgregar);
  		btnAgregar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent arg0) {
  				AmproPrincipal.nuevaPregunta = new NuevaPregunta();
    			AmproPrincipal.nuevaPregunta.setVisible(true);
  			}
  		});
  		btnAgregar.setOpaque(false);
  		btnAgregar.setContentAreaFilled(false);
  		btnAgregar.setBorderPainted(false);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(letraTexto1);
		lblMateria.setBounds(119, 227, 187, 32);
		getContentPane().add(lblMateria);
		
		JLabel lblPregunta = new JLabel("Pregunta:");
		lblPregunta.setFont(letraTexto1);
		lblPregunta.setBounds(119, 293, 187, 32);
		getContentPane().add(lblPregunta);
		
		comboMateria = new JComboBox(ConexDB.LlamarMaterias());
		comboMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboPregunta = new JComboBox(ConexDB.LlamarPreguntas((String)comboMateria.getSelectedItem()));
				revalidate();
			}
		});
		comboMateria.setBounds(308, 227, 187, 32);
		getContentPane().add(comboMateria);
		
		comboPregunta = new JComboBox();
		comboPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPregunta.setText(ConexDB.LlamarTextoPregunta((String)comboPregunta.getSelectedItem()));
				op1.setText(ConexDB.LlamarRespuesta((String)comboPregunta.getSelectedItem(), 1));
				op2.setText(ConexDB.LlamarRespuesta((String)comboPregunta.getSelectedItem(), 2));
				op3.setText(ConexDB.LlamarRespuesta((String)comboPregunta.getSelectedItem(), 3));
				op4.setText(ConexDB.LlamarRespuesta((String)comboPregunta.getSelectedItem(), 4));
				comboCorrecta.setSelectedIndex(ConexDB.LlamarRespuestaCorrecta((String)comboPregunta.getSelectedItem()));
			}
		});
		comboPregunta.setBounds(308, 293, 187, 32);
		getContentPane().add(comboPregunta);
		
		txtPregunta = new JTextField();
		txtPregunta.setBounds(308, 336, 702, 42);
		getContentPane().add(txtPregunta);
		txtPregunta.setColumns(10);
		
		JLabel lblOpciones = new JLabel("Opciones:");
		lblOpciones.setFont(letraTexto1);
		lblOpciones.setBounds(119, 392, 187, 32);
		getContentPane().add(lblOpciones);
		
		JLabel label = new JLabel("1:");
		label.setFont(letraTexto1);
		label.setBounds(308, 387, 53, 37);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setFont(letraTexto1);
		label_1.setBounds(308, 431, 53, 37);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setFont(letraTexto1);
		label_2.setBounds(308, 480, 53, 37);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setFont(letraTexto1);
		label_3.setBounds(308, 528, 53, 37);
		getContentPane().add(label_3);
		
		JLabel lblVlida = new JLabel("V\u00E1lida:");
		lblVlida.setFont(letraTexto1);
		lblVlida.setBounds(119, 578, 187, 32);
		getContentPane().add(lblVlida);
		
		comboCorrecta = new JComboBox();
		comboCorrecta.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboCorrecta.setBounds(308, 576, 187, 32);
		getContentPane().add(comboCorrecta);
		
		op1 = new JTextField();
		op1.setBounds(328, 389, 680, 32);
		getContentPane().add(op1);
		op1.setColumns(10);
		
		op2 = new JTextField();
		op2.setColumns(10);
		op2.setBounds(330, 435, 680, 32);
		getContentPane().add(op2);
		
		op4 = new JTextField();
		op4.setColumns(10);
		op4.setBounds(330, 533, 680, 32);
		getContentPane().add(op4);
		
		op3 = new JTextField();
		op3.setColumns(10);
		op3.setBounds(328, 487, 680, 32);
		getContentPane().add(op3);
	}
	
	protected void GuardarDatos()
	{
		
	}
}

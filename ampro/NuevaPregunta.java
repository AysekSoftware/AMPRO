package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class NuevaPregunta extends Emergentes
{
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 22);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 18);
    public Font letraTexto3 = new Font("Georgia", Font.PLAIN, 16);
    private JTextField txtPregunta, op1, op2, op4, op3;
    @SuppressWarnings("rawtypes")
	private JComboBox comboMateria, comboPregunta, comboCorrecta;

	public NuevaPregunta() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 586);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
  		
        JPanel guardar = new JPanel();
        guardar.setBounds(983, 380, 65, 65);
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
  		getContentPane().setLayout(null);
  		getContentPane().add(guardar);
  		guardar.setLayout(new BorderLayout(0, 0));
  		
  		JButton btnGuardar = new JButton("");
  		guardar.add(btnGuardar, BorderLayout.CENTER);
  		btnGuardar.setToolTipText("Guardar cambios del rubro");
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
  		cancelar.setBounds(883, 380, 65, 65);
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
  		cancelar.add(btnCancelar, BorderLayout.CENTER);
  		btnCancelar.setToolTipText("No guardar los cambios del rubro");
  		btnCancelar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent arg0) {comboMateria = new JComboBox();
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
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(letraTexto1);
		lblMateria.setBounds(62, 86, 187, 32);
		getContentPane().add(lblMateria);
		
		JLabel lblPregunta = new JLabel("Pregunta:");
		lblPregunta.setFont(letraTexto1);
		lblPregunta.setBounds(62, 130, 187, 32);
		getContentPane().add(lblPregunta);
		
		comboMateria = new JComboBox(ConexDB.LlamarMaterias());
		comboMateria.setBounds(251, 86, 187, 32);
		getContentPane().add(comboMateria);
		
		txtPregunta = new JTextField();
		txtPregunta.setBounds(251, 129, 702, 42);
		getContentPane().add(txtPregunta);
		txtPregunta.setColumns(10);
		
		JLabel lblOpciones = new JLabel("Opciones:");
		lblOpciones.setFont(letraTexto1);
		lblOpciones.setBounds(62, 185, 187, 32);
		getContentPane().add(lblOpciones);
		
		JLabel label = new JLabel("1:");
		label.setFont(letraTexto1);
		label.setBounds(251, 180, 53, 37);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setFont(letraTexto1);
		label_1.setBounds(251, 224, 53, 37);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setFont(letraTexto1);
		label_2.setBounds(251, 273, 53, 37);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setFont(letraTexto1);
		label_3.setBounds(251, 321, 53, 37);
		getContentPane().add(label_3);
		
		JLabel lblVlida = new JLabel("V\u00E1lida:");
		lblVlida.setFont(letraTexto1);
		lblVlida.setBounds(62, 371, 187, 32);
		getContentPane().add(lblVlida);
		
		comboCorrecta = new JComboBox();
		comboCorrecta.setBounds(251, 369, 187, 32);
		comboCorrecta.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		getContentPane().add(comboCorrecta);
		
		op1 = new JTextField();
		op1.setBounds(271, 182, 680, 32);
		getContentPane().add(op1);
		op1.setColumns(10);
		
		op2 = new JTextField();
		op2.setBounds(273, 228, 680, 32);
		op2.setColumns(10);
		getContentPane().add(op2);
		
		op4 = new JTextField();
		op4.setBounds(273, 326, 680, 32);
		op4.setColumns(10);
		getContentPane().add(op4);
		
		op3 = new JTextField();
		op3.setBounds(271, 280, 680, 32);
		op3.setColumns(10);
		getContentPane().add(op3);
		
		JLabel lblIngresarNuevaPregunta = new JLabel("Ingresar nueva pregunta");
		lblIngresarNuevaPregunta.setFont(new Font("Georgia", Font.BOLD, 24));
		lblIngresarNuevaPregunta.setBounds(399, 29, 315, 42);
		getContentPane().add(lblIngresarNuevaPregunta);
	}
	
	protected void GuardarDatos()
	{
		
	}
}

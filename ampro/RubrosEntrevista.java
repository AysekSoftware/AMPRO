package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class RubrosEntrevista extends Ampro
{
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 22);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 18);
    public Font letraTexto3 = new Font("Georgia", Font.PLAIN, 16);

    @SuppressWarnings("rawtypes")
	JComboBox comboCodRubro;
    JTextArea txtRubro;
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RubrosEntrevista() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Rubros de entrevista");
		lblTitulo.setForeground(SystemColor.menu);
		lblTitulo.setFont(new Font("Georgia", Font.PLAIN, 34));
		lblTitulo.setBounds(671, 68, 369, 52);
		getContentPane().add(lblTitulo);
		
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
      			AmproPrincipal.rubros.setVisible(false);
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
			public void actionPerformed(ActionEvent arg0) {
				GuardarDatos();
				comboCodRubro = new JComboBox(ConexDB.LlamarRubros());
				txtRubro = new JTextArea();
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
			public void actionPerformed(ActionEvent arg0) {
				comboCodRubro = new JComboBox(ConexDB.LlamarRubros());
				txtRubro = new JTextArea();
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
				AmproPrincipal.nuevoRubro = new NuevoRubro();
      			AmproPrincipal.nuevoRubro.setVisible(true);
			}
		});
		btnAgregar.setOpaque(false);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(false);
		
		comboCodRubro = new JComboBox(ConexDB.LlamarRubros());
		comboCodRubro.setToolTipText("Seleccione el n\u00FAmero del rubro a editar");
		comboCodRubro.setBounds(336, 227, 202, 26);
		getContentPane().add(comboCodRubro);
		
		JLabel lblNmeroDeRubro = new JLabel("N\u00FAmero de rubro:");
		lblNmeroDeRubro.setBounds(159, 227, 146, 26);
		getContentPane().add(lblNmeroDeRubro);
		
		JLabel lblRubro = new JLabel("Rubro:");
		lblRubro.setBounds(158, 273, 97, 26);
		getContentPane().add(lblRubro);
		
		txtRubro = new JTextArea();
		txtRubro.setToolTipText("Editar rubro. M\u00E1ximo 500 caracteres.");
		txtRubro.addKeyListener(new KeyListener(){
		public void keyTyped(KeyEvent e)
		{
			if (txtRubro.getText().length() >= 500)
		     e.consume();
		}
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
		}});
		txtRubro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRubro.setBounds(336, 274, 835, 266);
		getContentPane().add(txtRubro);
		
		JButton btnVerrubro = new JButton("Ver rubro");
		btnVerrubro.setToolTipText("Seleccione un rubro y presione este boton para verlo");
		btnVerrubro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRubro.setText(ConexDB.LlamarTxtRubros(Integer.parseInt(comboCodRubro.getSelectedItem().toString())));
			}
		});
		btnVerrubro.setBounds(599, 227, 113, 26);
		getContentPane().add(btnVerrubro);
	}
	
	protected void GuardarDatos()
	{
		
	}
}

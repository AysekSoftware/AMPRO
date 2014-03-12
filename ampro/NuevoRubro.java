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
public class NuevoRubro extends Emergentes 
{
	JTextArea txtRubro;

	public NuevoRubro() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 700, 500);
		
		JLabel lblAgregarRubro = new JLabel("Agregar un nuevo rubro");
		lblAgregarRubro.setBounds(250, 37, 235, 36);
		lblAgregarRubro.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarRubro);
		
		JLabel lblDigiteElNombre = new JLabel("Rubro:");
		lblDigiteElNombre.setBounds(43, 112, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);

		JPanel guardar = new JPanel();
		guardar.setBounds(557, 358, 65, 65);
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
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexDB.GuardarRubro(txtRubro.getText());
      			AmproPrincipal.nuevoRubro.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(478, 358, 65, 65);
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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
      			AmproPrincipal.nuevoRubro.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
		
		txtRubro = new JTextArea();
		txtRubro.setToolTipText("Digite el rubro a evaluar. M\u00E1ximo 500 caracteres.");
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
		txtRubro.setBounds(116, 112, 483, 222);
		getContentPane().add(txtRubro);
	}
}
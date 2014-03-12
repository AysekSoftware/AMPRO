package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CrearUsuario extends Emergentes 
{
	private JTextField txtUss;
	private JPasswordField txtContra1;
	private JPasswordField txtContraVerif;

	public CrearUsuario() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 500, 350);
		
		JLabel lblAgregarNuevaProfesion = new JLabel("Agregar usuario");
		lblAgregarNuevaProfesion.setBounds(171, 30, 142, 36);
		lblAgregarNuevaProfesion.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarNuevaProfesion);
		
		JLabel lblDigiteElNombre = new JLabel("Usuario:");
		lblDigiteElNombre.setBounds(42, 77, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		txtUss = new JTextField();
		txtUss.setBounds(244, 82, 197, 36);
		txtUss.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(txtUss);
		txtUss.setColumns(10);

		JPanel guardar = new JPanel();
		guardar.setBounds(393, 218, 65, 65);
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
				if(ConexDB.NoRepUsuario(txtUss.getText()))
					if(txtContra1.getPassword() == txtContraVerif.getPassword())
					{
						ConexDB.GuardarUsuario(txtUss.getText(), new String(txtContra1.getPassword()));
						AmproPrincipal.crearUsuario.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Contraseñas distintas", "Error", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Usuario ya existente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(314, 218, 65, 65);
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
      			AmproPrincipal.crearUsuario.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblContrasea.setBounds(42, 121, 180, 44);
		getContentPane().add(lblContrasea);
		 
		txtContra1 = new JPasswordField();
		txtContra1.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtContra1.setColumns(10);
		txtContra1.setBounds(244, 126, 197, 36);
		getContentPane().add(txtContra1);
		
		JLabel lblReescribirContrasea = new JLabel("Reescribir contrase\u00F1a:");
		lblReescribirContrasea.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblReescribirContrasea.setBounds(42, 163, 180, 44);
		getContentPane().add(lblReescribirContrasea);
		
		txtContraVerif = new JPasswordField();
		txtContraVerif.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtContraVerif.setColumns(10);
		txtContraVerif.setBounds(244, 168, 197, 36);
		getContentPane().add(txtContraVerif);
	}
	
	public String inputContraseña(Component th,	String mensaje,	String titulo)
	{
		String password = "";
		JPasswordField passwordField = new JPasswordField();
		Object[] obj = {mensaje+":\n\n", passwordField};
		Object stringArray[] = {"OK","Cancel"};
		if (JOptionPane.showOptionDialog(th, obj, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.YES_OPTION)
		{
			password = new String(passwordField.getPassword());
		}
		return password;
	}
}
package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class VerifUsuario extends Emergentes 
{
	private JTextField txtUss;
	private JPasswordField txtContra;
	
	private boolean sesion;
	
	public VerifUsuario(final Emergentes Llamado) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 494, 219);
		
		JLabel lblDigiteElNombre = new JLabel("Usuario:");
		lblDigiteElNombre.setBounds(26, 28, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		txtUss = new JTextField();
		txtUss.setBounds(26, 61, 197, 36);
		txtUss.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(txtUss);
		txtUss.setColumns(10);

		JPanel guardar = new JPanel();
		guardar.setBounds(392, 104, 65, 65);
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
				sesion = ConexDB.VerifUsuario(txtUss.getText(), new String(txtContra.getPassword()));
				if(sesion == true)
				{
					Llamado.setVisible(true);
					AmproPrincipal.verifUsuario.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Error de contraseña", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(313, 104, 65, 65);
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
		lblContrasea.setBounds(241, 28, 180, 44);
		getContentPane().add(lblContrasea);
		 
		txtContra = new JPasswordField();
		txtContra.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtContra.setColumns(10);
		txtContra.setBounds(241, 61, 197, 36);
		getContentPane().add(txtContra);
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
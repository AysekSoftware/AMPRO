package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class EliminarUsuario extends Emergentes 
{
	private JComboBox uss;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EliminarUsuario() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 499, 270);
		
		JLabel lblAgregarNuevaProfesion = new JLabel("Eliminar usuario");
		lblAgregarNuevaProfesion.setBounds(158, 48, 180, 36);
		lblAgregarNuevaProfesion.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarNuevaProfesion);
		
		JLabel lblDigiteElNombre = new JLabel("Usuario a eliminar:");
		lblDigiteElNombre.setBounds(42, 101, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		uss = new JComboBox(ConexDB.LlamarUsuarios());
		uss.setBounds(244, 106, 197, 36);
		uss.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(uss);

		JPanel guardar = new JPanel();
		guardar.setBounds(393, 153, 65, 65);
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
				int ax = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar este usuario?");
				if(ax == JOptionPane.YES_OPTION)
					ConexDB.EliminarUsuario((String)uss.getSelectedItem());
      			AmproPrincipal.eliminarUsuario.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(314, 153, 65, 65);
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
      			AmproPrincipal.eliminarUsuario.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
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
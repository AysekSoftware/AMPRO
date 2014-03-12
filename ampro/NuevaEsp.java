package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class NuevaEsp extends Emergentes 
{
	private JTextField txtNomEsp;

	public NuevaEsp() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 500, 350);
		
		JLabel lblAgregarNuevaEspecialidad = new JLabel("Agregar una especialidad");
		lblAgregarNuevaEspecialidad.setBounds(132, 40, 229, 36);
		lblAgregarNuevaEspecialidad.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarNuevaEspecialidad);
		
		JLabel lblDigiteElNombre = new JLabel("Digite el nombre:");
		lblDigiteElNombre.setBounds(77, 116, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		txtNomEsp = new JTextField();
		txtNomEsp.setBounds(222, 121, 197, 36);
		txtNomEsp.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(txtNomEsp);
		txtNomEsp.setColumns(10);

		JPanel guardar = new JPanel();
		guardar.setBounds(388, 191, 65, 65);
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
				ConexDB.GuardarEspecialidad(txtNomEsp.getText());
      			AmproPrincipal.nuevaEsp.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(309, 191, 65, 65);
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
      			AmproPrincipal.nuevaEsp.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
	}
}

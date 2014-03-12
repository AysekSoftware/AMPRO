package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class NuevoPais extends Emergentes 
{
	private JTextField txtNomPais;

	public NuevoPais() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 500, 350);
		
		JLabel lblAgregarPaisOrigen = new JLabel("Agregar un pais de origen");
		lblAgregarPaisOrigen.setBounds(137, 53, 235, 36);
		lblAgregarPaisOrigen.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarPaisOrigen);
		
		JLabel lblDigiteElNombre = new JLabel("Digite el nombre del pais:");
		lblDigiteElNombre.setBounds(43, 112, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		txtNomPais = new JTextField();
		txtNomPais.setBounds(245, 117, 197, 36);
		txtNomPais.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(txtNomPais);
		txtNomPais.setColumns(10);

		JPanel guardar = new JPanel();
		guardar.setBounds(393, 197, 65, 65);
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
				ConexDB.GuardarPais(txtNomPais.getText());
      			AmproPrincipal.nuevoPais.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(314, 197, 65, 65);
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
      			AmproPrincipal.nuevoPais.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
	}
}

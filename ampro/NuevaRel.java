package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class NuevaRel extends Emergentes 
{
	private JTextField txtNomRel;
	private JTextField txtImp;

	public NuevaRel() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 500, 350);
		
		JLabel lblAgregarNuevaEspecialidad = new JLabel("Agregar una religi�n");
		lblAgregarNuevaEspecialidad.setBounds(143, 33, 197, 36);
		lblAgregarNuevaEspecialidad.setFont(new Font("Georgia", Font.PLAIN, 20));
		getContentPane().add(lblAgregarNuevaEspecialidad);
		
		JLabel lblDigiteElNombre = new JLabel("Digite el nombre:");
		lblDigiteElNombre.setBounds(49, 87, 180, 44);
		lblDigiteElNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(lblDigiteElNombre);
		
		txtNomRel = new JTextField();
		txtNomRel.setBounds(230, 92, 197, 36);
		txtNomRel.setFont(new Font("Georgia", Font.PLAIN, 16));
		getContentPane().add(txtNomRel);
		txtNomRel.setColumns(10);
		
		JLabel lblDigiteLaImportancia = new JLabel("Digite la importancia:");
		lblDigiteLaImportancia.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblDigiteLaImportancia.setBounds(49, 142, 180, 44);
		getContentPane().add(lblDigiteLaImportancia);
		
		txtImp = new JTextField();
		txtImp.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtImp.setColumns(10);
		txtImp.setBounds(230, 147, 197, 36);
		getContentPane().add(txtImp);

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
				ConexDB.GuardarReligion(txtNomRel.getText(), txtImp.getText());
				//AmproPrincipal.agregar.revalidate();
      			AmproPrincipal.nuevaRel.setVisible(false); 
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
      			AmproPrincipal.nuevaRel.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
	}
}

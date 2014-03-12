package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class EditarUno extends Ampro implements ActionListener 
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 34);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 22);
    
    final String cedula;
	
    JTabbedPane panelTab;
    private JPanel iBas = new PanelInfoBasica(), fam = new PanelInfoPadres(); 
    
	public EditarUno(String Cedula) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
						
        cedula = Cedula;
        
		//Titulo
		JLabel lblAgregarEstudiante = new JLabel("Ver un estudiante");
		lblAgregarEstudiante.setForeground(UIManager.getColor("InternalFrame.borderColor"));
		lblAgregarEstudiante.setBounds(721, 72, 310, 52);
		getContentPane().add(lblAgregarEstudiante);
		lblAgregarEstudiante.setFont(letraTexto1);
		
		JPanel guardar = new JPanel();
		guardar.setBounds(1240, 580, 65, 65);
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
				GuardarDatos();
				AmproPrincipal.elegirEditar = new ElegirEditar();
      			AmproPrincipal.elegirEditar.setVisible(true);
      			AmproPrincipal.editar.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(1155, 580, 65, 65);
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
				AmproPrincipal.elegirEditar = new ElegirEditar();
      			AmproPrincipal.elegirEditar.setVisible(true);
      			AmproPrincipal.editar.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
				
		panelTab = new JTabbedPane(JTabbedPane.TOP);
		panelTab.setBounds(20, 150, tamTotal.width-35, tamTotal.height-255);
		getContentPane().add(panelTab);

		panelTab.addTab("Datos Básicos", iBas);
		panelTab.addTab("Familiares", fam);
	}

	protected void GuardarDatos()
	{
	}

	public void actionPerformed(ActionEvent e)
    {
    }
}
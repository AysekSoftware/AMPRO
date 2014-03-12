package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class AgregarUno extends Ampro implements ActionListener 
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 34);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 22);
	
    JTabbedPane panelTab;
    private JPanel iEst = new PanelInfoBasica(), iPadre = new PanelInfo(), iMadre = new PanelInfo(); 
    
	public AgregarUno() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
						
		//Titulo
		JLabel lblAgregarEstudiante = new JLabel("Agregar un estudiante");
		lblAgregarEstudiante.setForeground(UIManager.getColor("InternalFrame.borderColor"));
		lblAgregarEstudiante.setBounds(627, 72, 369, 52);
		getContentPane().add(lblAgregarEstudiante);
		lblAgregarEstudiante.setFont(letraTexto1);				
		
		
		//Botones
		JPanel refrescar = new JPanel();
		refrescar.setBounds(1250, tamTotal.height-590, 65, 65);
		getContentPane().add(refrescar);
		refrescar.setOpaque(false);
		try {
        	refrescar.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("refresh.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                refrescar.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(refrescar);
		getContentPane().add(refrescar);
		refrescar.setLayout(new BorderLayout(0, 0));
		
		JButton btnRefres = new JButton("");
		refrescar.add(btnRefres, BorderLayout.CENTER);
		btnRefres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.elegirEditar.setVisible(false);
      			AmproPrincipal.elegirEditar.setVisible(true);
			}
		});
		btnRefres.setOpaque(false);
		btnRefres.setContentAreaFilled(false);
		btnRefres.setBorderPainted(false);
		
		JPanel guardar = new JPanel();
		guardar.setBounds(1250, 570, 65, 65);
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
				AmproPrincipal.menu = new Menu();
      			AmproPrincipal.menu.setVisible(true);
      			AmproPrincipal.agregar.setVisible(false); 
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		guardar.add(btnGuardar);
		
		JPanel cancelar = new JPanel();
		cancelar.setBounds(1175, 570, 65, 65);
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
				AmproPrincipal.menu = new Menu();
      			AmproPrincipal.menu.setVisible(true);
      			AmproPrincipal.agregar.setVisible(false); 
			}
		});
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		cancelar.add(btnCancelar);
				
		panelTab = new JTabbedPane(JTabbedPane.TOP);
		panelTab.setBounds(20, 150, tamTotal.width-30, tamTotal.height-253);
		getContentPane().add(panelTab);
		
		panelTab.addTab("Datos Básicos", iEst);
		panelTab.addTab("Padre", iPadre);
		panelTab.addTab("Madre", iMadre);
	}

	protected void GuardarDatos()
	{
		PanelInfoBasica.GuardarBasico();
	}

	public void actionPerformed(ActionEvent e)
    {
    }
}

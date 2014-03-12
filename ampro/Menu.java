package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Menu extends Ampro implements ActionListener
{
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 22);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 18);
    public Font letraTexto3 = new Font("Georgia", Font.PLAIN, 16);

    boolean estadoIngres = false, estadoVer = false, estadoAct = false, estadoElim = false, estadoDesc = false, estadoImprim = false;
    JPanel unoIngres, variosIngres, unoVer, variosVer, unoElim, variosElim, unoAct, variosAct, unoImprim, variosImprim, unoDesc, variosDesc, descEntrev;
    JLabel lblUnoIngres, lblVariosIngres, lblUnoVer, lblVariosVer, lblUnoElim, lblVariosElim, lblUnoAct, lblVariosAct, lblUnoImprim, lblVariosImprim, 
    	lblUnoDesc, lblVariosDesc, lblDescEntrev; 	

	public Menu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
        
    //Salir
		JPanel regresar = new JPanel();
		regresar.setBounds(26, 115, 60, 60);
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
		btnRegres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.login = new Login();
      			AmproPrincipal.login.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);
			}
		});
		btnRegres.setOpaque(false);
		btnRegres.setContentAreaFilled(false);
		btnRegres.setBorderPainted(false);
		regresar.add(btnRegres);
		
  	//Opciones del Menu
		JPanel ingres = new JPanel();
		ingres.setBounds(170, 214, 97, 115);
		ingres.setOpaque(false);
		try {
        	ingres.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("ingresar.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                ingres.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(ingres);
		ingres.setLayout(new BorderLayout(0, 0));
		
		JButton btnIngresar = new JButton("");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.agregar = new AgregarUno();
      			AmproPrincipal.agregar.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);
			}
		});
		btnIngresar.setOpaque(false);
		btnIngresar.setContentAreaFilled(false);
		btnIngresar.setBorderPainted(false);
		ingres.add(btnIngresar);
		
		JPanel editar = new JPanel();
		editar.setBounds(467, 214, 97, 115);
		editar.setOpaque(false);
		try {
        	editar.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("actualizar.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                editar.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(editar);
		editar.setLayout(new BorderLayout(0, 0));
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.elegirEditar = new ElegirEditar();
      			AmproPrincipal.elegirEditar.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);
			}
		});
		btnEditar.setOpaque(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);
		editar.add(btnEditar);
		
		JPanel elim = new JPanel();
		elim.setBounds(791, 214, 97, 115);
		elim.setOpaque(false);
		try {
        	elim.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("eliminar.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                elim.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(elim);
		elim.setLayout(new BorderLayout(0, 0));
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AmproPrincipal.elegirVer = new ElegirVer();
      			AmproPrincipal.elegirVer.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);*/
			}
		});
		btnEliminar.setOpaque(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		elim.add(btnEliminar);
		
		JPanel descarg = new JPanel();
		descarg.setBounds(933, 453, 97, 115);
		descarg.setOpaque(false);
		try {
			descarg.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("descargar.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                descarg.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(descarg);
		descarg.setLayout(new BorderLayout(0, 0));
		
		JButton btnDescargas = new JButton("");
		btnDescargas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AmproPrincipal.elegirVer = new ElegirVer();
      			AmproPrincipal.elegirVer.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);*/
			}
		});
		btnDescargas.setOpaque(false);
		btnDescargas.setContentAreaFilled(false);
		btnDescargas.setBorderPainted(false);
		descarg.add(btnDescargas);
		
		JPanel fechas = new JPanel();
		fechas.setBounds(616, 453, 97, 115);
		fechas.setOpaque(false);
		try {
			fechas.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("fechas.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                fechas.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(fechas);
		fechas.setLayout(new BorderLayout(0, 0));
		
		JButton btnFechas = new JButton("");
		btnFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AmproPrincipal.elegirVer = new ElegirVer();
      			AmproPrincipal.elegirVer.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);*/
			}
		});
		btnFechas.setOpaque(false);
		btnFechas.setContentAreaFilled(false);
		btnFechas.setBorderPainted(false);
		fechas.add(btnFechas);
		
		JPanel examen = new JPanel();
		examen.setBounds(1063, 214, 97, 115);
		examen.setOpaque(false);
		try {
			examen.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("examen.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                examen.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(examen);
		examen.setLayout(new BorderLayout(0, 0));
		
		JButton btnExamen = new JButton("");
		btnExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.editarExamen = new EditarExamen();
      			AmproPrincipal.editarExamen.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);
			}
		});
		btnExamen.setOpaque(false);
		btnExamen.setContentAreaFilled(false);
		btnExamen.setBorderPainted(false);
		examen.add(btnExamen);
		
		JPanel entrev = new JPanel();
		entrev.setBounds(303, 447, 97, 115);
		entrev.setOpaque(false);
		try {
        	entrev.setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("entrevista.png");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                entrev.setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContentPane().add(entrev);
		entrev.setLayout(new BorderLayout(0, 0));
		
		JButton btnEntrev = new JButton("");
		entrev.add(btnEntrev);
		btnEntrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.rubros = new RubrosEntrevista();
      			AmproPrincipal.rubros.setVisible(true); 
      			AmproPrincipal.menu.setVisible(false);
			}
		});
		btnEntrev.setOpaque(false);
		btnEntrev.setContentAreaFilled(false);
		btnEntrev.setBorderPainted(false);
		
		JLabel lblIngresarEstudiante = new JLabel("Ingresar estudiante");
		lblIngresarEstudiante.setForeground(new Color(0, 0, 128));
		lblIngresarEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarEstudiante.setFont(letraTexto2);
		lblIngresarEstudiante.setBounds(131, 327, 176, 23);
		getContentPane().add(lblIngresarEstudiante);
		
		JLabel lblEditarEstudiante = new JLabel("Editar estudiante");
		lblEditarEstudiante.setForeground(new Color(0, 0, 128));
		lblEditarEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarEstudiante.setFont(letraTexto2);
		lblEditarEstudiante.setBounds(440, 331, 154, 14);
		getContentPane().add(lblEditarEstudiante);
		
		JLabel lblEliminarEstudian = new JLabel("Eliminar estudiante");
		lblEliminarEstudian.setForeground(new Color(0, 0, 128));
		lblEliminarEstudian.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarEstudian.setFont(letraTexto2);
		lblEliminarEstudian.setBounds(751, 327, 183, 23);
		getContentPane().add(lblEliminarEstudian);
		
		JLabel lblEditarExamen = new JLabel("Editar examen");
		lblEditarExamen.setForeground(new Color(0, 0, 128));
		lblEditarExamen.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarExamen.setFont(letraTexto2);
		lblEditarExamen.setBounds(1041, 327, 140, 23);
		getContentPane().add(lblEditarExamen);
		
		JLabel lblEditarFechas = new JLabel("Editar fechas");
		lblEditarFechas.setForeground(new Color(0, 0, 128));
		lblEditarFechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarFechas.setFont(letraTexto2);
		lblEditarFechas.setBounds(581, 573, 168, 23);
		getContentPane().add(lblEditarFechas);
		
		JLabel lblDescargarExpediente = new JLabel("Descargar expediente");
		lblDescargarExpediente.setForeground(new Color(0, 0, 128));
		lblDescargarExpediente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescargarExpediente.setFont(letraTexto2);
		lblDescargarExpediente.setBounds(883, 573, 204, 19);
		getContentPane().add(lblDescargarExpediente);
		
		JLabel lblRubrosDeEntrevistas = new JLabel("Rubros de entrevistas");
		lblRubrosDeEntrevistas.setForeground(new Color(0, 0, 128));
		lblRubrosDeEntrevistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRubrosDeEntrevistas.setFont(letraTexto2);
		lblRubrosDeEntrevistas.setBounds(260, 573, 199, 23);
		getContentPane().add(lblRubrosDeEntrevistas);		
  	}
      	
      	public void actionPerformed(ActionEvent e)
          {
      		
          }
}

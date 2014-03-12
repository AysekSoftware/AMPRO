package ampro;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Ampro extends JFrame implements ActionListener
{
	protected JMenuBar mb;
    private JMenu menu1, mTema, mEdicion, mUsuario, mFases, mVerFases; 
    private JMenuItem mSalir, mUndo, mRedo, mCrearUss, mEliminarUss, mVerEstadis, mFase1, mFase2, mFase3, mFase4;
    private JRadioButtonMenuItem mTemaVer, mTemaAzu, mTemaNar;
    
    public final static Font letraTitulo1 = new Font("Georgia", Font.BOLD, 38);
    public final static Font letraTexto1 = new Font("Georgia", Font.PLAIN, 28);
    public final static Font letraTexto2 = new Font("Georgia", Font.PLAIN, 22);

	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();

	public Ampro()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgsLogo.png"));
        setIconImage(icon);
        
        //Menu
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Archivo        ");
        menu1.setMnemonic('A');
        mb.add(menu1);
        mTema = new JMenu("Cambiar tema                   "); 	
        mTema.setMnemonic('C');
        mTema.addActionListener(this);
        menu1.add(mTema);  
        
        mTemaVer = new JRadioButtonMenuItem("Verde", true); 
        mTemaVer.addActionListener(this);
        mTema.add(mTemaVer); 
        mTemaAzu = new JRadioButtonMenuItem("Azul", false); 	
        mTemaAzu.addActionListener(this);
        mTema.add(mTemaAzu); 
        mTemaNar = new JRadioButtonMenuItem("Naranja", false); 	
        mTemaNar.addActionListener(this);
        mTema.add(mTemaNar); 
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(mTemaVer);
        grupo.add(mTemaAzu);
        grupo.add(mTemaNar);
        
        mSalir = new JMenuItem("Salir"); 	
        mSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0); 
            }
        });
        
        JMenuItem mntmAcercaDeNosotros = new JMenuItem("Acerca de esto...");
        mntmAcercaDeNosotros.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new InformacionProyecto().setVisible(true);
        	}
        });
        menu1.add(mntmAcercaDeNosotros);
        menu1.add(mSalir);   
        
        mEdicion = new JMenu("Edici\u00F3n          ");
        mEdicion.setMnemonic('E');
        mb.add(mEdicion);
        mUndo = new JMenuItem("Deshacer                         Ctrl+Z");
        mEdicion.add(mUndo);
        mRedo = new JMenuItem("Rehacer                           Ctrl+Y");
        mEdicion.add(mRedo);
        mUsuario = new JMenu("Usuario");
        mUsuario.setMnemonic('U');
        mCrearUss = new JMenuItem("Crear Usuario                         ");
        mCrearUss.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AmproPrincipal.verifUsuario = new VerifUsuario(new CrearUsuario());
      			AmproPrincipal.verifUsuario.setVisible(true); 
        	}
        });
        mUsuario.add(mCrearUss);
        mEliminarUss = new JMenuItem("Eliminar Usuario");
        mEliminarUss.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AmproPrincipal.verifUsuario = new VerifUsuario(new EliminarUsuario());
      			AmproPrincipal.verifUsuario.setVisible(true); 
        	}
        });
        mUsuario.add(mEliminarUss);
        mEdicion.add(mUsuario);
        
        mFases = new JMenu("Fases         ");
        mFases.setMnemonic('F');
        mb.add(mFases);
        mVerFases = new JMenu("Ver Fases");
        mVerFases.setMnemonic('V');
        mFase1 = new JMenuItem("Fase 1");
        mVerFases.add(mFase1);
        mFase2 = new JMenuItem("Fase 2");
        mVerFases.add(mFase2);
        mFase3 = new JMenuItem("Fase 3");
        mVerFases.add(mFase3);
        mFase4 = new JMenuItem("Fase 4");
        mVerFases.add(mFase4);
        mFases.add(mVerFases);
        mVerEstadis = new JMenuItem("Ver Estadisticas");
        mFases.add(mVerEstadis);
        
        //Inicializar ventana
        try {
        	InicializarVentana_Verde();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
	}
	
	//Denifinir los temas
	private void InicializarVentana_Verde() throws Exception 
	{
        JPanel principal_1 = new JPanel(); 
        principal_1.setForeground(SystemColor.controlHighlight);
        try {
            URL imagen = Ampro.class.getResource("verde2_Principal.jpg");
            BufferedImage  img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder( img );
            principal_1.setBorder(borde);
        } catch (Exception e) {
        }
        this.setContentPane(principal_1);
        principal_1.setLayout(null);
        
        JLabel titulo = new JLabel("Sistema de admisión de estudiantes");
        titulo.setForeground(SystemColor.menu);
        titulo.setFont(new Font("Georgia", titulo.getFont().getStyle() | Font.BOLD, titulo.getFont().getSize() + 34));
        getContentPane().add(titulo);
        titulo.setBounds(48, 22, 867, 72);
    }
	
	private void InicializarVentana_Azul() throws Exception 
	{
		JPanel principal_1 = new JPanel(); 
        principal_1.setForeground(SystemColor.controlHighlight);
        try {
            URL imagen = Ampro.class.getResource("azul2_Principal.jpg");
            BufferedImage  img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder( img );
            principal_1.setBorder(borde);
        } catch (Exception e) {
        }
        this.setContentPane(principal_1);
        principal_1.setLayout(null);
        
        JLabel titulo = new JLabel("Sistema de admisión de estudiantes");
        titulo.setForeground(SystemColor.menu);
        titulo.setFont(new Font("Georgia", titulo.getFont().getStyle() | Font.BOLD, titulo.getFont().getSize() + 34));
        getContentPane().add(titulo);
        titulo.setBounds(48, 22, 867, 72);
    }
	
	private void InicializarVentana_Naranja() throws Exception 
	{
		JPanel principal_1 = new JPanel(); 
        principal_1.setForeground(SystemColor.controlHighlight);
        try {
            URL imagen = Ampro.class.getResource("naranja2_Principal.jpg");
            BufferedImage  img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder( img );
            principal_1.setBorder(borde);
        } catch (Exception e) {
        }
        this.setContentPane(principal_1);
        principal_1.setLayout(null);
        
        JLabel titulo = new JLabel("Sistema de admisión de estudiantes");
        titulo.setForeground(SystemColor.menu);
        titulo.setFont(new Font("Georgia", titulo.getFont().getStyle() | Font.BOLD, titulo.getFont().getSize() + 34));
        getContentPane().add(titulo);
        titulo.setBounds(48, 22, 867, 72);
    }
	
	public void actionPerformed(ActionEvent e)
    {
		if(mTemaVer.isSelected())
    	{
            try {
            	InicializarVentana_Verde();
            	this.revalidate();
            } catch (Exception ever2) {
            }
    	} else if(mTemaAzu.isSelected())
    	{
            try {
            	InicializarVentana_Azul();
            	this.revalidate();
            } catch (Exception eaz2) {
            }
    	} else if(mTemaNar.isSelected())
    	{
            try {
            	InicializarVentana_Naranja();
            	this.revalidate();
            } catch (Exception enar2) {
            }
    	} 
    	
    }
}

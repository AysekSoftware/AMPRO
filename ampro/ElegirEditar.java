package ampro;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

@SuppressWarnings("serial")
public class ElegirEditar extends Ampro 
{
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 22);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 18);
   
	static TableColumn agregarColumn;
	private DefaultTableModel[] modelo = null;
    
    JComboBox<String> catBus;
    private JTextField opBus;
    private JTable tabEstudiantes;
    private JTextField numPag;
    private int numeroPagina = 1;	
    
	public ElegirEditar() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(tamTotal.width, tamTotal.height);
        setTitle("Sistema de admisión de estudiantes");
        setExtendedState(MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		catBus = new JComboBox<String>();
		catBus.setModel(new DefaultComboBoxModel<String>(new String[] {"C\u00E9dula", "Primer Apellido", "Segundo Apellido", "Primer Nombre", "Segundo Nombre"}));
		catBus.setBounds(496, 194, 203, 27);
		getContentPane().add(catBus);
		
		opBus = new JTextField();
		opBus.setColumns(10);
		opBus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					tabEstudiantes.setModel(ConexDB.Buscar(catBus.getSelectedIndex(), opBus.getText()));

					tabEstudiantes.getColumnModel().getColumn(0).setResizable(false);
					tabEstudiantes.getColumnModel().getColumn(0).setMinWidth(100);
					tabEstudiantes.getColumnModel().getColumn(0).setMaxWidth(125);
					tabEstudiantes.getColumnModel().getColumn(5).setResizable(false);
					tabEstudiantes.getColumnModel().getColumn(5).setMinWidth(110);
					tabEstudiantes.getColumnModel().getColumn(5).setMaxWidth(110);
					
					agregarColumn = tabEstudiantes.getColumnModel().getColumn(5);
					agregarColumn.setCellEditor(new BtnEditar(tabEstudiantes));
					agregarColumn.setCellRenderer(new Renderer(true));
		          }
			}
		});
		opBus.setBounds(708, 194, 267, 27);
		getContentPane().add(opBus);
		
		JComboBox<String> pagBus = new JComboBox<String>();
		pagBus.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "\u00D1", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		pagBus.setBounds(1262, 194, 44, 27);
		pagBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String letra;
				pagBus.getSelectedIndex()
				*/
			}
		});
		getContentPane().add(pagBus);
		
		modelo = ConexDB.LlamarEstudiantes();
		tabEstudiantes = new JTable();
		tabEstudiantes.setModel(modelo[numeroPagina]);
		tabEstudiantes.setBackground(new Color(204, 255, 255));
		tabEstudiantes.setFont(new Font("Georgia", Font.PLAIN, 12));
		tabEstudiantes.setBounds(40, 247, 1266, 369);
		tabEstudiantes.getColumnModel().getColumn(0).setResizable(false);
		tabEstudiantes.getColumnModel().getColumn(0).setMinWidth(100);
		tabEstudiantes.getColumnModel().getColumn(0).setMaxWidth(125);
		tabEstudiantes.getColumnModel().getColumn(5).setResizable(false);
		tabEstudiantes.getColumnModel().getColumn(5).setMinWidth(110);
		tabEstudiantes.getColumnModel().getColumn(5).setMaxWidth(110);
		getContentPane().add(tabEstudiantes);
		
		agregarColumn = tabEstudiantes.getColumnModel().getColumn(5);
		agregarColumn.setCellEditor(new BtnEditar(tabEstudiantes));
		agregarColumn.setCellRenderer(new Renderer(true));
		
		//agregarColumn = tabEstudiantes.getColumnModel().getColumn(5);
		//tabEstudiantes.setModel(ConexDB.LlamarEstudiantes());
		
		JButton btnAtras = new JButton("<");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(40, 628, 45, 36);
		getContentPane().add(btnAtras);
		
		JButton btnAdelante = new JButton(">");
		btnAdelante.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdelante.setBounds(1261, 627, 45, 36);
		getContentPane().add(btnAdelante);
		
		numPag = new JTextField();
		numPag.setEditable(false);
		numPag.setEnabled(false);
		numPag.setBounds(1176, 194, 76, 27);
		numPag.setColumns(10);
		numPag.setText("Pagina " + Integer.toString(numeroPagina));
		getContentPane().add(numPag);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabEstudiantes.setModel(ConexDB.Buscar(catBus.getSelectedIndex(), opBus.getText()));

				tabEstudiantes.getColumnModel().getColumn(0).setResizable(false);
				tabEstudiantes.getColumnModel().getColumn(0).setMinWidth(100);
				tabEstudiantes.getColumnModel().getColumn(0).setMaxWidth(125);
				tabEstudiantes.getColumnModel().getColumn(5).setResizable(false);
				tabEstudiantes.getColumnModel().getColumn(5).setMinWidth(110);
				tabEstudiantes.getColumnModel().getColumn(5).setMaxWidth(110);
				
				agregarColumn = tabEstudiantes.getColumnModel().getColumn(5);
				agregarColumn.setCellEditor(new BtnEditar(tabEstudiantes));
				agregarColumn.setCellRenderer(new Renderer(true));
			}
		});
		btnBuscar.setBounds(985, 194, 85, 27);
		getContentPane().add(btnBuscar);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdula.setBounds(40, 228, 76, 14);
		getContentPane().add(lblCdula);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrimerApellido.setBounds(139, 228, 267, 14);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegundoApellido.setBounds(385, 228, 267, 14);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre");
		lblPrimerNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrimerNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrimerNombre.setBounds(640, 229, 267, 14);
		getContentPane().add(lblPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
		lblSegundoNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSegundoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegundoNombre.setBounds(893, 228, 267, 14);
		getContentPane().add(lblSegundoNombre);
		
		JLabel lblActualizar = new JLabel("Actualizar");
		lblActualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActualizar.setBounds(1217, 228, 60, 14);
		getContentPane().add(lblActualizar);
		
		JPanel regresar = new JPanel();
		regresar.setBounds(26, 126, 60, 53);
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
				AmproPrincipal.menu = new Menu();
      			AmproPrincipal.menu.setVisible(true); 
      			AmproPrincipal.elegirEditar.setVisible(false);
			}
		});
		btnRegres.setOpaque(false);
		btnRegres.setContentAreaFilled(false);
		btnRegres.setBorderPainted(false);
		regresar.add(btnRegres);
		
		JPanel refrescar = new JPanel();
		refrescar.setBounds(91, 126, 60, 53);
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
		refrescar.setLayout(new BorderLayout(0, 0));
		getContentPane().add(refrescar);
		
		JButton btnRefres = new JButton("");
		btnRefres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmproPrincipal.elegirEditar = new ElegirEditar();
			}
		});
		btnRefres.setOpaque(false);
		btnRefres.setContentAreaFilled(false);
		btnRefres.setBorderPainted(false);
		refrescar.add(btnRefres);
	}
	
	static ActionListener accEditar = new ActionListener() {
		public void actionPerformed(ActionEvent e){
			//Integer fila = agregarColumn.getModelIndex();
			String id = null;
			AmproPrincipal.editar = new EditarUno(id);
			AmproPrincipal.editar.setVisible(true); 
			AmproPrincipal.elegirEditar.setVisible(false);  
		}
	};
}

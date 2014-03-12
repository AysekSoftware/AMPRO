package ampro;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


@SuppressWarnings("serial")
public class PanelInfoPadres extends PanelBase implements ActionListener
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Font letraTitulo1 = new Font("TimesRoman", Font.BOLD, 35);
    public Font letraTexto1 = new Font("TimesRoman", Font.PLAIN, 20);
    public Font letraTexto2 = new Font("TimesRoman", Font.PLAIN, 16);

    private JTable tabFamiliares;
	static TableColumn agregarColumn;
	
    public PanelInfoPadres() 
    {
        setSize(tamTotal.width-40, tamTotal.height-258);
        
        tabFamiliares = new JTable();
        tabFamiliares.setBounds(42, 65, 1235, 16);
        tabFamiliares.setBackground(new Color(204, 255, 255));
        tabFamiliares.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Cedula", "Apellido 1", "Apellido 2", "Nombre  1", "Nombre 2", "Tipo de familiar", "Editar"
        	}
        ));
        tabFamiliares.getColumnModel().getColumn(0).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabFamiliares.getColumnModel().getColumn(0).setMinWidth(100);
        tabFamiliares.getColumnModel().getColumn(0).setMaxWidth(125);
        tabFamiliares.getColumnModel().getColumn(1).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(2).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(3).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(4).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(5).setResizable(false);
        tabFamiliares.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabFamiliares.getColumnModel().getColumn(6).setMinWidth(110);
        tabFamiliares.getColumnModel().getColumn(6).setMaxWidth(110);
        tabFamiliares.getColumnModel().getColumn(5).setMaxWidth(200);
        setLayout(null);
        add(tabFamiliares);

		agregarColumn = tabFamiliares.getColumnModel().getColumn(5);
		agregarColumn.setCellEditor(new BtnEditar(tabFamiliares));
		agregarColumn.setCellRenderer(new Renderer(true));
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setBounds(42, 46, 76, 14);
		lblCdula.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCdula);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(117, 46, 267, 14);
		lblPrimerApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(353, 46, 267, 14);
		lblSegundoApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSegundoApellido);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre");
		lblPrimerNombre.setBounds(587, 46, 267, 14);
		lblPrimerNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrimerNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
		lblSegundoNombre.setBounds(803, 46, 267, 14);
		lblSegundoNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSegundoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSegundoNombre);
		
		JLabel lblActualizar = new JLabel("Editar");
		lblActualizar.setBounds(1183, 46, 60, 14);
		lblActualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblActualizar);
		
		JButton btnAgregarFamiliar = new JButton("Agregar familiar");
		btnAgregarFamiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//tabFamiliares.add;
			}
		});
		btnAgregarFamiliar.setBounds(1161, 98, 116, 23);
		add(btnAgregarFamiliar);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(1052, 46, 105, 16);
		lblTipo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblTipo);
	}

  	public void actionPerformed(ActionEvent e)
	{
	}
}

package ampro;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanelInfo extends PanelBase implements ActionListener
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Font letraTitulo1 = new Font("TimesRoman", Font.BOLD, 35);
    public Font letraTexto1 = new Font("TimesRoman", Font.PLAIN, 20);
    public Font letraTexto2 = new Font("TimesRoman", Font.PLAIN, 16);
    
    int alto = 35, ancho = 215;
    String TIM="", nom1="", nom2="", ap1="", ap2="", prov="", cant="", dis="", tel1="", tel2="", tel3="", telCel="";
  
    private JTextField txtAp1, txtAp2, txtNom1, txtNom2, txtTel1, txtTel2, txtTel3;
    JButton btnMsTelefonos;
    @SuppressWarnings("rawtypes")
	JComboBox comboProf, comboLugarTrab;
    
    int cont = 2;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelInfo() 
    {
        setSize(tamTotal.width-40, tamTotal.height-258);
        
    	//Etiquetas
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(150, 94, 107, 16);
		add(lblCedula);
		lblCedula.setFont(letraTexto1);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre");
		lblPrimerNombre.setBounds(150, 127, 145, 27);
		add(lblPrimerNombre);
		lblPrimerNombre.setFont(letraTexto1);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
		lblSegundoNombre.setBounds(150, 165, 150, 27);
		add(lblSegundoNombre);
		lblSegundoNombre.setFont(letraTexto1);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(150, 204, 171, 27);
		add(lblPrimerApellido);
		lblPrimerApellido.setFont(letraTexto1);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(150, 242, 171, 36);
		add(lblSegundoApellido);
		lblSegundoApellido.setFont(letraTexto1);
		
		JLabel lblTelefono1 = new JLabel("Telefonos:");
		lblTelefono1.setBounds(150, 281, 171, 36);
		add(lblTelefono1);
		lblTelefono1.setFont(letraTexto1);
		
		
		txtAp1 = new JTextField();
		txtAp1.setToolTipText("Primer apellido del alumno a ingresar");
		txtAp1.setBounds(331, 197, ancho, alto);
		add(txtAp1);
		txtAp1.setFont(letraTexto2);
		txtAp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	nom1 = txtAp1.getText();
            }
        });
		
		txtAp2 = new JTextField();
		txtAp2.setToolTipText("Segundo apellido del alumno a ingresar");
		txtAp2.setBounds(331, 237, ancho, alto);
		add(txtAp2);
		txtAp2.setFont(letraTexto2);
		txtAp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	nom2 = txtAp2.getText();
            }
        });
		
		txtNom1 = new JTextField();
		txtNom1.setToolTipText("Primer nombre del alumno a ingresar");
		txtNom1.setBounds(331, 120, ancho, alto);
		add(txtNom1);
		txtNom1.setFont(letraTexto2);
		txtNom1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ap1 = txtNom1.getText();
            }
        });
		
		txtNom2 = new JTextField();
		txtNom2.setToolTipText("Segundo nombre del alumno a ingresar");
		txtNom2.setBounds(331, 160, 215, 33);
		add(txtNom2);
		txtNom2.setFont(letraTexto2);
		txtNom2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ap2 = txtNom2.getText();
            }
        });
		
		txtTel1 = new JTextField();
		txtTel1.setBounds(331, 280, ancho, alto);
		add(txtTel1);
		txtTel1.setFont(letraTexto2);
		txtTel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tel1 = txtTel1.getText();
            }
        });
		
		JFormattedTextField txtCedula = new JFormattedTextField();
		txtCedula.setToolTipText("Cedula del alumno a ingresar");
		txtCedula.setBounds(331, 78, 215, 35);
		txtCedula.setFont(letraTexto2);
		add(txtCedula);
		
		btnMsTelefonos = new JButton("Agregar otro telefono");
		btnMsTelefonos.setBounds(464, 326, 137, 27);
		add(btnMsTelefonos);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblTipo.setBounds(151, 35, 144, 27);
		add(lblTipo);
		
		JComboBox<String> comboTipo = new JComboBox<String>();
		comboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Padre", "Madre", "Encargado"}));
		comboTipo.setSelectedIndex(2);
		comboTipo.setBounds(331, 35, 215, 36);
		add(comboTipo);
		
		JLabel label = new JLabel("Direcci\u00F3n:");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		label.setBounds(777, 35, 175, 39);
		add(label);

		JComboBox comboProvincia = new JComboBox(ConexDB.LlamarProvincia());
		comboProvincia.setBounds(958, 40, 193, 27);
		add(comboProvincia);
		
		JComboBox comboCanton = new JComboBox(ConexDB.LlamarCanton(comboProvincia.getSelectedItem()));
		comboCanton.setBounds(958, 72, 193, 27);
		add(comboCanton);
		
		JLabel lblLugarDeTrabajo = new JLabel("Lugar de trabajo:");
		lblLugarDeTrabajo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblLugarDeTrabajo.setBounds(777, 142, 175, 39);
		add(lblLugarDeTrabajo);
		
		JLabel lblProfesin = new JLabel("Profesi\u00F3n:");
		lblProfesin.setFont(new Font("Serif", Font.PLAIN, 20));
		lblProfesin.setBounds(777, 104, 175, 39);
		add(lblProfesin);
		
		comboProf = new JComboBox(ConexDB.LlamarProfesion());
		comboProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboProf.getSelectedItem() == "Agregar profesión")
				{
					AmproPrincipal.nuevaProf = new NuevaProfesion();
					AmproPrincipal.nuevoPais.setVisible(true);
				}
			}
		});
		comboProf.setBounds(958, 110, 193, 27);
		add(comboProf);
		
		comboLugarTrab = new JComboBox(ConexDB.LlamarLugarTrabajo());
		comboLugarTrab.setBounds(958, 149, 193, 27);
		comboProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboLugarTrab.getSelectedItem() == "Agregar lugar de trabajo")
				{
					AmproPrincipal.nuevoLugarTrab = new NuevoLugarTrab();
					AmproPrincipal.nuevoLugarTrab.setVisible(true);
				}
			}
		});
		add(comboLugarTrab);
		
		btnMsTelefonos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cont==2)
				{
					txtTel2 = new JTextField();
					txtTel2.setBounds(331, 323, ancho, alto);
					add(txtTel2);
					txtTel2.setFont(letraTexto2);
					txtTel2.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	tel2 = txtTel2.getText();
			            }
			        });
					cont++;
					btnMsTelefonos.setBounds(464, 369, 137, 27);
				}else if(cont==3)
				{
					txtTel3 = new JTextField();
					txtTel3.setBounds(331, 366, ancho, alto);
					add(txtTel3);
					txtTel3.setFont(letraTexto2);
					txtTel3.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	tel3 = txtTel3.getText();
			            }
			        });
					btnMsTelefonos.setBounds(464, 1369, 137, 27);
				}
			}
		});
	}

  	public void actionPerformed(ActionEvent e)
	{
		
	}
}

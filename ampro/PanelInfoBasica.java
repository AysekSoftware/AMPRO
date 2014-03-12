package ampro;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanelInfoBasica extends PanelBase implements ActionListener,FocusListener
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Font letraTitulo1 = new Font("TimesRoman", Font.BOLD, 35);
    public Font letraTexto1 = new Font("TimesRoman", Font.PLAIN, 20);
    public Font letraTexto2 = new Font("TimesRoman", Font.PLAIN, 16);
    
    int alto = 35, ancho = 215;
    
    static String TIM, nom1, nom2, ap1, ap2, tel1, tel2, tel3, elecEsp, rel, prov, cant, dis, nacionalidad;
    static float nMat, nSoc, nEsp, nIng, nCie, notaConducta;
    static boolean adecSiNo, padSiNo;
    
    private JTextField txtNom1, txtNom2, txtAp1, txtAp2, txtTel1, txtTel2, txtTel3, tim, txtConducta;
    JButton btnMsTelefonos;
	JLabel lblPadresCasados, lblEspecialidadALa, lblDesearaEntrar;
	@SuppressWarnings("rawtypes")
	static private JComboBox comboEspecialidades, comboReligion, comboProvincia, comboCanton, comboDistrito, comboPaisNacim, comboDiaNacim, comboMesNacim, comboAnoNacim;
	JRadioButton padSi, padNo, adecSi, adecNo;
    
    int cont = 2;
    private final ButtonGroup btnsPadres = new ButtonGroup();
    private final ButtonGroup btnsAdec = new ButtonGroup();
    private JLabel lblFechaDeNacimiento;
    private JTextField textField;
    private JTextField txtPromQ;
    private JTextField TxtPromS;
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelInfoBasica() 
	{
        setSize(tamTotal.width-40, tamTotal.height-258);
		
		//Etiquetas
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(146, 47, 107, 16);
		add(lblCedula);
		lblCedula.setFont(letraTexto1);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre");
		lblPrimerNombre.setBounds(146, 80, 145, 27);
		add(lblPrimerNombre);
		lblPrimerNombre.setFont(letraTexto1);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
		lblSegundoNombre.setBounds(146, 118, 150, 27);
		add(lblSegundoNombre);
		lblSegundoNombre.setFont(letraTexto1);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(146, 157, 171, 27);
		add(lblPrimerApellido);
		lblPrimerApellido.setFont(letraTexto1);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(146, 195, 171, 36);
		add(lblSegundoApellido);
		lblSegundoApellido.setFont(letraTexto1);
		
		JLabel lblTelefono1 = new JLabel("Telefonos:");
		lblTelefono1.setBounds(146, 234, 171, 36);
		add(lblTelefono1);
		lblTelefono1.setFont(letraTexto1);
		
		
		txtNom1 = new JTextField();
		txtNom1.setFont(letraTexto2);
		txtNom1.setToolTipText("Primer apellido del alumno a ingresar");
		txtNom1.setBounds(327, 150, ancho, alto);
		txtNom1.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      nom1 = txtNom2.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtNom1);
		
		txtNom2 = new JTextField();
		txtNom2.setFont(letraTexto2);
		txtNom2.setToolTipText("Segundo apellido del alumno a ingresar");
		txtNom2.setBounds(327, 190, ancho, alto);
		txtNom2.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      nom2 = txtNom2.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtNom2);
		
		txtAp1 = new JTextField();
		txtAp1.setFont(letraTexto2);
		txtAp1.setToolTipText("Primer nombre del alumno a ingresar");
		txtAp1.setBounds(327, 73, ancho, alto);
		txtAp1.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      ap1 = txtAp1.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtAp1);
		
		txtAp2 = new JTextField();
		txtAp2.setFont(letraTexto2);
		txtAp2.setToolTipText("Segundo nombre del alumno a ingresar");
		txtAp2.setBounds(327, 113, 215, 33);
		txtAp2.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      ap2 = txtAp2.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtAp2);
		
		txtTel1 = new JTextField();
		txtTel1.setFont(letraTexto2);
		txtTel1.setBounds(327, 233, ancho, alto);
		txtTel1.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      tel1 = txtTel1.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtTel1);
		
		tim = new JTextField();
		tim.setToolTipText("Cedula del alumno a ingresar");
		tim.setBounds(327, 31, 215, 35);
		tim.setFont(letraTexto2);
		tim.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      TIM = tim.getText();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(tim);
		
		btnMsTelefonos = new JButton("Agregar otro telefono");
		btnMsTelefonos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMsTelefonos.setBounds(460, 279, 170, 27);
		add(btnMsTelefonos);

		lblPadresCasados = new JLabel("Padres casados:");
		lblPadresCasados.setBounds(145, 314, 175, 39);
		lblPadresCasados.setFont(letraTexto1);
		add(lblPadresCasados);
		
		padSi = new JRadioButton("S\u00ED");
		btnsPadres.add(padSi);
		padSi.setBounds(326, 322, 109, 23);
		padSi.setOpaque(false);
		padSi.setFont(letraTexto1);
		add(padSi);
				
		padNo = new JRadioButton("No");
		btnsPadres.add(padNo);
		padNo.setBounds(432, 322, 109, 23);
		padNo.setOpaque(false);
		padNo.setFont(letraTexto1);
		add(padNo);
		
		lblEspecialidadALa = new JLabel("Especialidad a la ");
		lblEspecialidadALa.setBounds(144, 346, 175, 39);
		lblEspecialidadALa.setFont(letraTexto1);
		add(lblEspecialidadALa);
		
		lblDesearaEntrar = new JLabel("que desear\u00EDa entrar:");
		lblDesearaEntrar.setBounds(145, 373, 171, 36);
		lblDesearaEntrar.setFont(letraTexto1);
		add(lblDesearaEntrar);
		
		comboEspecialidades = new JComboBox(ConexDB.LlamarEspecialidad());
		comboEspecialidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboEspecialidades.getSelectedItem() == "Agregar especialidad")
				{
					AmproPrincipal.nuevaEsp = new NuevaEsp();
					AmproPrincipal.nuevaEsp.setVisible(true);
				}
			}
		});
		comboEspecialidades.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      elecEsp = (String)comboEspecialidades.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		comboEspecialidades.setBounds(326, 360, 215, 30);
		add(comboEspecialidades);
		
		JLabel lblAdecuacion = new JLabel("Adecuaci\u00F3n:");
		lblAdecuacion.setFont(letraTexto1);
		lblAdecuacion.setBounds(792, 11, 175, 39);
		add(lblAdecuacion);
		
		adecSi = new JRadioButton("S\u00ED");
		btnsAdec.add(adecSi);
		adecSi.setOpaque(false);
		adecSi.setFont(letraTexto1);
		adecSi.setBounds(973, 19, 109, 23);
		add(adecSi);
		
		adecNo = new JRadioButton("No");
		btnsAdec.add(adecNo);
		adecNo.setOpaque(false);
		adecNo.setFont(letraTexto1);
		adecNo.setBounds(1079, 19, 109, 23);
		add(adecNo);
		
		JLabel lblReligion = new JLabel("Religi\u00F3n:");
		lblReligion.setFont(letraTexto1);
		lblReligion.setBounds(792, 47, 175, 39);
		add(lblReligion);
		
		comboReligion = new JComboBox(ConexDB.LlamarReligion());
		comboReligion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboReligion.getSelectedItem() == "Agregar religion")
				{
					AmproPrincipal.nuevaRel = new NuevaRel();
					AmproPrincipal.nuevaRel.setVisible(true);
				}
			}
		});
		comboReligion.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      rel = (String)comboReligion.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		comboReligion.setBounds(973, 58, 193, 27);
		add(comboReligion);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNacimiento.setBounds(792, 90, 175, 39);
		add(lblNacimiento);
		
		comboPaisNacim = new JComboBox(ConexDB.LlamarPais());
		comboPaisNacim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboPaisNacim.getSelectedItem() == "Agregar pais de origen")
				{
					AmproPrincipal.nuevoPais = new NuevoPais();
					AmproPrincipal.nuevoPais.setVisible(true);
				}
			}
		});
		comboPaisNacim.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      nacionalidad = (String)comboPaisNacim.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		comboPaisNacim.setBounds(973, 95, 193, 27);
		add(comboPaisNacim);
		
		JLabel lblDirección = new JLabel("Direcci\u00F3n:");
		lblDirección.setFont(letraTexto1);
		lblDirección.setBounds(792, 124, 175, 39);
		add(lblDirección);
		
		comboProvincia = new JComboBox(ConexDB.LlamarProvincia());
		comboProvincia.setBounds(973, 129, 193, 27);
		comboProvincia.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      prov = (String)comboProvincia.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(comboProvincia);
		
		comboCanton = new JComboBox(ConexDB.LlamarCanton(comboProvincia.getSelectedItem()));
		comboCanton.setBounds(973, 161, 193, 27);
		comboCanton.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      cant = (String)comboCanton.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(comboCanton);
		
		comboDistrito = new JComboBox(ConexDB.LlamarDistrito(comboProvincia.getSelectedItem()));
		comboDistrito.setBounds(973, 195, 193, 27);
		comboDistrito.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      dis = (String)comboDistrito.getSelectedItem();
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(comboDistrito);
		
		JLabel lblCalificaciones = new JLabel("Calificaciones:");
		lblCalificaciones.setFont(letraTexto1);
		lblCalificaciones.setBounds(792, 224, 171, 27);
		add(lblCalificaciones);
		
		JLabel lblPromQ = new JLabel("Promedios de quinto:");
		lblPromQ.setFont(letraTexto1);
		lblPromQ.setBounds(821, 255, 193, 27);
		add(lblPromQ);
		
		JLabel lblPromS = new JLabel("Promedios de sexto:");
		lblPromS.setFont(new Font("Serif", Font.PLAIN, 20));
		lblPromS.setBounds(821, 287, 164, 27);
		add(lblPromS);
		
		txtConducta = new JTextField();
		txtConducta.setColumns(10);
		txtConducta.setBounds(1005, 323, 109, 30);
		txtConducta.addFocusListener(new FocusListener(){
		   public void focusLost(FocusEvent e)
		   {
		      notaConducta = Float.parseFloat(txtConducta.getText());
		   }
		   public void focusGained(FocusEvent e) {
		   }
		});
		add(txtConducta);
		
		JLabel lblConducta = new JLabel("Conducta quinto:");
		lblConducta.setFont(new Font("Serif", Font.PLAIN, 20));
		lblConducta.setBounds(821, 326, 164, 27);
		add(lblConducta);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Serif", Font.PLAIN, 20));
		lblFechaDeNacimiento.setBounds(146, 407, 175, 39);
		add(lblFechaDeNacimiento);
		
		comboDiaNacim = new JComboBox();
		comboDiaNacim.setToolTipText("Dia de nacimiento");
		comboDiaNacim.setModel(new DefaultComboBoxModel(new String[] {"Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDiaNacim.setBounds(326, 416, 52, 29);
		add(comboDiaNacim);
		
		comboMesNacim = new JComboBox();
		comboMesNacim.setModel(new DefaultComboBoxModel(new String[] {"Mes ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboMesNacim.setToolTipText("Mes de nacimiento");
		comboMesNacim.setBounds(388, 416, 82, 29);
		add(comboMesNacim);
		
		comboAnoNacim = new JComboBox();
		comboAnoNacim.setModel(new DefaultComboBoxModel(new String[] {"A\u00F1o", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		comboAnoNacim.setToolTipText("A\u00F1o de nacimiento");
		comboAnoNacim.setBounds(480, 416, 64, 29);
		add(comboAnoNacim);
		
		JLabel lblConductaSexto = new JLabel("Conducta sexto:");
		lblConductaSexto.setFont(new Font("Serif", Font.PLAIN, 20));
		lblConductaSexto.setBounds(821, 358, 164, 27);
		add(lblConductaSexto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(1005, 355, 109, 30);
		add(textField);
		
		txtPromQ = new JTextField();
		txtPromQ.setEditable(false);
		txtPromQ.setColumns(10);
		txtPromQ.setBounds(1005, 255, 109, 30);
		add(txtPromQ);
		
		TxtPromS = new JTextField();
		TxtPromS.setEditable(false);
		TxtPromS.setColumns(10);
		TxtPromS.setBounds(1005, 289, 109, 30);
		add(TxtPromS);
		
		JButton btnCalcularPromedioQ = new JButton("Calcular Promedio");
		btnCalcularPromedioQ.setBounds(1124, 260, 145, 24);
		add(btnCalcularPromedioQ);
		
		JButton btnCalcularPromedioS = new JButton("Calcular Promedio");
		btnCalcularPromedioS.setBounds(1124, 293, 145, 24);
		add(btnCalcularPromedioS);
		
		btnMsTelefonos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cont==2)
				{
					txtTel2 = new JTextField();
					txtTel2.setBounds(327, 276, ancho, alto);
					add(txtTel2);
					txtTel2.setFont(letraTexto2);
					lblPadresCasados.setBounds(145, 314+43, 175, 39);
					padSi.setBounds(326, 322+43, 109, 23);
					padNo.setBounds(432, 322+43, 109, 23);
					lblEspecialidadALa.setBounds(144, 346+43, 175, 39);
					lblDesearaEntrar.setBounds(145, 373+43, 171, 36);
					comboEspecialidades.setBounds(326, 360+43, 215, 30);
					lblFechaDeNacimiento.setBounds(146, 407+43, 175, 39);
					comboDiaNacim.setBounds(326, 416+43, 52, 25);
					comboMesNacim.setBounds(388, 416+43, 82, 25);
					comboAnoNacim.setBounds(480, 416+43, 64, 27);
					cont++;
					btnMsTelefonos.setBounds(464, 315, 170, 27);
				}else if(cont==3)
				{
					txtTel3 = new JTextField();
					txtTel3.setBounds(327, 319, ancho, alto);
					add(txtTel3);
					txtTel3.setFont(letraTexto2);
					lblPadresCasados.setBounds(145, 314+43, 175, 39);
					padSi.setBounds(326, 322+43, 109, 23);
					padNo.setBounds(432, 322+43, 109, 23);
					lblEspecialidadALa.setBounds(144, 346+43, 175, 39);
					lblDesearaEntrar.setBounds(145, 373+43, 171, 36);
					comboEspecialidades.setBounds(326, 360+43, 215, 30);
					lblFechaDeNacimiento.setBounds(146, 407+43, 175, 39);
					comboDiaNacim.setBounds(326, 416+43, 52, 25);
					comboMesNacim.setBounds(388, 416+43, 82, 25);
					comboAnoNacim.setBounds(480, 416+43, 64, 27);
					btnMsTelefonos.setBounds(2000, 2000, 170, 27);
				}
			}
		});
	}
	
	private static float Promedio(float a, float b, float c, float d, float e)
	{
		float prom = (a+b+c+d+e)/5;
		return prom;
		
	}
	
	protected static void GuardarBasico()
	{
		ConexDB.GuardarBasEstudiante(TIM, nom1, nom2, ap1, ap2);
		Date fechaNacim = new Date();
		//fechaNacim.
		ConexDB.GuardarEstudianteOtros(TIM, rel, nacionalidad, elecEsp, fechaNacim, padSiNo, adecSiNo);
		ConexDB.GuardarTelefonos(TIM, tel1, tel2, tel3);
		ConexDB.GuardarDireccion(TIM, prov, cant, dis);
		ConexDB.GuardarPromedios(TIM, Promedio(nMat, nSoc, nEsp, nIng, nCie), notaConducta);
	}

	public void actionPerformed(ActionEvent e){}

	public void focusGained(FocusEvent e){}

	public void focusLost(FocusEvent e){}
}

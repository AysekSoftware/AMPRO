package ampro;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class AmproPrincipal
{
	//Pantallas principales
	protected static Login login;
	protected static Menu menu;
	protected static ElegirEditar elegirEditar;
	protected static AgregarUno agregar;
	protected static EditarUno editar;
	protected static RubrosEntrevista rubros;
	protected static EditarExamen editarExamen;
	
	//Pantallas de menu
	
	//Pantallas emergentes
	protected static NuevaEsp nuevaEsp;
	protected static NuevaRel nuevaRel;
	protected static NuevoPais nuevoPais;
	protected static NuevaProfesion nuevaProf;
	protected static NuevaPregunta nuevaPregunta;
	protected static NuevoLugarTrab nuevoLugarTrab;
	protected static NuevoRubro nuevoRubro;
	protected static VerifUsuario verifUsuario;	
	protected static CrearUsuario crearUsuario;
	protected static EliminarUsuario eliminarUsuario;
	
	public static final Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) 
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    }
	    catch (Exception e){
        }

		login = new Login();
		login.setBounds(0, 0, tamTotal.width, tamTotal.height);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
	}
}

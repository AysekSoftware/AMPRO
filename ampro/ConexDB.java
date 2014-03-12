package ampro;

import java.sql.*;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

//FUNCIONES DE MANEJO DE LA BD
public class ConexDB 
{
	public static boolean VerifUsuario(String uss, String contra) 
	{
		int cont = 0;
		try {
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call VerifUsuario('"+uss+"','"+contra+"')");
	        	
	        rs.beforeFirst();
	        if (rs.next()) 
	        	cont=1;
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if ( cont == 1 ) 
        	return true;
        else 
        	return false;
	}

	public static DefaultTableModel[] LlamarEstudiantes()
	{
		DefaultTableModel modelo[] = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();

	        ResultSet rs1 = stmt.executeQuery("Call LlamarIDs()");
	        
	        int tam = 0;
	        while(rs1.next())
	        	tam++;
	        if(tam%23 != 0)
	        	tam+=1;

	        rs1.close();
	        
	        modelo = new DefaultTableModel[tam];
	        
	        for(int pag=0; pag<tam; pag++)
	        {
		        ResultSet rs2 = stmt.executeQuery("Call VerBasico()");
		        
		        modelo[pag].addColumn("TIM");
		        modelo[pag].addColumn("Apellido 1");
		        modelo[pag].addColumn("Apellido 2");
		        modelo[pag].addColumn("Nombre 1");
		        modelo[pag].addColumn("Nombre 2");
		        modelo[pag].addColumn("Editar");
		         
		        Object[] fila = new Object[6];    
		        
		        while (rs2.next())
		        {	        
				   for(int i=0;i<5;i++)
		              fila[i] = rs2.getObject(i+1);
		           modelo[pag].addRow(fila);        	
		        }

		        rs2.close();
	        }
	        
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}


	public static DefaultTableModel Buscar(Integer colBus, String opBus)
	{
		DefaultTableModel modelo = new DefaultTableModel();
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = null;
	
	        switch(colBus)
	        {
				case 0:
			        rs = stmt.executeQuery("Call BusTIM('"+ opBus +"')");
					break;
				case 1:
			        rs = stmt.executeQuery("Call BusAP1('"+ opBus +"')");
					break;
				case 2:
			        rs = stmt.executeQuery("Call BusAP2('"+ opBus +"')");
					break;
				case 3:
			        rs = stmt.executeQuery("Call BusNOM1('"+ opBus +"')");
					break;
				case 4:
			        rs = stmt.executeQuery("Call BusNOM2('"+ opBus +"')");
				default:
			        rs = stmt.executeQuery("Call BusTIM('"+ opBus +"')");
					break;
			}
	        
	        modelo.addColumn("TIM");
	        modelo.addColumn("Apellido 1");
	        modelo.addColumn("Apellido 2");
	        modelo.addColumn("Nombre 1");
	        modelo.addColumn("Nombre 2");
	        modelo.addColumn("Editar");
	         
	        Object[] fila = new Object[6];    
	        
	        while (rs.next())
	        {	          
    		   for(int i=0;i<5;i++)
	              fila[i] = rs.getObject(i+1); 
	           modelo.addRow(fila);
	        }
	        
	        //tablasFin = tablas;
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public static String[] LlamarEspecialidad()
	{
		String[] especialidades = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarEspecialidad()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=2;
	        especialidades = new String[tam];
	        
	        especialidades[0] = "Especialidades";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
              especialidades[i] = "		" + (String) rs.getObject("Especialidad"); 
              i++;
	        }
	        
	        especialidades[tam-1] = "Agregar especialidad";
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return especialidades;
	}

	public static void GuardarEspecialidad(String nomEsp)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String codEsp = "es" + nomEsp.substring(0,3);
	        ResultSet rs = stmt.executeQuery("Call GuardarEspecialidad('"+ codEsp +"','"+ nomEsp +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarReligion()
	{
		String[] especialidades = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarReligion()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=2;
	        especialidades = new String[tam];
	        
	        especialidades[0] = "Religiones";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
              especialidades[i] = (String) rs.getObject("Religion"); 
              i++;
	        }
	        
	        especialidades[tam-1] = "Agregar religion";
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return especialidades;
	}

	public static void GuardarReligion(String nomRel, String imp)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String codRel = "re" + nomRel.substring(0,3);
	        ResultSet rs = stmt.executeQuery("Call GuardarReligion('"+ codRel +"','"+ nomRel +"','"+ imp +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarPais()
	{
		String[] paises = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarPais()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=2;
	        paises = new String[tam];
	        
	        paises[0] = "Pais de origen";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	paises[i] = (String) rs.getObject("nom_pais"); 
              i++;
	        }
	        
	        paises[tam-1] = "Agregar pais de origen";
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paises;
	}

	public static void GuardarPais(String pais)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String codPais = "pa" + pais.substring(0,3);
	        ResultSet rs = stmt.executeQuery("Call GuardarReligion('"+ codPais +"','"+ pais +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarProvincia()
	{
		String[] provincias = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarProvincia()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        provincias = new String[tam];
	        
	        provincias[0] = "Provincias";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	provincias[i] = (String) rs.getObject("Provincia"); 
              i++;
	        }
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincias;
	}

	public static String[] LlamarCanton(Object provincia)
	{
		String[] cantones = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String prov = (String)provincia;
	        prov = prov.toLowerCase();
	        prov = prov.substring(0, 3);
	        
	        ResultSet rs = stmt.executeQuery("Call LlamarCanton('"+ prov +"')");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        cantones = new String[tam];
	        
	        cantones[0] = "Cantones";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	cantones[i] = (String) rs.getObject("Canton"); 
              i++;
	        }
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cantones;
	}

	public static String[] LlamarDistrito(Object canton)
	{
		String[] distritos = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();

	        String cant = (String)canton;
	        cant = cant.toLowerCase();
	        cant = cant.substring(0, 3);
	        
	        ResultSet rs = stmt.executeQuery("Call LlamarDistrito('"+ cant +"')");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        distritos = new String[tam];
	        
	        distritos[0] = "Distritos";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	distritos[i] = (String) rs.getObject("Distrito"); 
              i++;
	        }
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return distritos;
	}

	public static String[] LlamarProfesion()
	{
		String[] profesion = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarProfesion()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=2;
	        profesion = new String[tam];
	        
	        profesion[0] = "Profesión";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	profesion[i] = (String) rs.getObject("Profesion"); 
              i++;
	        }
	        
	        profesion[tam-1] = "Agregar profesión";
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profesion;
	}

	public static void GuardarProfesion(String prof)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String codProf = "pr" + prof.substring(0,3);
	        ResultSet rs = stmt.executeQuery("Call GuardarProfesion('"+ codProf +"','"+ prof +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarLugarTrabajo()
	{
		String[] trabajos = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarLugarTrabajo()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=2;
	        trabajos = new String[tam];
	        
	        trabajos[0] = "Lugar de trabajo";
	        
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	trabajos[i] = (String) rs.getObject("Empresa"); 
              i++;
	        }
	        
	        trabajos[tam-1] = "Agregar lugar de trabajo";
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajos;
	}

	public static void GuardarLugarTrabajo(String empresa)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String codEmp = "pr" + empresa.substring(0,3);
	        ResultSet rs = stmt.executeQuery("Call GuardarProfesion('"+ codEmp +"','"+ empresa +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarRubros()
	{
		String[] rubros = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarRubros()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        rubros = new String[tam];
	        
	        rubros[0] = "Número de rubro";
	         
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	String rb = (String) rs.getObject("Cod_rubro");
	        	rubros[i] = rb.substring(3, 5); 
              i++;
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rubros;
	}	

	public static String LlamarTxtRubros(int numRbr)
	{
		String rubros = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarTxtRubros('"+ numRbr +"')");

	        if(rs.next())
	        	rubros = rs.getString("Rubro");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rubros;
	}	

	public static void GuardarRubro(String rubro)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        String[] cods = LlamarRubros();
	        
	        int cont = 1;
	        while(!cods[cont].isEmpty())
	        	cont++;
	        
        	String codRbr;
	        if(cont<10)
	        	codRbr = "rbr0" + cont;
	        else
	        	codRbr = "rbr" + cont;
	        
	        ResultSet rs = stmt.executeQuery("Call GuardarRubro('"+ codRbr +"','"+ rubro +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void GuardarBasEstudiante(String TIM, String nom1, String nom2, String ap1, String ap2)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarBasEstudiante('"+ TIM +"','"+ nom1 +"','"+ nom2 +"','"+ ap1 +"','"+ ap2 +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void GuardarEstudianteOtros(String TIM, String religion, String nacimiento, String especialidad, Date fechaNacim , boolean padresSiNo, boolean adecSiNo)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarEstudianteOtros('"+ TIM +"','"+ religion +"','"+ nacimiento +"','"+ especialidad +"','"+ fechaNacim +"','"+ padresSiNo +"','"+ adecSiNo +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void GuardarTelefonos(String TIM, String tel1, String tel2, String tel3)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarTelefonos('"+ TIM +"','"+ tel1 +"','"+ tel2 +"','"+ tel3 +"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	


	
	
	
	

	public static void GuardarDireccion(String TIM, String prov, String cant, String dis)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarDireccion()");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void GuardarPromedios(String TIM, float prom, float conducta)
	{
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarPromedios()");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void GuardarUsuario(String uss, String contra) 
	{
		try {
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call GuardarUsuario('"+uss+"','"+contra+"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean NoRepUsuario(String uss) 
	{
		int cont = 0;
		try {
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call NoRepUsuario('"+uss+"')");
	        	
	        rs.beforeFirst();
	        if(rs.next()) 
	        	cont=1;
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if ( cont == 1 ) 
        	return true;
        else 
        	return false;
	}
	
	public static void EliminarUsuario(String uss) 
	{
		try {
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call EliminarUsuario('"+uss+"')");
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] LlamarUsuarios()
	{
		String[] usuarios = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarUsuarios()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        usuarios = new String[tam];
	        
	        usuarios[0] = "Usuarios";
	         
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	usuarios[i] = (String)rs.getObject("usuario"); 
              i++;
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}	

	public static String[] LlamarMaterias()
	{
		String[] materias = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarMateria()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        materias = new String[tam];
	        
	        materias[0] = "Materias";
	         
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	materias[i] = (String)rs.getObject("materia"); 
              i++;
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materias;
	}	

	public static String[] LlamarPreguntas(String materia)
	{
		String[] preguntas = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarPreguntas()");
	        
	        int tam = 0;
	        while(rs.next())
	        	tam++;
	        tam+=1;
	        preguntas = new String[tam];
	        
	        preguntas[0] = "Usuarios";
	         
	        Integer i = 1;
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	preguntas[i] = (String)rs.getObject("pregunta"); 
              i++;
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preguntas;
	}	

	public static String LlamarTextoPregunta(String numPregunta)
	{
		String pregunta = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarTxtPregunta('"+ numPregunta +"')");
	        
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	pregunta = (String)rs.getObject("pregunta"); 
            }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pregunta;
	}	

	public static String LlamarRespuesta(String pregunta, int num)
	{
		String respuesta = null;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarRespuesta('"+ pregunta +"', '"+ num +"')");
	     
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	respuesta = (String)rs.getObject("respuesta"); 
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}	

	public static int LlamarRespuestaCorrecta(String pregunta)
	{
		int respuesta = 0;
		try{
			Connection connection = Conexion.conectar();
	        Statement stmt = connection.createStatement();
	
	        ResultSet rs = stmt.executeQuery("Call LlamarRespuesta('"+ pregunta +"')");
	     
	        rs.beforeFirst();
	        while (rs.next())
	        {
	        	respuesta = (int)rs.getObject("respuesta"); 
	        }
	        
	        rs.close();
	        stmt.close();
	        Conexion.desconectar(connection);	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}	
	
}
package Clases;
import java.io.IOException;
import java.util.ArrayList;

public class ListaProyectos  implements Lista,Cloneable {

	
	private ArrayList <Proyecto> arrayProyectos;
	

//constructor
	public ListaProyectos(Archivo archivo) {
		
		arrayProyectos = new ArrayList<Proyecto>();
		archivo.cargarArchivoTextoProyecto(ListaProyectos.this);
	}
	
	public ListaProyectos() {
		arrayProyectos= new ArrayList<Proyecto>();
	}

	public Proyecto crearProyecto(String id,String nombre,String direccion,String ciudad,String nombreEncargado,int numPisos,int numDepts) {
		Proyecto proyecto=new Proyecto(id,nombre,direccion,ciudad,nombreEncargado,numPisos,numDepts);
		
		return proyecto;
	}

	
//agrega un nuevo proyecto a lista de proyectos 

	
		public boolean agregar(Object proyectonuevo)
		{
			if(!existe(((Proyecto)proyectonuevo).getId()))
			{
				arrayProyectos.add((Proyecto)proyectonuevo);
				Archivo archivo = new Archivo();
				try {
					archivo.actualizarTxtProyectos((Proyecto)proyectonuevo);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
			
			return false;
				
		}
		//utilizado al cargar de los txt
		public boolean agregarSinArchivo(Proyecto proyectonuevo)
		{
			if(!existe(((Proyecto)proyectonuevo).getId()))
			{
				arrayProyectos.add((Proyecto)proyectonuevo);
				return true;
			}
			
			return false;
				
		}
			
		

//busca un proy por el id en el array de proy
		public Proyecto busqueda(String buscado)
		{									   	
			if(arrayProyectos!=null){
				for(int i = 0; i < arrayProyectos.size(); i++){
					if(buscado.equals(arrayProyectos.get(i).getId()))
					{
						return arrayProyectos.get(i);
						
					}
				}
			}
			return null;	
		}

public Proyecto buscarNombre(String buscado)
		{									   	
			if(arrayProyectos!=null){
				for(int i = 0; i < arrayProyectos.size(); i++){
					if(buscado.equals(arrayProyectos.get(i).getNombre()))
					{
						return arrayProyectos.get(i);
						
					}
				}
			}
			return null;	
		}

public boolean modificarNombre(Object proyectoModificar,String cambiar)
		{
			Archivo archivo=new Archivo();
		
			if(existe(((Proyecto)proyectoModificar).getId()))
			{
				((Proyecto)proyectoModificar).setNombre(cambiar);
				try {
					archivo.actualizarTxtProyectos((Proyecto)proyectoModificar);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}

	//modifica el nombre de el proyecto 
//eliminar porque se generan solos 
	public boolean modificarId(Object proyectoModificar,String cambiar)
		{
			Archivo archivo=new Archivo();
		
			if(existe(((Proyecto)proyectoModificar).getId()))
			{
				((Proyecto)proyectoModificar).setId(cambiar);
				try {
					archivo.actualizarTxtProyectos((Proyecto)proyectoModificar);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}
	//modifica la direccion donde se encuentra el proyecto 
		public boolean modificarDireccionProy( Proyecto proyectoModificar,String nuevaDireccion)
		{
	    	Archivo archivo=new Archivo();

			if(existe(proyectoModificar.getId()))
			{
				proyectoModificar.setDireccion(nuevaDireccion);
				try {
					archivo.actualizarTxtProyectos((Proyecto)proyectoModificar);
					} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}
		
		public boolean modificarCiudad( Proyecto proyectoModificar,String nuevaCiudad)
		{
	    	Archivo archivo=new Archivo();

			if(existe(proyectoModificar.getId()))
			{
				proyectoModificar.setCiudadUbicacion(nuevaCiudad);
				try {
					archivo.actualizarTxtProyectos((Proyecto)proyectoModificar);
					} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}
		
		
		
		
//modifica el nombre de la persona encargada del proyecto 
	public boolean modificarNombreEncargado( Proyecto proyectoModificar,String nuevoNombreEncargado)
	{
    	Archivo archivo=new Archivo();

		if(existe(proyectoModificar.getId()))
		{
			proyectoModificar.setNombreEncargado(nuevoNombreEncargado);
			try {
				archivo.actualizarTxtProyectos((Proyecto)proyectoModificar);
				} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	
	
	public Proyecto buscarPorCiudad(String ciudad)
	{
		if(arrayProyectos!=null){
			for(int i = 0; i < arrayProyectos.size(); i++){
				if(ciudad.equals(arrayProyectos.get(i).getCiudadUbicacion()))
				{
					return arrayProyectos.get(i);
					
				}
			}
		}
		return null;
	}

	public Proyecto busquedaPorNombreEncargado(String nomEncargado)
	{
		if(arrayProyectos!=null){
			for(int i = 0; i < arrayProyectos.size(); i++){
				if(nomEncargado.equals(arrayProyectos.get(i).getNombreEncargado()))
				{
					return arrayProyectos.get(i);
					
				}
			}
		}
		return null;
	}

			
			public int size()
			{
				return arrayProyectos.size();
			}

	//elimina un proyecto del arreglo 
	public boolean eliminar(Object proyecto)
	{    	
		if(existe(((Proyecto)proyecto).getId()))
		{
			Archivo archivos= new Archivo();
			archivos.eliminarTxtProyecto((Proyecto)proyecto);
			return true;
		}
		return false;	
	}
		public boolean existe(Object buscado)
		{										
			if(arrayProyectos!=null){
				for(int i = 0; i < arrayProyectos.size(); i++)
				{
					if(buscado.equals(arrayProyectos.get(i))){
						return true;			
					}
				}
			}
			return false;
		}
		public Proyecto getPosProyecto(int i)
		{
			if(i<arrayProyectos.size())
				return arrayProyectos.get(i);
			
			return null;
		}
		
		public ListaProyectos clone() throws CloneNotSupportedException  {
			
			Proyecto proy=new Proyecto();
			ListaProyectos proyectos=new ListaProyectos();
			for(int i=0;i<arrayProyectos.size();i++)
			{
				proy=arrayProyectos.get(i).clone();
				proyectos.agregarSinArchivo(proy);
			}
                 return proyectos;
			 }
		 
		
		
		public ArrayList<Departamento> TodosLosDepartamentos()
		{
			ArrayList<Departamento> todosDepts= new ArrayList<Departamento>();
			for(int i=0;i<arrayProyectos.size();i++)
			{
				Proyecto proyActual = arrayProyectos.get(i);
				for(int j=0;j<proyActual.sizeDepartamentos();j++)
				{
					todosDepts.add(proyActual.getPosDept(i));
				}
			}
			return todosDepts;
		}

		

		public int largo() {
			return arrayProyectos.size();
		}
		
		//crea un numero id que no se repita
		public String generarIdProyecto()
		{								
			char letra = 'a';
			String aux="";
			String claveNueva="a";
			
				if(arrayProyectos==null)
					arrayProyectos= new ArrayList<Proyecto>();
				for(int i=0;i<arrayProyectos.size();i++)
				{
					
					claveNueva=aux+letra;
					if(arrayProyectos.get(i).getId()==claveNueva)
					{
						letra=(char) (letra+1);
					}
					
					if(letra=='z')
					{
						aux=aux+letra;
						letra='a';
					}
				}
			
			return claveNueva;
		}

		public Departamento busquedaDept(String departamentoStr) {
			String strDatos=departamentoStr;
			  char[] ca = strDatos.toCharArray();
			  String id = null ;
			   String num = null;
			  for(int i=0; i<strDatos.length();i++)
			  { 	
			if(Character.isLetter(ca[i]))       //Si es letra
			        id=(""+ca[i]); 
			else    
			if(Character.isDigit(ca[i]))//Si no es letra
			        num=(""+ca[i]);   
			   }
			  
			  Proyecto proy=busqueda(id);
			 Departamento dept= proy.buscarNumeroDepartamento(num);
			return dept;
		}

		
	

	
}

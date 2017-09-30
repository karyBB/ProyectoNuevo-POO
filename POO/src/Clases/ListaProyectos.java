package Clases;
import java.io.IOException;
import java.util.ArrayList;

public class ListaProyectos  {

	
	private ArrayList <Proyecto> arrayProyectos;
	

//constructor
	public ListaProyectos(Archivo archivo) {
		
		arrayProyectos = new ArrayList<Proyecto>();
		archivo.cargarArchivoTextoProyecto(ListaProyectos.this);
	}
	public int size()
	{
		return arrayProyectos.size();
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
		public boolean agregarSinArchivo(Proyecto proyectonuevo)
		{
			if(!existe(((Proyecto)proyectonuevo).getId()))
			{
				arrayProyectos.add((Proyecto)proyectonuevo);
				return true;
			}
			
			return false;
				
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

//modifica el nombre de el proyecto 

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
	
	
	
	public Proyecto busquedaPorCiudad(String ciudad)
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
	public Proyecto busquedaNombre(String buscado)
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

		public boolean existe(String buscado)
		{										
			if(arrayProyectos!=null){
				for(int i = 0; i < arrayProyectos.size(); i++)
				{
					if(buscado.equals(arrayProyectos.get(i).getId())){
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
		
		
		public ArrayList<Departamento> TodosLosDepartamentos()
		{
			ArrayList<Departamento> todosDepts= new ArrayList<Departamento>();
			for(int i=0;i<arrayProyectos.size();i++)
			{
				Proyecto proyActual = arrayProyectos.get(i);
				for(int j=0;j<proyActual.getListaDepartamentos().largo();j++)
				{
					todosDepts.add(proyActual.getListaDepartamentos().getPosDept(j));
				}
			}
			return todosDepts;
		}

		public Proyecto getPosDept(int i) 
		{
			if(arrayProyectos.get(i)==null)
			return null;
			
			return arrayProyectos.get(i);
		}

		public int largo() {
			return arrayProyectos.size();
		}
		
		//crea un numero id que no se repita
		public String generarId()
		{								
			int numero=0,cont;
			int correcto=0;
			while(correcto!=1)
			{
				cont=numero;
				if(arrayProyectos==null)
					arrayProyectos= new ArrayList<Proyecto>();
				for(int i=0;i<arrayProyectos.size();i++)
				{
					if(Integer.parseInt(arrayProyectos.get(i).getId())==numero)
						numero++;
				}
				if(cont==numero)
					correcto=1;		//se valida que el numero no lo tenga otro comentario
			}
			return String.valueOf(numero);
		}

	
}

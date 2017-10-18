package Clases;
import java.io.IOException;
import java.util.ArrayList;

public class ListaProyectos  implements Lista,Cloneable {

		
		private ArrayList <Proyecto> arrayProyectos;
		
	
		
		
		
		
	/*constructores de ListaProyectos*/
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
	/*fin de los contructores*/
		
		
		
		
		
		
		
		
		
		
		 /**
			 * Metodo agregar ,agrega un objeto poyectonuevo a la ArrayList 
			 * este metodo revisa  si el proyecto se encuentra antes de agregarlo
			 * y actualiza el archivo de este proyecto
			 * retorna un true si lo logra y un false si no 
			 */	
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


			
			
			
			
			
			
			 /**
			 * Metodo agregar sin archivo ,agrega un proyecto nuevo a el arraylist 
			 * este metodo revisa  si el proyecto se encuentra antes de agregarlo
			 * retorna un true si lo logra y un false si no 
			 */	
			public boolean agregarSinArchivo(Proyecto proyectonuevo)
			{
				if(!existe(((Proyecto)proyectonuevo).getId()))
				{
					arrayProyectos.add((Proyecto)proyectonuevo);
					return true;
				}
				
				return false;
					
			}
				
			
	
	        
			
			
			
			
			 /**
			 * Metodo busqueda
             *recorre el arrayProyectos y va comparando los id 
             *retorna el proyecto que tenga el id
			 */	
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
	        
			
			
			
			
			
			
			/**
			 * Metodo buscarNombre
             *recorre el arrayProyectos y va comparando los nombres 
             *retorna el proyecto que tenga el nombre
			 */	
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
			
			
			
			
			
			
			
			
		
		
			/**
			 *Metodo buscarPorCiudad
             *recorre el arrayProyectos y va comparando la ciudad 
             *retorna el proyecto que tenga la ciudad
			 */	
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
		
			
			
			
			
			
			
			
			/**
			 * Metodo buscarPorNombreEncargado
             *recorre el arrayProyectos y va comprando los nombres de encargados
             *retorna el proyecto que tenga el nombre del encargado
			 */	
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
			
		
		
			
			
			
			
			
			/**
			 * MetodomodificarNombre
	         * recibe el proyecto a modificar y el nombre nuevo 
	         * verifica que este el proyecto y modifica el nombre 
	         * luego actualiza el archivo del proyecto modificado 
	         * retorna true si lo logra y false si no 
			 */	
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
			
			
			
			
			
			
			
			/**
			 * MetodomodificarDireccion
	         * recibe el proyecto a modificar y la nueva direccion
	         * verifica que este el proyecto y modifica la direccion 
	         * luego actualiza el archivo del proyecto modificado 
	         * retorna true si lo logra y false si no 
			 */
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
				
				
				
				
				

				/**
				 * Metodo modificarCiudad
		         * recibe el proyecto a modificar y la nueva ciudad
		         * verifica que este el proyecto y modifica la ciudad 
		         * luego actualiza el archivo del proyecto modificado 
		         * retorna true si lo logra y false si no 
				 */
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
				
				
				
				

				
				

				/**
				 * Metodo modificarNombreEncargado
		         * recibe el proyecto a modificar y el nuvo nombre de encargado
		         * verifica que este el proyecto y modifica el nombre del encargado 
		         * luego actualiza el archivo del proyecto modificado 
		         * retorna true si lo logra y false si no 
				 */
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
		
					
				
				
				
				
				
			     /**
			      * Metodo que retorna el tamaño del arrayList de proyectos
			      */
				public int size()
				{
					return arrayProyectos.size();
				}
		
				
				
				
				
				
				
				
				

				/**
				 * Metodo eliminar
		         * recibe el proyecto a eliminar 
		         * verifica que este el proyecto lo elimina 
		         * luego elimina el archivo del proyecto  
		         * retorna true si lo logra y false si no 
				 */
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
				
				
				
				
				
				
				
				

				/**
				 * Metodo existe
		         * recibe el proyecto y lo busca 
		         * retorna true si lo encuentra y false si no 
				 */
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
				
				
				
				
				
				
				

				/**
				 * Metodo getPosProyecto
				 * recibe un numero de indice 
		         * retorna el proyecto que se encuentre en esa posicion 
				 */
				public Proyecto getPosProyecto(int i)
				{
					if(i<arrayProyectos.size())
						return arrayProyectos.get(i);
					
					return null;
				}
				
				
				
				
				
				
				
				
				

				/**
				 * clone
				 * crea un listade proyecto y clona la lista actual 
				 * este lo retorna esta lista
				 * solo es utilizado para los reportes 
				 */
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
				 
				
				
				
				
				
				
				
				
				
			
					
		
				
				
				 /**
				 * Metodo generar id 
				 * utilizando letra genera una clave unica
				 * si esta combinacion de letras no se encuentra anteriormente se puede utilizar
				 * como clave del proyecto
				 */	
				public String generarIdProyecto()
				{								
					
					int letraInt= 97;
					char letra = (char) letraInt;
					String aux="";
					String claveNueva=aux+letra;
				
					for(int i=0;i<arrayProyectos.size();i++)
					{
						letraInt++;
						if(letraInt>122)
						{
							letraInt=97;
							letra=(char) letraInt;
							aux=aux+letra;
							
						}
						letra=(char) letraInt;
						claveNueva=aux+letra;
						
						if(busqueda(claveNueva)==null)
							return claveNueva;
		
					}
				
					return claveNueva;
				}
		
				
				
				
				
				
				
				
				 /**
				 * Metodo busqueda depratamentos 
				 * este metodo separa el id del proyecto y el nuemero del dept pera buscarlo 
				 * retorna un departamento o null dependeiendo de si se encuentra ese departamento 
				 */	
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

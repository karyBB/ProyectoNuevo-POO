package Clases;
	import java.io.IOException;
	import java.util.*;
	import java.util.Map.Entry;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	import javax.swing.JPasswordField;
	public class ListaAdministradores extends ListaPersonas implements Lista,Cloneable {
	
		
		
		private HashMap<String,Administrador> administradores;
		
		
		
		
		
		
	/*constructores listaAdministradores*/
		public ListaAdministradores(Archivo archivo) {
			
			administradores =new HashMap<String,Administrador>();	
			archivo.cargarArchivoTextoAdministrador(ListaAdministradores.this);
			 
		}
        public ListaAdministradores() {
			
			administradores =new HashMap<String,Administrador>();	
			
			 
		}
	/*fin de los constructores de la clase listaAdministradores*/	
	
		


        
        
        
        /**
         * 
         * Metodos de la clase ListaAdministradores
         * 
         * */
        
        
        
        
        
        
        

        		
        /**
         * Metodo crear recibe
         * @param nombre
         * @param rut
         * @param direccion
         * @param correo
         * @param telefono
         * @param cargo
         * @param clave
         * y retorna un Administrador
         */
		public Administrador crear(String nombre,String rut ,String direccion ,String correo,String telefono,String cargo,String clave)
		    {
		    	Administrador administrador=new Administrador(nombre,rut,direccion,correo,telefono,clave ,cargo);
		    	return administrador;
		    	
		    	
		    }
			
		
		
		
		
		
		
		
		
			
		/**
		 * Metodo que valida la clave del administrador que esta ingresando 
		 * con el nombre y la clave es buscado en el hashmap
		 * retorna un true si el administrador es encontrado y un flase si no lo es
		 */ 
		 public boolean validarClaveAdministrador(String nombre,String clave )
		  {
			 Administrador admin = administradores.get(clave);
			 {
				 if(admin.getNombre().equals(nombre))
					 return true;
			 }
			 return false;
			
		  }
		 
		 
		 
		 
		 
		 
		
		
				
		 /**
			 * Metodo agregar ,agrega un objeto administrador nuevo a el hashmap 
			 * este metodo revisa  si el administrador se encuentra antes de agregarlo
			 * retorna un true si lo logra y un false si no 
			 */	
		public boolean  agregar(Object adminNuevo) 
		 {
		
			if(!existe(((Administrador)adminNuevo).getRut()))
			{
				administradores.put(((Administrador)adminNuevo).getClave(), (Administrador)adminNuevo);
				Archivo archivo = new Archivo();
					try {
						archivo.actualizarTxtAdministrador((Administrador)adminNuevo);
					} catch (IOException e) {
						
						e.printStackTrace();
					}	
				return true;
			}
			return false;
				
		 }	
		 
		
		
		
		
		
		
		/**
		 * Metodo que agregar al hashmap un administrador si  archivo ,es par ano sobre escribir el archivo 
		 */
		 public boolean agregarSinArchivo(Administrador nuevoAdministrador) {
			     if(!existe(nuevoAdministrador))
				 {
			    	 administradores.put(nuevoAdministrador.getClave(), nuevoAdministrador);
			      return true;
				 }
			 return false;
		 }
		 
		 
		 
		 
		
		 
		 
		 
		/**
		 * modificar el nombre del administrador 
		 * recibe el objeto administrador a modificar  y el nuevo nombre
		 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa el nombre 
		 * retorna true si lo pudo hacer y false si no 
		 */
		    public boolean modificarNombre(Object administradorModificar,String nuevoNombre)
		    
		    {
		    	Archivo archivo=new Archivo();
		    
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		
		    		((Administrador)administradorModificar).setNombre(nuevoNombre);
		
		           try {
					archivo.actualizarTxtAdministrador((Administrador)administradorModificar);
				} catch (IOException e) {
					e.printStackTrace();
				}
		    		return true;
		    	}
		    	
		    	return false;
		    
		    }
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * modificar la clave del administrador 
			 * recibe el objeto administrador a modificar  y la nueva clave
			 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa la clave  
			 * retorna true si lo pudo hacer y false si no 
			 */
		    public boolean modificarClave(Object administradorModificar,String nuevaClave)
		    {
		    	Archivo archivo=new Archivo();
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		
		    		Administrador adminModificar;
		    		adminModificar=administradores.get(((Administrador)administradorModificar).getClave());
		    		adminModificar.setClave(nuevaClave);
		    		  try {
		    				archivo.actualizarTxtAdministrador((Administrador)administradorModificar);
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    	    		return true;
		    	    	}
		    	
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * modificar la direccion del administrador 
			 * recibe el objeto administrador a modificar  y la nueva direccion
			 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa la direccion  
			 * retorna true si lo pudo hacer y false si no 
			 */
		    public boolean modificarDireccion(Object administradorModificar,String nuevaDireccion)
		    {
		    	Archivo archivo=new Archivo();
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		
		    		Administrador adminModificar;
		    		adminModificar=administradores.get(((Administrador)administradorModificar).getClave());
		    		adminModificar.setDireccion(nuevaDireccion);
		    		  try {
		  				archivo.actualizarTxtAdministrador((Administrador)administradorModificar);
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  	    		return true;
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * modificar la correo del administrador 
			 * recibe el objeto administrador a modificar  y el nuevo correo
			 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa el correo  
			 * retorna true si lo pudo hacer y false si no 
			 */
		    public boolean modificarCorreo(Object administradorModificar,String nuevoCorreo)
		    {
		    	Archivo archivo=new Archivo();
		
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		Administrador adminModificar;
		    		adminModificar=administradores.get(((Administrador)administradorModificar).getClave());
		    		adminModificar.setCorreo(nuevoCorreo);
		    		try {
		  				archivo.actualizarTxtAdministrador((Administrador)administradorModificar);
		    	} catch (IOException e) {
		  				e.printStackTrace();
		  			
		  	    		return true;    	}
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * modificar el telefono  del administrador 
			 * recibe el objeto administrador a modificar  y el nuvo telefono
			 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa el telefono 
			 * retorna true si lo pudo hacer y false si no 
			 */
		    public boolean modificarTelefono(Object administradorModificar,String nuevoTelefono)
		    {
		    	Archivo archivo=new Archivo();
		
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		Administrador adminModificar;
		    		adminModificar=administradores.get(((Administrador)administradorModificar).getClave());
		    		adminModificar.setTelefono(nuevoTelefono);
		    		try {
		  				archivo.actualizarTxtAdministrador((Administrador)administradorModificar);
		    		}
		    		catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  	    		return true; 
		  	    		}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * modificar el cargo  del administrador 
			 * recibe el objeto administrador a modificar  y  el nuvo cargo
			 * el metodo comprueba que este se encuentre en el hashmap  y  ingresa el cargo  
			 * retorna true si lo pudo hacer y false si no 
			 */
		    public boolean modificarCargo(Object administradorModificar,String nuevoCargo)
		    {    	Archivo archivo=new Archivo();
		
		    	if(existe(administradores.get(((Administrador)administradorModificar).getClave())))
		    	{
		    		Administrador adminModificar;
		    		adminModificar=administradores.get(((Administrador)administradorModificar).getClave());
		    		adminModificar.setCargo(nuevoCargo);
		    		try {
		    		archivo.actualizarTxtAdministrador((Administrador)administradorModificar);}
		    		catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  	    		return true;    
		  	    		}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Eliminar administrador 
			 * recibe el objeto administrador a eliminar
			 * el metodo comprueba que este se encuentre en el hashmap  y lo elimina  
			 * retorna true si lo pudo hacer y false si no 
			 */
		   public boolean eliminar(Object administradorEliminado)
		   {
			   if(existe(administradorEliminado))
			   {
				   administradores.remove(((Administrador)administradorEliminado).getClave(), administradorEliminado);
				   return true;
			   }
			   return false;
		   }
		 
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   /**
			 * buscarNombre  
			 * recibe el nombre del administrador buscado
			 * el metodo recorre el hashmap y va comparando los nombres
			 * retorna el administrador que tenga el nombre
			 */  
			public Administrador buscarNombre(String nombre)
			{
			
				 for (Entry<String, Administrador> e: administradores.entrySet())
				 {
					 if(e.getValue().getNombre().equals(nombre))
					 {
						 return e.getValue();
					 }
				   }		
				return null;
			}
		
		
			
			
			
			
			/**
			 * busqueda  
			 * recibe el rut del administrador buscado  
			 * el metodo recorre el hashmap y va comparando los rut
			 * retorna el administrador que tenga el rut
			 */ 
			public Administrador busqueda(String rut)
			{
				 for (Entry<String, Administrador> e: administradores.entrySet())
				 {
					 if(e.getValue().getRut().equals(rut))
					 {
						 return e.getValue();
					 }
				   }		
				return null;
			}
			
			
			
			
			
			
			
			/**
			 * buscarClave  
			 * recibe una clave 
			 * el metodo recorre el hashmap y va comparando las claves
			 * retorna el administrador que tenga la clave
			 */
			public Administrador buscarClave(String clave)
			{
				 for (Entry<String, Administrador> e: administradores.entrySet())
				 {
					 if(e.getKey().equals(clave))
					 {
						 return e.getValue();
					 }
				   }		
				return null;
			}
			
			
			
			
			
			
			
			
			/**
			 * obtener  
			 * recibe un rut
			 * retorna el administrador que tenga ese rut
			 */
			public Administrador obtener(String rut)
			{															
				for (Entry<String, Administrador> e: administradores.entrySet())
				 {
					 if(!e.getValue().getRut().equals(rut))
						 return e.getValue();
					 
				  }		
				return null;			
			}
			
		
			
			
			
			
			
			/**
			 * existe 
			 * recibe un objeto 
			 * el metodo retorna se true si este se encuentra en el hashmap y false si no 
			 */
			public boolean existe(Object  administrador)
			{
				if(administrador== null)
					return false;
				
				if(administradores.containsValue(administrador))
				{
					return true;
				}
				return false;
			}
			
			
			
			
			
			
			
			
			/**
			 * Metodo que retorna el tamaño del hashmap 
			 */
			
			public int size()
			{
				return administradores.size();
			}
			
			
			
			
		
		    
			
			
			/**
			 * getAdministrador
			 * busca al administrador por su nombre y por su clave 
			 * retorna el Administrador que tenga el nombre y la clave
			 */
			public Administrador getAdministrador(String admin, JPasswordField clave)
			{																									    	
				Administrador adminRetornar = buscarClave(clave.getText());
				if(adminRetornar==null)
					return null;
				if(adminRetornar.getNombre().equals(admin))
					return adminRetornar;
				
				return null;
			}
	
		
	
			
			
			
			
			
			/**
			 * clonarLista
			 * crea un hashmap y clona el hashmap actual 
			 * este lo retorna 
			 * solo es utilizado para los reportes 
			 */
			public HashMap<String, Administrador> clonarLista () {
				 HashMap <String, Administrador> result = new HashMap <String, Administrador>();
		       
		            result = (HashMap) administradores.clone();
	
		        return result;
		    }
		
			
		
		 
				
				
}

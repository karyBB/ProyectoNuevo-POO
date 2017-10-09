package Clases;
	import java.io.IOException;
	import java.util.*;
	import java.util.Map.Entry;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	import javax.swing.JPasswordField;
	public class ListaAdministradores extends ListaPersonas implements Lista {
	
		private HashMap<String,Administrador> administradores;
		
	//constructor
		public ListaAdministradores(Archivo archivo) {
			
			administradores =new HashMap<String,Administrador>();	
			archivo.cargarArchivoTextoAdministrador(ListaAdministradores.this);
			 
		}
        public ListaAdministradores() {
			
			administradores =new HashMap<String,Administrador>();	
			
			 
		}
		
	//metodos
		
		
		
		public Administrador crear(String nombre,String rut ,String direccion ,String correo,String telefono,String cargo,String clave)
		    {
		    	Administrador administrador=new Administrador(nombre,rut,direccion,correo,telefono,clave ,cargo);
		    	return administrador;
		    	
		    	
		    }
			
		
	//agrega un administrador a la hashmap  
	 public boolean validarClaveAdministrador(String nombre,String clave )
	  {
		 if(administradores.containsKey(clave) )
		 {
			 if(administradores.containsValue((Object)nombre))
				 return true;
		 }
		 return false;
		
	  }
	 public boolean verificarEmail(String email) {
			Pattern pat;
			Matcher mat;
			
			pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@pucv.cl");
			mat = pat.matcher(email);
			
				if(!(mat.find()))
				return false;
			
			return true;
		}
	 
	
	
			
		
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
	 
	 public boolean agregarSinArchivo(Administrador nuevoAdministrador) {
		     if(!existe(nuevoAdministrador))
			 {
		    	 administradores.put(nuevoAdministrador.getClave(), nuevoAdministrador);
		      return true;
			 }
		 return false;
	 }
	 
	 
	
	 
	//modificar los datos del administrador 
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
	    
	    
	    
	//elimina un Administrador de el hashmap    
	   public boolean eliminar(Object administradorEliminado)
	   {
		   if(existe(administradorEliminado))
		   {
			   administradores.remove(((Administrador)administradorEliminado).getClave(), administradorEliminado);
			   return true;
		   }
		   return false;
	   }
	 
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
	
	    
	public Administrador obtener(String rut)
	{															
		for (Entry<String, Administrador> e: administradores.entrySet())
		 {
			 if(!e.getValue().getRut().equals(rut))
				 return e.getValue();
			 
		  }		
		return null;			
	}
	
	
	 //retorna true si el admnistrador se encuentra en la lista de administradores y false si no 
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
		
		
		
		
		public int size()
		{
			return administradores.size();
		}
	
	//busqueda del admin segun el rut y contraseña en el administradores
		public Administrador getAdministrador(String admin, JPasswordField clave)
		{																									    	
			Administrador adminRetornar = buscarClave(clave.getText());
			if(adminRetornar==null)
				return null;
			if(adminRetornar.getNombre().equals(admin))
				return adminRetornar;
			
			return null;
		}

	

		
	
		
	
	 
			
		
	}

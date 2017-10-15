package Clases;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.text.html.HTMLDocument.Iterator;


public class ListaVendedores extends ListaPersonas implements Lista {


	private HashMap<String,Vendedor> vendedores;




	//constructor
	public ListaVendedores(Archivo archivo,ListaProyectos proyectos) {
	    	
		vendedores =new HashMap<String,Vendedor>();
		archivo.cargarArchivoTextoVendedor(ListaVendedores.this,proyectos);
	}
	
	
    
   


	public ListaVendedores() {
		// TODO Auto-generated constructor stub
	}






	/**
       * 
       *Metodo para crear a un vendedor
       */
    public Vendedor crear(String nombre,String rut ,String direccion ,String correo,String telefono,String clave)
    {
    	Vendedor vendedor=new Vendedor(nombre,rut,direccion,telefono,correo ,clave);
    	return vendedor;
    	
    	
    }
	
    
    //metodo para agrgar a un vendedor 
	public boolean  agregar(Object nuevoVendedor) 
	 {
		//se verifica que el vendedor por medio de su identificador (rut )no este en la lista existente de vendedores
		if(busqueda(((Vendedor)nuevoVendedor).getRut())==null)
		{
			vendedores.put(((Vendedor)nuevoVendedor).getClave(),(Vendedor)nuevoVendedor);
			Archivo archivo = new Archivo();
				try {
					archivo.actualizarTxtVendedor((Vendedor)nuevoVendedor);
				} catch (IOException e) {
					e.printStackTrace();
				}	
			return true;
		}
		return false;
			
	 }


	public Object busqueda(String rut)
	{															
		for (Entry<String, Vendedor> e: vendedores.entrySet())
		 {
			 if(e.getValue().getRut().equals(rut))
			 {
				 return e.getValue();
			 }
		   }		
		return null;			
	}
	public Vendedor obtener(String rut)
	{															
		for (Entry<String, Vendedor> e: vendedores.entrySet())
		 {
			 if(!e.getValue().getRut().equals(rut))
				 return e.getValue();
			 
		  }		
		return null;			
	}



	/**
	 * buscar Vendedor 
	 */
	
	public Vendedor buscarNombre(String nombre)
	{
		 for (Entry<String, Vendedor> e: vendedores.entrySet())
		 {
			 if(e.getValue().getNombre().equals(nombre))
			 {
				 return e.getValue();
			 }
		   }		
		return null;
	}
	 

	public Vendedor buscarClave(String clave)
	{
		 for (Entry<String, Vendedor> e: vendedores.entrySet())
		 {
			 if(e.getKey().equals(clave))
			 {
				 return e.getValue();
			 }
		   }		
		return null;
	}
	
	
	
	
	/**
	 * modificar los datos del vendedor
	 */

	public boolean modificarNombre(Object usuario ,String nuevoNombre)
	{
		Archivo archivo=new Archivo();
		if(existe((Vendedor)usuario))
		{
			((Vendedor)usuario).setNombre(nuevoNombre);
			try {
				archivo.actualizarTxtVendedor((Vendedor)usuario);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	
	}

	
	
	


	public boolean modificarDireccion(Object vendedorModificar,String nuevaDireccion)
	{
		Archivo archivo=new Archivo();
	
		if(existe(vendedores.get(((Vendedor)vendedorModificar).getClave())))
		{
			Vendedor vendedor;
			vendedor=vendedores.get(((Vendedor)vendedorModificar).getClave());
			vendedor.setDireccion(nuevaDireccion);
			try {
				archivo.actualizarTxtVendedor((Vendedor)vendedor);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}


	
	
	

	public boolean modificarCorreo(Object vendedorModificar,String nuevoCorreo)
	{
		Archivo archivo=new Archivo();
	
		if(existe(vendedores.get(((Vendedor)vendedorModificar).getClave())))
		{
			Vendedor vendedor;
			vendedor=vendedores.get(((Vendedor)vendedorModificar).getClave());
			vendedor.setCorreo(nuevoCorreo);
			try {
				archivo.actualizarTxtVendedor((Vendedor)vendedor);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	
	


	public boolean modificarTelefono(Object vendedorModificar,String nuevoTelefono)
	{
		Archivo archivo=new Archivo();
	
		if(existe(vendedores.get(((Vendedor)vendedorModificar).getClave())))
		{
			Vendedor vendedor;
			vendedor=vendedores.get(((Vendedor)vendedorModificar).getClave());
			vendedor.setTelefono(nuevoTelefono);
			try {
				archivo.actualizarTxtVendedor((Vendedor)vendedor);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}


	
	

	public boolean modificarClave(Object vendedorModificar,String nuevaClave)
	{
		Archivo archivo=new Archivo();
	
		if(existe(vendedores.get(((Vendedor)vendedorModificar).getClave())))
		{
			Vendedor vendedor;
			vendedor=vendedores.get(((Vendedor)vendedorModificar).getClave());
			vendedor.setClave(nuevaClave);
			try {
				archivo.actualizarTxtVendedor((Vendedor)vendedor);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}


    
	
	//elimina un usuario del hashmap    
	   public boolean eliminar(Object vendedorEliminado)
	   {
		   if(existe(vendedorEliminado))
		   {
			   vendedores.remove(((Vendedor)vendedorEliminado).getClave(),vendedorEliminado);
			   
			   return true;
		   }
		   return false;
	   }
	  

   

	/**
	 * 
	 * @return
	 */
	 public Vendedor getVendedor(String usuario, JPasswordField clave)
		{																									    	
			Vendedor usuarioRetornar = buscarClave(clave.getText());
			if(usuarioRetornar==null)
				return null;
			if(usuarioRetornar.getNombre().equals(usuario))
				return usuarioRetornar;
			
			return null;
		}
	


	 public int size()
		{
			return vendedores.size();
		}
	

	//retorna true si el usuario se encuentra en la lista de usuarios y false si no 
	public boolean existe(Object  vendedor)
	{
		if(vendedores==null)
			return false;
		if(vendedores.containsValue(vendedor))
			
		{
			return true;
		}
		return false;
	}



	//agrega un usuario al hashmap  
	 public boolean validarClaveUsuario(String nombre,String clave )
	  {
		 if(vendedores.containsKey(clave) )
		 {
			 if(vendedores.containsValue((Object)nombre))
				 return true;
		 }
		 return false;
		
	  }

 


	 
	



	



	
	
	
	
	
	




		
	
}

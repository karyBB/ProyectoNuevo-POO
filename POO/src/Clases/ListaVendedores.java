package Clases;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JPasswordField;


public class ListaVendedores extends ListaPersonas implements Lista,Cloneable{


	private HashMap<String,Vendedor> vendedores;




		/*constructores listaVendedores*/
		public ListaVendedores(Archivo archivo,ListaProyectos proyectos) {
		    	
			vendedores =new HashMap<String,Vendedor>();
			archivo.cargarArchivoTextoVendedor(ListaVendedores.this,proyectos);
		}
		
		
		public ListaVendedores() {
			vendedores =new HashMap<String,Vendedor>();	
		}
    
        /*fin de los contructores*/



		/**
		 * el Metodo crear recibe:
		 * @param nombre
		 * @param rut
		 * @param direccion
		 * @param correo
		 * @param telefono
		 * @param clave
		 * y retorna un vendedor creado
		 */
		    public Vendedor crear(String nombre,String rut ,String direccion ,String correo,String telefono,String clave)
		    {
		    	Vendedor vendedor=new Vendedor(nombre,rut,direccion,correo,telefono ,clave);
		    	return vendedor;
		    	
		    	
		    }
			
		    
		    /**
			 * Metodo que agrega a un Vendedor al hashmap
			 * verifica que este no se encuentre y lo agrega 
			 * ademas actualiza los archivos para que se crea inmediatamentes al ser agregado
			 * retorna un true si el vendedor lo hizo y un false si no lo hizo
			 */ 
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
			
			
			
			
			
			/**
			 * Metodo que agrega sin archivo a un Vendedor al hashmap
			 * verifica que este no se encuentre y lo agrega 
			 * es para no sobreescribir el archivo
			 * retorna un true si el vendedor es agregado y un false si no lo logro ingresar
			 */ 
			 public boolean agregarSinArchivo(Vendedor nuevoVendedor) {
				 
			     if(!existe(nuevoVendedor))
				 {
			    	 vendedores.put(nuevoVendedor.getClave(), nuevoVendedor);
			    	 
			      return true;
				 }
			 return false;
		    } 
		 
		
		    
			 
			 
			 
			  /**
				 * busqueda  
				 * recibe el rut del vendedor que se busca
				 * el metodo recorre el hashmap y va comparando los rut
				 * retorna el vendedor que tenga el rut
				 */   
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
			
			
			
			
			
			
		
		
		
			/**
			 * buscarNombre  
			 * recibe el nombre del vendedor que se busca
			 * el metodo recorre el hashmap y va comparando los nombre
			 * retorna el vendedor que tenga el nombre
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
			 
		    
			
			
			
			
			
			/**
			 * buscarClave  
			 * recibe la clave del vendedor que se busca
			 * el metodo recorre el hashmap y va comparando las claves
			 * retorna el vendedor que tenga la clave
			 */   
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
			 * modificarNombre  
			 * recibe un objeto usuario y el nuevo nombre del vendedor 
			 *revisa que el vendedor este y cambia el nombre actualiza el archivo del vendedor 
			 *retorna un boolean si lo logro y un false si no 
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
		
			
			
			
		
			/**
			 * modificarDireccion 
			 * recibe un objeto vvendedor a y la nueva direccion del vendedor 
			 *revisa que el vendedor este y cambia la direccion, actualiza el archivo del vendedor 
			 *retorna un boolean si lo logro y un false si no 
			 */
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
		
		
			
			
			
		   
			
			/**
			 * modificarCorreo 
			 * recibe un objeto vendedor  y el nuevo correo del vendedor 
			 *revisa que el vendedor este y cambia lel correo, actualiza el archivo del vendedor 
			 *retorna un boolean si lo logro y un false si no 
			 */
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
		
			
			
		
			/**
			 * modificarTelefono 
			 * recibe un objeto vendedor y el nuevo telefono del vendedor 
			 *revisa que el vendedor este y cambia el telefono, actualiza el archivo del vendedor 
			 *retorna un boolean si lo logro y un false si no 
			 */
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
		
		
			
			
		    
			
			
			/**
			 * modificarClave
			 * recibe un objeto vendedor  y la nueva clave del vendedor 
			 *revisa que el vendedor este y cambia la clave, actualiza el archivo del vendedor 
			 *retorna un boolean si lo logro y un false si no 
			 */
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
		
		
		    
			/**
			 * Metodo eliminar 
			 * recibe un objeto vendedor a eliminar 
			 * revisa que el vendedor este lo remiueve del hashmap 
			 * retorna un boolean si lo logro y un false si no 
			 */
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
			 * getVendedor
			 * recibe un nombre de usuario y una clave ingresados por login  
			 *revisa que el vendedor este y lo retorna
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
			
		
			 /**
			 * Metodo que retorna el tamaño del hashmap
			 */
			 public int size()
				{
					return vendedores.size();
				}
			
		
			 /**
			 * existe 
			 * recibe un objeto vendedor y verifica que se encuentre en el hashmap 
			 * retorna un true si esta y un false si no lo encuentra 
			 */
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
		
		
			
			
			
			
			
			
			
			
			/**
			 * obtener  
			 * recibe el rut del adminsitrador que se busca
			 * el metodo recorre el hashmap y va comparando los rut
			 * retorna el administrador que tenga el rut
			 */   
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
			 * validarClaveUsuario 
			 * recibe un nombre y una clave 
			 * retorna true si se encuentra el vendedor con ese nombre y esa clave y false si no se encuentra
			 */ 
			 public boolean validarClaveUsuario(String nombre,String clave )
			  {
				 Vendedor vendedor = vendedores.get(clave);
				 if(vendedor.getNombre().equals(nombre))
				 {
						 return true;
				 }
				 return false;
				
			  }
		
			 
			 
			 
			 
			 
			 /**
				 * clonarLista
				 * crea un hashmap y clona el hashmap actual 
				 * este lo retorna 
				 * solo es utilizado para los reportes 
				 */
			 public HashMap<String, Vendedor> clonarLista () {
				 HashMap <String, Vendedor> result = new HashMap <String, Vendedor>();
		       
		            result = (HashMap) vendedores.clone();
		
		        return result;
		    }
		
		
			 
			
		
		
		
			
		
		
		
			
			
			
			
			
			
		
		
		
		
				
			
		}

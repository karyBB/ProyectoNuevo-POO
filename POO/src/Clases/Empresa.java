package Clases;

import javax.swing.JPasswordField;

public class Empresa {
	
 
	private String nombre;
	private Archivo archivo; 
	private ListaVendedores listaVendedores;
	private ListaAdministradores listaAdministradores;
	private ListaProyectos listaProyectos ;
       
	
	
	//Constructor
	public Empresa() 
	{
		
		archivo=new Archivo();
		this.listaVendedores = new ListaVendedores(archivo);
		this.listaAdministradores=new ListaAdministradores(archivo);
		this.listaProyectos =new ListaProyectos(archivo);
	}
	
	
	public Empresa(String nombre, Archivo archivo) {
		this.nombre = nombre;
		this.archivo = archivo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public Vendedor crearVendedor(String nombre,String rut ,String direccion,String correo ,String telefono,String clave)
	 {
		 listaVendedores.crearVendedor(nombre, rut, direccion, correo, telefono, clave);
		 return listaVendedores.crearVendedor(nombre, rut, direccion, correo, telefono, clave);
	 }
	 
	 
     public void  agregarVendedor(Vendedor nuevoVendedor) {
    	 listaVendedores.agregar(nuevoVendedor);
     }
    
     
     
   
     /**
 	 * Metodo para buscar al Vendedor 
 	 * retornar al vendedor encontrado para poder ser modificado  
 	 */
 	public Vendedor buscarNombreVendedor(String nombre)
     {
    	 return listaVendedores.buscarNombre(nombre);
     } 	
 	
 	public Vendedor buscarClaveVendedor(String clave)
 	{
 		return listaVendedores.buscarClave(clave);
 	}
 	
 	public Object buscarRutVendedor(String rut)
 	{
 		return listaVendedores.busqueda(rut);
 	}
 	
    /**
     * Metodos para buscar al vendedor 
     */
     
     public void modificarNombreVendedor(Object vendedor,String nuevoNombre){
    	 listaVendedores.modificarNombre(vendedor, nuevoNombre);
	     }    
     
     public void modificarDireccionVendedor(Object vendedor,String nuevoNombre){
    	 listaVendedores.modificarDireccion(vendedor, nuevoNombre);
	     }
     
     public void modificarTelefonoVendedor(Object vendedor,String nuevaDireccion){
    	 listaVendedores.modificarTelefono(vendedor, nuevaDireccion);
	     }

     public void modificarCorreoVendedor(Object vendedor,String nuevoCorreo){
    	 listaVendedores.modificarCorreo(vendedor, nuevoCorreo);
	     }

     
     public void modificarClaveVendedor(Object vendedor,String nuevaClave){
    	 listaVendedores.modificarClave(vendedor, nuevaClave);
	     }
     
     
     
     
	/**
	 * Metodo para eliminacion de Vendedor 
	 */
    public void eliminaVendedor(Object vendedor)
    {
    	listaVendedores.eliminar(vendedor);
    }
    
    /**
     * motodo para obtener el Vendedor que esta ingresando
     * @return
     */
   public Vendedor  obtenerVendedor(String usuario, JPasswordField clave) {
	   return listaVendedores.getVendedor(usuario, clave);
	   
   }
   public int sizeVendedores() {
    return listaVendedores.size();
   }
     
     
 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   /**
    * 
    * Metodos de las la lista Administradores
    * @return
    */
     

	
	 
	 public Administrador crearAdministrador(String nombre,String rut ,String direccion,String correo ,String telefono,String cargo,String clave)
	 {
		 listaAdministradores.crearAdministrador(nombre, rut, direccion, correo, telefono, cargo,clave);
		 return listaAdministradores.crearAdministrador(nombre, rut, direccion, correo, telefono,cargo, clave);
	 }
	 
	 
    public void  agregarAdministrador(Administrador nuevoAdministrador) {
   	 listaAdministradores.agregar(nuevoAdministrador);
    }
   
    
    
    

	
	
	public Administrador buscarNombreAdministrador(String nombre)
    {
   	 return listaAdministradores.buscarNombre(nombre);
    } 	
	
	public Administrador buscarClaveAdministrador(String clave)
	{
		return listaAdministradores.buscarClave(clave);
	}
	
	public Administrador buscarRutAdministrador(String rut)
	{
		return listaAdministradores.busqueda(rut);
	}
	
		
	
   
	/**
	    * Metodos para buscar al administrador 
	   
	    */
	    public void modificarNombreAdministrador(Object administrador,String nuevoNombre){
	    	listaAdministradores.modificarNombre(administrador, nuevoNombre);
		     }    
	    
	    public void modificarDireccionAdministrador(Object administrador,String nuevoNombre){
	    	listaAdministradores.modificarDireccion(administrador, nuevoNombre);
		     }
	    
	    public void modificarTelefonoAdministrador(Object administrador,String nuevaDireccion){
	    	listaAdministradores.modificarTelefono(administrador, nuevaDireccion);
		     }

	    public void modificarCorreoAdministrador(Object administrador,String nuevoCorreo){
	    	listaAdministradores.modificarCorreo(administrador, nuevoCorreo);
		     }

	    
	    public void modificarClaveAdministrador(Object administrador,String nuevaClave){
	    	listaAdministradores.modificarClave(administrador, nuevaClave);
    
	    }
    
   
	/**
	 * Metodo para eliminacion de Adminstrador 
	 */
	
   public void eliminaAdministrador(Object administrador)
   {
	   listaAdministradores.eliminar(administrador);
   }
   
   /**
    * motodo para obtener el Administrador que esta ingresando
    * @return
    */
  public Administrador  obtenerAdministrador(String administrador, JPasswordField clave) {
	   return listaAdministradores.getAdministrador(administrador, clave);
	   
  }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListaProyectos getListaProyectos() {
		return listaProyectos;
	}
	
	public void setListaProyectos(ListaProyectos listaProyectos) {
		this.listaProyectos = listaProyectos;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Archivo getArchivos() {
		return archivo;
	}

	public void setArchivos(Archivo archivo) {
		this.archivo = archivo;
	}


  	
}

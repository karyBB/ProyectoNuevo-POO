package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;

public class Empresa  implements Cloneable {
	
 
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
		 
		 return listaVendedores.crear(nombre, rut, direccion, correo, telefono, clave);
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
    public Vendedor obtenerVendedor(String rut) {
    	return listaVendedores.obtener(rut);
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
		 return listaAdministradores.crear(nombre, rut, direccion, correo, telefono,cargo, clave);
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
  public Administrador obtenerAdministrador(String rut) {
  	return listaAdministradores.obtener(rut);
  }
   public int sizeAdministrador()
   {
	   return listaAdministradores.size();
   }
	

	/**
	 * metodos para los proyectos 
	 * @return
	 */
	public Proyecto crearProyecto(String id,String nombre,String direccion,String ciudad,String nombreEncargado,int numPisos,int numDepts ) {
		return listaProyectos.crearProyecto(id,nombre,direccion,ciudad,nombreEncargado,numPisos,numDepts);
	}
	
	

	//verifica que tenga la composicion correcta de un correo valido
	public boolean verificarEmail(String email)
	{
		Pattern patron;
		Matcher mat;
		
		patron = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]*(\\.[A-Za-z]{2,})$");
		mat = patron.matcher(email);
		
		if((mat.find()))
		return true;
		
		return false;
	}
		
		
	
	//verifica que el telefono tenga 8 digitos
	public boolean verificarTelefono(String telefono)	
	{
		if(!esNumerico(telefono))
			return false;
		
		int cont = 0;
		int telefonoInt = Integer.parseInt(telefono);
		
		while(telefonoInt>0){
			telefonoInt = telefonoInt/10;
			cont++;
		}
		if(cont>=8)
			return true;
		else
			return false;
	}

		
	

	//verifica que el string se pueda cambiar a numerico
	public boolean esNumerico(String string)
	{
	    boolean numerico = true;
	    try{
	        Integer.parseInt(string);
	    }catch(NumberFormatException e){
	    	numerico = false;
	    }
	    return numerico;
	}
	
	
	public void agregarProyecto(Proyecto proyecto)
	{
		listaProyectos.agregar(proyecto);
	}
	
	
	public void agregarProyectoSinArchivo(Proyecto proyecto)
	{
		listaProyectos.agregarSinArchivo(proyecto);
	}
	
	
	
	public String generarId() {
		return listaProyectos.generarId();
	}
	
	
	
	public Proyecto buscarIdProyecto(String id)
	{
		return listaProyectos.busqueda(id);
	}
	
	
	
	public Proyecto buscarNombreProyecto(String nombre)
	{
		return listaProyectos.buscarNombre(nombre);
	}
	
	
	
	public Proyecto buscarCiudadProyecto(String ciudad)
	{
		return listaProyectos.buscarPorCiudad(ciudad);
	}
	
	
	
	public Proyecto buscarNombreEncargadoProyecto(String nombre)
	{
		return listaProyectos.busquedaPorNombreEncargado(nombre);
	}
	
	
	
	public boolean modificarNombreProyecto(Proyecto proyecto,String nombre) {
		return listaProyectos.modificarNombre(proyecto, nombre);
	}
	
	
	public boolean modificarDireccionProyecto(Proyecto proyecto,String direccion) {
		return listaProyectos.modificarDireccionProy(proyecto, direccion);
	}
	
	
	public boolean modificarCiudadProyecto(Proyecto proyecto,String ciudad) {
		return listaProyectos.modificarCiudad(proyecto, ciudad);
	}
	
	
	public boolean modificarNombreEncProyecto(Proyecto proyecto,String nombre) {
		return listaProyectos.modificarNombreEncargado(proyecto, nombre);
	}
	public boolean eliminarProyecto(Proyecto proyecto)
	{
		return listaProyectos.eliminar(proyecto);
	}
	
	public Proyecto obtenerProyecto(int i)
	{
		return listaProyectos.getPosProyecto(i);
	}
	
	public int sizeProyecto() {
		return listaProyectos.size();
	}
	public ListaProyectos clonarProyectos() throws CloneNotSupportedException {
            return listaProyectos.clone();
            
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

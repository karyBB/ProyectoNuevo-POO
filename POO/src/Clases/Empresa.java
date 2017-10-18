package Clases;
	import java.util.HashMap;
	import javax.swing.JPasswordField;
		
	/**
	 * la clase Empresa contiene a las distintas listas 
	 * en esta clase se llamaran a los metodos de las clases lista(Administradores,Vendedores,Proyectos)
	 * los cuales actuan sobre los objetos (administrador,vendedores,proyecto)
	 */
	
		public class Empresa   {
			
		 
			private String nombre;
			private Archivo archivo; 
			private ListaVendedores listaVendedores;
			private ListaAdministradores listaAdministradores;
			private ListaProyectos listaProyectos ;
		       
				 
		/*Constructores de la clase empresa*/
		public Empresa() 
		{
			
			archivo=new Archivo();
			this.listaProyectos =new ListaProyectos(archivo);
			this.listaAdministradores=new ListaAdministradores(archivo);
			this.listaVendedores = new ListaVendedores(archivo,listaProyectos);
		}
		
		public Empresa(String nombre, Archivo archivo) {
			this.nombre = nombre;
			this.archivo = archivo;
		}
		/*fin de los contructores*/
		
		
		
		
		
		
		
		/**
		 * Metodos de ListaVendedores
		 * 
		 * 
		 * 
		 */
		
		
		
		/**metodo creasVendedor recibe 
		 * 
		 * @param nombre
		 * @param rut
		 * @param direccion
		 * @param correo
		 * @param telefono
		 * @param clave
		 * @return vendedor
		 */
		 public Vendedor crearVendedor(String nombre,String rut ,String direccion,String correo ,String telefono,String clave)
		 {
			 
			 return listaVendedores.crear(nombre, rut, direccion, correo, telefono, clave);
		 }
		 
		 
		 
		 
		 
		 /**metodo agregarVendedor recibe un nuevo vendedor ya creado
		  Llama al metodo agregar de la lista vendedor y no retorna nada */
		 public void  agregarVendedor(Vendedor nuevoVendedor) {
			 listaVendedores.agregar(nuevoVendedor);
			 
		 }
		
		 
		     
		   
		 /*
		 * Metodo para buscar al Vendedor por su nombre
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Vendedor buscarNombreVendedor(String nombre)
		 {
			 return listaVendedores.buscarNombre(nombre);
		 } 	
		
		
		
		
		
		/*
		 * Metodo para buscar al Vendedor por su clave
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Vendedor buscarClaveVendedor(String clave)
		{
			return listaVendedores.buscarClave(clave);
		}
		
		
		
		
		
		/*
		 * Metodo para buscar al Vendedor por su rut
		 * retornar un objeto encontrado para poder ser modificado  
		 */
		public Object buscarRutVendedor(String rut)
		{
			return listaVendedores.busqueda(rut);
		}
		
		
		
		
		
		/*
			 * Metodo para modificar el nombre del vendedor 
			 * no retorna nada
			 */
		 public void modificarNombreVendedor(Object vendedor,String nuevoNombre){
			 listaVendedores.modificarNombre(vendedor, nuevoNombre);
		     }    
		 
		 
		 
		 
		 
		 /*
			 * Metodo para modificar la direccion del vendedor 
			 * no retorna nada
			 */
		 public void modificarDireccionVendedor(Object vendedor,String nuevoNombre){
			 listaVendedores.modificarDireccion(vendedor, nuevoNombre);
		     }
		 
		 
		 
		 
		 /*
			 * Metodo para modificar el telefono del vendedor 
			 * no retorna nada
			 */
		 public void modificarTelefonoVendedor(Object vendedor,String nuevaDireccion){
			 listaVendedores.modificarTelefono(vendedor, nuevaDireccion);
		     }
		
		 
		 
		 
		 /*
			 * Metodo para modificar el correo del vendedor 
			 * no retorna nada
			 */
		 public void modificarCorreoVendedor(Object vendedor,String nuevoCorreo){
			 listaVendedores.modificarCorreo(vendedor, nuevoCorreo);
		     }
		
		 
		 
		 
		 
		 
		 /*
			 * Metodo para modificar la clave del vendedor 
			 * no retorna nada
			 */
		 public void modificarClaveVendedor(Object vendedor,String nuevaClave){
			 listaVendedores.modificarClave(vendedor, nuevaClave);
		     }
		 
		 
		
		 
		 
		 
		/*
		 * Metodo para eliminacion de un Vendedor
		 * recibe un objeto vendedor y lo elimina ,no retorna nada 
		 */
		public void eliminaVendedor(Object vendedor)
		{
			listaVendedores.eliminar(vendedor);
		}

		
		
		
		
		/**
		 * metodo para obtener el Vendedor que esta ingresando
		 * recibe el nombre de usuario y lo ingresado en el j{passowordField
		 * retorna el vendedor encontrado 
		 */
	   public Vendedor  obtenerVendedor(String usuario, JPasswordField clave) {
		   return listaVendedores.getVendedor(usuario, clave);
		   
	   }
	   
	   
	   
	   
	   /**
		 * Metodos para obtener el  vendedor 
		 * recibe un rut y busca al vendedor 
		 * retorna al vendedor 
		 */
	    public Vendedor obtenerVendedor(String rut) {
	    	return listaVendedores.obtener(rut);
	    }
	   public int sizeVendedores() {
	    return listaVendedores.size();
	   }
	     
	   public HashMap<String, Vendedor> clonarVendedores() throws CloneNotSupportedException {
	       return (HashMap<String, Vendedor>) listaVendedores.clonarLista();
	       
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
		   
		public HashMap<String, Administrador> clonarAdministradores() throws CloneNotSupportedException {
		       return (HashMap<String, Administrador>) listaAdministradores.clonarLista();
		       
		}
		
		
			
			
			/**
		 * metodos para los proyectos 
		 * @return
		 */
			public Proyecto crearProyecto(String id,String nombre,String direccion,String ciudad,String nombreEncargado,int numPisos,int numDepts ) {
				return listaProyectos.crearProyecto(id,nombre,direccion,ciudad,nombreEncargado,numPisos,numDepts);
			}
			
		
			public void agregarProyecto(Proyecto proyecto)
			{
				listaProyectos.agregar(proyecto);
			}
			
			
			public void agregarProyectoSinArchivo(Proyecto proyecto)
			{
				listaProyectos.agregarSinArchivo(proyecto);
			}
			
			
			
			public String generarIdProyecto() {
				return listaProyectos.generarIdProyecto();
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
			
			public ListaProyectos clonarProyectos() throws CloneNotSupportedException  {
		        return listaProyectos.clone();
		        
		}
					
					
					
				
		   //getters and setters de la clase empresa 
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

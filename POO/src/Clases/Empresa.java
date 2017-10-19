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
		
		
		
		/**Metodo creasVendedor recibe 
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
		 
		 
		 
		 
		 
		 /**
		  * Metodo agregarVendedor recibe un nuevo vendedor ya creado
		  * llama al metodo agregar de la lista vendedor y no retorna nada */
		 public void  agregarVendedor(Vendedor nuevoVendedor) {
			 listaVendedores.agregar(nuevoVendedor);
			 
		 }
		
		 
		   
		 
		   
		 /**
		 * Metodo para buscar al Vendedor por su nombre
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Vendedor buscarNombreVendedor(String nombre)
		 {
			 return listaVendedores.buscarNombre(nombre);
		 } 	
		
		
		
		
		
		
		/**
		 * Metodo para buscar al Vendedor por su clave
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Vendedor buscarClaveVendedor(String clave)
		{
			return listaVendedores.buscarClave(clave);
		}
		
		
		
		/**
		 * Metodo para buscar al Vendedor por su clave y su rut
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Vendedor buscarVendedor(String nombre,String clave)
		{
			 if(listaVendedores.validarClaveUsuario(nombre,clave))
				 return (Vendedor)listaVendedores.buscarNombre(nombre);
			 return null;
		}
		
		/**
		 * Metodo para buscar al Vendedor por su clave y su rut
		 * retornar al vendedor encontrado para poder ser modificado  
		 */
		public Administrador buscarAdministradores(String nombre,String clave)
		{
			 if(listaAdministradores.validarClaveAdministrador(nombre,clave))
				 return (Administrador)listaAdministradores.buscarNombre(nombre);
			 return null;
		}
		
		
		/**
		 * Metodo para buscar al Vendedor por su rut
		 * retornar un objeto encontrado para poder ser modificado  
		 */
		public Object buscarRutVendedor(String rut)
		{
			return listaVendedores.busqueda(rut);
		}
		
		
		
		
		
		
		/**
			 * Metodo para modificar el nombre del vendedor 
			 * no retorna nada
			 */
		 public void modificarNombreVendedor(Object vendedor,String nuevoNombre){
			 listaVendedores.modificarNombre(vendedor, nuevoNombre);
		     }    
		 
		 
		 
		 
		 
		 
		 /**
			 * Metodo para modificar la direccion del vendedor 
			 * no retorna nada
			 */
		 public void modificarDireccionVendedor(Object vendedor,String nuevoNombre){
			 listaVendedores.modificarDireccion(vendedor, nuevoNombre);
		     }
		 
		 
		 
		 
		 
		 /**
			 * Metodo para modificar el telefono del vendedor 
			 * no retorna nada
			 */
		 public void modificarTelefonoVendedor(Object vendedor,String nuevaDireccion){
			 listaVendedores.modificarTelefono(vendedor, nuevaDireccion);
		     }
		
		 
		 
		 
		 
		 /**
			 * Metodo para modificar el correo del vendedor 
			 * no retorna nada
			 */
		 public void modificarCorreoVendedor(Object vendedor,String nuevoCorreo){
			 listaVendedores.modificarCorreo(vendedor, nuevoCorreo);
		     }
		
		 
		 
		 
		 
		 
		 /**
			 * Metodo para modificar la clave del vendedor 
			 * no retorna nada
			 */
		 public void modificarClaveVendedor(Object vendedor,String nuevaClave){
			 listaVendedores.modificarClave(vendedor, nuevaClave);
		     }
		 
		 
		
		 
		 
		 
		/**
		 * Metodo para eliminacion de un Vendedor
		 * recibe un objeto vendedor y lo elimina ,no retorna nada 
		 */
		public void eliminaVendedor(Object vendedor)
		{
			listaVendedores.eliminar(vendedor);
		}

		
		
		
		
		
		/**
		 * Metodo para obtener el Vendedor que esta ingresando
		 * recibe el nombre de usuario y lo ingresado en el j{passowordField
		 * retorna el vendedor encontrado 
		 */
	   public Vendedor  obtenerVendedor(String usuario, JPasswordField clave) {
		   return listaVendedores.getVendedor(usuario, clave);
		   
	   }
	   
	   
	   
	   
	   
	   /**
		 * Metodo para obtener el  vendedor 
		 * recibe un rut y busca al vendedor 
		 * retorna al vendedor 
		 */
	    public Vendedor obtenerVendedor(String rut) {
	    	return listaVendedores.obtener(rut);
	    }
	    
	    
	    
	    
	    
	    /**
		 * Metodo para obtener el  tamaño del HashMap listaVendedores 
		 *
		 */
	   public int sizeVendedores() {
	    return listaVendedores.size();
	   }
	   
	   
	   
	   

	    /**
		 * Metodo para obtener la listaVendedores clonada 
		 * es utilizada para entregar un informe de los vendedores 
		 */
	   public HashMap<String, Vendedor> clonarVendedores() throws CloneNotSupportedException {
	       return (HashMap<String, Vendedor>) listaVendedores.clonarLista();
	       
		}
		     
		 
		   
		
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
		   

		   
		/**
		* 
		* Metodos de las la lista Administradores
		* 
		* 
		* 
		*/
		     
		
			
	   /**
	    * Metodo crear Administrador recibe
	    * @param nombre
	    * @param rut
	    * @param direccion
	    * @param correo
	    * @param telefono
	    * @param cargo
	    * @param clave
	    * @return un administrador
	    */
		 
		 public Administrador crearAdministrador(String nombre,String rut ,String direccion,String correo ,String telefono,String cargo,String clave)
		 {
			 return listaAdministradores.crear(nombre, rut, direccion, correo, telefono,cargo, clave);
		 }
		 
		 
		 
		 
		 
		 
		 /**
			* Metodo que agrega un nuevoAdministrador a la  lista Administradores
			* no retorna nada
			*/ 
	    public void  agregarAdministrador(Administrador nuevoAdministrador) {
	   	 listaAdministradores.agregar(nuevoAdministrador);
	   	 
	    }
	  
		
	    
	    
	    
	    /**
		* Metodo buscarNombreAdministrador 
		* recibe un nombre 
		* y retorna el administrador encontrado
		*/
		public Administrador buscarNombreAdministrador(String nombre)
	    {
	   	 return listaAdministradores.buscarNombre(nombre);
	    } 	
		
		
		
		
		
		 /**
		* Metodo buscarClaveAdministrador 
		* recibe una clave  
		* y retorna el administrador encontrado
		*/
		public Administrador buscarClaveAdministrador(String clave)
		{
			return listaAdministradores.buscarClave(clave);
		}
		
		
		
		
		
		 /**
		* Metodo buscarRutAdministrador 
		* recibe un rut 
		* y retorna el administrador encontrado
		*/
		public Administrador buscarRutAdministrador(String rut)
		{
			return listaAdministradores.busqueda(rut);
		}
		
			
	
		
		
		
		   
		 /**
		* Metodo modificarNombreAdministrador 
		* recibe un objeto y un nuevo nombre y lo modifica
		* no retorna nada
		*/
		public void modificarNombreAdministrador(Object administrador,String nuevoNombre){
			listaAdministradores.modificarNombre(administrador, nuevoNombre);
		     }    
		
		
		
		
		
		 /**
		* Metodo modificarDireccionAdministrador 
		* recibe un objeto y una nueva direccion y lo modifica
		* no retorna nada
		*/
		public void modificarDireccionAdministrador(Object administrador,String nuevoNombre){
			listaAdministradores.modificarDireccion(administrador, nuevoNombre);
		     }
		
		
		
		
		
		 /**
		* Metodo modificarTelefonoNombreAdministrador 
		* recibe un objeto y un nuevo telefono y lo modifica
		* no retorna nada
		*/
		public void modificarTelefonoAdministrador(Object administrador,String nuevaDireccion){
			listaAdministradores.modificarTelefono(administrador, nuevaDireccion);
		     }
		
		
		
		
		 /**
		* Metodo modificarCorreoAdministrador 
		* recibe un objeto y u nuevo correo y lo modifica
		* no retorna nada
		*/
		public void modificarCorreoAdministrador(Object administrador,String nuevoCorreo){
			listaAdministradores.modificarCorreo(administrador, nuevoCorreo);
		     }
		
		
		
		
		
		
		 /**
		* Metodo modificarClaveAdministrador 
		* recibe un objeto y una nuevo clave y lo modifica
		* no retorna nada
		*/
		public void modificarClaveAdministrador(Object administrador,String nuevaClave){
			listaAdministradores.modificarClave(administrador, nuevaClave);
		
		}
		
		   
		
		
		
		
		 /**
		 * Metodo para eliminacion de Adminstrador 
		 * recibe el objeto a eliminar 
		 * no retorna nada
		 */
			
		 public void eliminaAdministrador(Object administrador)
		   {
			   listaAdministradores.eliminar(administrador);
         }
		   
		   
		   
		   
		   
		   
		 /**
		* Metodo para obtener el Administrador que esta ingresando
		* recibe el nombre del usuario que esta ingresando y la clave que ingreso
		* retorna el administracion con ese nombre y con esa clave
		* 
		*/
		  public Administrador  obtenerAdministrador(String usuario, JPasswordField clave) {
			   return listaAdministradores.getAdministrador(usuario, clave);
			   
		  }
		  
		  
		  
		  
		  
		  /**
			* Metodo obtenerAdministrador 
			* recibe un rut 
			* y retorna el administrador con este rut
			*/
		  public Administrador obtenerAdministrador(String rut) {
		  	return listaAdministradores.obtener(rut);
		  }
		  
		  
		  
		  
		  
		  /**
			* Metodo que retorna el tamaño del HashMap listaAdministradores  
			*/
		   public int sizeAdministrador()
		   {
			   return listaAdministradores.size();
		   }
		   
		   
		   
		   
		   
		   /**
			 * Metodos para obtener la listaAdministradores clonada 
			 * es utilizada para entregar un informe de los administradores 
			 */
			public HashMap<String, Administrador> clonarAdministradores() throws CloneNotSupportedException {
			       return (HashMap<String, Administrador>) listaAdministradores.clonarLista();
			       
			}
		
		
			
			
			
			
			
			
			
			
			
			
			
			/**
			 * 
			 * Metodos para la listaProyectos
			 *  
			 */
			
			
			
			
			
		   /**
		    * el Metodo crearProyecto recibe:
		    * @param id
		    * @param nombre
		    * @param direccion
		    * @param ciudad
		    * @param nombreEncargado
		    * @param numPisos
		    * @param numDepts
		    *  y retorna el proyecto creado
		    */
			public Proyecto crearProyecto(String id,String nombre,String direccion,String ciudad,String nombreEncargado,int numPisos,int numDepts ) {
				return listaProyectos.crearProyecto(id,nombre,direccion,ciudad,nombreEncargado,numPisos,numDepts);
			}
			
			
			
			
			
		    
			/**
			 * Metodo agregarProyecto
			 * recibe un proyecto 
			 * y no retorna nada 
			 */
			public void agregarProyecto(Proyecto proyecto)
			{
				listaProyectos.agregar(proyecto);
			}
			
			
			
			
			
			
			/**
			 * Metodo agregar los proyectos si Archivo
			 * recibe el proyecto y no retorna nada 
			 */
			
			public void agregarProyectoSinArchivo(Proyecto proyecto)
			{
				listaProyectos.agregarSinArchivo(proyecto);
			}
			
			
			
			
			
			
			
			/**
			 * Metodo generarIdProyecto  
			 * no recibe nada solo es la llamada al metodo generarId proyecto que se encuentra en 
			 * listaProyectos
			 */
			
			public String generarIdProyecto() {
				return listaProyectos.generarIdProyecto();
			}
			
			
			
			
			
			
			
			/**
			 * Metodo buscarIdProyecto 
			 *recibe un id y retorna el proyecto que lo tiene 
			 */
			public Proyecto buscarIdProyecto(String id)
			{
				return listaProyectos.busqueda(id);
			}
			
			
			
			
			
			
			/**
			 * Metodo buscarNombreProyecto 
			 *recibe un nombre y retorna el proyecto que lo tiene 
			 */
			public Proyecto buscarNombreProyecto(String nombre)
			{
				return listaProyectos.buscarNombre(nombre);
			}
			
			
			
			
			
			
			/**
			 * Metodo buscarCiudadProyecto 
			 *recibe una ciudad y retorna el proyecto que lo tiene 
			 */
			public Proyecto buscarCiudadProyecto(String ciudad)
			{
				return listaProyectos.buscarPorCiudad(ciudad);
			}
			
			
			
			
			
			
			/**
			 * Metodo buscarNombreEncargadoProyecto 
			 *recibe un nombre de encargado y retorna el proyecto que lo tiene 
			 */
			public Proyecto buscarNombreEncargadoProyecto(String nombre)
			{
				return listaProyectos.busquedaPorNombreEncargado(nombre);
			}
			
			
			
			
			
			
			/**
			 * Metodo modificarNombreProyecto 
			 *recibe un nuevo nombre y retorna un boolean dependiendo si lo hizo o no 
			 */
			public boolean modificarNombreProyecto(Proyecto proyecto,String nombre) {
				return listaProyectos.modificarNombre(proyecto, nombre);
			}
			
			
			
			
			
			/**
			 * Metodo modificarDireccionProyecto 
			 *recibe una nueva direccion y retorna un boolean dependiendo si lo hizo o no 
			 */
			public boolean modificarDireccionProyecto(Proyecto proyecto,String direccion) {
				return listaProyectos.modificarDireccionProy(proyecto, direccion);
			}
			
			
			
			
			/**
			 * Metodo modificarCuidadProyecto 
			 *recibe una nueva ciudad y retorna un boolean dependiendo si lo hizo o no 
			 */
			public boolean modificarCiudadProyecto(Proyecto proyecto,String ciudad) {
				return listaProyectos.modificarCiudad(proyecto, ciudad);
			}
			
			
			
			
			
			
			/**
			 * Metodo modificarNombreEncProyecto 
			 *recibe un nuevo nombre de encargado y retorna un boolean dependiendo si lo hizo o no 
			 */
			public boolean modificarNombreEncProyecto(Proyecto proyecto,String nombre) {
				return listaProyectos.modificarNombreEncargado(proyecto, nombre);
			}
			
			
		    
			
			
			
			/**
			 * Metodo eliminarProyecto 
			 *recibe un proyecto y retorna un boolean dependiendo si lo elimino o no 
			 */
			public boolean eliminarProyecto(Proyecto proyecto)
			{
				return listaProyectos.eliminar(proyecto);
			}
			
			
			
			
			
			/**
			 *Metodo obtenerProyecto 
			 *recibe indice y retorna el proyecto que esta en esa posicion  
			 */
			public Proyecto obtenerProyecto(int i)
			{
				return listaProyectos.getPosProyecto(i);
			}
			
			
			
			
			
			/**
			 * Metodo que retorna el tamaño de la listaProyectos
			 */
			public int sizeProyecto() {
				return listaProyectos.size();
			}
			
			
			
			
			
			/**
			 * Metodo que retorna la lista ListaProyectos clonada 
			 */
			public ListaProyectos clonarProyectos() throws CloneNotSupportedException  {
		        return listaProyectos.clone();
		        
		    }
					
					
					
			
			
			
			
			
			
			
			
				
			/*getters y setters de la clase Empresa*/
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
			/*fin de los getters y setters de la classe Empresa*/
			
			
}

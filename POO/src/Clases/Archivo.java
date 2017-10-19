package Clases;
import java.io.*;
import java.util.StringTokenizer;

			public class Archivo {
				//constructor 
			public Archivo() {	
			}
			
			
			
			
			//carga  los proyecto de los txt al programa 
			public void cargarArchivoTextoProyecto(ListaProyectos arrayProyectos)
			{
				File raiz = new File("Empresa\\Proyectos");
				if(raiz.exists() && raiz.list()!=null)
				{
					String [] carpeta = raiz.list();
					for(int i=0;i<carpeta.length;i++)
					{
						try(FileReader archivoLectura = new FileReader("Empresa\\Proyectos\\"+carpeta[i]
																	+"\\DatosProyecto"+carpeta[i]+".txt")){
							BufferedReader buffer = new BufferedReader(archivoLectura);
							if(buffer.ready()){
								String cadena = buffer.readLine();
						    	if(cadena != null){
						    		StringTokenizer st = new StringTokenizer(cadena,"|");
						    		String id = st.nextToken();
							    	String nombre = st.nextToken();
							    	String direccion = st.nextToken();
							    	String ciudadUbicacion = st.nextToken();
							    	String nombreEncargado = st.nextToken();
							    	int totalPisos = Integer.parseInt(st.nextToken());
							        int totalDept  = Integer.parseInt(st.nextToken());
			
							    	//se agrega al ArrayList de Proyectos
							    	arrayProyectos.agregarSinArchivo(new Proyecto(id,nombre,direccion,ciudadUbicacion,
							    			nombreEncargado,totalPisos,totalDept));
							    		
						    	}
						    buffer.close();
						   	archivoLectura.close();
							}
						}catch(IOException x){
							System.out.println("Error E/S: "+x);
						}
					}
				}
				
			}
			
			
			
			
			
			
			
			
			public void cargarArchivoTextoAdministrador(ListaAdministradores administradores)
			{
			
				File raiz = new File("Empresa\\Administradores");
				if(raiz.exists() && raiz.list()!=null)
				{
					String [] carpeta = raiz.list();
					for(int i=0;i<carpeta.length;i++)
					{
						try(FileReader archivoLectura = new FileReader("Empresa\\Administradores\\"+carpeta[i])){
							BufferedReader buffer = new BufferedReader(archivoLectura);
							if(buffer.ready()){
								String cadena = buffer.readLine();
						    	if(cadena != null){
						    		StringTokenizer st = new StringTokenizer(cadena,"|");
						    		String nombre = st.nextToken();
							    	String rut = st.nextToken();
							    	String direccion = st.nextToken();
							    	String correo = st.nextToken();
							    	String telefono = st.nextToken();
							    	String clave= st.nextToken();
							    	String cargo= st.nextToken();
							    	
			
							    	//se agrega los administradores
							    	administradores.agregarSinArchivo(new Administrador(nombre,rut,direccion,correo,telefono,clave,cargo));
							    	
							    	
						    	}
						    buffer.close();
						   	archivoLectura.close();
							}
						}catch(IOException x){
							System.out.println("Error E/S: "+x);
						}
					}
				}
			}
				
			
			
			
			
			
			
			
			
			public void  cargarArchivoTextoVendedor(ListaVendedores vendedores, ListaProyectos proyectos)
			{
				
				File raiz = new File("Empresa\\Usuarios");
				if(raiz.exists() && raiz.list()!=null)
				{
					String [] carpeta = raiz.list();
				    
					for(int i=0;i<carpeta.length;i++)
					{
						try(FileReader archivoLectura = new FileReader("Empresa\\Usuarios\\"+carpeta[i]
																+"\\DatosUsuario"+carpeta[i]+".txt")){
							BufferedReader buffer = new BufferedReader(archivoLectura);
							if(buffer.ready()){
								String cadena = buffer.readLine();
						    	if(cadena != null){
						    		StringTokenizer st = new StringTokenizer(cadena,"|");
						    		String nombre = st.nextToken();
							    	String rut = st.nextToken();
							    	String direccion = st.nextToken();
							    	String correo = st.nextToken();
							    	String telefono = st.nextToken();
							    	String clave = st.nextToken();
							    	
							    	//se crea el vendedor nuevo    	
							    	Vendedor vendedorNuevo = new Vendedor(nombre,rut,direccion,correo,telefono,clave);
							    	
							    	
							    	//se agrega los departamentos al vendedor
							    	leerListaDpt(buffer,vendedorNuevo,proyectos);
							    	
							    	//se agrega a la lista de vendedores
							    	vendedores.agregarSinArchivo(vendedorNuevo);
							    	
						    	}
						    buffer.close();
						   	archivoLectura.close();
							}
						}catch(IOException x){
							System.out.println("Error E/S: "+x);
						}
					}
				}
			}
			
			
				
			
			
			
			
			
			public void cargarDatosDepartamentos(ListaDepartamentos departamentos, String idProyecto)
			{	
				File raiz = new File("Empresa\\Proyectos\\"+idProyecto+"\\Departamentos");
				if(raiz.exists() && raiz.list() != null)
				{
					String [] archivosDept = raiz.list();
			
					for(int i=0;i<archivosDept.length;i++)
					{
			
						try(FileReader archivoLectura = new FileReader(
										"Empresa\\Proyectos\\"+idProyecto+"\\Departamentos\\"
												+archivosDept[i]+"\\DatosDepartamentos"
												+archivosDept[i]+".txt"))
						{
							BufferedReader buffer = new BufferedReader(archivoLectura);
						
							if(buffer.ready()){
								
								String cadena = buffer.readLine();
								StringTokenizer st = new StringTokenizer(cadena,"|");
								
								String numero = st.nextToken();
								String tamaño = st.nextToken();
								int numHabitaciones = Integer.parseInt(st.nextToken());
								
								String estadoStr=st.nextToken();
								boolean estado = false;
								if(estadoStr.equals("true"))
									estado= true;
						
								int precio = Integer.parseInt(st.nextToken());
								String descripcion = st.nextToken();
								
						    	
						    	//se agrega al arrayList de departamentos
								departamentos.agregarSinArchivo(new Departamento(numero,tamaño,numHabitaciones,estado,precio,descripcion));
						    }
							buffer.close();
					    	archivoLectura.close();
						}catch(IOException x){
							System.out.println("Error E/S: "+x);
						}
						
					}
				}
				
			}
			
			
			
			
			
			
			//modifica o crea el archivo del proyectos recibido
			public void actualizarTxtProyectos(Proyecto proyecto) throws IOException 
			{							
				File archivoProyectos;
				FileWriter fEscrit;
				BufferedWriter bEscrit;
				PrintWriter pEscrit;
				
				archivoProyectos = new File("Empresa\\Proyectos\\"+proyecto.getId()+"\\DatosProyecto"+proyecto.getId()+".txt");
				
				if(!archivoProyectos.exists()){
					crearCarpetaProyecto(proyecto);
				}
			
				fEscrit = new FileWriter(archivoProyectos);
				bEscrit = new BufferedWriter(fEscrit);
				pEscrit = new PrintWriter(bEscrit);
			
				pEscrit.println(proyecto.getId()+"|"+proyecto.getNombre()+"|"
											+proyecto.getDireccion()+"|"+proyecto.getCiudadUbicacion()
											+"|"+proyecto.getNombreEncargado()+"|"+proyecto.getTotalPisos()
											+"|"+proyecto.getTotaldepartamentos());
			
				System.out.println("\nDatos actualizados en el txt  correctamente");
				
				pEscrit.close();
				bEscrit.close();
			}
			
			
			
			
			
			//modifica o crea el archivo del usuario recibido
			public void actualizarTxtVendedor(Vendedor usuario) throws IOException 
			{							
				File archivoUsuarios;
				FileWriter fEscrit;
				BufferedWriter bEscrit;
				PrintWriter pEscrit;
				
				archivoUsuarios = new File("Empresa\\Usuarios\\"
											+usuario.getRut()+"\\DatosUsuario"+usuario.getRut()+".txt");
				
				if(!archivoUsuarios.exists()){
					crearCarpetaUsuario(usuario);
				}
			
				fEscrit = new FileWriter(archivoUsuarios);
				bEscrit = new BufferedWriter(fEscrit);
				pEscrit = new PrintWriter(bEscrit);
				
				
				pEscrit.println(usuario.getNombre()+"|"+usuario.getRut()+"|"
											+usuario.getDireccion()+"|"+usuario.getTelefono()+"|"+usuario.getCorreo()
											+"|"+usuario.getClave()+"|");
				
			  	escribirListaDpt(usuario, pEscrit);
			    
				
				
				pEscrit.close();
				bEscrit.close();
			}
			
			
			
			
			
			
			//modifica o crea el archivo del administrador recibido
			public void actualizarTxtAdministrador(Administrador admin) throws IOException 
			{							
				File archivoUsuarios;
				FileWriter fEscrit;
				BufferedWriter bEscrit;
				PrintWriter pEscrit;
				
				archivoUsuarios = new File("Empresa\\Administradores\\DatosAdministrador"+admin.getRut()+".txt");
				
				
			
				fEscrit = new FileWriter(archivoUsuarios);
				bEscrit = new BufferedWriter(fEscrit);
				pEscrit = new PrintWriter(bEscrit);
				
				
				pEscrit.println(admin.getNombre()+"|"+admin.getRut()+"|"
											+admin.getDireccion()+"|"+admin.getCorreo()+"|"+admin.getTelefono()
											+"|"+admin.getClave()+"|"+admin.getCargo());
			
				System.out.println("\nDatos actualizados en el txt del administrador correctamente");
				
				pEscrit.close();
				bEscrit.close();
			}
			
			
			
			
			
			
			
			//modifica o crea el archivo del departamento recibido
			public void actualizarTxtDepartamentos(Departamento dept,String idProyecto) throws IOException 
			{							
				File archivoDepatamentos;
				FileWriter fEscrit;
				BufferedWriter bEscrit;
				PrintWriter pEscrit;
				
				archivoDepatamentos = new File("Empresa\\Proyectos\\"+idProyecto+"\\Departamentos\\"+dept.getNumero()+"\\DatosDepartamentos"+dept.getNumero()+".txt");
				
				if(!archivoDepatamentos.exists()){
					crearCarpetaDepartamento(dept,idProyecto);
				}
			
				fEscrit = new FileWriter(archivoDepatamentos);
				bEscrit = new BufferedWriter(fEscrit);
				pEscrit = new PrintWriter(bEscrit);
			
				pEscrit.println(dept.getNumero()+"|"+dept.getTamaño()+"|"
								+dept.getNumeroHabitaciones()+"|"+dept.isEstado()+"|"
								+dept.getPrecio()+"|"+dept.getDescripcion());
			
				System.out.println("\nDatos  dept actualizados en el txt  correctamente");
				
				pEscrit.close();
				bEscrit.close();
			}
			
			
			
			
			
			
			
			//se crear la carpeta y el archivo del proyecto
			public void crearCarpetaProyecto(Proyecto proyecto)
			{							
				File carpeta = new File("Empresa\\proyectos\\"+proyecto.getId());
				File archivo = new File(carpeta,"DatosProyecto"+proyecto.getId()+".txt");
				
				if(!carpeta.exists()){
					carpeta.mkdirs();
				}
				if(!archivo.exists()){
					try{
						archivo.createNewFile();
					}catch(IOException ex){ex.printStackTrace();}
				}
					
			}
			
			
			
			
			
			
			//se crear la carpeta y el archivo del departamento 
			public void crearCarpetaDepartamento(Departamento dept,String idProyecto)
			{							
				File carpeta = new File("Empresa\\Proyectos\\"+idProyecto+"\\Departamentos\\"+dept.getNumero());
			
				
				if(!carpeta.exists()){
					carpeta.mkdirs();
				}
			
					
			}
			
			
			
			
			
			
			
			//se crear la carpeta y el archivo del usuario 
			public void crearCarpetaUsuario(Vendedor usuario) 
			{
				File carpeta = new File("Empresa\\Usuarios\\"+usuario.getRut());
				File archivo = new File(carpeta,"DatosUsuario"+usuario.getRut()+".txt");
				
				if(!carpeta.exists()){
					carpeta.mkdirs();
				}
				if(!archivo.exists()){
					try{
						archivo.createNewFile();
					}catch(IOException ex){ex.printStackTrace();}
				}
				
			}
			
			
			
			
			
			
			
			//se elimina el proyecto de los archivos
			public boolean eliminarTxtProyecto(Proyecto proyecto)
			{    	
				  	
					File txt = new File("Empresa\\Proyectos\\"+proyecto.getId()+"\\DatosProyecto"+proyecto.getId()+".txt");
					if(txt.exists())
					{
						txt.delete();
						return true;
					}
					return false;		
				}	
			
			
			
			
			
			
			
			//se elimina el departamento de los archivos
			public boolean eliminarTxtDepartamento(Departamento departamento,String idProyecto)
			{    	
				File txt = new File("Empresa\\Proyectos\\"+idProyecto+"\\"+departamento.getNumero()+".txt");
				if(txt.exists()){							
					txt.delete();
					return true;
				}
				return false;	
			}
			
			
			
			
			
			
			
			//se elimina el usuario de los archivos
			public boolean eliminarTxtUsuario(Vendedor usuario)
			{    	
				File txt = new File("Empresa\\Usuarios\\"+usuario.getRut()+"\\DatosUsuario"+usuario.getRut()+".txt");
				if(txt.exists())
				{
					txt.delete();
					return true;
				}
				return false;		
			}
			
			
			
			
			
			
			
			//se elimina el administrador de los archivos
			public boolean eliminarTxtAdministrador(Administrador admin)
			{    
				File txt = new File("Empresa\\Administradores\\DatosAdministrador"+admin.getRut()+".txt");
				if(txt.exists())
				{
					txt.delete();
					return true;
				}
				return false;	
			}
			
			
			
			
			
			
			
			
			//se elimina la carpeta del proyecto
			public boolean eliminarCarpetaProyecto(Proyecto proyecto){
				File carpeta = new File("Empresa\\Proyectos\\"+proyecto.getId());
				if(carpeta.exists()){							
					File[] archivos = carpeta.listFiles();
					if(eliminarArchivos(archivos))
						carpeta.delete();
						return true;
				}
				return false;
			}
			
			
			
			
			
			
			
			
			//elimina la carpeta del usuario
			public boolean eliminarCarpetaUsuario(Vendedor usuario){
				File carpeta = new File("Empresa\\Usuarios\\"+usuario.getRut());
				if(carpeta.exists()){							
					File[] archivos = carpeta.listFiles();
					if(eliminarArchivos(archivos))
						if(carpeta.delete())	
							return true;
				}
				return false;
			}
			
			
			
			
			
			
			//elimina los archivos recibidos
			public boolean eliminarArchivos(File []archivos)
			{
				int cont=0;					
				
				for(int i=0;i<archivos.length;i++){
					if(archivos[i].isFile()){
						if(archivos[i].delete())
							cont++;
					}else{
						if(archivos[i].listFiles()!=null)
							if(!eliminarArchivos(archivos[i].listFiles()))
								return false;	
						archivos[i].delete();
						cont++;
					}
				}
				
				if(archivos.length==cont)
					return true;
				
				return false;
			}
			
			
			
			
			
			

			//escribe una lista de string en un archivo para este caso los id departamentos en los usuarios
			public void escribirListaDpt(Vendedor vendedor,PrintWriter pEscrit)
			{	
				int largo = vendedor.largoDept();
				
				pEscrit.println(largo);
				if(vendedor!=null)
				{
				
					for(int i=0;i<largo;i++)
					{
						//despues ingresa cada elemento del a lista
						pEscrit.println(vendedor.getPosDept(i));
					}
				
				}
			
			}
			
			
			
			
			
			
			//lee una lista de string en un archivo para este caso los id departamentos en los usuarios
			public void leerListaDpt(BufferedReader buffer, Vendedor vendedorNuevo,ListaProyectos proyectos) throws NumberFormatException, IOException
			{													
				//primero lee la cantidad de elementos de la lista
				int cantidad = Integer.parseInt(buffer.readLine());
				
				String departamentoStr;
				
					for(int i=0;i<cantidad;i++){
						departamentoStr = buffer.readLine();
					    Departamento deptNuevo = proyectos.busquedaDept(departamentoStr);
					    
						if(deptNuevo!=null)
							vendedorNuevo.agregarDept(deptNuevo);
					}
				
			}
			
			
}
			

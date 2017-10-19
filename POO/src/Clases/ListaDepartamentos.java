package Clases;
import java.io.IOException;
import java.util.ArrayList;

public class ListaDepartamentos {
		
			private ArrayList<Departamento> departamentos;
		  
			
			
			
			
			/*construtores de Lista Departamentos*/
			public ListaDepartamentos(Archivo archivo,String idProyecto) 
			{
				departamentos=new ArrayList<Departamento>();
				archivo.cargarDatosDepartamentos(ListaDepartamentos.this, idProyecto);
				
			}
		
			public ListaDepartamentos() {
				departamentos=new ArrayList<Departamento>();
			}
			
			
			/*fin de constructores*/
		
		
		
		
		     
	
	
	
	
			/**
			 * Metodo getPosDepartamento
			 * este metodo retorna el dapartamento que se encuentre en la posicion i ingresada
			 */	
			public Departamento getPosDept(int i)
			{
				if(i<departamentos.size())
					return departamentos.get(i);
				return null;
			}
			
			
			
			
			
			
			/**
			 * Metodo que retorna el tamaño de la lista de departamentos
			 */	
			public int largo()
			{
				return departamentos.size();
			}
		
			
			
			
			
			
			
			
			
			/**
			 * Metodo agregar sin archivo,
			 * revisa si el no existe en la lista 
			 * retorna un true si lo logra y un false si no 
			 */	
			public boolean agregarSinArchivo(Departamento nuevoDepartamento)
		    {
		    	 if(!existe(nuevoDepartamento.getNumero()))
				 {
			    	 departamentos.add(nuevoDepartamento);
			    	 return true;
				 }
			 return false;
		    }
			
			
			
			
			
			
			
			
			
			
			
			
			
			/**
			 * Metodo agregar sin archivo,
			 * el departamento contiene el id del proyecto y el numero 
			 * revisa si el no existe en la lista 
			 * retorna un true si lo logra y un false si no 
			 */	
			public void agregarSinArchivo2(Departamento deptnuevo) {
				 String strDatos=deptnuevo.getNumero();
				  char[] ca = strDatos.toCharArray();
				  String id = null ;
				   String num = null;
				  for(int i=0; i<strDatos.length();i++)
				  { 	
				if(Character.isLetter(ca[i]))       //Si es letra
				        id=(""+ca[i]); 
				else    
					if(Character.isDigit(ca[i])||ca[i]==0)//Si no es letra
					        num=(""+ca[i]);   
					   } 
				  Departamento dept= new Departamento(num,deptnuevo.getTamaño(), deptnuevo.getNumeroHabitaciones(), false,deptnuevo.getPrecio(),deptnuevo.getDescripcion());
				  
				  agregarSinArchivo(dept);
				  }
			
			
			
			
			
			
			
			
			
			/**
			 * Metodo agregar ,agrega un objeto departamento nuevo al ArrayList 
			 * este metodo revisa  si el departamento se encuentra antes de agregarlo
			 * actualiza el archivo del departamento
			 * retorna un true si lo logra y un false si no 
			 */	
		    public boolean agregar (Object deptnuevo,String idProyecto)
			{
		    	if(!existe(((Departamento)deptnuevo).getNumero()))
				{
					departamentos.add((Departamento)deptnuevo);
					Archivo archivo = new Archivo();
					
						try {
							archivo.actualizarTxtDepartamentos((Departamento)deptnuevo,idProyecto);
						} catch (IOException e) {
						
							e.printStackTrace();
						}
					
					return true;
				}
				
				return false;
					
			}
		    
		    
		    
		    
		    
		    
		    
		    

			/**
			 * Metodo agregar ,agrega un objeto departamento nuevo al ArrayList 
			 * este metodo revisa  si el departamento se encuentra antes de agregarlo
			 * tiene el id del proyecto y el numero del departamento
			 * actualiza el archivo del departamento
			 * retorna un true si lo logra y un false si no 
			 */
		    public void agregar(Departamento deptnuevo) {
				String strDatos=deptnuevo.getNumero();
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
				  agregarSinArchivo(deptnuevo);
				  }
		    
		    
		    
		    
		    
		    
		    
		   
		    /**
			 * Metodo existe 
			 * retorna true si este se encuentra en el ArrayList y false si no  
			 */	 
			public boolean existe(String numero)
			{
				int i;
				int cantidadDepartamentos;
				
				if(departamentos!=null)
				{
					cantidadDepartamentos=departamentos.size();
					for(i=0;i<cantidadDepartamentos;i++)
					{
						if(numero.equals(departamentos.get(i).getNumero()))
						{
							return true;
						}
					}
				}
				return false;
			}
			
			
			
			
			
			
			
			
			
			
			/**
			 * Metodo eliminar 
			 * este metodo revisa  si el administrador se encuentra antes de agregarlo
			 * retorna un true si lo logra y un false si no 
			 */	
			public boolean eliminar(Departamento departamento)
			{		
				if(existe(departamento.getNumero()))
				{
						if(departamentos.remove(departamento))
							return true;
				}
				
				return false;
			}
			
			
			
			
			
			
			
			/**
			 * Metodo buscarNumero 
			 *recorre la lista de departamentos y compara los numeros
			 *retorna el departamento con el numero recibido  
			 */	
		    public Departamento buscarNumero(String numeroDep)
		    {
		    	for(int i=0;i<departamentos.size();i++)
				{
					if(numeroDep.equals(departamentos.get(i).getNumero()))
						return departamentos.get(i);
				}
				return null;
		    }
		     
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo buscarTamaño 
			 *recorre la lista de departamentos y compara los tamaños
			 *retorna el departamento con el tamaño recibido  
			 */	
		    public Departamento buscarTamaño(String tamaño)
		    {
		    	for(int i=0;i<departamentos.size();i++)
				{
					if(departamentos.get(i).getTamaño().equals(tamaño))
						return departamentos.get(i);
				}
				return null;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo buscarPrecio 
			 *recorre la lista de departamentos y compara los precios 
			 *retorna el departamento con el precio recibido  
			 */	
		    public Departamento buscarPrecio(int  precio)
		    {
		    	for(int i=0;i<departamentos.size();i++)
				{
					if(departamentos.get(i).getPrecio()==precio)
						return departamentos.get(i);
				}
				return null;
		    }
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo buscarEstado
			 *recorre la lista de departamentos y compara los estados(libre/ocupado)
			 *retorna el departamento con el solicitado   
			 */	
		    public Departamento buscarEstado(boolean estado)
		    {
		    	for(int i=0;i<departamentos.size();i++)
				{
					if(departamentos.get(i).isEstado()==estado)
						return departamentos.get(i);
				
			    }
				return null;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo buscarNumeroHabitaciones
			 *recorre la lista de departamentos y compara el numero de habitacion
			 *retorna el departamento con el numero de habitaciones solicitado  
			 */	
		    public Departamento buscarNumeroHabitaciones(int numeroHabitaciones)
		    {
		    	for(int i=0;i<departamentos.size();i++)
				{
					if(departamentos.get(i).getNumeroHabitaciones()==numeroHabitaciones)
						return departamentos.get(i);
				
			    }
				return null;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo modificarPrecio 
			 *recorre la lista de departamentos , busca el  proyecto  y busca el departamento modifica el precio
			 *retorna true si lo logro a modificar y false si no   
			 */	
		    public boolean modificarprecio(Departamento departamentoModificar,int nuevoPrecio,String idProyecto )
		    {
		    	Archivo archivo=new Archivo();
		    	if(existe(departamentoModificar.getNumero()))
		    	{
		    		
		    		departamentoModificar.setPrecio(nuevoPrecio);
		            try {
						archivo.actualizarTxtDepartamentos((Departamento)departamentoModificar, idProyecto);
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		return true;
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo modificarEstado
			 *recorre la lista de departamentos , busca el  proyecto  y busca el departamento modifica el Estado
			 *retorna true si lo logro a modificar y false si no   
			 */	
		    public boolean modificarEstado(Departamento departamentoModificar,String idProyecto)
		    {
		    	Archivo archivo=new Archivo();
		    	if(departamentos==null)
		    		return false;
		    	if(existe(departamentoModificar.getNumero()))
		    	{
		    		
		            if(departamentoModificar.isEstado()==false)
		            {
		            	departamentoModificar.setEstado(true);
		            	return true;
		            }
		            if(departamentoModificar.isEstado()==true)
		            {
		            	departamentoModificar.setEstado(false);
		            	return true;
		            }
		            try {
		            	archivo.actualizarTxtDepartamentos((Departamento)departamentoModificar,idProyecto);
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo modificarTamaño
			 *recorre la lista de departamentos , busca el  proyecto  y busca el departamento modifica el tamaño
			 *retorna true si lo logro a modificar y false si no   
			 */	
		    public boolean modificarTamaño(Departamento departamentoModificar,String tamaño,String idProyecto )
		    {
		    	Archivo archivo=new Archivo();
		    	if(existe(departamentoModificar.getNumero()))
		    	{
		    		
		    		departamentoModificar.setTamaño(tamaño);
		            try {
		            	archivo.actualizarTxtDepartamentos((Departamento)departamentoModificar,idProyecto);
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		return true;
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    
		    /**
			 * Metodo modificarDescripcion
			 *recorre la lista de departamentos , busca el  proyecto  y busca el departamento modifica la descripcion del departamento
			 *retorna true si lo logro a modificar y false si no   
			 */	
		    public boolean modificarDescripcion(Departamento departamentoModificar,String descripcion,String idProyecto )
		    {
		    	Archivo archivo=new Archivo();
		    	if(existe(departamentoModificar.getNumero()))
		    	{
		    		
		    		departamentoModificar.setDescripcion(descripcion);
		            try {
		            	archivo.actualizarTxtDepartamentos((Departamento)departamentoModificar,idProyecto);
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		return true;
		    	}
		    	return false;
		    }
		    
		    
		    
		    
		    
		    
		    /**
		     * al crear un departamento se generan todos iguales 
		     * con los siguientes parametros
		     * @param departamento
		     * @param cantidad
		     * @param pisos
		     * @param idProyecto
		     * genera los numeros de los departamentos dependiendo de el piso en que el se encuentra 
		     * retorna el arrayList con estos 
		     */
		    public ArrayList<Departamento> generarDepartamentos(Departamento departamento,int cantidad,int pisos,String idProyecto)
		    {
		    	int id=0;
		    	String idCadena=idProyecto;
		    	int ultDig=0;
		    	int cantidadXpiso=cantidad/pisos;
		    	Archivo archivo = new Archivo();
		    	for(int i=0;i<cantidad;i++,id++)
		    	{
		    		idCadena=idProyecto;
		    		ultDig= obtenerUltimosDigitos(id);
		    		if(ultDig-cantidadXpiso==0)
		    		{
		    			id=id-cantidadXpiso;
		    			id=id+100;
		    		}
		    		if(id<100)
		    		{
		    			if(id<10)
		    				idCadena=idCadena+"00"+String.valueOf(id);
		    			else
		    				idCadena=idCadena+"0"+String.valueOf(id);
		    		}	
		    		else
		    		{
		    			idCadena=idCadena+String.valueOf(id);
		    		}
		    		Departamento nuevo = new Departamento(idCadena, departamento.getTamaño(),
		    				departamento.getNumeroHabitaciones(),departamento.isEstado(),
		    				departamento.getPrecio(), departamento.getDescripcion());
		    		departamentos.add(nuevo);
		    		try {
						archivo.actualizarTxtDepartamentos(nuevo, idProyecto);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		
		    	}
				return departamentos;
		    }
		
		    
		    
		    
		    
		    
		    
		    
		    /**
			 *sirve para obtener los ultimos digitos para la creacion de los 
			 *numeros de los departamentos en el metodo generar departamentos     
			 */	
			private int obtenerUltimosDigitos(int id) 
			{
				if(id==0)
					return 0;
				int ultDig=0;
				if(id<10)
				{
					ultDig=id%10;
				}
				else if(id<100)
					ultDig=id;
				else
					ultDig=id%100;
				
				return ultDig;
			}

			
}

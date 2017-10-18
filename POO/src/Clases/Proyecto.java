package Clases;

import java.util.ArrayList;

public class Proyecto implements Cloneable {

				private String id;
				private String nombre;
				private String direccion;
				private String ciudadUbicacion;
				private String nombreEncargado;
				private int totalPisos;
				private Archivo archivo; 
				private int totaldepartamentos;
				private ListaDepartamentos listaDepartamentos;
			
				
				/*constructores de la clase Proyecto*/
				public Proyecto(String id, String nombre, String direccion,String ciudadUbicacion, 
						String nombreEncargado, int totalPisos,int totalDpt) 
				{
					archivo=new Archivo();
					this.id = id;
					this.nombre = nombre;
					this.direccion = direccion;
					this.ciudadUbicacion=ciudadUbicacion;
					this.nombreEncargado = nombreEncargado;
					this.totalPisos = totalPisos;
					this.totaldepartamentos=totalDpt;
					this.listaDepartamentos = new ListaDepartamentos(archivo,id);	
					}
			
			
				public Proyecto() {
					
					
					this.id=null;
					this.nombre = null;
					this.direccion = null;
					this.nombreEncargado = null;
					this.totalPisos=0;
					this.totaldepartamentos=0;
				}
				/*fin de los constructores*/
				
			    
				
				
				
				 /**
				 * Metodo agregar departamento
				*recibe el departamentos y lo agrega este metodo no retorna nada
				 */
			
				public void agregarDepartamento(Object deptnuevo,String id)
				{
					listaDepartamentos.agregar(deptnuevo, id);
				}
				
				
				
				
				
				
				 /**
				 * Metodo agregar Departamento sin archivo
				*recibe el departamento  y agrega sin retornar nada
				 */
				public void agregarDepartamentoSinArchivo(Departamento nuevoDepartamento)
				{
					listaDepartamentos.agregarSinArchivo(nuevoDepartamento);
				}
				
				
				
				
				
				
				
				
				 /**
				 * Metodo getPosDepartamentos
				 * retorna el departamentos que esta en la posicion i
				 */
				public Departamento getPosDept (int i)
				{
					return listaDepartamentos.getPosDept(i);
				}
				
				
				
				
				
				
				 /**
				 * Metodo que retorna el tamaño de la listaDepartamentos
				 */
				public int sizeDepartamentos()
				{
					return listaDepartamentos.largo();
				}
				
				
				
				
				 /**
				 * Metodo existe
				*recibe el numero y retorna un boolean si existe true y si no false
				 */
				public boolean existe(String numero)
				{
					return listaDepartamentos.existe(numero); 
				}
				
				
				
				
				
				
				
			
				 /**
				*Metodo eliminarDepartamento
				*recibe el departamento a eliminar y no retorna nada
				 */
				public void eliminarDepartamento(Departamento  departamento)
				{
					listaDepartamentos.eliminar(departamento);
				}
				
				
				
				
				
				
				
				 /**
				 * Metodo buscarTamañNumerooDepartamento
				*recibe el numero y retorna el departamento que encuentre con ese numero
				 */
				public Departamento buscarNumeroDepartamento(String numeroDep)
				{
					return listaDepartamentos.buscarNumero(numeroDep);
				}
				
				
				
				
				
				
				
				 /**
				 * Metodo buscarEstadoDepartamento
				*recibe el estado y retorna el departamento que encuentre con ese estado
				 */
			    public Departamento buscarEstadoDepartamento(boolean estado)
				{
					return listaDepartamentos.buscarEstado(estado);
				}
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    /**
				 * Metodo buscarPrecioDepartamento
				 *recibe el precio y retorna el departamento que encuentre con ese precio
				 */
			    public Departamento buscarPrecioDepartamento(int precio)
				{
					return listaDepartamentos.buscarPrecio(precio);
				}
			    
			    
			    
			    
			    
			    
			    
			    
			    /**
				 * Metodo buscarNumHabitacionesDepartamento
				*recibe el numero de habitaciones y retorna el departamento que encuentre con ese numeros de habitaciones
				 */
			    public Departamento buscarNumHabitacionesDepartamento(int numeroHabitaciones)
				{
					return listaDepartamentos.buscarNumeroHabitaciones(numeroHabitaciones);
				}
				
			    
			    
			    
			    
			    /**
				 * Metodo buscarTamañoDepartamento
				*recibe el tamaño y retorna el departamento que encuentre con ese tamaño
				 */
			    public Departamento buscarTamañoDepartamento(String tamaño)
				{
					return listaDepartamentos.buscarTamaño(tamaño);
				}
				
			    
				
				
				
			    /**
				 * Metodo modificaPrecioDepartamento
				 * recibe el id del proyecto ,el numero del departamento y el nuevo precio
				 * retorna un boolean true si lo logro y false si no
				 */
				public boolean modificarPrecioDepartamento(Departamento departamentoModificar,int nuevoPrecio,String idProyecto) {
					return listaDepartamentos.modificarprecio(departamentoModificar, nuevoPrecio, idProyecto);
				}
				
				
				
				
				
				
				/**
				 * Metodo modificaEstadoDepartamento
				 * recibe el id del proyecto ,el numero del departamento y cambia el estado(libre/ocupado)
				 * retorna un boolean true si lo logro y false si no
				 */
				public boolean modificarEstadoDepartamento(Departamento departamentoModificar,String idProyecto) {
					return listaDepartamentos.modificarEstado(departamentoModificar, idProyecto);
				}
				
				
				
				
				
				
				
				/**
				 * Metodo modificadescripcionDepartamento
				 * recibe el id del proyecto ,el numero del departamento y la nueva descipcion
				 * retorna un boolean true si lo logro y false si no
				 */
				public boolean modificarDescripcionDepartemento(Departamento departamentoModificar,String descripcion,String idProyecto) {
					return listaDepartamentos.modificarDescripcion(departamentoModificar, descripcion, idProyecto);
				}
				
				
				
				
				
				
				
				/**
				 * Metodo modificaTamañoDepartamento
				 * recibe el id del proyecto ,el numero del departamento y el nuevo tamaño 
				 * retorna un boolean true si lo logro y false si no
				 */
				public boolean modificarTamañoDepartemento(Departamento departamentoModificar,String tamaño,String idProyecto) {
					return listaDepartamentos.modificarTamaño(departamentoModificar, tamaño, idProyecto);
				}
				
			
				
				
				
				
				/**
				 * Metodo envia una copia de los departamentos 
				 */
				public ArrayList<Departamento> departamentosCopia (Departamento departamento,int cantidad,int pisos,String idProyecto)  {
			            return listaDepartamentos.generarDepartamentos(departamento, cantidad, pisos, idProyecto);      
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
			
			
						
						
						
						
			//retorna un clone de el proyecto actual
				
				public Proyecto clone() throws CloneNotSupportedException  {
					
					  return (Proyecto) super.clone();
					 }
					
						
	         /* getters y setters de la clase Proyecto*/
				public String getNombre() {
					return nombre;
				}
				public void setNombre(String nombre) {
					this.nombre = nombre;
				}
				public String getDireccion() {
					return direccion;
				}
				public void setDireccion(String direccion) {
					this.direccion = direccion;
				}
			
			
				public String getCiudadUbicacion() {
					return ciudadUbicacion;
				}
			
			
				public void setCiudadUbicacion(String ciudadUbicacion) {
					this.ciudadUbicacion = ciudadUbicacion;
				}
			
				public int getTotaldepartamentos() {
					return totaldepartamentos;
				}
			
				
				
				public void setTotaldepartamentos(int totaldepartamentos) {
					this.totaldepartamentos = totaldepartamentos;
				}
			

				public String getId() {
					return id;
				}
			
				public void setId(String id) {
					this.id = id;
				}
			
				public String getNombreEncargado() {
					return nombreEncargado;
				}
			
				public void setNombreEncargado(String nombreEncargado) {
					this.nombreEncargado = nombreEncargado;
				}
			
				public int getTotalPisos() {
					return totalPisos;
				}
			
				public void setTotalPisos(int totalPisos) {
					this.totalPisos = totalPisos;
				}
			
				public Archivo getArchivo() {
					return archivo;
				}
			
			
				public void setArchivo(Archivo archivo) {
					this.archivo = archivo;
				}
			/*fin de los getters y los setters */
				@Override
				public String toString()
				{
					return id+" "+nombre;
				}
				
				
}

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


	public void agregarDepartamento(Object deptnuevo,String id)
	{
		listaDepartamentos.agregar(deptnuevo, id);
	}
	
	
	public void agregarDepartamentoSinArchivo(Departamento nuevoDepartamento)
	{
		listaDepartamentos.agregarSinArchivo(nuevoDepartamento);
	}
	
	public Departamento getPosDept (int i)
	{
		return listaDepartamentos.getPosDept(i);
	}
	
	public int sizeDepartamentos()
	{
		return listaDepartamentos.largo();
	}
	
	public boolean existe(String numero)
	{
		return listaDepartamentos.existe(numero); 
	}
	

	public void eliminarDepartamento(Departamento  departamento)
	{
		listaDepartamentos.eliminar(departamento);
	}
	
	
	public Departamento buscarNumeroDepartamento(String numeroDep)
	{
		return listaDepartamentos.buscarNumero(numeroDep);
	}
	
	
	
    public Departamento buscarEstadoDepartamento(boolean estado)
	{
		return listaDepartamentos.buscarEstado(estado);
	}
    
    
    public Departamento buscarPrecioDepartamento(int precio)
	{
		return listaDepartamentos.buscarPrecio(precio);
	}
    
    public Departamento buscarNumHabitacionesDepartamento(int numeroHabitaciones)
	{
		return listaDepartamentos.buscarNumeroHabitaciones(numeroHabitaciones);
	}
	
    public Departamento buscarTamañoDepartamento(String tamaño)
	{
		return listaDepartamentos.buscarTamaño(tamaño);
	}
	
    
	
	
	
	
	public boolean modificarPrecioDepartamento(Departamento departamentoModificar,int nuevoPrecio,String idProyecto) {
		return listaDepartamentos.modificarprecio(departamentoModificar, nuevoPrecio, idProyecto);
	}
	
	
	public boolean modificarEstadoDepartamento(Departamento departamentoModificar,String idProyecto) {
		return listaDepartamentos.modificarEstado(departamentoModificar, idProyecto);
	}
	
	
	public boolean modificarDescripcionDepartemento(Departamento departamentoModificar,String descripcion,String idProyecto) {
		return listaDepartamentos.modificarDescripcion(departamentoModificar, descripcion, idProyecto);
	}
	
	public boolean modificarTamañoDepartemento(Departamento departamentoModificar,String tamaño,String idProyecto) {
		return listaDepartamentos.modificarTamaño(departamentoModificar, tamaño, idProyecto);
	}
	

	
	
	public ArrayList<Departamento> generanDept(Departamento departamento,int cantidad,int pisos,String idProyecto)  {
            return listaDepartamentos.generarDepartamentos(departamento, cantidad, pisos, idProyecto);      
	}
	



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
	public Proyecto clone() throws CloneNotSupportedException  {
		
		  return (Proyecto) super.clone();
		 }
	@Override
	public String toString()
	{
		return id+" "+nombre;
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
}

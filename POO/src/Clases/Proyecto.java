package Clases;
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


	public ListaDepartamentos getListaDepartamentos() {
		return listaDepartamentos;
	}


	public void setListaDepartamentos(ListaDepartamentos listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
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
	
	
	
}

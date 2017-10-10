package Clases;

public class Departamento {
 private String numero;
 private String tama�o;
 private int numeroHabitaciones;
 //ocupado o libre
 private boolean estado;
 private int precio;
 private String descripcion;
 
 
 
 
public Departamento(String numero, String tama�o, int numeroHabitaciones, boolean estado,
		int precio, String descripcion) {
	super();
	this.numero = numero;
	this.tama�o = tama�o;
	this.numeroHabitaciones = numeroHabitaciones;
	this.estado = estado;
	this.precio = precio;
	this.descripcion = descripcion;
	
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


//getters and setters
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getTama�o() {
	return tama�o;
}
public void setTama�o(String tama�o) {
	this.tama�o = tama�o;
}
public int getNumeroHabitaciones() {
	return numeroHabitaciones;
}
public void setNumeroHabitaciones(int numeroHabitaciones) {
	this.numeroHabitaciones = numeroHabitaciones;
}
public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}

public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

@Override
public String toString()
{
	return numero;
}

  
}

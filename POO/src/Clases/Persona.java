package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*clase abstract no sabemos si es admin,usuario o cliente */
/*clase padre de admin*/
public abstract class Persona  {
	//tienen que ser protect 
	protected String nombre;
	protected String rut;
	protected String direccion;
	protected String correo;
	protected String telefono;
	protected String clave;
	
	
	
/*constructor*/
	
	public Persona(String nombre, String rut, String direccion, String correo, String telefono) {
	super();
	this.nombre = nombre;
	this.rut = rut;
	this.direccion = direccion;
	this.correo = correo;
	this.telefono = telefono;
	
}
	public Persona(String nombre, String rut, String direccion, String correo, String telefono, String clave) {
	super();
	this.nombre = nombre;
	this.rut = rut;
	this.direccion = direccion;
	this.correo = correo;
	this.telefono = telefono;
	this.clave = clave;
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
	
	
	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getRut() 
	{
		return rut;
	}
	public void setRut(String rut) 
	{
		this.rut = rut;
	}
	public String getDireccion() 
	{
		return direccion;
	}
	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}
	public String getCorreo() 
	{
		return correo;
	}
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	public String getTelefono()
	{
		return telefono;
	}
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}

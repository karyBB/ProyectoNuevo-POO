package Clases;

public class Vendedor extends Persona { 
	//el usuario tiene un arraylist de los departamentos que el ha vendido 

	 private String[] departamentos;
		 
	 	
	public Vendedor(String nombre, String rut, String direccion, String correo, String telefono, 
			String clave, String[] departamentos) 
	{
		super(nombre, rut, direccion, correo, telefono, clave);
		this.departamentos=departamentos;
	}
	public Vendedor(String nombre, String rut, String direccion, String correo, String telefono
							, String[] departamentos) {
		super(nombre, rut, direccion, correo, telefono);
		this.departamentos=departamentos;
		
	}

	public Vendedor(String nombre, String rut, String direccion, String correo, String telefono, String clave) {
		super(nombre, rut, direccion, correo, telefono, clave);
			
	}
	
	
	
	


	
	public String[] getDepartamentos() {
		return departamentos;
	}

	public boolean validarClaveUser(String rut, String claveUser) 
	{						
		if(rut.equals(super.getRut()) && claveUser.equals(getClave()))
		{
			return true;
		}
		return false;
	}
	
 
}

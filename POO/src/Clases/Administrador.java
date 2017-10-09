package Clases;

/*clase Admin, subclase de la clase Persona*/
public class Administrador extends Persona implements Cloneable{

	private String cargo ;
	
	public Administrador(){
		this("","","","","");
	}
//sobrecarga de constructor 
	public Administrador(String nombre, String rut, String direccion, String correo, String telefono, String clave,String cargo) {
		super(nombre, rut, direccion, correo, telefono, clave);
		
		this.cargo=cargo;
	}
	
	
	
	public Administrador(String nombre, String rut, String direccion, String correo, String telefono) {
		super(nombre, rut, direccion, correo, telefono);
		
	}

	

	public boolean validarClaveAdmi(String rut, String claveAdm) 
	{						
		if(rut.equals(super.getRut()) && claveAdm.equals(getClave()))
		{
			return true;
		}
		return false;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Administrador clone() throws CloneNotSupportedException  {
		
		  return (Administrador) super.clone();
		 }
}
    
	
	
	

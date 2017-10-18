package Clases;

/*clase Admin, subclase de la clase Persona*/
public class Administrador extends Persona {
		
			private String cargo ;
			
			
			
			
		/*contructores de la clase Administrador*/
			public Administrador(){
				this("","","","","");
			}
		
			
			public Administrador(String nombre, String rut, String direccion, String correo, String telefono, String clave,String cargo) {
				super(nombre, rut, direccion, correo, telefono, clave);
				
				this.cargo=cargo;
			}
			
			
			public Administrador(String nombre, String rut, String direccion, String correo, String telefono) {
				super(nombre, rut, direccion, correo, telefono);
				
			}
			
		
		/*fin de los constructores*/
			
		
			public boolean validarClaveAdmi(String rut, String claveAdm) 
			{						
				if(rut.equals(super.getRut()) && claveAdm.equals(getClave()))
				{
					return true;
				}
				return false;
			}
		  
			
		/*get y set de la clase Adminsitrador*/
			public String getCargo() {
				return cargo;
			}
		
			
			
			public void setCargo(String cargo) {
				this.cargo = cargo;
			}
	
}
    
	
	
	

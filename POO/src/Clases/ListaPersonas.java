package Clases;


public abstract class ListaPersonas
{
  

	/**
	 * Metodo que valida que la contraseņa se encuentre.
	 */
	public boolean verificacion(String contraseņaReal, String contraseņaIngresada)  
	{ 

			if((contraseņaReal.equals(contraseņaIngresada))){
				return true;
			}
			
		return false;
	}
	
			
	
	
			
	/*metodos abstractos que se implementan el listaVendedores y listaAdministradores*/
	public abstract Object buscarNombre(String nombre);

	public abstract Object buscarClave(String clave);

	public abstract boolean modificarDireccion(Object persona,String cambiar);

	public abstract boolean modificarTelefono(Object persona,String cambiar);

	public abstract boolean modificarCorreo(Object persona,String cambiar);
	
	public abstract boolean modificarClave(Object persona,String cambiar);
	/*fin */
	

	


}

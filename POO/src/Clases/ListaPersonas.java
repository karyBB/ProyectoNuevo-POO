package Clases;


public abstract class ListaPersonas
{
  

	/**
	 * Metodo que valida que la contrase�a se encuentre.
	 */
	public boolean verificacion(String contrase�aReal, String contrase�aIngresada)  
	{ 

			if((contrase�aReal.equals(contrase�aIngresada))){
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

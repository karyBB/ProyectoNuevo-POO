package Clases;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ListaPersonas 
{
  

	//valida que la contrase�a es correcta
	public boolean verificacion(String contrase�aReal, String contrase�aIngresada)  
	{ 

			if((contrase�aReal.equals(contrase�aIngresada))){
				return true;
			}
			
		return false;
	}
			
	
	public abstract Object buscarNombre(String nombre);

	public abstract Object buscarClave(String clave);

	public abstract boolean modificarDireccion(Object persona,String cambiar);

	public abstract boolean modificarTelefono(Object persona,String cambiar);

	public abstract boolean modificarCorreo(Object persona,String cambiar);
	
	public abstract boolean modificarClave(Object persona,String cambiar);
	

	


}

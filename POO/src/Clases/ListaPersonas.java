package Clases;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ListaPersonas 
{
  

	//valida que la contraseña es correcta
	public boolean verificacion(String contraseñaReal, String contraseñaIngresada)  
	{ 

			if((contraseñaReal.equals(contraseñaIngresada))){
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

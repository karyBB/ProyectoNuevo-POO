package Clases;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ListaPersonas 
{
  
	

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
	

	
	
	//valida que la contraseña es correcta
	public boolean verificacion(String contraseñaReal, String contraseñaIngresada)  
	{ 

			if((contraseñaReal.equals(contraseñaIngresada))){
				return true;
			}
			
		return false;
	}
			
	
		
		
		
		
	
	//verifica que el telefono tenga 8 digitos
	public boolean verificarTelefono(int nuevoTelefono)	
	{
		int cont = 0;
		while(nuevoTelefono>0){
			nuevoTelefono = nuevoTelefono/10;
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
	
	
	
	public abstract Object buscarNombre(String nombre);

	public abstract Object buscarClave(String clave);

	public abstract boolean modificarDireccion(Object persona,String cambiar);

	public abstract boolean modificarTelefono(Object persona,String cambiar);

	public abstract boolean modificarCorreo(Object persona,String cambiar);
	
	public abstract boolean modificarClave(Object persona,String cambiar);
	

	


}

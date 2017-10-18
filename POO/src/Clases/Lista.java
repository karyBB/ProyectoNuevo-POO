package Clases;



public interface Lista  
{
	/*lo elementos que implementa la interfaz lista pueden ser enlistables e implementan los siguientes metodos */
	public boolean agregar(Object a);
	
	public boolean eliminar(Object e);
	
	public boolean modificarNombre(Object algo,String cambiar);
	
	public boolean existe(Object buscado);
	
	public Object busqueda(String  buscado);
	
	public int size();
	

}

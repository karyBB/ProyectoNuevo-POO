package Clases;

public class Vendedor extends Persona { 
	
	//el usuario tiene un arraylist de los departamentos que el ha vendido 
	 private ListaDepartamentos departamentos;
		 
	 	
	public Vendedor(String nombre, String rut, String direccion, String correo, String telefono, 
			String clave) 
	{
		super(nombre, rut, direccion, correo, telefono, clave);
		this.departamentos = new ListaDepartamentos();
	}
	public Vendedor(String nombre, String rut, String direccion, String correo, String telefono) {
		super(nombre, rut, direccion, correo, telefono);
		this.departamentos = new ListaDepartamentos();
		
	}

	public int largoDept()
	{
		return departamentos.largo();
	}
	
	public Departamento getPosDept(int i)
	{
		return departamentos.getPosDept(i);
	}
	public boolean validarClaveUser(String rut, String claveUser) 
	{						
		if(rut.equals(super.getRut()) && claveUser.equals(getClave()))
		{
			return true;
		}
		return false;
	}
	
	public void agregarDept(Departamento deptnuevo)
	{
		departamentos.agregar(deptnuevo);
	}
	public void agregarDeptConArchivo(Departamento deptnuevo) 
	{
		Archivo archivo = new Archivo();
		departamentos.agregar(deptnuevo);
		archivo.actualizarTxtVendedor(Vendedor.this);
	}
	
	
}

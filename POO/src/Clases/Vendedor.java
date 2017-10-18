package Clases;

import java.io.IOException;

public class Vendedor extends Persona { 
	
	
			/*un ArrayList de los departamentos vendidos por el vendedor*/
			private ListaDepartamentos departamentos;
				
			
			
			
			
			
			/*contructores de la clase Vendedores*/
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
			/*fin de los constructores*/
		
			
			
			
			
			/**
			 * Metodo que retorna el tamaño del el arrayList de departamentos que posee el vendedor 
			 */
			public int largoDept()
			{
				return departamentos.largo();
			}
			
			
			
			
			
			
			
			/**
			 * Metodo que retorna el  departamento que se encuentra en la posicion i 
			 */
			public Departamento getPosDept(int i)
			{
				return departamentos.getPosDept(i);
			}
			
			
			
			
			
			
			
			/**
			 * Metodo que valida la clave del usuario encontrado con el rut 
			 * retorna true si este usuario cumple con la clave y el rut 
			 */
			public boolean validarClaveUser(String rut, String claveUser) 
			{						
				if(rut.equals(super.getRut()) && claveUser.equals(getClave()))
				{
					return true;
				}
				return false;
			}
			
			
			
			
			
			
			
	
			
			/**
			 * Metodo agrega un departamento a el arraylist de departamentos vendidos 
			 */
			public void agregarDept(Departamento deptnuevo)
			{
				departamentos.agregar(deptnuevo);
			}
			
			
			
			
			
			
			
			
			/**
			 * Metodo agrega un departamento a el arraylist de departamentos vendidos 
			 * y actualiza el text del vendedor agregando el nuevo departamento
			 */
			public void agregarDeptConArchivo(Departamento deptnuevo) 
			{
				Archivo archivo = new Archivo();
				departamentos.agregar(deptnuevo);
				try {
					archivo.actualizarTxtVendedor(Vendedor.this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
	
}

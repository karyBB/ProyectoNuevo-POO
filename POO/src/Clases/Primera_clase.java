package Clases;
import Ventanas.VentanaIngreso;

/**gestion de propiedades
*
*
*
* 
 Programado por Karina Bernal
           
 */

public class Primera_clase {
    
    
	public static void main(String[] args) {
		
		Empresa empresa=new Empresa();
		VentanaIngreso ingreso = new VentanaIngreso(empresa);
		ingreso.setVisible(true);
		
	
	}



}

package Clases;

import java.util.HashMap;


public class IteratorListas implements Iterable   {
	
       private int posicion=-1;
              
       private HashMap<String,Administrador> lista;
       
   


	public  IteratorListas(HashMap<String,Administrador>administradores)  {
        this.lista=administradores;
       }
       
       
       public boolean quedanElementos() {
           boolean result;
           if (posicion < lista.size()) {
        	   result = true; }
           else { 
        	   result = false; }
           return result;
       }
       
       
      
       public void primero()
       {
           this.posicion = -1;
       }
       
       
       public Administrador actual()
       {
           // Si no existen elementos, devolveremos null.
           // Si el indice actual es mayor que el mayor indice aceptable, devolveremos null.
           // Si el indice actual es -1, devolveremos null.
           if ((this.lista.isEmpty()) || 
               (posicion > this.lista.size() - 1) ||
               (this.posicion < 0))
               return null;
        
           // Devolvemos el elemento correspondiente al elemento actual
           else
               return (Administrador)this.lista.entrySet();
       }
     
    // Operación 3: Acceso al siguiente elemento
       public Administrador siguiente()
       {
           // Si no existen elementos, devolveremos null.
           // Si el indice siguiente es mayor que el mayor indice aceptable, devolveremos null.
    	  
           if ((this.lista.isEmpty()) ||  
               (posicion + 1 > this.lista.size()- 1))
               return null;
        
           // Aumentamos el índice en una unidad y devolvemos ese elemento
           else
        	   {
               return (Administrador)this.lista.entrySet();
        	   }
        	   
		
       }
}

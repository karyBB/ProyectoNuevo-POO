package Clases;

import java.util.HashMap;
import java.util.Map.Entry;


public abstract class IteratorListas implements Iterable   {
	
       private int posicion=-1;
       Entry<String,Administrador> siguiente;        // next entry to return
       int expectedModCount;   // For fast-fail
       int index;              // current slot
       Entry<String,Administrador> current;     // current entry
       
       private HashMap<String,Administrador> lista;
       
   
      public void HashIterator() {
           expectedModCount = lista.size();
           if (lista.size() > 0) { // advance to first entry
               Entry[] t = table;
               while (index < t.length && (next = t[index++]) == null)
                   ;
           }
       }

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
      

       public final boolean hasNext() {
           return next != null;
       }

       final Entry<K,V> nextEntry() {
           if (modCount != expectedModCount)
               throw new ConcurrentModificationException();
           Entry<K,V> e = next;
           if (e == null)
               throw new NoSuchElementException();

           if ((next = e.next) == null) {
               Entry[] t = table;
               while (index < t.length && (next = t[index++]) == null)
                   ;
           }
           current = e;
           return e;
       }

       public void remove() {
           if (current == null)
               throw new IllegalStateException();
           if (modCount != expectedModCount)
               throw new ConcurrentModificationException();
           Object k = current.key;
           current = null;
           HashMap.this.removeEntryForKey(k);
           expectedModCount = modCount;
       }

   }
}

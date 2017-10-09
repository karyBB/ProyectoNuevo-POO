package Clases;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CrearPDF {

	//Constructor
	public CrearPDF(Administrador admin)
	{
	   
	    	try{
	    		//Se instancia un JFileChooser para elegir donde guardar el PDF
	    	    JFileChooser fileChooserA = new JFileChooser(); 
	     
	    	    //filtro para ver solo archivos .pdf  
	    	    fileChooserA.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.PDF", "pdf","PDF"));
	    	    int seleccion = fileChooserA.showSaveDialog(null);
	    	    
		    	//comprueba si ha presionado el boton de aceptar 
		    	if (seleccion == JFileChooser.APPROVE_OPTION){
		    		//Ubicacion y creacion del PDF
		            File archivoJFileChooser = fileChooserA.getSelectedFile();
		            
		            //Se crea el PDF en la ruta elegida 
		            FileOutputStream archivo = new FileOutputStream(archivoJFileChooser+".pdf");
		            
		            llenarPDF(archivo,admin);
		    	}
	    	}catch (Exception e){
		        JOptionPane.showMessageDialog(null,"Error al guardar el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	  
	    
        
	}//FIN CONSTRUCTOR
	
	
	
	
	public void llenarPDF(FileOutputStream archivo, Administrador administrador){

	    //Tipos de letras personalizados que se usaran	    
		Font tipoLetraTitulo = new Font(Font.FontFamily.HELVETICA , 16, Font.BOLD);
		Font tipoLetraTitulos = new Font(Font.FontFamily.HELVETICA , 12, Font.BOLD);
		Font tipoLetraNormal = new Font(Font.FontFamily.HELVETICA , 10);	    
	   
    	Document docPDF = new Document();
        
    	try {
			PdfWriter.getInstance(docPDF, archivo);
  
	        //Se abre el PDF para poder escribir en su interior
	        docPDF.open();
	        
	        
	        //Contiene el titulo principal del documento PDF
	        Paragraph titulo = new Paragraph("Mis Recetas\n\r", tipoLetraTitulo); 
	        titulo.setAlignment(Element.ALIGN_CENTER);
	        docPDF.add(titulo);
	            
            //Recorrido de todas las recetas del alumno
            for(int i = 0; i < arrayRecetas.largo(); i++)
            {
	            //Titulo de la tabla de la receta
            	Paragraph tituloReceta = new Paragraph(arrayRecetas.getPosReceta(i).getNombreReceta(), tipoLetraTitulos); 
            	

            	//Se crea la tabla con titulo de la receta
	            PdfPTable tablaTitulo = new PdfPTable(1);
	            PdfPCell celdaTitulo = new PdfPCell(tituloReceta);
	            celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
	            tablaTitulo.addCell(celdaTitulo);
	            docPDF.add(tablaTitulo);		            
	            
	            
	            //String donde se guardaran los ingredientes de cada receta
	            String todosLosIng = "";
	            
	            for (int j = 0 ; j < arrayRecetas.getPosReceta(i).getIngredientes().length; j++){
		            String ingrediente = (""+arrayRecetas.getPosReceta(i).getIngredientes()[j].toString()+"\n");
		            todosLosIng = todosLosIng + ingrediente;
	            }
	            PdfPCell celdaIngredientes = new PdfPCell(new Phrase(todosLosIng));
	            
	      
	            //String donde se guardaran los utensilios de cada receta
	            String todosLosUten = "";
	            
	            for (int x = 0 ; x < arrayRecetas.getPosReceta(i).getUtensilios().length; x++){
	            	String utensilio = (""+arrayRecetas.getPosReceta(i).getUtensilios()[x].toString()+"\n");
	            	todosLosUten = todosLosUten + utensilio;
	            } 
	            PdfPCell celdaUtensilios = new PdfPCell(new Phrase(todosLosUten));
	           

	            //String donde se guardaran las categorias de cada receta
	            String todosLasCat = "";
	            
	            for (int y = 0 ; y < arrayRecetas.getPosReceta(i).getCategorias().length; y++){
	            	String categoria = (""+arrayRecetas.getPosReceta(i).getCategorias()[y].toString()+"\n");
	            	todosLasCat = todosLasCat + categoria;
	            } 
	            PdfPCell celdaCategorias = new PdfPCell(new Phrase(todosLasCat));	
	            
	            
	            //Contienen los headers de los elementos de la receta 
	            Paragraph tituloIngredientes = new Paragraph("INGREDIENTES", tipoLetraTitulos);
	            Paragraph tituloUtensilios = new Paragraph("UTENSILIOS", tipoLetraTitulos); 
	            Paragraph tituloCategorias = new Paragraph("CATEGORIAS", tipoLetraTitulos);
	            
	            
	            //Creacion de Headers de cada columna que contiene los elementos de la receta (Ingredientes, Utensilios, Categorias)
	            PdfPTable cabecerasElementosReceta = new PdfPTable(3);
	            cabecerasElementosReceta.addCell(tituloIngredientes);
	            cabecerasElementosReceta.addCell(tituloUtensilios);
	            cabecerasElementosReceta.addCell(tituloCategorias);
	            docPDF.add(cabecerasElementosReceta); 
	            
	            
	            //Creacion tabla de todos los elemtnos de la receta  
	            PdfPTable elementosRecetas = new PdfPTable(3);	
	            elementosRecetas.addCell(celdaIngredientes);
	            elementosRecetas.addCell(celdaUtensilios);
	            elementosRecetas.addCell(celdaCategorias);
	            docPDF.add(elementosRecetas);
	            
	            
	            //Contiene el titulo de instrucciones
	            Paragraph tituloInstrucciones = new Paragraph("INSTRUCCIONES", tipoLetraTitulos);
	            
	            //Se crea la tabla que tendrá el titulo de instrucciones
	            PdfPTable tablaTituloInstrucciones = new PdfPTable(1);
	            PdfPCell celdaTituloInstrucciones = new PdfPCell(tituloInstrucciones);
	            celdaTituloInstrucciones.setHorizontalAlignment(Element.ALIGN_CENTER);
	            tablaTituloInstrucciones.addCell(celdaTituloInstrucciones);
	            docPDF.add(tablaTituloInstrucciones);  
	            
	            
	            //Contiene las instrucciones de la receta
	            Paragraph instrucciones = new Paragraph(arrayRecetas.getPosReceta(i).getInstrucciones(), tipoLetraNormal); 
	            
	            //Se crea la tabla que tendrá las instrucciones de la receta
	            PdfPTable tablaInstrucciones = new PdfPTable(1);
	            PdfPCell celdaInstrucciones = new PdfPCell(instrucciones);
	            celdaInstrucciones.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	            tablaInstrucciones.addCell(celdaInstrucciones);
	            docPDF.add(tablaInstrucciones);     
	            
	            
	            //Contiene el tiempo estimado que tiene la receta   
	            Paragraph tiempoEstimado = new Paragraph ("Tiempo Estimado : "+arrayRecetas.getPosReceta(i).getTiempoEstimadoPreparacion()+" minutos",tipoLetraNormal);
	            PdfPTable tablaTiempoEstimado = new PdfPTable(1);
	            PdfPCell celdaTiempoEstimado = new PdfPCell(tiempoEstimado);
	            tablaTiempoEstimado.addCell(celdaTiempoEstimado);
	            docPDF.add(tablaTiempoEstimado);
	            
	            
	            //Un Espacio en blanco para separar cada tabla
	            Paragraph espacioEnBlanco = new Paragraph ("\n\r");
	            docPDF.add(espacioEnBlanco);
            }
            
            //Se cierra el documento PDF
            docPDF.close();

            if(opcion == 1){
            	JOptionPane.showMessageDialog(null,"Se guardó correctamente el archivo", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }else if (opcion == 2){
            	String correoAlumno = JOptionPane.showInputDialog(null, "Ingrese su correo: ", "Para enviar sus recetas", JOptionPane.QUESTION_MESSAGE);
            	if(correoAlumno != null){
            		if(!correoAlumno.equals("")){
                    	enviarPDF(correoAlumno);
            		}else{
            			JOptionPane.showMessageDialog(null,"Faltó llenar campo");
            		}
            	}
            	try {
					eliminarPDF();
				} catch (IOException e) {
					System.out.println("no se pudo eliminar archivo");
				}
            }
            	
		} catch (DocumentException e) {
			e.printStackTrace();
		}	 
    }
	
	//Metodo que llama al metodo de la clase EnviarMensajeCorreo para poder enviar pdf a correo
	private void enviarPDF(String correoAlumno)
	{
		EnviarMensajeACorreo enviarCorreo = new EnviarMensajeACorreo();
		enviarCorreo.crearMensajeConArchivoAdjunto(correoAlumno);
	}
	
	//Metodo que elimina el PDF auxiliar
	private void eliminarPDF() throws IOException{
        File f = new File("MisRecetas.pdf");
        if(f.exists())
        	f.delete();
	}

}//FIN CLASE

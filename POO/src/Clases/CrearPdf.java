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

public class CrearPdf {

	//Constructor
	public CrearPdf(Administrador admin,Vendedor vendedor)
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
		            if(admin!=null)
		            llenarPDFAdministrador(archivo,admin);
		            else
		            llenarPDFVendedor(archivo,vendedor);
		    	}
	    	}catch (Exception e){
		        JOptionPane.showMessageDialog(null,"Error al guardar el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	  
	   
        
	}//FIN CONSTRUCTOR
	
	
	
	
	public void llenarPDFVendedor(FileOutputStream archivo, Vendedor vendedor){

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
	        Paragraph titulo = new Paragraph("Datos Usuario \n\r", tipoLetraTitulo); 
	        titulo.setAlignment(Element.ALIGN_CENTER);
	        docPDF.add(titulo);
	            
            
	            //Titulo de la tabla 
            	Paragraph tituloDatos = new Paragraph("Vendedor "+vendedor.getNombre(), tipoLetraTitulos); 
            	

            	//Se crea la tabla con titulo 
	            PdfPTable tablaTitulo = new PdfPTable(1);
	            PdfPCell celdaTitulo = new PdfPCell(tituloDatos);
	            celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
	            tablaTitulo.addCell(celdaTitulo);
	            docPDF.add(tablaTitulo);		
	            
	            
	            
	            
	            Paragraph rut = new Paragraph("RUT  "+vendedor.getRut(), tipoLetraNormal);
	            docPDF.add(rut); 
	            Paragraph direccion = new Paragraph("DIRECCION  "+vendedor.getDireccion(), tipoLetraNormal);
	            docPDF.add(direccion); 
	            Paragraph correo = new Paragraph("CORREO  "+vendedor.getCorreo(), tipoLetraNormal);
	            docPDF.add(correo); 
	            Paragraph telefono = new Paragraph("TELEFONO  "+vendedor.getTelefono(), tipoLetraNormal);
	            docPDF.add(telefono); 
	          
	            
            //Se cierra el documento PDF
            docPDF.close();

           
            	JOptionPane.showMessageDialog(null,"Se guardó correctamente el archivo", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
          
            	
		} catch (DocumentException e) {
			e.printStackTrace();
		}	 
    }
	
	

	public void llenarPDFAdministrador(FileOutputStream archivo, Administrador administrador){

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
	        Paragraph titulo = new Paragraph("Datos Usuario \n\r", tipoLetraTitulo); 
	        titulo.setAlignment(Element.ALIGN_CENTER);
	        docPDF.add(titulo);
	            
            
	            //Titulo de la tabla 
            	Paragraph tituloDatos = new Paragraph("Administrador "+administrador.getNombre(), tipoLetraTitulos); 
            	

            	//Se crea la tabla con titulo 
	            PdfPTable tablaTitulo = new PdfPTable(1);
	            PdfPCell celdaTitulo = new PdfPCell(tituloDatos);
	            celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
	            tablaTitulo.addCell(celdaTitulo);
	            docPDF.add(tablaTitulo);		
	            
	            
	            
	            
	            Paragraph rut = new Paragraph("RUT  "+administrador.getRut(), tipoLetraNormal);
	            docPDF.add(rut); 
	            Paragraph direccion = new Paragraph("DIRECCION  "+administrador.getDireccion(), tipoLetraNormal);
	            docPDF.add(direccion); 
	            Paragraph correo = new Paragraph("CORREO  "+administrador.getCorreo(), tipoLetraNormal);
	            docPDF.add(correo); 
	            Paragraph telefono = new Paragraph("TELEFONO  "+administrador.getTelefono(), tipoLetraNormal);
	            docPDF.add(telefono); 
	            Paragraph cargo = new Paragraph("CARGO  "+administrador.getCargo(), tipoLetraNormal);
	            docPDF.add(cargo); 
	            
            //Se cierra el documento PDF
            docPDF.close();

           
            	JOptionPane.showMessageDialog(null,"Se guardó correctamente el archivo", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
          
            	
		} catch (DocumentException e) {
			e.printStackTrace();
		}	 
    }
	
	

}//FIN CLASE

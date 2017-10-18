package Clases;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CrearReporteExcel {

	
	
    public CrearReporteExcel(Empresa empresa,ListaProyectos proyectos) throws IOException{
        
    	HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();	
        libro.setSheetName(0, "Proyectos");
        
        
        String[] cabeceras = new String[]{"ID","NOMBRE","DIRECCION","CIUDAD","ENCARGADO","TOTAL DE PISOS"};
        
        CellStyle estiloCabecera = libro.createCellStyle();
        Font tipoLetra = libro.createFont();
        tipoLetra.setBoldweight(Font.BOLDWEIGHT_BOLD);
        estiloCabecera.setFont(tipoLetra);

        CellStyle estilo = libro.createCellStyle();
        estilo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        estilo.setFillPattern(CellStyle.SOLID_FOREGROUND);

        //Se agregan en la cabecera los datos contenidos en el arreglo de string cabeceras y ademas se le da un estilo a la letra
        
        HSSFRow cabeceraFila = hoja.createRow((short)0);
        for (int i = 0; i < cabeceras.length; ++i) {
            String cabecera = cabeceras[i];
            HSSFCell cell = cabeceraFila.createCell(i);
            cell.setCellStyle(estiloCabecera);
            cell.setCellValue(cabecera);
        }

        
        //Se llenan las columnas con los datos de los proyectos
        int i=0;
        while (empresa.obtenerProyecto(i)!=null) {
            HSSFRow datosFila = hoja.createRow(i + 1);
            String id = proyectos.getPosProyecto(i).getId();
            String nombre = proyectos.getPosProyecto(i).getNombre();
            String direccion = proyectos.getPosProyecto(i).getDireccion();
            String ciudad = proyectos.getPosProyecto(i).getCiudadUbicacion();
            String encargado = proyectos.getPosProyecto(i).getNombreEncargado();
            int npisos = proyectos.getPosProyecto(i).getTotalPisos();
           
        
            
            //Se agrega el dato especifico del proyecto en cada celda
        
            datosFila.createCell(0).setCellValue(id);
            datosFila.createCell(1).setCellValue(nombre);
            datosFila.createCell(2).setCellValue(direccion);
            datosFila.createCell(3).setCellValue(ciudad);
            datosFila.createCell(4).setCellValue(encargado);
            datosFila.createCell(5).setCellValue(npisos);
         
            
            //Ajusta el tamaño de la celda
            
            hoja.autoSizeColumn(i);
           i++; 
        }
        
        //Se llama al metodo para guardar archivo
        
        guardarArchivoXLS(libro);
            
    }//Fin Constructor
    
    
    
    
    
    /**
     *	Metodo que guarda el archivo .xls el cualquier parte que el administrador indique.
     *		Es el archivo .xls que contiene los datos de todos los proyectos.
     * */
    public void guardarArchivoXLS(HSSFWorkbook libro)
    {
        JFileChooser fileChooserProyectos = new JFileChooser();
       
        //filtro para ver solo archivos .xls
        
        fileChooserProyectos.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.XLS", "xls","XLS"));
        int seleccion = fileChooserProyectos.showSaveDialog(null);
        
        try{
        	//comprueba si ha presionado el boton de aceptar
            
        	if (seleccion == JFileChooser.APPROVE_OPTION){
                File archivoJFileChooser = fileChooserProyectos.getSelectedFile();
                FileOutputStream archivo = new FileOutputStream(archivoJFileChooser+".xls");
                libro.write(archivo);      
                archivo.close();
                JOptionPane.showMessageDialog(null,"Se guardó correctamente el archivo", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al guardar el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}//Fin Clase
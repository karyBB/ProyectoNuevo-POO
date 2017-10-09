package Ventanas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.Administrador;
import Clases.CrearReporteEnExcel;
import Clases.Empresa;
import Clases.ListaAdministradores;
import Clases.ListaProyectos;
import Clases.ListaVendedores;
import Clases.Proyecto;
import Clases.Vendedor;

public class VentanaReporte extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public VentanaReporte( Empresa empresa,int seleccionado, final VentanaAdministrador ventanaAnterior) throws CloneNotSupportedException {
	setTitle("Ventana de reporte");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(51, 204, 153));
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información Datos registrados :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelDatos.setBounds(8, 10, 350, 360);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);
		
		final JTextArea datos = new JTextArea();
		datos.setBounds(1, 1, 338, 331);
		datos.setBackground(new Color(255, 255, 255));
		panelDatos.add(datos);
		datos.setLineWrap(true); 
		datos.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datos);
		scrollLateral.setBounds(5, 22, 340, 333);
		panelDatos.add(scrollLateral);
		
		
		//Generar reporte
		
		        
				
		       
		        
		       
				if(seleccionado==0)
				mostrarEnJTextAreaProyecto(datos,empresa);
			 if(seleccionado==1)
				mostrarEnJTextAreaVendedor(datos,empresa);
				 if(seleccionado==2)
					mostrarEnJTextAreaAdministrador(datos,empresa);
				
				//Regresa a la ventana anterior
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						ventanaAnterior.setVisible(true);
					}
				});
				btnAtras.setBounds(268, 376, 90, 23);
				contentPane.add(btnAtras);
				
				if (seleccionado==0)
			     {
				//Se crea un .xls con los datos de los proyecto
				JButton btnCrearArchivoXls = new JButton("CREAR ARCHIVO XLS");
				btnCrearArchivoXls.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnCrearArchivoXls.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//implementar despues un JFileChooser para elegir ruta y nombre archivo
						     
						    	 ListaProyectos proyectos;
								
									try {
										proyectos = empresa.clonarProyectos();
										CrearReporteEnExcel archivoXLS = new CrearReporteEnExcel(empresa,proyectos);
									} catch (IOException | CloneNotSupportedException e) {
										e.printStackTrace();
									}
								
						     
					}
				});
			     
				btnCrearArchivoXls.setBounds(8, 376, 137, 23);
				contentPane.add(btnCrearArchivoXls);
			}
	}
	//muestra los datos por pantalla
	private void mostrarEnJTextAreaProyecto(JTextArea datosProy,Empresa empresa)
	{
		int j = 1;
		
		for (int i = 0; i < empresa.sizeProyecto(); i++)
		{
			Proyecto proyecto=empresa.obtenerProyecto(i);
			datosProy.append("["+j+"] Proyecto \r\nID : "+proyecto.getId()+
			"\r\nNOMBRE : "+proyecto.getNombre()+"\r\nDIRECCION : "+proyecto.getDireccion()+
			"\r\nCIUDAD: "+proyecto.getCiudadUbicacion()+"\r\nNOMBRE ENCARGADO : "+proyecto.getNombreEncargado()+ 
			"\r\nTOTAL PISOS : "+proyecto.getTotalPisos()+"\r\n\r\n");
			j++;
		}
	}
	private void mostrarEnJTextAreaVendedor(JTextArea datoVendedor,Empresa empresa)
	{
		int j = 1;
		String rut=null;
		for (int i = 0; i < empresa.sizeVendedores(); i++)
		{
			Vendedor vendedores=empresa.obtenerVendedor(rut);
			datoVendedor.append("["+j+"] VENDEDOR \r\nNOMBRE : "+vendedores.getNombre()+
			"\r\nRUT : "+vendedores.getRut()+"\r\nDIRECCION : "+vendedores.getDireccion()+
			"\r\nTELEFONO: "+vendedores.getTelefono()+"\r\nCORREO : "+vendedores.getCorreo()+"\r\n\r\n");
			j++;
			rut=vendedores.getRut();
		}
	}
	private void mostrarEnJTextAreaAdministrador(JTextArea datoAdministrador,Empresa empresa)
	{
		int j = 1;
		String rut=null;
		for (int i = 0; i < empresa.sizeVendedores(); i++)
		{
			Administrador administradores=empresa.obtenerAdministrador(rut);
			datoAdministrador.append("["+j+"] VENDEDOR \r\nNOMBRE : "+administradores.getNombre()+
			"\r\nRut : "+administradores.getRut()+"\r\nDIRECCION : "+administradores.getDireccion()+
			"\r\nTELEFONO: "+administradores.getTelefono()+"\r\nCORREO : "+administradores.getCorreo()+
			"\r\nCARGO: "+administradores.getCargo()+"\r\n\r\n");
			j++;
			rut=administradores.getRut();
		}
	}
	 

}
		


package Ventanas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.CrearReporteEnExcel;
import Clases.ListaProyectos;

public class VentanaReporte extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaReporte(final ListaProyectos proyectos, final VentanaAdministrador ventanaAnterior) {
	setTitle("Ventana de reporte");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelProy = new JPanel();
		panelProy.setBackground(new Color(51, 204, 153));
		panelProy.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información proyectos registrados :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelProy.setBounds(8, 10, 350, 360);
		contentPane.add(panelProy);
		panelProy.setLayout(null);
		
		final JTextArea datosProy = new JTextArea();
		datosProy.setBounds(1, 1, 338, 331);
		datosProy.setBackground(new Color(255, 255, 255));
		panelProy.add(datosProy);
		datosProy.setLineWrap(true); 
		datosProy.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosProy);
		scrollLateral.setBounds(5, 22, 340, 333);
		panelProy.add(scrollLateral);
		
		//Generar reporte
				mostrarEnJTextArea(datosProy,proyectos);
				
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
		
		
				
				
				
				
				
				//Se crea un .xls con los datos de los proyecto
				JButton btnCrearArchivoXls = new JButton("CREAR ARCHIVO XLS");
				btnCrearArchivoXls.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnCrearArchivoXls.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//implementar despues un JFileChooser para elegir ruta y nombre archivo
						try {
							CrearReporteEnExcel archivoXLS = new CrearReporteEnExcel(proyectos);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				btnCrearArchivoXls.setBounds(8, 376, 137, 23);
				contentPane.add(btnCrearArchivoXls);
			}
		
	//muestra los datos por pantalla
	private void mostrarEnJTextArea(JTextArea datosProy, ListaProyectos proyecto)
	{
		int j = 1;
		
		for (int i = 0; i < proyecto.size(); i++)
		{
			datosProy.append("["+j+"] Proyecto \r\nID : "+proyecto.getPosProyecto(i).getId()+
			"\r\nNOMBRE : "+proyecto.getPosProyecto(i).getNombre()+"\r\nDIRECCION : "+proyecto.getPosProyecto(i).getDireccion()+
			"\r\nCIUDAD: "+proyecto.getPosProyecto(i).getCiudadUbicacion()+"\r\nNOMBRE ENCARGADO : "+proyecto.getPosProyecto(i).getNombreEncargado()+ 
			"\r\nTOTAL PISOS : "+proyecto.getPosProyecto(i).getTotalPisos()+"\r\n\r\n");
			j++;
		}
	}
}
		


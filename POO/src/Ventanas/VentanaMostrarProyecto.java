package Ventanas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.Empresa;
import Clases.Proyecto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMostrarProyecto extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaMostrarProyecto(Empresa empresa,Proyecto proyecto,JFrame ventanaAnt,VentanaBuscarProyecto ventanaAnte) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 401);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(51, 204, 153));
		setForeground(Color.BLACK);
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panelAdministrador = new JPanel();
		panelAdministrador.setBackground(new Color(51, 204, 153));
		panelAdministrador.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información Proyecto :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelAdministrador.setBounds(0, 0, 352, 290);
		contentPane.add(panelAdministrador);
		panelAdministrador.setLayout(new GridLayout());
		
		final JTextArea datosProyecto = new JTextArea();
		datosProyecto.setBackground(new Color(255, 255, 255));
		panelAdministrador.add(datosProyecto);
		datosProyecto.setLineWrap(true); 
		datosProyecto.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosProyecto);
		panelAdministrador.add(scrollLateral);
		
		//Generar reporte
				mostrarEnJTextArea(datosProyecto,proyecto);
				
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(ventanaAnt!=null) {
						dispose();
						ventanaAnt.setVisible(true);
						}
						else
							if(ventanaAnte!=null) {
						dispose();
						ventanaAnte.setVisible(true);
						}
						
					}
				});
				btnVolver.setBounds(127, 318, 89, 23);
				contentPane.add(btnVolver);
	}

	private void mostrarEnJTextArea(JTextArea datosProyecto, Proyecto proyecto)
	{
		
		
		datosProyecto.append(" Proyecto \r\nId :"+proyecto.getId()+
				"\r\nNombre : "+proyecto.getNombre()+
				"\r\nDireccion : "+proyecto.getDireccion()+
				"\r\nCiudad : "+proyecto.getCiudadUbicacion()+
				"\r\nTotal Pisos : "+proyecto.getTotalPisos()+
				"\r\nNombre Encargado : "+proyecto.getNombreEncargado()+"\r\n\r\n");
	}
		
		
		
	
	
	}

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

import Clases.Administrador;
import Clases.CrearPdf;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaMostrarAdmin extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaMostrarAdmin(Administrador admin,VentanaBuscarAdministrador ventanaAnt) {
		
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
		panelAdministrador.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información Administrador :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelAdministrador.setBounds(0, 0, 352, 290);
		contentPane.add(panelAdministrador);
		panelAdministrador.setLayout(new GridLayout());
		
		final JTextArea datosAdministrador = new JTextArea();
		datosAdministrador.setBackground(new Color(255, 255, 255));
		panelAdministrador.add(datosAdministrador);
		datosAdministrador.setLineWrap(true); 
		datosAdministrador.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosAdministrador);
		panelAdministrador.add(scrollLateral);
		
		//Generar reporte
				mostrarEnJTextArea(datosAdministrador,admin);
				
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
				btnVolver.setBackground(SystemColor.controlHighlight);
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						ventanaAnt.setVisible(true);
					}
				});
				btnVolver.setBounds(253, 316, 89, 23);
				contentPane.add(btnVolver);
				
				JButton btnArchivoPdf = new JButton("ARCHIVO PDF");
				btnArchivoPdf.setFont(new Font("Consolas", Font.PLAIN, 13));
				btnArchivoPdf.setBackground(SystemColor.controlHighlight);
				btnArchivoPdf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						new CrearPdf(admin,null);							
							
							}
					
				});
				btnArchivoPdf.setBounds(39, 316, 143, 23);
				contentPane.add(btnArchivoPdf);
	}

	private void mostrarEnJTextArea(JTextArea datosAdministrador, Administrador administrador)
	{
		
		
		
		datosAdministrador.append("Administrador \r\nNombre : "+administrador.getNombre()+
				"\r\nRut : "+administrador.getRut()+"\r\nDireccion : "+administrador.getDireccion()+
				"\r\nTelefono: "+administrador.getTelefono()+"\r\nCorreo : "+administrador.getCorreo()+ 
				"\r\nCargo : "+administrador.getCargo()+"\r\n\r\n");
			
	}
}

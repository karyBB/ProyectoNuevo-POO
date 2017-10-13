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

import Clases.CrearPdf;
import Clases.Vendedor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaMostrarVendedor extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaMostrarVendedor(Vendedor vendedor,VentanaAdminVendedores ventanaAnt) {
		
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
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBackground(new Color(51, 204, 153));
		panelUsuario.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información Usuario :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelUsuario.setBounds(0, 0, 352, 290);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(new GridLayout());
		
		final JTextArea datosUsuario = new JTextArea();
		datosUsuario.setBackground(new Color(255, 255, 255));
		panelUsuario.add(datosUsuario);
		datosUsuario.setLineWrap(true); 
		datosUsuario.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosUsuario);
		panelUsuario.add(scrollLateral);
		
		//Generar reporte
				mostrarEnJTextArea(datosUsuario,vendedor);
				
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.setBackground(SystemColor.controlHighlight);
				btnVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						ventanaAnt.setVisible(true);
					}
				});
				btnVolver.setBounds(231, 316, 89, 23);
				contentPane.add(btnVolver);
				JButton btnArchivoPdf = new JButton("ARCHIVO PDF");
				btnArchivoPdf.setFont(new Font("Consolas", Font.PLAIN, 13));
				btnArchivoPdf.setBackground(SystemColor.controlHighlight);
				btnArchivoPdf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						new CrearPdf(null,vendedor);							
							
							}
					
				});
				btnArchivoPdf.setBounds(39, 316, 143, 23);
				contentPane.add(btnArchivoPdf);
	}

	
	
	
	private void mostrarEnJTextArea(JTextArea datosUsuario, Vendedor vendedor)
	{
			
		datosUsuario.append(" usuario \r\nNombre : "+vendedor.getNombre()+
				"\r\nRut : "+vendedor.getRut()+"\r\nDireccion : "+vendedor.getDireccion()+
				"\r\nTelefono: "+vendedor.getTelefono()+"\r\nCorreo : "+vendedor.getCorreo()+"\r\n\r\n");
			
	}
}


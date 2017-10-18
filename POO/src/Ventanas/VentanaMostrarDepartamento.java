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

import Clases.Departamento;
import Clases.Empresa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMostrarDepartamento extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaMostrarDepartamento(Empresa empresa,Departamento departamento,VentanaDepartamento ventanaAnt) {
		
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
		
		JPanel panelDepartamento = new JPanel();
		panelDepartamento.setBackground(new Color(51, 204, 153));
		panelDepartamento.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información Departamento :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelDepartamento.setBounds(0, 0, 352, 290);
		contentPane.add(panelDepartamento);
		panelDepartamento.setLayout(new GridLayout());
		
		final JTextArea datosDepartamento = new JTextArea();
		datosDepartamento.setBackground(new Color(255, 255, 255));
		panelDepartamento.add(datosDepartamento);
		datosDepartamento.setLineWrap(true); 
		datosDepartamento.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosDepartamento);
		panelDepartamento.add(scrollLateral);
		
		//Generar reporte
				mostrarEnJTextArea(datosDepartamento,departamento);
				
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						ventanaAnt.setVisible(true);
					}
				});
				btnVolver.setBounds(127, 318, 89, 23);
				contentPane.add(btnVolver);
	}

	private void mostrarEnJTextArea(JTextArea datosDepartamento, Departamento departamento)
	{
		
		
		
		datosDepartamento.append("Departamento \r\nNumero : "+departamento.getNumero()+
				"\r\nTamaño : "+departamento.getTamaño()+"\r\nNumero de Habitaciones: "+departamento.getNumeroHabitaciones()+
				"\r\nEstado: "+departamento.isEstado()+"\r\nPrecio : "+departamento.getPrecio()+ 
				"\r\nDescripcion : "+departamento.getDescripcion()+"\r\n\r\n");
			
	}
}

package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Empresa;
import Clases.ListaAdministradores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class VentanaBuscarAdministrador extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBusquedaNom;
	private JTextField textFieldBusquedaRut;
	
	public VentanaBuscarAdministrador(Empresa empresa,String  adminNombre,final VentanaAdministrador ventanaAnterior) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		JLabel lblBienvenido = new JLabel("Administrador "+adminNombre);
		lblBienvenido.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(10, 43, 342, 28);
		contentPane.add(lblBienvenido);
		

		textFieldBusquedaNom = new JTextField();
		textFieldBusquedaNom.setBounds(10, 119, 514, 36);
		contentPane.add(textFieldBusquedaNom);
		textFieldBusquedaNom.setColumns(10);
		

		//boton buscar
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBackground(SystemColor.controlHighlight);
		btnBuscar.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent arg0) 
				{
					
					if(!textFieldBusquedaNom.getText().isEmpty())
					{	
						String nombre = textFieldBusquedaNom.getText();
	
							if(empresa.buscarNombreAdministrador(nombre)!=null) {
							VentanaMostrarAdmin ingreso = new VentanaMostrarAdmin(empresa.buscarNombreAdministrador(nombre),VentanaBuscarAdministrador.this);//interfaz 
							ingreso.setVisible(true);
							setVisible(false);
							}
					}

					if(!textFieldBusquedaRut.getText().isEmpty())
					{	
						String rut = textFieldBusquedaRut.getText();
	
							if(empresa.buscarRutAdministrador(rut)!=null) {
							VentanaMostrarAdmin ingreso = new VentanaMostrarAdmin(empresa.buscarRutAdministrador(rut),VentanaBuscarAdministrador.this);//interfaz 
							ingreso.setVisible(true);
							setVisible(false);
							}
					}
					
				}
			

		
		
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(56, 322, 146, 49);
		contentPane.add(btnBuscar);{
	
		

		//boton volver
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(SystemColor.controlHighlight);
		btnVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		
		});
		btnVolver.setBounds(294, 322, 146, 49);
		contentPane.add(btnVolver);
		
		JLabel lblBusquedaRut = new JLabel("O ingrese rut del Administrador que desea buscar");
		lblBusquedaRut.setForeground(new Color(255, 255, 255));
		lblBusquedaRut.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblBusquedaRut.setBackground(new Color(0, 153, 153));
		lblBusquedaRut.setBounds(100, 150, 338, 58);
		contentPane.add(lblBusquedaRut);
		
		JLabel lblBusquedaNom = new JLabel("Ingrese nombre del Administrador que desea buscar");
		lblBusquedaNom.setForeground(Color.WHITE);
		lblBusquedaNom.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblBusquedaNom.setBackground(new Color(0, 153, 153));
		lblBusquedaNom.setBounds(56, 59, 347, 58);
		contentPane.add(lblBusquedaNom);
		
		textFieldBusquedaRut = new JTextField();
		textFieldBusquedaRut.setColumns(10);
		textFieldBusquedaRut.setBounds(10, 219, 514, 36);
		contentPane.add(textFieldBusquedaRut);
		
		
	}
		

		
	}
}

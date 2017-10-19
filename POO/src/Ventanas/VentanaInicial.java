package Ventanas;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Clases.Administrador;
import Clases.Empresa;
import Clases.Vendedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;


public class VentanaInicial extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	
	private JTextField usuarioField;
	private JPanel contentPane;
	
	
	public VentanaInicial(Empresa empresa) {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(258, 292, 89, 23);
		getContentPane().add(btnNewButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(new Color(0, 153, 153));
		lblUsuario.setBounds(62, 185, 167, 58);
		lblUsuario.setForeground(new Color(0, 153, 153));
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 14));
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(62, 228, 167, 58);
		lblContrasea.setBackground(SystemColor.activeCaptionBorder);
		lblContrasea.setForeground(new Color(0, 153, 153));
		lblContrasea.setFont(new Font("Cambria", Font.PLAIN, 14));
		getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(197, 241, 233, 35);
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setEchoChar('*');
		getContentPane().add(passwordField);
		
		 JPanel paneltipoUsuario = new JPanel();
		paneltipoUsuario.setBackground(new Color(255, 255, 255));
		paneltipoUsuario.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		paneltipoUsuario.setBounds(53, 328, 176, 63);
		contentPane.add(paneltipoUsuario);
		paneltipoUsuario.setLayout(null);
		
		String[] tipoUsuario = {"Administrador","Vendedor"};
		
		final JComboBox comboBoxtipoUsuario = new JComboBox(tipoUsuario);
		comboBoxtipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Vendedor", "Administrador"}));
		comboBoxtipoUsuario.setBounds(61, 27, 105, 25);
		paneltipoUsuario.add(comboBoxtipoUsuario);
		comboBoxtipoUsuario.setFont(new Font("Consolas", Font.PLAIN, 10));
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setBounds(70, -20, 96, 58);
		paneltipoUsuario.add(lblTipoUsuario);
		lblTipoUsuario.setForeground(new Color(0, 153, 153));
		lblTipoUsuario.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblTipoUsuario.setBackground(new Color(0, 153, 153));
		
	//boton ingresar
		JButton Ingesar = new JButton("INGRESAR");
		Ingesar.setBounds(309, 310, 96, 35);
		Ingesar.setFont(new Font("Consolas", Font.PLAIN, 13));
		Ingesar.setBorder(new MatteBorder(20, 1, 20, 1, (Color) new Color(0, 255, 0)));
		Ingesar.setBorderPainted(false);
		Ingesar.setForeground(Color.BLACK);
		Ingesar.setBackground(SystemColor.controlHighlight);
		getContentPane().add(Ingesar);
	
	
		Ingesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tipoUsuario = (String) comboBoxtipoUsuario.getSelectedItem();
				
				
				//SI ES TIPO ADMINISTRADOR
				if(tipoUsuario.equals("Administrador"))
				{
	
					 empresa.buscarNombreAdministrador(usuarioField.getText());
					if(empresa.buscarNombreAdministrador(usuarioField.getText())==null)
						JOptionPane.showMessageDialog(VentanaInicial.this,"administrador no existe","Error",0);
					
					//verifica que la contraseña ingresada es valida
					else if(empresa.buscarAdministradores(usuarioField.getText(),passwordField.getText()) != null)
						{
						Administrador Admin = empresa.obtenerAdministrador(usuarioField.getText(),passwordField);
						JOptionPane.showMessageDialog(VentanaInicial.this,"Se inició sesión correctamente");
						//creo la ventanaAdministrador
						VentanaAdministrador ventanaAdministrador = new VentanaAdministrador(empresa, Admin,VentanaInicial.this);
						ventanaAdministrador.setVisible(true);
						dispose();
						//Dejar en blanco los campos de rut y contraseña
						usuarioField.setText("");
						passwordField.setText("");
						}
						else 
							JOptionPane.showMessageDialog(VentanaInicial.this,"Contraseña incorrecta","Error",0);
				}	
				
				//SI ES TIPO Vendedor
				if(tipoUsuario.equals("Vendedor"))
				{	
					
					empresa.buscarNombreVendedor(usuarioField.getText());
					if(empresa.buscarNombreVendedor(usuarioField.getText())==null)
						JOptionPane.showMessageDialog(VentanaInicial.this,"vendedor no existe","Error",0);
						//verifica que la contraseña ingresada es valida
					//verificacion con nombre y clave
					else if(empresa.buscarVendedor(usuarioField.getText(),passwordField.getText()) != null)
					{
						Vendedor user = empresa.obtenerVendedor(usuarioField.getText(),passwordField); 
								JOptionPane.showMessageDialog(VentanaInicial.this,"Se inició sesión correctamente");		
								VentanaVendedor ventanauser = new VentanaVendedor(empresa,user,VentanaInicial.this);
								ventanauser.setVisible(true);
								dispose();
								//Dejar en blanco los campos de rut y contraseña
								usuarioField.setText("");
								passwordField.setText("");
					}
							else 
								JOptionPane.showMessageDialog(VentanaInicial.this,"Contraseña incorrecta","Error",0);
				}
				
		}});
		
	//boton salir 
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(309, 356, 96, 35);
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(new MatteBorder(20, 1, 20, 1, (Color) new Color(0, 255, 0)));
		btnSalir.setBackground(SystemColor.controlHighlight);
		getContentPane().add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\usuario\\Documents\\proyectos\\workspace\\POO\\imagenes\\logito.PNG"));
		lblNewLabel.setBounds(107, 11, 455, 145);
		getContentPane().add(lblNewLabel);
		
		usuarioField = new JTextField();
		usuarioField.setBackground(SystemColor.controlHighlight);
		usuarioField.setBounds(197, 198, 233, 35);
		getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		
		

	}
}

package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Empresa;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class VentanaAgregarVendedor extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldRut;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldClave;


	
	public VentanaAgregarVendedor(Empresa empresa,VentanaAdministrador ventanaAnterior) {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarVendedor = new JLabel("Agregar Vendedor");
		lblAgregarVendedor.setForeground(new Color(255, 255, 255));
		lblAgregarVendedor.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblAgregarVendedor.setBounds(200, 11, 133, 26);
		contentPane.add(lblAgregarVendedor);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(86, 48, 438, 20);
		contentPane.add(textFieldNombre);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombre.setBackground(new Color(0, 153, 153));
		labelNombre.setBounds(10, 33, 66, 49);
		contentPane.add(labelNombre);
		
		textFieldRut = new JTextField();
		textFieldRut.setColumns(10);
		textFieldRut.setBounds(86, 95, 181, 20);
		contentPane.add(textFieldRut);
		
		JLabel labelRut = new JLabel("RUT:");
		labelRut.setForeground(Color.WHITE);
		labelRut.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelRut.setBackground(new Color(0, 153, 153));
		labelRut.setBounds(10, 80, 66, 49);
		contentPane.add(labelRut);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(86, 141, 438, 20);
		contentPane.add(textFieldCorreo);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(86, 186, 181, 20);
		contentPane.add(textFieldTelefono);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(86, 227, 438, 20);
		contentPane.add(textFieldDireccion);
		
		//agregar a un vendedor
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.controlHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//si los campos de texto estan vacios
				if(!textFieldNombre.getText().isEmpty() && !textFieldRut.getText().isEmpty()
						&& !textFieldCorreo.getText().isEmpty()
						&& !textFieldTelefono.getText().isEmpty()&& !textFieldDireccion.getText().isEmpty())
				{
					
						empresa.crearVendedor(textFieldNombre.getText(), textFieldRut.getText(), textFieldDireccion.getText(), textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldClave.getText());
						empresa.agregarVendedor(empresa.crearVendedor(textFieldNombre.getText(), textFieldRut.getText(), textFieldDireccion.getText(), textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldClave.getText()));		
				        
						
						JOptionPane.showMessageDialog(VentanaAgregarVendedor.this,"Su contraseña es\n"+
								textFieldClave.getText(),"Datos ingresados correctamente",1);
					
				    	
				}else{			
					
					JOptionPane.showMessageDialog(VentanaAgregarVendedor.this,"Ingresó mal algun campo","Error",0);
				}
				textFieldNombre.setEditable(false);
				textFieldRut.setEditable(false);
				textFieldCorreo.setEditable(false);
				textFieldDireccion.setEditable(false);
				textFieldTelefono.setEditable(false);	
				
			}
		});
		btnAgregar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregar.setBounds(50, 340, 146, 49);
		contentPane.add(btnAgregar);
		
		JButton button = new JButton("VOLVER");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					ventanaAnterior.setVisible(true);	
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(322, 340, 146, 49);
		contentPane.add(button);
		
		JLabel labelCorreo = new JLabel("Correo:");
		labelCorreo.setForeground(Color.WHITE);
		labelCorreo.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelCorreo.setBackground(new Color(0, 153, 153));
		labelCorreo.setBounds(10, 126, 66, 49);
		contentPane.add(labelCorreo);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setForeground(Color.WHITE);
		labelTelefono.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelTelefono.setBackground(new Color(0, 153, 153));
		labelTelefono.setBounds(10, 171, 66, 49);
		contentPane.add(labelTelefono);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelDireccion.setBackground(new Color(0, 153, 153));
		labelDireccion.setBounds(10, 212, 66, 49);
		contentPane.add(labelDireccion);
		
		textFieldClave = new JTextField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(86, 266, 438, 20);
		contentPane.add(textFieldClave);
		
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setForeground(Color.WHITE);
		lblClave.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblClave.setBackground(new Color(0, 153, 153));
		lblClave.setBounds(10, 251, 66, 49);
		contentPane.add(lblClave);
		
		
		
		
	}
}

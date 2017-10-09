package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Empresa;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaAgregarAdministrador extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldRut;
	private JTextField textFieldCargo;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldClave;

	
	public VentanaAgregarAdministrador(Empresa empresa,Administrador admin,final VentanaAdministrador ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarAdministradr = new JLabel("Agregar Administrador");
		lblAgregarAdministradr.setForeground(new Color(255, 255, 255));
		lblAgregarAdministradr.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblAgregarAdministradr.setBounds(174, 11, 176, 26);
		contentPane.add(lblAgregarAdministradr);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(86, 48, 438, 20);
		contentPane.add(textFieldNombre);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombre.setBackground(new Color(0, 153, 153));
		labelNombre.setBounds(20, 35, 66, 49);
		contentPane.add(labelNombre);
		
		textFieldRut = new JTextField();
		textFieldRut.setColumns(10);
		textFieldRut.setBounds(86, 95, 181, 20);
		contentPane.add(textFieldRut);
		
		JLabel labelRut = new JLabel("RUT:");
		labelRut.setForeground(Color.WHITE);
		labelRut.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelRut.setBackground(new Color(0, 153, 153));
		labelRut.setBounds(20, 80, 66, 49);
		contentPane.add(labelRut);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(86, 140, 438, 20);
		contentPane.add(textFieldCargo);
		
		JLabel labelCargo = new JLabel("Cargo:");
		labelCargo.setForeground(Color.WHITE);
		labelCargo.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelCargo.setBackground(new Color(0, 153, 153));
		labelCargo.setBounds(20, 126, 66, 49);
		contentPane.add(labelCargo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(86, 186, 438, 20);
		contentPane.add(textFieldCorreo);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(86, 229, 181, 20);
		contentPane.add(textFieldTelefono);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(86, 270, 438, 20);
		contentPane.add(textFieldDireccion);
		
		
	//agregar a un administrador
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.controlHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//validacion de rut, correo, telefono y campos vacios
				if(!textFieldNombre.getText().isEmpty() && !textFieldRut.getText().isEmpty()
						&& !textFieldCorreo.getText().isEmpty()
						&& !textFieldTelefono.getText().isEmpty()&& !textFieldDireccion.getText().isEmpty())
				{
				if(empresa.esNumerico(textFieldRut.getText()))
				{
				if(empresa.verificarEmail(textFieldCorreo.getText()))
				{
				if(empresa.verificarTelefono(textFieldTelefono.getText()))
					{
					//Se agrega el administrador
					empresa.agregarVendedor(empresa.crearVendedor(textFieldNombre.getText(), textFieldRut.getText(), textFieldDireccion.getText(), textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldClave.getText()));		
				      
					JOptionPane.showMessageDialog(VentanaAgregarAdministrador.this,"Su contraseña es\n"+
							textFieldClave.getText(),"Datos ingresados correctamente",1);
					textFieldNombre.setEditable(false);
					textFieldRut.setEditable(false);
					textFieldCorreo.setEditable(false);
					textFieldCargo.setEditable(false);
					textFieldDireccion.setEditable(false);
					textFieldTelefono.setEditable(false);
					}
				else
					JOptionPane.showMessageDialog(VentanaAgregarAdministrador.this,"Ingresó mal el telefono","Error",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarAdministrador.this,"Ingresó mal el correo","Error",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarAdministrador.this,"Ingresó mal el rut","Error",0);   	
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarAdministrador.this,"Ingresó mal algun campo","Error",0);
				

			}
		});
		btnAgregar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregar.setBounds(50, 340, 146, 49);
		contentPane.add(btnAgregar);
		//boton volver
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(SystemColor.controlHighlight);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnVolver.setBounds(323, 340, 146, 49);
		contentPane.add(btnVolver);
		
		JLabel labelCorreo = new JLabel("Correo:");
		labelCorreo.setForeground(Color.WHITE);
		labelCorreo.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelCorreo.setBackground(new Color(0, 153, 153));
		labelCorreo.setBounds(20, 169, 66, 49);
		contentPane.add(labelCorreo);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setForeground(Color.WHITE);
		labelTelefono.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelTelefono.setBackground(new Color(0, 153, 153));
		labelTelefono.setBounds(20, 210, 66, 49);
		contentPane.add(labelTelefono);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelDireccion.setBackground(new Color(0, 153, 153));
		labelDireccion.setBounds(20, 255, 66, 49);
		contentPane.add(labelDireccion);
		
		textFieldClave = new JTextField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(86, 309, 438, 20);
		contentPane.add(textFieldClave);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setForeground(Color.WHITE);
		lblClave.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblClave.setBackground(new Color(0, 153, 153));
		lblClave.setBounds(20, 295, 66, 49);
		contentPane.add(lblClave);
	}
}

package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Empresa;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaModificarAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCargo;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldClave;

	public VentanaModificarAdministrador(Empresa empresa,Administrador admin,final VentanaAdministrador ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblNombre.setBackground(new Color(0, 153, 153));
		lblNombre.setBounds(10, 36, 66, 49);
		contentPane.add(lblNombre);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Color.WHITE);
		lblCargo.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblCargo.setBackground(new Color(0, 153, 153));
		lblCargo.setBounds(10, 128, 66, 49);
		contentPane.add(lblCargo);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblCorreo.setBackground(new Color(0, 153, 153));
		lblCorreo.setBounds(10, 174, 66, 49);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblTelefono.setBackground(new Color(0, 153, 153));
		lblTelefono.setBounds(10, 83, 66, 49);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblDireccin.setBackground(new Color(0, 153, 153));
		lblDireccin.setBounds(10, 216, 66, 49);
		contentPane.add(lblDireccin);
		
		textFieldNombre = new JTextField(admin.getNombre());
		textFieldNombre.setBounds(86, 51, 438, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCargo = new JTextField(admin.getCargo());
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(86, 143, 438, 20);
		contentPane.add(textFieldCargo);
		
		textFieldCorreo = new JTextField(admin.getCorreo());
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(86, 189, 438, 20);
		contentPane.add(textFieldCorreo);
		
		textFieldTelefono = new JTextField(admin.getTelefono());
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(86, 98, 181, 20);
		contentPane.add(textFieldTelefono);
		
		textFieldDireccion = new JTextField(admin.getDireccion());
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(86, 231, 438, 20);
		contentPane.add(textFieldDireccion);
		
		//boton modificar
		JButton button = new JButton("MODIFICAR");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(!textFieldNombre.getText().isEmpty())
					empresa.modificarNombreAdministrador(admin, textFieldNombre.getText());
				
				if(!textFieldDireccion.getText().isEmpty())
					empresa.modificarDireccionAdministrador(admin, textFieldDireccion.getText());
	
				if(!textFieldCorreo.getText().isEmpty())
				{
					if(admin.verificarEmail(textFieldCorreo.getText()))
					empresa.modificarCorreoAdministrador(admin, textFieldCorreo.getText());
					else
						JOptionPane.showMessageDialog(VentanaModificarAdministrador.this,"Ingresó mal el correo","Error",0);
				}
				if(!textFieldTelefono.getText().isEmpty())
				{
					if(admin.verificarTelefono(textFieldTelefono.getText()))
						empresa.modificarTelefonoAdministrador(admin, textFieldTelefono.getText());
					else
						JOptionPane.showMessageDialog(VentanaModificarAdministrador.this,"Ingresó mal el telefono","Error",0);
					
				}
				if(!textFieldClave.getText().isEmpty())
					empresa.modificarClaveAdministrador(admin, textFieldCorreo.getText());

			}
			});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(63, 337, 146, 49);
		contentPane.add(button);
		
		//boton volver
		JButton button_1 = new JButton("VOLVER");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		button_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_1.setBounds(311, 337, 146, 49);
		contentPane.add(button_1);
		
		JLabel lblModificarAdministrador = new JLabel("Modificar Administrador");
		lblModificarAdministrador.setForeground(Color.WHITE);
		lblModificarAdministrador.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblModificarAdministrador.setBounds(175, 11, 181, 26);
		contentPane.add(lblModificarAdministrador);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblClave.setForeground(SystemColor.textHighlightText);
		lblClave.setBounds(10, 276, 56, 20);
		contentPane.add(lblClave);
		
		textFieldClave = new JTextField();
		textFieldClave.setBounds(86, 275, 86, 20);
		contentPane.add(textFieldClave);
		textFieldClave.setColumns(10);
	}
}

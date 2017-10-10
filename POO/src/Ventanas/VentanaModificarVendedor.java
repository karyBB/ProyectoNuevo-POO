package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Empresa;
import Clases.Vendedor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaModificarVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldClave;

	
	
	public VentanaModificarVendedor(Empresa empresa,Vendedor vendedor, VentanaVendedor ventanaAnterior,VentanaAdminVendedores ventana) {
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
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblCorreo.setBackground(new Color(0, 153, 153));
		lblCorreo.setBounds(10, 124, 66, 49);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblTelefono.setBackground(new Color(0, 153, 153));
		lblTelefono.setBounds(10, 174, 66, 49);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblDireccion.setBackground(new Color(0, 153, 153));
		lblDireccion.setBounds(10, 83, 66, 49);
		contentPane.add(lblDireccion);
		
		textFieldNombre = new JTextField(vendedor.getNombre());
		textFieldNombre.setBounds(86, 51, 438, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCorreo = new JTextField(vendedor.getCorreo());
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(86, 139, 438, 20);
		contentPane.add(textFieldCorreo);
		
		textFieldTelefono = new JTextField(vendedor.getTelefono());
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(86, 189, 181, 20);
		contentPane.add(textFieldTelefono);
		
		textFieldDireccion = new JTextField(vendedor.getDireccion());
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(86, 98, 438, 20);
		contentPane.add(textFieldDireccion);
		
		JButton button = new JButton("MODIFICAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				if(!textFieldNombre.getText().isEmpty())
					empresa.modificarNombreVendedor(vendedor,textFieldNombre.getText());

				if(!textFieldDireccion.getText().isEmpty())
					empresa.modificarDireccionVendedor(vendedor, textFieldDireccion.getText());

				if(!textFieldCorreo.getText().isEmpty())
				{
					if(vendedor.verificarEmail(textFieldCorreo.getText()))
						empresa.modificarCorreoVendedor(vendedor, textFieldCorreo.getText());
					else
						JOptionPane.showMessageDialog(VentanaModificarVendedor.this,"Ingresó mal el correo","Error",0);
				}
				
				if(!textFieldTelefono.getText().isEmpty())
				{
					if(vendedor.verificarTelefono(textFieldTelefono.getText()))
						empresa.modificarTelefonoVendedor(vendedor, textFieldTelefono.getText());
					else
						JOptionPane.showMessageDialog(VentanaModificarVendedor.this,"Ingresó mal algun campo","Error",0);

				}
				
				if(!textFieldClave.getText().isEmpty())
					empresa.modificarTelefonoVendedor(vendedor, textFieldClave.getText());
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(63, 337, 146, 49);
		contentPane.add(button);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ventana==null) {
					dispose();
					ventanaAnterior.setVisible(true);
				}
				else {
					dispose();
					ventana.setVisible(true);
				}
			}
		});
		BotonVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
		BotonVolver.setBounds(311, 337, 146, 49);
		contentPane.add(BotonVolver);
		
		JLabel lblModificarVendedor = new JLabel("Modificar Vendedor "+vendedor.getRut());
		lblModificarVendedor.setForeground(Color.WHITE);
		lblModificarVendedor.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblModificarVendedor.setBounds(203, 11, 289, 26);
		contentPane.add(lblModificarVendedor);
		
		textFieldClave = new JTextField();
		textFieldClave.setBounds(86, 242, 86, 20);
		contentPane.add(textFieldClave);
		textFieldClave.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblClave.setForeground(new Color(255, 255, 255));
		lblClave.setBounds(10, 244, 46, 14);
		contentPane.add(lblClave);
	}

	

}

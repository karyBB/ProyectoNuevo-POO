package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Empresa;
import Clases.Proyecto;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaAgregarProyecto extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textCantidadDept;
	private JTextField textFieldNombreEnc;
	private JTextField textFieldDireccion;
	private JTextField textFieldNombre;
	private JTextField textFieldCiudad;
	private JTextField textFieldNpisos;

	
	public VentanaAgregarProyecto(Empresa empresa,Administrador admin, VentanaAdministrador ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarProyecto = new JLabel("Agregar Proyecto");
		lblAgregarProyecto.setForeground(new Color(255, 255, 255));
		lblAgregarProyecto.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblAgregarProyecto.setBounds(200, 11, 133, 26);
		contentPane.add(lblAgregarProyecto);
		
		textCantidadDept = new JTextField();
		textCantidadDept.setColumns(10);
		textCantidadDept.setBounds(176, 68, 66, 20);
		contentPane.add(textCantidadDept);
		
		JLabel lblId = new JLabel("Cantidad Departamentos:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblId.setBackground(new Color(0, 153, 153));
		lblId.setBounds(10, 53, 156, 49);
		contentPane.add(lblId);
		
		textFieldNombreEnc = new JTextField();
		textFieldNombreEnc.setColumns(10);
		textFieldNombreEnc.setBounds(138, 248, 365, 20);
		contentPane.add(textFieldNombreEnc);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.controlHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validaciones de numero de pisos, cantidad de departamentos y campos vacios
				if(!textCantidadDept.getText().isEmpty() && !textFieldNombre.getText().isEmpty()
						&& !textFieldDireccion.getText().isEmpty() && !textFieldCiudad.getText().isEmpty()
						&& !textFieldNpisos.getText().isEmpty()&& !textFieldNombreEnc.getText().isEmpty())
				{
				if(admin.esNumerico(textFieldNpisos.getText()))
				{
				if(admin.esNumerico(textCantidadDept.getText()))
				{
				Proyecto proyNuevo=empresa.crearProyecto(empresa.generarId(),textFieldNombre.getText(),textFieldDireccion.getText(),
				textFieldCiudad.getText(),textFieldNombreEnc.getText(),Integer.parseInt(textFieldNpisos.getText())
				,Integer.parseInt(textCantidadDept.getText()));
				
				empresa.agregarProyecto(proyNuevo);
				
				
				JOptionPane.showMessageDialog(VentanaAgregarProyecto.this,"El proyecto\n"+
						proyNuevo.getId(),"a sido ingresado correctamente",1);
				
				JOptionPane.showMessageDialog(VentanaAgregarProyecto.this,"Ingrese datos Departamento para el proyecto\n"+
						proyNuevo.getId(),"Departamentos",1);
				
			    
			    VentanaAgregarDepartamento ventana= new VentanaAgregarDepartamento(empresa,proyNuevo,VentanaAgregarProyecto.this);
			    ventana.setVisible(true);
			    textCantidadDept.setEditable(false);
				textFieldNombre.setEditable(false);
				textFieldDireccion.setEditable(false);
				textFieldCiudad.setEditable(false);
				textFieldNombreEnc.setEditable(false);
				textFieldNpisos.setEditable(false);	
				}
				else		
					JOptionPane.showMessageDialog(VentanaAgregarProyecto.this,"Ingresó mal la cantidad de departamentos","Error",0);
				}
				else		
					JOptionPane.showMessageDialog(VentanaAgregarProyecto.this,"Ingresó mal el numero de pisos","Error",0);	
				}
				else		
					JOptionPane.showMessageDialog(VentanaAgregarProyecto.this,"Ingresó mal algun campo","Error",0);
				
				dispose();
				ventanaAnterior.setVisible(true);
			}
			
			
		});


		btnAgregar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregar.setBounds(50, 322, 146, 49);
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
		button.setBounds(322, 322, 146, 49);
		contentPane.add(button);
		
		JLabel lblNombreEncargado = new JLabel("Nombre Encargado:");
		lblNombreEncargado.setForeground(Color.WHITE);
		lblNombreEncargado.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblNombreEncargado.setBackground(new Color(0, 153, 153));
		lblNombreEncargado.setBounds(10, 233, 133, 49);
		contentPane.add(lblNombreEncargado);
		
		JLabel lblUbicacin = new JLabel("Nombre:");
		lblUbicacin.setForeground(Color.WHITE);
		lblUbicacin.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblUbicacin.setBackground(new Color(0, 153, 153));
		lblUbicacin.setBounds(10, 96, 66, 49);
		contentPane.add(lblUbicacin);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblDireccion.setBackground(new Color(0, 153, 153));
		lblDireccion.setBounds(10, 139, 66, 49);
		contentPane.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblCiudad.setBackground(new Color(0, 153, 153));
		lblCiudad.setBounds(10, 185, 66, 49);
		contentPane.add(lblCiudad);
		
		JLabel lblTotaldePisos = new JLabel("N\u00B0 de Pisos:");
		lblTotaldePisos.setForeground(Color.WHITE);
		lblTotaldePisos.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblTotaldePisos.setBackground(new Color(0, 153, 153));
		lblTotaldePisos.setBounds(324, 53, 97, 49);
		contentPane.add(lblTotaldePisos);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(86, 154, 418, 20);
		contentPane.add(textFieldDireccion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(86, 111, 418, 20);
		contentPane.add(textFieldNombre);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(86, 200, 418, 20);
		contentPane.add(textFieldCiudad);
		
		textFieldNpisos = new JTextField();
		textFieldNpisos.setColumns(10);
		textFieldNpisos.setBounds(406, 68, 97, 20);
		contentPane.add(textFieldNpisos);
	}
}

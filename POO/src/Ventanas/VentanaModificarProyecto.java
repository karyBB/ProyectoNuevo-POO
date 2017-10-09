package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class VentanaModificarProyecto extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldCiudad;
	private JTextField textFieldNomEnc;

	
	public VentanaModificarProyecto (Empresa empresa,Proyecto proyecto ,final JFrame ventanaAnterior ){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarProyecto = new JLabel("Modificar Proyecto");
		lblAgregarProyecto.setForeground(new Color(255, 255, 255));
		lblAgregarProyecto.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblAgregarProyecto.setBounds(189, 11, 172, 26);
		contentPane.add(lblAgregarProyecto);
		
		JButton btnAgregar = new JButton("MODIFICAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNombre.getText().isEmpty())
				{
					empresa.modificarNombreProyecto(proyecto, textFieldNombre.getText());
				}
				if(!textFieldDireccion.getText().isEmpty())
				{
					empresa.modificarDireccionProyecto(proyecto,textFieldDireccion.getText() );
				}
				if(!textFieldCiudad.getText().isEmpty())
				{
					empresa.modificarCiudadProyecto(proyecto, textFieldCiudad.getText());
				}
				if(!textFieldNomEnc.getText().isEmpty())
				{
					empresa.modificarNombreEncProyecto(proyecto,textFieldNomEnc.getText());
				}
				JOptionPane.showMessageDialog(VentanaModificarProyecto.this,"Proyecto\n"+
						proyecto.getNombre()+"datos han sido modificados","DATOS MODIFICADOS",1);
					
			}
		});
		btnAgregar.setBackground(SystemColor.controlHighlight);
		btnAgregar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregar.setBounds(49, 335, 146, 49);
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
		button.setBounds(322, 335, 146, 49);
		contentPane.add(button);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombre.setBackground(new Color(0, 153, 153));
		labelNombre.setBounds(10, 102, 66, 49);
		contentPane.add(labelNombre);
		
		JLabel labelDireccion = new JLabel("Direccion:");
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelDireccion.setBackground(new Color(0, 153, 153));
		labelDireccion.setBounds(10, 146, 66, 49);
		contentPane.add(labelDireccion);
		
		JLabel labelCiudad = new JLabel("Ciudad:");
		labelCiudad.setForeground(Color.WHITE);
		labelCiudad.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelCiudad.setBackground(new Color(0, 153, 153));
		labelCiudad.setBounds(10, 193, 66, 49);
		contentPane.add(labelCiudad);
		
		JLabel labelNombreEncargado = new JLabel("Nombre Encargado:");
		labelNombreEncargado.setForeground(Color.WHITE);
		labelNombreEncargado.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombreEncargado.setBackground(new Color(0, 153, 153));
		labelNombreEncargado.setBounds(10, 237, 133, 49);
		contentPane.add(labelNombreEncargado);
		
		textFieldNombre = new JTextField(proyecto.getNombre());
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(75, 117, 416, 20);
		contentPane.add(textFieldNombre);
		
		textFieldDireccion = new JTextField(proyecto.getDireccion());
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(75, 162, 416, 20);
		contentPane.add(textFieldDireccion);
		
		textFieldCiudad = new JTextField(proyecto.getCiudadUbicacion());
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(75, 206, 416, 20);
		contentPane.add(textFieldCiudad);
		
		textFieldNomEnc = new JTextField(proyecto.getNombreEncargado());
		textFieldNomEnc.setColumns(10);
		textFieldNomEnc.setBounds(139, 252, 352, 20);
		contentPane.add(textFieldNomEnc);
	}



	}


package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.Departamento;
import Clases.Empresa;
import Clases.Proyecto;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class VentanaAgregarDepartamento extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNumHabitaciones;
	private JTextField textFieldPrecio;
	private JTextField textFieldTamanno;

	
	public VentanaAgregarDepartamento(Empresa empresa,Proyecto proy, VentanaAgregarProyecto ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(88, 178, 299, 88);
		contentPane.add(textAreaDescripcion);
		
		JLabel lblAgregarDepartamento = new JLabel("Agregar Departamento");
		lblAgregarDepartamento.setForeground(new Color(255, 255, 255));
		lblAgregarDepartamento.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblAgregarDepartamento.setBounds(181, 11, 175, 26);
		contentPane.add(lblAgregarDepartamento);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(SystemColor.controlHighlight);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//validaciones de precio, tamaño, numero de habitaciones y campos vacios 
				if(!textFieldTamanno.getText().isEmpty()
						&& !textFieldNumHabitaciones.getText().isEmpty() && !textFieldPrecio.getText().isEmpty()
						&& !textAreaDescripcion.getText().isEmpty())
				{
				if(empresa.esNumerico(textFieldPrecio.getText()))
				{
				if(empresa.esNumerico(textFieldNumHabitaciones.getText()))
				{
				if(empresa.esNumerico(textFieldTamanno.getText()))
				{
					Departamento deptNuevo = new Departamento("0",textFieldTamanno.getText(),
						Integer.parseInt(textFieldNumHabitaciones.getText()),rootPaneCheckingEnabled, Integer.parseInt(textFieldPrecio.getText()),
						textAreaDescripcion.getText());
					
					//se generan los departamentos
					proy.getListaDepartamentos().generarDepartamentos(deptNuevo,proy.getTotaldepartamentos(),proy.getTotalPisos()
							,proy.getId());
					
					JOptionPane.showMessageDialog(VentanaAgregarDepartamento.this,"El departamento\n"+
							deptNuevo.getNumero(),"han sido creado correctamente los departamentos",1);
					textFieldNumHabitaciones.setEditable(false);
					textFieldPrecio.setEditable(false);
					textAreaDescripcion.setEditable(false);
					textFieldTamanno.setEditable(false);
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarDepartamento.this,"Ingresó mal el tamaño","Error",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarDepartamento.this,"Ingresó mal el numero de habitaciones","Error",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaAgregarDepartamento.this,"Ingresó mal el precio","Error",0);			
				}
				else			
					JOptionPane.showMessageDialog(VentanaAgregarDepartamento.this,"Ingresó mal algun campo","Error",0);
	
			}
			
			
		});

		


		btnAgregar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregar.setBounds(323, 335, 146, 49);
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
		button.setBounds(86, 335, 146, 49);
		contentPane.add(button);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblDescripcion.setBackground(new Color(0, 153, 153));
		lblDescripcion.setBounds(10, 165, 133, 49);
		contentPane.add(lblDescripcion);
		
		JLabel lblNumHabitaciones = new JLabel("N\u00FAmero habitaciones:");
		lblNumHabitaciones.setForeground(Color.WHITE);
		lblNumHabitaciones.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblNumHabitaciones.setBackground(new Color(0, 153, 153));
		lblNumHabitaciones.setBounds(10, 126, 146, 49);
		contentPane.add(lblNumHabitaciones);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblPrecio.setBackground(new Color(0, 153, 153));
		lblPrecio.setBounds(240, 126, 66, 49);
		contentPane.add(lblPrecio);
		
		 JPanel paneltipoEstado = new JPanel();
			paneltipoEstado.setBackground(new Color(0, 102, 102));
			paneltipoEstado.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			paneltipoEstado.setBounds(278, 48, 176, 63);
			contentPane.add(paneltipoEstado);
			paneltipoEstado.setLayout(null);
			
			String[] tipoEstado = {"Libre","Ocupado"};
			
			final JComboBox comboBoxtipoEstado = new JComboBox(tipoEstado);
			comboBoxtipoEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado"}));
			comboBoxtipoEstado.setBounds(61, 27, 105, 25);
			paneltipoEstado.add(comboBoxtipoEstado);
			comboBoxtipoEstado.setFont(new Font("Consolas", Font.PLAIN, 10));
			
			JLabel lblNewLabel = new JLabel("Estado");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 2, 59, 14);
			paneltipoEstado.add(lblNewLabel);
			
		JLabel lblTamano = new JLabel("Tama\u00F1o:");
		lblTamano.setForeground(Color.WHITE);
		lblTamano.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblTamano.setBackground(new Color(0, 153, 153));
		lblTamano.setBounds(10, 77, 97, 49);
		contentPane.add(lblTamano);
		
		textFieldNumHabitaciones = new JTextField();
		textFieldNumHabitaciones.setColumns(10);
		textFieldNumHabitaciones.setBounds(166, 141, 44, 20);
		contentPane.add(textFieldNumHabitaciones);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(292, 141, 132, 20);
		contentPane.add(textFieldPrecio);
		
		textFieldTamanno = new JTextField();
		textFieldTamanno.setColumns(10);
		textFieldTamanno.setBounds(73, 92, 175, 20);
		contentPane.add(textFieldTamanno);
		
		
	}
}


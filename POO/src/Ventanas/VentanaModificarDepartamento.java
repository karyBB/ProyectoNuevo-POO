package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.Departamento;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaModificarDepartamento extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldPrecio;
	private JTextField textFieldDescripcion;

	
	public VentanaModificarDepartamento (Departamento departamento ,final VentanaDepartamento ventanaDepartamento ){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Modificar Depatamento");
		lblDepartamento.setForeground(new Color(255, 255, 255));
		lblDepartamento.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblDepartamento.setBounds(122, 11, 172, 26);
		contentPane.add(lblDepartamento);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnModificar.setBackground(SystemColor.controlHighlight);
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnModificar.setBounds(49, 335, 146, 49);
		contentPane.add(btnModificar);
		
		JButton button = new JButton("VOLVER");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaDepartamento.setVisible(true);
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(240, 335, 146, 49);
		contentPane.add(button);
		
		JLabel labelNombre = new JLabel("Precio:");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombre.setBackground(new Color(0, 153, 153));
		labelNombre.setBounds(10, 66, 66, 49);
		contentPane.add(labelNombre);

		 JPanel paneltipoEstado = new JPanel();
			paneltipoEstado.setBackground(new Color(0, 102, 102));
			paneltipoEstado.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			paneltipoEstado.setBounds(10, 126, 176, 63);
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
		
		JLabel labelNombreEncargado = new JLabel("Descripcion:");
		labelNombreEncargado.setForeground(Color.WHITE);
		labelNombreEncargado.setFont(new Font("Cambria", Font.PLAIN, 14));
		labelNombreEncargado.setBackground(new Color(0, 153, 153));
		labelNombreEncargado.setBounds(10, 189, 133, 49);
		contentPane.add(labelNombreEncargado);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(75, 81, 416, 20);
		contentPane.add(textFieldPrecio);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(10, 240, 376, 56);
		contentPane.add(textFieldDescripcion);
	}



	}
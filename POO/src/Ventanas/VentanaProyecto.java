package Ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Empresa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class VentanaProyecto extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;


	public VentanaProyecto(Empresa empresa, VentanaAdministrador ventanaAdministrador, boolean b, VentanaAdministrador ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonAgregarProyecto = new JButton("AGREGAR PROYECTO");
		BotonAgregarProyecto.setBackground(SystemColor.controlHighlight);
		BotonAgregarProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		BotonAgregarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			VentanaAgregarProyecto ingreso = new VentanaAgregarProyecto(empresa,VentanaProyecto.this,false, VentanaProyecto.this);//interfaz 
			ingreso.setVisible(true);
			}
		});
		BotonAgregarProyecto.setBounds(10, 93, 253, 37);
		contentPane.add(BotonAgregarProyecto);
		
		JLabel lblMenProyectos = new JLabel("Men\u00FA Proyectos");
		lblMenProyectos.setForeground(Color.WHITE);
		lblMenProyectos.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblMenProyectos.setBounds(59, 11, 147, 47);
		contentPane.add(lblMenProyectos);
		
		//btn buscar
		JButton btnBuscarProyecto = new JButton("BUSCAR PROYECTO");
		btnBuscarProyecto.setBackground(SystemColor.controlHighlight);
		btnBuscarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
	             VentanaBuscarProyecto buscar = new VentanaBuscarProyecto(empresa, VentanaProyecto.this);     
	             buscar.setVisible(true);
			}
		});
		btnBuscarProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscarProyecto.setBounds(10, 184, 253, 35);
		contentPane.add(btnBuscarProyecto);
		
		JButton BtnVolver = new JButton("VOLVER");
		BtnVolver.setBackground(SystemColor.controlHighlight);
		BtnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		BtnVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
		BtnVolver.setBounds(59, 299, 156, 47);
		contentPane.add(BtnVolver);
	}
}

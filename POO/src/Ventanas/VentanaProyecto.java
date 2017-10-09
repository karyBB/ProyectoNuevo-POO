package Ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Empresa;
import Clases.Proyecto;
import Clases.Vendedor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.SystemColor;

public class VentanaProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProyecto;
	private DefaultListModel<Proyecto> Proyectos;
	
	public VentanaProyecto(Empresa empresa, VentanaAdministrador ventanaAnterior) {
		Proyectos = new DefaultListModel<Proyecto>();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMostrarProyectos = new JPanel();		
		panelMostrarProyectos.setBackground(new Color(0, 153, 255));
		panelMostrarProyectos.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelMostrarProyectos.setBounds(10, 112, 327, 254);
		contentPane.add(panelMostrarProyectos);
		panelMostrarProyectos.setLayout(new GridLayout());
		
		final JList<Proyecto> listaProyectos = new JList<Proyecto>();
		listaProyectos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		listaProyectos.setModel(Proyectos);
		panelMostrarProyectos.add(listaProyectos);
		
		JScrollPane scrollRecetas = new JScrollPane(listaProyectos);
		panelMostrarProyectos.add(scrollRecetas);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelBusqueda.setBackground(new Color(0, 153, 153));
		panelBusqueda.setBounds(10, 62, 339, 41);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		JLabel lblProyecto = new JLabel("PROYECTO :");
		lblProyecto.setBounds(10, 13, 73, 14);
		panelBusqueda.add(lblProyecto);
		lblProyecto.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblProyecto.setForeground(new Color(255, 255, 255));
		
		txtProyecto = new JTextField();
		txtProyecto.setBounds(82, 6, 247, 28);
		panelBusqueda.add(txtProyecto);
		txtProyecto.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtProyecto.setColumns(10);
	
		
		
		JLabel lblUsuario = new JLabel("Men\u00FA Proyectos");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblUsuario.setBounds(198, 11, 181, 47);
		contentPane.add(lblUsuario);
		
		JButton btnRegresar = new JButton("CERRAR SESION");
		btnRegresar.setBackground(SystemColor.controlHighlight);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRegresar.setBounds(359, 332, 175, 34);
		contentPane.add(btnRegresar);
		
		JButton btnBuscar = new JButton("BUSCAR PROYECTO");
		btnBuscar.setBackground(SystemColor.controlHighlight);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!txtProyecto.getText().isEmpty() && !txtProyecto.getText().equals(""))
				{
					String nombreProyecto = txtProyecto.getText();
					int largo = empresa.sizeProyecto();
					
					Proyectos.removeAllElements(); //se parte con la lista de Proyectos vacia
						for(int i=0;i<largo;i++)
						{
							if(empresa.obtenerProyecto(i).getNombre().indexOf(nombreProyecto)!=-1
								|| empresa.obtenerProyecto(i).getCiudadUbicacion().indexOf(nombreProyecto)!=-1
								|| empresa.obtenerProyecto(i).getId().indexOf(nombreProyecto)!=-1)
							{
								Proyectos.addElement(empresa.obtenerProyecto(i));
							}
						}
					
				}
				
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(359, 62, 175, 34);
		contentPane.add(btnBuscar);
		
		JButton btnMostrar = new JButton("MOSTRAR PROYECTO");
		btnMostrar.setBackground(SystemColor.controlHighlight);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaProyectos.getSelectedIndex()!=-1)
				{
					VentanaMostrarProyecto ventanaMostrarProyecto = new VentanaMostrarProyecto (empresa,listaProyectos.getSelectedValue(),VentanaProyecto.this,null);     
					ventanaMostrarProyecto.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnMostrar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnMostrar.setBounds(347, 112, 187, 34);
		contentPane.add(btnMostrar);
		
		JButton btnDepartamentos = new JButton("DEPARTAMENTOS");
		btnDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaProyectos.getSelectedIndex()!=-1)
				{
					VentanaDepartamento ventana = new VentanaDepartamento (empresa,listaProyectos.getSelectedValue(),VentanaProyecto.this);     
					ventana.setVisible(true);
					setVisible(false);
				}
				
			}
		});
		btnDepartamentos.setBackground(SystemColor.controlHighlight);
		btnDepartamentos.setBounds(347, 157, 187, 34);
		contentPane.add(btnDepartamentos);
	
		
		
		
		
	}
	
	
	/*
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
	} */
}




package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Empresa;
import Clases.ListaProyectos;
import Clases.Proyecto;
import Clases.Vendedor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.SystemColor;

public class VentanaVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProyecto;
	private DefaultListModel<Proyecto> Proyectos;
	
	public VentanaVendedor(Empresa empresa,Vendedor user,VentanaInicial ventanaAnterior) {
		Proyectos = new DefaultListModel<Proyecto>();
		ListaProyectos listaProyecto = empresa.getListaProyectos();
		
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
	
		
		
		JLabel lblUsuario = new JLabel("Men\u00FA Vendedor");
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
					int largo = listaProyecto.largo();
					
					Proyectos.removeAllElements(); //se parte con la lista de Proyectos vacia
						for(int i=0;i<largo;i++)
						{
							if(listaProyecto.getPosDept(i).getNombre().indexOf(nombreProyecto)!=-1
								|| listaProyecto.getPosDept(i).getCiudadUbicacion().indexOf(nombreProyecto)!=-1
								|| listaProyecto.getPosDept(i).getId().indexOf(nombreProyecto)!=-1)
							{
								Proyectos.addElement(listaProyecto.getPosDept(i));
							}
						}
					
				}
				
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(359, 62, 175, 34);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("MODIFICAR\r\n DATOS");
		btnModificar.setBackground(SystemColor.controlHighlight);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	             VentanaModificarVendedor ventanaModificarUsuario = new VentanaModificarVendedor (empresa,user, VentanaVendedor.this,null);     
	             ventanaModificarUsuario.setVisible(true);
			}
		});
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnModificar.setBounds(359, 287, 175, 34);
		contentPane.add(btnModificar);
		
		JButton btnMostrar = new JButton("MOSTRAR PROYECTO");
		btnMostrar.setBackground(SystemColor.controlHighlight);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaProyectos.getSelectedIndex()!=-1)
				{
					VentanaMostrarProyecto ventanaMostrarProyecto = new VentanaMostrarProyecto (empresa,listaProyectos.getSelectedValue(),VentanaVendedor.this,null);     
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
					VentanaDepartamento ventana = new VentanaDepartamento (empresa,listaProyectos.getSelectedValue(),VentanaVendedor.this);     
					ventana.setVisible(true);
					setVisible(false);
				}
				
			}
		});
		btnDepartamentos.setBackground(SystemColor.controlHighlight);
		btnDepartamentos.setBounds(347, 157, 187, 34);
		contentPane.add(btnDepartamentos);
	
		
		
		
		
	}
}
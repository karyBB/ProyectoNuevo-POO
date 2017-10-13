package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Departamento;
import Clases.Empresa;
import Clases.ListaDepartamentos;
import Clases.Proyecto;

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

public class VentanaDepartamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDepartamento;
	private DefaultListModel<Departamento> departamentos;
	
	public VentanaDepartamento(Empresa empresa,Proyecto proyecto,JFrame ventanaAnterior) {
		departamentos = new DefaultListModel<Departamento>();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMostrarDepartamentos = new JPanel();		
		panelMostrarDepartamentos.setBackground(new Color(0, 153, 255));
		panelMostrarDepartamentos.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelMostrarDepartamentos.setBounds(10, 112, 327, 254);
		contentPane.add(panelMostrarDepartamentos);
		panelMostrarDepartamentos.setLayout(new GridLayout());
		
		final JList<Departamento> listaDepartamentos = new JList<Departamento>();
		listaDepartamentos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		listaDepartamentos.setModel(departamentos);
		panelMostrarDepartamentos.add(listaDepartamentos);
		
		JScrollPane scrollDepts = new JScrollPane(listaDepartamentos);
		panelMostrarDepartamentos.add(scrollDepts);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelBusqueda.setBackground(new Color(0, 153, 153));
		panelBusqueda.setBounds(10, 62, 327, 41);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("DEPARTAMENTO:");
		lblDepartamento.setBounds(10, 13, 119, 14);
		panelBusqueda.add(lblDepartamento);
		lblDepartamento.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDepartamento.setForeground(new Color(255, 255, 255));
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(139, 6, 176, 28);
		panelBusqueda.add(txtDepartamento);
		txtDepartamento.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDepartamento.setColumns(10);
	
		
		
		JLabel lblDept = new JLabel("Men\u00FA Departamento");
		lblDept.setForeground(Color.WHITE);
		lblDept.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblDept.setBounds(198, 11, 181, 47);
		contentPane.add(lblDept);
		
		JButton btnRegresar = new JButton("VOLVER");
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
		
		JButton btnBuscar = new JButton("BUSCAR DEPARTAMENTO");
		btnBuscar.setBackground(SystemColor.controlHighlight);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!txtDepartamento.getText().isEmpty() && !txtDepartamento.getText().equals(""))
				{
					String numero = txtDepartamento.getText();
					int largo =proyecto.sizeDepartamentos();
					
					departamentos.removeAllElements(); //se parte con la lista de Proyectos vacia
						for(int i=0;i<largo;i++)
						{
							if(proyecto.getPosDept(i).getNumero().indexOf(numero)!=-1)
							{
								departamentos.addElement(proyecto.getPosDept(i));
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
	             VentanaModificarDepartamento ventanaModificarDepartamento = new VentanaModificarDepartamento (empresa,proyecto,listaDepartamentos.getSelectedValue(), VentanaDepartamento.this);     
	             ventanaModificarDepartamento.setVisible(true);
			}
		});
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnModificar.setBounds(359, 287, 175, 34);
		contentPane.add(btnModificar);
		
		JButton btnMostrar = new JButton("MOSTRAR ");
		btnMostrar.setBackground(SystemColor.controlHighlight);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaDepartamentos.getSelectedIndex()!=-1)
				{
					VentanaMostrarDepartamento ventanaMostrarDepartamento = new VentanaMostrarDepartamento (empresa,listaDepartamentos.getSelectedValue(),VentanaDepartamento.this);     
					ventanaMostrarDepartamento.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnMostrar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnMostrar.setBounds(359, 112, 175, 34);
		contentPane.add(btnMostrar);
	
		
		
		
		
	}
		
	}

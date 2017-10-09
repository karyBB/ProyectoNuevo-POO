package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Empresa;
import Clases.Vendedor;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaAdministrador(Empresa empresa,Vendedor usuario,Administrador admin, VentanaInicial ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ventana agregar
		JButton botonAgregarAdmin = new JButton("AGREGAR UN ADMINISTRADOR\r\n");
		botonAgregarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 setVisible(false);
             VentanaAgregarAdministrador ventanaAgregarAdministrador = new VentanaAgregarAdministrador(empresa,admin,VentanaAdministrador.this);     
             ventanaAgregarAdministrador.setVisible(true);
             setVisible(false);
			}
		});
		botonAgregarAdmin.setBounds(10, 123, 253, 28);
		botonAgregarAdmin.setForeground(Color.BLACK);
		botonAgregarAdmin.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonAgregarAdmin.setBorderPainted(false);
		botonAgregarAdmin.setBorder(null);
		botonAgregarAdmin.setBackground(SystemColor.controlHighlight);
		contentPane.add(botonAgregarAdmin);
		
		JButton botonEliminarAdministrador = new JButton("ELIMINAR ADMINISTRADOR");
		botonEliminarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
	             VentanaEliminarAdministrador ventanaEliminarAdministrador = new VentanaEliminarAdministrador (empresa,admin, VentanaAdministrador.this);     
	             ventanaEliminarAdministrador.setVisible(true);
	             setVisible(false);
			}
		});
		botonEliminarAdministrador.setForeground(Color.BLACK);
		botonEliminarAdministrador.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonEliminarAdministrador.setBackground(SystemColor.controlHighlight);
		botonEliminarAdministrador.setBounds(10, 204, 253, 26);
		contentPane.add(botonEliminarAdministrador);
		
		//ventana modificar
		JButton btnModificarAdministrador = new JButton("MODIFICAR DATOS");
		btnModificarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	             VentanaModificarAdministrador ventanaModificarAdministrador = new VentanaModificarAdministrador (empresa,admin, VentanaAdministrador.this);     
	             ventanaModificarAdministrador.setVisible(true);
			}
		});
		btnModificarAdministrador.setForeground(Color.BLACK);
		btnModificarAdministrador.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnModificarAdministrador.setBorderPainted(false);
		btnModificarAdministrador.setBorder(null);
		btnModificarAdministrador.setBackground(SystemColor.controlHighlight);
		btnModificarAdministrador.setBounds(273, 203, 253, 28);
		contentPane.add(btnModificarAdministrador);
		
		//entana buscar
		JButton botonBuscarAdmin = new JButton("BUSCAR ADMINISTRADOR");
		botonBuscarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	             VentanaBuscarAdministrador ventanaBuscarAdministrador = new VentanaBuscarAdministrador (empresa, VentanaAdministrador.this);     
	             ventanaBuscarAdministrador.setVisible(true);
			}
		});
		botonBuscarAdmin.setForeground(Color.BLACK);
		botonBuscarAdmin.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonBuscarAdmin.setBorderPainted(false);
		botonBuscarAdmin.setBorder(null);
		botonBuscarAdmin.setBackground(SystemColor.controlHighlight);
		botonBuscarAdmin.setBounds(10, 162, 253, 28);
		contentPane.add(botonBuscarAdmin);
		
		JLabel lblMenAdministrador = new JLabel("Men\u00FA Administrador");
		lblMenAdministrador.setForeground(Color.WHITE);
		lblMenAdministrador.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblMenAdministrador.setBounds(187, 11, 181, 47);
		contentPane.add(lblMenAdministrador);
		
		JButton botonRegresar = new JButton("VOLVER");
		botonRegresar.setBackground(SystemColor.controlHighlight);
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		botonRegresar.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonRegresar.setBounds(107, 291, 156, 47);
		contentPane.add(botonRegresar);
		
		JButton botonProyectos = new JButton("PROYECTOS\r\n");
		botonProyectos.setBackground(SystemColor.controlHighlight);
		botonProyectos.setForeground(Color.BLACK);
		botonProyectos.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonProyectos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaProyecto ingreso = new VentanaProyecto(empresa,VentanaAdministrador.this);//interfaz 
				ingreso.setVisible(true);
			}
		});
		botonProyectos.setBounds(273, 163, 253, 26);
		contentPane.add(botonProyectos);
		
		JButton botonAgregarUsuario = new JButton("VENDEDORES");
		botonAgregarUsuario.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonAgregarUsuario.setBackground(SystemColor.controlHighlight);
		botonAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaAdminVendedores ingreso= new VentanaAdminVendedores(empresa,VentanaAdministrador.this);//interfaz 
				ingreso.setVisible(true);
				setVisible(false);
			}
		});
		botonAgregarUsuario.setBounds(273, 123, 253, 28);
		contentPane.add(botonAgregarUsuario);
		
		
		
		
		JButton botonReporte = new JButton("REPORTE PROYECTOS");
		botonReporte.setBackground(SystemColor.controlHighlight);
		botonReporte.setForeground(Color.BLACK);
		botonReporte.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(empresa.sizeProyecto()!=0)
                {
                    setVisible(false);
                    VentanaReporte reporte;
					
						try {
							
							reporte = new VentanaReporte(empresa,0,VentanaAdministrador.this);
							 reporte.setVisible(true);
						} catch (CloneNotSupportedException e1) {
							e1.printStackTrace();
						}
						
					
					
                }else
                    JOptionPane.showMessageDialog(VentanaAdministrador.this,"No existen  ingresados","Error al mostrar",0);
            }
			
			
		});
		botonReporte.setBounds(273, 239, 253, 26);
		contentPane.add(botonReporte);
		
		JLabel lblBienvenido = new JLabel("Bienvenido/a "+admin.getNombre());
		lblBienvenido.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(10, 71, 342, 28);
		contentPane.add(lblBienvenido);
		
		JButton btnReporteVendedor = new JButton("REPORTE VENDEDORES");
		btnReporteVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(empresa.sizeVendedores()!=0)
                {
                    setVisible(false);
                    VentanaReporte reporte;
					try {
						reporte = new VentanaReporte(empresa,1,VentanaAdministrador.this);
						reporte.setVisible(true);
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                }else
                    JOptionPane.showMessageDialog(VentanaAdministrador.this,"No existen  ingresados","Error al mostrar",0);
            }
			
		});
		btnReporteVendedor.setForeground(Color.BLACK);
		btnReporteVendedor.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnReporteVendedor.setBackground(SystemColor.controlHighlight);
		btnReporteVendedor.setBounds(273, 276, 253, 26);
		contentPane.add(btnReporteVendedor);
		
		JButton btnAgregarUnVendedor = new JButton("AGREGAR UN VENDEDOR\r\n");
		btnAgregarUnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
	             VentanaAgregarVendedor  ventanaAgregarAdministrador = new VentanaAgregarVendedor(empresa,VentanaAdministrador.this);     
	             ventanaAgregarAdministrador.setVisible(true);
	             setVisible(false);
			}
		});
		btnAgregarUnVendedor.setForeground(Color.BLACK);
		btnAgregarUnVendedor.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregarUnVendedor.setBorderPainted(false);
		btnAgregarUnVendedor.setBorder(null);
		btnAgregarUnVendedor.setBackground(SystemColor.controlHighlight);
		btnAgregarUnVendedor.setBounds(10, 240, 253, 28);
		contentPane.add(btnAgregarUnVendedor);
		
		JButton btnReporteAdministradores = new JButton("REPORTE ADMINISTRADORES");
		btnReporteAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(empresa.sizeAdministrador()!=0)
                {
                    setVisible(false);
                    VentanaReporte reporte;
					try {
						reporte = new VentanaReporte(empresa,2,VentanaAdministrador.this);
	                    reporte.setVisible(true);

					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }else
                    JOptionPane.showMessageDialog(VentanaAdministrador.this,"No existen  ingresados","Error al mostrar",0);
			}
		});
		btnReporteAdministradores.setForeground(Color.BLACK);
		btnReporteAdministradores.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnReporteAdministradores.setBackground(SystemColor.controlHighlight);
		btnReporteAdministradores.setBounds(273, 312, 253, 26);
		contentPane.add(btnReporteAdministradores);
	}
}
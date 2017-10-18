package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Clases.Administrador;
import Clases.Empresa;
import Clases.Vendedor;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaAdministrador(Empresa empresa,Administrador admin, VentanaInicial ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panelReportes = new JPanel();
		panelReportes.setBackground(new Color(0, 128, 128));
		panelReportes.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "REPORTES :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelReportes.setBounds(362, 25, 276, 198);
		contentPane.add(panelReportes);
		panelReportes.setLayout(null);
		
		
		
		
		
		
		JButton botonReporte = new JButton("REPORTE PROYECTOS");
		botonReporte.setBounds(35, 36, 202, 32);
		panelReportes.add(botonReporte);
		botonReporte.setBackground(SystemColor.controlHighlight);
		botonReporte.setForeground(Color.BLACK);
		botonReporte.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		JButton btnReporteAdministradores = new JButton("REPORTE ADMINISTRADORES");
		btnReporteAdministradores.setBounds(35, 133, 202, 32);
		panelReportes.add(btnReporteAdministradores);
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
		
		JButton btnReporteVendedor = new JButton("REPORTE VENDEDORES");
		btnReporteVendedor.setBounds(35, 90, 202, 32);
		panelReportes.add(btnReporteVendedor);
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
		btnModificarAdministrador.setBounds(30, 386, 253, 28);
		contentPane.add(btnModificarAdministrador);
		
		JLabel lblMenAdministrador = new JLabel("Men\u00FA Administrador");
		lblMenAdministrador.setForeground(Color.WHITE);
		lblMenAdministrador.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblMenAdministrador.setBounds(10, 10, 181, 47);
		contentPane.add(lblMenAdministrador);
		
		JButton botonRegresar = new JButton("CERRAR SESION");
		botonRegresar.setBackground(SystemColor.controlHighlight);
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		botonRegresar.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonRegresar.setBounds(377, 386, 253, 28);
		contentPane.add(botonRegresar);
		
		JLabel lblBienvenido = new JLabel("Bienvenido/a "+admin.getNombre());
		lblBienvenido.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(10, 56, 342, 28);
		contentPane.add(lblBienvenido);
		
		
		JPanel panelProyecto = new JPanel();
		panelProyecto.setBounds(362, 247, 276, 128);
		contentPane.add(panelProyecto);
		panelProyecto.setBackground(new Color(0, 128, 128));
		panelProyecto.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Proyectos :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelProyecto.setLayout(null);
		
		JButton btnAgregarProyecto = new JButton("AGREGAR UN PROYECTO\r\n");
		btnAgregarProyecto.setBounds(10, 35, 253, 28);
		panelProyecto.add(btnAgregarProyecto);
		btnAgregarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	             VentanaAgregarProyecto  ventanaAgregar = new VentanaAgregarProyecto(empresa,admin,VentanaAdministrador.this);     
	             ventanaAgregar.setVisible(true);
	             setVisible(false);
			}
		});
		btnAgregarProyecto.setForeground(Color.BLACK);
		btnAgregarProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregarProyecto.setBorderPainted(false);
		btnAgregarProyecto.setBorder(null);
		btnAgregarProyecto.setBackground(SystemColor.controlHighlight);
		
		JButton botonProyectos = new JButton("PROYECTOS\r\n");
		botonProyectos.setBounds(10, 74, 253, 26);
		panelProyecto.add(botonProyectos);
		botonProyectos.setBackground(SystemColor.controlHighlight);
		botonProyectos.setForeground(Color.BLACK);
		botonProyectos.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonProyectos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaProyecto ingreso = new VentanaProyecto(empresa,VentanaAdministrador.this,admin);//interfaz 
				ingreso.setVisible(true);
			}
		});
		
		
		JPanel panelvendedores = new JPanel();
		panelvendedores.setBounds(10, 247, 309, 128);
		contentPane.add(panelvendedores);
		panelvendedores.setBackground(new Color(0, 128, 128));
		panelvendedores.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Vendedores :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelvendedores.setLayout(null);
		
		JButton btnAgregarUnVendedor = new JButton("AGREGAR UN VENDEDOR\r\n");
		btnAgregarUnVendedor.setBounds(31, 34, 253, 28);
		panelvendedores.add(btnAgregarUnVendedor);
		btnAgregarUnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
	             VentanaAgregarVendedor  ventanaAgregarAdministrador = new VentanaAgregarVendedor(empresa,admin,VentanaAdministrador.this);     
	             ventanaAgregarAdministrador.setVisible(true);
	             setVisible(false);
			}
		});
		btnAgregarUnVendedor.setForeground(Color.BLACK);
		btnAgregarUnVendedor.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAgregarUnVendedor.setBorderPainted(false);
		btnAgregarUnVendedor.setBorder(null);
		btnAgregarUnVendedor.setBackground(SystemColor.controlHighlight);
		
		JButton botonAgregarUsuario = new JButton("VENDEDORES");
		botonAgregarUsuario.setBounds(31, 73, 253, 28);
		panelvendedores.add(botonAgregarUsuario);
		botonAgregarUsuario.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonAgregarUsuario.setBackground(SystemColor.controlHighlight);
		
		JPanel panelAdministrador = new JPanel();
		panelAdministrador.setBounds(10, 99, 307, 137);
		contentPane.add(panelAdministrador);
		panelAdministrador.setBackground(new Color(0, 128, 128));
		panelAdministrador.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Administradores :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelAdministrador.setLayout(null);
		
		
		//Boton agregar 
		JButton botonAgregarAdmin = new JButton("AGREGAR UN ADMINISTRADOR\r\n");
		botonAgregarAdmin.setBounds(33, 26, 253, 28);
		panelAdministrador.add(botonAgregarAdmin);
		botonAgregarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 setVisible(false);
             VentanaAgregarAdministrador ventanaAgregarAdministrador = new VentanaAgregarAdministrador(empresa,admin,VentanaAdministrador.this);     
             ventanaAgregarAdministrador.setVisible(true);
             setVisible(false);
			}
		});
		botonAgregarAdmin.setForeground(Color.BLACK);
		botonAgregarAdmin.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonAgregarAdmin.setBorderPainted(false);
		botonAgregarAdmin.setBorder(null);
		botonAgregarAdmin.setBackground(SystemColor.controlHighlight);
		
		//entana buscar
		JButton botonBuscarAdmin = new JButton("BUSCAR ADMINISTRADOR");
		botonBuscarAdmin.setBounds(33, 65, 253, 28);
		panelAdministrador.add(botonBuscarAdmin);
		botonBuscarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	             VentanaBuscarAdministrador ventanaBuscarAdministrador = new VentanaBuscarAdministrador (empresa,admin.getNombre(), VentanaAdministrador.this);     
	             ventanaBuscarAdministrador.setVisible(true);
			}
		});
		botonBuscarAdmin.setForeground(Color.BLACK);
		botonBuscarAdmin.setFont(new Font("Consolas", Font.PLAIN, 13));
		botonBuscarAdmin.setBorderPainted(false);
		botonBuscarAdmin.setBorder(null);
		botonBuscarAdmin.setBackground(SystemColor.controlHighlight);
		
		JButton botonEliminarAdministrador = new JButton("ELIMINAR ADMINISTRADOR");
		botonEliminarAdministrador.setBounds(33, 105, 253, 26);
		panelAdministrador.add(botonEliminarAdministrador);
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
		botonAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaAdminVendedores ingreso= new VentanaAdminVendedores(empresa,VentanaAdministrador.this);//interfaz 
				ingreso.setVisible(true);
				setVisible(false);
			}
		});
	}
}
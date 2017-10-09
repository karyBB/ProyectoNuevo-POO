package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Archivo;
import Clases.Empresa;
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
import javax.swing.JOptionPane;

import java.awt.SystemColor;

public class VentanaAdminVendedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreVendedor;

	public VentanaAdminVendedores(Empresa empresa,VentanaAdministrador ventanaAnterior) {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 235);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelBusqueda.setBackground(new Color(0, 153, 153));
		panelBusqueda.setBounds(10, 69, 276, 65);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		JLabel lblProyecto = new JLabel("Vendedor :");
		lblProyecto.setBounds(10, 11, 73, 14);
		panelBusqueda.add(lblProyecto);
		lblProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblProyecto.setForeground(new Color(255, 255, 255));
		
		txtNombreVendedor = new JTextField();
		txtNombreVendedor.setBounds(10, 26, 256, 28);
		panelBusqueda.add(txtNombreVendedor);
		txtNombreVendedor.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombreVendedor.setColumns(10);
	
		
		
		JLabel lblUsuario = new JLabel("Men\u00FA Vendedor");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblUsuario.setBounds(63, 0, 156, 58);
		contentPane.add(lblUsuario);
		
		JButton btnRegresar = new JButton("VOLVER");
		btnRegresar.setBackground(SystemColor.controlHighlight);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ventanaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRegresar.setBounds(63, 162, 175, 34);
		contentPane.add(btnRegresar);
		
		JButton btnMostrar = new JButton("MOSTRAR VENDEDOR");
		btnMostrar.setBackground(SystemColor.controlHighlight);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtNombreVendedor.getText().isEmpty())
				{	
					String vendedorBuscado = txtNombreVendedor.getText();
					if(empresa.buscarNombreVendedor(vendedorBuscado)!=null)
					{
					VentanaMostrarVendedor ventanaMostrarVendedor = new VentanaMostrarVendedor (empresa.buscarNombreVendedor(vendedorBuscado),VentanaAdminVendedores.this);     
					ventanaMostrarVendedor.setVisible(true);
					setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"No existen Vendedor","Error",0);

				}else
					JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"Porfavor ingrese un nombre","Error",0);

				

				
			}
		});
		btnMostrar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnMostrar.setBounds(296, 36, 187, 34);
		contentPane.add(btnMostrar);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtNombreVendedor.getText().isEmpty())
				{	
					String vendedorBuscado = txtNombreVendedor.getText();
					 if(empresa.buscarNombreVendedor(vendedorBuscado)!=null) {
							 VentanaModificarVendedor ventanaModificarVendedor = new VentanaModificarVendedor (empresa,empresa.buscarNombreVendedor(vendedorBuscado),null,VentanaAdminVendedores.this);     
					         ventanaModificarVendedor.setVisible(true);
						setVisible(false);
					 }
					 else {
							JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"No se encuentra ningun vendedor con este nombre","Error",0);

					 }
						}
				else {
					JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"Porfavor ingrese algun nombre","Error",0);

				}
				 }
			
			
	      
			
		});
		btnNewButton.setBounds(296, 100, 185, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ELIMINAR");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNombreVendedor.getText().isEmpty())
				{	
					String vendedorBuscado = txtNombreVendedor.getText();
	
							if(empresa.buscarNombreVendedor(vendedorBuscado)!=null) {
						Vendedor vendedor=empresa.buscarNombreVendedor(vendedorBuscado);
						
	                    Archivo archivo=new Archivo();
	                    archivo.eliminarTxtUsuario(vendedor);
	                    archivo.eliminarCarpetaUsuario(vendedor);
	                    empresa.eliminaVendedor(vendedor);
	                    JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"El Vendedor ha sido eliminado","Mensaje ",1);
	
							}
							else {
	                    JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"No existen Vendedor","Error ",0);
					
			                   }
					
		             }
				else {
					 JOptionPane.showMessageDialog(VentanaAdminVendedores.this,"Ingrese el Vendedor","Error ",0);
				}
			}
			
		});
		btnNewButton_1.setBounds(296, 161, 185, 34);
		contentPane.add(btnNewButton_1);
	
		
		
		
		
	}
}

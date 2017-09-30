package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Archivo;
import Clases.Empresa;
import Clases.ListaProyectos;
import Clases.Proyecto;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaBuscarProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBusquedaId;

	public VentanaBuscarProyecto(Empresa empresa,final VentanaProyecto ventanaAnterior) {
		ListaProyectos listaProyectos = empresa.getListaProyectos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//boton buscar
		JButton btnBuscar = new JButton("MOSTRAR DATOS");
		btnBuscar.setBackground(SystemColor.controlHighlight);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id=textFieldBusquedaId.getText();
				VentanaMostrarProyecto ventanaMostrarProyecto = new VentanaMostrarProyecto (empresa,empresa.getListaProyectos().busqueda(id),null,VentanaBuscarProyecto.this);     
				ventanaMostrarProyecto.setVisible(true);
			setVisible(false);
				
				
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(23, 177, 253, 28);
		contentPane.add(btnBuscar);
		
		//boton volver
		JButton button_1 = new JButton("VOLVER");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		button_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_1.setBounds(81, 307, 146, 49);
		contentPane.add(button_1);
		
		textFieldBusquedaId = new JTextField();
		textFieldBusquedaId.setColumns(10);
		textFieldBusquedaId.setBounds(39, 97, 207, 35);
		contentPane.add(textFieldBusquedaId);
		
		JLabel lblOIngreseEl = new JLabel(" Ingrese el ID del Proyecto que desea buscar");
		lblOIngreseEl.setForeground(Color.WHITE);
		lblOIngreseEl.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblOIngreseEl.setBackground(new Color(0, 153, 153));
		lblOIngreseEl.setBounds(10, 44, 359, 58);
		contentPane.add(lblOIngreseEl);
		
		JButton btnModificarProyecto = new JButton("MODIFICAR PROYECTO");
		btnModificarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String id = textFieldBusquedaId.getText();

						if(listaProyectos.busqueda(id)!=null) {
							 VentanaModificarProyecto ventanaModificarProyecto = new VentanaModificarProyecto (empresa,listaProyectos.busqueda(id),VentanaBuscarProyecto.this);     
							 ventanaModificarProyecto.setVisible(true);
						setVisible(false);
						}
				}
			
		});
		btnModificarProyecto.setForeground(Color.BLACK);
		btnModificarProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnModificarProyecto.setBorderPainted(false);
		btnModificarProyecto.setBorder(null);
		btnModificarProyecto.setBackground(SystemColor.controlHighlight);
		btnModificarProyecto.setBounds(23, 216, 253, 28);
		contentPane.add(btnModificarProyecto);
		
		JButton btnEliminarProyecto = new JButton("ELIMINAR PROYECTO");
		btnEliminarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldBusquedaId.getText().isEmpty())
				{	
					String id = textFieldBusquedaId.getText();

						if(listaProyectos.busqueda(id)!=null) {
					Proyecto proyecto=listaProyectos.busqueda(id);
                    Archivo archivo=new Archivo();
                    archivo.eliminarTxtProyecto(proyecto);
                    archivo.eliminarCarpetaProyecto(proyecto);
                    listaProyectos.eliminar(proyecto);
                    JOptionPane.showMessageDialog(VentanaBuscarProyecto.this,"El Proyecto ha sido eliminado","Mensaje ",1);

						}
						else
                    JOptionPane.showMessageDialog(VentanaBuscarProyecto.this,"No existen Proyecto","Error ",0);
				
				       }
			}
		});
		btnEliminarProyecto.setForeground(Color.BLACK);
		btnEliminarProyecto.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnEliminarProyecto.setBorderPainted(false);
		btnEliminarProyecto.setBorder(null);
		btnEliminarProyecto.setBackground(SystemColor.controlHighlight);
		btnEliminarProyecto.setBounds(23, 255, 253, 26);
		contentPane.add(btnEliminarProyecto);
	}
}

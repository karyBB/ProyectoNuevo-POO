package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Archivo;
import Clases.Empresa;
import Clases.ListaAdministradores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEliminarAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;

	
	public VentanaEliminarAdministrador (Empresa empresa,Administrador admin,final VentanaAdministrador ventanaAnterior) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Administrador "+admin.getNombre());
		lblBienvenido.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(10, 71, 342, 28);
		contentPane.add(lblBienvenido);
		//boton eliminar
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldNombre.getText().isEmpty())
				{	
					String nombre = textFieldNombre.getText();

						if(empresa.buscarNombreAdministrador(nombre)!=null) {
					Administrador admin=empresa.buscarNombreAdministrador(nombre);
                    empresa.eliminaAdministrador(admin);
                    Archivo archivo=new Archivo();
                    archivo.eliminarTxtAdministrador(admin);
                    JOptionPane.showMessageDialog(VentanaEliminarAdministrador.this,"El Adminstrador ha sido eliminado","Mensaje ",1);

						}
						else
                    JOptionPane.showMessageDialog(VentanaEliminarAdministrador.this,"No existen  Adminstrador","Error ",0);
				
				}
				else {
					 JOptionPane.showMessageDialog(VentanaEliminarAdministrador.this,"Ingrese nombre del administrador","Error ",0);
				}
			}
		});
		btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnEliminar.setBounds(52, 317, 146, 49);
		contentPane.add(btnEliminar);
		
		//boton volver
		JButton buttonVolver = new JButton("VOLVER");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dispose();
				ventanaAnterior.setVisible(true);
			}
			
		});
		buttonVolver.setFont(new Font("Consolas", Font.PLAIN, 13));
		buttonVolver.setBounds(346, 317, 146, 49);
		contentPane.add(buttonVolver);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(10, 181, 514, 36);
		contentPane.add(textFieldNombre);
		
		JLabel lblIngreseNombreDel = new JLabel("Ingrese nombre del Administrador que desea eliminar");
		lblIngreseNombreDel.setForeground(Color.WHITE);
		lblIngreseNombreDel.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblIngreseNombreDel.setBackground(new Color(0, 153, 153));
		lblIngreseNombreDel.setBounds(89, 123, 359, 58);
		contentPane.add(lblIngreseNombreDel);
	}


}

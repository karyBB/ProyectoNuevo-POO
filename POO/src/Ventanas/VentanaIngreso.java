package Ventanas;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Clases.Empresa;

public class VentanaIngreso extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;


	public VentanaIngreso(Empresa empresa) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.setBounds(165, 350, 166, 35);
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicial ingreso = new VentanaInicial(empresa);//interfaz 
				ingreso.setVisible(true);
				setVisible(false);
			}
		});
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\usuario\\Documents\\proyectos\\workspace\\POO\\imagenes\\logo.PNG"));
		lblNewLabel.setBounds(107, 41, 291, 222);
		getContentPane().add(lblNewLabel);
		
		btnIniciarSesin.setForeground(Color.BLACK);
		btnIniciarSesin.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnIniciarSesin.setBorderPainted(false);
		btnIniciarSesin.setBorder(new MatteBorder(20, 1, 20, 1, (Color) new Color(0, 255, 0)));
		btnIniciarSesin.setBackground(SystemColor.controlHighlight);
		getContentPane().add(btnIniciarSesin);

	}
}

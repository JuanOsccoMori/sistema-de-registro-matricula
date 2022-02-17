package aplicacion.usuario.ingreso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.plataforma.Plataforma;
import aplicacion.usuario.clase.Usuario;
import aplicacion.usuario.registro.FrmRegistro;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmIngreso extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textEmail;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JPasswordField textContraseña;
	private JButton btnIngresar;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					FrmIngreso frame = new FrmIngreso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmIngreso() {
		setTitle("Ingresar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEmail = new JTextField();
		textEmail.setBounds(183, 27, 140, 26);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		lblNewLabel = new JLabel("Correo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(64, 22, 97, 33);
		contentPane.add(lblNewLabel);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(64, 75, 79, 20);
		contentPane.add(lblContrasea);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(183, 71, 140, 26);
		contentPane.add(textContraseña);
		
		btnIngresar = new JButton("Ingrese");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(202, 126, 89, 23);
		contentPane.add(btnIngresar);
		
		btnRegistrar = new JButton("Registrese");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(72, 126, 105, 23);
		contentPane.add(btnRegistrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String email = textEmail.getText();
		char[] arrayC = textContraseña.getPassword();
		String pass = new String(arrayC);
		int pos = Usuario.verificarIngreso(email, pass);
		if(pos == -1) {
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecto");
		} else {
			Plataforma p = new Plataforma();
			p.setVisible(true);
			this.dispose();
		}
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		FrmRegistro r = new FrmRegistro();
		r.setVisible(true);
		this.dispose();
	}
}

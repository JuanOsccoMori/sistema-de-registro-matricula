package aplicacion.usuario.registro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.usuario.clase.Usuario;
import aplicacion.usuario.ingreso.FrmIngreso;
import aplicacion.usuario.lista.ListaUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textEmail;
	private JPasswordField textContraseña;
	private JButton btnIngresar;
	private JButton btnRegistro;
	private JComboBox<String> cboRango;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			FrmRegistro dialog = new FrmRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegistro() {
		setTitle("Registro");
		setBounds(100, 100, 501, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 37, 63, 21);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Rango");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 93, 63, 21);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 149, 87, 49);
		contentPanel.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(138, 35, 262, 28);
		contentPanel.add(textEmail);
		textEmail.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(138, 161, 262, 28);
		contentPanel.add(textContraseña);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(57, 242, 117, 35);
		contentPanel.add(btnIngresar);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(this);
		btnRegistro.setBounds(302, 242, 117, 35);
		contentPanel.add(btnRegistro);
		
		cboRango = new JComboBox<String>();
		cboRango.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Secretario"}));
		cboRango.setBounds(138, 91, 262, 28);
		contentPanel.add(cboRango);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistro) {
			actionPerformedBtnRegistro(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		FrmIngreso i = new FrmIngreso();
		i.setVisible(true);
		this.dispose();
	}
	protected void actionPerformedBtnRegistro(ActionEvent e) {
		String email = textEmail.getText();
		char[] arrayC = textContraseña.getPassword();
		String pass = new String(arrayC);
		String rango = (String)cboRango.getSelectedItem();
		
		Usuario obj = new Usuario();
		if (Usuario.verificarUsuarioNuevo(email) == -1) {
			obj.setEmail(email);
			obj.setContraseña(pass);
			obj.setRango(rango);
			ListaUsuario.agregar(obj);
			JOptionPane.showMessageDialog(this, "Se registro correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "Este usuario ya esta siendo usado");
		}

	}
}
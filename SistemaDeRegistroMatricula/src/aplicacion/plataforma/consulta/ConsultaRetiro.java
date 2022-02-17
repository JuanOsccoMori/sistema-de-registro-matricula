package aplicacion.plataforma.consulta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import aplicacion.plataforma.mantenimiento.arreglos.ArregloAlumno;
import aplicacion.plataforma.mantenimiento.arreglos.ArregloCurso;
import aplicacion.plataforma.mantenimiento.clase.Curso;
import aplicacion.plataforma.registro.arreglos.ArregloMatricula;
import aplicacion.plataforma.registro.arreglos.ArregloRetiro;
import aplicacion.plataforma.registro.clase.Retiro;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaRetiro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsulta;
	private JComboBox cboRetiro;
	private JLabel lblNewLabel;
	private JTable tblRetiro;
	private DefaultTableModel modelo;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ConsultaRetiro dialog = new ConsultaRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaRetiro() {
		setTitle("Consulta de Curso");
		setBounds(100, 100, 977, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(812, 16, 118, 40);
		contentPanel.add(btnConsulta);
		
		cboRetiro = new JComboBox();
		cboRetiro.setBounds(156, 16, 257, 40);
		contentPanel.add(cboRetiro);
		
		lblNewLabel = new JLabel("Consulta de retiro");
		lblNewLabel.setBounds(40, 23, 118, 27);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 941, 320);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblRetiro = new JTable();
		
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);
		modelo = new DefaultTableModel();
		modelo.addColumn("N° RETIRO");
		modelo.addColumn("N° MAT.");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		tblRetiro.setModel(modelo);
		
		lista_combo();
	}
	
	ArregloRetiro ar = new ArregloRetiro();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		String numRetiro = (String) cboRetiro.getSelectedItem();
		consultaRetiro(Integer.parseInt(numRetiro));
	}
	
	void consultaRetiro(int numRetiro) {
		Retiro r = ar.buscar(numRetiro);
	       
		DefaultTableModel dtm = (DefaultTableModel) tblRetiro.getModel();
		dtm.setRowCount(0);
		
		String nombres="";
		String apellidos ="";
		String asignatura = "";
		        
		        nombres = aa.buscar(am.buscar(r.getNumero_de_matricula()).getCodigo_alumno()).getNombres();
		        apellidos = aa.buscar(am.buscar(r.getNumero_de_matricula()).getCodigo_alumno()).getApellidos(); 
		        asignatura = ac.buscar(am.buscar(r.getNumero_de_matricula()).getCodigo_curso()).getAsignatura();
				
			Object[] f = { numRetiro,r.getNumero_de_matricula(), nombres, apellidos,
					asignatura, r.getFecha(),r.getHora() };
			
			dtm.addRow(f);
	}
	void lista_combo() {
		Retiro r;
		for (int i = 0; i < ar.tamaño(); i++) {
			r = ar.obtener(i);
			if (ar.procedeNumeroRetiros(r.getNumero_de_retiro()))
				cboRetiro.addItem("" + r.getNumero_de_retiro());
		}
	}
	
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		}
	
}

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
import aplicacion.plataforma.registro.arreglos.ArregloMatricula;
import aplicacion.plataforma.registro.clase.Matricula;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaMatricula extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsulta;
	private JComboBox cboMatricula;
	private JLabel lblNewLabel;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ConsultaMatricula dialog = new ConsultaMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaMatricula() {
		setTitle("Consulta de Matricula");
		setBounds(100, 100, 804, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(611, 11, 118, 40);
		contentPanel.add(btnConsulta);
		
		cboMatricula = new JComboBox();
		cboMatricula.setBounds(129, 16, 190, 31);
		contentPanel.add(cboMatricula);
		
		lblNewLabel = new JLabel("Consulta de matricula");
		lblNewLabel.setBounds(10, 18, 118, 27);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 768, 293);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblMatricula = new JTable();
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		modelo = new DefaultTableModel();
		modelo.addColumn("NÚM");
		modelo.addColumn("C.A.");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("C.C.");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		modelo.addColumn("ACTIVO");
		tblMatricula.setModel(modelo);
		
		listar_combo();
	}
	
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		String numMatricula = (String) cboMatricula.getSelectedItem();
		consultaMatricula(Integer.parseInt(numMatricula));
	}
	
	void consultaMatricula(int numMatricula) {
		Matricula m = am.buscar(numMatricula);
		ArregloAlumno aa = new ArregloAlumno();
	       
		DefaultTableModel dtm = (DefaultTableModel) tblMatricula.getModel();
		dtm.setRowCount(0);
		String activo = "";
		String nombres="";
		String apellidos ="";
		String asignatura = "";
		        activo = activo(aa.buscar(m.getCodigo_alumno()).getEstado());  
		        nombres = aa.buscar(m.getCodigo_alumno()).getNombres();
		        apellidos = aa.buscar(m.getCodigo_alumno()).getApellidos(); 
		        asignatura = ac.buscar(m.getCodigo_curso()).getAsignatura();
				
			Object[] f = { numMatricula,m.getCodigo_alumno(), nombres, apellidos,
					m.getCodigo_curso(),asignatura, m.getFecha(),m.getHora(),activo };
			
			dtm.addRow(f);
	}
	
	void listar_combo() {
		Matricula m;
		for (int i = 0; i < am.tamaño(); i++) {
			m = am.obtener(i);
			if (am.procedeNumeroMatricula(m.getNumero_matricula()))
				cboMatricula.addItem("" + m.getNumero_matricula());
		}
	}
	
	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}

	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		}
}

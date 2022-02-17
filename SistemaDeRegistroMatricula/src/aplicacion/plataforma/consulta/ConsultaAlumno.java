package aplicacion.plataforma.consulta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import aplicacion.plataforma.mantenimiento.arreglos.ArregloAlumno;
import aplicacion.plataforma.mantenimiento.clase.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAlumno extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsulta;
	private JLabel lblNewLabel;
	private JComboBox cboAlumno;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTable tblAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ConsultaAlumno dialog = new ConsultaAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaAlumno() {
		setTitle("Consulta de Alumno");
		setBounds(100, 100, 544, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(373, 8, 133, 61);
		contentPanel.add(btnConsulta);
		
		lblNewLabel = new JLabel("Codigo de alumno");
		lblNewLabel.setBounds(10, 25, 123, 27);
		contentPanel.add(lblNewLabel);
		
		cboAlumno = new JComboBox();
		cboAlumno.setBounds(128, 19, 160, 39);
		contentPanel.add(cboAlumno);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 508, 313);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblAlumno = new JTable();
		tblAlumno.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumno);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EDAD");
		modelo.addColumn("CELULAR");
		modelo.addColumn("ESTADO");
		tblAlumno.setModel(modelo);
		
		listar_combo();
	}
	
	ArregloAlumno aa = new ArregloAlumno();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		String codAlumno = (String) cboAlumno.getSelectedItem();
		consultaAlumno(Integer.parseInt(codAlumno));
	}
	
	void consultaAlumno(int codAlumno) {
		
		Alumno a = aa.buscar(codAlumno);
       
		DefaultTableModel dtm = (DefaultTableModel) tblAlumno.getModel();
		dtm.setRowCount(0);
		String estado = "";
		          
		          estado = nombreEstado(a.getEstado());
				
			Object[] f = { codAlumno, a.getNombres(), a.getApellidos(), a.getDni(),
					a.getEdad(), a.getCelular(), estado };
			
			dtm.addRow(f);     			

	}	
	
	void listar_combo() {
		
		Alumno a;
		for (int i = 0; i < aa.tamaño(); i++) {
			a = aa.obtener(i);
			if (aa.procedeCodigoAlumno(a.getCodAlumno()))
				cboAlumno.addItem("" + a.getCodAlumno());
		}
	}
	
	String nombreEstado(int i) {
		switch (i) {
			case 0: return "REGISTRADO";
			case 1: return "MATRICULADO";
			case 2: return "RETIRADO";
			default:return null;
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
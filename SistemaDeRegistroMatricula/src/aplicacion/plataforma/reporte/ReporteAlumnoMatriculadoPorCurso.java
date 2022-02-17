package aplicacion.plataforma.reporte;

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
import aplicacion.plataforma.registro.clase.Matricula;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteAlumnoMatriculadoPorCurso extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ReporteAlumnoMatriculadoPorCurso dialog = new ReporteAlumnoMatriculadoPorCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteAlumnoMatriculadoPorCurso() {
		setTitle("Reporte Alumno Matriculado Por Curso");
		setBounds(100, 100, 760, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(296, 11, 167, 47);
		contentPanel.add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 724, 348);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("");
		for (int i = 0; i < ac.tamaño(); i++) {
			boolean x = false;
			imprimir(" " + ac.obtener(i).getAsignatura());
			imprimir("");
			int CodCurso = ac.obtener(i).getCodCurso();
			for (int j = 0; j < am.tamaño(); j++) {
				Matricula m = am.obtener(j);
				if (m.getCodigo_curso() == CodCurso) {
					int estado = aa.buscar(m.getCodigo_alumno()).getEstado();
					if (estado == 1) {
						if (!x) x = true;
						imprimir(" * ALUMNO : " + aa.buscar(m.getCodigo_alumno()).getNombres() +
								" " + aa.buscar(m.getCodigo_alumno()).getApellidos());
					}
				}
			}
			if (!x) imprimir(" NO EXISTEN ALUMNOS MATRICULADOS EN ESTE CURSO");
			imprimir("-------------------------------------------------------------------------");
		}
	}
	
	//DECLARACION GLOBAL
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	String nombreEstado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default: return null;
		}
	}
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}

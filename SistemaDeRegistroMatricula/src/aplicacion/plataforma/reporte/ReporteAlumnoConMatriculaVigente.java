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

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteAlumnoConMatriculaVigente extends JDialog implements ActionListener {

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
			ReporteAlumnoConMatriculaVigente dialog = new ReporteAlumnoConMatriculaVigente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteAlumnoConMatriculaVigente() {
		setTitle("Reporte Alumno Con Matricula Vigente");
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
		for (int i = 0; i < aa.tamaño(); i++) {
			if (aa.obtener(i).getEstado() == 1) {
				imprimir(" CÓDIGO    : " + aa.obtener(i).getCodAlumno());
				imprimir(" NOMBRES   : " + aa.obtener(i).getNombres());
				imprimir(" APELLIDOS : " + aa.obtener(i).getApellidos());
				imprimir(" DNI       : " + aa.obtener(i).getDni());
				imprimir(" EDAD      : " + aa.obtener(i).getEdad());
				imprimir(" CELULAR   : " + aa.obtener(i).getCelular());
				imprimir(" ESTADO    : " + nombreEstado(aa.obtener(i).getEstado()));
				imprimir("-------------------------------------------------------------------------");
			}
		}
	}
	
	//DECLARACION GLOBAL
	ArregloAlumno aa = new ArregloAlumno();
	
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

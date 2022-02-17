package aplicacion.plataforma.registro.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import aplicacion.plataforma.mantenimiento.arreglos.ArregloAlumno;
import aplicacion.plataforma.mantenimiento.arreglos.ArregloCurso;
import aplicacion.plataforma.mantenimiento.clase.Alumno;
import aplicacion.plataforma.mantenimiento.clase.Curso;
import aplicacion.plataforma.registro.arreglos.ArregloMatricula;
import aplicacion.plataforma.registro.clase.Calendario;
import aplicacion.plataforma.registro.clase.Matricula;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class RegistroMatricula extends JDialog implements ItemListener, ActionListener, MouseListener  {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Integer> cboNumMatricula;
	private JComboBox<Integer> cboCodigoAlumno;
	private JComboBox<Integer> cboCodigoCurso;
	private JTextField txtAlumno;
	private JTextField txtEstadoAlumno;
	private JTextField txtCurso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTable tblMatricula;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			RegistroMatricula dialog = new RegistroMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroMatricula() {
		setTitle("Registro de Matriculas");
		setBounds(100, 100, 808, 605);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.addItemListener(this);
		cboNumMatricula.setSelectedIndex(-1);
		cboNumMatricula.setBounds(171, 22, 178, 34);
		contentPanel.add(cboNumMatricula);
		
		cboCodigoAlumno = new JComboBox<Integer>();
		cboCodigoAlumno.addItemListener(this);
		cboCodigoAlumno.setSelectedIndex(-1);
		cboCodigoAlumno.setBounds(171, 67, 178, 34);
		contentPanel.add(cboCodigoAlumno);
		
		cboCodigoCurso = new JComboBox<Integer>();
		cboCodigoCurso.addItemListener(this);
		cboCodigoCurso.setBounds(171, 186, 178, 34);
		contentPanel.add(cboCodigoCurso);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(20, 112, 329, 25);
		contentPanel.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		txtEstadoAlumno = new JTextField();
		txtEstadoAlumno.setBounds(171, 148, 178, 27);
		contentPanel.add(txtEstadoAlumno);
		txtEstadoAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(20, 231, 329, 25);
		contentPanel.add(txtCurso);
		
		lblNewLabel = new JLabel("Numero de Matriculas");
		lblNewLabel.setBounds(20, 27, 141, 24);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo de Alumno");
		lblNewLabel_1.setBounds(20, 72, 141, 24);
		contentPanel.add(lblNewLabel_1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(454, 67, 133, 53);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(454, 150, 133, 53);
		contentPanel.add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(646, 28, 133, 53);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(646, 100, 133, 53);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(646, 177, 133, 53);
		contentPanel.add(btnEliminar);
		
		lblNewLabel_2 = new JLabel("Estado del Alumno");
		lblNewLabel_2.setBounds(20, 154, 108, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Codigo de Curso");
		lblNewLabel_3.setBounds(20, 196, 124, 14);
		contentPanel.add(lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 270, 769, 285);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblMatricula = new JTable();
		tblMatricula.addMouseListener(this);
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
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCurso) {
			itemStateChangedCboCodigoCurso(e);
		}
		if (e.getSource() == cboCodigoAlumno) {
			itemStateChangedCboCodigoAlumno(e);
		}
		if (e.getSource() == cboNumMatricula) {
			itemStateChangedCboNumMatricula(e);
		}
	}
	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			Matricula buscado = am.buscar(numMatricula);
			cboCodigoAlumno.setSelectedItem(buscado.getCodigo_alumno());
			cboCodigoCurso.setSelectedItem(buscado.getCodigo_curso());
			tblMatricula.setRowSelectionInterval(cboNumMatricula.getSelectedIndex(), cboNumMatricula.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCodigoAlumno(ItemEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno buscado = aa.buscar(codAlumno);
			txtAlumno.setText(buscado.getNombres() + " " + buscado.getApellidos());
			txtEstadoAlumno.setText(nombreEstado(buscado.getEstado()));
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCodigoCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso buscado = ac.buscar(codCurso);
			txtCurso.setText(buscado.getAsignatura());
		} catch (Exception error) {
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		botonAceptar();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		botonAdicionar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		botonModificar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		botonEliminar();
	}
	
	void botonAdicionar() {
		limpiar();
		habilitar(false, true, false, false, true, false, true, true, false, true, false);
		cboNumMatricula.addItem(am.codigoCorrelativo());
		cboNumMatricula.setSelectedIndex(am.tamaño());
		cboCodigoAlumno.requestFocus();
	}
	void botonModificar() {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, false, false, false, true, false, true, true, true, false, false);
		cboNumMatricula.requestFocus();
	}
	void botonEliminar(){
		try {
			int numMatricula = leerNumeroMatricula();
			int codAlumno = leerCodigoAlumno();
			Matricula buscado = am.buscar(numMatricula);
			if (aa.buscar(codAlumno).getEstado() == 1) {
				if (confirmar() == 0) {
					am.eliminar(buscado);
					aa.buscar(codAlumno).setEstado(0);
					aa.actualizarAlumnos();
					listar();
					mensaje("Matrícula eliminada exitosamente");
					deshabilitarTodo();
				}
			} else {
				error("No es posible eliminar la matrícula, el alumno se encuentra retirado", cboNumMatricula);
			}
		} catch (Exception error) {
			error("Seleccione un número de matrícula", cboNumMatricula);
		}
	}
	
	void botonAceptar() {
		try {
			int numMatricula = leerNumeroMatricula();
			try {
				int codAlumno = leerCodigoAlumno();
				try {
					int codCurso = leerCodigoCurso();
					if (!btnAdicionar.isEnabled()) {
						if (aa.buscar(codAlumno).getEstado() == 0) {
							Matricula nuevo = new Matricula(numMatricula, codAlumno, codCurso, Calendario.fechaActual(), Calendario.horaActual());
							aa.buscar(codAlumno).setEstado(1);
							aa.actualizarAlumnos();
							am.adicionar(nuevo);
							listar();
							mensaje("Nueva matrícula añadida exitosamente");
							deshabilitarTodo();
						} else {
							error("No es posible completar la acción, el alumno ya se encuentra matriculado", cboCodigoAlumno);
						}
					} else if (!btnModificar.isEnabled()) {
							Matricula buscado = am.buscar(numMatricula);
							buscado.setCodigo_curso(codCurso);
							am.actualizarMatricula();
							listar();
							mensaje("Matrícula modificada exitosamente");
							deshabilitarTodo();
					}
				} catch (Exception error) {
					error("Inserte un código de curso", cboCodigoCurso);
				}
			} catch (Exception error) {
				error("Inserte un código de alumno", cboCodigoAlumno);
			}
		} catch (Exception error) {
			error("Seleccione un número de matrícula", cboNumMatricula);
		}
	}
	
	void habilitar(boolean numMatricula, boolean codigoAlumno, boolean alumno, boolean estadoAlumno, boolean codigoCurso,
			boolean curso, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboNumMatricula.setEnabled(numMatricula);
		cboCodigoAlumno.setEnabled(codigoAlumno);
		txtAlumno.setEditable(alumno);
		txtEstadoAlumno.setEditable(estadoAlumno);
		cboCodigoCurso.setEnabled(codigoCurso);
		txtCurso.setEditable(curso);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboNumMatricula();
		listarCboCodAlumno();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	
	void limpiar() {
		cboNumMatricula.setSelectedIndex(-1);
		cboCodigoAlumno.setSelectedIndex(-1);
		txtAlumno.setText("");
		txtEstadoAlumno.setText("");
		cboCodigoCurso.setSelectedIndex(-1);
		txtCurso.setText("");
	}
	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumero_matricula());
		}
	}
	void listarCboCodAlumno() {
		cboCodigoAlumno.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodigoAlumno.addItem(aa.obtener(i).getCodAlumno());
		}
	}
	void listarCboCodCurso() {
		cboCodigoCurso.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigoCurso.addItem(ac.obtener(i).getCodCurso());
		}
	}
	
	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}
	int leerCodigoAlumno() {
		return Integer.parseInt(cboCodigoAlumno.getSelectedItem().toString());
	}
	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}
	String leerEstadoAlumno() {
		return txtEstadoAlumno.getText();
	}
	String nombreEstado(int i) {
		switch (i) {
		case 0: return "Registrado";
		case 1: return "Matriculado";
		case 2: return "Retirado";
		default:return null;
		}
	}
	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodigoCurso.getSelectedItem().toString());
	}
	String leerCurso() {
		return txtCurso.getText().trim().toUpperCase();
	}
	
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblMatricula.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth()*7);
		modeloColuma.getColumn(6).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(7).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(8).setPreferredWidth(scrollPane.getWidth()*1);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < am.tamaño(); i++) {
			Object[] fila = {
					am.obtener(i).getNumero_matricula(),
					am.obtener(i).getCodigo_alumno(),
					aa.buscar(am.obtener(i).getCodigo_alumno()).getNombres(),
					aa.buscar(am.obtener(i).getCodigo_alumno()).getApellidos(),
					am.obtener(i).getCodigo_curso(),
					ac.buscar(am.obtener(i).getCodigo_curso()).getAsignatura(),
					am.obtener(i).getFecha(),
					am.obtener(i).getHora(),
					activo(aa.buscar(am.obtener(i).getCodigo_alumno()).getEstado())
			};
			modelo.addRow(fila);
		}
	}
	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estás seguro que deseas eliminar esta matricula?\n"
				+ "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblMatricula) {
			mouseClickedTblMatricula(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblMatricula(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Matricula buscado = am.obtener(tblMatricula.getSelectedRow());
				cboNumMatricula.setSelectedIndex(tblMatricula.getSelectedRow());
				cboCodigoAlumno.setSelectedItem(buscado.getCodigo_alumno());
				cboCodigoCurso.setSelectedItem(buscado.getCodigo_curso());
			} catch (Exception error) {
				
			}
		}
	}
}

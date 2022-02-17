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
import aplicacion.plataforma.mantenimiento.clase.Curso;
import aplicacion.plataforma.registro.arreglos.ArregloMatricula;
import aplicacion.plataforma.registro.arreglos.ArregloRetiro;
import aplicacion.plataforma.registro.clase.Calendario;
import aplicacion.plataforma.registro.clase.Matricula;
import aplicacion.plataforma.registro.clase.Retiro;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class RegistroRetiro extends JDialog implements ItemListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Integer> cboNumRetiro;
	private JComboBox<Integer> cboNumMatricula;
	private JComboBox<Integer> cboCodigoCurso;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private JTextField txtActivoMatricula;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTable tblRetiro;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			RegistroRetiro dialog = new RegistroRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroRetiro() {
		setTitle("Registro de Retiros");
		setBounds(100, 100, 862, 581);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboNumRetiro = new JComboBox<Integer>();
		cboNumRetiro.addItemListener(this);
		cboNumRetiro.setSelectedIndex(-1);
		cboNumRetiro.setBounds(174, 11, 229, 37);
		contentPanel.add(cboNumRetiro);
		
		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.addItemListener(this);
		cboNumMatricula.setSelectedIndex(-1);
		cboNumMatricula.setBounds(174, 69, 229, 37);
		contentPanel.add(cboNumMatricula);
		
		cboCodigoCurso = new JComboBox<Integer>();
		cboCodigoCurso.addItemListener(this);
		cboCodigoCurso.setSelectedIndex(-1);
		cboCodigoCurso.setBounds(174, 157, 229, 37);
		contentPanel.add(cboCodigoCurso);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(107, 117, 296, 29);
		contentPanel.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(107, 205, 296, 29);
		contentPanel.add(txtCurso);
		
		txtActivoMatricula = new JTextField();
		txtActivoMatricula.setColumns(10);
		txtActivoMatricula.setBounds(107, 245, 296, 29);
		contentPanel.add(txtActivoMatricula);
		
		lblNewLabel = new JLabel("Numero de Retiro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 16, 137, 32);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Numero de Matricula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 69, 148, 33);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Alumno");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(27, 120, 70, 22);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Codigo del curso");
		lblNewLabel_3.setBounds(27, 161, 103, 29);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Curso");
		lblNewLabel_4.setBounds(27, 212, 53, 22);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Activo");
		lblNewLabel_5.setBounds(27, 245, 58, 29);
		contentPanel.add(lblNewLabel_5);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(497, 80, 137, 60);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(497, 174, 137, 60);
		contentPanel.add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(691, 32, 137, 60);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(691, 117, 137, 60);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(691, 214, 137, 60);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 300, 822, 231);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblRetiro = new JTable();
		tblRetiro.addMouseListener(this);
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
		
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	/*----------- IMPORTACION ---------------*/
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	ArregloRetiro ar = new ArregloRetiro();
	
	/*------------ BUSCARDOR ---------*/
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCurso) {
			itemStateChangedCboCodigoCurso(e);
		}
		if (e.getSource() == cboNumMatricula) {
			itemStateChangedCboNumMatricula(e);
		}
		if (e.getSource() == cboNumRetiro) {
			itemStateChangedCboNumRetiro(e);
		}
	}
	protected void itemStateChangedCboNumRetiro(ItemEvent e) {
		try {
			int numRetiro = leerNumeroRetiro();
			Retiro buscadoR = ar.buscar(numRetiro);
			Matricula buscadoM = am.buscar(buscadoR.getNumero_de_matricula());
			cboNumMatricula.setSelectedItem(buscadoR.getNumero_de_matricula());
			cboCodigoCurso.setSelectedItem(buscadoM.getCodigo_curso());
			tblRetiro.setRowSelectionInterval(cboNumRetiro.getSelectedIndex(), cboNumRetiro.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			Matricula buscado = am.buscar(numMatricula);
			txtAlumno.setText(aa.buscar(buscado.getCodigo_alumno()).getNombres()
					+ " " + aa.buscar(buscado.getCodigo_alumno()).getApellidos());
			cboCodigoCurso.setSelectedItem(buscado.getCodigo_curso());
			txtActivoMatricula.setText(activo(aa.buscar(buscado.getCodigo_alumno()).getEstado()));
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
	/*------------BOTONES ------------------*/
	void botonAdicionar() {
		limpiar();
		habilitar(false, true, false, false, false, false, true, true, false, true, false);
		cboNumRetiro.addItem(ar.codigoCorrelativo());
		cboNumRetiro.setSelectedIndex(ar.tamaño());
		cboNumMatricula.requestFocus();
	}
	void botonAceptar() {
		try {
			int numRetiro = leerNumeroRetiro();
			try {
				int numMatricula = leerNumeroMatricula();
				int codCurso = leerCodigoCurso();
				if (!btnAdicionar.isEnabled()) {
					if (aa.buscar(am.buscar(numMatricula).getCodigo_alumno()).getEstado() == 1) {
						Retiro nuevo = new Retiro(numRetiro, numMatricula, Calendario.fechaActual(), Calendario.horaActual());
						aa.buscar(am.buscar(numMatricula).getCodigo_alumno()).setEstado(2);
						aa.actualizarAlumnos();
						ar.adicionar(nuevo);
						listar();
						mensaje("Nuevo retiro añadido exitosamente");
						deshabilitarTodo();
					} else {
						error("No es posible completar la acción, el alumno ya se encuentra retirado", cboNumMatricula);
					}
				} else if (!btnModificar.isEnabled()) {
						Retiro buscado = ar.buscar(numRetiro);
						am.buscar(buscado.getNumero_de_matricula()).setCodigo_curso(codCurso);
						am.actualizarMatricula();
						listar();
						mensaje("Retiro modificado exitosamente");
						deshabilitarTodo();
				}
			} catch (Exception error) {
				error("Inserte un número de matrícula", cboNumMatricula);
			}
		} catch (Exception error) {
			error("Seleccione un número de retiro", cboNumRetiro);
		}
	}
	void botonEliminar() {
		try {
			int numRetiro = leerNumeroRetiro();
			Retiro buscado = ar.buscar(numRetiro);
			if (confirmar() == 0) {
				ar.eliminar(buscado);
				aa.buscar(am.buscar(buscado.getNumero_de_matricula()).getCodigo_alumno()).setEstado(1);
				aa.actualizarAlumnos();
				listar();
				mensaje("Retiro eliminado exitosamente");
				deshabilitarTodo();
			}
		} catch (Exception error) {
			error("Seleccione un número de retiro", cboNumRetiro);
		}
	}

	void botonModificar() {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, false, false, true, false, false, true, true, true, false, false);
		cboNumRetiro.requestFocus();
	}
	/*------------HABILITAR DESABILITAR----------*/
	void habilitar(boolean numRetiro, boolean numMatricula, boolean alumno, boolean codigoCurso, boolean curso,
			boolean activoMatricula, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboNumRetiro.setEnabled(numRetiro);
		cboNumMatricula.setEnabled(numMatricula);
		txtAlumno.setEditable(alumno);
		cboCodigoCurso.setEnabled(codigoCurso);
		txtCurso.setEditable(curso);
		txtActivoMatricula.setEditable(activoMatricula);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboNumRetiro();
		listarCboNumMatricula();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	
	/*-----------LECTURA ------------------*/
	int leerNumeroRetiro() {
		return Integer.parseInt(cboNumRetiro.getSelectedItem().toString());
	}
	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}
	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodigoCurso.getSelectedItem().toString());
	}
	String leerCurso() {
		return txtCurso.getText().trim().toUpperCase();
	}
	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}
	
	/*----------- DATOS --------------------*/
	void limpiar() {
		cboNumRetiro.setSelectedIndex(-1);
		cboNumMatricula.setSelectedIndex(-1);
		txtAlumno.setText("");
		cboCodigoCurso.setSelectedIndex(-1);
		txtCurso.setText("");
		txtActivoMatricula.setText("");
	}
	void listarCboNumRetiro() {
		cboNumRetiro.removeAllItems();
		for (int i = 0; i < ar.tamaño(); i++) {
			cboNumRetiro.addItem(ar.obtener(i).getNumero_de_retiro());
		}
	}
	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumero_matricula());
		}
	}
	void listarCboCodCurso() {
		cboCodigoCurso.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigoCurso.addItem(ac.obtener(i).getCodCurso());
		}
	}
	
	
	/*------------TABLA -----------------*/
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblRetiro.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*3);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*6);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*11);
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth()*3);
		modeloColuma.getColumn(6).setPreferredWidth(scrollPane.getWidth()*3);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ar.tamaño(); i++) {
			Object[] fila = {
					ar.obtener(i).getNumero_de_retiro(),
					ar.obtener(i).getNumero_de_matricula(),
					aa.buscar(am.buscar(ar.obtener(i).getNumero_de_matricula()).getCodigo_alumno()).getNombres(),
					aa.buscar(am.buscar(ar.obtener(i).getNumero_de_matricula()).getCodigo_alumno()).getApellidos(),
					ac.buscar(am.buscar(ar.obtener(i).getNumero_de_matricula()).getCodigo_curso()).getAsignatura(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora(),
			};
			modelo.addRow(fila);
		}
	}
	
	/*----------- MENSAJES --------------*/
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estás seguro que deseas eliminar este retiro?\n"
				+ "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	
	/*------ SELECCIONAR CON UN CLICK -----------*/
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRetiro) {
			mouseClickedTblRetiro(e);
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
	protected void mouseClickedTblRetiro(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Retiro buscado = ar.obtener(tblRetiro.getSelectedRow());
				cboNumRetiro.setSelectedIndex(tblRetiro.getSelectedRow());
				cboNumMatricula.setSelectedItem(buscado.getNumero_de_matricula());
			} catch (Exception error) {
				
			}	
		}
	}
}

package aplicacion.plataforma.mantenimiento.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import aplicacion.plataforma.mantenimiento.arreglos.ArregloAlumno;
import aplicacion.plataforma.mantenimiento.clase.Alumno;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
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
import javax.swing.DefaultComboBoxModel;

public class MantenimientoAlumno extends JDialog implements ItemListener, ActionListener, MouseListener  {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JComboBox<Integer> cboCodigo;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JComboBox<String> cboEstado;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTable tblAlumno;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			MantenimientoAlumno dialog = new MantenimientoAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoAlumno() {
		setTitle("Mantenimiento Alumno");
		setBounds(100, 100, 681, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(107, 59, 208, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(107, 90, 208, 20);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboCodigo = new JComboBox();
		cboCodigo.setBounds(107, 11, 208, 37);
		contentPanel.add(cboCodigo);
		
		txtDni = new JTextField();
		txtDni.setBounds(107, 121, 104, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(270, 121, 45, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(107, 152, 208, 20);
		contentPanel.add(txtCelular);
		txtCelular.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(107, 183, 208, 31);
		contentPanel.add(cboEstado);
		
		lblNewLabel = new JLabel("Edad");
		lblNewLabel.setBounds(221, 124, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(28, 14, 66, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setBounds(28, 62, 69, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setBounds(28, 93, 69, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("DNI");
		lblNewLabel_4.setBounds(28, 124, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Celular");
		lblNewLabel_5.setBounds(28, 155, 69, 14);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(28, 185, 69, 23);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_6);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(494, 11, 133, 61);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(494, 80, 133, 61);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(494, 153, 133, 61);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 631, 258);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(352, 58, 115, 37);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(352, 120, 115, 37);
		contentPanel.add(btnCancelar);
		
		tblAlumno = new JTable();
		tblAlumno.addMouseListener(this);
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
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	ArregloAlumno aa = new ArregloAlumno();
	
	//Item Evento
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}
	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codAlumno = leerCodigo();
			Alumno buscado = aa.buscar(codAlumno);
			txtNombres.setText(buscado.getNombres());
			txtApellidos.setText(buscado.getApellidos());
			txtDni.setText(buscado.getDni());
			txtEdad.setText("" + buscado.getEdad());
			txtCelular.setText("" + buscado.getCelular());
			cboEstado.setSelectedIndex(buscado.getEstado());
			tblAlumno.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
		} catch (Exception error) {
			System.out.println(error);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
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
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		botonAceptar();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	
	/* --------------------- 
	 * Configuraciones
	 * --------------------- */
	
	//BOTONES
	void botonAdicionar() {
		limpiar();
		habilitar(false, true, true, true, true, true, false, true, true, false, true, false);
		cboEstado.setSelectedIndex(0);
		cboCodigo.addItem(aa.codigoCorrelativo());
		cboCodigo.setSelectedIndex(aa.tamaño());
		txtNombres.requestFocus();
	}
	
	void botonModificar() {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, true, true, false, true, true, false, true, true, true, false, false);
		cboCodigo.requestFocus();
	}
	
	void botonEliminar() {
		try {
			int codAlumno = leerCodigo();
			Alumno buscado = aa.buscar(codAlumno);
			if (buscado.getEstado() == 0) {
				if (confirmar() == 0) {
					aa.eliminar(buscado);
					listar();
					mensaje("Alumno eliminado exitosamente");
					deshabilitarTodo();
				}
			} else {
				error("No puede eliminar a un alumno ya matriculado", cboCodigo);
			}
		} catch (Exception error) {
			error("Seleccione un código de alumno", cboCodigo);
		}
	}
	
	void botonAceptar() {
		try {
			int codAlumno = leerCodigo();
			String nombre = leerNombres();
			if (nombre.length() != 0) {
				String apellidos = leerApellidos();
				if (apellidos.length() != 0) {
					String dni = leerDNI();
					try {
						if (Integer.parseInt(dni) > 0 && dni.length() == 8) {
							try {
								int edad = leerEdad();
								try {
									int celular = leerCelular();
									if (celular >= 900000000 && celular <= 999999999) {
										int estado = leerEstado();
										if (estado != -1) {
											if (!btnAdicionar.isEnabled()) {
												if (!existeDNI(dni)) {
													Alumno nuevo = new Alumno(codAlumno, nombre, apellidos, dni, edad, celular, estado);
													aa.adicionar(nuevo);
													listar();
													mensaje("Nuevo alumno añadido exitosamente");
													deshabilitarTodo();	
												} else {
													error("No puede ingresar un DNI ya existente", txtDni);
												}
											} else if (!btnModificar.isEnabled()) {
												Alumno buscado = aa.buscar(codAlumno);
												buscado.setNombres(nombre);
												buscado.setApellidos(apellidos);
												buscado.setEdad(edad);
												buscado.setCelular(celular);
												aa.actualizarAlumnos();
												listar();
												mensaje("Alumno modificado exitosamente");
												deshabilitarTodo();
											}
										} else {
											error("Especifique el estado del alumno", cboEstado);
										}	
									} else {
										error("Ingrese un número de celular válido", txtCelular);
									}
								} catch (Exception error) {
									error("Ingrese un número de celular válido", txtCelular);
								}
							} catch (Exception error) {
								error("Ingrese una edad válida", txtEdad);
							}
						} else {
							error("Ingrese un DNI válido", txtDni);
						}	
					} catch (Exception error) {
						error("Ingrese un DNI válido", txtDni);
					}
				} else {
					error("Ingrese los apellidos del alumno", txtApellidos);
				}
			} else {
				error("Ingrese el nombre del alumno", txtNombres);
			}
		} catch (Exception error) {
			error("Seleccione un código de alumno", cboCodigo);
		}
	}
	
	void botonCancelar() {
		deshabilitarTodo();
	}
	
	//traer los Get de las casillas
	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
	String leerNombres() {
		return txtNombres.getText().trim().toUpperCase();
	}
	String leerApellidos() {
		return txtApellidos.getText().trim().toUpperCase();
	}
	String leerDNI() {
		return txtDni.getText().trim().toUpperCase();
	}
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	int leerCelular() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	//Estado de matricula
	String nombreEstado(int i) {
		switch (i) {
			case 0: return "REGISTRADO";
			case 1: return "MATRICULADO";
			case 2: return "RETIRADO";
			default:return null;
		}
	}
	
	//Habilitar las casillas con excepciones
	void habilitar(boolean codigo,boolean nombre, boolean apellidos, boolean dni, boolean edad, boolean celular,
			boolean estado, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtNombres.setEditable(nombre);
		txtApellidos.setEditable(apellidos);
		txtDni.setEditable(dni);
		txtEdad.setEditable(edad);
		txtCelular.setEditable(celular);
		cboEstado.setEnabled(estado);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	
	//Desabilitar las casillas con excepciones
	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	
	//Limpiar casillas
	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		cboEstado.setSelectedIndex(-1);
	}
	//Listar Codigo
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodigo.addItem(aa.obtener(i).getCodAlumno());
		}
	}
	
	//Tabla
	void ajustarColumnas() {
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < aa.tamaño(); i++) {
			Object[] fila = {
					aa.obtener(i).getCodAlumno(),
					aa.obtener(i).getNombres(),
					aa.obtener(i).getApellidos(),
					aa.obtener(i).getDni(),
					aa.obtener(i).getEdad(),
					aa.obtener(i).getCelular(),
					nombreEstado(aa.obtener(i).getEstado()),
			};
			modelo.addRow(fila);
		}
	}
	//Alertar de DNI existente
	boolean existeDNI(String dni) {
		for (int i = 0; i < aa.tamaño(); i++) {
			if(aa.obtener(i).getDni().equals(dni))
				return true;
		}
		return false;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAlumno) {
			mouseClickedTblAlumno(e);
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
	protected void mouseClickedTblAlumno(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Alumno buscado = aa.obtener(tblAlumno.getSelectedRow());
				cboCodigo.setSelectedIndex(tblAlumno.getSelectedRow());
				txtNombres.setText(buscado.getNombres());
				txtApellidos.setText(buscado.getApellidos());
				txtDni.setText(buscado.getDni());
				txtEdad.setText("" + buscado.getEdad());
				txtCelular.setText("" + buscado.getCelular());
				cboEstado.setSelectedIndex(buscado.getEstado());
			} catch (Exception error) {
				
			}
		}
	}
	/*
	 * Mensajes de errores y de confirmaciones
	 * */
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		txt.selectAll();
		txt.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estás seguro que deseas eliminar a este alumno?\n"
				+ aa.buscar(leerCodigo()).getNombres() + " " + aa.buscar(leerCodigo()).getApellidos(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
}

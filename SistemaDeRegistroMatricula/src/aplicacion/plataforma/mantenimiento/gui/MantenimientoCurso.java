package aplicacion.plataforma.mantenimiento.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import aplicacion.plataforma.mantenimiento.arreglos.ArregloCurso;
import aplicacion.plataforma.mantenimiento.clase.Curso;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MantenimientoCurso extends JDialog implements ActionListener, MouseListener,  ItemListener  {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Integer> cboCodigo;
	private JComboBox<String> cboCiclo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTable tblCurso;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			MantenimientoCurso dialog = new MantenimientoCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoCurso() {
		setTitle("Mantenimiento Cursos");
		setBounds(100, 100, 797, 482);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.setBounds(122, 11, 185, 33);
		contentPanel.add(cboCodigo);
		
		cboCiclo = new JComboBox<String>();
		cboCiclo.addItemListener(this);
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO"}));
		cboCiclo.setBounds(122, 99, 185, 33);
		contentPanel.add(cboCiclo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(122, 55, 185, 33);
		contentPanel.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(122, 143, 100, 33);
		contentPanel.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setBounds(330, 143, 86, 33);
		contentPanel.add(txtHoras);
		txtHoras.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(478, 49, 118, 44);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(478, 114, 118, 44);
		contentPanel.add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(635, 11, 118, 44);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(635, 77, 118, 44);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(635, 143, 118, 44);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 761, 235);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(25, 20, 72, 24);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Asignatura");
		lblNewLabel_1.setBounds(25, 57, 88, 29);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ciclo");
		lblNewLabel_2.setBounds(25, 103, 58, 24);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Creditos");
		lblNewLabel_3.setBounds(25, 152, 72, 24);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cant. de Horas");
		lblNewLabel_4.setBounds(232, 147, 88, 24);
		contentPanel.add(lblNewLabel_4);
		
		tblCurso = new JTable();
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("CICLO");
		modelo.addColumn("CRÉDITOS");
		modelo.addColumn("HORAS");
		tblCurso.setModel(modelo);
		
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	ArregloCurso ac = new ArregloCurso();
	
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}
	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codCurso = leerCodigo();
			Curso buscado = ac.buscar(codCurso);
			txtAsignatura.setText(buscado.getAsignatura());
			cboCiclo.setSelectedIndex(buscado.getCiclo());
			txtCreditos.setText("" + buscado.getCreditos());
			txtHoras.setText("" + buscado.getHoras());
			tblCurso.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
		} catch (Exception error) {
			
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
		botonCancelar();
	}
	
	/*------------ BOTONES -----------------*/
	void botonAdicionar() {
		limpiar();
		habilitar(false, true, true, true, true, true, true, false, true, false);
		cboCodigo.addItem(ac.codigoCorrelativo());
		cboCodigo.setSelectedIndex(ac.tamaño());
		txtAsignatura.requestFocus();
	}
	
	void botonModificar() {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, true, true, true, true, true, true, true, false, false);
		cboCodigo.requestFocus();
	}
	
	void botonEliminar() {
		try {
			int codCurso = leerCodigo();
			if (confirmar() == 0) {
				Curso buscado = ac.buscar(codCurso);
				ac.eliminar(buscado);
				listar();
				mensaje("Curso eliminado exitosamente");
				deshabilitarTodo();
			}
		} catch (Exception error) {
			error("Seleccione un código de curso", cboCodigo);
		}
	}
	
	void botonAceptar() {
		try {
			int codCurso = leerCodigo();
			String asignatura = leerAsignatura();
			if (asignatura.length() != 0) {
				int ciclo = leerCiclo();
				if (ciclo != -1) {
					try {
						int creditos = leerCreditos();
						try {
							int horas = leerHoras();
							if (!btnAdicionar.isEnabled()) {
								Curso nuevo = new Curso(codCurso, asignatura, ciclo, creditos, horas);
								ac.adicionar(nuevo);
								listar();
								mensaje("Nuevo curso añadido exitosamente");
								deshabilitarTodo();
							} else if (!btnModificar.isEnabled()) {
								Curso buscado = ac.buscar(codCurso);
								buscado.setAsignatura(asignatura);
								buscado.setCiclo(ciclo);
								buscado.setCreditos(creditos);
								buscado.setHoras(horas);
								ac.actualizarCurso();
								listar();
								mensaje("Curso modificado exitosamente");
								deshabilitarTodo();
							}
						} catch (Exception error) {
							error("Ingrese un número de horas válido", txtHoras);
						}
					} catch (Exception error) {
						error("Ingrese una cantidad de créditos válida", txtCreditos);
					}
				} else {
					error("Seleccione el ciclo al que pertenece el curso", cboCiclo);
				}
			} else {
				error("Ingrese el nombre de la asignatura", txtAsignatura);
			}
		} catch (Exception error) {
			error("Seleccione un código de curso", cboCodigo);
		}
	}
	
	void botonCancelar() {
		deshabilitarTodo();
	}

	/*------------HABILITAR Y DESHABILITAR------------------*/
	void habilitar(boolean codigo,boolean asignatura, boolean ciclo, boolean creditos, boolean horas, 
			boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtAsignatura.setEditable(asignatura);
		cboCiclo.setEnabled(ciclo);
		txtCreditos.setEditable(creditos);
		txtHoras.setEditable(horas);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	
	/*------------- DATOS ---------------*/
	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(-1);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigo.addItem(ac.obtener(i).getCodCurso());
		}
	}
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblCurso.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*6);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*1);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamaño(); i++) {
			Object[] fila = {
					ac.obtener(i).getCodCurso(),
					ac.obtener(i).getAsignatura(),
					nombreCiclo(ac.obtener(i).getCiclo()),
					ac.obtener(i).getCreditos(),
					ac.obtener(i).getHoras()
			};
			modelo.addRow(fila);
		}
	}
	
	/*-------------CASILLAS ----------------*/
	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
	String leerAsignatura() {
		return txtAsignatura.getText().trim().toUpperCase();
	}
	int leerCiclo() {
		return cboCiclo.getSelectedIndex();
	}
	int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	int leerHoras() {
		return Integer.parseInt(txtHoras.getText().trim());
	}
	String nombreCiclo(int i) {
		switch (i) {
			case 0: return "PRIMERO";
			case 1: return "SEGUNDO";
			case 2: return "TERCERO";
			case 3: return "CUARTO";
			case 4: return "QUINTO";
			case 5: return "SEXTO";
			default:return null;
		}
	}
	
	/*-------------MENSAJES ------------------*/
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
				"¿Estás seguro que deseas eliminar este curso?\n"
				+ ac.buscar(leerCodigo()).getAsignatura(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	
	/*---------- AL DAR CLICK MOSTRAR EL CURSO -----------------*/
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCurso) {
			mouseClickedTblCurso(e);
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
	protected void mouseClickedTblCurso(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Curso buscado = ac.obtener(tblCurso.getSelectedRow());
				cboCodigo.setSelectedIndex(tblCurso.getSelectedRow());
				txtAsignatura.setText(buscado.getAsignatura());
				cboCiclo.setSelectedItem(buscado.getCiclo());
				txtCreditos.setText("" + buscado.getCreditos());
				txtHoras.setText("" + buscado.getHoras());
			} catch (Exception error) {
				
			}
		}
	}
}

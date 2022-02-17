package aplicacion.plataforma.consulta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class ConsultaCurso extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConsulta;
	private JComboBox cboCurso;
	private JLabel lblNewLabel;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTable tblCurso;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ConsultaCurso dialog = new ConsultaCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaCurso() {
		setTitle("Consulta de Curso");
		setBounds(100, 100, 522, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(378, 11, 118, 40);
		contentPanel.add(btnConsulta);
		
		cboCurso = new JComboBox();
		cboCurso.setBounds(107, 16, 190, 31);
		contentPanel.add(cboCurso);
		
		lblNewLabel = new JLabel("Consulta de curso");
		lblNewLabel.setBounds(10, 18, 118, 27);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 486, 198);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		tblCurso = new JTable();
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("CICLO");
		modelo.addColumn("CRÉDITOS");
		modelo.addColumn("HORAS");
		tblCurso.setModel(modelo);
		
		listar_combo();
	}
	ArregloCurso ac = new ArregloCurso();
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		String codCurso = (String) cboCurso.getSelectedItem();
		consultaCurso(Integer.parseInt(codCurso));
	}
	
	void consultaCurso(int codCurso) {
		Curso c = ac.buscar(codCurso);
	       
		DefaultTableModel dtm = (DefaultTableModel) tblCurso.getModel();
		dtm.setRowCount(0);
		String ciclo = "";
		          
		         ciclo = nombreCiclo(c.getCiclo());
				
			Object[] f = { codCurso, c.getAsignatura(), ciclo, c.getCreditos(),
					c.getHoras() };
			
			dtm.addRow(f);    
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
	
	void listar_combo() {
		Curso c;
		for (int i = 0; i < ac.tamaño(); i++) {
			c = ac.obtener(i);
			if (ac.procedeCodigoCurso(c.getCodCurso()))
				cboCurso.addItem("" + c.getCodCurso());
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

package aplicacion.plataforma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import aplicacion.plataforma.consulta.ConsultaAlumno;
import aplicacion.plataforma.consulta.ConsultaCurso;
import aplicacion.plataforma.consulta.ConsultaMatricula;
import aplicacion.plataforma.consulta.ConsultaRetiro;
import aplicacion.plataforma.mantenimiento.gui.MantenimientoAlumno;
import aplicacion.plataforma.mantenimiento.gui.MantenimientoCurso;
import aplicacion.plataforma.registro.gui.RegistroMatricula;
import aplicacion.plataforma.registro.gui.RegistroRetiro;
import aplicacion.plataforma.reporte.ReporteAlumnoConMatriculaPendiente;
import aplicacion.plataforma.reporte.ReporteAlumnoConMatriculaVigente;
import aplicacion.plataforma.reporte.ReporteAlumnoMatriculadoPorCurso;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Plataforma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmConsultaMatricula;
	private JMenuItem mntmConsultaCurso;
	private JMenuItem mntmConsultaRetiro;
	private JMenuItem mntmAlumnosConMatriculaPendiente;
	private JMenuItem mntmAlumnosMatriculadosPorCurso;
	private JMenuItem mntmAlumnosConMatriculaVigente;
	private JMenuItem mntmConsultaAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					Plataforma frame = new Plataforma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Plataforma() {
		setTitle("Sistema de Registro y Matricula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 376);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addActionListener(this);
		mnRegistro.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmConsultaAlumno = new JMenuItem("Alumno");
		mntmConsultaAlumno.addActionListener(this);
		mnConsulta.add(mntmConsultaAlumno);
		
		mntmConsultaCurso = new JMenuItem("Curso");
		mntmConsultaCurso.addActionListener(this);
		mnConsulta.add(mntmConsultaCurso);
		
		mntmConsultaMatricula = new JMenuItem("Matricula");
		mntmConsultaMatricula.addActionListener(this);
		mnConsulta.add(mntmConsultaMatricula);
		
		mntmConsultaRetiro = new JMenuItem("Retiro");
		mntmConsultaRetiro.addActionListener(this);
		mnConsulta.add(mntmConsultaRetiro);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmAlumnosConMatriculaPendiente = new JMenuItem("Alumnos con Matricula Pendiente");
		mntmAlumnosConMatriculaPendiente.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatriculaPendiente);
		
		mntmAlumnosConMatriculaVigente = new JMenuItem("Alumnos con Matricula Vigente");
		mntmAlumnosConMatriculaVigente.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatriculaVigente);
		
		mntmAlumnosMatriculadosPorCurso = new JMenuItem("Alumnos Matriculados por Curso");
		mntmAlumnosMatriculadosPorCurso.addActionListener(this);
		mnReporte.add(mntmAlumnosMatriculadosPorCurso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAlumnosMatriculadosPorCurso) {
			actionPerformedMntmAlumnosMatriculadosPorCurso(e);
		}
		if (e.getSource() == mntmAlumnosConMatriculaVigente) {
			actionPerformedMntmAlumnosConMatriculaVigente(e);
		}
		if (e.getSource() == mntmAlumnosConMatriculaPendiente) {
			actionPerformedMntmAlumnosConMatriculaPendiente(e);
		}
		if (e.getSource() == mntmConsultaRetiro) {
			actionPerformedMntmConsultaRetiro(e);
		}
		if (e.getSource() == mntmConsultaMatricula) {
			actionPerformedMntmConsultaMatricula(e);
		}
		if (e.getSource() == mntmConsultaCurso) {
			actionPerformedMntmConsultaCurso(e);
		}
		if (e.getSource() == mntmConsultaAlumno) {
			actionPerformedMntmConsultaAlumno(e);
		}
		if (e.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(e);
		}
		if (e.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(e);
		}
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int mensaje;
		
		mensaje = JOptionPane.showConfirmDialog(null, "¿Seguro desea salir?", "Mensaje importante!", 
				JOptionPane.YES_NO_OPTION);
		if(mensaje == 0) System.exit(0);
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		MantenimientoAlumno ma = new MantenimientoAlumno();
		ma.setVisible(true);
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		MantenimientoCurso mc = new MantenimientoCurso();
		mc.setVisible(true);
	}
	protected void actionPerformedMntmMatricula(ActionEvent e) {
		RegistroMatricula rm = new RegistroMatricula();
		rm.setVisible(true);
	}
	protected void actionPerformedMntmRetiro(ActionEvent e) {
		RegistroRetiro rr = new RegistroRetiro();
		rr.setVisible(true);
	}
	protected void actionPerformedMntmConsultaAlumno(ActionEvent e) {
		ConsultaAlumno ac = new ConsultaAlumno();
		ac.setVisible(true);
	}
	protected void actionPerformedMntmConsultaCurso(ActionEvent e) {
		ConsultaCurso cc = new ConsultaCurso();
		cc.setVisible(true);
	}
	protected void actionPerformedMntmConsultaMatricula(ActionEvent e) {
		ConsultaMatricula cm = new ConsultaMatricula();
		cm.setVisible(true);
	}
	protected void actionPerformedMntmConsultaRetiro(ActionEvent e) {
		ConsultaRetiro cr = new ConsultaRetiro();
		cr.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosConMatriculaPendiente(ActionEvent e) {
		ReporteAlumnoConMatriculaPendiente rp = new ReporteAlumnoConMatriculaPendiente();
		rp.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosConMatriculaVigente(ActionEvent e) {
		ReporteAlumnoConMatriculaVigente rv = new ReporteAlumnoConMatriculaVigente();
		rv.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosMatriculadosPorCurso(ActionEvent e) {
		ReporteAlumnoMatriculadoPorCurso rc = new ReporteAlumnoMatriculadoPorCurso();
		rc.setVisible(true);
	}
}

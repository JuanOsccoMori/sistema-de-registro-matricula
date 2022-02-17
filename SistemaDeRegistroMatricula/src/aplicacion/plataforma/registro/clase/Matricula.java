package aplicacion.plataforma.registro.clase;

public class Matricula {
	private int numero_matricula, codigo_alumno, codigo_curso;
	private String fecha, hora;
	public Matricula(int numero_matricula, int codigo_alumno, int codigo_curso, String fecha, String hora) {
		this.numero_matricula = numero_matricula;
		this.codigo_alumno = codigo_alumno;
		this.codigo_curso = codigo_curso;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(int numero_matricula) {
		this.numero_matricula = numero_matricula;
	}
	public int getCodigo_alumno() {
		return codigo_alumno;
	}
	public void setCodigo_alumno(int codigo_alumno) {
		this.codigo_alumno = codigo_alumno;
	}
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}

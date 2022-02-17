package aplicacion.plataforma.registro.clase;

public class Retiro {
	private int numero_de_retiro, numero_de_matricula;
	private String fecha, hora;
	public Retiro(int numero_de_retiro, int numero_de_matricula, String fecha, String hora) {
		this.numero_de_retiro = numero_de_retiro;
		this.numero_de_matricula = numero_de_matricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getNumero_de_retiro() {
		return numero_de_retiro;
	}
	public void setNumero_de_retiro(int numero_de_retiro) {
		this.numero_de_retiro = numero_de_retiro;
	}
	public int getNumero_de_matricula() {
		return numero_de_matricula;
	}
	public void setNumero_de_matricula(int numero_de_matricula) {
		this.numero_de_matricula = numero_de_matricula;
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

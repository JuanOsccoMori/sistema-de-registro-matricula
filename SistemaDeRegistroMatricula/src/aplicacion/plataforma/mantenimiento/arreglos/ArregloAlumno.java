package aplicacion.plataforma.mantenimiento.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import aplicacion.plataforma.mantenimiento.clase.Alumno;

public class ArregloAlumno {
	//Atributo de arreglo alumnos
	private ArrayList<Alumno> alumno;
		
	//Arreglo de alumnos
	public ArregloAlumno() {
		alumno = new ArrayList<Alumno>();
		cargarAlumno();
	}
		
	//Agregar alumnos
	public void adicionar(Alumno x) {
		alumno.add(x);
		grabarAlumno();
	}
		
	//eliminar alumno
	public void eliminar(Alumno x) {
		alumno.remove(x);
		grabarAlumno();
	}
		
	//Acutalizar alumnos
	public void actualizarAlumnos() {
		grabarAlumno();
	}
		
	//obtener tamaño
	public int tamaño() {
		return alumno.size();
	}
		
	//mostrar alumnos
	public Alumno obtener(int i) {
		return alumno.get(i);
	}
		
	//Buscar alumnos
	public Alumno buscar(int codigo) {
		for(int i = 0; i < alumno.size(); i++) {
			if(alumno.get(i).getCodAlumno() == codigo) return alumno.get(i);
		}
		return null;
	}
		
	//Codigo correlativo
	public int codigoCorrelativo () {
		if(alumno.size() == 0) return 202110001;
		return alumno.get(alumno.size() - 1).getCodAlumno() + 1;
	}
		
	//Grabar alumnos
	private void grabarAlumno() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i = 0; i< alumno.size(); i++) {
				x = alumno.get(i);
				linea = x.getCodAlumno() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
	}
		
	//poner en txt los alumnos
	private void cargarAlumno() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni;
			String[] s;
			int codAlumno, edad, celular, estado;
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
		
	public boolean procedeCodigoAlumno(int codAlumno){
		for (int i = tamaño()-1; i >= 0; i--) {
			if(obtener(i).getCodAlumno() == codAlumno);
		}
		return true;
	}
}


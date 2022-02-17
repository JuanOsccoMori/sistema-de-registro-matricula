package aplicacion.plataforma.mantenimiento.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import aplicacion.plataforma.mantenimiento.clase.Curso;

public class ArregloCurso {
	private ArrayList<Curso> curso;
	
	public ArregloCurso() {
		curso = new ArrayList<Curso>();
		cargarCurso();
	}
	
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCurso();
	}
	
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCurso();
	}
	
	public void actualizarCurso() {
		grabarCurso();
	}
	
	public int tamaño() {
		return curso.size();
	}
	
	public Curso obtener(int i) {
		return curso.get(i);
	}
	
	public Curso buscar(int codigo) {
		for(int i = 0; i < curso.size(); i++) {
			if(curso.get(i).getCodCurso() == codigo) return curso.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if(curso.size() == 0) return 101;
		return curso.get(curso.size() - 1).getCodCurso() + 1;
	}
	
	private void grabarCurso() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("cursos.txt"));
			for(int i = 0; i< curso.size(); i++) {
				x = curso.get(i);
				linea = x.getCodCurso() + ";" +
						x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Aca esta el error: " + e);
		}
	}
	
	private void cargarCurso() {
		try {
			BufferedReader br;
			int codCurso, ciclo, creditos, horas;
			String asignatura, linea;
			String[] s;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				adicionar(new Curso(codCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Aca esta el error: " + e);
		}
	}
	
	public boolean procedeCodigoCurso(int codCurso) {
		for(int i = tamaño() - 1; i >= 0; i--) {
			if(obtener(i).getCodCurso() == codCurso);
		}
		return true;
	}
}

package aplicacion.plataforma.registro.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import aplicacion.plataforma.registro.clase.Matricula;

public class ArregloMatricula {

	//Atributo de arreglo
		private ArrayList<Matricula> matricula;
		
		//Arreglo de matricula
		public ArregloMatricula() {
			matricula = new ArrayList<Matricula>();
			cargarMatriculas();
		}
		
		//Adicionar matricula
		public void adicionar(Matricula x) {
			matricula.add(x);
			grabarMatriculas();
		}
		
		//Eliminar Matricula
		public void eliminar(Matricula x) {
			matricula.remove(x);
			grabarMatriculas();
		}
		
		//Actualizar el archivo
		public void actualizarMatricula() {
			grabarMatriculas();
		}
		
		//cantidad de matriculados
		public int tamaño() {
			return matricula.size();
		}
		
		//obtener a los matriculados
		public Matricula obtener(int i) {
			return matricula.get(i);
		}
		
		//Buscar matricula
		public Matricula buscar(int codigo) {
			for(int i = 0; i < tamaño(); i++) {
				if(obtener(i).getNumero_matricula() == codigo) return obtener(i);
			}
			return null;
		}
		
		//Buscar codigo
		public Matricula buscarCodigo(int codigo) {
			for(int i = 0; i < tamaño(); i++) {
				if (obtener(i).getCodigo_alumno() == codigo) return obtener(i);
			}
			return null;
		}
		
		//Creacion de codigos
		public int codigoCorrelativo() {
			if(tamaño() == 0) return 100001;
			return obtener(tamaño() - 1).getNumero_matricula() + 1;
		}
		
		//Grabar Matriculas
		private void grabarMatriculas() {
			try {
				PrintWriter pw;
				String linea;
				Matricula x;
				pw = new PrintWriter(new FileWriter("matriculas.txt"));
				for(int i = 0; i < matricula.size(); i++) {
					x = matricula.get(i);
					linea = x.getNumero_matricula() + ";" +
							x.getCodigo_alumno() + ";" +
							x.getCodigo_curso() + ";" +
							x.getFecha() + ";" +
							x.getHora();
					pw.println(linea);
				}
				pw.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error : " + e);
			}
		}
		
		//Cargar matriculas
		private void cargarMatriculas() {
			try {
				BufferedReader br;
				int numero_de_matricula, codigo_alumno, codigo_curso;
				String fecha, hora, linea;
				String[] s;
				br = new BufferedReader(new FileReader("matriculas.txt"));
				while ((linea = br.readLine())!= null) {
					s = linea.split(";");
					numero_de_matricula = Integer.parseInt(s[0].trim());
					codigo_alumno = Integer.parseInt(s[1].trim());
					codigo_curso = Integer.parseInt(s[2].trim());
					fecha = s[3].trim();
					hora = s[4].trim();
					adicionar(new Matricula(numero_de_matricula, codigo_alumno, codigo_curso, fecha, hora));
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error : " + e);
			}
			
		}
		
		public boolean procedeNumeroMatricula(int numMatricula){
			for (int i = tamaño()-1; i >= 0; i--) {
				if(obtener(i).getNumero_matricula() == numMatricula);
			}
			return true;
		}
}

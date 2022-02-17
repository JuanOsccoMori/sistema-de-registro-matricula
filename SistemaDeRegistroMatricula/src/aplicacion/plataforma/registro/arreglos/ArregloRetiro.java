package aplicacion.plataforma.registro.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import aplicacion.plataforma.registro.clase.Retiro;

public class ArregloRetiro {
	//Atributo Array
		private ArrayList<Retiro> retiro;
		
		//Constructor
		public ArregloRetiro() {
			retiro = new ArrayList<Retiro>();
			cargarRetiros();
		}
		
		//Agregar retiros
		public void adicionar(Retiro x) {
			retiro.add(x);
			grabarRetiros();
		}

		//Eliminar retiro
		public void eliminar(Retiro x) {
			retiro.remove(x);
			grabarRetiros();
		}
		
		//Actualizar
		public void actualizarRetirp() {
			grabarRetiros();
		}
		//retornar tamaño
		public int tamaño() {
			return retiro.size();
		}
		
		//obtener los retiros
		public Retiro obtener(int i) {
			return retiro.get(i);
		}
		
		//Agregar numeros al numero de retiro
		public int codigoCorrelativo() {
			if(tamaño() == 0) return 200001;
			return obtener(tamaño() - 1).getNumero_de_retiro() + 1;
		}
		
		//Buscar
		public Retiro buscar(int codigo) {
			for(int i = 0; i < tamaño(); i++) {
				if(obtener(i).getNumero_de_retiro() == codigo)return obtener(i);
			}
			return null;
		}
		
		//Grabar los retiros
		private void grabarRetiros() {
			try {
				PrintWriter pw;
				String linea;
				Retiro x;
				pw = new PrintWriter(new FileWriter("retiros.txt"));
				for(int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getNumero_de_retiro() + ";" +
							x.getNumero_de_matricula() + ";" + 
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
		
		//Cargar retiros
		private void cargarRetiros() {
			try {
				BufferedReader br;
				int numero_de_retiro, numero_de_matricula;
				String fecha, hora, linea;
				String[] s;
				br = new BufferedReader(new FileReader("retiros.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					numero_de_retiro = Integer.parseInt(s[0].trim());
					numero_de_matricula = Integer.parseInt(s[1].trim());
					fecha = s[2].trim();
					hora = s[3].trim();
					adicionar(new Retiro(numero_de_retiro, numero_de_matricula, fecha, hora));
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error : " + e);
			}
		}
		
		public boolean procedeNumeroRetiros(int numRetiros){
			for (int i = tamaño()-1; i >= 0; i--) {
				if(obtener(i).getNumero_de_retiro() == numRetiros);
			}
			return true;
		}
}

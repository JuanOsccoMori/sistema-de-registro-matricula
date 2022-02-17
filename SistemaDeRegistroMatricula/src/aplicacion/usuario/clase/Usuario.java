package aplicacion.usuario.clase;

import aplicacion.usuario.lista.*;
import java.util.Vector;

public class Usuario {
	private String email, contrase�a, rango;

	/*-- Get and Set ---*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}
	
	/*--- Mostrar lista de usuarios ---*/
	public static Vector mostrar() {
		return ListaUsuario.mostrar();
	}
	
	/*--- Verificar un nuevo usuario ---*/
	public static int verificarUsuarioNuevo(String usuario) {
		Vector lista = mostrar();
		Usuario obj;
		for(int i = 0; i < lista.size(); i++) {
			obj = (Usuario) lista.elementAt(i);
			if(obj.getEmail().equalsIgnoreCase(usuario)) {
				return i;
			}
		}
		return -1;
	}
	
	/*--- Verificar el ingreso ---*/
	public static int verificarIngreso(String usuario, String contrase�a) {
		Vector lista = mostrar();
		Usuario obj;
		for(int i = 0; i < lista.size(); i++) {
			obj = (Usuario) lista.elementAt(i);
			if(obj.getEmail().equalsIgnoreCase(usuario) && obj.getContrase�a().equalsIgnoreCase(contrase�a)) {
				return i;
			}
		}
		return -1;
	}
	
}

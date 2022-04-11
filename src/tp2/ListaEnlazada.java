package tp2;

public class ListaEnlazada {

	public Nodo cabecera;
	private Nodo fin;
	
	public ListaEnlazada() {
		this.cabecera = null;
		this.fin = null;
	}
	
	public void insertar(int numero) {
		if (this.cabecera == null) {
			this.cabecera = new Nodo(numero);
			this.fin = this.cabecera;
		}
		else {
			Nodo nuevoNodo = new Nodo (numero);
			this.fin.cambiarSiguiente(nuevoNodo);
			this.fin = nuevoNodo;
		}
	}
	
}

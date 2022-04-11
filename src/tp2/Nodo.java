package tp2;

public class Nodo {
	
	int valor;
	Nodo siguiente;
	
	public Nodo(int numero) {
		this.valor = numero;
		this.siguiente = null;
	}
	
	public void cambiarSiguiente(Nodo nuevoSiguiente) {
		this.siguiente = nuevoSiguiente;
	}
	
}

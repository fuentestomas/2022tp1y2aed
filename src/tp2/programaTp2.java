package tp2;
import java.util.Scanner;

public class programaTp2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ListaEnlazada lista;
		int cantidadNodos = 0;
		boolean numeroValido = false;
		
		System.out.println("Ingrese la cantidad de valores que desea generar");
		while (!numeroValido) {
			cantidadNodos = entrada.nextInt();
			if (cantidadNodos > 0) {
				numeroValido = true;
			}
			else {
				System.out.println("Ingrese un numero mayor a 0");
			}
		}
		
		lista = generarLista(cantidadNodos);
		calcularPromedio(lista, cantidadNodos);
	}
	
	public static ListaEnlazada generarLista(int cantidadNodos) {
		long tiempoInicial, tiempoFinal;
		tiempoInicial = System.currentTimeMillis();
		double aleatorio;
		
		ListaEnlazada lista = new ListaEnlazada();
		for (int i = 0; i < cantidadNodos; i++) {
			aleatorio = Math.random() * 1000;
			lista.insertar((int)aleatorio);
		}
		
		tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("La generacion de la lista tardo "+tiempoFinal+" milisegundos\r\n");
		
		return lista;
	}
	
	public static void calcularPromedio(ListaEnlazada lista, int cantidadNodos) {
		long tiempoInicial, tiempoFinal;
		tiempoInicial = System.currentTimeMillis();
		Nodo actualNodo = lista.cabecera;
		double acumulador = 0;
		
		while (actualNodo != null) {
//			System.out.println(actualNodo.valor);
			acumulador = acumulador + actualNodo.valor;
			actualNodo = actualNodo.siguiente;
		}
		
		System.out.println("El promedio de los valores generados es "+acumulador/cantidadNodos+"\r\n");
		
		tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("El calculo de promedio tardo "+tiempoFinal+" milisegundos\r\n");
	}

}

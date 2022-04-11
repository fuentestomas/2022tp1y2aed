package tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class generadorCsv {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int filas = 0, columnas = 0;
		File archivoCsv;
		boolean numeroValido = false;
		
		System.out.println("Ingrese la cantidad de filas que desea que tenga el archivo");
		while (!numeroValido) {
			filas = entrada.nextInt();
			if (filas > 0) {
				numeroValido = true;
			}
			else {
				System.out.println("Ingrese un numero mayor a 0");
			}
		}
		
		numeroValido = false;
		System.out.println("Ingrese la cantidad de columna que desea que tenga el archivo");
		while (!numeroValido) {
			columnas = entrada.nextInt();
			if (columnas > 0) {
				numeroValido = true;
			}
			else {
				System.out.println("Ingrese un numero mayor a 0");
			}
		}
		
		archivoCsv = generarArchivo(filas, columnas);
		leerArchivo(archivoCsv, filas, columnas);
	}
	
	public static File generarArchivo(int filas, int columnas) {
		long tiempoInicial, tiempoFinal;
		tiempoInicial = System.currentTimeMillis();
		double aleatorio;
		File archivoCsv = new File ("archivoTp-"+filas+"x"+columnas+".ascii");
		
		try {
			PrintWriter printWriter = new PrintWriter(archivoCsv);
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					aleatorio = Math.random() * 1000;
					stringBuilder.append((int)aleatorio);
					stringBuilder.append(",");
				}
				stringBuilder.append("\r\n");
			}
			
			printWriter.write(stringBuilder.toString());
			printWriter.close();
			System.out.println("Archivo generado\r\n");
		}
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		
		tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("La generacion del archivo tardo "+tiempoFinal+" milisegundos\r\n");
		
		return archivoCsv;
	}
	
	public static void leerArchivo(File archivoCsv, int filas, int columnas) {
		long tiempoInicial, tiempoFinal;
		tiempoInicial = System.currentTimeMillis();
		
		try {
			Scanner scannerArchivo = new Scanner(archivoCsv);
			int acumuladorTotal = 0;
			int acumuladorFila;
			int contadorFilas = 1;
			String lineaArchivo;
			
			while (scannerArchivo.hasNextLine()) {
				lineaArchivo = scannerArchivo.nextLine();
				ArrayList<String> fila = new ArrayList<String>(Arrays.asList(lineaArchivo.split(",")));
//				System.out.println("La fila "+contadorFilas+" es " +fila);
				acumuladorFila = 0;
				for (int i = 0; i < columnas; i++) {
					acumuladorFila = acumuladorFila + Integer.parseInt(fila.get(i));
				}
				acumuladorTotal = acumuladorTotal + acumuladorFila;
				System.out.println("El promedio de la fila "+contadorFilas+" es igual a "+Double.valueOf(acumuladorFila)/columnas+"\r\n");
				contadorFilas++;
			}
			
			System.out.println("El promedio total es igual a "+Double.valueOf(acumuladorTotal)/(filas*columnas)+"\r\n");
		}
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		
		tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("La lectura del archivo tardo "+tiempoFinal+" milisegundos\r\n");
	}

}

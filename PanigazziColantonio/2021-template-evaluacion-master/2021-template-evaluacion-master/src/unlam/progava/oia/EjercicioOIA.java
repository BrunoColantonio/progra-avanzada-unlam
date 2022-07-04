package unlam.progava.oia;

import java.util.ArrayList;

public class EjercicioOIA {
	Grafo grafo = null;
	int tiradas;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();

		ejercicio.leer("src/unlam/progava/oia/in/05.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/05.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la consigna desde el archivo.
	 */
	public void leer(String path) {
		grafo = ArchivoManager.leer(path);

	}

	/**
	 * Este método se encarga de escribir la salida de la consigna en el archivo.
	 */
	public void escribir(String path) {
		ArchivoManager.escribir(path, tiradas);
	}

	/**
	 * Este método debe realizar la resolución del ejercicio. NO DEBE SITUARSE LA
	 * LOGICA AQUI, sino que se pueden utilizar clases adicionales, y los objetos
	 * creados en la etapa de lectura. Utilizar este mismo paquete para toda la
	 * resolución.
	 */
	public void resolver() {
		int[] distancias = grafo.dijkstra(0);

		ArrayList<Integer> camino = grafo.getCamino(24);

		for (Integer integer : camino) {
			System.out.print((integer + 1) + " ");
		}

		System.out.println();

		System.out.println(distancias[24]);
	}
}

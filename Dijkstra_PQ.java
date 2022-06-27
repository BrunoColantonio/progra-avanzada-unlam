import java.util.ArrayList;
import java.util.PriorityQueue;


// a.log(n)
public class Dijkstra_PQ {

	private int matrizAdy[][];
	private int nodoInicial;
	private int[] padre;

	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.padre = new int[matrizAdy.length];
	}

	public int[] dijkstra(int nodoInicial) {
		int distancia[] = new int[matrizAdy.length];
		boolean visitado[] = new boolean[matrizAdy.length];
		int infinito = Integer.MAX_VALUE;

		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();


		for (int i = 0; i < matrizAdy.length; i++) {
			distancia[i] = infinito;
			padre[i] = infinito;
			visitado[i] = false;
		}

		distancia[nodoInicial] = 0;
		pq.add(new Nodo(nodoInicial, distancia[nodoInicial]));

		while (!pq.isEmpty()) {
			Nodo nodo = pq.remove();
			int nodoActual = nodo.getNodo();
			visitado[nodoActual] = true;

			for (int i = 0; i < matrizAdy.length; i++) {
				if (matrizAdy[nodoActual][i] > 0) {
					if (!visitado[i] && (distancia[i] > (distancia[nodoActual] + matrizAdy[nodoActual][i]))) {
						distancia[i] = distancia[nodoActual] + matrizAdy[nodoActual][i];
						padre[i] = nodoActual;
						pq.add(new Nodo(i, distancia[i]));
					}

				}
			}
		}

		return distancia;
	}

	public ArrayList<Integer> getCamino(int nodoHasta) {
		int i = nodoHasta;
		ArrayList<Integer> camino = new ArrayList<Integer>();
		camino.add(i);

		while (i != nodoInicial) {
			i = padre[i];
			camino.add(i);
		}

		return camino;
	}
}

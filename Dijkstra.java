import java.util.ArrayList;

public class Dijkstra {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public Dijkstra(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public int[] dijkstra(int nodoInicial) {
		boolean conjSol[] = new boolean[cantNodos];
		int dist[] = new int[cantNodos];
		this.nodoInicial = nodoInicial;

		for (int i = 0; i < cantNodos; i++) {
			dist[i] = infinito;
			padre[i] = nodoInicial;
		}

		dist[nodoInicial] = 0;

		int nodoActual = nodoInicial;
		for (int i = 0; i < cantNodos; i++) {
			conjSol[nodoActual] = true;

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				if (matrizAdy[nodoActual][vecino] > 0 && matrizAdy[nodoActual][vecino] != infinito) {
					if (conjSol[vecino] == false) {

						int minimoTentativo = dist[nodoActual] + matrizAdy[nodoActual][vecino];

						if (minimoTentativo < dist[vecino]) {
							dist[vecino] = minimoTentativo;

							padre[vecino] = nodoActual;
						}
					}
				}

				nodoActual = hallarNodoMinDist(conjSol, dist);
			}
		}
		return dist;
	}

	public int hallarNodoMinDist(boolean[] conjSol, int[] dist) {
		int minKey = Integer.MAX_VALUE;
		int nodo = 0;

		for (int i = 0; i < matrizAdy.length; i++) {

			if (conjSol[i] == false && dist[i] < minKey) {
				minKey = dist[i];
				nodo = i;
			}
		}
		return nodo;
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

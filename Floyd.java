import java.util.ArrayList;

public class Floyd {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public Floyd (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public int[][] floyd() {
		int dist[][] = new int[cantNodos][cantNodos];
		dist = matrizAdy.clone();

		for (int i = 0; i < cantNodos; i++) {
			dist[i][i] = 0;
		}

		for (int k = 0; k < cantNodos; k++) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = 0; j < cantNodos; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		return dist;
	}

}

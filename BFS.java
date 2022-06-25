import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public BFS(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();

	}

	public void BFS(int nodoInicial) {
		boolean estado[] = new boolean[cantNodos];
		int dist[] = new int[cantNodos];
		int padre[] = new int[cantNodos];
		Queue<Integer> cola = new LinkedList<>();

		estado[nodoInicial] = true;
		cola.offer(nodoInicial);
		dist[nodoInicial] = 0;

		while (!cola.isEmpty()) {
			int nodo = cola.poll();
			for (int i = 0; i < cantNodos; i++) {
				if (matrizAdy[nodo][i] > 0 && matrizAdy[nodo][i] != infinito) {
					if (estado[i] == false) {
						estado[i] = true;
						dist[i] = dist[nodo] + 1;
						padre[i] = nodo;
						cola.offer(i);
					}
				}
			}
		}
	}
}

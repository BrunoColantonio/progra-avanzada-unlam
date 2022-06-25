import java.util.ArrayList;
import java.util.Stack;

public class DFS {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public DFS(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public void DFS(int nodoInicial) {
		boolean estado[] = new boolean[cantNodos];
		Stack<Integer> pila = new Stack<Integer>();

		estado[nodoInicial] = true;
		pila.push(nodoInicial);

		while (!pila.isEmpty()) {
			int nodo = pila.pop();
			for (int i = 0; i < cantNodos; i++) {
				if (matrizAdy[nodo][i] > 0 && matrizAdy[nodo][i] != infinito) {
					if (estado[i] == false) {
						estado[i] = true;
						pila.push(i);
					}
				}
			}
		}
	}
}

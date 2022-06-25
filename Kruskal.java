import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskal {
	
	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;	
	private ArrayList<Arista> aristas;
	
	public Kruskal (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public ArrayList<Arista> kruskal() {

		PriorityQueue<Arista> pq = new PriorityQueue<Arista>(aristas.size());

		for (Arista arista : aristas) {
			pq.add(arista);
		}

		int padre[] = new int[cantNodos];

		makeSet(padre);

		ArrayList<Arista> mst = new ArrayList<Arista>();

		int i = 0;

		while (i < cantNodos - 1) {

			Arista ari = pq.remove();

			int padre_x = find(padre, ari.getOrigen());
			int padre_y = find(padre, ari.getDestino());

			if (padre_x != padre_y) {

				mst.add(ari);

				i++;

				union(padre, padre_x, padre_y);
			}
		}
		return mst;
	}

	public void agregarArista(int origen, int destino, int costo) {
		Arista ari = new Arista(origen, destino, costo);
		if (!aristas.contains(ari)) {
			aristas.add(ari);
		}
	}

	public void encontrarAristas() {
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (matrizAdy[i][j] > 0 && matrizAdy[i][j] != infinito) {
					agregarArista(i, j, matrizAdy[i][j]);
				}
			}
		}
	}

	public void makeSet(int padre[]) {
		for (int i = 0; i < padre.length; i++) {
			padre[i] = i;
		}
	}

	public int find(int padre[], int nodo) {
		if (padre[nodo] != nodo) {
			return find(padre, padre[nodo]);
		}

		return nodo;
	}

	public void union(int padre[], int x, int y) {
		x = find(padre, x);
		y = find(padre, y);

		if (x != y) {
			padre[y] = x;
		}
	}

	public void mostrarMST(ArrayList<Arista> mst) {
		for (Arista arista : mst) {
			System.out.println("Origen: " + arista.getOrigen() + " Costo: " + arista.getCosto() + "Destino: "
					+ arista.getDestino());
		}
	}
}

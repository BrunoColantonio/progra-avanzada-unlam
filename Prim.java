import java.util.PriorityQueue;

public class Prim {
	
	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;	
	private ArrayList<Arista> aristas;
	
	public Prim (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public int prim(int nodoInicial) {
		int costo = 0;
		boolean visitado[] = new boolean[cantNodos];
		
		PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
		
		visitado[nodoInicial] = true;
		int visitados = 1;
		
		agregarAristasAdyacentes(pq, nodoInicial);
		
		while (!pq.isEmpty() && visitados != cantNodos) {
			Arista ari = pq.remove();
			
			
			if (!visitado[ari.getDestino()]) {
				visitado[ari.getDestino()] = true;
				costo += ari.getCosto();
				
				agregarAristasAdyacentes(pq, ari.getDestino());
				visitados++;
			}
		}
		
		
		if (visitados < cantNodos)
			return -1;

		return costo;		
	}
	
	
	
	public void agregarAristasAdyacentes(PriorityQueue<Arista> pq, int nodo) {
		for (int i = 0; i < cantNodos; i++) {
			if (matrizAdy[nodo][i] > 0 && matrizAdy[nodo][i] != infinito) {
				pq.add(new Arista(nodo, i, matrizAdy[nodo][i]));
			}
		}		
	}
}

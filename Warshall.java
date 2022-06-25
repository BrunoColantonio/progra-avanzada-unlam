import java.util.ArrayList;

public class Warshall {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public Warshall (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public boolean[][] warshall() {
		boolean mct[][] = new boolean[cantNodos][cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (matrizAdy[i][j] > 0 && matrizAdy[i][j] != infinito) {
					mct[i][j] = true;
				}

			}
		}

		for (int k = 0; k < cantNodos; k++) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = 0; j < cantNodos; j++) {
					if (mct[i][j] || (mct[i][k] && mct[k][j])) {
						mct[i][j] = true;
					}
				}
			}
		}

		return mct;
	}
}

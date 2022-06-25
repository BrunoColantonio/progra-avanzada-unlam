
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Coloreo {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int padre[];
	private int nodoInicial;
	private ArrayList<Arista> aristas;

	public Coloreo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.padre = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}

	public void coloreo(int cantPasadas) {
		ArrayList<Nodo> noColoreados = new ArrayList<Nodo>();
		ArrayList<Color> colores = new ArrayList<Color>();
		boolean encontrado;

		hallarGrados(noColoreados);

		for (int i = 0; i < cantPasadas; i++) {
			Collections.sort(noColoreados, Collections.reverseOrder());

			int colorActual = 1;

			while (!noColoreados.isEmpty()) {

				Color color = new Color(colorActual);
				colores.add(color);

				Iterator<Nodo> iter = noColoreados.iterator();

				while (iter.hasNext()) {
					Nodo nodo = iter.next();
					encontrado = false;

					for (Nodo nodoPintado : color.getNodos()) {
						if (matrizAdy[nodo.getNodo()][nodoPintado.getNodo()] > 0
								&& matrizAdy[nodo.getNodo()][nodoPintado.getNodo()] != infinito) {
							encontrado = true;
						}
					}

					if (encontrado == false) {
						iter.remove();
						color.getNodos().add(nodo);
					}
				}
				colorActual++;
			}

			hallarGrados(noColoreados);
			desordenar(noColoreados);
		}
	}

	public void desordenar(ArrayList<Nodo> lista) {
		int indice1 = (int) Math.floor(Math.random() * lista.size());
		int indice2 = (int) Math.floor(Math.random() * lista.size());

		Collections.swap(lista, indice1, indice2);
	}

	public void hallarGrados(ArrayList<Nodo> lista) {
		int cant = 0;

		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (matrizAdy[i][j] > 0 && matrizAdy[i][j] != infinito) {
					cant++;
				}
			}
			Nodo n = new Nodo(i, cant);
			lista.add(n);
			cant = 0;
		}
	}
}

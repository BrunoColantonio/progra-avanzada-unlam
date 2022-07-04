package unlam.progava.oia;

public class Nodo implements Comparable<Nodo> {

	private int nodo;
	private int peso;

	public Nodo(int nodo, int peso) {
		this.nodo = nodo;
		this.peso = peso;
	}

	public int getNodo() {
		return nodo;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public int compareTo(Nodo o) {
		if (this.peso > o.peso) {
			return 1;
		} else if (this.peso < o.peso) {
			return -1;
		}
		return 0;
	}
}
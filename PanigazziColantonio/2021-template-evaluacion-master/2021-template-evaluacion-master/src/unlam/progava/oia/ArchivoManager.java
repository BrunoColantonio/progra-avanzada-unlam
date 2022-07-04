package unlam.progava.oia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ArchivoManager {

	public static Grafo leer(String path) {
		Scanner scanner = null;
		Grafo grafo = null;

		try {
			File file = new File(path);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int[][] matAdy = new int[25][25];

			for (int i = 0; i < matAdy.length; i++) {
				for (int j = 0; j < matAdy.length; j++) {
					matAdy[i][j] = Integer.MAX_VALUE;
				}

			}

			for (int i = 0; i < matAdy.length; i++) {
				for (int j = i; j < i + 7; j++) {
					matAdy[i][j] = 1;
					if (j == matAdy.length - 1)
						j = i + 7;
				}

			}
			int cantSer = scanner.nextInt();
			int cabeza;
			int cola;
			for (int s = 0; s < cantSer; s++) {
				cola = scanner.nextInt() - 1;
				cabeza = scanner.nextInt() - 1;

				for (int i = 0; i < matAdy.length; i++) {
					matAdy[cabeza][i] = Integer.MAX_VALUE;
				}
				matAdy[cabeza][cola] = cabeza - cola;

			}

			int cantEsc = scanner.nextInt();
			int basesEsc;
			int topEsc;
			;

			for (int e = 0; e < cantEsc; e++) {
				basesEsc = scanner.nextInt() - 1;
				topEsc = scanner.nextInt() - 1;
				matAdy[basesEsc][topEsc] = 0;

			}

			grafo = new Grafo(matAdy);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return grafo;

	}

	public static void escribir(String path, int tiradas) {

		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(path);
			printerWriter = new PrintWriter(file);
			printerWriter.print(tiradas);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

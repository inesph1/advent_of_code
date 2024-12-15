package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Diciembre_4_pt2 {

	public static int calcularEjeDiagonal(int ejeX, int ejeY, int contador, char celdas[][]) {

		// limitador pa las null
		if ((ejeX >= 1 && ejeY >= 1) && (ejeX < celdas.length - 1 && ejeY < celdas.length - 1)) {

			// casos
			if ((celdas[ejeX - 1][ejeY - 1] == celdas[ejeX + 1][ejeY - 1]) && (celdas[ejeX - 1][ejeY - 1] == 'M')
					&& ((celdas[ejeX - 1][ejeY + 1] == celdas[ejeX + 1][ejeY + 1])
							&& (celdas[ejeX - 1][ejeY + 1] == 'S'))) {
				contador++;
			}

			if ((celdas[ejeX - 1][ejeY - 1] == celdas[ejeX - 1][ejeY + 1]) && (celdas[ejeX - 1][ejeY - 1] == 'M')
					&& ((celdas[ejeX + 1][ejeY - 1] == celdas[ejeX + 1][ejeY + 1])
							&& (celdas[ejeX + 1][ejeY - 1] == 'S'))) {
				contador++;
			}

			if ((celdas[ejeX - 1][ejeY - 1] == celdas[ejeX + 1][ejeY - 1]) && (celdas[ejeX - 1][ejeY - 1] == 'S')
					&& ((celdas[ejeX - 1][ejeY + 1] == celdas[ejeX + 1][ejeY + 1])
							&& (celdas[ejeX - 1][ejeY + 1] == 'M'))) {
				contador++;
			}
			if ((celdas[ejeX - 1][ejeY - 1] == celdas[ejeX - 1][ejeY + 1]) && (celdas[ejeX - 1][ejeY - 1] == 'S')
					&& ((celdas[ejeX + 1][ejeY - 1] == celdas[ejeX + 1][ejeY + 1])
							&& (celdas[ejeX + 1][ejeY - 1] == 'M'))) {
				contador++;
			}

		}

		return contador;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char celdas[][];

		int contador = 0;
		int ejeX = 0;
		int ejeY = 0;

		// x fila y columna
		List<String> filas = new ArrayList();

		try (BufferedReader br = new BufferedReader(new FileReader("./input_4.txt"))) {
			// try (BufferedReader br = new BufferedReader(new FileReader("./xmas.txt"))) {
			String l;

			while ((l = br.readLine()) != null) {

				filas.add(l);
				contador++;
			}

			ejeX = contador;
			ejeY = contador;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contador = 0;
		celdas = new char[ejeX][ejeY];

		// inicializa celdas y guarda valor
		for (int i = 0; i < filas.size(); i++) {
			for (int j = 0; j < filas.size(); j++) {
				celdas[i][j] = filas.get(i).charAt(j);

			}
		}

		// conteo elementos

		for (int x = 0; x < celdas.length; x++) {
			for (int y = 0; y < celdas.length; y++) {

				if (celdas[x][y] == 'A') {

					contador = calcularEjeDiagonal(x, y, contador, celdas);

				}

			}
		}
		System.out.println("CONTADOR " + contador);

	}

}

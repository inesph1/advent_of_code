package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Diciembre_4 {

	public static int calcularEjeHorizontal(int ejeX, int ejeY, int contador, char celdas[][]) {
		if (ejeY < 3) {
			// solo `positivos
			if (celdas[ejeX][ejeY + 1] == 'M' && celdas[ejeX][ejeY + 2] == 'A' && celdas[ejeX][ejeY + 3] == 'S') {
				contador++;
			}
		} else if (ejeY >= celdas.length - 3) {
			// solo negativos
			if (celdas[ejeX][ejeY - 1] == 'M' && celdas[ejeX][ejeY - 2] == 'A' && celdas[ejeX][ejeY - 3] == 'S') {
				contador++;
			}
		} else {
			if (celdas[ejeX][ejeY + 1] == 'M' && celdas[ejeX][ejeY + 2] == 'A' && celdas[ejeX][ejeY + 3] == 'S') {
				contador++;
			}
			if (celdas[ejeX][ejeY - 1] == 'M' && celdas[ejeX][ejeY - 2] == 'A' && celdas[ejeX][ejeY - 3] == 'S') {
				contador++;
			}
		}

		return contador;
	}

	public static int calcularEjeVertical(int ejeX, int ejeY, int contador, char celdas[][]) {
		if (ejeX < 3) {
			// solpositivos
			if (celdas[ejeX + 1][ejeY] == 'M' && celdas[ejeX + 2][ejeY] == 'A' && celdas[ejeX + 3][ejeY] == 'S') {
				contador++;
			}

		} else if (ejeX >= celdas.length - 3) {
			// solo negativos
			if (celdas[ejeX - 1][ejeY] == 'M' && celdas[ejeX - 2][ejeY] == 'A' && celdas[ejeX - 3][ejeY] == 'S') {
				contador++;
			}
		} else {
			// ambos
			if (celdas[ejeX + 1][ejeY] == 'M' && celdas[ejeX + 2][ejeY] == 'A' && celdas[ejeX + 3][ejeY] == 'S') {
				contador++;
			}
			if (celdas[ejeX - 1][ejeY] == 'M' && celdas[ejeX - 2][ejeY] == 'A' && celdas[ejeX - 3][ejeY] == 'S') {
				contador++;
			}
		}
		return contador;
	}

	public static int calcularEjeDiagonal(int ejeX, int ejeY, int contador, char celdas[][]) {

		// System.out.println("X :"+ejeX +" / Y :"+ejeY);
		if (ejeX < 3 && ejeY < 3) {
			if (celdas[ejeX + 1][ejeY + 1] == 'M' && celdas[ejeX + 2][ejeY + 2] == 'A'
					&& celdas[ejeX + 3][ejeY + 3] == 'S') {
				contador++;
			}
		} else if (ejeX >= celdas.length - 3 && ejeY >= celdas.length - 3) {
			if (celdas[ejeX - 1][ejeY - 1] == 'M' && celdas[ejeX - 2][ejeY - 2] == 'A'
					&& celdas[ejeX - 3][ejeY - 3] == 'S') {
				contador++;
			}

		} else if (ejeX >= celdas.length - 3 && ejeY < 3) {
			// esquina inf izq
			if (celdas[ejeX - 1][ejeY + 1] == 'M' && celdas[ejeX - 2][ejeY + 2] == 'A'
					&& celdas[ejeX - 3][ejeY + 3] == 'S') {
				contador++;
			}
		} else if (ejeX < 3 && ejeY >= celdas.length - 3) {
			// esquina sup der
			if (celdas[ejeX + 1][ejeY - 1] == 'M' && celdas[ejeX + 2][ejeY - 2] == 'A'
					&& celdas[ejeX + 3][ejeY - 3] == 'S') {
				contador++;
			}
		} else {

			if (ejeX >= 3) {
				if (ejeY < celdas.length - 3) {// && ejeX <celdas.length-3

					if (celdas[ejeX - 1][ejeY + 1] == 'M' && celdas[ejeX - 2][ejeY + 2] == 'A'
							&& celdas[ejeX - 3][ejeY + 3] == 'S') {
						contador++;
					}
				}
				if (ejeY >= 3) {
					if (celdas[ejeX - 1][ejeY - 1] == 'M' && celdas[ejeX - 2][ejeY - 2] == 'A'
							&& celdas[ejeX - 3][ejeY - 3] == 'S') {
						contador++;

					}
				}

			}
			if (ejeX < celdas.length - 3) {
				if (ejeY < celdas.length - 3) {
					// System.out.println(celdas[ejeX+1][ejeY+1]+ ""+celdas[ejeX+2][ejeY+2]+"" +
					// celdas[ejeX+3][ejeY+3]);
					if (celdas[ejeX + 1][ejeY + 1] == 'M' && celdas[ejeX + 2][ejeY + 2] == 'A'
							&& celdas[ejeX + 3][ejeY + 3] == 'S') {
						contador++;
					}
				}

				if (ejeX < celdas.length - 3 && ejeY >= 3) {
					// System.out.println(celdas[ejeX+1][ejeY-1] +""+celdas[ejeX+2][ejeY-2]
					// +""+celdas[ejeX+3][ejeY-3] );
					if (celdas[ejeX + 1][ejeY - 1] == 'M' && celdas[ejeX + 2][ejeY - 2] == 'A'
							&& celdas[ejeX + 3][ejeY - 3] == 'S') {
						contador++;
					}
				}

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

				if (celdas[x][y] == 'X') {
					contador = calcularEjeHorizontal(x, y, contador, celdas);
					contador = calcularEjeVertical(x, y, contador, celdas);
					contador = calcularEjeDiagonal(x, y, contador, celdas);
				}

			}
		}
		System.out.println("CONTADOR " + contador);

	}

}

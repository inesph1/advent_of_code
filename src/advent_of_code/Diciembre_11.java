package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Diciembre_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Long> arreglo = new ArrayList<>();

		int contador = 0;

		arreglo.add((long) 475449);
		arreglo.add((long) 2599064);
		arreglo.add((long) 213);
		arreglo.add((long) 0);
		arreglo.add((long) 2);
		arreglo.add((long) 65);
		arreglo.add((long) 5755);
		arreglo.add((long) 51149);

		// 475449 2599064 213 0 2 65 5755 51149

		do {
			for (int i = arreglo.size() - 1; i >= 0; i--) {
				long numero = arreglo.get(i);
				long dividendo = numero;
				long divisor = 1;
				long cociente = 0;
				long resto = 0;

				int contador_digitos = 0;

				if (numero == 0) {
					arreglo.add(i, (long) 1);
					arreglo.remove(i + 1);
				} else {

					while (dividendo / divisor != 0) {
						divisor = divisor * 10;
						contador_digitos++;
					}

					if (contador_digitos % 2 == 0) {

						cociente = dividendo / (long) Math.pow(10, contador_digitos / 2); // n1
						resto = dividendo % (long) Math.pow(10, contador_digitos / 2);

						arreglo.add(i, resto);
						arreglo.add(i, cociente);
						arreglo.remove(i + 2);

					} else {

						arreglo.add(i, numero * 2024);
						arreglo.remove(i + 1);

					}

				}

			}

			contador++;
		} while (contador <= 24);

		System.out.println("TAMANO " + arreglo.size());

	}

}

package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Diciembre_1_pt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arr1 = new ArrayList();
		ArrayList<Integer> arr2 = new ArrayList();

		try (BufferedReader br = new BufferedReader(new FileReader("./input.txt"))) {
			String l;

			while ((l = br.readLine()) != null) {
				String columnas[] = l.split("\\s+");
				arr1.add(Integer.parseInt(columnas[0]));
				arr2.add(Integer.parseInt(columnas[1]));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int actual;
		int siguiente;

		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr1.size(); j++) {
				actual = arr1.get(j);
				if (j != arr1.size() - 1) {
					siguiente = arr1.get(j + 1);
					if (actual > siguiente) {
						arr1.set(j, siguiente);
						siguiente = actual;
						arr1.set(j + 1, siguiente);
					}
				}

			}
		}

		for (int k = 0; k < arr2.size(); k++) {
			for (int l = 0; l < arr2.size(); l++) {
				actual = arr2.get(l);
				if (l != arr2.size() - 1) {
					siguiente = arr2.get(l + 1);
					if (actual > siguiente) {
						arr2.set(l, siguiente);
						siguiente = actual;
						arr2.set(l + 1, siguiente);
					}
				}

			}
		}

		int sumatorio = 0;
		int contador = 0;

		for (Integer integer : arr1) {
			contador = 0;
			if (arr2.contains(integer)) {

				System.out.println("LO CONTIENE");

				for (Integer inte : arr2) {

					if (inte.equals(integer)) {
						contador = contador + 1;
						System.out.println("ES IGUAL");
					}

				}
				System.out.println("El numero " + integer + " aparece " + contador + " veces");

				sumatorio = sumatorio + (contador * integer);
			}

		}

		System.out.println("SOLUCION " + sumatorio);
		System.out.println("SOLUCION " + contador);

	}

}

package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Diciembre_1 {

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

		for (int m = 0; m < arr1.size(); m++) {
			// System.out.println(arr1.get(m) +" MENOS "+arr2.get(m));
			// System.out.println("SOLUCION "+ (arr1.get(m)-arr2.get(m)));
			int resta = arr1.get(m) - arr2.get(m);
			if (resta < 0) {
				resta = resta * (-1);
			}
			sumatorio = sumatorio + resta;
		}

		// System.out.println(arr1.size());
		// System.out.println(arr2.size());
		System.out.println("SOLUCION " + sumatorio);

	}

}

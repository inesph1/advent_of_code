package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Diciembre_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ObjetoNoDescriptivo> listadoDeObjetosNoDescriptivos = new ArrayList();
		int actual;
		int siguiente;
		boolean flag_desorden_mayor = false;
		boolean flag_desorden_menor = false;
		int contador = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("./input_2.txt"))) {
			String l;

			while ((l = br.readLine()) != null) {
				String columnas[] = l.split("\\s+");
				ArrayList<Integer> listadoNumeros = new ArrayList<Integer>();

				for (int i = 0; i < columnas.length; i++) {
					listadoNumeros.add(Integer.parseInt(columnas[i]));
				}
				Diciembre_2 D2 = new Diciembre_2();
				ObjetoNoDescriptivo objND = new ObjetoNoDescriptivo(listadoNumeros, false);
				listadoDeObjetosNoDescriptivos.add(objND);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ObjetoNoDescriptivo objetoNoDescriptivo : listadoDeObjetosNoDescriptivos) {
			flag_desorden_mayor = false;
			flag_desorden_menor = false;

			ArrayList<Integer> arrayAux = objetoNoDescriptivo.getListadoNumeros();
			System.out.println(objetoNoDescriptivo.getListadoNumeros().size());

			for (int j = 0; j < arrayAux.size(); j++) {
				actual = arrayAux.get(j);
				if (j != arrayAux.size() - 1) {
					siguiente = arrayAux.get(j + 1);
					if (actual > siguiente || actual == siguiente) {
						flag_desorden_mayor = true;
						if ((actual - siguiente) > 3 || (actual - siguiente) < 1 || actual == siguiente) {
							objetoNoDescriptivo.setContaminado(true);
							break;
						}
					}
					if (actual < siguiente) {
						if ((siguiente - actual) > 3 || (siguiente - actual) < 1) {
							objetoNoDescriptivo.setContaminado(true);
							break;
						}

						flag_desorden_menor = true;
					}
				}
				if (flag_desorden_menor && flag_desorden_mayor) {
					System.out.println("AMBAS FLAGS ACTIVAS");
					objetoNoDescriptivo.setContaminado(true);
					break;
				}
			}

		}

		for (ObjetoNoDescriptivo objAux : listadoDeObjetosNoDescriptivos) {
			if (!objAux.isContaminado()) {
				contador = contador + 1;
			}
		}

		System.out.println("CONTADOR " + contador);

	}

}

class ObjetoNoDescriptivo {
	private ArrayList<Integer> listadoNumeros;
	private boolean contaminado = false;

	public ObjetoNoDescriptivo() {
		this.listadoNumeros = new ArrayList<Integer>();
		this.contaminado = false;
	}

	public ObjetoNoDescriptivo(ArrayList<Integer> listadoNumeros, boolean contaminado) {
		this.listadoNumeros = listadoNumeros;
		this.contaminado = contaminado;
	}

	public ArrayList<Integer> getListadoNumeros() {
		return listadoNumeros;
	}

	public void setListadoNumeros(ArrayList<Integer> listadoNumeros) {
		this.listadoNumeros = listadoNumeros;
	}

	public boolean isContaminado() {
		return contaminado;
	}

	public void setContaminado(boolean contaminado) {
		this.contaminado = contaminado;
	}

	@Override
	public String toString() {
		return "ObjetoNoDescriptivo [listadoNumeros=" + listadoNumeros + ", contaminado=" + contaminado + "]";
	}

}

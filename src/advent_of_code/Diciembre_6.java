package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Diciembre_6 {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char celdas[][];

		boolean fin_exploracion= false;
		int contador = 0;

		int ejeX = 0;
		int ejeY = 0;

		List<String> filas = new ArrayList();

		try (BufferedReader br = new BufferedReader(new FileReader("./input_6.txt"))) {
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

		while(!fin_exploracion){

		     contador = 0;

		     for (int i = 0; i < celdas.length; i++){
		         for(int j = 0; j< celdas.length; j++){
		             char actual = celdas[i][j];
		             char siguiente = ' ';

		             try{
		                 switch(actual) {
		                     case '^':
		                         siguiente = celdas[i-1][j];
		                         if (siguiente == '#'){
		                             celdas[i][j] = '>';
		                         }else{
		                             celdas[i-1][j] = '^';
		                             celdas[i][j] = 'X';
		                         }
		                         System.out.print( "Llega" );
		                         break;
		                     case '>':
		                         siguiente = celdas[i][j+1];
		                         if (siguiente == '#'){
		                             celdas[i][j] = 'v';
		                         }else{
		                             celdas[i][j+1] = '>';
		                             celdas[i][j] = 'X';
		                         }
		                         break;
		                     case 'v':
		                         siguiente = celdas[i+1][j];
		                         if (siguiente == '#'){
		                             celdas[i][j] = '<';
		                         }else{
		                             celdas[i+1][j] = 'v';
		                             celdas[i][j] = 'X';
		                         }
		                         break;
		                     case '<':
		                         siguiente = celdas[i][j-1];
		                         if (siguiente == '#'){
		                             celdas[i][j] = '^';
		                         }else{
		                             celdas[i][j-1] = '<';
		                             celdas[i][j] = 'X';
		                         }
		                         break;

		                 }

		             }catch(Exception e){
		                 celdas[i][j] = 'X';
		                 fin_exploracion = true;
		             };

		         }
		     }
		}





		 System.out.println("Mostrar");

		 for (int i = 0; i < celdas.length; i++){
		     for(int j = 0; j< celdas.length; j++){
		         if(celdas[i][j] == 'X'){
		             contador++;
		         }

		     }

		 }

		 System.out.print( "CONTADOR "+contador );

	}

}

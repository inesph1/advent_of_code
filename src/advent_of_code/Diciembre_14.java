package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Diciembre_14 {

	public static void main(String[] args) {

		List<Robot> robots = new ArrayList<Robot>();

		// PRUEBAS EJEMPLO
		/*
		 * int limiteX = 7; int limiteY = 11;int limite_vertical = 7;int
		 * limite_horizontal = 11;
		 */

		// robots.add(new Robot(2, 4, 2, -3));

		/*
		 * robots.add(new Robot(0, 4, 3, -3)); robots.add(new Robot(6, 3, -1, -3));
		 * robots.add(new Robot(10, 3, -1, 2)); robots.add(new Robot(2, 0, 2, -1));
		 * robots.add(new Robot(0, 0, 1, 3)); robots.add(new Robot(3, 0, -2, -2));
		 * robots.add(new Robot(7, 6, -1, -3)); robots.add(new Robot(3, 0, -1, -2));
		 * robots.add(new Robot(9, 3, 2, 3)); robots.add(new Robot(7, 3, -1, 2));
		 * robots.add(new Robot(2, 4, 2, -3)); robots.add(new Robot(9, 5, -3, -3));
		 */

		int limite_vertical = 103;
		int limite_horizontal = 101;

		// calculo del centro
		int cocV = limite_vertical / 2;
		int cocH = limite_horizontal / 2;

		// calculo cuadrantes
		// de izq a derecha de arriba abajo
		int sumatorioA = 0; // 1 cuadrante
		int sumatorioB = 0; // 2 cuadrante
		int sumatorioC = 0; // 3 cuadrante
		int sumatorioD = 0; // 4 cuadrante

		// LECTURA INPUT
		try (BufferedReader br = new BufferedReader(new FileReader("./input_14.txt"))) {
			String l;
			while ((l = br.readLine()) != null) {
				String columnas[] = l.split("\\s+");

				String[] p = columnas[0].split("=");
				String[] v = columnas[1].split("=");

				String[] posiciones = p[1].split(",");
				String[] velocidades = v[1].split(",");

				robots.add(new Robot(Integer.parseInt(posiciones[0]), Integer.parseInt(posiciones[1]),
						Integer.parseInt(velocidades[0]), Integer.parseInt(velocidades[1])));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// inicializacion array bidimensional
		Posicion posiciones[][];
		posiciones = new Posicion[limite_vertical][limite_horizontal];
		int contador = 0;
		for (int i_vertical = 0; i_vertical < limite_vertical; i_vertical++) {
			for (int i_horizontal = 0; i_horizontal < limite_horizontal; i_horizontal++) {
				posiciones[i_vertical][i_horizontal] = new Posicion(false, new ArrayList<Robot>());
			}
		}

		// ubicar robots en tablero y ocupar celda

		for (Robot robot : robots) {
			int x = robot.getPosicionX();
			int y = robot.getPosicionY();

			posiciones[y][x].setOcupada(true);
			posiciones[y][x].getRobots_posicionados().add(robot);

			// System.out.println(robot.toString());
		}

		// avanzar 100 veces
		do {

			for (Robot robot : robots) {

				int x = robot.getPosicionX();
				int y = robot.getPosicionY();

				posiciones[y][x].getRobots_posicionados().remove(robot);
				if (posiciones[y][x].getRobots_posicionados().isEmpty()) {
					posiciones[y][x].setOcupada(false);
				}

				robot.avanzar(limite_horizontal, limite_vertical);

				x = robot.getPosicionX();
				y = robot.getPosicionY();

				posiciones[y][x].setOcupada(true);
				posiciones[y][x].getRobots_posicionados().add(robot);

			}

			contador++;

		} while (contador < 100);

		// System.out.println("\n#####################");

		for (int x = 0; x < limite_vertical; x++) {
			// System.out.println("\n");
			for (int y = 0; y < limite_horizontal; y++) {
				int cantidad_robots_por_celda = 0;
				if (((y < cocH) || (y >= (limite_horizontal - cocH)))
						&& ((x < cocV) || (x >= (limite_vertical - cocV)))) {
					if (posiciones[x][y].isOcupada()) {
						if (posiciones[x][y].getRobots_posicionados().size() > 1) {
							cantidad_robots_por_celda = posiciones[x][y].getRobots_posicionados().size();
							// System.out.println(posiciones[x][y].getRobots_posicionados().size());
						} else {
							cantidad_robots_por_celda = 1;
							// System.out.println("1");
						}

						if (y < 1 + cocH && x < cocV) {
							// System.out.println("\nSUMATORIO-A X: " + x+ " Y : "+y);
							sumatorioA = sumatorioA + cantidad_robots_por_celda;
						} else if (y >= cocH && x < cocV) {
							// System.out.println("\nSUMATORIO-B X: " + x+ " Y : "+y);
							sumatorioB = sumatorioB + cantidad_robots_por_celda;
						} else if (y < cocH && x >= cocV) {
							// System.out.println("\nSUMATORIO-C X: " + x+ " Y : "+y);
							sumatorioC = sumatorioC + cantidad_robots_por_celda;
						} else if (y > cocH && x >= cocV) {
							// System.out.println("\nSUMATORIO-D X: " + x+ " Y : "+y);
							sumatorioD = sumatorioD + cantidad_robots_por_celda;

						}
					} /*
						 * else { System.out.print("."); }
						 */
				}

			}
		}

		if (sumatorioA == 0) {
			sumatorioA = 1;
		}
		if (sumatorioB == 0) {
			sumatorioB = 1;
		}
		if (sumatorioC == 0) {
			sumatorioC = 1;
		}
		if (sumatorioD == 0) {
			sumatorioD = 1;
		}

		System.out.println("\n****SUMATORIO " + sumatorioA * sumatorioB * sumatorioC * sumatorioD);

	}

}

class Robot {
	private int posicionX;
	private int posicionY;
	private int velocidadX;
	private int velocidadY;

	public Robot() {
		this.posicionX = 0;
		this.posicionY = 0;
		this.velocidadX = 0;
		this.velocidadY = 0;
	}

	public Robot(int posicionX, int posicionY, int velocidadX, int velocidadY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.velocidadX = velocidadX;
		this.velocidadY = velocidadY;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;

	}

	public int getPosicionY() {

		return posicionY;

	}

	public void setPosicionY(int posicionY) {

		this.posicionY = posicionY;

	}

	public int getVelocidadX() {

		return velocidadX;

	}

	public void setVelocidadX(int velocidadX) {

		this.velocidadX = velocidadX;

	}

	public int getVelocidadY() {

		return velocidadY;

	}

	public void setVelocidadY(int velocidadY) {

		this.velocidadY = velocidadY;

	}

	public void avanzar(int topeX, int topeY) {
		topeX = topeX - 1;
		topeY = topeY - 1;
		if (((this.posicionX + this.velocidadX) <= 0) || (this.posicionX + this.velocidadX) > topeX) {
			if ((this.posicionX + this.velocidadX) <= 0) {
				this.posicionX = this.velocidadX + ((topeX + 1) + this.posicionX);
			} else {
				this.posicionX = this.velocidadX - ((topeX + 1) - this.posicionX);
			}
		} else {
			this.posicionX = this.posicionX + (this.velocidadX);
		}

		if (((this.posicionY + this.velocidadY) <= 0) || (this.posicionY + this.velocidadY) > topeY) {
			if ((this.posicionY + this.velocidadY) < 0) {
				this.posicionY = this.velocidadY + ((topeY + 1) + this.posicionY);
			} else {
				this.posicionY = this.velocidadY - ((topeY + 1) - this.posicionY);
			}

		} else {
			this.posicionY = this.posicionY + (this.velocidadY);
		}
		if (this.posicionY < 0) {
			this.posicionY = this.posicionY * -1;
		}

		if (this.posicionX < 0) {
			this.posicionX = this.posicionX * -1;
		}

		if (this.posicionY == topeY + 1) {
			this.posicionY = 0;
		}

		if (this.posicionX == topeX + 1) {
			this.posicionX = 0;
		}

	}

	@Override
	public String toString() {
		return "Robot [posicionX=" + posicionX + ", posicionY=" + posicionY + ", velocidadX=" + velocidadX
				+ ", velocidadY=" + velocidadY + "]";
	}

}

class Posicion {
	private boolean ocupada;
	private List<Robot> robots_posicionados;

	public Posicion(boolean ocupada) {
		this.ocupada = ocupada;
		this.robots_posicionados = new ArrayList<Robot>();
	}

	public Posicion(boolean ocupada, List<Robot> robots) {
		this.ocupada = ocupada;
		this.robots_posicionados = robots;
	}

	public boolean isOcupada() {
		return this.ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public List<Robot> getRobots_posicionados() {
		return robots_posicionados;
	}

	public void setRobots_posicionados(List<Robot> robots_posicionados) {
		this.robots_posicionados = robots_posicionados;
	}

	public void avanzar(Robot robot, int limiteX, int limiteY) {
		if (robots_posicionados.contains(robot)) {
			int indice = robots_posicionados.indexOf(robot);
			robots_posicionados.get(indice).avanzar(limiteX, limiteY);
			robots_posicionados.remove(robot);

			if (robots_posicionados.size() <= 0) {
				this.ocupada = false;
			}
		}
	}

}

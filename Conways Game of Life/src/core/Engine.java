package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Engine {
	
	boolean cells[][];
	int aliveCount[][];

	int rows = 1080/1;
	int cols = 1920/1;
	int cellSize = 1;

	void init() {
		cells = new boolean[rows][cols];
		aliveCount = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (Math.random() > .96) {
					cells[i][j] = true;
				} else {
					cells[i][j] = false;
				}
			}
		}

	}

	void update() {

	}

	void render(Graphics g) {

		// if(input.mouseX)

		int numAlive = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				numAlive = 0;
				// 3 above
				// top left
				if (i - 1 >= 0 && j - 1 >= 0 && cells[i - 1][j - 1] == true) {
					numAlive++;
				}
				// middle above
				if (i - 1 >= 0 && cells[i - 1][j] == true) {
					numAlive++;
				}
				// top right
				if (i - 1 >= 0 && j + 1 < cols && cells[i - 1][j + 1] == true) {
					numAlive++;
				}
				// 2 in middle
				// left
				if (j - 1 >= 0 && cells[i][j - 1] == true) {
					numAlive++;
				}
				// right
				if (j + 1 < cols && cells[i][j + 1] == true) {
					numAlive++;
				}
				// 3 below
				// bottom left
				if (i + 1 < rows && j - 1 >= 0 && cells[i + 1][j - 1] == true) {
					numAlive++;
				}
				// bottom middle
				if (i + 1 < rows && cells[i + 1][j] == true) {
					numAlive++;
				}
				// bottom right
				if (i + 1 < rows && j + 1 < cols && cells[i + 1][j + 1]) {
					numAlive++;
				}

				aliveCount[i][j] = numAlive;

			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				if(cells[i][j] == false) {
					if(aliveCount[i][j] == 3) {
						cells[i][j] = true;
					}
				}
				else {
					if(!(aliveCount[i][j] == 3 || aliveCount[i][j] == 2 )) {
						cells[i][j] = false;
					}
				}
				
				
				
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (cells[i][j] == true) {
					// g.setColor(new
					// Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random())));
					g.setColor(Color.green);
					g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
				}
			}
		}
	}
}

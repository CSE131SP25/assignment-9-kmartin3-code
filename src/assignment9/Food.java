package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		// Make sure the food doesn't spawn too close to the edges
		x = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
		y = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * Respawns the food at a new random location
	 */
	public void respawn() {
		x = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
		y = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
	}
	
}

package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
    private int score; // Variable to keep track of the score

	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		snake = new Snake();
		food = new Food();
        score = 0; // Initialize the score to 0

	}
	
	public void play() {
		  // Display the intro screen
        showIntroScreen();
		 while (snake.isInbounds()) {
		        int dir = getKeypress();

		        // 1. Update direction if a key is pressed
		        if (dir != -1) {
		            snake.changeDirection(dir);
		        }

		        // 2. Move the snake
		        snake.move();

		        // 3. Eat food if the snake reaches it
		        if (snake.eatFood(food)) {
		            food = new Food(); // Spawn new food
	                score++; // Increment the score when the snake eats food
		        }

		        // 4. Redraw everything
		        updateDrawing();
		    }

		 // Display the game over screen after the game ends
	     showGameOverScreen();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();

		snake.draw();
		food.draw();

		  // Display the score in the top-left corner
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.1, 0.95, "Score: " + score);
        
		StdDraw.pause(50); // Pause for smooth animation
		StdDraw.show();
	}
	 private void showIntroScreen() {
	        StdDraw.clear();
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.5, 0.7, "Welcome to Snake Game!");
	        StdDraw.text(0.5, 0.5, "Use WASD keys to move.");
	        StdDraw.text(0.5, 0.3, "Press one of those to start.");

	        StdDraw.show();
	        
	        // Wait for a key press to start the game
	        while (!StdDraw.hasNextKeyTyped()) {
	            // waiting for a key press
	        }
	        StdDraw.nextKeyTyped(); //start the game when key is types
	    }
	  /**
	     * Displays the game over screen with the final score
	     */
	    private void showGameOverScreen() {
	        StdDraw.clear();
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.5, 0.7, "Game Over!");
	        StdDraw.text(0.5, 0.5, "Your Score: " + score);

	        StdDraw.show();

	        // Wait for a key press to exit the game
	        while (!StdDraw.hasNextKeyTyped()) {
	            // Keep waiting for a key press
	        }
	        StdDraw.nextKeyTyped(); // consume the key press to quit the game
	    }
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}

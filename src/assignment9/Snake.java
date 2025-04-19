package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		// Step 1: Initialize the LinkedList
		segments = new LinkedList<BodySegment>();
		// Add one BodySegment to the snake at a starting position (e.g., center of canvas)
		double startX = 0.5;
		double startY = 0.5;
		BodySegment head = new BodySegment(startX, startY, SEGMENT_SIZE);
		segments.add(head);
				
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		 // Step 3: Get the head and calculate the new position
	    BodySegment head = segments.getFirst();
	    double newX = head.getX() + deltaX;
	    double newY = head.getY() + deltaY;

	    // Move segments from back to front
	    for (int i = segments.size() - 1; i > 0; i--) {
	        BodySegment prev = segments.get(i - 1);
	        segments.get(i).setPosition(prev.getX(), prev.getY());
	    }

	    // Move head last
	    head.setPosition(newX, newY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		// Step 2: Draw all body segments
		for (BodySegment segment : segments) {
		segment.draw();
		}
	}
	//This method adds a new segment at the end of the snake, behind the tail
	public void grow() {
	    BodySegment tail = segments.getLast();

	    // Add new segment at tail's position with a fixed color (e.g., Color.GREEN)
	    BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), tail.getSize());
	    segments.addLast(newSegment);
	}
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food food) {
		  BodySegment head = segments.getFirst();
		    double dx = head.getX() - food.getX();
		    double dy = head.getY() - food.getY();
		    double distance = Math.sqrt(dx * dx + dy * dy);

		    if (distance < 0.04) { // Collision threshold (adjust as needed)
		        grow(); // Add new segment
		        return true;
		    }
		    return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		 BodySegment head = segments.getFirst();
		    double x = head.getX();
		    double y = head.getY();

		    return (x >= 0 && x <= 1 && y >= 0 && y <= 1);
	}
}

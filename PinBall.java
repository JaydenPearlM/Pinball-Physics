package algorithyms.classicpinball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PinBall extends Circle {

    private static final double RADIUS = 10; // Default radius of the ball
    private static final Color DEFAULT_COLOR = Color.SILVER; // Default color of the ball
    private static final double GRAVITY = 0.5;
    private double velocityY = 0;
    private double velocityX = 0;
//    private long lastUpdateTime;

    PinBall(double centerX, double centerY) {
        super(centerX, centerY, RADIUS); // Set the initial position and radius of the ball

        this.setFill(DEFAULT_COLOR);
    }

    // Ball Physics
    public void startBall() {
        System.out.println("Ball moving!");
        velocityY = -20; // Set initial upward velocity to start the ball
        updatePosition();
    }
                  
      

    public void updatePosition() {
        // Apply gravity
        velocityY += GRAVITY;

        // Update ball's position based on velocity
        setCenterX(getCenterX() + velocityX);
        setCenterY(getCenterY() + velocityY);

        // Handle collision with walls
        // If the ball hits the left or right wall, reverse its horizontal velocity
        if (getCenterX() - RADIUS <= 0 || getCenterX() + RADIUS >= 800) {
            velocityX = -velocityX * 0.8; // Reverse horizontal 
        }

        // If the ball hits the top or bottom wall, reverse its vertical velocity
        if (getCenterY() - RADIUS <= 0 || getCenterY() + RADIUS >= 600) {
            velocityY = -velocityY * 0.8; // Reverse vertical velocity
        }
    }
}
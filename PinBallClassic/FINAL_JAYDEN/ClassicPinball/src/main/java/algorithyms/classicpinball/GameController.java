package algorithyms.classicpinball;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import static javafx.scene.transform.Transform.rotate;

public class GameController extends ClassicPinball {

    private String playerName;
    private boolean isRunning;
    private boolean isPause;
    private int highScore;
    private int ballCount;
    private String gameLoop;
    private String updateGame;
    private Rectangle rightFlipper;
    private double flipperPositionY;
    private static final double FLIPPER_MOVEMENT_SPEED = 5.0;
    

    public GameController() {

        this.playerName = null;
        this.isRunning = false;
        this.isPause = false;
        this.highScore = 0;
        this.ballCount = 3;

    }

    public void playerCharacter(String playerName) {
        this.isRunning = true;
        this.playerName = playerName;
        this.highScore = 0;
        this.ballCount = 3;

    }
//    public void start

    public void startGame(PinBall ball) {
        if (!isRunning) {
            isRunning = true;
            ball.startBall();
        }
    }

 // Method to move right flipper up
    public void moveRightFlipperUp() {
        flipperPositionY -= FLIPPER_MOVEMENT_SPEED;
        rightFlipper.setLayoutY(flipperPositionY);
        
    }
    
//       public void rotateFlipper() {
//        double ROTATION_SPEED = 2.0;
//        double newAngle = rotation.getAngle() + ROTATION_SPEED;
//        double MAX_ROTATION_ANGLE = 0;
//        if (newAngle <= MAX_ROTATION_ANGLE) {
//            rotation.setAngle(newAngle);
//        }
//    }

    // Method to move right flipper down
    public void moveRightFlipperDown() {
        flipperPositionY += FLIPPER_MOVEMENT_SPEED;
        rightFlipper.setLayoutY(flipperPositionY);
    }
    public void pauseGame() {
        this.isPause = true;
    }

    public void resumeGame() {
        this.isPause = false;
    }

    public void endGame() {
        this.isRunning = false;
    }

    public void updateScore(int points) {
        this.highScore += points;
    }

    public void ballLost() {
        this.ballCount--;
        if (this.ballCount == 0) {
            endGame();
        } else {
            resetBall();
        }
    }

    private void resetBall() {

    }
}

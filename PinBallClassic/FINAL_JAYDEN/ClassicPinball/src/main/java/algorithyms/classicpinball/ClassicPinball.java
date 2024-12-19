package algorithyms.classicpinball;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

public class ClassicPinball extends Application {

    private boolean spacePressed = false;
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private PinBall ballA;
    public int moveRightFlipperUp = 0;
    public int moveRightFlipperDown = 0;
    

    @Override
    public void start(Stage primaryStage) {
        // Game board
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Classic Pinball by Jayden Maxwell");

        // Add border
        Rectangle border = new Rectangle(5, 5, 340, 590);
        border.setStroke(Color.INDIGO);
        border.setStrokeWidth(20);
        border.setFill(Color.LAVENDER);
        root.getChildren().add(border);

        // Add pinball
        ballA = new PinBall(330, 560);
        root.getChildren().add(ballA);

        // Space bar to make ball move
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                spacePressed = true;
                ballA.startBall();
                scene.setOnKeyPressed(null);
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                spacePressed = true;
            }
        });
        
        
        
//        scene.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.RIGHT) {
//                rightPressed = true;
//            }
//                
//        });

        // Game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (spacePressed) {
                    ballA.updatePosition();
                }
            }
        };
        timer.start();
        
        int RIGHTFLIPPER_WIDTH = 100;
        int RIGHTFLIPPER_HEIGHT = 20;

        Rectangle rightFlipper = new Rectangle(100, 20);
        rightFlipper.setLayoutX(RIGHTFLIPPER_WIDTH - RIGHTFLIPPER_WIDTH);
        rightFlipper.setLayoutY(RIGHTFLIPPER_HEIGHT - RIGHTFLIPPER_HEIGHT);
        rightFlipper.setLayoutX(185);
        rightFlipper.setLayoutY(500);
        rightFlipper.setStroke(Color.BLACK);
        rightFlipper.setStrokeWidth(5);
        rightFlipper.setFill(Color.WHITE);
        Scale scaleRightFlipper = new Scale();
        scaleRightFlipper.setX(0.45); // Set scale factor for x-axis (horizontal scaling)
        scaleRightFlipper.setY(0.45); // Set scale factor for y-axis (vertical scaling)
        rightFlipper.getTransforms().add(scaleRightFlipper);
        root.getChildren().add(rightFlipper);
        Rotate rotation = new Rotate(0);
        //double RIGHTFLIPPER_WIDTH;
        rotation.setPivotX(RIGHTFLIPPER_WIDTH); // Set pivot point X coordinate to the right end of the flipper
        //double RIGHTFLIPPER_HEIGHT;
        rotation.setPivotY(RIGHTFLIPPER_HEIGHT); // Set pivot point Y coordinate to the lower end of the flipper
        rightFlipper.getTransforms().add(rotation);
        
        
//     RightFlipper.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.RIGHT) {
//                boolean rotatingRight = true;
//            }
//        });
//
//        scene.setOnKeyReleased(event -> {
//            if (event.getCode() == KeyCode.RIGHT) {
//                boolean rotatingRight = false;
//                ballA.updatePosition();
//            }
//        });
//    scene.setOnKeyPressed(event -> {
//if (event.getCode() == KeyCode.LEFT){
//    boolean rotatingLeft = false;
//    ballA.updatePosition();
//}
    

   
     
//        
      
        

        
      
        int LEFTFLIPPER_WIDTH = 100;
        int LEFTFLIPPER_HEIGHT = 20;

        Rectangle leftFlipper = new Rectangle(100, 20);
        leftFlipper.setLayoutX(LEFTFLIPPER_WIDTH - LEFTFLIPPER_WIDTH);
        leftFlipper.setLayoutY(LEFTFLIPPER_HEIGHT - LEFTFLIPPER_HEIGHT);
        leftFlipper.setLayoutX(105);
        leftFlipper.setLayoutY(500);
        leftFlipper.setStroke(Color.BLACK);
        leftFlipper.setStrokeWidth(5);
        leftFlipper.setFill(Color.WHITE);
        Scale scaleLeftFlipper = new Scale();
        scaleLeftFlipper.setX(0.45); // Set scale factor for x-axis (horizontal scaling)
        scaleLeftFlipper.setY(0.45); // Set scale factor for y-axis (vertical scaling)
        leftFlipper.getTransforms().add(scaleLeftFlipper);
        root.getChildren().add(leftFlipper);

////////////////////////////////////////triangles///////////////////////////////////////////////////////////////////////////
        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(
                60.0, 560.0, // Bottom-left corner
                150.0, 600.0, // Bottom-right corner
                75.0, 450.0 // Top corner  
        );//middle left triangle
        triangle1.setLayoutX(50);
        triangle1.setLayoutY(200);
        Scale scaleTriangle1 = new Scale();
        scaleTriangle1.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle1.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle1.getTransforms().add(scaleTriangle1);
        triangle1.setStrokeWidth(5);
        triangle1.setStroke(Color.BLACK);
        triangle1.setFill(Color.BURLYWOOD);
        root.getChildren().add(triangle1);

        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(
                150.0, 600.0, // Bottom-left corner
                60.0, 560.0, // Bottom-right corner
                75.0, 450.0 // Top corner  
        ); //Middle right triangle
        triangle2.setLayoutX(245);
        triangle2.setLayoutY(200);
        // Apply rotation to the triangle and scale
        //scaleing
        Scale scaleTriangle2 = new Scale();
        scaleTriangle2.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle2.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle2.getTransforms().add(scaleTriangle2);
        triangle2.setStrokeWidth(5);
        triangle2.setStroke(Color.BLACK);
        triangle2.setFill(Color.BURLYWOOD);
        Scale flipHorizontal = new Scale(-1, 1);
        flipHorizontal.setPivotX(triangle2.getBoundsInLocal().getWidth() / 2); // Set pivot to the center of the triangle
        flipHorizontal.setPivotY(triangle2.getBoundsInLocal().getHeight() / 2); // Set pivot to the center of the triangle
        triangle2.getTransforms().add(flipHorizontal);
        root.getChildren().add(triangle2);

        Polygon triangle3 = new Polygon();
        triangle3.getPoints().addAll(
                0.0, 560.0, // Bottom-left corner
                0.0, 722.0, // Bottom-right corner
                300.0, 725.0 // Top-right corner (adjusted for right angle)
        ); //Bottom left triangle
        triangle3.setLayoutX(15);
        triangle3.setLayoutY(300);
        Scale scaleTriangle3 = new Scale();
        scaleTriangle3.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle3.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle3.getTransforms().add(scaleTriangle1);
        triangle3.setStrokeWidth(5);
        triangle3.setStroke(Color.BLACK);
        triangle3.setFill(Color.BURLYWOOD);
        root.getChildren().add(triangle3);
        
        Polygon triangle4 = new Polygon();
        triangle4.getPoints().addAll(
                0.0, 560.0, // Bottom-left corner
                0.0, 722.0, // Bottom-right corner
                300.0, 725.0 // Top-right corner (adjusted for right angle)
        );//Bottom right triangle
        triangle4.setLayoutX(194);
        triangle4.setLayoutY(300);
        Scale scaleTriangle4 = new Scale();
        scaleTriangle4.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle4.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle4.getTransforms().add(scaleTriangle4);
        triangle4.setStrokeWidth(5);
        triangle4.setStroke(Color.BLACK);
        triangle4.setFill(Color.BURLYWOOD);
        Scale flipHorizontal1 = new Scale(-1, 1);
        flipHorizontal1.setPivotX(triangle4.getBoundsInLocal().getWidth() / 2); // Set pivot to the center of the triangle
        flipHorizontal1.setPivotY(triangle4.getBoundsInLocal().getHeight() / 2); // Set pivot to the center of the triangle
        triangle4.getTransforms().add(flipHorizontal1);
        root.getChildren().add(triangle4);
        
        Polygon triangle5 = new Polygon();
        triangle5.getPoints().addAll(
                0.0, 560.0, // Bottom-left corner
                0.0, 722.0, // Bottom-right corner
                400.0, 725.0 // Top-right corner (adjusted for right angle) 
        );//Top left triangle
        triangle5.setLayoutX(15);
        triangle5.setLayoutY(235);
        Scale scaleTriangle5 = new Scale();
        scaleTriangle5.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle5.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle5.getTransforms().add(scaleTriangle5);
        triangle5.setStrokeWidth(5);
        triangle5.setStroke(Color.BLACK);
        triangle5.setFill(Color.BURLYWOOD);
        Scale flipVertical = new Scale(1, -1);
        flipVertical.setPivotX(triangle5.getBoundsInLocal().getWidth() / 2); // Set pivot to the center of the triangle
        flipVertical.setPivotY(triangle5.getBoundsInLocal().getHeight() / 2); // Set pivot to the center of the triangle
        triangle5.getTransforms().add(flipVertical);
        root.getChildren().add(triangle5);
        
        
        Polygon triangle6 = new Polygon();
        triangle6.getPoints().addAll(
                0.0, 560.0, // Bottom-left corner
                0.0, 722.0, // Bottom-right corner
                400.0, 725.0 // Top-right corner (adjusted for right angle) 
        );//Top right triangle
        triangle6.setLayoutX(175);
        triangle6.setLayoutY(235);
        Scale scaleTriangle6 = new Scale();
        scaleTriangle6.setX(0.4); // Set scale factor for x-axis (horizontal scaling)
        scaleTriangle6.setY(0.4); // Set scale factor for y-axis (vertical scaling)
        triangle6.getTransforms().add(scaleTriangle6);
        triangle6.setStrokeWidth(5);
        triangle6.setStroke(Color.BLACK);
        triangle6.setFill(Color.BURLYWOOD);
        Scale flipVertical6 = new Scale(1, -1);
        Scale flipHorizontal6 = new Scale(-1, 1);
        flipHorizontal6.setPivotX(triangle6.getBoundsInLocal().getWidth() / 2); // Set pivot to the center of the triangle
        flipHorizontal6.setPivotY(triangle6.getBoundsInLocal().getHeight() / 2); // Set pivot to the center of the triangle
        triangle6.getTransforms().add(flipHorizontal6);
        flipVertical6.setPivotX(triangle6.getBoundsInLocal().getWidth() / 2); // Set pivot to the center of the triangle
        flipVertical6.setPivotY(triangle6.getBoundsInLocal().getHeight() / 2); // Set pivot to the center of the triangle
        triangle6.getTransforms().add(flipVertical6);
        root.getChildren().add(triangle6);
        
        
        

        primaryStage.show();
        
        
        
        
         new AnimationTimer() {
            @Override
            public void handle(long now) {
                boolean rotatingRight = false;
                if (rotatingRight) {
                   rotateRightFlipper();
                }
            }
        }.start();
    }
    
 private void rotateRightFlipper() {
        double ROTATION_SPEED = 2.0;
        double newAngle = rotation.getAngle() + ROTATION_SPEED;
        double MAX_ROTATION_ANGLE = 45;
        if (newAngle <= MAX_ROTATION_ANGLE) {
            rotation.setAngle(newAngle);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

   
}

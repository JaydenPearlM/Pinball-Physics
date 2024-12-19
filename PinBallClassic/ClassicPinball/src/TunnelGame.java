package GUIs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ImageSearch extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage)  {
        BorderPane pane = new BorderPane();
        
        VBox topBox = new VBox(10);
        
        // Title
        Label title = new Label("Search for an image");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        
        // Search Field
        TextField searchTF = new TextField();
        
        // Search Button
        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);
        // Lambda for button
        searchButton.setOnAction((e) -> {
            System.out.println("Button pressed");
            // TODO: Call method to set the title text
            setTitle(searchTF, title);
        });
        
        
        // Place nodes onto the VBox
        topBox.getChildren().addAll(title, searchTF, searchButton);
        topBox.setAlignment(Pos.CENTER);
        
        // Add nodes to pane
        pane.setTop(topBox);
        
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Image Search");
        stage.setResizable(false);
        stage.show();
    }
    
    public static void setTitle(TextField searchTF, Label title) {
        title.setText(searchTF.getText());
    }
    
}

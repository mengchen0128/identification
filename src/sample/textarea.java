package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class textarea extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField textField = new TextField();
        Button button = new Button("查找");
        Button button2 = new Button("排序");
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(textField, button, button2);


        TextArea textArea=new TextArea();
        VBox vbox= new VBox(10);
        vbox.getChildren().addAll(textArea,hbox);
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");
        an.getChildren().addAll(vbox);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String find_value=textArea.getText();
                textArea.getParagraphs().forEach(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) {
                        String value=charSequence.toString();
                        String find_value=textField.getText();
                        if(value.contains(find_value))
                        {
                            System.out.println("有相同内容");
                        }
                    }
                });
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.getText().toCharArray();
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        Screen screen = Screen.getPrimary();
//        Rectangle2D rec = screen.getBounds();
//        Rectangle2D rec2 = screen.getVisualBounds();
    //    System.out.println("x=" + rec.getMinX());
        primaryStage.show();
//        Platform.exit();
    }
}

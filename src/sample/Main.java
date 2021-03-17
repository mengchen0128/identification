package sample;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

        Stage s1=new Stage();
        s1.setTitle("s1");
        s1.show();

        Stage s2=new Stage();
        s2.setTitle("s2");
        s2.initOwner(s1);
        s2.initModality(Modality.WINDOW_MODAL);
        s2.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


package sample;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class group extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1=new Button("b1");
        Button b2=new Button("b2");
        Button b3=new Button("b3");


        b1.setLayoutX(0);
        b1.setLayoutY(0);
//        b1.setPrefWidth(50);
//        b1.setPrefHeight(50);

//        BackgroundFill bgt=new BackgroundFill(Paint.valueOf("#FFF8DC"),new CornerRadii(1),new Insets(1,1,1,1));
//        Background bg=new Background(bgt);
//        b1.setBackground(bg);
//
//        BorderStroke borderStroke=new BorderStroke(Paint.valueOf("#000000"),BorderStrokeStyle.DOTTED,new CornerRadii(2),new BorderWidths(3));
//        Border bo=new Border(borderStroke);
//        b1.setBorder(bo);


//        b1.setStyle();


        b2.setLayoutX(100);
        b2.setLayoutY(100);
        b3.setLayoutX(200);
        b3.setLayoutY(200);
        Group group=new Group();
        group.getChildren().addAll(b1,b2,b3);


        Object[] obj=group.getChildren().toArray();
        System.out.println(obj.length);


        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println( c.getList().size());

            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bu4=new Button("button4");
                group.getChildren().add(bu4);

            }
        });

        for(Object o:obj)
        {
            Button bu=(Button)o;
            bu.setPrefHeight(100);
            bu.setPrefWidth(100);
        }


//        group.getChildren().remove(0);


        Scene scene=new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(700);
        primaryStage.setHeight(500);
        primaryStage.show();








    }

    public static void main(String[] args) {
        launch(args);
    }
}

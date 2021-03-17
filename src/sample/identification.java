package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

public class identification extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        TextArea ta = new TextArea(); //文本框
        ta.setPrefWidth(1200);
        ta.setPrefHeight(250);


        ToolBar toolBar=new ToolBar();
        Button button3 = new Button("Click Me");
        Button button4 = new Button("Click Me");
        Button button5 = new Button("Click Me");
        Button button6 = new Button("Click Me");
        Button button7 = new Button("Click Me");
        Button button8 = new Button("Click Me");

        toolBar.getItems().addAll(button3,button4,button5,button6,button7,button8);


        TreeView<String> treeview = new TreeView<String>();     /*设置树列表*/

        TreeItem<String> root = new TreeItem<String>("主单元");

        TreeItem<String> cell1 = new TreeItem<String>("二级单元");
        TreeItem<String> cell2 = new TreeItem<String>("三级单元");
        TreeItem<String> cell3 = new TreeItem<String>("三级单元");
        TreeItem<String> cell4 = new TreeItem<String>("三级单元");

        TreeItem<String> cell5 = new TreeItem<String>("二级单元");
        TreeItem<String> cell6 = new TreeItem<String>("三级单元");
        TreeItem<String> cell7 = new TreeItem<String>("三级单元");
        TreeItem<String> cell8 = new TreeItem<String>("单元");

        TreeItem<String> cell9 = new TreeItem<String>("二级单元");
        TreeItem<String> cell10 = new TreeItem<String>("单元");
        TreeItem<String> cell11 = new TreeItem<String>("单元");
        TreeItem<String> cell12 = new TreeItem<String>("单元");

        treeview.setRoot(root);  //树的根节点

        cell1.getChildren().addAll(cell2, cell3, cell4);  //添加树节点
        cell5.getChildren().addAll(cell6, cell7, cell8);
        cell9.getChildren().addAll(cell10, cell11, cell12);
        root.getChildren().addAll(cell1, cell5, cell9);
        root.setExpanded(true);
        treeview.setPrefWidth(360);
        treeview.setPrefHeight(950);


        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");


        TabPane tabPane = new TabPane();
        tabPane.setPrefWidth(850);
        tabPane.setPrefHeight(950);
        tabPane.setStyle("-fx-background-color: #ffffff");

        Border bor = new Border(new BorderStroke(Paint.valueOf("#1C1C1C"), SOLID, new CornerRadii(1), new BorderWidths(1)));
        tabPane.setBorder(bor);

        Tab tab1 = new Tab("选项卡 1");
        Tab tab2 = new Tab("选项卡 2");
        Tab tab3 = new Tab("选项卡 3");
        Tab tab4 = new Tab("选项卡 4");


//        HBox hbox = new HBox(10);
//        hbox.setAlignment(Pos.CENTER);
        Button button2 = new Button("BUTTON");
//        hbox.getChildren().addAll(new Button("button1"), new Button("button2"),button2);
        tab1.setContent(button2);


        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);


        MenuBar menubar = new MenuBar();
        Menu menu1 = new Menu("文件");
        Menu menu2 = new Menu("编辑");
        Menu menu3 = new Menu("视图");
        Menu menu4 = new Menu("导航");
        Menu menu5 = new Menu("代码");
        Menu menu6 = new Menu("分析");
        Menu menu7 = new Menu("工具");
        Menu menu8 = new Menu("帮助");

        SeparatorMenuItem separ1 = new SeparatorMenuItem();
        SeparatorMenuItem separ2 = new SeparatorMenuItem();
        SeparatorMenuItem separ3 = new SeparatorMenuItem();
        SeparatorMenuItem separ4 = new SeparatorMenuItem();

        MenuItem item1 = new MenuItem("新建", new ImageView("image/icon.jpg"));
        item1.setAccelerator(KeyCombination.valueOf("ctrl+Y"));


        MenuItem item2 = new MenuItem("打开");
        MenuItem item3 = new MenuItem("设置");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");
        MenuItem item6 = new MenuItem("item6");
        MenuItem item7 = new MenuItem("关闭");
        MenuItem item8 = new MenuItem("item8");
        MenuItem item9 = new MenuItem("item9");


        CustomMenuItem cmi1 = new CustomMenuItem();
        Button button = new Button("button");
        cmi1.setContent(button);

        ToggleGroup tg = new ToggleGroup();
        RadioMenuItem rmi1 = new RadioMenuItem("RadioMenuItem1");
        RadioMenuItem rmi2 = new RadioMenuItem("RadioMenuItem2");
        RadioMenuItem rmi3 = new RadioMenuItem("RadioMenuItem3");
        rmi1.setToggleGroup(tg);
        rmi2.setToggleGroup(tg);
        rmi3.setToggleGroup(tg);

        menu1.getItems().addAll(item1, separ1, item2, separ2, item5, separ3, item6, separ4, item7, menu8);

        menu2.getItems().addAll(item3, item4, rmi1, rmi2, rmi3);


        menu8.getItems().addAll(item8, item9);

        menubar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5, menu6, menu7);

        item1.setOnAction(new EventHandler<ActionEvent>()
                          {
                              @Override
                              public void handle(ActionEvent event) {
                                  System.out.println("item1.action");
                              }
                          }

        );

        an.getChildren().add(menubar);
        an.getChildren().add(tabPane);
        an.getChildren().add(treeview);
        an.getChildren().add(ta);

        an.getChildren().add(toolBar);
        an.setTopAnchor(toolBar, 25.0);      //toolbar位置
        an.setLeftAnchor(toolBar,760.0);

        an.setTopAnchor(tabPane, 58.0);  //设置tab组件的位置
        an.setTopAnchor(treeview, 25.0);
        an.setTopAnchor(ta, 720.0);
        AnchorPane.setLeftAnchor(tabPane, 360.0);


        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("参数辨识起步");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1200);
        primaryStage.setResizable(false);
        primaryStage.show();

        menubar.setPrefWidth(an.getWidth());

        rmi1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("当前选择状态：" + rmi1.isSelected());
            }
        });
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menubar.setPrefWidth((newValue.doubleValue()));
            }
        });
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                System.out.println(newValue.getText());
            }
        });
        tab1.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab t = (Tab) event.getSource();
                System.out.println("变化的是" + t.getText());
            }
        });
//        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//           public void handle(MouseEvent event) {
//               tabPane.getTabs().add(new Tab("new tab"));
//            }
//        });
//       treeview.requestFocus();
//        treeview.setEditable(true);
//
 //       treeview.setCellFactory(TextFieldTreeCell.fortreeview());

//        root.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                int times = event.getClickCount();
//                if (times == 2) {
//                    tabPane.getTabs().add(new Tab("new tab"));
//                }
//            }
//        });
//        treeview.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                TreeView t = (TreeView) event.getSource();
//                if(event.getClickCount() == 2 )
//                {
//                    tabPane.getTabs().add(new Tab("new tab"));
//                }
//            }
//        });
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tabPane.getTabs().add(new Tab("new tab"));
            }
        });
        treeview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                TreeItem<String> currentSelectItem = (TreeItem<String>) newValue;
                if (currentSelectItem != null && currentSelectItem.getValue() == "三级单元") {
                    System.out.println("selection(" + ((TreeItem<String>) newValue).getValue() + ") change");
                    tabPane.getSelectionModel().select(tab1);
                }
            }
        });


        ta.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });
        ta.setText("历史输入：");


        // treeview.getSelectionModel().selectedItemProperty().addListener();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

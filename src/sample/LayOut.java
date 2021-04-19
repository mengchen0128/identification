package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.BreadCrumbBar;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import java.io.File;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

public class LayOut extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Register a custom default font
        GlyphFontRegistry.register("icomoon", org.controlsfx.samples.HelloGlyphFont.class.getResourceAsStream("icomoon.ttf") , 16);
        /**
         * 组件布局-文本框
         */
        TextArea textArea = new TextArea();
        Border bor = new Border(new BorderStroke(Paint.valueOf("#1C1C1C"), SOLID, new CornerRadii(1), new BorderWidths(1)));
        textArea.setBorder(bor);

        /**
         * 工具栏
         */

        GlyphFont1 glyphFont11 =new GlyphFont1();
        /**
         * 树
         */
        TreeView<String> treeview = new TreeView<>();

        TreeItem<String> root = new TreeItem<>("主目录");

        TreeItem<String> cell1 = new TreeItem<>("二级目录");
        TreeItem<String> cell2 = new TreeItem<>("三级目录");
        TreeItem<String> cell3 = new TreeItem<>("三级目录");
        TreeItem<String> cell4 = new TreeItem<>("三级目录");

        TreeItem<String> cell5 = new TreeItem<>("二级目录");
        TreeItem<String> cell6 = new TreeItem<>("三级目录");
        TreeItem<String> cell7 = new TreeItem<>("三级目录");
        TreeItem<String> cell8 = new TreeItem<>("三级目录");

        TreeItem<String> cell9 = new TreeItem<>("二级目录");
        TreeItem<String> cell10 = new TreeItem<>("三级目录");
        TreeItem<String> cell11 = new TreeItem<>("三级目录");
        TreeItem<String> cell12 = new TreeItem<>("三级目录");

        treeview.setRoot(root);  //树的根节点
        NodeBuilder.addToList(cell1,cell2, cell3, cell4);
        NodeBuilder.addToList(cell5,cell6, cell7, cell8);
        NodeBuilder.addToList(cell9,cell10, cell11, cell12);
        NodeBuilder.addToList(root,cell1, cell5, cell9);
        root.setExpanded(true);

        /**
         * 导航栏
         */
        Pane pane = new Pane();
      //  BreadCrumbBar.getPanel(pane,root);
        BreadCrumbBar  sampleBreadCrumbBar=new BreadCrumbBar(root);
     //   new Thread(() -> breadCrumbBar.getPanel(pane)).start();
    //    sampleBreadCrumbBar.setSelectedCrumb(model);
        sampleBreadCrumbBar.getStylesheets().add("/css/breadcrumbbar.css");
        pane.getChildren().add(sampleBreadCrumbBar);
        /**
        * 选项卡
        */

        TabPane tabPane = new TabPane();

        tabPane.setStyle("-fx-background-color: #ffffff");

        Tab tab1 = new Tab("选项卡 1");
        Tab tab2 = new Tab("选项卡 2");
        Tab tab3 = new Tab("选项卡 3");
        Tab tab4 = new Tab("选项卡 4");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_LEFT);
        Button vbutton2 = new Button("开始绘图");
        Button vbutton=new Button("选择文件");
        final ObservableList strings = FXCollections.observableArrayList(
                "算法 1", "算法 2", "算法 3");
            //Non-editable combobox. Created with a builder
        ComboBox uneditableComboBox = new ComboBox();
        uneditableComboBox.setPromptText("Make a choice...");
        uneditableComboBox.setItems(FXCollections.observableArrayList(strings.subList(0, 3)));
        vbox.getChildren().addAll(vbutton,uneditableComboBox,vbutton2);
        tab1.setContent(vbox);

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


        AnchorPane an = new AnchorPane();
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("参数辨识起步");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1200);
        primaryStage.setResizable(true);
        primaryStage.show();



        VBox vbox1=new VBox();
        StackPane top=new StackPane();
        top.prefWidthProperty().bind(an.widthProperty());
        top.setPrefHeight(50);
        VBox vbox2=new VBox();
        BorderPane borderPane=new BorderPane();

        vbox2.getChildren().addAll(menubar,borderPane);

        glyphFont11.getPanel(borderPane);

        borderPane.setLeft(pane);

        top.getChildren().addAll(vbox2);


        SplitPane splitPane=new SplitPane();
        SplitPane bottom=new SplitPane();
        bottom.getItems().add(textArea);
        bottom.prefWidthProperty().bind(an.widthProperty());
        bottom.setPrefHeight(300);
        bottom.setStyle("-fx-background-color: #00FFFF");

        SplitPane middle=new SplitPane();
        middle.prefWidthProperty().bind(an.widthProperty());
        middle.prefHeightProperty().bind(an.heightProperty().subtract(top.getPrefHeight()+bottom.getPrefHeight()));
        middle.setStyle("-fx-background-color: #1E90FF");

        splitPane.getItems().addAll(middle,bottom);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPositions(0.7);


        StackPane left=new StackPane();

        left.prefHeightProperty().bind(middle.prefHeightProperty());
        left.setStyle("-fx-background-color: #FFB6C1");
        left.getChildren().addAll(treeview);

        StackPane center=new StackPane();

        center.prefHeightProperty().bind(middle.prefHeightProperty());
        center.setStyle("-fx-background-color: #0000FF");
        center.getChildren().addAll(tabPane);

        StackPane right=new StackPane();
        TableView tableView=new TableView();
        right.prefHeightProperty().bind(middle.prefHeightProperty());
        right.setStyle("-fx-background-color: #0000FF");
        right.getChildren().addAll(tableView);


        middle.getItems().addAll(left,center,right);
        middle.setDividerPositions(0.2,0.8,0.3);

        vbox1.getChildren().addAll(top,splitPane);


        an.setStyle("-fx-background-color: #ffffff");
        an.getChildren().add(vbox1);

        /**
         * 组件的操作-------------------------------------------------------------------------------------------
         */
        treeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sampleBreadCrumbBar.selectedCrumbProperty().set(newValue);
          /*  if (currentSelectItem != null && currentSelectItem.getValue() .equals("三级目录")) {
                System.out.println("selection(" + ((TreeItem<String>) newValue).getValue() + ") change");
                tabPane.getSelectionModel().select(tab1);
            }
           */
        });
        /**
         * 菜单按钮-----------------------------------------------------------------------------------------------
         */
        rmi1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("当前选择状态：" + rmi1.isSelected());
            }
        });
        /**
        * 选项卡操作----------------------------------------------------------------------------------------------------
         */
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
        uneditableComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue=="算法 1")
                {
                    new Thread(() -> Algorithm1.start()).start();
                }
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
//        vbutton2.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                tabPane.getTabs().add(new Tab("new tab"));
//            }
//        });

        vbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage=new Stage();
                FileChooser fileChooser=new FileChooser();
                fileChooser.setTitle("选择辨识数据");
                fileChooser.setInitialDirectory(new File("C:\\Users\\Student-16\\Desktop\\java"));
                File file= fileChooser.showOpenDialog(stage);
                if(file==null){return;}
                TxtRead.readFile1(file.getAbsolutePath());
            }
        });
       vbutton2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
                    NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
                    ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
                            new LineChart.Series<Double,Double>("Series 1", FXCollections.observableArrayList(
                                    new XYChart.Data<Double,Double>(0.0, 1.0),
                                    new XYChart.Data<Double,Double>(1.2, 1.4),
                                    new XYChart.Data<Double,Double>(2.2, 1.9),
                                    new XYChart.Data<Double,Double>(2.7, 2.3),
                                    new XYChart.Data<Double,Double>(2.9, 0.5)
                            )),
                            new LineChart.Series<Double,Double>("Series 2", FXCollections.observableArrayList(
                                    new XYChart.Data<Double,Double>(0.0, 1.6),
                                    new XYChart.Data<Double,Double>(0.8, 0.4),
                                    new XYChart.Data<Double,Double>(1.4, 2.9),
                                    new XYChart.Data<Double,Double>(2.1, 1.3),
                                    new XYChart.Data<Double,Double>(2.6, 0.9)
                            ))
                    );
                    LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
                    chart.setMaxWidth(600);
                    chart.setMaxHeight(600);
                    vbox.getChildren().addAll(chart);

                }
            });

        textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });
        textArea.setText("历史输入：");
        // treeview.getSelectionModel().selectedItemProperty().addListener();

    }
}

package sample;

import com.jfoenix.controls.*;
import com.jfoenix.svg.SVGGlyphLoader;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.io.File;
import java.io.IOException;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

public class LayOut extends Application {
    public static  JFXTabPane  tabPane;
    private JFXListView<Label> listview2;
    @Override
    public void start(Stage primaryStage) throws Exception {

        new Thread(() -> {
            try {
                SVGGlyphLoader.loadGlyphsFont(LayOut.class.getResourceAsStream("/fonts/icon_font/iconfont.svg"),
                        ApplicatonStore.ICON_FONT_KEY);

            } catch (IOException ioExc) {
                ioExc.printStackTrace();
            }
        }).start();


        /**
         * 按钮
         */
        JFXButton push = new JFXButton("Raised Button".toUpperCase());
        push.getStylesheets().add("/css/button.css");
        push.getStyleClass().add("button-raised");

     //   Button push = new Button("Push Me!");
        push.setOnAction(new ButtonHandler());

        /**
         * 组件布局-文本框
         */
    //    JFXTextArea textArea=new JFXTextArea();
       TextArea textArea = new TextArea();
/*        Border bor = new Border(new BorderStroke(Paint.valueOf("#1C1C1C"), SOLID, new CornerRadii(1), new BorderWidths(1)));
        textArea.setBorder(bor);*/

        /**
         * 工具栏
         */
        JFXButton homeButton=new JFXButton();
        homeButton.setGraphic(SVGGlyphLoader.getIcoMoonGlyph(ApplicatonStore.ICON_FONT_KEY + ".home-outline"));
        homeButton.getStyleClass().add("tool-bar-button");
        /**
         * 列表
         */
        JFXListView<Object> listview = new JFXListView<>();
        listview2 = new JFXListView<>();
   //     ObservableList<Label> List = FXCollections.observableArrayList();
         //for(int i = 0 ; i < 4 ; i++)
      //     listview.getItems().add(new Label("Item " + i));
     //   ObservableList<Label> List2 = FXCollections.observableArrayList();
        Label label1=new Label("主页");
        Label label2=new Label("主页");
        Label label3=new Label("主页");
        Label label4=new Label("参数辨识");
        label4.setGraphic(SVGGlyphLoader.getIcoMoonGlyph(ApplicatonStore.ICON_FONT_KEY + ".taiyang"));
        Label label5=new Label("参数辨识");
        label5.setGraphic(SVGGlyphLoader.getIcoMoonGlyph(ApplicatonStore.ICON_FONT_KEY + ".jiankong"));


    //    List.addAll(label1,label2,label3);


    //    listview2.setItems(List);
        listview2.getItems().addAll(label1,label2,label3);
        listview2.getStyleClass().add("sublist");
        listview2.setGroupnode(label5);
        listview.getItems().addAll(label4,listview2);
        listview.getStyleClass().add("navigation-list");

        listview.getSelectionModel().clearAndSelect(0);
        listview.expandedProperty().set(true);
        listview2.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> {
            if(newValue==null)
            {
                return;
            }
            tabPane.getTabs().add(new Tab( newValue.getText()));

        });

     //   TreeView<String> treeview = new TreeView<>();
        JFXTreeView<String> treeView=new JFXTreeView<>();

/*        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sampleBreadCrumbBar.selectedCrumbProperty().set(newValue);
            if (currentSelectItem != null && currentSelectItem.getValue() .equals("三级目录")) {
                System.out.println("selection(" + ((TreeItem<String>) newValue).getValue() + ") change");
                tabPane.getSelectionModel().select(tab1);
            }
        });*/


/*
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
        root.setExpanded(true);*/

        /**
         * 工具
         */
        Pane pane = new Pane();
        pane.getStyleClass().add("tool-pane");
        pane.getChildren().add(homeButton);
        //BreadCrumbBar  sampleBreadCrumbBar=new BreadCrumbBar(root);
     //   new Thread(() -> breadCrumbBar.getPanel(pane)).start();
    //    sampleBreadCrumbBar.setSelectedCrumb(model);
      //  sampleBreadCrumbBar.getStylesheets().add("/css/breadcrumbbar.css");
      //  pane.getChildren().add(sampleBreadCrumbBar);
        /**
        * 选项卡
        */

        //TabPane tabPane = new TabPane();
         tabPane = new JFXTabPane();
         tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);

        Tab tab1 = new Tab("主页");
        tab1.setClosable(false);
        tab1.setGraphic(SVGGlyphLoader.getIcoMoonGlyph(ApplicatonStore.ICON_FONT_KEY + ".home-outline"));
       // tab1.getStyleClass().addAll("tab-content");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_LEFT);
        JFXButton vbutton2 = new JFXButton("开始绘图");
        JFXButton vbutton=new JFXButton("选择文件");



        final ObservableList strings = FXCollections.observableArrayList(
                "算法 1", "算法 2", "算法 3");
            //Non-editable combobox. Created with a builder
        ComboBox uneditableComboBox = new ComboBox();
/*        uneditableComboBox.setPromptText("Make a choice...");
        uneditableComboBox.setItems(FXCollections.observableArrayList(strings.subList(0, 3)));*/

        JFXComboBox<String> jfxCombo = new JFXComboBox<>();

/*      jfxCombo.getItems().add(new Label("算法 1"));
        jfxCombo.getItems().add(new Label("算法 2"));
        jfxCombo.getItems().add(new Label("算法 3"));
        jfxCombo.getItems().add(new Label("算法 4"));*/

        jfxCombo.setItems(FXCollections.observableArrayList(strings.subList(0, 3)));
        jfxCombo.setPromptText("Make a choice...");

        vbox.getChildren().addAll(vbutton,jfxCombo,vbutton2,push);
        tab1.setContent(vbox);

        tabPane.getTabs().addAll(tab1);


        /**
         * 菜单
         */
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

/**
 * 表
 */

        TableView tableView=new TableView();



        AnchorPane an = new AnchorPane();
        JFXDecorator wfxDecorator = new JFXDecorator(primaryStage,an);

        Scene scene = new Scene(wfxDecorator);
        primaryStage.setScene(scene);
        primaryStage.setTitle("参数辨识");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1200);
        primaryStage.setResizable(true);
        primaryStage.show();


        scene.getStylesheets().add( "/css/app-light.css");


        VBox vbox1=new VBox();
        StackPane top=new StackPane();
        top.prefWidthProperty().bind(an.widthProperty());
        VBox vbox2=new VBox();
        BorderPane borderPane=new BorderPane();

        vbox2.getChildren().addAll(menubar,borderPane);



        borderPane.setLeft(pane);

        Border bor = new Border(new BorderStroke(Paint.valueOf("#DCDCDC"), SOLID, new CornerRadii(1), new BorderWidths(1)));
        borderPane.setBorder(bor);
        top.getChildren().addAll(vbox2);


        SplitPane splitPane=new SplitPane();
        SplitPane bottom=new SplitPane();
        bottom.getItems().add(textArea);
        bottom.prefWidthProperty().bind(an.widthProperty());
        bottom.setPrefHeight(300);
  //      bottom.setStyle("-fx-background-color: #00FFFF");

        SplitPane middle=new SplitPane();
        middle.prefWidthProperty().bind(an.widthProperty());
        middle.prefHeightProperty().bind(an.heightProperty().subtract(top.getPrefHeight()+bottom.getPrefHeight()));
    //    middle.setStyle("-fx-background-color: #1E90FF");

        splitPane.getItems().addAll(middle,bottom);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPositions(0.7);


        StackPane left=new StackPane();

        left.prefHeightProperty().bind(middle.prefHeightProperty());
     //   left.setStyle("-fx-background-color: #FFB6C1");


        left.getChildren().addAll(listview);


/*        JFXDrawersStack jfxDrawersStack=new JFXDrawersStack();
        jfxDrawersStack.setContent(tabPane);
        jfxDrawersStack.prefHeightProperty().bind(middle.prefHeightProperty());*/


        StackPane center=new StackPane();
        center.prefHeightProperty().bind(middle.prefHeightProperty());
       center.setStyle("-fx-background-color: #F5F5F5");
        center.getChildren().addAll(tabPane);

        StackPane right=new StackPane();





        right.prefHeightProperty().bind(middle.prefHeightProperty());
  //      right.setStyle("-fx-background-color: #0000FF");
        right.getChildren().addAll(tableView);


        middle.getItems().addAll(left,center,right);
        middle.setDividerPositions(0.2,0.8,0.3);

        vbox1.getChildren().addAll(top,splitPane);


        an.setStyle("-fx-background-color: #ffffff");
        an.getChildren().add(vbox1);

        /**
         * 组件的操作-------------------------------------------------------------------------------------------
         */
/*        treeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sampleBreadCrumbBar.selectedCrumbProperty().set(newValue);
            if (currentSelectItem != null && currentSelectItem.getValue() .equals("三级目录")) {
                System.out.println("selection(" + ((TreeItem<String>) newValue).getValue() + ") change");
                tabPane.getSelectionModel().select(tab1);
            }
        });*/
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
/*        tab1.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab t = (Tab) event.getSource();
                System.out.println("变化的是" + t.getText());
            }
        });*/
        jfxCombo.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            if (newValue=="算法 1")
            {
                new Thread(() -> Algorithm.start()).start();
                // Algorithm1.start();
            }
                }
        );


/*        uneditableComboBox.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            if (newValue=="算法 1")
            {
                new Thread(() -> Algorithm.start()).start();
               // Algorithm1.start();
            }
        });*/

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
     //   textArea.setText("历史输入：");
        // treeview.getSelectionModel().selectedItemProperty().addListener();

    }
}

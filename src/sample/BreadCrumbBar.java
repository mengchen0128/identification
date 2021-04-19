package sample;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;

public class BreadCrumbBar  {

    public static Node getPanel(Pane pane, TreeItem treeItem) {
        org.controlsfx.control.BreadCrumbBar breadCrumbBar=new org.controlsfx.control.BreadCrumbBar(treeItem);
        pane.getChildren().addAll(breadCrumbBar);
        return pane;
    }
}

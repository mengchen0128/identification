package sample;

import javafx.scene.control.TreeItem;

public class NodeBuilder {
    public static <T> void addToList (TreeItem<T> listArg, TreeItem... elements) {
        for (TreeItem x : elements) {
            listArg.getChildren().add(x);
        }
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;

class ButtonHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        LayOut layOut=new LayOut();
        layOut.tabPane.getTabs().add(new Tab("new tab"));

    }
}

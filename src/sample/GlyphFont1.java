package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

public class GlyphFont1  {
    private GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");
    private static char FAW_GEAR  = '\uf013';


    public  Node getPanel(final BorderPane pane) {
        Button button1= new Button("", new Glyph("FontAwesome", "TRASH_ALT"));            // Use the Glyph-class with a icon name
        Button button2  = new Button("", new Glyph("FontAwesome", FontAwesome.Glyph.STAR));   // Use the Glyph-class with a known enum value
                Button button3   =  new Button("", Glyph.create("FontAwesome|BUG"));                  // Use the static Glyph-class create protocol
                Button button4   =  new Button("", fontAwesome.create("REBEL"));                        // Use the font-instance with a name
                Button button5   =    new Button("", fontAwesome.create(FontAwesome.Glyph.SMILE_ALT));    // Use the font-instance with a enum
                Button button6    =    new Button("", fontAwesome.create(FAW_GEAR).color(Color.RED));
        ToolBar toolbar = new ToolBar(
                // There are many ways how you can define a Glyph:
      // Use the font-instance with a unicode char
        );
       toolbar.getItems().addAll( button1, button2, button3, button4, button5 ,button6);
        pane.setRight(toolbar);;

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是按钮一");
            }
        });

        return pane;
    }
}

package athensclub.comproj.control;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * A custom layout class that contain all the buttons
 * 
 * @author Athensclub
 *
 */
public class GButtons extends VBox {

    private SimpleObjectProperty<Paint> textFill;
    
    public GButtons() throws IOException {
	textFill = new SimpleObjectProperty<>();
	textFill.addListener((obj,oldv,newv)->getChildren().forEach(btn->((GButton)btn).setTextFill(getTextFill())));
	FXMLLoader loader = new FXMLLoader(getClass().getResource("gbuttons.fxml"));
	loader.setController(this);
	loader.setRoot(this);
	getChildren().addListener((ListChangeListener<? super Node>) (change -> {
	    if (change.next()) {
		change.getAddedSubList().forEach(obj -> {
		    if (!(obj instanceof GButton)) {
			throw new IllegalArgumentException("Add non-GButton node to GButtons: " + obj);
		    }
		    if(getTextFill() != null) {
			((GButton)obj).setTextFill(getTextFill());
		    }
		});
	    }
	}));
	loader.load();
	setStyle("-fx-font-size: 20;");
    }
    
    public Paint getTextFill() {
	return textFillProperty().get();
    }
    
    public void setTextFill(Paint textFill) {
	textFillProperty().set(textFill);
    }
    
    public ObjectProperty<Paint> textFillProperty(){
	return textFill;
    }

}

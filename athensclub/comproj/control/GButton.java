package athensclub.comproj.control;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 * A custom button class that has text of explanation in front of it and action
 * button after text
 * 
 * @author Athensclub
 *
 */
public class GButton extends HBox {

    @FXML
    private Text text;
    @FXML
    private Button button;
    
    private SimpleObjectProperty<Paint> textFill;

    public GButton() throws IOException {
	textFill = new SimpleObjectProperty<>();
	textFill.addListener((obj,oldv,newv)->text.setFill(getTextFill()));
	FXMLLoader loader = new FXMLLoader(getClass().getResource("gbutton.fxml"));
	loader.setRoot(this);
	loader.setController(this);
	loader.load();
	setStyle("-fx-font-size: 20;");
    }
    
    public Text text() {
	return text;
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

    public EventHandler<ActionEvent> getOnAction() {
	return onActionProperty().get();
    }

    public void setOnAction(EventHandler<ActionEvent> onAction) {
	onActionProperty().set(onAction);
    }

    public ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
	return button.onActionProperty();
    }

    public void setText(String text) {
	textProperty().set(text);
    }

    public String getText() {
	return textProperty().get();
    }

    public StringProperty textProperty() {
	return text.textProperty();
    }

}

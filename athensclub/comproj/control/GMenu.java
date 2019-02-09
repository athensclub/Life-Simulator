package athensclub.comproj.control;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * A class for menus
 * 
 * @author Athensclub
 *
 */
public class GMenu extends BorderPane {

    @FXML
    private GButtons buttons;

    @FXML
    private VBox titlePane;

    @FXML
    private Label titleLabel;

    @FXML
    private Label subtitleLabel;

    private SimpleObjectProperty<GButtons> buttonsp;

    private SimpleObjectProperty<Paint> textFill;

    private SimpleObjectProperty<Image> backgroundImage;

    private SimpleBooleanProperty tileBackground;

    public GMenu() throws IOException {
	buttonsp = new SimpleObjectProperty<>();
	backgroundImage = new SimpleObjectProperty<>();
	tileBackground = new SimpleBooleanProperty();
	textFill = new SimpleObjectProperty<>();
	textFill.addListener((obj, oldv, newv) -> {
	    if (getButtons() != null) {
		getButtons().setTextFill(getTextFill());
	    }
	    titleLabel.setTextFill(getTextFill());
	    subtitleLabel.setTextFill(getTextFill());
	});
	buttonsp.addListener((obj, oldv, newv) -> {
	    this.buttons = getButtons();
	    setCenter(getButtons());
	    if (getTextFill() != null) {
		getButtons().setTextFill(getTextFill());
	    }
	});
	FXMLLoader loader = new FXMLLoader(getClass().getResource("gmenu.fxml"));
	loader.setController(this);
	loader.setRoot(this);
	backgroundImage.addListener((obj, oldv, newv) -> updateBackground());
	tileBackground.addListener((obj, oldv, newv) -> updateBackground());
	getChildren().addListener((ListChangeListener<? super Node>) (change -> {
	    if (change.next() && change.wasAdded()) {
		if (!change.getAddedSubList().contains(titlePane) && !containsButtons(change.getAddedSubList())) {
		    buttons.getChildren().addAll(change.getAddedSubList());
		    getChildren().removeAll(change.getAddedSubList());
		}
	    }
	}));
	loader.load();
	setButtons(buttons);
	titlePane.setStyle("-fx-font-size: 26;");
	subtitleLabel.setStyle("-fx-font-size: 24;");
    }

    private static boolean containsButtons(List<? extends Node> node) {
	for (int i = 0; i < node.size(); i++) {
	    if (node.get(i) instanceof GButtons) {
		return true;
	    }
	}
	return false;
    }

    public void setButtons(GButtons buttons) {
	buttonsp.set(buttons);
    }

    public GButtons getButtons() {
	return buttonsp.get();
    }

    public ObjectProperty<GButtons> buttonsProperty() {
	return buttonsp;
    }

    public Paint getTextFill() {
	return textFillProperty().get();
    }

    public void setTextFill(Paint textFill) {
	textFillProperty().set(textFill);
    }

    public ObjectProperty<Paint> textFillProperty() {
	return textFill;
    }

    /**
     * Update the background image y creating new instance of background object with
     * current configuration
     * 
     */
    private void updateBackground() {
	if (getBackgroundImage() != null) {
	    setBackground(new Background(new BackgroundImage(getBackgroundImage(),
		    isTileBackground() ? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT,
		    isTileBackground() ? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
    }

    public String getSubtitle() {
	return subtitleProperty().get();
    }

    public void setSubtitle(String subtitle) {
	subtitleProperty().set(subtitle);
    }

    public StringProperty subtitleProperty() {
	return subtitleLabel.textProperty();
    }

    public String getTitle() {
	return titleProperty().get();
    }

    public void setTitle(String title) {
	titleProperty().set(title);
    }

    public StringProperty titleProperty() {
	return titleLabel.textProperty();
    }

    public boolean isTileBackground() {
	return tileBackground.get();
    }

    public void setTileBackground(boolean value) {
	tileBackground.set(value);
    }

    public SimpleBooleanProperty tileBackgroundProperty() {
	return tileBackground;
    }

    public Image getBackgroundImage() {
	return backgroundImage.get();
    }

    public void setBackgroundImage(Image img) {
	backgroundImage.set(img);
    }

    public ObjectProperty<Image> backgroundImageProperty() {
	return backgroundImage;
    }

}

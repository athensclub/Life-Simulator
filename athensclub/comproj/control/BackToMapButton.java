package athensclub.comproj.control;

import java.io.IOException;

import athensclub.comproj.Main;
import athensclub.comproj.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class BackToMapButton extends HBox{
    
    public BackToMapButton() throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("back_to_map_button.fxml"));
	loader.setRoot(this);
	loader.setController(this);
	loader.load();
	setStyle("-fx-font-size: 20;");
    }
    
    @FXML public void onClicked() {
	Main.changeScene(Scenes.gameMap);
    }
    
}

package athensclub.comproj.panes;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

/**
 * A controller class for credits pane
 *
 * @author Athensclub
 */
public class CreditsController {

    @FXML private BorderPane pane;

    @FXML private VBox names;

    @FXML private VBox title;

    @FXML private HBox backToMainMenu;

    @FXML public void initialize(){
        title.setStyle("-fx-font-size: 26;");
        names.setStyle("-fx-font-size: 20;");
        backToMainMenu.setStyle("-fx-font-size: 20");
        pane.setBackground(new Background(new BackgroundImage(Images.cityBackground, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    }

    @FXML public void onBackToMainMenuClicked(){
        Main.changeScene(Scenes.mainMenu);
    }

}

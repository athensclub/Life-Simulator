package athensclub.comproj.panes;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.Panes;
import athensclub.comproj.Scenes;
import athensclub.comproj.game.Player;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A Controller class for main menu pane
 *
 * @author Athensclub
 */
public class MainMenuController {

    @FXML private BorderPane pane;

    @FXML private VBox title;

    @FXML private VBox buttons;

    @FXML public void initialize(){
        title.setStyle("-fx-font-size: 26;");
        buttons.setStyle("-fx-font-size: 20;");
        pane.setBackground(new Background(new BackgroundImage(Images.cityBackground, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    }

    @FXML public void onNewGameClicked(){
        Main.currentPlayer = new Player();
        Main.updatePlayerData(Main.currentPlayer);
        Main.changeScene(Scenes.gameMap);
    }

    @FXML public void onCreditsClicked(){
        Main.changeScene(Scenes.credits);
    }

}

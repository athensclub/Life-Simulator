package athensclub.comproj.panes;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.Scenes;
import athensclub.comproj.game.Player;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;


/**
 * A controller class for toolbar pane
 *
 * @author Athensclub
 */
public class ToolbarController {

    @FXML private FlowPane pane;

    @FXML private HBox healthPane;

    @FXML private HBox hungerPane;

    @FXML private HBox moneyPane;

    @FXML private HBox agePane;

    @FXML private Text health;

    @FXML private Text hunger;

    @FXML private Text age;

    @FXML private Text money;

    @FXML private ImageView hungerIcon;

    @FXML private ImageView healthIcon;

    @FXML private ImageView ageIcon;

    @FXML private ImageView moneyIcon;

    /**
     * Update the text of current player status to the given one
     */
    public void updatePlayerData(Player player){
        health.setText(player.getHealth() + " / 100");
        hunger.setText(player.getHunger() + " / 100");
        age.setText(player.getAge().toThaiString());
        money.setText(player.getMoney() + "บาท");
    }

    public void initialize(){
        healthPane.setStyle("-fx-font-size: 20;");
        hungerPane.setStyle("-fx-font-size: 20;");
        moneyPane.setStyle("-fx-font-size: 20;");
        agePane.setStyle("-fx-font-size: 20;");
        moneyIcon.setImage(Images.dollarSign);
        ageIcon.setImage(Images.clock);
        hungerIcon.setImage(Images.burger);
        healthIcon.setImage(Images.heart);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.DARKBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        pane.setBackground(new Background(new BackgroundFill(lg1,CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    public void onBackToMainMenuClicked(){
        Main.changeScene(Scenes.mainMenu);
    }

}

package athensclub.comproj.panes.indoors;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.Panes;
import athensclub.comproj.Scenes;
import athensclub.comproj.control.HasToolbar;
import athensclub.comproj.game.item.Food;
import athensclub.comproj.game.item.Heal;
import athensclub.comproj.game.item.Job;
import javafx.fxml.FXML;
import javafx.scene.layout.*;

/**
 * A controller class for inside card board box pane
 *
 * @author Athensclub
 */
public class InCardboardBoxController implements HasToolbar {

    @FXML private BorderPane pane;

    @FXML public void initialize(){
        pane.setTop(Panes.toolbar);
        pane.setBackground(new Background(new BackgroundImage(Images.insideCardboardBox, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    }

    @FXML public void onBegClicked(){
        Main.currentPlayer.work(Job.BEG);
    }

    @FXML public void onEatFromTrashClicked(){
        Main.currentPlayer.buy(Food.TRASH);
    }

    @FXML public void onSleepInCardboardBoxClicked(){
        Main.currentPlayer.buy(Heal.SLEEP_IN_CARDBOARD_BOX);
    }

}

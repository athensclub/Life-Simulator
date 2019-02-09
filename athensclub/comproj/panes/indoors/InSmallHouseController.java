package athensclub.comproj.panes.indoors;

import java.io.IOException;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.control.GButton;
import athensclub.comproj.control.GButtons;
import athensclub.comproj.control.GMenu;
import athensclub.comproj.control.HasToolbar;
import athensclub.comproj.game.Player;
import athensclub.comproj.game.item.Food;
import athensclub.comproj.game.item.Heal;
import athensclub.comproj.game.item.Shelter;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 * A controller class for a inside small house pane
 *
 * @author Athensclub
 */
public class InSmallHouseController implements HasToolbar {

    @FXML private BorderPane pane;
    
    @FXML private GMenu menu;
    
    @FXML private GButton buySmallHouse;
    
    @FXML private GButton sleepInSmallHouse;
    
    @FXML private GButton eatHomemadeFood;
    
    private GButtons whenOwn;
    
    private GButtons whenNotOwn;

    @FXML public void initialize() throws IOException{
	whenOwn = new GButtons();
	whenOwn.getChildren().addAll(sleepInSmallHouse,eatHomemadeFood);
	whenNotOwn = new GButtons();
	whenNotOwn.getChildren().addAll(buySmallHouse);
        pane.setBackground(new Background(new BackgroundImage(Images.insideSmallHouse,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    }
    
    public void updatePlayerData(Player player) {
	if(!player.own(Shelter.SMALL_HOUSE)) {
	    menu.setSubtitle("คุณไม่ได้เป็นเจ้าของบ้านหลังนี้");
	    menu.setButtons(whenNotOwn);
	}else {
	    menu.setSubtitle("คุณเป็นเจ้าของบ้านหลังนี้");
	    menu.setButtons(whenOwn);
	}
    }

    @FXML public void onSleepInSmallHouseClicked(){
        Main.currentPlayer.buy(Heal.SLEEP_IN_SMALL_HOUSE);
    }

    @FXML public void onEatHomemadeFoodClicked() {
	Main.currentPlayer.buy(Food.HOMEMADE);
    }
    
    @FXML public void onBuySmallHouseClicked() {
	Main.currentPlayer.buy(Shelter.SMALL_HOUSE);
    }

}

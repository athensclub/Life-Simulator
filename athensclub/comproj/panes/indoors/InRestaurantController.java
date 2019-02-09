package athensclub.comproj.panes.indoors;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.control.GButton;
import athensclub.comproj.control.GMenu;
import athensclub.comproj.control.HasToolbar;
import athensclub.comproj.game.item.Food;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 * A controller class for inside restaurant pane
 * 
 * @author Athensclub
 *
 */
public class InRestaurantController implements HasToolbar{

    @FXML private BorderPane pane;
    
    @FXML private GMenu menu;
    
    @FXML public void initialize() {
	pane.setBackground(new Background(new BackgroundImage(Images.insideRestaurant,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    }
    
    @FXML public void onBuyRestaurantSmallFoodClicked() {
	Main.currentPlayer.buy(Food.RESTAURANT_SMALL);
    }
    
    @FXML public void onBuyRestaurantMediumFoodClicked() {
	Main.currentPlayer.buy(Food.RESTAURANT_MEDUIM);
    }
    
    @FXML public void onBuyRestaurantLargeFoodClicked() {
	Main.currentPlayer.buy(Food.RESTAURANT_LARGE);
    }
    
}

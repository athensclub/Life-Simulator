package athensclub.comproj;

import athensclub.comproj.Panes;
import athensclub.comproj.control.GScene;
import athensclub.comproj.game.*;
import javafx.scene.Scene;

/**
 * A class containing all the scenes in game. ALl the scenes only wrap the panes
 *
 * @author Athensclub
 */
public class Scenes {

    public static GScene mainMenu,credits,gameMap,inCardboardBox,inSmallHouse,inRestaurant;

    /**
     * Load all the scene from {@link athensclub.comproj.Panes} classs.Therefore Panes class must be called load() first
     */
    public static void load(){
        mainMenu = new GScene(Panes.mainMenu,Panes.mainMenuController);
        credits = new GScene(Panes.credits,Panes.creditsController);
        gameMap = new GScene(Panes.gameMap,Panes.gameMapController);
        inCardboardBox = new GScene(Panes.inCardboardBox,Panes.inCardboardBoxController);
        inSmallHouse = new GScene(Panes.inSmallHouse,Panes.inSmallHouseController);
        inRestaurant = new GScene(Panes.inRestaurant,Panes.inRestaurantController);
    }

}

package athensclub.comproj;

import java.net.URL;

import athensclub.comproj.panes.CreditsController;
import athensclub.comproj.panes.GameMapController;
import athensclub.comproj.panes.MainMenuController;
import athensclub.comproj.panes.ToolbarController;
import athensclub.comproj.panes.indoors.InCardboardBoxController;
import athensclub.comproj.panes.indoors.InRestaurantController;
import athensclub.comproj.panes.indoors.InSmallHouseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * A class used for accessing and loading panes
 *
 * @author Athensclub
 */
public class Panes {

    /**
     * A constants for all panes in this game
     */
    public static Pane mainMenu,credits,gameMap,toolbar,inCardboardBox,inSmallHouse,inRestaurant;

    public static MainMenuController mainMenuController;

    public static CreditsController creditsController;

    public static GameMapController gameMapController;

    public static ToolbarController toolbarController;

    public static InCardboardBoxController inCardboardBoxController;

    public static InSmallHouseController inSmallHouseController;
    
    public static InRestaurantController inRestaurantController;
    /**
     * Get the url of the fxml that is inside panes package
     */
    private static URL url(String fxmlName) throws Exception{
        return Panes.class.getResource("panes/" + fxmlName + ".fxml");
    }

    public static void load() throws Exception{
        FXMLLoader toolbarLoader = new FXMLLoader(url("toolbar"));
        toolbar = toolbarLoader.load();
        toolbarController = toolbarLoader.getController();
        FXMLLoader mainMenuLoader = new FXMLLoader(url("main_menu"));
        mainMenu = mainMenuLoader.load();
        mainMenuController = mainMenuLoader.getController();
        FXMLLoader creditsLoader = new FXMLLoader(url("credits"));
        credits = creditsLoader.load();
        creditsController = creditsLoader.getController();
        FXMLLoader gameMapLoader = new FXMLLoader(url("game_map"));
        gameMap = gameMapLoader.load();
        gameMapController = gameMapLoader.getController();
        FXMLLoader inCardboardBoxLoader = new FXMLLoader(url("indoors/in_cardboard_box"));
        inCardboardBox = inCardboardBoxLoader.load();
        inCardboardBoxController = inCardboardBoxLoader.getController();
        FXMLLoader inSmallHouseLoader = new FXMLLoader(url("indoors/in_small_house"));
        inSmallHouse = inSmallHouseLoader.load();
        inSmallHouseController = inSmallHouseLoader.getController();
        FXMLLoader inRestaurantLoader = new FXMLLoader(url("indoors/in_restaurant"));
        inRestaurant = inRestaurantLoader.load();
        inRestaurantController = inRestaurantLoader.getController();
    }

}

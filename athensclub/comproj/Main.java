package athensclub.comproj;

import athensclub.comproj.control.GScene;
import athensclub.comproj.control.HasToolbar;
import athensclub.comproj.game.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

/**
 * A class containing main method
 *
 * @author Athensclub
 */
public class Main extends Application {

    /**
     * The main stage for the game
     */
    public static Stage primaryStage;

    public static Player currentPlayer;

    /**
     * Update all ui component to display according to the given player data
     */
    public static void updatePlayerData(Player player){
        Panes.toolbarController.updatePlayerData(player);
        Panes.inSmallHouseController.updatePlayerData(player);
    }

    /**
     * Change the scene of the primary stage to the given scene,making changes as necessary
     * @param scene
     */
    public static void changeScene(GScene scene){
        Object controller = scene.getController();
        if(controller instanceof HasToolbar){
            ((BorderPane)scene.getRoot()).setTop(Panes.toolbar);
        }
        primaryStage.setScene(scene);
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        Images.load();
        Panes.load();
        Scenes.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.setResizable(false);
        stage.setScene(Scenes.mainMenu);
        stage.setTitle("Life Simulator");
        stage.getIcons().add(Images.dollarSign);
        stage.show();
    }



}

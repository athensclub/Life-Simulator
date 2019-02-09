package athensclub.comproj.panes;

import athensclub.comproj.Images;
import athensclub.comproj.Main;
import athensclub.comproj.Panes;
import athensclub.comproj.Scenes;
import athensclub.comproj.control.HasToolbar;
import athensclub.comproj.control.Tile;
import athensclub.comproj.game.item.Shelter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * A controller class for game map pane
 *
 * @author Athensclub
 */
public class GameMapController implements HasToolbar {

    @FXML private BorderPane pane;

    @FXML private GridPane map;

    @FXML private ImageView tile0_0,tile1_0,tile2_0;

    private Tile[][] tiles;

    /**
     * Get the tile at the given position
     * @param x
     * @param y
     * @return
     */
    public Tile tileAt(int x,int y){
        return tiles[x][y];
    }

    @FXML public void initialize(){
        pane.setTop(Panes.toolbar);
        map.setStyle("-fx-font-size: 20;");
        map.setBackground(new Background(new BackgroundImage(Images.emptyLot, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        tiles = new Tile[4][2];
        tiles[0][0] = Tile.shelterTile(tile0_0, Shelter.CARDBOARD_BOX);
        tiles[1][0] = Tile.shelterTile(tile1_0,Shelter.SMALL_HOUSE);
        tiles[2][0] = new Tile(tile2_0);
        tileAt(2,0).setImage(Images.restaurant);
        tileAt(2,0).setMouseOverImage(Images.restaurantDarker);
    }

    /**
     * Cardboard tile
     */
    @FXML public void onTile00Clicked(MouseEvent e){
        if(e.getButton() == MouseButton.PRIMARY){
            Main.changeScene(Scenes.inCardboardBox);
        }
    }

    /**
     * Small house tile
     * @param e
     */
    @FXML public void onTile10Clicked(MouseEvent e){
        if(e.getButton() == MouseButton.PRIMARY){
            Main.changeScene(Scenes.inSmallHouse);
        }
    }
    
    /**
     * Restaurant tile
     * @param e
     */
    @FXML public void onTile20Clicked(MouseEvent e) {
	if(e.getButton() == MouseButton.PRIMARY) {
	    Main.changeScene(Scenes.inRestaurant);
	}
    }

    @FXML public void onBackToMainMenuClicked(){
        Main.changeScene(Scenes.mainMenu);
    }

}

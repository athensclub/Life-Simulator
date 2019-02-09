package athensclub.comproj.game.item;

import athensclub.comproj.Images;
import athensclub.comproj.game.Player;
import javafx.scene.image.Image;

/**
 * A enum represent all shelter that player can own
 */
public enum Shelter implements Buyable{

    CARDBOARD_BOX(Images.cardboardBoxDarker,Images.cardBoardBox,0),
    SMALL_HOUSE(Images.smallHouseDarker,Images.smallHouse,2500);

    private Image mouseOver,normal;
    
    private double price;
    
    private Shelter(Image mouseOver,Image normal,double price){
        this.mouseOver = mouseOver;
        this.normal = normal;
        this.price = price;
    }

    public Image getMouseOverImage(){
        return mouseOver;
    }

    public Image getNormalImage(){
        return normal;
    }
    
    @Override
    public double getPrice() {
	return price;
    }

    @Override
    public void onBought(Player player) {
	player.addShelter(this).update();
    }

}

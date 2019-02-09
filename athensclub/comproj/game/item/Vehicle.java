package athensclub.comproj.game.item;

import athensclub.comproj.game.Player;

/**
 * A enum for all possible vehicle to be used by player
 * 
 * @author Athensclub
 *
 */
public enum Vehicle implements Buyable{
    
    FOOT(0),SHOES(100);
    
    private double price;
    
    private Vehicle(double price) {
	this.price = price;
    }
    
    @Override
    public double getPrice() {
	return price;
    }

    @Override
    public void onBought(Player player) {
	//TODO: Add to player
    }

}

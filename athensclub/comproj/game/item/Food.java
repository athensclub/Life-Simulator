package athensclub.comproj.game.item;

import athensclub.comproj.game.Player;

/**
 * Represent type food that player can eat
 * 
 * @author Athensclub
 *
 */
public enum Food implements Buyable{

    TRASH(0,10,5),HOMEMADE(20,15,4),
    RESTAURANT_SMALL(30,20,3),RESTAURANT_MEDUIM(55,40,3),RESTAURANT_LARGE(70,60,3);
    
    private double price;
    
    private double hungerFill,healthLost;
    
    private Food(double price,double hungerFill,double healthLost) {
	this.price = price;
	this.hungerFill = hungerFill;
	this.healthLost = healthLost;
    }

    @Override
    public double getPrice() {
	return price;
    }

    @Override
    public void onBought(Player player) {
	player.addHunger(hungerFill).subtractHealth(healthLost).age().update();
    }
    
}

package athensclub.comproj.game.item;

import athensclub.comproj.game.Player;

/**
 * Represent an action that can increase player's health
 * 
 * @author Athensclub
 *
 */
public enum Heal implements Buyable{

    SLEEP_IN_CARDBOARD_BOX(10,5,0),
    SLEEP_IN_SMALL_HOUSE(15,4,0);
    
    private double healthFill,hungerLost;
    
    private double price;
    
    private Heal(double healthFill,double hungerLost,double price) {
	this.healthFill = healthFill;
	this.hungerLost =  hungerLost;
	this.price = price;
    }
    
    public double getHealthFill() {
	return healthFill;
    }
    
    public double getHungerLost() {
	return hungerLost;
    }

    @Override
    public double getPrice() {
	return price;
    }

    @Override
    public void onBought(Player player) {
	player.addHealth(healthFill).subtractHunger(hungerLost).age().update();
    }
    
}

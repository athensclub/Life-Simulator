package athensclub.comproj.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import athensclub.comproj.Main;
import athensclub.comproj.game.item.Buyable;
import athensclub.comproj.game.item.Job;
import athensclub.comproj.game.item.Shelter;

/**
 * A class that store all information of player
 *
 * @author Athensclub
 */
public class Player implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private double money;

    private boolean dyingFromHealth, dyingFromHunger;

    private int dyingFromHealthCountdown, dyingFromHungerCountdown;

    private Age age = new Age(18);

    private List<Shelter> ownedShelters = new ArrayList<>();
    {
	ownedShelters.add(Shelter.CARDBOARD_BOX);
    }

    /**
     * Note that hunger value means that the more the hunger the less this player is
     * hungry both value has min and max of 0,100 respectively
     */
    private double health = 100, hunger = 100;

    public double getHealth() {
	return health;
    }

    public double getHunger() {
	return hunger;
    }

    public double getMoney() {
	return money;
    }

    public Age getAge() {
	return age;
    }

    /**
     * Attempt to do the given job and if succeed, call that job onWork()
     * 
     * @param job
     */
    public void work(Job job) {
	if (job.canWork(this)) {
	    job.onWork(this);
	}
    }

    /**
     * Attempt to buy given object and if succeed,call that object obBought()
     * method.
     * 
     * @param toBuy
     * @return this
     */
    public Player buy(Buyable toBuy) {
	if (subtractMoney(toBuy.getPrice())) {
	    toBuy.onBought(this);
	}
	return this;
    }

    /**
     * 
     * @param shelter
     * @return this
     */
    public Player addShelter(Shelter shelter) {
	if (!ownedShelters.contains(shelter)) {
	    ownedShelters.add(shelter);
	} else {
	    throw new IllegalArgumentException("Add shelter that is already owned: " + shelter);
	}
	return this;
    }

    /**
     *
     * @param amount
     * @return this
     */
    public Player addHealth(double amount) {
	if (health + amount >= 100) {
	    health = 100;
	} else {
	    health += amount;
	}
	return this;
    }

    /**
     *
     * @param amount
     * @return this
     */
    public Player addHunger(double amount) {
	if (hunger + amount >= 100) {
	    hunger = 100;
	} else {
	    hunger += amount;
	}
	return this;
    }

    /**
     *
     * @param amount
     * @return this
     */
    public Player subtractHealth(double amount) {
	if (health <= amount) {
	    health = 0;
	    if (!dyingFromHealth) {
		dyingFromHealth = true;
		dyingFromHealthCountdown = 3;
		// TODO: DISPLAY WARNING
	    }
	} else {
	    health -= amount;
	}
	return this;
    }

    /**
     *
     * @param amount
     * @return this
     */
    public Player subtractHunger(double amount) {
	if (hunger <= amount) {
	    hunger = 0;
	    if (!dyingFromHunger) {
		dyingFromHunger = true;
		dyingFromHungerCountdown--;
		// TODO: DISPLAY WARNING
	    }
	} else {
	    hunger -= amount;
	}
	return this;
    }

    /**
     * Age the current player
     * 
     * @return this
     */
    public Player age() {
	age.addDays(1);
	if (dyingFromHealth) {
	    if (dyingFromHealthCountdown > 0) {
		dyingFromHealthCountdown--;
	    } else {
		// TODO: GAME OVER
	    }
	}
	if (dyingFromHunger) {
	    if (dyingFromHungerCountdown > 0) {
		dyingFromHungerCountdown--;
	    } else {
		// TODO: GAME OVER
	    }
	}
	return this;
    }

    /**
     * Check if this player own the given shelter
     * 
     * @param shelter
     * @return
     */
    public boolean own(Shelter shelter) {
	return ownedShelters.contains(shelter);
    }

    /**
     *
     * @param amount
     * @return this
     */
    public Player addMoney(double amount) {
	money += amount;
	return this;
    }

    /**
     * Update this player data to all ui components
     */
    public void update() {
	Main.updatePlayerData(this);
    }

    /**
     * Subtract money from this player's money and return true if success otherwise
     * return false(in case of player not having enough money)
     * 
     * @return
     */
    public boolean subtractMoney(double amount) {
	if (money >= amount) {
	    money -= amount;
	    return true;
	}
	return false;
    }

}

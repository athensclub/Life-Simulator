package athensclub.comproj.game.item;

import java.util.function.Predicate;

import athensclub.comproj.game.Player;

/**
 * An action that can give player money
 * 
 * @author Athensclub
 *
 */
public enum Job {

    BEG(10,5,5,p->true);
    
    private double salary;
    
    private double healthLost,hungerLost;

    /**
     * Check if given player can do this job
     */
    private Predicate<Player> canWork;
    
    private Job(double salary,double healthLost,double hungerLost,Predicate<Player> canWork) {
	this.salary = salary;
	this.healthLost = healthLost;
	this.hungerLost = hungerLost;
	this.canWork = canWork;
    }
    
    /**
     * Check if given player can work this job or not
     * @param player
     * @return
     */
    public boolean canWork(Player player) {
	return canWork.test(player);
    }
    
    /**
     * Event that occur when player do this job
     * @param player
     */
    public void onWork(Player player) {
	player.subtractHealth(healthLost).subtractHunger(hungerLost).addMoney(salary).age().update();
    }
    
}


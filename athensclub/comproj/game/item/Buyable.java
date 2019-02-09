package athensclub.comproj.game.item;

import athensclub.comproj.game.Player;

/**
 * Represent item that can be bought from player
 * 
 * @author Athensclub
 *
 */
public interface Buyable {

    public double getPrice();

    /**
     * Event that occur when this item is bought
     *
     */
    public void onBought(Player player);

}

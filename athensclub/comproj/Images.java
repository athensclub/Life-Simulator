package athensclub.comproj;

import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;

/**
 * A class used for accessing and loading images
 *
 * @author Athensclub
 */
public class Images {

    public static Image emptyLot,smallHouse,insideCardboardBox,cityBackground,burger,heart,cardBoardBox,smallHouseDarker,
            cardboardBoxDarker,dollarSign,clock,insideSmallHouse,restaurant,restaurantDarker,
            insideRestaurant;

    /**
     * Get url for that image name.Image must be in images package
     * @param imgName
     * @return
     */
    private static String url(String imgName){
        return "athensclub/comproj/images/" + imgName + ".png";
    }

    /**
     * Load all image from images package
     */
    public static void load(){
        emptyLot = new Image(url("empty_lot"));
        smallHouse = new Image(url("small_house"));
        smallHouseDarker = new Image(url("small_house_darker"));
        cityBackground = new Image(url("city_background"));
        insideCardboardBox = new Image(url("inside_cardboard_box"));
        burger = new Image(url("burger"));
        heart = new Image(url("heart"));
        cardBoardBox = new Image(url("cardboard_box"));
        cardboardBoxDarker = new Image(url("cardboard_box_darker"));
        dollarSign = new Image(url("dollar_sign"));
        clock = new Image(url("clock"));
        insideSmallHouse = new Image(url("inside_small_house"));
        restaurant = new Image(url("restaurant"));
        restaurantDarker = new Image(url("restaurant_darker"));
        insideRestaurant = new Image(url("inside_restaurant"));
    }

}

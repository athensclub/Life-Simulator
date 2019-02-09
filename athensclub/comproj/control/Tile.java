package athensclub.comproj.control;

import athensclub.comproj.game.item.Shelter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A class representing 1 tile or 1 block
 *
 * @author Athensclub
 */
public class Tile {

    private ImageView imageView;

    private Image mouseOver,normal;

    private boolean mouseInside;

    /**
     * Create a tile that represent shelter from given image view
     * @return
     */
    public static Tile shelterTile(ImageView view,Shelter shelter){
        Tile result = new Tile(view);
        result.setImage(shelter.getNormalImage());
        result.setMouseOverImage(shelter.getMouseOverImage());
        return result;
    }

    /**
     * Create tile object from given image view
     */
    public Tile(ImageView view){
        imageView = view;
        imageView.setOnMouseEntered(e->{
            mouseInside = true;
            imageView.setImage(mouseOver);
        });
        imageView.setOnMouseExited(e->{
            mouseInside = false;
            if(mouseOver != null) {
                imageView.setImage(normal);
            }
        });
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImage(Image image){
        normal = image;
        if(!mouseInside){
            imageView.setImage(normal);
        }
    }

    /**
     * Set the image to be displayed if mouse is over this tile
     * @param image
     */
    public void setMouseOverImage(Image image){
        mouseOver = image;
        if(mouseInside){
            imageView.setImage(mouseOver);
        }
    }

}

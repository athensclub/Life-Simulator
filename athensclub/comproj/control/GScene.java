package athensclub.comproj.control;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * A Scene object that hold controller of its root
 */
public class GScene extends Scene {

    private Object controller;

    public GScene(Parent parent,Object controller) {
        super(parent,640,640);
        this.controller = controller;
    }

    /**
     * Get controller object controlling root pane of this scene
     * @return
     */
    public Object getController(){
        return controller;
    }

}

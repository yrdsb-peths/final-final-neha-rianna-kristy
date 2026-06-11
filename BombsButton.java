import greenfoot.*;
/**
 * A button that starts the Bombs game mode.
 * When clicked, the player is taken to the BombGrid world.
 * 
 * @author Kristy
 * @version June 2026
 */
public class BombsButton extends Button
{
    private String text = "Bombs";
    
    /**
     * Creates a BombsButton and displays its text.
     */
    public BombsButton()
    {
        updateImage();
    }

    /**
     * Checks for mouse clicks and starts the Bombs game mode.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new BombGrid());
        }
    }

    /**
     * Creates and displays the button image.
     */
    private void updateImage()
    {
        GreenfootImage textImg = new GreenfootImage(text, 60, Color.BLACK, new Color(0,0,0,0));
        textImg.setFont(new Font("Monospaced", true, false, 30));

        setImage(textImg);
    }
}
